package com.actionbarsherlock.internal.nineoldandroids.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;

public abstract class NineViewGroup
  extends ViewGroup
{
  private final AnimatorProxy mProxy;
  
  public NineViewGroup(Context paramContext)
  {
    super(paramContext);
    AnimatorProxy localAnimatorProxy;
    if (!AnimatorProxy.NEEDS_PROXY) {
      localAnimatorProxy = null;
    } else {
      localAnimatorProxy = AnimatorProxy.wrap(this);
    }
    this.mProxy = localAnimatorProxy;
  }
  
  public NineViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AnimatorProxy localAnimatorProxy;
    if (!AnimatorProxy.NEEDS_PROXY) {
      localAnimatorProxy = null;
    } else {
      localAnimatorProxy = AnimatorProxy.wrap(this);
    }
    this.mProxy = localAnimatorProxy;
  }
  
  public NineViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AnimatorProxy localAnimatorProxy;
    if (!AnimatorProxy.NEEDS_PROXY) {
      localAnimatorProxy = null;
    } else {
      localAnimatorProxy = AnimatorProxy.wrap(this);
    }
    this.mProxy = localAnimatorProxy;
  }
  
  public float getAlpha()
  {
    float f;
    if (!AnimatorProxy.NEEDS_PROXY) {
      f = super.getAlpha();
    } else {
      f = this.mProxy.getAlpha();
    }
    return f;
  }
  
  public float getTranslationX()
  {
    float f;
    if (!AnimatorProxy.NEEDS_PROXY) {
      f = super.getTranslationX();
    } else {
      f = this.mProxy.getTranslationX();
    }
    return f;
  }
  
  public float getTranslationY()
  {
    float f;
    if (!AnimatorProxy.NEEDS_PROXY) {
      f = super.getTranslationY();
    } else {
      f = this.mProxy.getTranslationY();
    }
    return f;
  }
  
  public void setAlpha(float paramFloat)
  {
    if (!AnimatorProxy.NEEDS_PROXY) {
      super.setAlpha(paramFloat);
    } else {
      this.mProxy.setAlpha(paramFloat);
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    if (!AnimatorProxy.NEEDS_PROXY) {
      super.setTranslationX(paramFloat);
    } else {
      this.mProxy.setTranslationX(paramFloat);
    }
  }
  
  public void setTranslationY(float paramFloat)
  {
    if (!AnimatorProxy.NEEDS_PROXY) {
      super.setTranslationY(paramFloat);
    } else {
      this.mProxy.setTranslationY(paramFloat);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.mProxy != null) {
      if (paramInt != 8)
      {
        if (paramInt == 0) {
          setAnimation(this.mProxy);
        }
      }
      else {
        clearAnimation();
      }
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.nineoldandroids.view.NineViewGroup
 * JD-Core Version:    0.7.0.1
 */