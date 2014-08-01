package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class SnapshotMetadataBuffer
  extends DataBuffer<SnapshotMetadata>
{
  public SnapshotMetadataBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public SnapshotMetadata get(int paramInt)
  {
    return new SnapshotMetadataRef(this.DD, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataBuffer
 * JD-Core Version:    0.7.0.1
 */