package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public class cv
  extends de.a
  implements ServiceConnection
{
  private dh oV;
  private cs oW;
  private final cy oX;
  private da oZ;
  private final Activity oe;
  private Context pf;
  private dc pg;
  private cw ph;
  private String pi = null;
  
  public cv(Activity paramActivity)
  {
    this.oe = paramActivity;
    this.oX = cy.h(this.oe.getApplicationContext());
  }
  
  public static void a(Context paramContext, boolean paramBoolean, cr paramcr)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", paramBoolean);
    cr.a(localIntent, paramcr);
    paramContext.startActivity(localIntent);
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    try
    {
      this.oV.a(new cx(this.pf, paramString, paramBoolean, paramInt, paramIntent, this.ph));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.D("Fail to invoke PlayStorePurchaseListener.");
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001) {}
    try
    {
      int i = cz.c(paramIntent);
      if ((paramInt2 == -1) && (i == 0))
      {
        if (this.oZ.a(this.pi, paramInt2, paramIntent)) {
          a(this.pg.getProductId(), true, paramInt2, paramIntent);
        }
        for (;;)
        {
          this.pg.recordPlayBillingResolution(i);
          return;
          a(this.pg.getProductId(), false, paramInt2, paramIntent);
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.D("Fail to process purchase result.");
        this.pi = null;
        this.oe.finish();
        continue;
        this.oX.a(this.ph);
        a(this.pg.getProductId(), false, paramInt2, paramIntent);
      }
    }
    finally
    {
      this.pi = null;
      this.oe.finish();
    }
  }
  
  public void onCreate()
  {
    Object localObject = cr.b(this.oe.getIntent());
    this.oV = ((cr)localObject).kV;
    this.oZ = ((cr)localObject).kX;
    this.pg = ((cr)localObject).oR;
    this.oW = new cs(this.oe.getApplicationContext());
    this.pf = ((cr)localObject).oS;
    Activity localActivity = this.oe;
    localObject = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    this.oe.getApplicationContext();
    localActivity.bindService((Intent)localObject, this, 1);
  }
  
  public void onDestroy()
  {
    this.oe.unbindService(this);
    this.oW.destroy();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.oW.o(paramIBinder);
    try
    {
      this.pi = this.oZ.bh();
      Bundle localBundle = this.oW.a(this.oe.getPackageName(), this.pg.getProductId(), this.pi);
      PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("BUY_INTENT");
      int i;
      if (localPendingIntent == null)
      {
        i = cz.a(localBundle);
        this.pg.recordPlayBillingResolution(i);
        a(this.pg.getProductId(), false, i, null);
        this.oe.finish();
      }
      else
      {
        this.ph = new cw(this.pg.getProductId(), this.pi);
        this.oX.b(this.ph);
        this.oe.startIntentSenderForResult(i.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
      }
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Error when connecting in-app billing service", localRemoteException);
      this.oe.finish();
    }
    catch (IntentSender.SendIntentException localSendIntentException)
    {
      label186:
      break label186;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ev.B("In-app billing service disconnected.");
    this.oW.destroy();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cv
 * JD-Core Version:    0.7.0.1
 */