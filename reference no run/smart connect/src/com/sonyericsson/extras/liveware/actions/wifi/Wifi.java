package com.sonyericsson.extras.liveware.actions.wifi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.actions.OnOffToggleActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;

public class Wifi
  extends AbstractAction
{
  public Wifi()
  {
    super(Wifi.class.getSimpleName());
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, WifiAction.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return ActionUtils.getSettingsHandlerIntent(paramContext, paramIntent);
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return OnOffToggleActivity.getLabelByRawSetting(paramContext, paramIntent.getExtras().getString("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, WifiActivity.class);
  }
  
  protected boolean isCompatible(Context paramContext)
  {
    boolean bool;
    if (paramContext.getPackageManager().hasSystemFeature("android.hardware.wifi")) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.wifi.Wifi
 * JD-Core Version:    0.7.0.1
 */