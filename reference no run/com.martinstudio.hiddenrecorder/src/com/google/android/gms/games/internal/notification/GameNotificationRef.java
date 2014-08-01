package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class GameNotificationRef
  extends d
  implements GameNotification
{
  GameNotificationRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public long getId()
  {
    return getLong("_id");
  }
  
  public String getText()
  {
    return getString("text");
  }
  
  public String getTitle()
  {
    return getString("title");
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public String jdMethod_if()
  {
    return getString("notification_id");
  }
  
  public String ig()
  {
    return getString("ticker");
  }
  
  public String ih()
  {
    return getString("coalesced_text");
  }
  
  public boolean ii()
  {
    boolean bool;
    if (getInteger("acknowledged") <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean ij()
  {
    boolean bool;
    if (getInteger("alert_level") != 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return hl.e(this).a("Id", Long.valueOf(getId())).a("NotificationId", jdMethod_if()).a("Type", Integer.valueOf(getType())).a("Title", getTitle()).a("Ticker", ig()).a("Text", getText()).a("CoalescedText", ih()).a("isAcknowledged", Boolean.valueOf(ii())).a("isSilent", Boolean.valueOf(ij())).toString();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.notification.GameNotificationRef
 * JD-Core Version:    0.7.0.1
 */