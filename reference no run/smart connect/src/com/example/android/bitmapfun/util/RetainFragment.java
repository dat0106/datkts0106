package com.example.android.bitmapfun.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class RetainFragment
  extends Fragment
{
  private static final String TAG = "RetainFragment";
  private Object mObject;
  
  public static RetainFragment findOrCreateRetainFragment(FragmentManager paramFragmentManager)
  {
    RetainFragment localRetainFragment = (RetainFragment)paramFragmentManager.findFragmentByTag("RetainFragment");
    if (localRetainFragment == null)
    {
      localRetainFragment = new RetainFragment();
      paramFragmentManager.beginTransaction().add(localRetainFragment, "RetainFragment").commitAllowingStateLoss();
    }
    return localRetainFragment;
  }
  
  public Object getObject()
  {
    return this.mObject;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public void setObject(Object paramObject)
  {
    this.mObject = paramObject;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.example.android.bitmapfun.util.RetainFragment
 * JD-Core Version:    0.7.0.1
 */