package com.smartandroidapps.audiowidgetlib.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import java.util.List;

public class ToggleService
  extends Service
  implements Constants
{
  private void setToast(String paramString)
  {
    Toast.makeText(getApplicationContext(), paramString, 0).show();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Log.d("AudioManager", "Service started");
    int i = new SettingsManager(getApplicationContext()).getInt("sortMode", 0);
    Log.d("AudioManager", "sort by: " + i);
    List localList = Profile.getProfiles(getApplicationContext(), i);
    i = ProfilesFragment.checkProfileStreams(getApplicationContext(), false, (AudioManager)getApplicationContext().getSystemService("audio"));
    if ((localList == null) || (localList.size() <= 0))
    {
      setToast("No saved profiles.");
    }
    else
    {
      Profile localProfile = null;
      if (i != -1)
      {
        int j = 0;
        while (j < localList.size()) {
          if (i != ((Profile)localList.get(j)).getId()) {
            j++;
          } else if (j != -1 + localList.size()) {
            localProfile = (Profile)localList.get(j + 1);
          } else {
            localProfile = (Profile)localList.get(0);
          }
        }
      }
      if (localProfile == null) {
        localProfile = (Profile)localList.get(0);
      }
      startActivity(MiscUtils.getProfileShortcutIntent(localProfile.getId(), this));
    }
    stopSelf();
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.services.ToggleService
 * JD-Core Version:    0.7.0.1
 */