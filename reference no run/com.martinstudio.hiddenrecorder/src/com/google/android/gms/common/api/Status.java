package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class Status
  implements Result, SafeParcelable
{
  public static final StatusCreator CREATOR = new StatusCreator();
  public static final Status Ek = new Status(0);
  public static final Status El = new Status(14);
  public static final Status Em = new Status(8);
  public static final Status En = new Status(15);
  public static final Status Eo = new Status(16);
  private final int CQ;
  private final String Ep;
  private final PendingIntent mPendingIntent;
  private final int xJ;
  
  public Status(int paramInt)
  {
    this(1, paramInt, null, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.xJ = paramInt1;
    this.CQ = paramInt2;
    this.Ep = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String es()
  {
    String str;
    if (this.Ep == null) {
      str = CommonStatusCodes.getStatusCodeString(this.CQ);
    } else {
      str = this.Ep;
    }
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  PendingIntent eL()
  {
    return this.mPendingIntent;
  }
  
  @Deprecated
  public ConnectionResult eM()
  {
    return new ConnectionResult(this.CQ, this.mPendingIntent);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof Status))
    {
      Status localStatus = (Status)paramObject;
      if ((this.xJ == localStatus.xJ) && (this.CQ == localStatus.CQ) && (hl.equal(this.Ep, localStatus.Ep)) && (hl.equal(this.mPendingIntent, localStatus.mPendingIntent))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.CQ;
  }
  
  public String getStatusMessage()
  {
    return this.Ep;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean hasResolution()
  {
    boolean bool;
    if (this.mPendingIntent == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.xJ);
    arrayOfObject[1] = Integer.valueOf(this.CQ);
    arrayOfObject[2] = this.Ep;
    arrayOfObject[3] = this.mPendingIntent;
    return hl.hashCode(arrayOfObject);
  }
  
  public boolean isCanceled()
  {
    boolean bool;
    if (this.CQ != 16) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isInterrupted()
  {
    boolean bool;
    if (this.CQ != 14) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isSuccess()
  {
    boolean bool;
    if (this.CQ > 0) {
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StatusCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.7.0.1
 */