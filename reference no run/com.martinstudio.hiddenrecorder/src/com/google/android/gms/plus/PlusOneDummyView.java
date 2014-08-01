package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class PlusOneDummyView
  extends FrameLayout
{
  public static final String TAG = "PlusOneDummyView";
  
  public PlusOneDummyView(Context paramContext, int paramInt)
  {
    super(paramContext);
    Button localButton = new Button(paramContext);
    localButton.setEnabled(false);
    localButton.setBackgroundDrawable(jO().getDrawable(paramInt));
    Point localPoint = cY(paramInt);
    addView(localButton, new FrameLayout.LayoutParams(localPoint.x, localPoint.y, 17));
  }
  
  private Point cY(int paramInt)
  {
    int j = 24;
    int k = 20;
    Point localPoint = new Point();
    switch (paramInt)
    {
    default: 
      int i = j;
      j = 38;
      k = i;
      break;
    case 0: 
      k = 14;
      break;
    case 1: 
      j = 32;
      break;
    case 2: 
      j = 50;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f2 = TypedValue.applyDimension(1, j, localDisplayMetrics);
    float f1 = TypedValue.applyDimension(1, k, localDisplayMetrics);
    localPoint.x = ((int)(0.5D + f2));
    localPoint.y = ((int)(0.5D + f1));
    return localPoint;
  }
  
  private d jO()
  {
    Object localObject = new b(getContext(), null);
    if (!((d)localObject).isValid()) {
      localObject = new c(getContext(), null);
    }
    if (!((d)localObject).isValid()) {
      localObject = new a(getContext(), null);
    }
    return localObject;
  }
  
  private static class a
    implements PlusOneDummyView.d
  {
    private Context mContext;
    
    private a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public Drawable getDrawable(int paramInt)
    {
      return this.mContext.getResources().getDrawable(17301508);
    }
    
    public boolean isValid()
    {
      return true;
    }
  }
  
  private static class c
    implements PlusOneDummyView.d
  {
    private Context mContext;
    
    private c(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public Drawable getDrawable(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "ic_plusone_standard_off_client";
        break;
      case 0: 
        str = "ic_plusone_small_off_client";
        break;
      case 1: 
        str = "ic_plusone_medium_off_client";
        break;
      case 2: 
        str = "ic_plusone_tall_off_client";
      }
      int i = this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName());
      return this.mContext.getResources().getDrawable(i);
    }
    
    public boolean isValid()
    {
      int k = this.mContext.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.mContext.getPackageName());
      int i = this.mContext.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.mContext.getPackageName());
      int j = this.mContext.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.mContext.getPackageName());
      int m = this.mContext.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.mContext.getPackageName());
      if ((k == 0) || (i == 0) || (j == 0) || (m == 0)) {
        i = 0;
      } else {
        i = 1;
      }
      return i;
    }
  }
  
  private static class b
    implements PlusOneDummyView.d
  {
    private Context mContext;
    
    private b(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public Drawable getDrawable(int paramInt)
    {
      for (;;)
      {
        try
        {
          Resources localResources = this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
          switch (paramInt)
          {
          case 2: 
            localObject = localResources.getDrawable(localResources.getIdentifier((String)localObject, "drawable", "com.google.android.gms"));
            break label75;
            localObject = "ic_plusone_tall";
            continue;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localObject = null;
          break label75;
          localObject = "ic_plusone_standard";
          continue;
        }
        label75:
        return localObject;
        Object localObject = "ic_plusone_small";
        continue;
        localObject = "ic_plusone_medium";
      }
    }
    
    public boolean isValid()
    {
      try
      {
        this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
        bool = true;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          boolean bool = false;
        }
      }
      return bool;
    }
  }
  
  private static abstract interface d
  {
    public abstract Drawable getDrawable(int paramInt);
    
    public abstract boolean isValid();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.PlusOneDummyView
 * JD-Core Version:    0.7.0.1
 */