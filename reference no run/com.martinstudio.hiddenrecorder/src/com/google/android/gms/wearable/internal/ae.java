package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ae
  implements MessageApi
{
  private PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final MessageApi.MessageListener paramMessageListener, final IntentFilter[] paramArrayOfIntentFilter)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramMessageListener, paramArrayOfIntentFilter);
      }
      
      public Status d(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
    });
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    return a(paramGoogleApiClient, paramMessageListener, null);
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final MessageApi.MessageListener paramMessageListener)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramMessageListener);
      }
      
      public Status d(Status paramAnonymousStatus)
      {
        return new Status(13);
      }
    });
  }
  
  public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    paramGoogleApiClient.a(new d()
    {
      protected void a(au paramAnonymousau)
        throws RemoteException
      {
        paramAnonymousau.a(this, paramString1, paramString2, paramArrayOfByte);
      }
      
      protected MessageApi.SendMessageResult au(Status paramAnonymousStatus)
      {
        return new ae.a(paramAnonymousStatus, -1);
      }
    });
  }
  
  public static class a
    implements MessageApi.SendMessageResult
  {
    private final int qX;
    private final Status yw;
    
    public a(Status paramStatus, int paramInt)
    {
      this.yw = paramStatus;
      this.qX = paramInt;
    }
    
    public int getRequestId()
    {
      return this.qX;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ae
 * JD-Core Version:    0.7.0.1
 */