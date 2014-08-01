package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class az
  extends aj
{
  private static final String ID = a.ac.toString();
  private static final String afR = b.cL.toString();
  private static final String afS = b.cO.toString();
  private static final String afT = b.co.toString();
  private static final String afv = b.bi.toString();
  
  public az()
  {
    super(str, arrayOfString);
  }
  
  private String a(String paramString, a parama, Set<Character> paramSet)
  {
    switch (1.afU[parama.ordinal()])
    {
    }
    for (;;)
    {
      return paramString;
      try
      {
        String str1 = dk.cv(paramString);
        paramString = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        bh.b("Joiner: unsupported encoding", localUnsupportedEncodingException);
      }
      continue;
      String str2 = paramString.replace("\\", "\\\\");
      Iterator localIterator = paramSet.iterator();
      String str3;
      for (str2 = str2; localIterator.hasNext(); str2 = str2.replace(str3, "\\" + str3)) {
        str3 = ((Character)localIterator.next()).toString();
      }
      paramString = str2;
    }
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, a parama, Set<Character> paramSet)
  {
    paramStringBuilder.append(a(paramString, parama, paramSet));
  }
  
  private void a(Set<Character> paramSet, String paramString)
  {
    for (int i = 0;; i++)
    {
      if (i >= paramString.length()) {
        return;
      }
      paramSet.add(Character.valueOf(paramString.charAt(i)));
    }
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    d.a locala1 = (d.a)paramMap.get(afv);
    Object localObject1;
    if (locala1 != null)
    {
      localObject1 = (d.a)paramMap.get(afR);
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = dh.j((d.a)localObject1);
      }
      Object localObject2 = (d.a)paramMap.get(afS);
      String str1;
      if (localObject2 == null) {
        str1 = "=";
      } else {
        str1 = dh.j((d.a)localObject2);
      }
      a locala = a.afV;
      localObject2 = (d.a)paramMap.get(afT);
      if (localObject2 == null)
      {
        localObject2 = null;
        locala = locala;
      }
      else
      {
        localObject2 = dh.j((d.a)localObject2);
        if (!"url".equals(localObject2))
        {
          if (!"backslash".equals(localObject2))
          {
            bh.A("Joiner: unsupported escape type: " + (String)localObject2);
            return dh.mY();
          }
          locala = a.afX;
          localObject2 = new HashSet();
          a((Set)localObject2, (String)localObject1);
          a((Set)localObject2, str1);
          ((Set)localObject2).remove(Character.valueOf('\\'));
        }
        else
        {
          locala = a.afW;
          localObject2 = null;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int j;
      Object localObject3;
      int i;
      switch (locala1.type)
      {
      default: 
        a(localStringBuilder, dh.j(locala1), locala, (Set)localObject2);
        break;
      case 2: 
        j = 1;
        localObject3 = locala1.fO;
        int m = localObject3.length;
        i = 0;
        while (i < m)
        {
          d.a locala2 = localObject3[i];
          if (j == 0) {
            localStringBuilder.append((String)localObject1);
          }
          a(localStringBuilder, dh.j(locala2), locala, (Set)localObject2);
          i++;
          j = 0;
        }
      }
      for (int k = 0;; k++)
      {
        if (k >= i.fP.length)
        {
          localObject1 = dh.r(localStringBuilder.toString());
          break;
        }
        if (k > 0) {
          localStringBuilder.append((String)localObject1);
        }
        localObject3 = dh.j(i.fP[k]);
        String str2 = dh.j(i.fQ[k]);
        a(localStringBuilder, (String)localObject3, locala, (Set)localObject2);
        localStringBuilder.append(j);
        a(localStringBuilder, str2, locala, (Set)localObject2);
      }
    }
    else
    {
      localObject1 = dh.mY();
    }
    return localObject1;
  }
  
  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = afV;
      arrayOfa[1] = afW;
      arrayOfa[2] = afX;
      afY = arrayOfa;
    }
    
    private a() {}
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.az
 * JD-Core Version:    0.7.0.1
 */