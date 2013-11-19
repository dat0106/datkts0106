package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.example.android.bitmapfun.util.ImageWorker;

public class ImageGradientWorker
  extends ImageWorker
{
  private boolean eventListGradient = false;
  
  public ImageGradientWorker(Context paramContext)
  {
    super(paramContext);
  }
  
  protected Bitmap processBitmap(Object paramObject)
  {
    String str = String.valueOf(paramObject);
    return UIUtils.getBitmapWithGradient(this.mContext, str, this.eventListGradient);
  }
  
  public void setEventListGradient(boolean paramBoolean)
  {
    this.eventListGradient = paramBoolean;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.ImageGradientWorker
 * JD-Core Version:    0.7.0.1
 */