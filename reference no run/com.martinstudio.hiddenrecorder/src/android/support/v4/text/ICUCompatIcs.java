package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ICUCompatIcs
{
  private static final String TAG = "ICUCompatIcs";
  private static Method sAddLikelySubtagsMethod;
  private static Method sGetScriptMethod;
  
  static
  {
    try
    {
      Class localClass = Class.forName("libcore.icu.ICU");
      if (localClass != null)
      {
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = String.class;
        sGetScriptMethod = localClass.getMethod("getScript", arrayOfClass);
        arrayOfClass = new Class[1];
        arrayOfClass[0] = String.class;
        sAddLikelySubtagsMethod = localClass.getMethod("addLikelySubtags", arrayOfClass);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", localException);
      }
    }
  }
  
  public static String addLikelySubtags(String paramString)
  {
    try
    {
      if (sAddLikelySubtagsMethod != null)
      {
        Object localObject = new Object[1];
        localObject[0] = paramString;
        localObject = (String)sAddLikelySubtagsMethod.invoke(null, (Object[])localObject);
        return localObject;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", localIllegalAccessException);
        String str = paramString;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", localInvocationTargetException);
      }
    }
  }
  
  public static String getScript(String paramString)
  {
    try
    {
      if (sGetScriptMethod != null)
      {
        Object localObject1 = new Object[1];
        localObject1[0] = paramString;
        localObject1 = (String)sGetScriptMethod.invoke(null, (Object[])localObject1);
        return localObject1;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", localIllegalAccessException);
        Object localObject2 = null;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", localInvocationTargetException);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompatIcs
 * JD-Core Version:    0.7.0.1
 */