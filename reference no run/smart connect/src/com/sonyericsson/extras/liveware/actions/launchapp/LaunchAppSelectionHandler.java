package com.sonyericsson.extras.liveware.actions.launchapp;

import android.content.Intent;
import com.sonyericsson.extras.liveware.R.string;
import com.sonyericsson.extras.liveware.ui.MissingAppHandlerActivity;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ReflectionUtils;

public class LaunchAppSelectionHandler
  extends MissingAppHandlerActivity
{
  protected String getAppLabelFromRawSetting(String paramString)
  {
    String str = null;
    if (paramString.contains(";")) {
      if (!paramString.contains(";@"))
      {
        str = paramString.split(";")[1];
      }
      else
      {
        Object localObject = ReflectionUtils.getStaticField(R.string.class.getName(), paramString.split("@")[1]);
        if (localObject == null) {
          Dbg.d("R.string." + paramString.split("@")[1] + " does not exist");
        } else {
          str = getString(((Integer)localObject).intValue());
        }
      }
    }
    if (str == null)
    {
      if (!paramString.contains(";")) {
        str = paramString;
      } else {
        str = paramString.split(";")[0];
      }
      if (str.contains("/")) {
        str = str.split("/")[0];
      }
    }
    return str;
  }
  
  protected String getDialogTitle()
  {
    return getString(2131099848);
  }
  
  protected String getPackageNameFromRawSetting(String paramString)
  {
    String str;
    if (!paramString.contains("/")) {
      str = paramString;
    } else {
      str = paramString.split("/")[0];
    }
    if (str.contains(";")) {
      str = str.split(";")[0];
    }
    return str;
  }
  
  protected void showAppSelectionActivity()
  {
    Intent localIntent = new Intent(this, LaunchAppSelectionActivity.class);
    localIntent.putExtra("setting_raw", this.mRawSetting);
    localIntent.putExtra("id", this.mUuid);
    startActivityForResult(localIntent, 7);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.launchapp.LaunchAppSelectionHandler
 * JD-Core Version:    0.7.0.1
 */