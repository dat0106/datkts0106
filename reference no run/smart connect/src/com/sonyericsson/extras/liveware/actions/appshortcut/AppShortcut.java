package com.sonyericsson.extras.liveware.actions.appshortcut;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import java.net.URISyntaxException;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class AppShortcut
  extends AbstractAction
{
  public static final String SETTING = "app_shortcut_setting";
  public static final String SETTINGS_COMPONENT = "app_shortcut_component";
  public static final String SETTINGS_LABEL = "app_shortcut_settings_label";
  
  public AppShortcut()
  {
    super(AppShortcut.class.getSimpleName());
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    String str1 = "";
    Object localObject1 = "";
    Object localObject2 = null;
    int i = 0;
    int j = 0;
    Intent localIntent = null;
    try
    {
      localJSONObject = new JSONObject(paramString);
      str2 = localJSONObject.optString("app_shortcut_setting");
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      String str2;
      label48:
      Dbg.e(localJSONException);
    }
    try
    {
      localIntent = Intent.parseUri(str2, 0);
      localIntent = localIntent;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      break label48;
    }
    if (localIntent != null)
    {
      if ((!TextUtils.isEmpty(localIntent.getDataString())) || (str2.contains("vnd.android.cursor.item")) || (str2.contains("vnd.android.cursor.dir")) || (localIntent.getExtras() != null)) {
        break label330;
      }
      i = 1;
      if ((localIntent.getCategories() == null) || (!localIntent.getCategories().contains("android.intent.category.LAUNCHER"))) {
        break label336;
      }
    }
    label330:
    label336:
    for (j = 1;; j = 0)
    {
      str2 = localJSONObject.optString("app_shortcut_component");
      if (str2 != null)
      {
        localObject2 = ComponentName.unflattenFromString(str2);
        localObject1 = PackageUtils.getActivityNameFromComponentName(paramContext, (ComponentName)localObject2);
      }
      if (localObject2 != null)
      {
        if (PackageUtils.existsPackage(paramContext, ((ComponentName)localObject2).getPackageName()))
        {
          localObject2 = PackageUtils.getActivityNameFromIntent(paramContext, localIntent);
          if (i != 0)
          {
            if (j != 0) {
              str1 = localObject2 + ": " + (String)localObject1;
            } else {
              str1 = localObject1 + ": " + (String)localObject2;
            }
          }
          else {
            str1 = localObject1 + ": " + localJSONObject.optString("app_shortcut_settings_label");
          }
        }
        else
        {
          localObject1 = new Object[1];
          localObject1[0] = localJSONObject.optString("app_shortcut_settings_label");
          str1 = paramContext.getString(2131099996, (Object[])localObject1);
        }
      }
      else
      {
        str1 = localJSONObject.optString("app_shortcut_settings_label");
        str1 = str1;
      }
      return str1;
      i = 0;
      break;
    }
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, AppShortcutAction.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return null;
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, AppShortcutSelectionActivity.class);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.appshortcut.AppShortcut
 * JD-Core Version:    0.7.0.1
 */