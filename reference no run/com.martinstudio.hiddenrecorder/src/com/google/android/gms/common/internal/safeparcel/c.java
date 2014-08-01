package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public final class c
{
  public static <T extends SafeParcelable> byte[] a(T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    return arrayOfByte;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.c
 * JD-Core Version:    0.7.0.1
 */