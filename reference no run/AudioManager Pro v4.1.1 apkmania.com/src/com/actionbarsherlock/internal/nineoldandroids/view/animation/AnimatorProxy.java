package com.actionbarsherlock.internal.nineoldandroids.view.animation;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.FloatMath;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy
  extends Animation
{
  public static final boolean NEEDS_PROXY;
  private static final WeakHashMap<View, AnimatorProxy> PROXIES = new WeakHashMap();
  private final RectF mAfter = new RectF();
  private float mAlpha = 1.0F;
  private final RectF mBefore = new RectF();
  private float mScaleX = 1.0F;
  private float mScaleY = 1.0F;
  private final Matrix mTempMatrix = new Matrix();
  private float mTranslationX;
  private float mTranslationY;
  private final WeakReference<View> mView;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = false;
    } else {
      bool = true;
    }
    NEEDS_PROXY = bool;
  }
  
  private AnimatorProxy(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.mView = new WeakReference(paramView);
  }
  
  private void computeRect(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.mTempMatrix;
    localMatrix.reset();
    transformMatrix(localMatrix, paramView);
    this.mTempMatrix.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    float f;
    if (paramRectF.right < paramRectF.left)
    {
      f = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      f = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f;
    }
  }
  
  private void invalidateAfterUpdate()
  {
    View localView2 = (View)this.mView.get();
    if (localView2 != null)
    {
      View localView1 = (View)localView2.getParent();
      if (localView1 != null)
      {
        localView2.setAnimation(this);
        RectF localRectF = this.mAfter;
        computeRect(localRectF, localView2);
        localRectF.union(this.mBefore);
        localView1.invalidate((int)FloatMath.floor(localRectF.left), (int)FloatMath.floor(localRectF.top), (int)FloatMath.ceil(localRectF.right), (int)FloatMath.ceil(localRectF.bottom));
      }
    }
  }
  
  private void prepareForUpdate()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      computeRect(this.mBefore, localView);
    }
  }
  
  private void transformMatrix(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    float f2 = this.mScaleX;
    float f1 = this.mScaleY;
    if ((f2 != 1.0F) || (f1 != 1.0F))
    {
      f3 = (f2 * f3 - f3) / 2.0F;
      f4 = (f1 * f4 - f4) / 2.0F;
      paramMatrix.postScale(f2, f1);
      paramMatrix.postTranslate(-f3, -f4);
    }
    paramMatrix.postTranslate(this.mTranslationX, this.mTranslationY);
  }
  
  public static AnimatorProxy wrap(View paramView)
  {
    AnimatorProxy localAnimatorProxy = (AnimatorProxy)PROXIES.get(paramView);
    if (localAnimatorProxy == null)
    {
      localAnimatorProxy = new AnimatorProxy(paramView);
      PROXIES.put(paramView, localAnimatorProxy);
    }
    return localAnimatorProxy;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.mAlpha);
      transformMatrix(paramTransformation.getMatrix(), localView);
    }
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getScaleX()
  {
    return this.mScaleX;
  }
  
  public float getScaleY()
  {
    return this.mScaleY;
  }
  
  public int getScrollX()
  {
    View localView = (View)this.mView.get();
    int i;
    if (localView != null) {
      i = localView.getScrollX();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getScrollY()
  {
    View localView = (View)this.mView.get();
    int i;
    if (localView != null) {
      i = localView.getScrollY();
    } else {
      i = 0;
    }
    return i;
  }
  
  public float getTranslationX()
  {
    return this.mTranslationX;
  }
  
  public float getTranslationY()
  {
    return this.mTranslationY;
  }
  
  public void reset() {}
  
  public void setAlpha(float paramFloat)
  {
    if (this.mAlpha != paramFloat)
    {
      this.mAlpha = paramFloat;
      View localView = (View)this.mView.get();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    if (this.mScaleX != paramFloat)
    {
      prepareForUpdate();
      this.mScaleX = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setScaleY(float paramFloat)
  {
    if (this.mScaleY != paramFloat)
    {
      prepareForUpdate();
      this.mScaleY = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setScrollX(int paramInt)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      localView.scrollTo(paramInt, localView.getScrollY());
    }
  }
  
  public void setScrollY(int paramInt)
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      localView.scrollTo(localView.getScrollY(), paramInt);
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    if (this.mTranslationX != paramFloat)
    {
      prepareForUpdate();
      this.mTranslationX = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setTranslationY(float paramFloat)
  {
    if (this.mTranslationY != paramFloat)
    {
      prepareForUpdate();
      this.mTranslationY = paramFloat;
      invalidateAfterUpdate();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy
 * JD-Core Version:    0.7.0.1
 */