package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class ConnectionResult
{
  public static final int API_UNAVAILABLE = 16;
  public static final int CANCELED = 13;
  public static final ConnectionResult CP = new ConnectionResult(0, null);
  public static final int DATE_INVALID = 12;
  public static final int DEVELOPER_ERROR = 10;
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 15;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 14;
  private final int CQ;
  private final PendingIntent mPendingIntent;
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this.CQ = paramInt;
    this.mPendingIntent = paramPendingIntent;
  }
  
  private String es()
  {
    String str;
    switch (this.CQ)
    {
    case 12: 
    default: 
      str = "unknown status code " + this.CQ;
      break;
    case 0: 
      str = "SUCCESS";
      break;
    case 1: 
      str = "SERVICE_MISSING";
      break;
    case 2: 
      str = "SERVICE_VERSION_UPDATE_REQUIRED";
      break;
    case 3: 
      str = "SERVICE_DISABLED";
      break;
    case 4: 
      str = "SIGN_IN_REQUIRED";
      break;
    case 5: 
      str = "INVALID_ACCOUNT";
      break;
    case 6: 
      str = "RESOLUTION_REQUIRED";
      break;
    case 7: 
      str = "NETWORK_ERROR";
      break;
    case 8: 
      str = "INTERNAL_ERROR";
      break;
    case 9: 
      str = "SERVICE_INVALID";
      break;
    case 10: 
      str = "DEVELOPER_ERROR";
      break;
    case 11: 
      str = "LICENSE_CHECK_FAILED";
      break;
    case 13: 
      str = "CANCELED";
      break;
    case 14: 
      str = "TIMEOUT";
      break;
    case 15: 
      str = "INTERRUPTED";
    }
    return str;
  }
  
  public int getErrorCode()
  {
    return this.CQ;
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public boolean hasResolution()
  {
    boolean bool;
    if ((this.CQ == 0) || (this.mPendingIntent == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isSuccess()
  {
    boolean bool;
    if (this.CQ != 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (hasResolution()) {
      paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
    }
  }
  
  public String toString()
  {
    return hl.e(this).a("statusCode", es()).a("resolution", this.mPendingIntent).toString();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.ConnectionResult
 * JD-Core Version:    0.7.0.1
 */