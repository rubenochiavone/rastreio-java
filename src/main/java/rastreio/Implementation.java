package rastreio;

/**
 * Rastreio implementation interface.
 */
public interface Implementation {
  /**
   * Track an object by its code asynchronously.
   * 
   * When track operation finishes listener is called with result.
   * 
   * @param objectCode string representing object track code
   * @param listener listener to be called when object tracking is completed
   * @see Listener
   * @see TrackObject
   */
  void track(String objectCode, Rastreio.Listener listener);

  /**
   * Track an object by its code synchronously.
   * 
   * @param objectCode string representing object track code
   * @throws IOException if a network error occur
   * @return new tracking object to query tracking data
   */
  TrackObject trackSync(String objectCode) throws java.io.IOException;
}
