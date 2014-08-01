package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.BitSet;

public class fh
  implements SafeParcelable
{
  public static final fi CREATOR = new fi();
  final int xJ;
  final fl[] xK;
  public final String xL;
  public final boolean xM;
  
  fh(int paramInt, fl[] paramArrayOffl, String paramString, boolean paramBoolean)
  {
    this.xJ = paramInt;
    this.xK = paramArrayOffl;
    this.xL = paramString;
    this.xM = paramBoolean;
  }
  
  public fh(String paramString, boolean paramBoolean, fl... paramVarArgs)
  {
    this(1, paramVarArgs, paramString, paramBoolean);
    BitSet localBitSet = new BitSet(fp.dK());
    int j;
    for (int i = 0;; i++)
    {
      if (i >= paramVarArgs.length) {
        return;
      }
      j = paramVarArgs[i].xT;
      if (j != -1)
      {
        if (localBitSet.get(j)) {
          break;
        }
        localBitSet.set(j);
      }
    }
    throw new IllegalArgumentException("Duplicate global search section type " + fp.H(j));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    fi.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fh
 * JD-Core Version:    0.7.0.1
 */