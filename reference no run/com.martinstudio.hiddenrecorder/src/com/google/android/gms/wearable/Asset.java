package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;

public class Asset
  implements SafeParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new a();
  private byte[] TC;
  private String ald;
  public ParcelFileDescriptor ale;
  public Uri uri;
  final int xJ;
  
  Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    this.xJ = paramInt;
    this.TC = paramArrayOfByte;
    this.ald = paramString;
    this.ale = paramParcelFileDescriptor;
    this.uri = paramUri;
  }
  
  public static Asset createFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return new Asset(1, paramArrayOfByte, null, null, null);
    }
    throw new IllegalArgumentException("Asset data cannot be null");
  }
  
  public static Asset createFromFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor != null) {
      return new Asset(1, null, null, paramParcelFileDescriptor, null);
    }
    throw new IllegalArgumentException("Asset fd cannot be null");
  }
  
  public static Asset createFromRef(String paramString)
  {
    if (paramString != null) {
      return new Asset(1, null, paramString, null, null);
    }
    throw new IllegalArgumentException("Asset digest cannot be null");
  }
  
  public static Asset createFromUri(Uri paramUri)
  {
    if (paramUri != null) {
      return new Asset(1, null, null, null, paramUri);
    }
    throw new IllegalArgumentException("Asset uri cannot be null");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof Asset))
      {
        Asset localAsset = (Asset)paramObject;
        if ((!hl.equal(this.TC, localAsset.TC)) || (!hl.equal(this.ald, localAsset.ald)) || (!hl.equal(this.ale, localAsset.ale)) || (!hl.equal(this.uri, localAsset.uri))) {
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
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public String getDigest()
  {
    return this.ald;
  }
  
  public ParcelFileDescriptor getFd()
  {
    return this.ale;
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.TC;
    arrayOfObject[1] = this.ald;
    arrayOfObject[2] = this.ale;
    arrayOfObject[3] = this.uri;
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.ald != null)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(this.ald);
    }
    else
    {
      localStringBuilder.append(", nodigest");
    }
    if (this.TC != null)
    {
      localStringBuilder.append(", size=");
      localStringBuilder.append(this.TC.length);
    }
    if (this.ale != null)
    {
      localStringBuilder.append(", fd=");
      localStringBuilder.append(this.ale);
    }
    if (this.uri != null)
    {
      localStringBuilder.append(", uri=");
      localStringBuilder.append(this.uri);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * JD-Core Version:    0.7.0.1
 */