package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new b();
  private final Uri Fr;
  private final int ks;
  private final int kt;
  private final int xJ;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.xJ = paramInt1;
    this.Fr = paramUri;
    this.ks = paramInt2;
    this.kt = paramInt3;
  }
  
  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
        return;
      }
      throw new IllegalArgumentException("width and height must not be negative");
    }
    throw new IllegalArgumentException("url cannot be null");
  }
  
  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(c(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  private static Uri c(JSONObject paramJSONObject)
  {
    Uri localUri = null;
    if (paramJSONObject.has("url")) {}
    try
    {
      localUri = Uri.parse(paramJSONObject.getString("url"));
      localUri = localUri;
    }
    catch (JSONException localJSONException)
    {
      label23:
      break label23;
    }
    return localUri;
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.Fr.toString());
      localJSONObject.put("width", this.ks);
      localJSONObject.put("height", this.kt);
      label44:
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label44;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject != null) && ((paramObject instanceof WebImage)))
      {
        WebImage localWebImage = (WebImage)paramObject;
        if ((!hl.equal(this.Fr, localWebImage.Fr)) || (this.ks != localWebImage.ks) || (this.kt != localWebImage.kt)) {
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
  
  public int getHeight()
  {
    return this.kt;
  }
  
  public Uri getUrl()
  {
    return this.Fr;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int getWidth()
  {
    return this.ks;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.Fr;
    arrayOfObject[1] = Integer.valueOf(this.ks);
    arrayOfObject[2] = Integer.valueOf(this.kt);
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.ks);
    arrayOfObject[1] = Integer.valueOf(this.kt);
    arrayOfObject[2] = this.Fr.toString();
    return String.format("Image %dx%d %s", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * JD-Core Version:    0.7.0.1
 */