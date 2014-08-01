package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new b();
  private int Hv;
  private int ajY;
  private WalletFragmentStyle akz;
  private int mTheme;
  final int xJ;
  
  private WalletFragmentOptions()
  {
    this.xJ = 1;
  }
  
  WalletFragmentOptions(int paramInt1, int paramInt2, int paramInt3, WalletFragmentStyle paramWalletFragmentStyle, int paramInt4)
  {
    this.xJ = paramInt1;
    this.ajY = paramInt2;
    this.mTheme = paramInt3;
    this.akz = paramWalletFragmentStyle;
    this.Hv = paramInt4;
  }
  
  public static WalletFragmentOptions a(Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WalletFragmentOptions);
    int m = ((TypedArray)localObject).getInt(0, 0);
    int k = ((TypedArray)localObject).getInt(1, 1);
    int j = ((TypedArray)localObject).getResourceId(2, 0);
    int i = ((TypedArray)localObject).getInt(3, 1);
    ((TypedArray)localObject).recycle();
    localObject = new WalletFragmentOptions();
    ((WalletFragmentOptions)localObject).mTheme = m;
    ((WalletFragmentOptions)localObject).ajY = k;
    ((WalletFragmentOptions)localObject).akz = new WalletFragmentStyle().setStyleResourceId(j);
    ((WalletFragmentOptions)localObject).akz.N(paramContext);
    ((WalletFragmentOptions)localObject).Hv = i;
    return localObject;
  }
  
  public static Builder newBuilder()
  {
    WalletFragmentOptions localWalletFragmentOptions = new WalletFragmentOptions();
    localWalletFragmentOptions.getClass();
    return new Builder(null);
  }
  
  public void N(Context paramContext)
  {
    if (this.akz != null) {
      this.akz.N(paramContext);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEnvironment()
  {
    return this.ajY;
  }
  
  public WalletFragmentStyle getFragmentStyle()
  {
    return this.akz;
  }
  
  public int getMode()
  {
    return this.Hv;
  }
  
  public int getTheme()
  {
    return this.mTheme;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public WalletFragmentOptions build()
    {
      return WalletFragmentOptions.this;
    }
    
    public Builder setEnvironment(int paramInt)
    {
      WalletFragmentOptions.a(WalletFragmentOptions.this, paramInt);
      return this;
    }
    
    public Builder setFragmentStyle(int paramInt)
    {
      WalletFragmentOptions.a(WalletFragmentOptions.this, new WalletFragmentStyle().setStyleResourceId(paramInt));
      return this;
    }
    
    public Builder setFragmentStyle(WalletFragmentStyle paramWalletFragmentStyle)
    {
      WalletFragmentOptions.a(WalletFragmentOptions.this, paramWalletFragmentStyle);
      return this;
    }
    
    public Builder setMode(int paramInt)
    {
      WalletFragmentOptions.c(WalletFragmentOptions.this, paramInt);
      return this;
    }
    
    public Builder setTheme(int paramInt)
    {
      WalletFragmentOptions.b(WalletFragmentOptions.this, paramInt);
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentOptions
 * JD-Core Version:    0.7.0.1
 */