package com.sonyericsson.extras.liveware.actions.datatraffic;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.sonyericsson.extras.liveware.actions.ActionForResultService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.lang.reflect.Method;

public class DataTrafficAction
  extends ActionForResultService
{
  static final String ACTION_DATA_TRAFFIC_SWITCH = "com.android.phone.intent.ACTION_DATA_TRAFFIC_SWITCH";
  
  private static boolean isDataEnabled(Context paramContext)
  {
    boolean bool = false;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    Method[] arrayOfMethod = localConnectivityManager.getClass().getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return bool;
      }
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getName().equals("getMobileDataEnabled")) {}
      try
      {
        bool = ((Boolean)localMethod.invoke(localConnectivityManager, new Object[0])).booleanValue();
        bool = bool;
        i++;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Dbg.e("Failed to read if data traffic is enabled");
        }
      }
    }
  }
  
  private void setMobileDataEnabled(Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    Method[] arrayOfMethod = localConnectivityManager.getClass().getDeclaredMethods();
    int i = arrayOfMethod.length;
    for (;;)
    {
      if (j >= i) {
        return;
      }
      Method localMethod = arrayOfMethod[j];
      if (localMethod.getName().equals("setMobileDataEnabled")) {}
      try
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(paramBoolean);
        localMethod.invoke(localConnectivityManager, arrayOfObject);
        j++;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Dbg.e("Failed calling setMobileDataEnabled");
        }
      }
    }
  }
  
  protected void disable()
  {
    Context localContext = getApplicationContext();
    if (!isDataEnabled(localContext))
    {
      replyAndStop(0);
    }
    else
    {
      setMobileDataEnabled(localContext, false);
      waitForStateChange("android.intent.action.ANY_DATA_STATE");
    }
  }
  
  protected void enable()
  {
    Context localContext = getApplicationContext();
    if (isDataEnabled(localContext))
    {
      replyAndStop(0);
    }
    else
    {
      setMobileDataEnabled(localContext, true);
      waitForStateChange("android.intent.action.ANY_DATA_STATE");
    }
  }
  
  protected void onStateChange(Intent paramIntent)
  {
    Object localObject = ((ConnectivityManager)getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject == null)
    {
      Dbg.e("Faild to get network info");
      replyAndStop(0);
    }
    else
    {
      localObject = ((NetworkInfo)localObject).getState();
      if ((((NetworkInfo.State)localObject).compareTo(NetworkInfo.State.CONNECTING) != 0) && (((NetworkInfo.State)localObject).compareTo(NetworkInfo.State.DISCONNECTING) != 0)) {
        replyAndStop(0);
      } else {
        Dbg.d("Still waiting for state change");
      }
    }
  }
  
  protected void toggle()
  {
    Context localContext = getApplicationContext();
    boolean bool;
    if (!isDataEnabled(localContext)) {
      bool = true;
    } else {
      bool = false;
    }
    setMobileDataEnabled(localContext, bool);
    waitForStateChange("android.intent.action.ANY_DATA_STATE");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.datatraffic.DataTrafficAction
 * JD-Core Version:    0.7.0.1
 */