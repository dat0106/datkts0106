package com.sonyericsson.extras.liveware.actions.wifidisplay;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.actions.OnOffToggleActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class WifiDisplay
  extends AbstractAction
{
  public WifiDisplay()
  {
    super(WifiDisplay.class.getSimpleName());
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    Dbg.v("Wi-Fi Display - getExecuteIntent()");
    return new Intent(paramContext, WifiDisplayAction.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    Dbg.v("Wi-Fi Display - getInjectSettingsIntent()");
    return ActionUtils.getSettingsHandlerIntent(paramContext, paramIntent);
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    Dbg.v("Wi-Fi Display - getLocalizedSetting()");
    return OnOffToggleActivity.getLabelByRawSetting(paramContext, paramIntent.getExtras().getString("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    Dbg.v("Wi-Fi Display - getSettingsIntent()");
    return new Intent(paramContext, WifiDisplayActivity.class);
  }
  
  protected boolean isCompatible(Context paramContext)
  {
    boolean bool = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    Dbg.v("Wi-Fi Display - checkCompatibility()");
    try
    {
      localPackageManager.getApplicationInfo("com.sonymobile.tvout.wifidisplay", 0);
      Dbg.v("Wi-Fi Display - checkCompatibility() -> pm.getApplicationInfo(com.sonymobile.tvout.wifidisplay, 0 ); OK -> Action is available on this platform");
      bool = true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Dbg.v("Wi-Fi Display - checkCompatibility() -> pm.getApplicationInfo(com.sonymobile.tvout.wifidisplay, 0 ); Fails -> Action is not available on this platform");
      }
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.wifidisplay.WifiDisplay
 * JD-Core Version:    0.7.0.1
 */