package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class cu
  extends dc.a
{
  private String lp;
  private Context mContext;
  private String pd;
  private ArrayList<String> pe;
  
  public cu(String paramString1, ArrayList<String> paramArrayList, Context paramContext, String paramString2)
  {
    this.pd = paramString1;
    this.pe = paramArrayList;
    this.lp = paramString2;
    this.mContext = paramContext;
  }
  
  private void be()
  {
    try
    {
      Object localObject1 = this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter");
      Object localObject2 = new Class[4];
      localObject2[0] = Context.class;
      localObject2[1] = String.class;
      localObject2[2] = String.class;
      localObject2[3] = Boolean.TYPE;
      localObject2 = ((Class)localObject1).getDeclaredMethod("reportWithProductId", (Class[])localObject2);
      localObject1 = new Object[4];
      localObject1[0] = this.mContext;
      localObject1[1] = this.pd;
      localObject1[2] = "";
      localObject1[3] = Boolean.valueOf(true);
      ((Method)localObject2).invoke(null, (Object[])localObject1);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        ev.D("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        ev.D("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ev.c("Fail to report a conversion.", localException);
      }
    }
  }
  
  protected String a(String paramString, HashMap<String, String> paramHashMap)
  {
    localObject3 = this.mContext.getPackageName();
    try
    {
      String str1 = this.mContext.getPackageManager().getPackageInfo((String)localObject3, 0).versionName;
      localObject2 = str1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        long l;
        ev.c("Error to retrieve app version", localNameNotFoundException);
        localObject2 = "";
      }
      Object localObject4 = new Object[1];
      localObject4[0] = "sessionid";
      Object localObject5 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", (Object[])localObject4);
      localObject4 = new Object[1];
      localObject4[0] = ei.rN;
      localObject4 = paramString.replaceAll((String)localObject5, String.format("$1%s$2", (Object[])localObject4));
      localObject5 = new Object[1];
      localObject5[0] = "appid";
      localObject5 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", (Object[])localObject5);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localObject3;
      localObject3 = ((String)localObject4).replaceAll((String)localObject5, String.format("$1%s$2", arrayOfObject));
      localObject4 = new Object[1];
      localObject4[0] = "osversion";
      localObject4 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", (Object[])localObject4);
      localObject5 = new Object[1];
      localObject5[0] = String.valueOf(Build.VERSION.SDK_INT);
      localObject3 = ((String)localObject3).replaceAll((String)localObject4, String.format("$1%s$2", (Object[])localObject5));
      localObject4 = new Object[1];
      localObject4[0] = "sdkversion";
      localObject5 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", (Object[])localObject4);
      localObject4 = new Object[1];
      localObject4[0] = this.lp;
      localObject3 = ((String)localObject3).replaceAll((String)localObject5, String.format("$1%s$2", (Object[])localObject4));
      localObject4 = new Object[1];
      localObject4[0] = "appversion";
      localObject4 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", (Object[])localObject4);
      localObject5 = new Object[1];
      localObject5[0] = localObject2;
      Object localObject2 = ((String)localObject3).replaceAll((String)localObject4, String.format("$1%s$2", (Object[])localObject5));
      localObject3 = new Object[1];
      localObject3[0] = "timestamp";
      localObject4 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", (Object[])localObject3);
      localObject3 = new Object[1];
      localObject3[0] = String.valueOf(localNameNotFoundException);
      String str2 = ((String)localObject2).replaceAll((String)localObject4, String.format("$1%s$2", (Object[])localObject3));
      Object localObject1 = new Object[1];
      localObject1[0] = "[^@]+";
      localObject1 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", (Object[])localObject1);
      localObject2 = new Object[1];
      localObject2[0] = "";
      return str2.replaceAll((String)localObject1, String.format("$1%s$2", (Object[])localObject2)).replaceAll("@@", "@");
    }
    l = SystemClock.elapsedRealtime() - ei.bF().bJ();
    localObject4 = paramHashMap.keySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (String)((Iterator)localObject4).next();
      arrayOfObject = new Object[1];
      arrayOfObject[0] = localObject5;
      String str3 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject);
      arrayOfObject = new Object[1];
      arrayOfObject[0] = paramHashMap.get(localObject5);
      paramString = paramString.replaceAll(str3, String.format("$1%s$2", arrayOfObject));
    }
  }
  
  public String getProductId()
  {
    return this.pd;
  }
  
  protected int l(int paramInt)
  {
    int i = 1;
    if (paramInt != 0) {
      if (paramInt != i)
      {
        if (paramInt != 4) {
          i = 0;
        } else {
          i = 3;
        }
      }
      else {
        i = 2;
      }
    }
    return i;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    if (paramInt == 0) {
      be();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("google_play_status", String.valueOf(paramInt));
    localHashMap.put("sku", this.pd);
    localHashMap.put("status", String.valueOf(l(paramInt)));
    Iterator localIterator = this.pe.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      new et(this.mContext, this.lp, a(str, localHashMap)).start();
    }
  }
  
  public void recordResolution(int paramInt)
  {
    if (paramInt == 1) {
      be();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", String.valueOf(paramInt));
    localHashMap.put("sku", this.pd);
    Iterator localIterator = this.pe.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      new et(this.mContext, this.lp, a(str, localHashMap)).start();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cu
 * JD-Core Version:    0.7.0.1
 */