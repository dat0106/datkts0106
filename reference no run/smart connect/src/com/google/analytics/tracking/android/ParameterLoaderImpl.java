package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

class ParameterLoaderImpl
  implements ParameterLoader
{
  private final Context mContext;
  
  public ParameterLoaderImpl(Context paramContext)
  {
    if (paramContext != null)
    {
      this.mContext = paramContext.getApplicationContext();
      return;
    }
    throw new NullPointerException("Context cannot be null");
  }
  
  private int getResourceIdForType(String paramString1, String paramString2)
  {
    int i;
    if (this.mContext != null) {
      i = this.mContext.getResources().getIdentifier(paramString1, paramString2, this.mContext.getPackageName());
    } else {
      i = 0;
    }
    return i;
  }
  
  public boolean getBoolean(String paramString)
  {
    int i = getResourceIdForType(paramString, "bool");
    boolean bool;
    if (i != 0) {
      bool = "true".equalsIgnoreCase(this.mContext.getString(i));
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Double getDoubleFromString(String paramString)
  {
    Double localDouble = null;
    String str = getString(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return localDouble;
      try
      {
        localDouble = Double.valueOf(Double.parseDouble(str));
        localDouble = localDouble;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.w("NumberFormatException parsing " + str);
      }
    }
  }
  
  public int getInt(String paramString, int paramInt)
  {
    int i = getResourceIdForType(paramString, "integer");
    if (i == 0) {}
    for (;;)
    {
      return paramInt;
      try
      {
        i = Integer.parseInt(this.mContext.getString(i));
        paramInt = i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.w("NumberFormatException parsing " + this.mContext.getString(i));
      }
    }
  }
  
  public String getString(String paramString)
  {
    int i = getResourceIdForType(paramString, "string");
    String str;
    if (i != 0) {
      str = this.mContext.getString(i);
    } else {
      str = null;
    }
    return str;
  }
  
  public boolean isBooleanKeyPresent(String paramString)
  {
    boolean bool;
    if (getResourceIdForType(paramString, "bool") == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.ParameterLoaderImpl
 * JD-Core Version:    0.7.0.1
 */