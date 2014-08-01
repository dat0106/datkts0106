package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.google.android.gms.internal.iq;
import java.lang.ref.WeakReference;

public class PopupManager
{
  protected GamesClientImpl OV;
  protected PopupLocationInfo OW;
  
  private PopupManager(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    this.OV = paramGamesClientImpl;
    cl(paramInt);
  }
  
  public static PopupManager a(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    Object localObject;
    if (!iq.fY()) {
      localObject = new PopupManager(paramGamesClientImpl, paramInt);
    } else {
      localObject = new PopupManagerHCMR1(paramGamesClientImpl, paramInt);
    }
    return localObject;
  }
  
  protected void cl(int paramInt)
  {
    this.OW = new PopupLocationInfo(paramInt, new Binder(), null);
  }
  
  public void g(View paramView) {}
  
  public void hG()
  {
    this.OV.a(this.OW.OX, this.OW.hJ());
  }
  
  public Bundle hH()
  {
    return this.OW.hJ();
  }
  
  public IBinder hI()
  {
    return this.OW.OX;
  }
  
  public void setGravity(int paramInt)
  {
    this.OW.gravity = paramInt;
  }
  
  public static final class PopupLocationInfo
  {
    public IBinder OX;
    public int OY = -1;
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    
    private PopupLocationInfo(int paramInt, IBinder paramIBinder)
    {
      this.gravity = paramInt;
      this.OX = paramIBinder;
    }
    
    public Bundle hJ()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("popupLocationInfo.gravity", this.gravity);
      localBundle.putInt("popupLocationInfo.displayId", this.OY);
      localBundle.putInt("popupLocationInfo.left", this.left);
      localBundle.putInt("popupLocationInfo.top", this.top);
      localBundle.putInt("popupLocationInfo.right", this.right);
      localBundle.putInt("popupLocationInfo.bottom", this.bottom);
      return localBundle;
    }
  }
  
  private static final class PopupManagerHCMR1
    extends PopupManager
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
  {
    private boolean Ns = false;
    private WeakReference<View> OZ;
    
    protected PopupManagerHCMR1(GamesClientImpl paramGamesClientImpl, int paramInt)
    {
      super(paramInt, null);
    }
    
    private void h(View paramView)
    {
      int i = -1;
      if (iq.gc())
      {
        localObject = paramView.getDisplay();
        if (localObject != null) {
          i = ((Display)localObject).getDisplayId();
        }
      }
      Object localObject = paramView.getWindowToken();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      this.OW.OY = i;
      this.OW.OX = ((IBinder)localObject);
      this.OW.left = arrayOfInt[0];
      this.OW.top = arrayOfInt[1];
      this.OW.right = (j + arrayOfInt[0]);
      this.OW.bottom = (k + arrayOfInt[1]);
      if (this.Ns)
      {
        hG();
        this.Ns = false;
      }
    }
    
    protected void cl(int paramInt)
    {
      this.OW = new PopupManager.PopupLocationInfo(paramInt, null, null);
    }
    
    public void g(View paramView)
    {
      this.OV.hr();
      Object localObject;
      if (this.OZ != null)
      {
        localObject = (View)this.OZ.get();
        localContext = this.OV.getContext();
        if ((localObject == null) && ((localContext instanceof Activity))) {
          localObject = ((Activity)localContext).getWindow().getDecorView();
        }
        if (localObject != null)
        {
          ((View)localObject).removeOnAttachStateChangeListener(this);
          localObject = ((View)localObject).getViewTreeObserver();
          if (!iq.gb()) {
            ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this);
          } else {
            ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(this);
          }
        }
      }
      this.OZ = null;
      Context localContext = this.OV.getContext();
      if ((paramView == null) && ((localContext instanceof Activity)))
      {
        localObject = ((Activity)localContext).findViewById(16908290);
        if (localObject == null) {
          localObject = ((Activity)localContext).getWindow().getDecorView();
        }
        GamesLog.j("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
        paramView = (View)localObject;
      }
      if (paramView == null)
      {
        GamesLog.k("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
      }
      else
      {
        h(paramView);
        this.OZ = new WeakReference(paramView);
        paramView.addOnAttachStateChangeListener(this);
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
      }
    }
    
    public void hG()
    {
      if (this.OW.OX == null)
      {
        boolean bool;
        if (this.OZ == null) {
          bool = false;
        } else {
          bool = true;
        }
        this.Ns = bool;
      }
      else
      {
        super.hG();
      }
    }
    
    public void onGlobalLayout()
    {
      if (this.OZ != null)
      {
        View localView = (View)this.OZ.get();
        if (localView != null) {
          h(localView);
        }
      }
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      h(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      this.OV.hr();
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.PopupManager
 * JD-Core Version:    0.7.0.1
 */