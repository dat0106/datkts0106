package com.sonyericsson.extras.liveware.actions.appshortcut;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

public class AppShortcutAction
  extends ActionService
{
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    for (int i = 0;; i = 1)
    {
      try
      {
        localObject = new JSONObject(paramString2);
        localComponentName = ComponentName.unflattenFromString(((JSONObject)localObject).optString("app_shortcut_component"));
        if (localComponentName == null) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          ComponentName localComponentName;
          Dbg.e(localJSONException);
          int j = 1;
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          Dbg.e(localURISyntaxException);
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          label106:
          Dbg.e(localRuntimeException);
        }
      }
      try
      {
        getPackageManager().getActivityInfo(localComponentName, 0);
        localObject = ((JSONObject)localObject).getString("app_shortcut_setting");
        ((PowerManager)paramContext.getSystemService("power")).newWakeLock(268435462, "AppShortcutAction").acquire(3000L);
        localObject = Intent.parseUri((String)localObject, 0);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).setSourceBounds(new Rect());
        startActivity((Intent)localObject);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        i = 1;
        break label106;
      }
      return i;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.appshortcut.AppShortcutAction
 * JD-Core Version:    0.7.0.1
 */