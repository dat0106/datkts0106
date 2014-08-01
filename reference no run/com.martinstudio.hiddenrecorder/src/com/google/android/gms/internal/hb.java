package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class hb
  implements SafeParcelable
{
  private static final Object FU = new Object();
  private static ClassLoader FV = null;
  private static Integer FW = null;
  private boolean FX = false;
  
  private static boolean a(Class<?> paramClass)
  {
    boolean bool = false;
    try
    {
      bool = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      bool = bool;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label20;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label20:
      break label20;
    }
    return bool;
  }
  
  protected static boolean aA(String paramString)
  {
    ClassLoader localClassLoader = fk();
    boolean bool;
    if (localClassLoader == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = a(bool.loadClass(paramString));
        bool = bool;
      }
      catch (Exception localException)
      {
        bool = false;
      }
    }
  }
  
  protected static ClassLoader fk()
  {
    synchronized (FU)
    {
      ClassLoader localClassLoader = FV;
      return localClassLoader;
    }
  }
  
  protected static Integer fl()
  {
    synchronized (FU)
    {
      Integer localInteger = FW;
      return localInteger;
    }
  }
  
  protected boolean fm()
  {
    return this.FX;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hb
 * JD-Core Version:    0.7.0.1
 */