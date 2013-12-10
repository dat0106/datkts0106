package com.smartandroidapps.audiowidgetlib.ui;

import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;

public class ActionItem
{
  private Drawable icon;
  private View.OnClickListener listener;
  private String title;
  
  public ActionItem() {}
  
  public ActionItem(Drawable paramDrawable)
  {
    this.icon = paramDrawable;
  }
  
  public Drawable getIcon()
  {
    return this.icon;
  }
  
  public View.OnClickListener getListener()
  {
    return this.listener;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.icon = paramDrawable;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.listener = paramOnClickListener;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.ui.ActionItem
 * JD-Core Version:    0.7.0.1
 */