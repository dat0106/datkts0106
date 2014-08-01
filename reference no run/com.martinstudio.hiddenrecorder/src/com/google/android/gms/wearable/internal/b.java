package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class b
  implements SafeParcelable
{
  public static final Parcelable.Creator<b> CREATOR = new c();
  public final ac alw;
  public final IntentFilter[] alx;
  final int xJ;
  
  b(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.xJ = paramInt;
    if (paramIBinder == null) {
      this.alw = null;
    } else {
      this.alw = ac.a.bx(paramIBinder);
    }
    this.alx = paramArrayOfIntentFilter;
  }
  
  public b(av paramav)
  {
    this.xJ = 1;
    this.alw = paramav;
    this.alx = paramav.np();
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
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.b
 * JD-Core Version:    0.7.0.1
 */