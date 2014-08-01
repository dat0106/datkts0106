package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ao
  implements SafeParcelable
{
  public static final Parcelable.Creator<ao> CREATOR = new ap();
  public final ac alw;
  final int xJ;
  
  ao(int paramInt, IBinder paramIBinder)
  {
    this.xJ = paramInt;
    if (paramIBinder == null) {
      this.alw = null;
    } else {
      this.alw = ac.a.bx(paramIBinder);
    }
  }
  
  public ao(ac paramac)
  {
    this.xJ = 1;
    this.alw = paramac;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  IBinder nj()
  {
    IBinder localIBinder;
    if (this.alw != null) {
      localIBinder = this.alw.asBinder();
    } else {
      localIBinder = null;
    }
    return localIBinder;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ap.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ao
 * JD-Core Version:    0.7.0.1
 */