package com.astuetz.viewpager.extensions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;

public class ViewPagerTabButton
  extends Button
{
  private static final String TAG = "com.astuetz.viewpager.extensions";
  private int mLineColor = -9465913;
  private int mLineColorSelected = -9465913;
  private int mLineHeight = 2;
  private int mLineHeightSelected = 6;
  private Paint mLinePaint = new Paint();
  
  public ViewPagerTabButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerTabButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerTabButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mLineHeight = ((int)TypedValue.applyDimension(1, this.mLineHeight, paramContext.getResources().getDisplayMetrics()));
    this.mLineHeightSelected = ((int)TypedValue.applyDimension(1, this.mLineHeightSelected, paramContext.getResources().getDisplayMetrics()));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerExtensions, paramInt, 0);
    this.mLineColor = localTypedArray.getColor(3, this.mLineColor);
    this.mLineColorSelected = localTypedArray.getColor(4, this.mLineColorSelected);
    this.mLineHeight = localTypedArray.getDimensionPixelSize(5, this.mLineHeight);
    this.mLineHeightSelected = localTypedArray.getDimensionPixelSize(6, this.mLineHeightSelected);
    localTypedArray.recycle();
  }
  
  public int getLineColor()
  {
    return this.mLineColor;
  }
  
  public int getLineColorSelected()
  {
    return this.mLineColorSelected;
  }
  
  public int getLineHeight()
  {
    return this.mLineHeight;
  }
  
  public int getLineHeightSelected()
  {
    return this.mLineHeightSelected;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  protected void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 89	android/widget/Button:onDraw	(Landroid/graphics/Canvas;)V
    //   7: aload_0
    //   8: getfield 40	com/astuetz/viewpager/extensions/ViewPagerTabButton:mLinePaint	Landroid/graphics/Paint;
    //   11: astore_2
    //   12: aload_0
    //   13: invokevirtual 93	com/astuetz/viewpager/extensions/ViewPagerTabButton:isSelected	()Z
    //   16: ifeq +52 -> 68
    //   19: aload_0
    //   20: getfield 29	com/astuetz/viewpager/extensions/ViewPagerTabButton:mLineColorSelected	I
    //   23: istore_3
    //   24: aload_2
    //   25: iload_3
    //   26: invokevirtual 97	android/graphics/Paint:setColor	(I)V
    //   29: aload_0
    //   30: invokevirtual 93	com/astuetz/viewpager/extensions/ViewPagerTabButton:isSelected	()Z
    //   33: ifeq +43 -> 76
    //   36: aload_0
    //   37: getfield 33	com/astuetz/viewpager/extensions/ViewPagerTabButton:mLineHeightSelected	I
    //   40: istore_3
    //   41: aload_1
    //   42: ldc 98
    //   44: aload_0
    //   45: invokevirtual 101	com/astuetz/viewpager/extensions/ViewPagerTabButton:getMeasuredHeight	()I
    //   48: iload_3
    //   49: isub
    //   50: i2f
    //   51: aload_0
    //   52: invokevirtual 104	com/astuetz/viewpager/extensions/ViewPagerTabButton:getMeasuredWidth	()I
    //   55: i2f
    //   56: aload_0
    //   57: invokevirtual 101	com/astuetz/viewpager/extensions/ViewPagerTabButton:getMeasuredHeight	()I
    //   60: i2f
    //   61: aload_2
    //   62: invokevirtual 110	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: getfield 27	com/astuetz/viewpager/extensions/ViewPagerTabButton:mLineColor	I
    //   72: istore_3
    //   73: goto -49 -> 24
    //   76: aload_0
    //   77: getfield 31	com/astuetz/viewpager/extensions/ViewPagerTabButton:mLineHeight	I
    //   80: istore_3
    //   81: goto -40 -> 41
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ViewPagerTabButton
    //   0	89	1	paramCanvas	android.graphics.Canvas
    //   11	51	2	localPaint	Paint
    //   84	4	2	localObject	java.lang.Object
    //   23	58	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	65	84	finally
    //   68	81	84	finally
  }
  
  public void setLineColor(int paramInt)
  {
    this.mLineColor = paramInt;
    invalidate();
  }
  
  public void setLineColorSelected(int paramInt)
  {
    this.mLineColorSelected = paramInt;
    invalidate();
  }
  
  public void setLineHeight(int paramInt)
  {
    this.mLineHeight = paramInt;
    invalidate();
  }
  
  public void setLineHeightSelected(int paramInt)
  {
    this.mLineHeightSelected = paramInt;
    invalidate();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.viewpager.extensions.ViewPagerTabButton
 * JD-Core Version:    0.7.0.1
 */