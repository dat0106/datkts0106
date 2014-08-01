package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class cd
{
  public static boolean a(Context paramContext, cf paramcf, cm paramcm)
  {
    boolean bool = false;
    if (paramcf == null) {
      ev.D("No intent data for launcher overlay.");
    }
    for (;;)
    {
      return bool;
      Intent localIntent = new Intent();
      if (TextUtils.isEmpty(paramcf.nZ))
      {
        ev.D("Open GMSG did not contain a URL.");
      }
      else
      {
        if (!TextUtils.isEmpty(paramcf.mimeType)) {
          localIntent.setDataAndType(Uri.parse(paramcf.nZ), paramcf.mimeType);
        }
        String[] arrayOfString;
        for (;;)
        {
          localIntent.setAction("android.intent.action.VIEW");
          if (!TextUtils.isEmpty(paramcf.packageName)) {
            localIntent.setPackage(paramcf.packageName);
          }
          if (TextUtils.isEmpty(paramcf.oa)) {
            break label182;
          }
          arrayOfString = paramcf.oa.split("/", 2);
          if (arrayOfString.length >= 2) {
            break label168;
          }
          ev.D("Could not parse component name from open GMSG: " + paramcf.oa);
          break;
          localIntent.setData(Uri.parse(paramcf.nZ));
        }
        label168:
        localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
        try
        {
          label182:
          ev.C("Launching an intent: " + localIntent);
          paramContext.startActivity(localIntent);
          paramcm.T();
          bool = true;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          ev.D(localActivityNotFoundException.getMessage());
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cd
 * JD-Core Version:    0.7.0.1
 */