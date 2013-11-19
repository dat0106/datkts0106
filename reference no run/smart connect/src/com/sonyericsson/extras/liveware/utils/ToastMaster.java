package com.sonyericsson.extras.liveware.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.sonyericsson.extras.liveware.service.ToastService;

public class ToastMaster
{
  private static int sShownToasts;
  private static boolean sTestMode = false;
  
  public static void makeLWToast(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.sonyericsson.extras.TOAST_ACTION");
    localIntent.putExtra("title_extra", paramString1);
    localIntent.putExtra("msg_extra", paramString2);
    localIntent.setComponent(new ComponentName(paramContext, ToastService.class));
    paramContext.startService(localIntent);
  }
  
  public static void show(Toast paramToast)
  {
    paramToast.show();
    if (sTestMode) {
      sShownToasts = 1 + sShownToasts;
    }
  }
  
  public static void showLWToast(Context paramContext, String paramString1, String paramString2)
  {
    Toast localToast = new Toast(paramContext);
    View localView = View.inflate(paramContext, 2130903087, null);
    ((TextView)localView.findViewById(2131558536)).setText(paramString1);
    ((TextView)localView.findViewById(2131558537)).setText(paramString2);
    localToast.setView(localView);
    localToast.show();
  }
  
  public static int testGetShownToasts()
  {
    return sShownToasts;
  }
  
  public static void testStartTestMode()
  {
    sTestMode = true;
    sShownToasts = 0;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.ToastMaster
 * JD-Core Version:    0.7.0.1
 */