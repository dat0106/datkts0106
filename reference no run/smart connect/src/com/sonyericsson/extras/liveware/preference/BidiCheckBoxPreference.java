package com.sonyericsson.extras.liveware.preference;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class BidiCheckBoxPreference
  extends CheckBoxPreference
{
  public BidiCheckBoxPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public BidiCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BidiCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramView, paramViewGroup);
    UIUtils.applyDirectionality(localView);
    return localView;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.preference.BidiCheckBoxPreference
 * JD-Core Version:    0.7.0.1
 */