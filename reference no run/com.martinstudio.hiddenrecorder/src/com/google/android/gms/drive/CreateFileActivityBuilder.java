package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.internal.hn;
import java.io.IOException;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private final h HC = new h(0);
  private Contents HD;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    hn.b(this.HD, "Must provide initial contents to CreateFileActivityBuilder.");
    try
    {
      this.HD.getParcelFileDescriptor().close();
      label20:
      this.HD.close();
      return this.HC.build(paramGoogleApiClient);
    }
    catch (IOException localIOException)
    {
      break label20;
    }
  }
  
  public CreateFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.HC.a(paramDriveId);
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.HC.aM(paramString);
    return this;
  }
  
  public CreateFileActivityBuilder setInitialContents(Contents paramContents)
  {
    this.HD = ((Contents)hn.f(paramContents));
    this.HC.aS(this.HD.getRequestId());
    return this;
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.HC.a(paramMetadataChangeSet);
    return this;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.CreateFileActivityBuilder
 * JD-Core Version:    0.7.0.1
 */