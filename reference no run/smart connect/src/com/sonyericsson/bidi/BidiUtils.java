package com.sonyericsson.bidi;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BidiUtils
{
  public static final int DIRECTIONALITY_LEFT_TO_RIGHT = 1;
  public static final int DIRECTIONALITY_NONE = 0;
  private static final String TAG = "BidiUtils";
  private static Method sGetDirectionalityMethod;
  private static Method sHasBackgroundDrawablePaddingMethod;
  private static boolean sReflectionOk;
  private static int sRtlAlphabetField;
  private static Method sSetDirectionalityMethod;
  private static Method sShouldMirrorMethod;
  
  static
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      sSetDirectionalityMethod = ViewGroup.class.getMethod("setDirectionality", arrayOfClass);
      sGetDirectionalityMethod = ViewGroup.class.getMethod("getDirectionality", new Class[0]);
      sShouldMirrorMethod = View.class.getDeclaredMethod("shouldMirror", new Class[0]);
      sShouldMirrorMethod.setAccessible(true);
      sHasBackgroundDrawablePaddingMethod = View.class.getDeclaredMethod("hasBackgroundDrawablePadding", new Class[0]);
      sHasBackgroundDrawablePaddingMethod.setAccessible(true);
      sRtlAlphabetField = Class.forName("com.android.internal.R$bool").getField("alphabet_isRtl").getInt(null);
      sReflectionOk = true;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        sReflectionOk = false;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        sReflectionOk = false;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        sReflectionOk = false;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        sReflectionOk = false;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        sReflectionOk = false;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        sReflectionOk = false;
      }
    }
  }
  
  public static final int getDirectionality(ViewGroup paramViewGroup)
  {
    if (sReflectionOk) {}
    try
    {
      i = ((Integer)sGetDirectionalityMethod.invoke(paramViewGroup, new Object[0])).intValue();
      i = i;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        int i;
        Log.e("BidiUtils", "Failed to invoke setDirectionality", localIllegalArgumentException);
        int j = 0;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("BidiUtils", "Failed to invoke setDirectionality", localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.e("BidiUtils", "Failed to invoke setDirectionality", localInvocationTargetException);
      }
    }
    return i;
  }
  
  public static final boolean isRtlAlphabet(Context paramContext)
  {
    if (sReflectionOk) {}
    for (;;)
    {
      try
      {
        boolean bool = paramContext.getResources().getBoolean(sRtlAlphabetField);
        bool = bool;
        return bool;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Log.e("BidiUtils", "Failed to get RtlAlphabetField", localNotFoundException);
      }
      int i = 0;
    }
  }
  
  public static final void setDirectionality(ViewGroup paramViewGroup, int paramInt)
  {
    if (sReflectionOk) {}
    try
    {
      Method localMethod = sSetDirectionalityMethod;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localMethod.invoke(paramViewGroup, arrayOfObject);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("BidiUtils", "Failed to invoke setDirectionality", localIllegalArgumentException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("BidiUtils", "Failed to invoke setDirectionality", localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.e("BidiUtils", "Failed to invoke setDirectionality", localInvocationTargetException);
      }
    }
  }
  
  public static final boolean shouldMirror(View paramView)
  {
    if (sReflectionOk) {}
    try
    {
      bool = ((Boolean)sShouldMirrorMethod.invoke(paramView, new Object[0])).booleanValue();
      bool = bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        boolean bool;
        Log.e("BidiUtils", "Failed to invoke shouldMirror", localIllegalArgumentException);
        int i = 0;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("BidiUtils", "Failed to invoke shouldMirror", localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.e("BidiUtils", "Failed to invoke shouldMirror", localInvocationTargetException);
      }
    }
    return bool;
  }
  
  public static final boolean shouldMirrorPadding(View paramView)
  {
    if (sReflectionOk) {
      for (;;)
      {
        try
        {
          if (!((Boolean)sShouldMirrorMethod.invoke(paramView, new Object[0])).booleanValue()) {
            continue;
          }
          bool = ((Boolean)sHasBackgroundDrawablePaddingMethod.invoke(paramView, new Object[0])).booleanValue();
          if (bool) {
            continue;
          }
          bool = true;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          boolean bool;
          Log.e("BidiUtils", "Failed to invoke shouldMirrorPadding", localIllegalArgumentException);
          int i = 0;
          continue;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e("BidiUtils", "Failed to invoke shouldMirrorPadding", localIllegalAccessException);
          continue;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.e("BidiUtils", "Failed to invoke shouldMirrorPadding", localInvocationTargetException);
          continue;
        }
        return bool;
        bool = false;
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.bidi.BidiUtils
 * JD-Core Version:    0.7.0.1
 */