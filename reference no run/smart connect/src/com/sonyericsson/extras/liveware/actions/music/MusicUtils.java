package com.sonyericsson.extras.liveware.actions.music;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.io.File;

public class MusicUtils
{
  public static void playTrack(Context paramContext, String paramString, MusicService paramMusicService)
  {
    int i = 1;
    ((PowerManager)paramContext.getSystemService("power")).newWakeLock(268435462, "PlayBack").acquire(3000L);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "audio/*");
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
        i = 0;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Dbg.e(localIllegalArgumentException.getMessage());
        if (!Dbg.isDebugMode()) {
          continue;
        }
        localIllegalArgumentException.printStackTrace();
        continue;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Dbg.e(localIllegalStateException.getMessage());
        if (!Dbg.isDebugMode()) {
          continue;
        }
        localIllegalStateException.printStackTrace();
        continue;
      }
      paramMusicService.replyAndStop(i);
      return;
      Dbg.d("No MUSIC setting.");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.MusicUtils
 * JD-Core Version:    0.7.0.1
 */