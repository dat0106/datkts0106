package com.google.android.gms.analytics;

import android.content.Context;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler tL;
  private final Tracker tM;
  private ExceptionParser tN;
  
  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker != null)
    {
      if (paramContext != null)
      {
        this.tL = paramUncaughtExceptionHandler;
        this.tM = paramTracker;
        this.tN = new StandardExceptionParser(paramContext, new ArrayList());
        this.mContext = paramContext.getApplicationContext();
        StringBuilder localStringBuilder = new StringBuilder().append("ExceptionReporter created, original handler is ");
        String str;
        if (paramUncaughtExceptionHandler != null) {
          str = paramUncaughtExceptionHandler.getClass().getName();
        } else {
          str = "null";
        }
        aa.C(str);
        return;
      }
      throw new NullPointerException("context cannot be null");
    }
    throw new NullPointerException("tracker cannot be null");
  }
  
  Thread.UncaughtExceptionHandler cy()
  {
    return this.tL;
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.tN;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.tN = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str = "UncaughtException";
    if (this.tN != null)
    {
      if (paramThread == null) {
        str = null;
      } else {
        str = paramThread.getName();
      }
      str = this.tN.getDescription(str, paramThrowable);
    }
    aa.C("Tracking Exception: " + str);
    this.tM.send(new HitBuilders.ExceptionBuilder().setDescription(str).setFatal(true).build());
    GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
    if (this.tL != null)
    {
      aa.C("Passing exception to original handler.");
      this.tL.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ExceptionReporter
 * JD-Core Version:    0.7.0.1
 */