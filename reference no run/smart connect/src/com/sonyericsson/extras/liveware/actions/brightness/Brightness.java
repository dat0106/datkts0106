package com.sonyericsson.extras.liveware.actions.brightness;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class Brightness
  extends AbstractAction
{
  public static final String BRIGHTNESS_SETTING = "brightness";
  public static final int MAXIMUM_BACKLIGHT = 255;
  public static final int MINIMUM_BACKLIGHT = 20;
  
  public Brightness()
  {
    super(Brightness.class.getSimpleName());
  }
  
  public static String getBrightnessPercentageString(int paramInt)
  {
    return Integer.toString(paramInt * 100 / 255) + "%";
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    int j = 0;
    try
    {
      int i = Integer.parseInt(paramString);
      j = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Dbg.e(localNumberFormatException);
      }
    }
    return getBrightnessPercentageString(j);
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, BrightnessAction.class);
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
    return new Intent(paramContext, BrightnessSettings.class);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.brightness.Brightness
 * JD-Core Version:    0.7.0.1
 */