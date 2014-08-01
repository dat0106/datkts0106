package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import java.util.Collections;

public class InFilter<T>
  implements SafeParcelable, Filter
{
  public static final g CREATOR = new g();
  final MetadataBundle KJ;
  private final b<T> KU;
  final int xJ;
  
  InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.xJ = paramInt;
    this.KJ = paramMetadataBundle;
    this.KU = ((b)e.b(paramMetadataBundle));
  }
  
  public InFilter(SearchableCollectionMetadataField<T> paramSearchableCollectionMetadataField, T paramT)
  {
    this(1, MetadataBundle.a(paramSearchableCollectionMetadataField, Collections.singleton(paramT)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.InFilter
 * JD-Core Version:    0.7.0.1
 */