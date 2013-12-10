package com.smartandroidapps.audiowidgetlib.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class ProfilesActivity
  extends SherlockFragmentActivity
  implements Constants
{
  public static boolean isActive = false;
  int profilesBackground;
  
  private void setLayoutTheme()
  {
    String str = new SettingsManager(this).getTheme();
    if (!str.equals("darkBlue"))
    {
      if (!str.equals("normal"))
      {
        if (!str.equals("darkRed"))
        {
          if (!str.equals("darkGreen"))
          {
            if (!str.equals("darkYellow"))
            {
              if (str.equals("darkPink")) {
                this.profilesBackground = R.drawable.background_holo_dark_bg;
              }
            }
            else {
              this.profilesBackground = R.drawable.background_holo_dark_bg;
            }
          }
          else {
            this.profilesBackground = R.drawable.background_holo_dark_bg;
          }
        }
        else {
          this.profilesBackground = R.drawable.background_holo_dark_bg;
        }
      }
      else {
        this.profilesBackground = R.drawable.background_holo_dark;
      }
    }
    else {
      this.profilesBackground = R.drawable.background_holo_dark_bg;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setLayoutTheme();
    if (!MiscUtils.isAtLeastLargeHC(this)) {
      setContentView(R.layout.profiles_phone);
    } else {
      setContentView(R.layout.profiles_dialog);
    }
    ((RelativeLayout)findViewById(R.id.profilesBackground)).setBackgroundDrawable(getResources().getDrawable(this.profilesBackground));
  }
  
  protected void onStart()
  {
    super.onStart();
    isActive = true;
  }
  
  protected void onStop()
  {
    super.onStop();
    isActive = false;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.activities.ProfilesActivity
 * JD-Core Version:    0.7.0.1
 */