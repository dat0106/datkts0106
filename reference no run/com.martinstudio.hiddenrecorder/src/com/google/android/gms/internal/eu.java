package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class eu
{
  public static final Handler ss = new Handler(Looper.getMainLooper());
  
  public static int a(Context paramContext, int paramInt)
  {
    return a(paramContext.getResources().getDisplayMetrics(), paramInt);
  }
  
  public static int a(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }
  
  public static void a(ViewGroup paramViewGroup, am paramam, String paramString)
  {
    a(paramViewGroup, paramam, paramString, -16777216, -1);
  }
  
  private static void a(ViewGroup paramViewGroup, am paramam, String paramString, int paramInt1, int paramInt2)
  {
    if (paramViewGroup.getChildCount() == 0)
    {
      Context localContext = paramViewGroup.getContext();
      TextView localTextView = new TextView(localContext);
      localTextView.setGravity(17);
      localTextView.setText(paramString);
      localTextView.setTextColor(paramInt1);
      localTextView.setBackgroundColor(paramInt2);
      FrameLayout localFrameLayout = new FrameLayout(localContext);
      localFrameLayout.setBackgroundColor(paramInt1);
      int i = a(localContext, 3);
      localFrameLayout.addView(localTextView, new FrameLayout.LayoutParams(paramam.widthPixels - i, paramam.heightPixels - i, 17));
      paramViewGroup.addView(localFrameLayout, paramam.widthPixels, paramam.heightPixels);
    }
  }
  
  public static void a(ViewGroup paramViewGroup, am paramam, String paramString1, String paramString2)
  {
    ev.D(paramString2);
    a(paramViewGroup, paramam, paramString1, -65536, -16777216);
  }
  
  public static boolean bQ()
  {
    return Build.DEVICE.startsWith("generic");
  }
  
  public static boolean bR()
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static String o(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((str == null) || (bQ())) {
      str = "emulator";
    }
    return y(str);
  }
  
  public static String y(String paramString)
  {
    int i = 0;
    if (i < 2) {}
    for (;;)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramString.getBytes());
        localObject = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest());
        localObject = String.format((Locale)localObject, "%032X", arrayOfObject);
        localObject = localObject;
        return localObject;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i++;
      }
      break;
      Object localObject = null;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.eu
 * JD-Core Version:    0.7.0.1
 */