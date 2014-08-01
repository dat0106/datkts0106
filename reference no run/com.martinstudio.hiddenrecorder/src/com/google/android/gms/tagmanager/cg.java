package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cg
  extends aj
{
  private static final String ID = a.ae.toString();
  private static final String agE = b.bi.toString();
  private static final String agF = b.bj.toString();
  private static final String agG = b.cF.toString();
  private static final String agH = b.cz.toString();
  
  public cg()
  {
    super(str, arrayOfString);
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject4 = (d.a)paramMap.get(agE);
    Object localObject3 = (d.a)paramMap.get(agF);
    d.a locala;
    if ((localObject4 == null) || (localObject4 == dh.mY()) || (localObject3 == null) || (localObject3 == dh.mY())) {
      locala = dh.mY();
    }
    for (;;)
    {
      return locala;
      int i = 64;
      if (dh.n((d.a)paramMap.get(agG)).booleanValue()) {
        i = 66;
      }
      Object localObject2 = (d.a)paramMap.get(agH);
      Object localObject1;
      int j;
      if (localObject2 != null)
      {
        localObject2 = dh.l((d.a)localObject2);
        if (localObject2 == dh.mT())
        {
          localObject1 = dh.mY();
          continue;
        }
        j = ((Long)localObject2).intValue();
        if (j < 0) {
          localObject1 = dh.mY();
        }
      }
      else
      {
        j = 1;
      }
      try
      {
        localObject4 = dh.j((d.a)localObject4);
        String str = dh.j((d.a)localObject3);
        localObject3 = null;
        localObject1 = Pattern.compile(str, localObject1).matcher((CharSequence)localObject4);
        if ((((Matcher)localObject1).find()) && (((Matcher)localObject1).groupCount() >= j)) {
          localObject3 = ((Matcher)localObject1).group(j);
        }
        if (localObject3 == null)
        {
          localObject1 = dh.mY();
        }
        else
        {
          localObject1 = dh.r(localObject3);
          localObject1 = localObject1;
        }
      }
      catch (PatternSyntaxException localPatternSyntaxException)
      {
        localObject1 = dh.mY();
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cg
 * JD-Core Version:    0.7.0.1
 */