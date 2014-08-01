

android.app.ActionBar
android.app.Activity
android.content.res.TypedArray
android.graphics.drawable.Drawable
android.util.Log
android.view.View
android.view.ViewGroup
android.widget.ImageView
java.lang.reflect.Method

ActionBarDrawerToggleHoneycomb

  TAG = "ActionBarDrawerToggleHoneycomb"
  []THEME_ATTRS
  
  static
  
    [] = 1
    0 = 16843531
    THEME_ATTRS = 
  
  
  getThemeUpIndicator
  
     = obtainStyledAttributesTHEME_ATTRS
     = getDrawable0
    recycle()
    
  
  
  setActionBarDescription, , 
  
     (== {
       = 
    
     = 
     (setHomeAsUpIndicator != null) {}
    try
    {
      ActionBar localActionBar = paramActivity.getActionBar();
      localObject = ((SetIndicatorInfo)localObject).setHomeActionContentDescription;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      ((Method)localObject).invoke(localActionBar, arrayOfObject);
      return paramObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", localException);
      }
    }
  }
  
  public static Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
  {
    if (paramObject == null) {
      paramObject = new SetIndicatorInfo(paramActivity);
    }
    Object localObject1 = (SetIndicatorInfo)paramObject;
    if (((SetIndicatorInfo)localObject1).setHomeAsUpIndicator != null) {}
    for (;;)
    {
      try
      {
        ActionBar localActionBar = paramActivity.getActionBar();
        Object localObject2 = ((SetIndicatorInfo)localObject1).setHomeAsUpIndicator;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramDrawable;
        ((Method)localObject2).invoke(localActionBar, arrayOfObject);
        localObject1 = ((SetIndicatorInfo)localObject1).setHomeActionContentDescription;
        localObject2 = new Object[1];
        localObject2[0] = Integer.valueOf(paramInt);
        ((Method)localObject1).invoke(localActionBar, (Object[])localObject2);
        return paramObject;
      }
      catch (Exception localException)
      {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", localException);
        continue;
      }
      if (((SetIndicatorInfo)localObject1).upIndicatorView != null) {
        ((SetIndicatorInfo)localObject1).upIndicatorView.setImageDrawable(paramDrawable);
      } else {
        Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
      }
    }
  }
  
  private static class SetIndicatorInfo
  {
    public Method setHomeActionContentDescription;
    public Method setHomeAsUpIndicator;
    public ImageView upIndicatorView;
    
    SetIndicatorInfo(Activity paramActivity)
    {
      label122:
      for (;;)
      {
        Object localObject2;
        try
        {
          localObject1 = new Class[1];
          localObject1[0] = Drawable.class;
          this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", (Class[])localObject1);
          localObject1 = new Class[1];
          localObject1[0] = Integer.TYPE;
          this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", (Class[])localObject1);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          localObject1 = paramActivity.findViewById(16908332);
          if (localObject1 == null) {
            continue;
          }
          localObject2 = (ViewGroup)((View)localObject1).getParent();
          if (((ViewGroup)localObject2).getChildCount() != 2) {
            continue;
          }
          localObject1 = ((ViewGroup)localObject2).getChildAt(0);
          localObject2 = ((ViewGroup)localObject2).getChildAt(1);
          if (((View)localObject1).getId() != 16908332) {}
        }
        for (Object localObject1 = localObject2;; localObject1 = localObject1)
        {
          if (!(localObject1 instanceof ImageView)) {
            break label122;
          }
          this.upIndicatorView = ((ImageView)localObject1);
          break;
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggleHoneycomb
 * JD-Core Version:    0.7.0.1
 */