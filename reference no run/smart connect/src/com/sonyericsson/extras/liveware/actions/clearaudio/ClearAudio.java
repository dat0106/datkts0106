package com.sonyericsson.extras.liveware.actions.clearaudio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.actions.OnOffToggleActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ReflectionUtils;

public class ClearAudio
  extends AbstractAction
{
  protected static final String CLASSNAME = "com.sonymobile.audioeffect.ClearAudioPlus";
  
  public ClearAudio()
  {
    super(ClearAudio.class.getSimpleName());
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, ClearAudioAction.class);
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
    return new Intent(paramContext, ClearAudioActivity.class);
  }
  
  protected boolean isCompatible(Context paramContext)
  {
    boolean bool;
    if (!ReflectionUtils.classExists("com.sonymobile.audioeffect.ClearAudioPlus"))
    {
      bool = false;
    }
    else
    {
      bool = ReflectionUtils.getResultFromMethod("com.sonymobile.audioeffect.ClearAudioPlus", "isGlobalSetting", getBaseContext());
      Dbg.d("ClearAudio.isCompatible: " + bool);
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.clearaudio.ClearAudio
 * JD-Core Version:    0.7.0.1
 */