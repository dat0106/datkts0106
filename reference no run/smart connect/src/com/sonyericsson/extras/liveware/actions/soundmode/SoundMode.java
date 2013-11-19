package com.sonyericsson.extras.liveware.actions.soundmode;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.ActionUtils;

public class SoundMode
  extends AbstractAction
{
  public static final String OBSOLETE_SOUND_MODE_SETTING_LOUD = "loud";
  public static final String SOUND_MODE_SETTING = "sound_mode_setting";
  public static final String SOUND_MODE_SETTING_NORMAL = "normal";
  public static final String SOUND_MODE_SETTING_SILENT = "silent";
  public static final String SOUND_MODE_SETTING_VIBRATE = "vibrate";
  
  public SoundMode()
  {
    super(SoundMode.class.getSimpleName());
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    Object localObject;
    if (!"silent".equals(paramString))
    {
      if (!"vibrate".equals(paramString))
      {
        localObject = paramContext.getString(2131099898);
      }
      else
      {
        localObject = (Vibrator)paramContext.getSystemService("vibrator");
        if ((localObject == null) || (!((Vibrator)localObject).hasVibrator())) {
          localObject = paramContext.getString(2131099899);
        } else {
          localObject = paramContext.getString(2131099932);
        }
      }
    }
    else {
      localObject = paramContext.getString(2131099899);
    }
    return localObject;
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, SoundModeAction.class);
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
    return new Intent(paramContext, SoundModeSettings.class);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.soundmode.SoundMode
 * JD-Core Version:    0.7.0.1
 */