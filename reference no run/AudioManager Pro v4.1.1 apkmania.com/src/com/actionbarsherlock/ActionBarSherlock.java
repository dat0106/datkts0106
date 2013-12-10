package com.actionbarsherlock;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.ActionBarSherlockCompat;
import com.actionbarsherlock.internal.ActionBarSherlockNative;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.MenuInflater;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class ActionBarSherlock
{
  private static final Class<?>[] CONSTRUCTOR_ARGS;
  protected static final boolean DEBUG = false;
  public static final int FLAG_DELEGATE = 1;
  private static final HashMap<Implementation, Class<? extends ActionBarSherlock>> IMPLEMENTATIONS;
  protected static final String TAG = "ActionBarSherlock";
  protected final Activity mActivity;
  protected final boolean mIsDelegate;
  protected MenuInflater mMenuInflater;
  
  static
  {
    Class[] arrayOfClass = new Class[2];
    arrayOfClass[0] = Activity.class;
    arrayOfClass[1] = Integer.TYPE;
    CONSTRUCTOR_ARGS = arrayOfClass;
    IMPLEMENTATIONS = new HashMap();
    registerImplementation(ActionBarSherlockCompat.class);
    registerImplementation(ActionBarSherlockNative.class);
  }
  
  protected ActionBarSherlock(Activity paramActivity, int paramInt)
  {
    this.mActivity = paramActivity;
    boolean bool;
    if ((paramInt & 0x1) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    this.mIsDelegate = bool;
  }
  
  public static void registerImplementation(Class<? extends ActionBarSherlock> paramClass)
  {
    if (paramClass.isAnnotationPresent(Implementation.class))
    {
      if (!IMPLEMENTATIONS.containsValue(paramClass))
      {
        Implementation localImplementation = (Implementation)paramClass.getAnnotation(Implementation.class);
        IMPLEMENTATIONS.put(localImplementation, paramClass);
      }
      return;
    }
    throw new IllegalArgumentException("Class " + paramClass.getSimpleName() + " is not annotated with @Implementation");
  }
  
  public static boolean unregisterImplementation(Class<? extends ActionBarSherlock> paramClass)
  {
    return IMPLEMENTATIONS.values().remove(paramClass);
  }
  
  public static ActionBarSherlock wrap(Activity paramActivity)
  {
    return wrap(paramActivity, 0);
  }
  
  public static ActionBarSherlock wrap(Activity paramActivity, int paramInt)
  {
    Object localObject = new HashMap(IMPLEMENTATIONS);
    int i = 0;
    Iterator localIterator1 = ((HashMap)localObject).keySet().iterator();
    while (localIterator1.hasNext()) {
      if (((Implementation)localIterator1.next()).dpi() == 213) {
        i = 1;
      }
    }
    if (i != 0)
    {
      if (paramActivity.getResources().getDisplayMetrics().densityDpi == 213) {}
      for (int j = 1;; j = 0)
      {
        Iterator localIterator3 = ((HashMap)localObject).keySet().iterator();
        while (localIterator3.hasNext())
        {
          i = ((Implementation)localIterator3.next()).dpi();
          if (((j != 0) && (i != 213)) || ((j == 0) && (i == 213))) {
            localIterator3.remove();
          }
        }
      }
    }
    i = 0;
    Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
    while (localIterator2.hasNext()) {
      if (((Implementation)localIterator2.next()).api() != -1) {
        i = 1;
      }
    }
    if (i != 0)
    {
      int m = Build.VERSION.SDK_INT;
      i = 0;
      localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        int k = ((Implementation)localIterator2.next()).api();
        if (k > m) {
          localIterator2.remove();
        } else if (k > i) {
          i = k;
        }
      }
      localIterator2 = ((HashMap)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        if (((Implementation)localIterator2.next()).api() != i) {
          localIterator2.remove();
        }
      }
    }
    if (((HashMap)localObject).size() > 1) {
      throw new IllegalStateException("More than one implementation matches configuration.");
    }
    if (((HashMap)localObject).isEmpty()) {
      throw new IllegalStateException("No implementations match configuration.");
    }
    localObject = (Class)((HashMap)localObject).values().iterator().next();
    try
    {
      localObject = ((Class)localObject).getConstructor(CONSTRUCTOR_ARGS);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramActivity;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      localObject = (ActionBarSherlock)((Constructor)localObject).newInstance(arrayOfObject);
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException(localNoSuchMethodException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new RuntimeException(localIllegalArgumentException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException(localInvocationTargetException);
    }
  }
  
  public abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  protected final boolean callbackCreateOptionsMenu(com.actionbarsherlock.view.Menu paramMenu)
  {
    boolean bool = true;
    if (!(this.mActivity instanceof OnCreatePanelMenuListener))
    {
      if ((this.mActivity instanceof OnCreateOptionsMenuListener)) {
        bool = ((OnCreateOptionsMenuListener)this.mActivity).onCreateOptionsMenu(paramMenu);
      }
    }
    else {
      bool = ((OnCreatePanelMenuListener)this.mActivity).onCreatePanelMenu(0, paramMenu);
    }
    return bool;
  }
  
  protected final boolean callbackOptionsItemSelected(com.actionbarsherlock.view.MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (!(this.mActivity instanceof OnMenuItemSelectedListener))
    {
      if ((this.mActivity instanceof OnOptionsItemSelectedListener)) {
        bool = ((OnOptionsItemSelectedListener)this.mActivity).onOptionsItemSelected(paramMenuItem);
      }
    }
    else {
      bool = ((OnMenuItemSelectedListener)this.mActivity).onMenuItemSelected(0, paramMenuItem);
    }
    return bool;
  }
  
  protected final boolean callbackPrepareOptionsMenu(com.actionbarsherlock.view.Menu paramMenu)
  {
    boolean bool = true;
    if (!(this.mActivity instanceof OnPreparePanelListener))
    {
      if ((this.mActivity instanceof OnPrepareOptionsMenuListener)) {
        bool = ((OnPrepareOptionsMenuListener)this.mActivity).onPrepareOptionsMenu(paramMenu);
      }
    }
    else {
      bool = ((OnPreparePanelListener)this.mActivity).onPreparePanel(0, null, paramMenu);
    }
    return bool;
  }
  
  public boolean dispatchCloseOptionsMenu()
  {
    return false;
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration) {}
  
  public abstract boolean dispatchCreateOptionsMenu(android.view.Menu paramMenu);
  
  public void dispatchDestroy() {}
  
  public abstract void dispatchInvalidateOptionsMenu();
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean dispatchMenuOpened(int paramInt, android.view.Menu paramMenu)
  {
    return false;
  }
  
  public boolean dispatchOpenOptionsMenu()
  {
    return false;
  }
  
  public abstract boolean dispatchOptionsItemSelected(android.view.MenuItem paramMenuItem);
  
  public void dispatchPanelClosed(int paramInt, android.view.Menu paramMenu) {}
  
  public void dispatchPause() {}
  
  public void dispatchPostCreate(Bundle paramBundle) {}
  
  public void dispatchPostResume() {}
  
  public abstract boolean dispatchPrepareOptionsMenu(android.view.Menu paramMenu);
  
  public void dispatchStop() {}
  
  public void dispatchTitleChanged(CharSequence paramCharSequence, int paramInt) {}
  
  public abstract ActionBar getActionBar();
  
  public MenuInflater getMenuInflater()
  {
    if (this.mMenuInflater == null) {
      if (getActionBar() == null) {
        this.mMenuInflater = new MenuInflater(this.mActivity);
      } else {
        this.mMenuInflater = new MenuInflater(getThemedContext());
      }
    }
    return this.mMenuInflater;
  }
  
  protected abstract Context getThemedContext();
  
  public abstract boolean hasFeature(int paramInt);
  
  public abstract boolean requestFeature(int paramInt);
  
  public abstract void setContentView(int paramInt);
  
  public void setContentView(View paramView)
  {
    setContentView(paramView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void setProgress(int paramInt);
  
  public abstract void setProgressBarIndeterminate(boolean paramBoolean);
  
  public abstract void setProgressBarIndeterminateVisibility(boolean paramBoolean);
  
  public abstract void setProgressBarVisibility(boolean paramBoolean);
  
  public abstract void setSecondaryProgress(int paramInt);
  
  public void setTitle(int paramInt)
  {
    setTitle(this.mActivity.getString(paramInt));
  }
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public abstract void setUiOptions(int paramInt);
  
  public abstract void setUiOptions(int paramInt1, int paramInt2);
  
  public abstract ActionMode startActionMode(ActionMode.Callback paramCallback);
  
  public static abstract interface OnActionModeStartedListener
  {
    public abstract void onActionModeStarted(ActionMode paramActionMode);
  }
  
  public static abstract interface OnActionModeFinishedListener
  {
    public abstract void onActionModeFinished(ActionMode paramActionMode);
  }
  
  public static abstract interface OnPrepareOptionsMenuListener
  {
    public abstract boolean onPrepareOptionsMenu(com.actionbarsherlock.view.Menu paramMenu);
  }
  
  public static abstract interface OnPreparePanelListener
  {
    public abstract boolean onPreparePanel(int paramInt, View paramView, com.actionbarsherlock.view.Menu paramMenu);
  }
  
  public static abstract interface OnOptionsItemSelectedListener
  {
    public abstract boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem paramMenuItem);
  }
  
  public static abstract interface OnMenuItemSelectedListener
  {
    public abstract boolean onMenuItemSelected(int paramInt, com.actionbarsherlock.view.MenuItem paramMenuItem);
  }
  
  public static abstract interface OnCreateOptionsMenuListener
  {
    public abstract boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu paramMenu);
  }
  
  public static abstract interface OnCreatePanelMenuListener
  {
    public abstract boolean onCreatePanelMenu(int paramInt, com.actionbarsherlock.view.Menu paramMenu);
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface Implementation
  {
    public static final int DEFAULT_API = -1;
    public static final int DEFAULT_DPI = -1;
    
    int api() default -1;
    
    int dpi() default -1;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.ActionBarSherlock
 * JD-Core Version:    0.7.0.1
 */