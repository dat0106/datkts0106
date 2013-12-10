package com.smartandroidapps.audiowidgetlib.util;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;

class OldAPIHelper11
{
  static LinearLayout getLinearLayout_Holo_ButtonBar_AlertDialog(Context paramContext)
  {
    return new LinearLayout(paramContext, null, 16974055);
  }
  
  static void setupActionBar(Activity paramActivity)
  {
    ActionBar localActionBar = paramActivity.getActionBar();
    localActionBar.setDisplayUseLogoEnabled(true);
    localActionBar.setDisplayShowTitleEnabled(false);
    localActionBar.setDisplayShowHomeEnabled(true);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.util.OldAPIHelper11
 * JD-Core Version:    0.7.0.1
 */