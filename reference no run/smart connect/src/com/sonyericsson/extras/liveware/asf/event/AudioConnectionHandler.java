package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.asf.EventHandler;
import com.sonyericsson.extras.liveware.ui.FlapActivity;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AudioConnectionHandler
  extends ConnectionHandler
{
  private static boolean sHeadset = false;
  
  private List<Intent> audioConnected(Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DeviceService.getDeviceConnectionIntent(paramContext, getAudioProductId(paramInt), true, paramInt, 7, null));
    return localArrayList;
  }
  
  private List<Intent> audioDisconnected(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DeviceService.getDeviceConnectionIntent(paramContext, getAudioProductId(11), false, 11, 7, null));
    localArrayList.add(DeviceService.getDeviceConnectionIntent(paramContext, getAudioProductId(5), false, 5, 7, null));
    return localArrayList;
  }
  
  public static String getAudioProductId(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      Dbg.e("Unknown audio device");
      str = null;
      break;
    case 5: 
      str = "Headset";
      break;
    case 11: 
      str = "Headphones";
    }
    return str;
  }
  
  public static AudioConnectionHandler getNewHandler()
  {
    return new AudioConnectionHandler();
  }
  
  private List<Intent> handleAudio(final Context paramContext, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject = new ArrayList();
    Dbg.v("Headset event!");
    final int i;
    if (paramIntent.getIntExtra("microphone", 0) != 0) {
      i = 5;
    } else {
      i = 11;
    }
    if (!paramBoolean)
    {
      sHeadset = false;
      localObject = audioDisconnected(paramContext);
    }
    else if (i != 11)
    {
      sHeadset = true;
      localObject = audioConnected(paramContext, i);
    }
    else
    {
      TimerTask local1 = new TimerTask()
      {
        public void run()
        {
          if (!AudioConnectionHandler.sHeadset) {
            EventHandler.sendIntentsToDeviceService(paramContext, AudioConnectionHandler.this.audioConnected(paramContext, i));
          }
        }
      };
      sHeadset = false;
      new Timer().schedule(local1, 1000L);
    }
    return localObject;
  }
  
  public void disconnect(Context paramContext)
  {
    Iterator localIterator = audioDisconnected(paramContext).iterator();
    while (localIterator.hasNext()) {
      paramContext.startService((Intent)localIterator.next());
    }
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    return handleAudio(paramContext, paramIntent, true);
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    List localList = handleAudio(paramContext, paramIntent, false);
    if ((AsfUtils.isWaterproof(paramContext)) && (!AsfUtils.hasWaterproofedAudioPlug(paramContext)))
    {
      FlapActivity.show(paramContext, localList);
      localList = null;
    }
    return localList;
  }
  
  public void onStartup(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if (paramIntent.getIntExtra("state", 0) != i) {
      i = 0;
    }
    Iterator localIterator = handleAudio(paramContext, paramIntent, i).iterator();
    while (localIterator.hasNext()) {
      paramContext.startService((Intent)localIterator.next());
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.AudioConnectionHandler
 * JD-Core Version:    0.7.0.1
 */