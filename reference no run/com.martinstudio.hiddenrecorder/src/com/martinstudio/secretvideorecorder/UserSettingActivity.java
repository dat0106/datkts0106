package com.martinstudio.secretvideorecorder;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.ads.InterstitialAd;

public class UserSettingActivity
  extends PreferenceActivity
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private CheckBoxPreference mCheckShowPreview;
  InterstitialAd mInterstitial;
  
  public static boolean getInfoEnableNotification(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("use_notification", true);
  }
  
  public static String getInfoQualityVideo(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("video_quality", "0");
  }
  
  public static boolean getInfoShowPreviewOrNot(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("preview", false);
  }
  
  public static boolean getInfoWhichCameraForRecorder(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("use_camera_front", false);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131034112);
    setRequestedOrientation(1);
    ActionBar localActionBar = getActionBar();
    localActionBar.setBackgroundDrawable(new ColorDrawable(-864059521));
    localActionBar.setDisplayHomeAsUpEnabled(true);
    this.mCheckShowPreview = ((CheckBoxPreference)getPreferenceScreen().findPreference("preview"));
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
      break;
    case 16908332: 
      finish();
      bool = true;
    }
    return bool;
  }
  
  protected void onResume()
  {
    super.onResume();
    getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    this.mCheckShowPreview.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        UserSettingActivity.this.showToast();
        return false;
      }
    });
  }
  
  void showToast()
  {
    Toast.makeText(this, "Show preview  need restart this app for apply", 1).show();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.martinstudio.secretvideorecorder.UserSettingActivity
 * JD-Core Version:    0.7.0.1
 */