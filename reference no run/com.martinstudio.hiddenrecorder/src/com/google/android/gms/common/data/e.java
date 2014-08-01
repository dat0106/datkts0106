package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class e<T extends SafeParcelable>
  extends DataBuffer<T>
{
  private static final String[] EB;
  private final Parcelable.Creator<T> EC;
  
  static
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "data";
    EB = arrayOfString;
  }
  
  public e(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.EC = paramCreator;
  }
  
  public T ad(int paramInt)
  {
    Object localObject = this.DD.f("data", paramInt, 0);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)this.EC.createFromParcel(localParcel);
    localParcel.recycle();
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.e
 * JD-Core Version:    0.7.0.1
 */