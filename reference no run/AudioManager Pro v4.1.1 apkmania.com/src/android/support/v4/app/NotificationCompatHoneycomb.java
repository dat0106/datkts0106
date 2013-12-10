package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

class NotificationCompatHoneycomb
{
  static Notification add(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap)
  {
    Notification.Builder localBuilder2 = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    boolean bool1;
    if ((0x2 & paramNotification.flags) == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Notification.Builder localBuilder1 = localBuilder2.setOngoing(bool1);
    boolean bool3;
    if ((0x8 & paramNotification.flags) == 0) {
      bool3 = false;
    } else {
      bool3 = true;
    }
    Notification.Builder localBuilder3 = localBuilder1.setOnlyAlertOnce(bool3);
    boolean bool2;
    if ((0x10 & paramNotification.flags) == 0) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    localBuilder3 = localBuilder3.setAutoCancel(bool2).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
    if ((0x80 & paramNotification.flags) == 0) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    return localBuilder3.setFullScreenIntent(paramPendingIntent2, bool2).setLargeIcon(paramBitmap).setNumber(paramInt).getNotification();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatHoneycomb
 * JD-Core Version:    0.7.0.1
 */