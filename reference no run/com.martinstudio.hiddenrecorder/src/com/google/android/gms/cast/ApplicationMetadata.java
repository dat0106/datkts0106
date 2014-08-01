package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new a();
  String mName;
  private final int xJ;
  String zM;
  List<WebImage> zN;
  List<String> zO;
  String zP;
  Uri zQ;
  
  private ApplicationMetadata()
  {
    this.xJ = 1;
    this.zN = new ArrayList();
    this.zO = new ArrayList();
  }
  
  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List<WebImage> paramList, List<String> paramList1, String paramString3, Uri paramUri)
  {
    this.xJ = paramInt;
    this.zM = paramString1;
    this.mName = paramString2;
    this.zN = paramList;
    this.zO = paramList1;
    this.zP = paramString3;
    this.zQ = paramUri;
  }
  
  public boolean areNamespacesSupported(List<String> paramList)
  {
    boolean bool;
    if ((this.zO == null) || (!this.zO.containsAll(paramList))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public Uri dS()
  {
    return this.zQ;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject != this) {
      if ((paramObject instanceof ApplicationMetadata))
      {
        ApplicationMetadata localApplicationMetadata = (ApplicationMetadata)paramObject;
        if ((!gj.a(this.zM, localApplicationMetadata.zM)) || (!gj.a(this.zN, localApplicationMetadata.zN)) || (!gj.a(this.mName, localApplicationMetadata.mName)) || (!gj.a(this.zO, localApplicationMetadata.zO)) || (!gj.a(this.zP, localApplicationMetadata.zP)) || (!gj.a(this.zQ, localApplicationMetadata.zQ))) {
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
  
  public String getApplicationId()
  {
    return this.zM;
  }
  
  public List<WebImage> getImages()
  {
    return this.zN;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSenderAppIdentifier()
  {
    return this.zP;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.xJ);
    arrayOfObject[1] = this.zM;
    arrayOfObject[2] = this.mName;
    arrayOfObject[3] = this.zN;
    arrayOfObject[4] = this.zO;
    arrayOfObject[5] = this.zP;
    arrayOfObject[6] = this.zQ;
    return hl.hashCode(arrayOfObject);
  }
  
  public boolean isNamespaceSupported(String paramString)
  {
    boolean bool;
    if ((this.zO == null) || (!this.zO.contains(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return this.mName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.ApplicationMetadata
 * JD-Core Version:    0.7.0.1
 */