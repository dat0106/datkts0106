package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class HasFilter<T>
  implements SafeParcelable, Filter
{
  public static final f CREATOR = new f();
  final MetadataBundle KJ;
  final MetadataField<T> KK;
  final int xJ;
  
  HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.xJ = paramInt;
    this.KJ = paramMetadataBundle;
    this.KK = e.b(paramMetadataBundle);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.HasFilter
 * JD-Core Version:    0.7.0.1
 */