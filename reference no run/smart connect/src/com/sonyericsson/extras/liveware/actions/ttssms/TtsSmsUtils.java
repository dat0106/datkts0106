package com.sonyericsson.extras.liveware.actions.ttssms;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class TtsSmsUtils
{
  private static final int NOTIFICATION_ID = 2;
  private static final String NOTIFICATION_TAG = "tts_sms";
  private static final String SPEAK_INCOMMING_SMS = "speak_incomming_sms";
  private static final String TTS_GENERAL_PREFS = "tts_general_prefs";
  
  private static void cancelNotification(Context paramContext)
  {
    ((NotificationManager)paramContext.getSystemService("notification")).cancel("tts_sms", 2);
  }
  
  public static void doStartupCheck(Context paramContext)
  {
    if (isSpeakSmsEnabled(paramContext)) {
      showNotification(paramContext);
    }
  }
  
  public static void enablesSpeakSms(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("tts_general_prefs", 0).edit().putBoolean("speak_incomming_sms", paramBoolean).commit();
    Dbg.d("TtsSmsAction - enablesSpeakSms " + paramBoolean);
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putBoolean(paramContext.getString(2131099736), paramBoolean);
    localEditor.commit();
    if (!paramBoolean) {
      cancelNotification(paramContext);
    } else {
      showNotification(paramContext);
    }
  }
  
  public static boolean isSpeakSmsEnabled(Context paramContext)
  {
    return paramContext.getSharedPreferences("tts_general_prefs", 0).getBoolean("speak_incomming_sms", false);
  }
  
  private static void showNotification(Context paramContext)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, TtsSmsTurnOffActivity.class), 0);
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    localBuilder.setContentIntent(localPendingIntent);
    localBuilder.setSmallIcon(2130837605);
    localBuilder.setOngoing(true);
    localBuilder.setTicker(paramContext.getString(2131099948));
    localBuilder.setContentTitle(paramContext.getString(2131099946));
    localBuilder.setContentText(paramContext.getString(2131099947));
    localNotificationManager.notify("tts_sms", 2, localBuilder.getNotification());
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ttssms.TtsSmsUtils
 * JD-Core Version:    0.7.0.1
 */