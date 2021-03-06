package rastreio;

/**
 * Rastreio implementation interface.
 */
public interface Implementation {
  /**
   * Track an object by its code asynchronously.
   * 
   * <p>When track operation finishes listener is called with result.</p>
   * 
   * @param objectCode string representing object track code
   * @param listener listener to be called when object tracking is completed
   * @see Rastreio.Listener
   */
  void track(String objectCode, Rastreio.Listener listener);

  /**
   * Track an object by its code synchronously.
   * 
   * @param objectCode string representing object track code
   * @return new tracking object to query tracking data
   * @throws java.io.IOException if a network error occur
   * @see TrackObject
   */
  TrackObject trackSync(String objectCode) throws java.io.IOException;
}
