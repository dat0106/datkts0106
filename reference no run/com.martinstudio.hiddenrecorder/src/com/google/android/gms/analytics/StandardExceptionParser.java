package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StandardExceptionParser
  implements ExceptionParser
{
  private final TreeSet<String> xa = new TreeSet();
  
  public StandardExceptionParser(Context paramContext, Collection<String> paramCollection)
  {
    setIncludedPackages(paramContext, paramCollection);
  }
  
  protected StackTraceElement getBestStackTraceElement(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    StackTraceElement localStackTraceElement;
    if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length != 0))
    {
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      if (i >= j)
      {
        localStackTraceElement = arrayOfStackTraceElement[0];
      }
      else
      {
        localStackTraceElement = arrayOfStackTraceElement[i];
        String str = localStackTraceElement.getClassName();
        Iterator localIterator = this.xa.iterator();
        do
        {
          if (!localIterator.hasNext())
          {
            i++;
            break;
          }
        } while (!str.startsWith((String)localIterator.next()));
        localStackTraceElement = localStackTraceElement;
      }
    }
    else
    {
      localStackTraceElement = null;
    }
    return localStackTraceElement;
  }
  
  protected Throwable getCause(Throwable paramThrowable)
  {
    for (;;)
    {
      if (paramThrowable.getCause() == null) {
        return paramThrowable;
      }
      paramThrowable = paramThrowable.getCause();
    }
  }
  
  public String getDescription(String paramString, Throwable paramThrowable)
  {
    return getDescription(getCause(paramThrowable), getBestStackTraceElement(getCause(paramThrowable)), paramString);
  }
  
  protected String getDescription(Throwable paramThrowable, StackTraceElement paramStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getSimpleName());
    Object localObject1;
    if (paramStackTraceElement != null)
    {
      Object localObject2 = paramStackTraceElement.getClassName().split("\\.");
      localObject1 = "unknown";
      if ((localObject2 != null) && (localObject2.length > 0)) {
        localObject1 = localObject2[(-1 + localObject2.length)];
      }
      localObject2 = new Object[3];
      localObject2[0] = localObject1;
      localObject2[1] = paramStackTraceElement.getMethodName();
      localObject2[2] = Integer.valueOf(paramStackTraceElement.getLineNumber());
      localStringBuilder.append(String.format(" (@%s:%s:%s)", (Object[])localObject2));
    }
    if (paramString != null)
    {
      localObject1 = new Object[1];
      localObject1[0] = paramString;
      localStringBuilder.append(String.format(" {%s}", (Object[])localObject1));
    }
    return localStringBuilder.toString();
  }
  
  public void setIncludedPackages(Context paramContext, Collection<String> paramCollection)
  {
    this.xa.clear();
    Object localObject1 = new HashSet();
    if (paramCollection != null) {
      ((Set)localObject1).addAll(paramCollection);
    }
    Object localObject2;
    if (paramContext != null) {
      try
      {
        localObject2 = paramContext.getApplicationContext().getPackageName();
        this.xa.add(localObject2);
        localObject2 = paramContext.getApplicationContext().getPackageManager().getPackageInfo((String)localObject2, 15).activities;
        if (localObject2 != null)
        {
          int i = localObject2.length;
          for (int j = 0; j < i; j++) {
            ((Set)localObject1).add(localObject2[j].packageName);
          }
        }
        localIterator2 = ((Set)localObject1).iterator();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        aa.B("No package found");
      }
    }
    Iterator localIterator2;
    if (localIterator2.hasNext())
    {
      localObject1 = (String)localIterator2.next();
      Iterator localIterator1 = this.xa.iterator();
      for (int k = 1;; k = 0)
      {
        if (localIterator1.hasNext())
        {
          localObject2 = (String)localIterator1.next();
          if (((String)localObject1).startsWith((String)localObject2)) {
            continue;
          }
          if (((String)localObject2).startsWith((String)localObject1)) {
            this.xa.remove(localObject2);
          }
        }
        if (k == 0) {
          break;
        }
        this.xa.add(localObject1);
        break;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.StandardExceptionParser
 * JD-Core Version:    0.7.0.1
 */