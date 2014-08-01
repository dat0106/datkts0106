package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.query.Query;

public abstract interface DriveApi
{
  public abstract PendingResult<Status> discardContents(GoogleApiClient paramGoogleApiClient, Contents paramContents);
  
  public abstract PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract DriveFolder getAppFolder(GoogleApiClient paramGoogleApiClient);
  
  public abstract DriveFile getFile(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId);
  
  public abstract DriveFolder getFolder(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId);
  
  public abstract DriveFolder getRootFolder(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<ContentsResult> newContents(GoogleApiClient paramGoogleApiClient);
  
  public abstract CreateFileActivityBuilder newCreateFileActivityBuilder();
  
  public abstract OpenFileActivityBuilder newOpenFileActivityBuilder();
  
  public abstract PendingResult<MetadataBufferResult> query(GoogleApiClient paramGoogleApiClient, Query paramQuery);
  
  public abstract PendingResult<Status> requestSync(GoogleApiClient paramGoogleApiClient);
  
  public static abstract interface DriveIdResult
    extends Result
  {
    public abstract DriveId getDriveId();
  }
  
  public static abstract interface ContentsResult
    extends Result
  {
    public abstract Contents getContents();
  }
  
  public static abstract interface MetadataBufferResult
    extends Result
  {
    public abstract MetadataBuffer getMetadataBuffer();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveApi
 * JD-Core Version:    0.7.0.1
 */