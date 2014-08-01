package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class bc
{
  public static final bd mR = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap) {}
  };
  public static final bd mS = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("urls");
      if (!TextUtils.isEmpty(str1))
      {
        String[] arrayOfString = str1.split(",");
        HashMap localHashMap = new HashMap();
        PackageManager localPackageManager = paramAnonymousey.getContext().getPackageManager();
        int j = arrayOfString.length;
        for (int i = 0;; i++)
        {
          if (i >= j)
          {
            paramAnonymousey.a("openableURLs", localHashMap);
            break;
          }
          String str2 = arrayOfString[i];
          Object localObject = str2.split(";", 2);
          String str3 = localObject[0].trim();
          if (localObject.length <= 1) {
            localObject = "android.intent.action.VIEW";
          } else {
            localObject = localObject[1].trim();
          }
          boolean bool;
          if (localPackageManager.resolveActivity(new Intent((String)localObject, Uri.parse(str3)), 65536) == null) {
            bool = false;
          } else {
            bool = true;
          }
          localHashMap.put(str2, Boolean.valueOf(bool));
        }
      }
      ev.D("URLs missing in canOpenURLs GMSG.");
    }
  };
  public static final bd mT = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      str = (String)paramAnonymousMap.get("u");
      if (str == null) {
        ev.D("URL missing from click GMSG.");
      }
      for (;;)
      {
        return;
        localUri = Uri.parse(str);
        try
        {
          localObject = paramAnonymousey.bX();
          if ((localObject == null) || (!((l)localObject).a(localUri))) {
            break;
          }
          localObject = ((l)localObject).a(localUri, paramAnonymousey.getContext());
          localObject = localObject;
        }
        catch (m localm)
        {
          for (;;)
          {
            ev.D("Unable to append parameter to URL: " + str);
            Object localObject = localUri;
          }
        }
        localObject = ((Uri)localObject).toString();
        new et(paramAnonymousey.getContext(), paramAnonymousey.bY().st, (String)localObject).start();
      }
    }
  };
  public static final bd mU = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      cg localcg = paramAnonymousey.bV();
      if (localcg != null) {
        localcg.close();
      } else {
        ev.D("A GMSG tried to close something that wasn't an overlay.");
      }
    }
  };
  public static final bd mV = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      cg localcg = paramAnonymousey.bV();
      if (localcg != null) {
        localcg.j("1".equals(paramAnonymousMap.get("custom_close")));
      } else {
        ev.D("A GMSG tried to use a custom close button on something that wasn't an overlay.");
      }
    }
  };
  public static final bd mW = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      String str = (String)paramAnonymousMap.get("u");
      if (str != null) {
        new et(paramAnonymousey.getContext(), paramAnonymousey.bY().st, str).start();
      } else {
        ev.D("URL missing from httpTrack GMSG.");
      }
    }
  };
  public static final bd mX = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      ev.B("Received log message: " + (String)paramAnonymousMap.get("string"));
    }
  };
  public static final bd mY = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("tx");
      String str3 = (String)paramAnonymousMap.get("ty");
      String str2 = (String)paramAnonymousMap.get("td");
      try
      {
        int i = Integer.parseInt(str1);
        int k = Integer.parseInt(str3);
        int j = Integer.parseInt(str2);
        l locall = paramAnonymousey.bX();
        if (locall != null) {
          locall.y().a(i, k, j);
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          ev.D("Could not parse touch parameters from gmsg.");
        }
      }
    }
  };
  public static final bd mZ = new bi();
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bc
 * JD-Core Version:    0.7.0.1
 */