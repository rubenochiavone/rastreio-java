package rastreio;

import java.util.ArrayList;
import java.util.Date;

public class TrackObject {
  private String mCode;
  private boolean mIsValid;
  private boolean mIsDelivered;
  private Date mPostedAt;
  private Date mUpdatedAt;
  private ArrayList<Event> mEvents;
  private Error mError;

  public String getCode() {
    return mCode;
  }

  public void setCode(String code) {
    mCode = code;
  }

  public boolean IsValid() {
    return mIsValid;
  }

  public void setValid(boolean valid) {
    mIsValid = valid;
  }

  public boolean IsDelivered() {
    return mIsDelivered;
  }

  public void setDelivered(boolean delivered) {
    mIsDelivered = delivered;
  }

  public Date getPostedAt() {
    return mPostedAt;
  }

  public void setPostedAt(Date postedAt) {
    mPostedAt = postedAt;
  }

  public Date getUpdatedAt() {
    return mUpdatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    mUpdatedAt = updatedAt;
  }

  public ArrayList<Event> getEvents() {
    return mEvents;
  }

  public void setEvents(ArrayList<Event> events) {
    mEvents = events;
  }

  public Error getError() {
    return mError;
  }

  public void setError(Error error) {
    mError = error;
  }

  public static class Event {
    private String mLocale;
    private String mDescription;
    private String mDetails;
    private Date mTrackedAt;

    public String getLocale() {
      return mLocale;
    }
  
    public void setLocale(String locale) {
      mLocale = locale;
    }

    public String getDescription() {
      return mDescription;
    }
  
    public void setDescription(String description) {
      mDescription = description;
    }

    public String getDetails() {
      return mDetails;
    }
  
    public void setDetails(String details) {
      mDetails = details;
    }

    public Date getTrackedAt() {
      return mTrackedAt;
    }
  
    public void setTrackedAt(Date trackedAt) {
      mTrackedAt = trackedAt;
    }
  }
}
