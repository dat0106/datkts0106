package com.sonyericsson.extras.liveware.actions.homescreen;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.ActionUtils;

public class Homescreen
  extends AbstractAction
{
  public Homescreen()
  {
    super(Homescreen.class.getSimpleName());
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, HomescreenAction.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return null;
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return "";
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return null;
  }
  
  protected void onInjectSettings(Context paramContext, Intent paramIntent)
  {
    ActionUtils.sendInjectSettingsResponseIntent(paramContext, paramIntent.getStringExtra("id"), 0, null);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.homescreen.Homescreen
 * JD-Core Version:    0.7.0.1
 */