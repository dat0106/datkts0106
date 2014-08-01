package com.google.android.gms.internal;

import java.util.Arrays;

public final class mh
{
  final byte[] amZ;
  final int tag;
  
  mh(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.amZ = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject != this) {
      if ((paramObject instanceof mh))
      {
        mh localmh = (mh)paramObject;
        if ((this.tag != localmh.tag) || (!Arrays.equals(this.amZ, localmh.amZ))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  public int hashCode()
  {
    return 31 * (527 + this.tag) + Arrays.hashCode(this.amZ);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mh
 * JD-Core Version:    0.7.0.1
 */