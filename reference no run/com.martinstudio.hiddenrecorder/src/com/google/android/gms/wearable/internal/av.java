package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;

public class av
  extends ac.a
{
  private final DataApi.DataListener ami;
  private final MessageApi.MessageListener amj;
  private final NodeApi.NodeListener amk;
  private final IntentFilter[] aml;
  
  public av(DataApi.DataListener paramDataListener, MessageApi.MessageListener paramMessageListener, NodeApi.NodeListener paramNodeListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.ami = paramDataListener;
    this.amj = paramMessageListener;
    this.amk = paramNodeListener;
    this.aml = paramArrayOfIntentFilter;
  }
  
  public static av a(DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new av(paramDataListener, null, null, paramArrayOfIntentFilter);
  }
  
  public static av a(MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new av(null, paramMessageListener, null, paramArrayOfIntentFilter);
  }
  
  public static av a(NodeApi.NodeListener paramNodeListener)
  {
    return new av(null, null, paramNodeListener, null);
  }
  
  public void Y(DataHolder paramDataHolder)
  {
    if (this.ami != null) {}
    for (;;)
    {
      try
      {
        this.ami.onDataChanged(new DataEventBuffer(paramDataHolder));
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
      paramDataHolder.close();
    }
  }
  
  public void a(af paramaf)
  {
    if (this.amj != null) {
      this.amj.onMessageReceived(paramaf);
    }
  }
  
  public void a(ai paramai)
  {
    if (this.amk != null) {
      this.amk.onPeerConnected(paramai);
    }
  }
  
  public void b(ai paramai)
  {
    if (this.amk != null) {
      this.amk.onPeerDisconnected(paramai);
    }
  }
  
  public IntentFilter[] np()
  {
    return this.aml;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.av
 * JD-Core Version:    0.7.0.1
 */