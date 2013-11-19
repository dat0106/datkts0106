package com.sonyericsson.extras.liveware.actions.appshortcut;

import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.ui.MissingAppHandlerActivity;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class AppShortcutSelectionHandler
  extends MissingAppHandlerActivity
{
  protected String getAppLabelFromRawSetting(String paramString)
  {
    Object localObject = "";
    try
    {
      String str = new JSONObject(paramString).optString("app_shortcut_settings_label");
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e("Invalid json object", localJSONException);
      }
    }
    return localObject;
  }
  
  protected String getDialogTitle()
  {
    return getString(2131099953);
  }
  
  protected String getPackageNameFromRawSetting(String paramString)
  {
    String str = "";
    try
    {
      Object localObject = new JSONObject(paramString).optString("app_shortcut_component");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ComponentName.unflattenFromString((String)localObject);
        if (localObject != null)
        {
          str = ((ComponentName)localObject).getPackageName();
          str = str;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e("Invalid json object", localJSONException);
      }
    }
    return str;
  }
  
  protected void showAppSelectionActivity()
  {
    Intent localIntent = new Intent(this, AppShortcutSelectionActivity.class);
    localIntent.putExtra("setting_raw", this.mRawSetting);
    localIntent.putExtra("id", this.mUuid);
    startActivityForResult(localIntent, 7);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.appshortcut.AppShortcutSelectionHandler
 * JD-Core Version:    0.7.0.1
 */