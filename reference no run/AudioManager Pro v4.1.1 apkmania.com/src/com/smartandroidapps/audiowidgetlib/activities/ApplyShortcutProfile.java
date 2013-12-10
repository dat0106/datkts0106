package com.smartandroidapps.audiowidgetlib.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;
import com.smartandroidapps.audiowidgetlib.AApplication;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager.Editor;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class ApplyShortcutProfile
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("profileId", 0);
    if (Profile.getProfile(i, this) == null)
    {
      Toast.makeText(this, getString(R.string.profile_notfound), 0).show();
    }
    else
    {
      AApplication.isShortcutApplied = true;
      if (MiscUtils.isDebug()) {
        Log.d("AudioManager", "ApplyShortcutProfile, applying profile");
      }
      Profile localProfile = Profile.getProfile(i, this);
      localProfile.changeStreamsToProfile();
      SettingsManager localSettingsManager = new SettingsManager(this);
      if (localSettingsManager.getBoolean("vibrateProfile", true)) {
        ((Vibrator)getSystemService("vibrator")).vibrate(125L);
      }
      String str = getString(R.string.profile_applied);
      if (!str.contains("{0}")) {
        str = localProfile.getName() + " " + str;
      } else {
        str = str.replace("{0}", localProfile.getName());
      }
      localSettingsManager.editnew().putCurrentProfile(localProfile.getId()).commit();
      if (1 != 0) {
        startService(new Intent(this, UpdateService.class));
      }
      Toast.makeText(this, str, 0).show();
      AApplication.ShortCutDoneBeingApplied();
      if (MiscUtils.isDebug()) {
        Log.d("AudioManager", "ApplyShortcutProfile, done applying profile");
      }
    }
    finish();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.activities.ApplyShortcutProfile
 * JD-Core Version:    0.7.0.1
 */