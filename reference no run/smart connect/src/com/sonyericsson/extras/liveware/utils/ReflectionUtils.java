package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils
{
  public static boolean classExists(String paramString)
  {
    try
    {
      Class.forName(paramString);
      bool = true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public static boolean getResultFromMethod(String paramString1, String paramString2, Context paramContext)
  {
    boolean bool = false;
    try
    {
      Object localObject1 = Class.forName(paramString1);
      Object localObject2 = new Class[1];
      localObject2[0] = Context.class;
      localObject2 = ((Class)localObject1).getConstructor((Class[])localObject2);
      localObject1 = new Object[1];
      localObject1[0] = paramContext;
      localObject1 = ((Constructor)localObject2).newInstance((Object[])localObject1);
      if (localObject1 != null)
      {
        bool = ((Boolean)localObject1.getClass().getMethod(paramString2, new Class[0]).invoke(localObject1, new Object[0])).booleanValue();
        bool = bool;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Dbg.e("ClassNotFoundException when trying to call method " + paramString2 + " on class " + paramString1 + " through reflection.");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Dbg.e("NoSuchMethodException when trying to call method " + paramString2 + " on class " + paramString1 + " through reflection.");
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Dbg.e("IllegalArgumentException when trying to call method " + paramString2 + " on class " + paramString1 + " through reflection.");
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        Dbg.e("InstantiationException when trying to call method " + paramString2 + " on class " + paramString1 + " through reflection.");
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Dbg.e("IllegalAccessException when trying to call method " + paramString2 + " on class " + paramString1 + " through reflection.");
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Dbg.e("InvocationTargetException when trying to call method " + paramString2 + " on class " + paramString1 + " through reflection.");
      }
    }
    return bool;
  }
  
  public static Object getStaticField(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    try
    {
      Object localObject1 = Class.forName(paramString1).getField(paramString2).get(null);
      localObject2 = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.d("Failed to get static field.", localException);
      }
    }
    return localObject2;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.ReflectionUtils
 * JD-Core Version:    0.7.0.1
 */