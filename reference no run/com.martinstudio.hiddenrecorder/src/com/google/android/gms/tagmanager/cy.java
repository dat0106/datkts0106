package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class cy
{
  static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(paramString1, 0).edit();
    localEditor.putString(paramString2, paramString3);
    a(localEditor);
  }
  
  static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT < 9) {
      new Thread(new Runnable()
      {
        public void run()
        {
          cy.this.commit();
        }
      }).start();
    } else {
      paramEditor.apply();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cy
 * JD-Core Version:    0.7.0.1
 */