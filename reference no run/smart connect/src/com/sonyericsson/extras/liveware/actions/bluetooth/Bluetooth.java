package com.sonyericsson.extras.liveware.actions.bluetooth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.actions.OnOffToggleActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;

public class Bluetooth
  extends AbstractAction
{
  public Bluetooth()
  {
    super(Bluetooth.class.getSimpleName());
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, BluetoothAction.class);
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
    return new Intent(paramContext, BluetoothActivity.class);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.bluetooth.Bluetooth
 * JD-Core Version:    0.7.0.1
 */