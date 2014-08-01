package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.d.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dk
{
  private static by<d.a> a(by<d.a> paramby)
  {
    try
    {
      by localby = new by(dh.r(cv(dh.j((d.a)paramby.getObject()))), paramby.lV());
      paramby = localby;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        bh.b("Escape URI: unsupported encoding", localUnsupportedEncodingException);
      }
    }
    return paramby;
  }
  
  private static by<d.a> a(by<d.a> paramby, int paramInt)
  {
    if (q((d.a)paramby.getObject())) {
      switch (paramInt)
      {
      default: 
        bh.A("Unsupported Value Escaping: " + paramInt);
        break;
      case 12: 
        paramby = a(paramby);
        break;
      }
    } else {
      bh.A("Escaping can only be applied to strings.");
    }
    return paramby;
  }
  
  static by<d.a> a(by<d.a> paramby, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return paramby;
      }
      paramby = a(paramby, paramVarArgs[i]);
    }
  }
  
  static String cv(String paramString)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
  
  private static boolean q(d.a parama)
  {
    return dh.o(parama) instanceof String;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.dk
 * JD-Core Version:    0.7.0.1
 */