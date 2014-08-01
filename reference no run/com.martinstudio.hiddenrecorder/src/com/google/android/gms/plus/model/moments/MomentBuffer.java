package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ks;

public final class MomentBuffer
  extends DataBuffer<Moment>
{
  public MomentBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public Moment get(int paramInt)
  {
    return new ks(this.DD, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.model.moments.MomentBuffer
 * JD-Core Version:    0.7.0.1
 */