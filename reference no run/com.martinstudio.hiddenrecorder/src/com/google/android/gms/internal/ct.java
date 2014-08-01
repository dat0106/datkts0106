package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ct
  extends en
  implements ServiceConnection
{
  private final Object lq = new Object();
  private Context mContext;
  private boolean oU = false;
  private dh oV;
  private cs oW;
  private cy oX;
  private List<cw> oY = null;
  private da oZ;
  
  public ct(Context paramContext, dh paramdh, da paramda)
  {
    this.mContext = paramContext;
    this.oV = paramdh;
    this.oZ = paramda;
    this.oW = new cs(paramContext);
    this.oX = cy.h(this.mContext);
    this.oY = this.oX.d(10L);
  }
  
  private void a(final cw paramcw, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    localIntent.putExtra("RESPONSE_CODE", 0);
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    eu.ss.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (ct.a(ct.this).a(paramcw.pk, -1, localIntent)) {
            ct.c(ct.this).a(new cx(ct.b(ct.this), paramcw.pl, true, -1, localIntent, paramcw));
          } else {
            ct.c(ct.this).a(new cx(ct.b(ct.this), paramcw.pl, false, -1, localIntent, paramcw));
          }
        }
        catch (RemoteException localRemoteException)
        {
          ev.D("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }
  
  private void b(long paramLong)
  {
    do
    {
      if (!c(paramLong)) {
        ev.D("Timeout waiting for pending transaction to be processed.");
      }
    } while (!this.oU);
  }
  
  private void bd()
  {
    HashMap localHashMap;
    Object localObject1;
    if (!this.oY.isEmpty())
    {
      localHashMap = new HashMap();
      localObject1 = this.oY.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        localObject1 = null;
        Object localObject3 = this.oW.b(this.mContext.getPackageName(), (String)localObject1);
        ArrayList localArrayList;
        String str2;
        if ((localObject3 != null) && (cz.a((Bundle)localObject3) == 0))
        {
          localArrayList = ((Bundle)localObject3).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
          localObject2 = ((Bundle)localObject3).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
          localObject1 = ((Bundle)localObject3).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
          str2 = ((Bundle)localObject3).getString("INAPP_CONTINUATION_TOKEN");
        }
        for (int i = 0;; i++)
        {
          if (i >= localArrayList.size())
          {
            if ((str2 == null) || (localHashMap.isEmpty()))
            {
              localObject1 = localHashMap.keySet().iterator();
              for (;;)
              {
                if (!((Iterator)localObject1).hasNext()) {
                  return;
                }
                localObject2 = (String)((Iterator)localObject1).next();
                this.oX.a((cw)localHashMap.get(localObject2));
              }
            }
            localObject1 = str2;
            break;
          }
          if (localHashMap.containsKey(localArrayList.get(i)))
          {
            String str1 = (String)localArrayList.get(i);
            String str4 = (String)((ArrayList)localObject2).get(i);
            localObject3 = (String)((ArrayList)localObject1).get(i);
            cw localcw = (cw)localHashMap.get(str1);
            String str3 = cz.p(str4);
            if (localcw.pk.equals(str3))
            {
              a(localcw, str4, (String)localObject3);
              localHashMap.remove(str1);
            }
          }
        }
      }
      Object localObject2 = (cw)((Iterator)localObject1).next();
      localHashMap.put(((cw)localObject2).pl, localObject2);
    }
  }
  
  private boolean c(long paramLong)
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    boolean bool;
    if (l <= 0L) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.lq.wait(bool);
        bool = true;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ev.D("waitWithTimeout_lock interrupted");
        }
      }
    }
  }
  
  public void bc()
  {
    synchronized (this.lq)
    {
      Context localContext = this.mContext;
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localContext.bindService(localIntent, this, 1);
      b(SystemClock.elapsedRealtime());
      this.mContext.unbindService(this);
      this.oW.destroy();
      return;
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (this.lq)
    {
      this.oW.o(paramIBinder);
      bd();
      this.oU = true;
      this.lq.notify();
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ev.B("In-app billing service disconnected.");
    this.oW.destroy();
  }
  
  public void onStop()
  {
    synchronized (this.lq)
    {
      this.mContext.unbindService(this);
      this.oW.destroy();
      return;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ct
 * JD-Core Version:    0.7.0.1
 */