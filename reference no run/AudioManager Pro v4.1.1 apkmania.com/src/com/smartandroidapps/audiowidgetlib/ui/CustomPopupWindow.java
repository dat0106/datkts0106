package com.smartandroidapps.audiowidgetlib.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.smartandroidapps.audiowidgetlib.R.style;

public class CustomPopupWindow
{
  protected final View anchor;
  private Drawable background = null;
  private View root;
  protected final PopupWindow window;
  protected final WindowManager windowManager;
  
  public CustomPopupWindow(View paramView)
  {
    this.anchor = paramView;
    this.window = new PopupWindow(paramView.getContext());
    this.window.setTouchInterceptor(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        boolean bool;
        if (paramAnonymousMotionEvent.getAction() != 4)
        {
          bool = false;
        }
        else
        {
          CustomPopupWindow.this.window.dismiss();
          bool = true;
        }
        return bool;
      }
    });
    this.windowManager = ((WindowManager)paramView.getContext().getSystemService("window"));
    onCreate();
  }
  
  public void dismiss()
  {
    this.window.dismiss();
  }
  
  protected void onCreate() {}
  
  protected void onShow() {}
  
  protected void preShow()
  {
    if (this.root != null)
    {
      onShow();
      if (this.background != null) {
        this.window.setBackgroundDrawable(this.background);
      } else {
        this.window.setBackgroundDrawable(new BitmapDrawable());
      }
      this.window.setWidth(-2);
      this.window.setHeight(-2);
      this.window.setTouchable(true);
      this.window.setFocusable(true);
      this.window.setOutsideTouchable(true);
      this.window.setContentView(this.root);
      return;
    }
    throw new IllegalStateException("setContentView was not called with a view to display.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.background = paramDrawable;
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(((LayoutInflater)this.anchor.getContext().getSystemService("layout_inflater")).inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    this.root = paramView;
    this.window.setContentView(paramView);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.window.setOnDismissListener(paramOnDismissListener);
  }
  
  public void showDropDown()
  {
    showDropDown(0, 0);
  }
  
  public void showDropDown(int paramInt1, int paramInt2)
  {
    preShow();
    this.window.setAnimationStyle(R.style.Animations_PopDownMenu);
    this.window.showAsDropDown(this.anchor, paramInt1, paramInt2);
  }
  
  public void showLikeQuickAction()
  {
    showLikeQuickAction(0, 0);
  }
  
  public void showLikeQuickAction(int paramInt1, int paramInt2)
  {
    preShow();
    this.window.setAnimationStyle(R.style.Animations_PopUpMenu_Center);
    Object localObject = new int[2];
    this.anchor.getLocationOnScreen((int[])localObject);
    localObject = new Rect(localObject[0], localObject[1], localObject[0] + this.anchor.getWidth(), localObject[1] + this.anchor.getHeight());
    this.root.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.root.measure(-2, -2);
    int j = this.root.getMeasuredWidth();
    int i = this.root.getMeasuredHeight();
    j = paramInt1 + (this.windowManager.getDefaultDisplay().getWidth() - j) / 2;
    int k = paramInt2 + (((Rect)localObject).top - i);
    if (i > ((Rect)localObject).top)
    {
      k = paramInt2 + ((Rect)localObject).bottom;
      this.window.setAnimationStyle(R.style.Animations_PopDownMenu_Center);
    }
    this.window.showAtLocation(this.anchor, 0, j, k);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.ui.CustomPopupWindow
 * JD-Core Version:    0.7.0.1
 */