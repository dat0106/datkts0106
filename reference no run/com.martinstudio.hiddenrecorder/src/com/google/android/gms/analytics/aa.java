package com.google.android.gms.analytics;

public class aa
{
  private static GoogleAnalytics wH;
  
  public static void A(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.error(paramString);
    }
  }
  
  public static void B(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.info(paramString);
    }
  }
  
  public static void C(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.verbose(paramString);
    }
  }
  
  public static void D(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null) {
      localLogger.warn(paramString);
    }
  }
  
  public static boolean dk()
  {
    boolean bool = false;
    if ((getLogger() != null) && (getLogger().getLogLevel() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  private static Logger getLogger()
  {
    if (wH == null) {
      wH = GoogleAnalytics.dd();
    }
    Logger localLogger;
    if (wH == null) {
      localLogger = null;
    } else {
      localLogger = wH.getLogger();
    }
    return localLogger;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.aa
 * JD-Core Version:    0.7.0.1
 */