package com.smartandroidapps.audiowidgetlib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

public class CustomImageButton
  extends ImageButton
{
  public CustomImageButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if ((!paramBoolean) || (!(getParent() instanceof View)) || (!((View)getParent()).isPressed())) {
      super.setPressed(paramBoolean);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.ui.CustomImageButton
 * JD-Core Version:    0.7.0.1
 */