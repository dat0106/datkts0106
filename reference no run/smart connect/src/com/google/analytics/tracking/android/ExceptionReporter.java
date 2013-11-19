package com.google.analytics.tracking.android;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private ExceptionParser mExceptionParser;
  private final Thread.UncaughtExceptionHandler mOriginalHandler;
  private final ServiceManager mServiceManager;
  private final Tracker mTracker;
  
  public ExceptionReporter(Tracker paramTracker, ServiceManager paramServiceManager, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    if (paramTracker != null)
    {
      if (paramServiceManager != null)
      {
        this.mOriginalHandler = paramUncaughtExceptionHandler;
        this.mTracker = paramTracker;
        this.mServiceManager = paramServiceManager;
        StringBuilder localStringBuilder = new StringBuilder().append("ExceptionReporter created, original handler is ");
        String str;
        if (paramUncaughtExceptionHandler != null) {
          str = paramUncaughtExceptionHandler.getClass().getName();
        } else {
          str = "null";
        }
        Log.iDebug(str);
        return;
      }
      throw new NullPointerException("serviceManager cannot be null");
    }
    throw new NullPointerException("tracker cannot be null");
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.mExceptionParser;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.mExceptionParser = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str;
    if (this.mExceptionParser != null)
    {
      if (paramThread == null) {
        str = null;
      } else {
        str = paramThread.getName();
      }
      str = this.mExceptionParser.getDescription(str, paramThrowable);
    }
    else
    {
      str = paramThrowable.getMessage();
    }
    Log.iDebug("Tracking Exception: " + str);
    this.mTracker.sendException(str, true);
    this.mServiceManager.dispatch();
    if (this.mOriginalHandler != null)
    {
      Log.iDebug("Passing exception to original handler.");
      this.mOriginalHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.ExceptionReporter
 * JD-Core Version:    0.7.0.1
 */