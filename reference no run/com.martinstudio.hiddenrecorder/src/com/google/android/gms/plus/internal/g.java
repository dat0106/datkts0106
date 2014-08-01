package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hn;
import com.google.android.gms.plus.PlusOneDummyView;

public final class g
{
  private static Context aag;
  private static c abP;
  
  private static c H(Context paramContext)
    throws g.a
  {
    hn.f(paramContext);
    ClassLoader localClassLoader;
    if (abP == null)
    {
      if (aag == null)
      {
        aag = GooglePlayServicesUtil.getRemoteContext(paramContext);
        if (aag == null) {
          throw new a("Could not get remote context.");
        }
      }
      localClassLoader = aag.getClassLoader();
    }
    try
    {
      abP = c.a.bl((IBinder)localClassLoader.loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
      return abP;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new a("Could not load creator class.");
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new a("Could not instantiate creator.");
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a("Could not access creator.");
    }
  }
  
  public static View a(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Object localObject;
    if (paramString == null) {
      try
      {
        throw new NullPointerException();
      }
      catch (Exception localException)
      {
        localObject = new PlusOneDummyView(paramContext, paramInt1);
      }
    }
    for (;;)
    {
      return localObject;
      localObject = (View)e.e(H(paramContext).a(e.h(paramContext), paramInt1, paramInt2, paramString, paramInt3));
    }
  }
  
  public static class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.g
 * JD-Core Version:    0.7.0.1
 */