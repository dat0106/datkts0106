package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.aa;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.hn;

public class OpenFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private String HV;
  private String[] HW;
  private DriveId HX;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    hn.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    if (this.HW == null) {
      this.HW = new String[0];
    }
    Object localObject = ((r)paramGoogleApiClient.a(Drive.yE)).gk();
    try
    {
      localObject = ((aa)localObject).a(new OpenFileIntentSenderRequest(this.HV, this.HW, this.HX));
      return localObject;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException("Unable to connect Drive Play Service", localRemoteException);
    }
  }
  
  public OpenFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.HX = ((DriveId)hn.f(paramDriveId));
    return this;
  }
  
  public OpenFileActivityBuilder setActivityTitle(String paramString)
  {
    this.HV = ((String)hn.f(paramString));
    return this;
  }
  
  public OpenFileActivityBuilder setMimeType(String[] paramArrayOfString)
  {
    boolean bool;
    if (paramArrayOfString == null) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "mimeTypes may not be null");
    this.HW = paramArrayOfString;
    return this;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.OpenFileActivityBuilder
 * JD-Core Version:    0.7.0.1
 */