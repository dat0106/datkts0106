package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ac
  extends aj
{
  private static final String ID = a.Y.toString();
  private static final String afv = b.bi.toString();
  private static final String afw = b.di.toString();
  private static final String afx = b.cH.toString();
  private static final String afy = b.dq.toString();
  
  public ac()
  {
    super(str, arrayOfString);
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject1 = (d.a)paramMap.get(afv);
    if ((localObject1 == null) || (localObject1 == dh.mY()))
    {
      localObject1 = dh.mY();
      return localObject1;
    }
    Object localObject2 = dh.j((d.a)localObject1);
    localObject1 = (d.a)paramMap.get(afx);
    String str;
    if (localObject1 == null)
    {
      str = "text";
      label56:
      localObject1 = (d.a)paramMap.get(afy);
      if (localObject1 != null) {
        break label157;
      }
      localObject1 = "base16";
      label76:
      d.a locala = (d.a)paramMap.get(afw);
      if ((locala == null) || (!dh.n(locala).booleanValue())) {
        break label341;
      }
    }
    label157:
    label312:
    label341:
    for (int i = 3;; i = 2)
    {
      for (;;)
      {
        try
        {
          if ("text".equals(str))
          {
            localObject2 = ((String)localObject2).getBytes();
            localObject2 = localObject2;
            if (!"base16".equals(localObject1)) {
              break label271;
            }
            localObject1 = j.d((byte[])localObject2);
            localObject1 = dh.r(localObject1);
            break;
            str = dh.j((d.a)localObject1);
            break label56;
            localObject1 = dh.j((d.a)localObject1);
            break label76;
          }
          if ("base16".equals(str))
          {
            localObject2 = j.bE((String)localObject2);
            continue;
          }
          if ("base64".equals(str))
          {
            localObject2 = Base64.decode((String)localObject2, i);
            continue;
          }
          if ("base64url".equals(str))
          {
            localObject2 = Base64.decode((String)localObject2, i | 0x8);
            continue;
          }
          bh.A("Encode: unknown input format: " + str);
          localObject1 = dh.mY();
          localObject1 = localObject1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          bh.A("Encode: invalid input:");
          localObject1 = dh.mY();
        }
        break;
        if ("base64".equals(localObject1))
        {
          localObject1 = Base64.encodeToString((byte[])localObject2, i);
        }
        else
        {
          if (!"base64url".equals(localObject1)) {
            break label312;
          }
          localObject1 = Base64.encodeToString((byte[])localObject2, i | 0x8);
        }
      }
      bh.A("Encode: unknown output format: " + (String)localObject1);
      localObject1 = dh.mY();
      break;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ac
 * JD-Core Version:    0.7.0.1
 */