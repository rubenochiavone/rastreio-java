package rastreio;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Shipment tracking object.
 */
public class TrackObject {
  /**
   * Tracking object code.
   */
  private String mCode;
  /**
   * Tracking object service type.
   */
  private TrackObjectServiceType mServiceType;
  /**
   * Whether this tracking object is valid.
   */
  private boolean mIsValid;
  /**
   * Whether this tracking object was delivered.
   */
  private boolean mIsDelivered;
  /**
   * Date this tracking object was posted.
   */
  private Date mPostedAt;
  /**
   * Last time this tracking object was updated.
   */
  private Date mUpdatedAt;
  /**
   * List of events that occurred to this tracking object.
   */
  private ArrayList<Event> mEvents;
  /**
   * Error code.
   */
  private Error mError;

  protected TrackObject() {}

  /**
   * Get tracking object code.
   * @return tracking object code
   */
  public String getCode() {
    return mCode;
  }

  /**
   * Set tracking object code.
   * @param code new tracking object code
   */
  public void setCode(String code) {
    mCode = code;
  }

  /**
   * Get tracking object service type.
   * @return tracking object service type
   */
  public TrackObjectServiceType getServiceType() {
    return mServiceType;
  }

  /**
   * Set tracking object service type.
   * @param serviceType tracking object service type
   */
  public void setServiceType(TrackObjectServiceType serviceType) {
    mServiceType = serviceType;
  }

  /**
   * Check whether this tracking object is valid.
   * @return whether this tracking object is valid
   */
  public boolean isValid() {
    return mIsValid;
  }

  /**
   * Set whether this tracking object is valid.
   * @param valid whether this tracking object is valid
   */
  public void setValid(boolean valid) {
    mIsValid = valid;
  }

  /**
   * Check whether this object was delivered.
   * @return whether this object was delivered
   */
  public boolean isDelivered() {
    return mIsDelivered;
  }

  /**
   * Set whether this object was delivered.
   * @param delivered whether this object was delivered
   */
  public void setDelivered(boolean delivered) {
    mIsDelivered = delivered;
  }

  /**
   * Get when this tracking object was posted.
   * @return when this tracking object was posted
   */
  public Date getPostedAt() {
    return mPostedAt;
  }

  /**
   * Set when this tracking object was posted.
   * @param postedAt posted date
   */
  public void setPostedAt(Date postedAt) {
    mPostedAt = postedAt;
  }

  /**
   * Get when this tracking object was updated for the last time.
   * @return when this tracking object was updated for the last time
   */
  public Date getUpdatedAt() {
    return mUpdatedAt;
  }

  /**
   * Set when this tracking object was updated for the last time.
   * @param updatedAt last time this tracking object was updated
   */
  public void setUpdatedAt(Date updatedAt) {
    mUpdatedAt = updatedAt;
  }

  /**
   * Get list of events that occurred to this tracking object.
   * @return list of events that occurred to this tracking object
   */
  public ArrayList<Event> getEvents() {
    return mEvents;
  }

  /**
   * Set list of events that occurred to this tracking object.
   * @param events list of events that occurred to this tracking object
   */
  public void setEvents(ArrayList<Event> events) {
    mEvents = events;
  }

  /**
   * Get error code.
   * @return error code
   * @see Error
   */
  public Error getError() {
    return mError;
  }

  /**
   * Set error code.
   * @param error error code
   * @see Error
   */
  public void setError(Error error) {
    mError = error;
  }

  /**
   * Tracking object code validator class.
   */
  public static class Code {
    private static final Pattern OBJECT_CODE_PATTERN = Pattern.compile("[A-Z]{2}[0-9]{9}[A-Z]{2}");

    private Code() {}

    /**
     * Validates object code format.
     * 
     * @param objectCode tracking object code
     * @return {@code true} if object code is valid and {@code false} otherwise
     * @see <a href="https://www.correios.com.br/enviar-e-receber/precisa-de-ajuda/como-rastrear-um-objeto"></a>
     */
    public static boolean validate(String objectCode) {
      if (objectCode == null || objectCode.isEmpty()) {
        return false;
      }
      return OBJECT_CODE_PATTERN.matcher(objectCode).matches();
    }
  }

  /**
   * Tracking object event.
   * 
   * <p>It represents any event that happened with a tracking object.</p>
   * 
   * @see TrackObject
   */
  public static class Event {
    /**
     * Locale of this event.
     */
    private String mLocale;
    /**
     * Event description.
     */
    private String mDescription;
    /**
     * Event description details.
     */
    private String mDetails;
    /**
     * Time when this event happened.
     */
    private Date mTrackedAt;

    protected Event() {}

    /**
     * Get locale of this event.
     * @return locale of this event
     */
    public String getLocale() {
      return mLocale;
    }
  
    /**
     * Set locale of this event.
     * @param locale locale of this event
     */
    public void setLocale(String locale) {
      mLocale = locale;
    }

    /**
     * Get event description.
     * @return event description
     */
    public String getDescription() {
      return mDescription;
    }

    /**
     * Set event description.
     * @param description event description
     */
    public void setDescription(String description) {
      mDescription = description;
    }

    /**
     * Get event details.
     * @return event details
     */
    public String getDetails() {
      return mDetails;
    }

    /**
     * Set event details.
     * @param details event details
     */
    public void setDetails(String details) {
      mDetails = details;
    }

    /**
     * Get time when this event happened.
     * @return time when this event happened
     */
    public Date getTrackedAt() {
      return mTrackedAt;
    }

    /**
     * Set time when this event happened.
     * @param trackedAt time when this event happened
     */
    public void setTrackedAt(Date trackedAt) {
      mTrackedAt = trackedAt;
    }
  }
}
