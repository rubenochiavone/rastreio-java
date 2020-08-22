package rastreio;

import java.io.IOException;

/**
 * Get tracking object data by scrapping Correios' HTML server response.
 * 
 * Example of tracking an object in another thread:
 * 
 * <pre>
 *   Rastreio.track("JT124720455BR", new Rastreio.Listener() {
 *     public void onSuccess(TrackObject trackObject) {
 *       // Use this tracking object
 *     }
 *   
 *     public void onFailure(Exception e) {
 *       // Report exception
 *       e.printStackTrace();
 *     }
 *   });
 * </pre>
 * 
 * See {@link Rastreio#track(String, Listener)} for more information.
 * 
 * Also it is possible to wait until operation is completed in the same thread:
 * 
 * <pre>
 *   try {
 *     TrackObject trackObject = Rastreio.trackSync("JT124720455BR");
 *     // Use this tracking object
 *   } catch (IOException e) {
 *     // Report exception
 *     e.printStackTrace();
 *   }
 * </pre>
 * 
 * See {@link Rastreio#trackSync(String)} for more information.
 * 
 * @see Listener
 * @see TrackObject
 */
public class Rastreio {
  private static Implementation IMPL = new DefaultImplementation();

  private Rastreio() {}

  /**
   * Track an object by its code asynchronously.
   * 
   * When track operation finishes listener is called with result.
   * 
   * @param objectCode string representing object track code
   * @param listener listener to be called when object tracking is completed
   * @throws NullPointerException if {@code objectCode} or {@code listener} is null
   * @throws IllegalArgumentException if {@code objectCode} is empty or invalid
   * @see Listener
   * @see TrackObject
   */
  public static void track(String objectCode, Listener listener) {
    if (objectCode == null || listener == null) {
      throw new NullPointerException("Rastreio.track: null listener or object code");
    }
    // Validate object code
    if (objectCode.isEmpty() || !TrackObject.Code.validate(objectCode)) {
      throw new IllegalArgumentException("Rastreio.track: invalid object code");
    }
    IMPL.track(objectCode, listener);
  }

  /**
   * Track an object by its code synchronously.
   * 
   * @param objectCode string representing object track code
   * @throws IOException if an network error occur
   * @throws NullPointerException if {@code objectCode} is null
   * @throws IllegalArgumentException if {@code objectCode} is empty or invalid
   * @return new tracking object to query tracking data
   */
  public static TrackObject trackSync(String objectCode) throws IOException {
    if (objectCode == null) {
      throw new NullPointerException("Rastreio.trackSync: null object code");
    }
    // Validate object code
    if (objectCode.isEmpty() || !TrackObject.Code.validate(objectCode)) {
      throw new IllegalArgumentException("Rastreio.trackSync: invalid object code");
    }
    return IMPL.trackSync(objectCode);
  }

  /**
   * Change underlying implementation.
   * 
   * @param implementation rastreio implementation to be used
   * @throws NullPointerException if {@code implementation} is null
   * @see Implementation, DefaultImplementation, EnhancedImplementation
   */
  public static void setImplementation(Implementation implementation) {
    if (implementation == null) {
      throw new NullPointerException("Rastreio.setImplementation: null implementation");
    }
    IMPL = implementation;
  }

  /**
   * Listener interface for asynchronously object tracking.
   */
  public static interface Listener {
    /**
     * Called when object tracking is completed with success.
     * @param trackObject tracking object result
     */
    void onSuccess(TrackObject trackObject);

    /**
     * Called when object tracking fails.
     * @param exception failure explanation
     */
    void onFailure(Exception exception);
  }
}
