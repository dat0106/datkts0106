package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao
  extends aj
{
  private static final String ID = a.aa.toString();
  private static final String afB = b.aZ.toString();
  private static final String afv = b.bi.toString();
  private static final String afx = b.cH.toString();
  
  public ao()
  {
    super(str, arrayOfString);
  }
  
  private byte[] c(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    Object localObject1 = (d.a)paramMap.get(afv);
    if ((localObject1 == null) || (localObject1 == dh.mY())) {
      localObject1 = dh.mY();
    }
    for (;;)
    {
      return localObject1;
      Object localObject2 = dh.j((d.a)localObject1);
      localObject1 = (d.a)paramMap.get(afB);
      label55:
      Object localObject3;
      if (localObject1 == null)
      {
        localObject1 = "MD5";
        localObject3 = (d.a)paramMap.get(afx);
        if (localObject3 != null) {
          break label119;
        }
        localObject3 = "text";
        label78:
        if (!"text".equals(localObject3)) {
          break label129;
        }
      }
      for (localObject2 = ((String)localObject2).getBytes();; localObject2 = j.bE((String)localObject2))
      {
        try
        {
          localObject1 = dh.r(j.d(c((String)localObject1, (byte[])localObject2)));
          localObject1 = localObject1;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          label119:
          bh.A("Hash: unknown algorithm: " + (String)localObject1);
          label129:
          localObject1 = dh.mY();
        }
        localObject1 = dh.j((d.a)localObject1);
        break label55;
        localObject3 = dh.j((d.a)localObject3);
        break label78;
        if (!"base16".equals(localObject3)) {
          break label147;
        }
      }
      label147:
      bh.A("Hash: unknown input format: " + (String)localObject3);
      localObject1 = dh.mY();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ao
 * JD-Core Version:    0.7.0.1
 */