package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.hq;
import com.google.android.gms.plus.internal.g;

public final class PlusOneButton
  extends FrameLayout
{
  public static final int ANNOTATION_BUBBLE = 1;
  public static final int ANNOTATION_INLINE = 2;
  public static final int ANNOTATION_NONE = 0;
  public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
  public static final int SIZE_MEDIUM = 1;
  public static final int SIZE_SMALL = 0;
  public static final int SIZE_STANDARD = 3;
  public static final int SIZE_TALL = 2;
  private int abA;
  private OnPlusOneClickListener abB;
  private View aby;
  private int abz;
  private int mSize;
  private String qV;
  
  public PlusOneButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PlusOneButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mSize = getSize(paramContext, paramAttributeSet);
    this.abz = getAnnotation(paramContext, paramAttributeSet);
    this.abA = -1;
    z(getContext());
    if (isInEditMode()) {}
  }
  
  protected static int getAnnotation(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    String str = hq.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if (!"INLINE".equalsIgnoreCase(str))
    {
      if (!"NONE".equalsIgnoreCase(str)) {
        i = 1;
      }
    }
    else {
      i = 2;
    }
    return i;
  }
  
  protected static int getSize(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    String str = hq.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", paramContext, paramAttributeSet, true, false, "PlusOneButton");
    if (!"SMALL".equalsIgnoreCase(str)) {
      if (!"MEDIUM".equalsIgnoreCase(str))
      {
        if (!"TALL".equalsIgnoreCase(str)) {
          i = 3;
        } else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    return i;
  }
  
  private void z(Context paramContext)
  {
    if (this.aby != null) {
      removeView(this.aby);
    }
    this.aby = g.a(paramContext, this.mSize, this.abz, this.qV, this.abA);
    setOnPlusOneClickListener(this.abB);
    addView(this.aby);
  }
  
  public void initialize(String paramString, int paramInt)
  {
    hn.a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
    this.qV = paramString;
    this.abA = paramInt;
    z(getContext());
  }
  
  public void initialize(String paramString, OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.qV = paramString;
    this.abA = 0;
    z(getContext());
    setOnPlusOneClickListener(paramOnPlusOneClickListener);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aby.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.aby;
    measureChild(localView, paramInt1, paramInt2);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setAnnotation(int paramInt)
  {
    this.abz = paramInt;
    z(getContext());
  }
  
  public void setOnPlusOneClickListener(OnPlusOneClickListener paramOnPlusOneClickListener)
  {
    this.abB = paramOnPlusOneClickListener;
    this.aby.setOnClickListener(new DefaultOnPlusOneClickListener(paramOnPlusOneClickListener));
  }
  
  public void setSize(int paramInt)
  {
    this.mSize = paramInt;
    z(getContext());
  }
  
  protected class DefaultOnPlusOneClickListener
    implements View.OnClickListener, PlusOneButton.OnPlusOneClickListener
  {
    private final PlusOneButton.OnPlusOneClickListener abC;
    
    public DefaultOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener paramOnPlusOneClickListener)
    {
      this.abC = paramOnPlusOneClickListener;
    }
    
    public void onClick(View paramView)
    {
      Intent localIntent = (Intent)PlusOneButton.a(PlusOneButton.this).getTag();
      if (this.abC == null) {
        onPlusOneClick(localIntent);
      } else {
        this.abC.onPlusOneClick(localIntent);
      }
    }
    
    public void onPlusOneClick(Intent paramIntent)
    {
      Context localContext = PlusOneButton.this.getContext();
      if (((localContext instanceof Activity)) && (paramIntent != null)) {
        ((Activity)localContext).startActivityForResult(paramIntent, PlusOneButton.b(PlusOneButton.this));
      }
    }
  }
  
  public static abstract interface OnPlusOneClickListener
  {
    public abstract void onPlusOneClick(Intent paramIntent);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.PlusOneButton
 * JD-Core Version:    0.7.0.1
 */