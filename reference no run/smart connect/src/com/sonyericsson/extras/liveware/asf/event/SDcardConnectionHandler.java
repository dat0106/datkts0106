package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.ui.FlapActivity;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import java.util.ArrayList;
import java.util.List;

public class SDcardConnectionHandler
  extends ConnectionHandler
{
  public static SDcardConnectionHandler getNewHandler()
  {
    return new SDcardConnectionHandler();
  }
  
  private List<Intent> showFlapActivity(Context paramContext, Intent paramIntent)
  {
    ArrayList localArrayList = new ArrayList();
    if (AsfUtils.shouldShowWaterproofWarningForSDcard(paramContext)) {
      FlapActivity.show(paramContext, localArrayList);
    }
    return localArrayList;
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    return showFlapActivity(paramContext, paramIntent);
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    return showFlapActivity(paramContext, paramIntent);
  }
  
  public void onStartup(Context paramContext, Intent paramIntent) {}
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.SDcardConnectionHandler
 * JD-Core Version:    0.7.0.1
 */