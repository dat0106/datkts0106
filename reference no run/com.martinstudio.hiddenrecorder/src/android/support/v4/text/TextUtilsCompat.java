package android.support.v4.text;

import java.util.Locale;

public class TextUtilsCompat
{
  private static String ARAB_SCRIPT_SUBTAG = "Arab";
  private static String HEBR_SCRIPT_SUBTAG = "Hebr";
  public static final Locale ROOT = new Locale("", "");
  
  private static int getLayoutDirectionFromFirstChar(Locale paramLocale)
  {
    int i = 0;
    switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
    {
    case 1: 
    case 2: 
      i = 1;
    }
    return i;
  }
  
  public static int getLayoutDirectionFromLocale(Locale paramLocale)
  {
    if ((paramLocale != null) && (!paramLocale.equals(ROOT)))
    {
      String str = ICUCompat.getScript(ICUCompat.addLikelySubtags(paramLocale.toString()));
      if (str == null) {
        break label59;
      }
      if ((str.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG)) || (str.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG))) {}
    }
    else
    {
      return 0;
    }
    int i = 1;
    return i;
    label59:
    i = getLayoutDirectionFromFirstChar(paramLocale);
    return i;
  }
  
  public static String htmlEncode(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0;; i++)
    {
      if (i >= paramString.length()) {
        return localStringBuilder.toString();
      }
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        localStringBuilder.append(c);
        break;
      case '"': 
        localStringBuilder.append("&quot;");
        break;
      case '&': 
        localStringBuilder.append("&amp;");
        break;
      case '\'': 
        localStringBuilder.append("&#39;");
        break;
      case '<': 
        localStringBuilder.append("&lt;");
        break;
      case '>': 
        localStringBuilder.append("&gt;");
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextUtilsCompat
 * JD-Core Version:    0.7.0.1
 */