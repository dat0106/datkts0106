package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch
  extends dc
{
  private static final String ID = a.ag.toString();
  private static final String agG = b.cF.toString();
  
  public ch()
  {
    super(ID);
  }
  
  protected boolean a(String paramString1, String paramString2, Map<String, d.a> paramMap)
  {
    if (dh.n((d.a)paramMap.get(agG)).booleanValue()) {}
    int j;
    for (int i = 66;; j = 64)
    {
      try
      {
        bool = Pattern.compile(paramString2, i).matcher(paramString1).find();
        bool = bool;
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        for (;;)
        {
          boolean bool = false;
        }
      }
      return bool;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ch
 * JD-Core Version:    0.7.0.1
 */