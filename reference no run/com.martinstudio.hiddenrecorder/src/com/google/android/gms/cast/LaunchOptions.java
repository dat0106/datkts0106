package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gj;
import com.google.android.gms.internal.hl;
import java.util.Locale;

public class LaunchOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<LaunchOptions> CREATOR = new c();
  private boolean An;
  private String Ao;
  private final int xJ;
  
  public LaunchOptions()
  {
    this(1, false, gj.b(Locale.getDefault()));
  }
  
  LaunchOptions(int paramInt, boolean paramBoolean, String paramString)
  {
    this.xJ = paramInt;
    this.An = paramBoolean;
    this.Ao = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject != this) {
      if ((paramObject instanceof LaunchOptions))
      {
        LaunchOptions localLaunchOptions = (LaunchOptions)paramObject;
        if ((this.An != localLaunchOptions.An) || (!gj.a(this.Ao, localLaunchOptions.Ao))) {
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
  
  public String getLanguage()
  {
    return this.Ao;
  }
  
  public boolean getRelaunchIfRunning()
  {
    return this.An;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(this.An);
    arrayOfObject[1] = this.Ao;
    return hl.hashCode(arrayOfObject);
  }
  
  public void setLanguage(String paramString)
  {
    this.Ao = paramString;
  }
  
  public void setRelaunchIfRunning(boolean paramBoolean)
  {
    this.An = paramBoolean;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Boolean.valueOf(this.An);
    arrayOfObject[1] = this.Ao;
    return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private LaunchOptions Ap = new LaunchOptions();
    
    public LaunchOptions build()
    {
      return this.Ap;
    }
    
    public Builder setLocale(Locale paramLocale)
    {
      this.Ap.setLanguage(gj.b(paramLocale));
      return this;
    }
    
    public Builder setRelaunchIfRunning(boolean paramBoolean)
    {
      this.Ap.setRelaunchIfRunning(paramBoolean);
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.LaunchOptions
 * JD-Core Version:    0.7.0.1
 */