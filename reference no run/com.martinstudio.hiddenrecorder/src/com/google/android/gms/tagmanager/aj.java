package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj
{
  private final String afA;
  private final Set<String> afz;
  
  public aj(String paramString, String... paramVarArgs)
  {
    this.afA = paramString;
    this.afz = new HashSet(paramVarArgs.length);
    int i = paramVarArgs.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      String str = paramVarArgs[j];
      this.afz.add(str);
    }
  }
  
  boolean a(Set<String> paramSet)
  {
    return paramSet.containsAll(this.afz);
  }
  
  public String lG()
  {
    return this.afA;
  }
  
  public Set<String> lH()
  {
    return this.afz;
  }
  
  public abstract boolean lc();
  
  public abstract d.a w(Map<String, d.a> paramMap);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.aj
 * JD-Core Version:    0.7.0.1
 */