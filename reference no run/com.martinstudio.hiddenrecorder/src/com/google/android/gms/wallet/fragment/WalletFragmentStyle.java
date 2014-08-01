package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R.style;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new c();
  Bundle akB;
  int akC;
  final int xJ;
  
  public WalletFragmentStyle()
  {
    this.xJ = 1;
    this.akB = new Bundle();
  }
  
  WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.xJ = paramInt1;
    this.akB = paramBundle;
    this.akC = paramInt2;
  }
  
  private void a(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (!this.akB.containsKey(paramString))
    {
      TypedValue localTypedValue = paramTypedArray.peekValue(paramInt);
      if (localTypedValue != null) {
        this.akB.putLong(paramString, Dimension.a(localTypedValue));
      }
    }
  }
  
  private void a(TypedArray paramTypedArray, int paramInt, String paramString1, String paramString2)
  {
    if ((!this.akB.containsKey(paramString1)) && (!this.akB.containsKey(paramString2)))
    {
      TypedValue localTypedValue = paramTypedArray.peekValue(paramInt);
      if (localTypedValue != null) {
        if ((localTypedValue.type < 28) || (localTypedValue.type > 31)) {
          this.akB.putInt(paramString2, localTypedValue.resourceId);
        } else {
          this.akB.putInt(paramString1, localTypedValue.data);
        }
      }
    }
  }
  
  private void b(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (!this.akB.containsKey(paramString))
    {
      TypedValue localTypedValue = paramTypedArray.peekValue(paramInt);
      if (localTypedValue != null) {
        this.akB.putInt(paramString, localTypedValue.data);
      }
    }
  }
  
  public void N(Context paramContext)
  {
    int i;
    if (this.akC > 0) {
      i = this.akC;
    } else {
      i = R.style.WalletFragmentDefaultStyle;
    }
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(i, R.styleable.WalletFragmentStyle);
    a(localTypedArray, 1, "buyButtonWidth");
    a(localTypedArray, 0, "buyButtonHeight");
    b(localTypedArray, 2, "buyButtonText");
    b(localTypedArray, 3, "buyButtonAppearance");
    b(localTypedArray, 4, "maskedWalletDetailsTextAppearance");
    b(localTypedArray, 5, "maskedWalletDetailsHeaderTextAppearance");
    a(localTypedArray, 6, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
    b(localTypedArray, 7, "maskedWalletDetailsButtonTextAppearance");
    a(localTypedArray, 8, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
    b(localTypedArray, 9, "maskedWalletDetailsLogoTextColor");
    b(localTypedArray, 10, "maskedWalletDetailsLogoImageType");
    localTypedArray.recycle();
  }
  
  public int a(String paramString, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    if (this.akB.containsKey(paramString)) {
      paramInt = Dimension.a(this.akB.getLong(paramString), paramDisplayMetrics);
    }
    return paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public WalletFragmentStyle setBuyButtonAppearance(int paramInt)
  {
    this.akB.putInt("buyButtonAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonHeight(int paramInt)
  {
    this.akB.putLong("buyButtonHeight", Dimension.dM(paramInt));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonHeight(int paramInt, float paramFloat)
  {
    this.akB.putLong("buyButtonHeight", Dimension.a(paramInt, paramFloat));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonText(int paramInt)
  {
    this.akB.putInt("buyButtonText", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonWidth(int paramInt)
  {
    this.akB.putLong("buyButtonWidth", Dimension.dM(paramInt));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonWidth(int paramInt, float paramFloat)
  {
    this.akB.putLong("buyButtonWidth", Dimension.a(paramInt, paramFloat));
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int paramInt)
  {
    this.akB.remove("maskedWalletDetailsBackgroundResource");
    this.akB.putInt("maskedWalletDetailsBackgroundColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int paramInt)
  {
    this.akB.remove("maskedWalletDetailsBackgroundColor");
    this.akB.putInt("maskedWalletDetailsBackgroundResource", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int paramInt)
  {
    this.akB.remove("maskedWalletDetailsButtonBackgroundResource");
    this.akB.putInt("maskedWalletDetailsButtonBackgroundColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int paramInt)
  {
    this.akB.remove("maskedWalletDetailsButtonBackgroundColor");
    this.akB.putInt("maskedWalletDetailsButtonBackgroundResource", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsButtonTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsHeaderTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsLogoImageType", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsLogoTextColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setStyleResourceId(int paramInt)
  {
    this.akC = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentStyle
 * JD-Core Version:    0.7.0.1
 */