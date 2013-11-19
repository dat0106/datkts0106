package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

public class PreferenceHelper
{
  private static final String KEY_FIRST_LAUNCH = "first_launch";
  private static final String KEY_LAST_USED_TAB = "last_used_tab";
  public static final int TAB_DEVICES = 0;
  public static final int TAB_EVENTS = 1;
  
  public static boolean isFirstLaunch(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("first_launch", true);
  }
  
  public static int readLastUsedTab(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("last_used_tab", 1);
  }
  
  public static void saveFirstLaunch(Context paramContext, final boolean paramBoolean)
  {
    AsyncTask local2 = new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(PreferenceHelper.this).edit();
        localEditor.putBoolean("first_launch", paramBoolean);
        localEditor.commit();
        return null;
      }
    };
    Void[] arrayOfVoid = new Void[1];
    arrayOfVoid[0] = null;
    local2.execute(arrayOfVoid);
  }
  
  public static void saveLastUsedTab(Context paramContext, final int paramInt)
  {
    AsyncTask local1 = new AsyncTask()
    {
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(PreferenceHelper.this).edit();
        localEditor.putInt("last_used_tab", paramInt);
        localEditor.commit();
        return null;
      }
    };
    Void[] arrayOfVoid = new Void[1];
    arrayOfVoid[0] = null;
    local1.execute(arrayOfVoid);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.PreferenceHelper
 * JD-Core Version:    0.7.0.1
 */