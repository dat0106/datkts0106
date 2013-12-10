package com.smartandroidapps.audiowidgetlib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;

public class API
  extends Activity
{
  public static final String ACTION_APPLY_PROFILE = "com.smartandroidapps.audiowidgetpro.intent.action.APPLY_PROFILE";
  public static final String ACTION_GET_PROFILES = "com.smartandroidapps.audiowidgetpro.intent.action.GET_PROFILES";
  public static final String EXTRA_PROFILE_APPLIED = "PROFILE_APPLIED";
  public static final String EXTRA_PROFILE_ID = "PROFILE_ID";
  public static final String EXTRA_PROFILE_LIST = "PROFILE_LIST";
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    if (!localIntent.getAction().equals("com.smartandroidapps.audiowidgetpro.intent.action.GET_PROFILES"))
    {
      if (localIntent.getAction().equals("com.smartandroidapps.audiowidgetpro.intent.action.APPLY_PROFILE"))
      {
        int i = localIntent.getIntExtra("PROFILE_ID", -1);
        Profile localProfile = null;
        boolean bool = false;
        if (i != -1) {
          localProfile = Profile.getProfile(i, this);
        }
        if (localProfile != null)
        {
          localProfile.changeStreamsToProfile();
          startService(new Intent(this, UpdateService.class));
          bool = true;
        }
        localIntent.putExtra("PROFILE_APPLIED", bool);
      }
    }
    else {
      localIntent.putStringArrayListExtra("PROFILE_LIST", Profile.getProfilesMap(this));
    }
    setResult(-1, localIntent);
    finish();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.API
 * JD-Core Version:    0.7.0.1
 */