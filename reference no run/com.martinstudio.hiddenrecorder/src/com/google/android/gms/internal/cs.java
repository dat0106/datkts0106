package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.Method;

public class cs
{
  private final Context mContext;
  private Object oT;
  
  public cs(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject2 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
      Object localObject1 = new Class[3];
      localObject1[0] = Integer.TYPE;
      localObject1[1] = String.class;
      localObject1[2] = String.class;
      localObject1 = ((Class)localObject2).getDeclaredMethod("consumePurchase", (Class[])localObject1);
      localObject2 = ((Class)localObject2).cast(this.oT);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(3);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      i = ((Integer)((Method)localObject1).invoke(localObject2, arrayOfObject)).intValue();
      i = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        ev.c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", localException);
        int j = 5;
      }
    }
    return i;
  }
  
  public Bundle a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Object localObject3 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
      Object localObject1 = new Class[5];
      localObject1[0] = Integer.TYPE;
      localObject1[1] = String.class;
      localObject1[2] = String.class;
      localObject1[3] = String.class;
      localObject1[4] = String.class;
      localObject1 = ((Class)localObject3).getDeclaredMethod("getBuyIntent", (Class[])localObject1);
      localObject3 = ((Class)localObject3).cast(this.oT);
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = Integer.valueOf(3);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = paramString2;
      arrayOfObject[3] = "inapp";
      arrayOfObject[4] = paramString3;
      localObject1 = (Bundle)((Method)localObject1).invoke(localObject3, arrayOfObject);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ev.c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", localException);
        Object localObject2 = null;
      }
    }
  }
  
  public Bundle b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject3 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
      Object localObject1 = new Class[4];
      localObject1[0] = Integer.TYPE;
      localObject1[1] = String.class;
      localObject1[2] = String.class;
      localObject1[3] = String.class;
      localObject1 = ((Class)localObject3).getDeclaredMethod("getPurchases", (Class[])localObject1);
      localObject3 = ((Class)localObject3).cast(this.oT);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(3);
      arrayOfObject[1] = paramString1;
      arrayOfObject[2] = "inapp";
      arrayOfObject[3] = paramString2;
      localObject1 = (Bundle)((Method)localObject1).invoke(localObject3, arrayOfObject);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ev.c("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", localException);
        Object localObject2 = null;
      }
    }
  }
  
  public void destroy()
  {
    this.oT = null;
  }
  
  public void o(IBinder paramIBinder)
  {
    try
    {
      Object localObject2 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub");
      Object localObject1 = new Class[1];
      localObject1[0] = IBinder.class;
      localObject2 = ((Class)localObject2).getDeclaredMethod("asInterface", (Class[])localObject1);
      localObject1 = new Object[1];
      localObject1[0] = paramIBinder;
      this.oT = ((Method)localObject2).invoke(null, (Object[])localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ev.D("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cs
 * JD-Core Version:    0.7.0.1
 */