package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;

public abstract interface DriveResource
{
  public abstract PendingResult<Status> addChangeListener(GoogleApiClient paramGoogleApiClient, DriveEvent.Listener<ChangeEvent> paramListener);
  
  public abstract DriveId getDriveId();
  
  public abstract PendingResult<MetadataResult> getMetadata(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> removeChangeListener(GoogleApiClient paramGoogleApiClient, DriveEvent.Listener<ChangeEvent> paramListener);
  
  public abstract PendingResult<MetadataResult> updateMetadata(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet);
  
  public static abstract interface MetadataResult
    extends Result
  {
    public abstract Metadata getMetadata();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveResource
 * JD-Core Version:    0.7.0.1
 */