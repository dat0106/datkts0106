package android.support.v4.view;

import android.view.ScaleGestureDetector;

class ScaleGestureDetectorCompatKitKat
{
  public static boolean isQuickScaleEnabled(Object paramObject)
  {
    return ((ScaleGestureDetector)paramObject).isQuickScaleEnabled();
  }
  
  public static void setQuickScaleEnabled(Object paramObject, boolean paramBoolean)
  {
    ((ScaleGestureDetector)paramObject).setQuickScaleEnabled(paramBoolean);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ScaleGestureDetectorCompatKitKat
 * JD-Core Version:    0.7.0.1
 */