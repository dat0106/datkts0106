package android.support.v4.text;

import android.os.Build.VERSION;

public class ICUCompat
{
  private static final ICUCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT < 14) {
      IMPL = new ICUCompatImplBase();
    } else {
      IMPL = new ICUCompatImplIcs();
    }
  }
  
  public static String addLikelySubtags(String paramString)
  {
    return IMPL.addLikelySubtags(paramString);
  }
  
  public static String getScript(String paramString)
  {
    return IMPL.getScript(paramString);
  }
  
  static class ICUCompatImplIcs
    implements ICUCompat.ICUCompatImpl
  {
    public String addLikelySubtags(String paramString)
    {
      return ICUCompatIcs.addLikelySubtags(paramString);
    }
    
    public String getScript(String paramString)
    {
      return ICUCompatIcs.getScript(paramString);
    }
  }
  
  static class ICUCompatImplBase
    implements ICUCompat.ICUCompatImpl
  {
    public String addLikelySubtags(String paramString)
    {
      return paramString;
    }
    
    public String getScript(String paramString)
    {
      return null;
    }
  }
  
  static abstract interface ICUCompatImpl
  {
    public abstract String addLikelySubtags(String paramString);
    
    public abstract String getScript(String paramString);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompat
 * JD-Core Version:    0.7.0.1
 */