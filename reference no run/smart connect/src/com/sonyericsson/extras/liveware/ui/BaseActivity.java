package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class BaseActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    if (!AsfUtils.isSonyDevice()) {
      setTheme(2131361940);
    }
    super.onCreate(paramBundle);
    UIUtils.applyDirectionalityToDecorWindow(this);
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(LayoutInflater.from(this).inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    UIUtils.applyDirectionality(paramView);
    super.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    UIUtils.applyDirectionality(paramView);
    super.setContentView(paramView, paramLayoutParams);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */