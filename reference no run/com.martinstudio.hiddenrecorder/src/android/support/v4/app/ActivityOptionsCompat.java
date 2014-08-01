package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;

public class ActivityOptionsCompat
{
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT < 16) {
      localObject = new ActivityOptionsCompat();
    } else {
      localObject = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    return localObject;
  }
  
  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT < 16) {
      localObject = new ActivityOptionsCompat();
    } else {
      localObject = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return localObject;
  }
  
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT < 16) {
      localObject = new ActivityOptionsCompat();
    } else {
      localObject = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    return localObject;
  }
  
  public Bundle toBundle()
  {
    return null;
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat) {}
  
  private static class ActivityOptionsImplJB
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompatJB mImpl;
    
    ActivityOptionsImplJB(ActivityOptionsCompatJB paramActivityOptionsCompatJB)
    {
      this.mImpl = paramActivityOptionsCompatJB;
    }
    
    public Bundle toBundle()
    {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImplJB))
      {
        ActivityOptionsImplJB localActivityOptionsImplJB = (ActivityOptionsImplJB)paramActivityOptionsCompat;
        this.mImpl.update(localActivityOptionsImplJB.mImpl);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat
 * JD-Core Version:    0.7.0.1
 */