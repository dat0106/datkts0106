package com.google.android.gms.panorama;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract interface PanoramaApi
{
  public abstract PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public abstract PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, Uri paramUri);
  
  public static abstract interface PanoramaResult
    extends Result
  {
    public abstract Intent getViewerIntent();
  }
  
  public static abstract interface a
    extends PanoramaApi.PanoramaResult
  {}
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.panorama.PanoramaApi
 * JD-Core Version:    0.7.0.1
 */