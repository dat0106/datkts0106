package com.google.android.gms.wearable;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public abstract interface NodeApi
{
  public abstract PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, NodeListener paramNodeListener);
  
  public abstract PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, NodeListener paramNodeListener);
  
  public static abstract interface NodeListener
  {
    public abstract void onPeerConnected(Node paramNode);
    
    public abstract void onPeerDisconnected(Node paramNode);
  }
  
  public static abstract interface GetConnectedNodesResult
    extends Result
  {
    public abstract List<Node> getNodes();
  }
  
  public static abstract interface GetLocalNodeResult
    extends Result
  {
    public abstract Node getNode();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.NodeApi
 * JD-Core Version:    0.7.0.1
 */