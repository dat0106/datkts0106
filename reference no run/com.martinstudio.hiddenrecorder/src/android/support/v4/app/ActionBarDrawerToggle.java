package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private static final int ID_HOME = 16908332;
  private static final ActionBarDrawerToggleImpl IMPL;
  private static final float TOGGLE_DRAWABLE_OFFSET = 0.3333333F;
  private final Activity mActivity;
  private final Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private Drawable mDrawerImage;
  private final int mDrawerImageResource;
  private boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private final int mOpenDrawerContentDescRes;
  private Object mSetIndicatorInfo;
  private SlideDrawable mSlider;
  private Drawable mThemeImage;
  
  static
  {
    if (Build.VERSION.SDK_INT < 11) {
      IMPL = new ActionBarDrawerToggleImplBase(null);
    } else {
      IMPL = new ActionBarDrawerToggleImplHC(null);
    }
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mActivity = paramActivity;
    if (!(paramActivity instanceof DelegateProvider)) {
      this.mActivityImpl = null;
    } else {
      this.mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();
    }
    this.mDrawerLayout = paramDrawerLayout;
    this.mDrawerImageResource = paramInt1;
    this.mOpenDrawerContentDescRes = paramInt2;
    this.mCloseDrawerContentDescRes = paramInt3;
    this.mThemeImage = getThemeUpIndicator();
    this.mDrawerImage = paramActivity.getResources().getDrawable(paramInt1);
    this.mSlider = new SlideDrawable(this.mDrawerImage, null);
    this.mSlider.setOffset(0.3333333F);
  }
  
  Drawable getThemeUpIndicator()
  {
    Drawable localDrawable;
    if (this.mActivityImpl == null) {
      localDrawable = IMPL.getThemeUpIndicator(this.mActivity);
    } else {
      localDrawable = this.mActivityImpl.getThemeUpIndicator();
    }
    return localDrawable;
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return this.mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mThemeImage = getThemeUpIndicator();
    this.mDrawerImage = this.mActivity.getResources().getDrawable(this.mDrawerImageResource);
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    this.mSlider.setPosition(0.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    this.mSlider.setPosition(1.0F);
    if (this.mDrawerIndicatorEnabled) {
      setActionBarDescription(this.mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    float f = this.mSlider.getPosition();
    if (paramFloat <= 0.5F) {
      f = Math.min(f, paramFloat * 2.0F);
    } else {
      f = Math.max(f, 2.0F * Math.max(0.0F, paramFloat - 0.5F));
    }
    this.mSlider.setPosition(f);
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    if ((paramMenuItem == null) || (paramMenuItem.getItemId() != 16908332) || (!this.mDrawerIndicatorEnabled))
    {
      bool = false;
    }
    else
    {
      if (!this.mDrawerLayout.isDrawerVisible(8388611)) {
        this.mDrawerLayout.openDrawer(8388611);
      } else {
        this.mDrawerLayout.closeDrawer(8388611);
      }
      bool = true;
    }
    return bool;
  }
  
  void setActionBarDescription(int paramInt)
  {
    if (this.mActivityImpl == null) {
      this.mSetIndicatorInfo = IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, paramInt);
    } else {
      this.mActivityImpl.setActionBarDescription(paramInt);
    }
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if (this.mActivityImpl == null) {
      this.mSetIndicatorInfo = IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, paramDrawable, paramInt);
    } else {
      this.mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
    }
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.mDrawerIndicatorEnabled)
    {
      if (!paramBoolean)
      {
        setActionBarUpIndicator(this.mThemeImage, 0);
      }
      else
      {
        SlideDrawable localSlideDrawable = this.mSlider;
        int i;
        if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
          i = this.mOpenDrawerContentDescRes;
        } else {
          i = this.mCloseDrawerContentDescRes;
        }
        setActionBarUpIndicator(localSlideDrawable, i);
      }
      this.mDrawerIndicatorEnabled = paramBoolean;
    }
  }
  
  public void syncState()
  {
    if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
      this.mSlider.setPosition(0.0F);
    } else {
      this.mSlider.setPosition(1.0F);
    }
    if (this.mDrawerIndicatorEnabled)
    {
      SlideDrawable localSlideDrawable = this.mSlider;
      int i;
      if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
        i = this.mOpenDrawerContentDescRes;
      } else {
        i = this.mCloseDrawerContentDescRes;
      }
      setActionBarUpIndicator(localSlideDrawable, i);
    }
  }
  
  private class SlideDrawable
    extends InsetDrawable
    implements Drawable.Callback
  {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    
    private SlideDrawable(Drawable paramDrawable)
    {
      super(0);
      if (Build.VERSION.SDK_INT > 18) {
        bool = true;
      }
      this.mHasMirroring = bool;
      this.mTmpRect = new Rect();
    }
    
    public void draw(Canvas paramCanvas)
    {
      int j = 1;
      copyBounds(this.mTmpRect);
      paramCanvas.save();
      int k;
      if (ViewCompat.getLayoutDirection(ActionBarDrawerToggle.this.mActivity.getWindow().getDecorView()) != j) {
        k = 0;
      } else {
        k = j;
      }
      if (k != 0) {
        j = -1;
      }
      int i = this.mTmpRect.width();
      paramCanvas.translate(-this.mOffset * i * this.mPosition * j, 0.0F);
      if ((k != 0) && (!this.mHasMirroring))
      {
        paramCanvas.translate(i, 0.0F);
        paramCanvas.scale(-1.0F, 1.0F);
      }
      super.draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public float getPosition()
    {
      return this.mPosition;
    }
    
    public void setOffset(float paramFloat)
    {
      this.mOffset = paramFloat;
      invalidateSelf();
    }
    
    public void setPosition(float paramFloat)
    {
      this.mPosition = paramFloat;
      invalidateSelf();
    }
  }
  
  private static class ActionBarDrawerToggleImplHC
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(paramActivity);
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return ActionBarDrawerToggleHoneycomb.setActionBarDescription(paramObject, paramActivity, paramInt);
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(paramObject, paramActivity, paramDrawable, paramInt);
    }
  }
  
  private static class ActionBarDrawerToggleImplBase
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return null;
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return paramObject;
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return paramObject;
    }
  }
  
  private static abstract interface ActionBarDrawerToggleImpl
  {
    public abstract Drawable getThemeUpIndicator(Activity paramActivity);
    
    public abstract Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt);
    
    public abstract Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt);
  }
  
  public static abstract interface Delegate
  {
    public abstract Drawable getThemeUpIndicator();
    
    public abstract void setActionBarDescription(int paramInt);
    
    public abstract void setActionBarUpIndicator(Drawable paramDrawable, int paramInt);
  }
  
  public static abstract interface DelegateProvider
  {
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle
 * JD-Core Version:    0.7.0.1
 */