package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class mg
{
  private static void a(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException, InvocationTargetException
  {
    if (paramObject == null) {
      return;
    }
    int i;
    Object localObject1;
    int k;
    Object localObject3;
    String str;
    if ((paramObject instanceof mf))
    {
      i = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(cA(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      localObject1 = paramObject.getClass();
      Object localObject2 = ((Class)localObject1).getFields();
      int j = localObject2.length;
      k = 0;
      if (k < j)
      {
        localObject3 = localObject2[k];
        int m = ((Field)localObject3).getModifiers();
        str = ((Field)localObject3).getName();
        if (((m & 0x1) == 1) && ((m & 0x8) != 8) && (!str.startsWith("_")) && (!str.endsWith("_")))
        {
          Class localClass = ((Field)localObject3).getType();
          localObject3 = ((Field)localObject3).get(paramObject);
          if (!localClass.isArray()) {
            break label231;
          }
          if (localClass.getComponentType() != Byte.TYPE) {
            break label183;
          }
          a(str, localObject3, paramStringBuffer1, paramStringBuffer2);
        }
        for (;;)
        {
          k++;
          break;
          label183:
          if (localObject3 == null) {}
          for (int n = 0;; n = Array.getLength(localObject3))
          {
            for (int i1 = 0; i1 < n; i1++) {
              a(str, Array.get(localObject3, i1), paramStringBuffer1, paramStringBuffer2);
            }
            break;
          }
          label231:
          a(str, localObject3, paramStringBuffer1, paramStringBuffer2);
        }
      }
      localObject2 = ((Class)localObject1).getMethods();
      j = localObject2.length;
      k = 0;
      label258:
      if (k < j)
      {
        str = localObject2[k].getName();
        if (str.startsWith("set")) {
          str = str.substring(3);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = ((Class)localObject1).getMethod("has" + str, new Class[0]);
        if (((Boolean)((Method)localObject3).invoke(paramObject, new Object[0])).booleanValue()) {
          continue;
        }
        k++;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        continue;
      }
      break label258;
      try
      {
        localObject3 = ((Class)localObject1).getMethod("get" + str, new Class[0]);
        a(str, ((Method)localObject3).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
      }
      catch (NoSuchMethodException localNoSuchMethodException1) {}
      if (paramString == null) {
        break;
      }
      paramStringBuffer1.setLength(i);
      paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      break;
      localObject1 = cA(paramString);
      paramStringBuffer2.append(paramStringBuffer1).append((String)localObject1).append(": ");
      if ((paramObject instanceof String))
      {
        localObject1 = cB((String)paramObject);
        paramStringBuffer2.append("\"").append((String)localObject1).append("\"");
        paramStringBuffer2.append("\n");
        break;
      }
      if ((paramObject instanceof byte[])) {
        a((byte[])paramObject, paramStringBuffer2);
      } else {
        paramStringBuffer2.append(paramObject);
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte != null)
    {
      paramStringBuffer.append('"');
      for (int j = 0;; j++)
      {
        if (j >= paramArrayOfByte.length)
        {
          paramStringBuffer.append('"');
          break;
        }
        int i = paramArrayOfByte[j];
        if ((i != 92) && (i != 34))
        {
          if ((i < 32) || (i >= 127))
          {
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Integer.valueOf(i);
            paramStringBuffer.append(String.format("\\%03o", arrayOfObject));
          }
          else
          {
            paramStringBuffer.append(i);
          }
        }
        else {
          paramStringBuffer.append('\\').append(i);
        }
      }
    }
    paramStringBuffer.append("\"\"");
  }
  
  private static String aK(String paramString)
  {
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localStringBuilder.toString();
      }
      char c = paramString.charAt(j);
      if ((c < ' ') || (c > '~') || (c == '"') || (c == '\''))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(c);
        localStringBuilder.append(String.format("\\u%04x", arrayOfObject));
      }
      else
      {
        localStringBuilder.append(c);
      }
    }
  }
  
  private static String cA(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0;; i++)
    {
      if (i >= paramString.length()) {
        return localStringBuffer.toString();
      }
      char c = paramString.charAt(i);
      if (i != 0)
      {
        if (!Character.isUpperCase(c)) {
          localStringBuffer.append(c);
        } else {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        }
      }
      else {
        localStringBuffer.append(Character.toLowerCase(c));
      }
    }
  }
  
  private static String cB(String paramString)
  {
    if ((!paramString.startsWith("http")) && (paramString.length() > 200)) {
      paramString = paramString.substring(0, 200) + "[...]";
    }
    return aK(paramString);
  }
  
  public static <T extends mf> String e(T paramT)
  {
    Object localObject;
    if (paramT == null) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      localObject = new StringBuffer();
      try
      {
        a(null, paramT, new StringBuffer(), (StringBuffer)localObject);
        localObject = ((StringBuffer)localObject).toString();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        String str1 = "Error printing proto: " + localIllegalAccessException.getMessage();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        String str2 = "Error printing proto: " + localInvocationTargetException.getMessage();
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mg
 * JD-Core Version:    0.7.0.1
 */