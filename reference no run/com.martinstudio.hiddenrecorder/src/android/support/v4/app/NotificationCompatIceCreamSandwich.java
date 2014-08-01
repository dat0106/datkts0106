package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

class NotificationCompatIceCreamSandwich
{
  static Notification add(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Notification.Builder localBuilder1 = new Notification.Builder(paramContext).setWhen(paramNotification.when).setSmallIcon(paramNotification.icon, paramNotification.iconLevel).setContent(paramNotification.contentView).setTicker(paramNotification.tickerText, paramRemoteViews).setSound(paramNotification.sound, paramNotification.audioStreamType).setVibrate(paramNotification.vibrate).setLights(paramNotification.ledARGB, paramNotification.ledOnMS, paramNotification.ledOffMS);
    boolean bool2;
    if ((0x2 & paramNotification.flags) == 0) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    localBuilder1 = localBuilder1.setOngoing(bool2);
    if ((0x8 & paramNotification.flags) == 0) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    Notification.Builder localBuilder2 = localBuilder1.setOnlyAlertOnce(bool2);
    boolean bool1;
    if ((0x10 & paramNotification.flags) == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    localBuilder2 = localBuilder2.setAutoCancel(bool1).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
    if ((0x80 & paramNotification.flags) == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    return localBuilder2.setFullScreenIntent(paramPendingIntent2, bool1).setLargeIcon(paramBitmap).setNumber(paramInt1).setProgress(paramInt2, paramInt3, paramBoolean).getNotification();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatIceCreamSandwich
 * JD-Core Version:    0.7.0.1
 */