package com.example.android.bitmapfun.util;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;

public class Utils
{
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    int i;
    if (Build.VERSION.SDK_INT < 12) {
      i = paramBitmap.getRowBytes() * paramBitmap.getHeight();
    } else {
      i = paramBitmap.getByteCount();
    }
    return i;
  }
  
  public static int getMemoryClass(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.example.android.bitmapfun.util.Utils
 * JD-Core Version:    0.7.0.1
 */