package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class NotFilter
  implements SafeParcelable, Filter
{
  public static final Parcelable.Creator<NotFilter> CREATOR = new j();
  final FilterHolder KW;
  final int xJ;
  
  NotFilter(int paramInt, FilterHolder paramFilterHolder)
  {
    this.xJ = paramInt;
    this.KW = paramFilterHolder;
  }
  
  public NotFilter(Filter paramFilter)
  {
    this(1, new FilterHolder(paramFilter));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.NotFilter
 * JD-Core Version:    0.7.0.1
 */