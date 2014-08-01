package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity
  extends Activity
{
  private void d(String paramString1, String paramString2, String paramString3)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.setTitle(paramString1);
    localAlertDialog.setMessage(paramString2);
    localAlertDialog.setButton(-1, paramString3, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localAlertDialog.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      bh.B("Preview activity");
      Object localObject = getIntent().getData();
      if (!TagManager.getInstance(this).h((Uri)localObject))
      {
        localObject = "Cannot preview the app with the uri: " + localObject + ". Launching current version instead.";
        bh.D((String)localObject);
        d("Preview failure", (String)localObject, "Continue");
      }
      localObject = getPackageManager().getLaunchIntentForPackage(getPackageName());
      if (localObject != null)
      {
        bh.B("Invoke the launch activity for package name: " + getPackageName());
        startActivity((Intent)localObject);
      }
      else
      {
        bh.B("No launch activity found for package name: " + getPackageName());
      }
    }
    catch (Exception localException)
    {
      bh.A("Calling preview threw an exception: " + localException.getMessage());
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.PreviewActivity
 * JD-Core Version:    0.7.0.1
 */