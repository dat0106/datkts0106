package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class go
{
  private static boolean Ci = false;
  private boolean Cj;
  private boolean Ck;
  private String Cl;
  private final String mTag;
  
  public go(String paramString)
  {
    this(paramString, en());
  }
  
  public go(String paramString, boolean paramBoolean)
  {
    this.mTag = paramString;
    this.Cj = paramBoolean;
    this.Ck = false;
  }
  
  private String e(String paramString, Object... paramVarArgs)
  {
    String str = String.format(paramString, paramVarArgs);
    if (!TextUtils.isEmpty(this.Cl)) {
      str = this.Cl + str;
    }
    return str;
  }
  
  public static boolean en()
  {
    return Ci;
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    if (em()) {
      Log.v(this.mTag, e(paramString, paramVarArgs));
    }
  }
  
  public void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if ((el()) || (Ci)) {
      Log.d(this.mTag, e(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void ap(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = new Object[1];
      localObject[0] = paramString;
      localObject = String.format("[%s] ", (Object[])localObject);
    }
    else
    {
      localObject = null;
    }
    this.Cl = ((String)localObject);
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    if ((el()) || (Ci)) {
      Log.d(this.mTag, e(paramString, paramVarArgs));
    }
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    Log.i(this.mTag, e(paramString, paramVarArgs));
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    Log.w(this.mTag, e(paramString, paramVarArgs));
  }
  
  public boolean el()
  {
    return this.Cj;
  }
  
  public boolean em()
  {
    return this.Ck;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.go
 * JD-Core Version:    0.7.0.1
 */