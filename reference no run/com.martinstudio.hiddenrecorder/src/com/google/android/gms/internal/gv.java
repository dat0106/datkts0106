package com.google.android.gms.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public final class gv
{
  public static Bitmap a(Bitmap paramBitmap)
  {
    int k = 0;
    Bitmap localBitmap1;
    if (paramBitmap != null)
    {
      int m = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int i;
      if (m < j)
      {
        i = j / 2 - m / 2;
        j = m;
      }
      else
      {
        k = m / 2 - j / 2;
        i = 0;
      }
      Bitmap localBitmap2 = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localCanvas.drawCircle(j / 2, j / 2, j / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, k, i, localPaint);
      localBitmap1 = localBitmap2;
    }
    else
    {
      localBitmap1 = null;
    }
    return localBitmap1;
  }
  
  private static Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap;
    if (paramDrawable != null)
    {
      if (!(paramDrawable instanceof BitmapDrawable))
      {
        localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
      }
      else
      {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
    }
    else {
      localBitmap = null;
    }
    return localBitmap;
  }
  
  public static Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return new BitmapDrawable(paramResources, a(a(paramDrawable)));
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gv
 * JD-Core Version:    0.7.0.1
 */