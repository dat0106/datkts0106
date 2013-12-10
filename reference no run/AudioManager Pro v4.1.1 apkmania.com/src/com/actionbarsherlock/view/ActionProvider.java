package com.actionbarsherlock.view;

import android.content.Context;
import android.view.View;

public abstract class ActionProvider
{
  private SubUiVisibilityListener mSubUiVisibilityListener;
  
  public ActionProvider(Context paramContext) {}
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public abstract View onCreateActionView();
  
  public boolean onPerformDefaultAction()
  {
    return false;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu) {}
  
  public void setSubUiVisibilityListener(SubUiVisibilityListener paramSubUiVisibilityListener)
  {
    this.mSubUiVisibilityListener = paramSubUiVisibilityListener;
  }
  
  public void subUiVisibilityChanged(boolean paramBoolean)
  {
    if (this.mSubUiVisibilityListener != null) {
      this.mSubUiVisibilityListener.onSubUiVisibilityChanged(paramBoolean);
    }
  }
  
  public static abstract interface SubUiVisibilityListener
  {
    public abstract void onSubUiVisibilityChanged(boolean paramBoolean);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.view.ActionProvider
 * JD-Core Version:    0.7.0.1
 */