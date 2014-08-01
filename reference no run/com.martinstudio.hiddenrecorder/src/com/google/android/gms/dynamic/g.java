package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hn;

public abstract class g<T>
{
  private final String Mi;
  private T Mj;
  
  protected g(String paramString)
  {
    this.Mi = paramString;
  }
  
  protected final T D(Context paramContext)
    throws g.a
  {
    Object localObject;
    if (this.Mj == null)
    {
      hn.f(paramContext);
      localObject = GooglePlayServicesUtil.getRemoteContext(paramContext);
      if (localObject == null) {
        throw new a("Could not get remote context.");
      }
      localObject = ((Context)localObject).getClassLoader();
    }
    try
    {
      this.Mj = d((IBinder)((ClassLoader)localObject).loadClass(this.Mi).newInstance());
      return this.Mj;
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
  
  protected abstract T d(IBinder paramIBinder);
  
  public static class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
    
    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.g
 * JD-Core Version:    0.7.0.1
 */