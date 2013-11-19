package com.sonyericsson.extras.liveware.actions.urllaunch;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.ActionUtils;

public class UrlLauncher
  extends AbstractAction
{
  public UrlLauncher()
  {
    super(UrlLauncher.class.getSimpleName());
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    return paramString;
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, UrlService.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return ActionUtils.getSettingsHandlerIntent(paramContext, paramIntent);
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, UrlSettings.class);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.urllaunch.UrlLauncher
 * JD-Core Version:    0.7.0.1
 */