package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

class NotificationCompatJellybean
{
  private Notification.Builder b;
  
  public NotificationCompatJellybean(Context paramContext, Notification paramNotification, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, RemoteViews paramRemoteViews, int paramInt1, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, Bitmap paramBitmap, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, CharSequence paramCharSequence4)
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
    localBuilder2 = localBuilder2.setAutoCancel(bool1).setDefaults(paramNotification.defaults).setContentTitle(paramCharSequence1).setContentText(paramCharSequence2).setSubText(paramCharSequence4).setContentInfo(paramCharSequence3).setContentIntent(paramPendingIntent1).setDeleteIntent(paramNotification.deleteIntent);
    if ((0x80 & paramNotification.flags) == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.b = localBuilder2.setFullScreenIntent(paramPendingIntent2, bool1).setLargeIcon(paramBitmap).setNumber(paramInt1).setUsesChronometer(paramBoolean2).setPriority(paramInt4).setProgress(paramInt2, paramInt3, paramBoolean1);
  }
  
  public void addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this.b.addAction(paramInt, paramCharSequence, paramPendingIntent);
  }
  
  public void addBigPictureStyle(CharSequence paramCharSequence1, boolean paramBoolean1, CharSequence paramCharSequence2, Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean2)
  {
    Notification.BigPictureStyle localBigPictureStyle = new Notification.BigPictureStyle(this.b).setBigContentTitle(paramCharSequence1).bigPicture(paramBitmap1);
    if (paramBoolean2) {
      localBigPictureStyle.bigLargeIcon(paramBitmap2);
    }
    if (paramBoolean1) {
      localBigPictureStyle.setSummaryText(paramCharSequence2);
    }
  }
  
  public void addBigTextStyle(CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    Notification.BigTextStyle localBigTextStyle = new Notification.BigTextStyle(this.b).setBigContentTitle(paramCharSequence1).bigText(paramCharSequence3);
    if (paramBoolean) {
      localBigTextStyle.setSummaryText(paramCharSequence2);
    }
  }
  
  public void addInboxStyle(CharSequence paramCharSequence1, boolean paramBoolean, CharSequence paramCharSequence2, ArrayList<CharSequence> paramArrayList)
  {
    Notification.InboxStyle localInboxStyle = new Notification.InboxStyle(this.b).setBigContentTitle(paramCharSequence1);
    if (paramBoolean) {
      localInboxStyle.setSummaryText(paramCharSequence2);
    }
    Iterator localIterator = paramArrayList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      localInboxStyle.addLine((CharSequence)localIterator.next());
    }
  }
  
  public Notification build()
  {
    return this.b.build();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompatJellybean
 * JD-Core Version:    0.7.0.1
 */