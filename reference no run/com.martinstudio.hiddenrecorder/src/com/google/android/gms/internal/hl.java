package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class hl
{
  public static a e(Object paramObject)
  {
    return new a(paramObject, null);
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (!paramObject1.equals(paramObject2)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static final class a
  {
    private final List<String> GG;
    private final Object GH;
    
    private a(Object paramObject)
    {
      this.GH = hn.f(paramObject);
      this.GG = new ArrayList();
    }
    
    public a a(String paramString, Object paramObject)
    {
      this.GG.add((String)hn.f(paramString) + "=" + String.valueOf(paramObject));
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.GH.getClass().getSimpleName()).append('{');
      int i = this.GG.size();
      for (int j = 0;; j++)
      {
        if (j >= i) {
          return '}';
        }
        localStringBuilder.append((String)this.GG.get(j));
        if (j < i - 1) {
          localStringBuilder.append(", ");
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hl
 * JD-Core Version:    0.7.0.1
 */