package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

public final class cr
  implements SafeParcelable
{
  public static final cq CREATOR = new cq();
  public final dh kV;
  public final da kX;
  public final dc oR;
  public final Context oS;
  public final int versionCode;
  
  cr(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    this.versionCode = paramInt;
    this.kV = ((dh)e.e(d.a.ag(paramIBinder1)));
    this.kX = ((da)e.e(d.a.ag(paramIBinder2)));
    this.oR = ((dc)e.e(d.a.ag(paramIBinder3)));
    this.oS = ((Context)e.e(d.a.ag(paramIBinder4)));
  }
  
  public cr(dc paramdc, dh paramdh, da paramda, Context paramContext)
  {
    this.versionCode = 1;
    this.oR = paramdc;
    this.kV = paramdh;
    this.kX = paramda;
    this.oS = paramContext;
  }
  
  public static void a(Intent paramIntent, cr paramcr)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramcr);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }
  
  public static cr b(Intent paramIntent)
  {
    try
    {
      localObject = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      ((Bundle)localObject).setClassLoader(cr.class.getClassLoader());
      localObject = (cr)((Bundle)localObject).getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  IBinder aY()
  {
    return e.h(this.kV).asBinder();
  }
  
  IBinder aZ()
  {
    return e.h(this.kX).asBinder();
  }
  
  IBinder ba()
  {
    return e.h(this.oR).asBinder();
  }
  
  IBinder bb()
  {
    return e.h(this.oS).asBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cq.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cr
 * JD-Core Version:    0.7.0.1
 */