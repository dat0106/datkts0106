package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.internal.hn;

public class h
{
  private String HV;
  private DriveId HX;
  protected MetadataChangeSet Ix;
  private Integer Iy;
  private final int Iz;
  
  public h(int paramInt)
  {
    this.Iz = paramInt;
  }
  
  public void a(DriveId paramDriveId)
  {
    this.HX = ((DriveId)hn.f(paramDriveId));
  }
  
  public void a(MetadataChangeSet paramMetadataChangeSet)
  {
    this.Ix = ((MetadataChangeSet)hn.f(paramMetadataChangeSet));
  }
  
  public void aM(String paramString)
  {
    this.HV = ((String)hn.f(paramString));
  }
  
  public void aS(int paramInt)
  {
    this.Iy = Integer.valueOf(paramInt);
  }
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    hn.b(this.Ix, "Must provide initial metadata to CreateFileActivityBuilder.");
    hn.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    aa localaa = ((r)paramGoogleApiClient.a(Drive.yE)).gk();
    if (this.Iy == null) {}
    for (int i = -1;; j = this.Iy.intValue()) {
      try
      {
        IntentSender localIntentSender = localaa.a(new CreateFileIntentSenderRequest(this.Ix.gh(), i, this.HV, this.HX, this.Iz));
        return localIntentSender;
      }
      catch (RemoteException localRemoteException)
      {
        int j;
        throw new RuntimeException("Unable to connect Drive Play Service", localRemoteException);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.h
 * JD-Core Version:    0.7.0.1
 */