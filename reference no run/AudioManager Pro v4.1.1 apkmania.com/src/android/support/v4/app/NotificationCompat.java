package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.RemoteViews;

public class NotificationCompat
{
  public static final int FLAG_HIGH_PRIORITY = 128;
  private static final NotificationCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT < 11) {
      IMPL = new NotificationCompatImplBase();
    } else {
      IMPL = new NotificationCompatImplHoneycomb();
    }
  }
  
  public static class Builder
  {
    CharSequence mContentInfo;
    PendingIntent mContentIntent;
    CharSequence mContentText;
    CharSequence mContentTitle;
    Context mContext;
    PendingIntent mFullScreenIntent;
    Bitmap mLargeIcon;
    Notification mNotification = new Notification();
    int mNumber;
    RemoteViews mTickerView;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
      this.mNotification.when = System.currentTimeMillis();
      this.mNotification.audioStreamType = -1;
    }
    
    private void setFlag(int paramInt, boolean paramBoolean)
    {
      Notification localNotification;
      if (!paramBoolean)
      {
        localNotification = this.mNotification;
        localNotification.flags &= (paramInt ^ 0xFFFFFFFF);
      }
      else
      {
        localNotification = this.mNotification;
        localNotification.flags = (paramInt | localNotification.flags);
      }
    }
    
    public Notification getNotification()
    {
      return NotificationCompat.IMPL.getNotification(this);
    }
    
    public Builder setAutoCancel(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }
    
    public Builder setContent(RemoteViews paramRemoteViews)
    {
      this.mNotification.contentView = paramRemoteViews;
      return this;
    }
    
    public Builder setContentInfo(CharSequence paramCharSequence)
    {
      this.mContentInfo = paramCharSequence;
      return this;
    }
    
    public Builder setContentIntent(PendingIntent paramPendingIntent)
    {
      this.mContentIntent = paramPendingIntent;
      return this;
    }
    
    public Builder setContentText(CharSequence paramCharSequence)
    {
      this.mContentText = paramCharSequence;
      return this;
    }
    
    public Builder setContentTitle(CharSequence paramCharSequence)
    {
      this.mContentTitle = paramCharSequence;
      return this;
    }
    
    public Builder setDefaults(int paramInt)
    {
      this.mNotification.defaults = paramInt;
      if ((paramInt & 0x4) != 0)
      {
        Notification localNotification = this.mNotification;
        localNotification.flags = (0x1 | localNotification.flags);
      }
      return this;
    }
    
    public Builder setDeleteIntent(PendingIntent paramPendingIntent)
    {
      this.mNotification.deleteIntent = paramPendingIntent;
      return this;
    }
    
    public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
    {
      this.mFullScreenIntent = paramPendingIntent;
      setFlag(128, paramBoolean);
      return this;
    }
    
    public Builder setLargeIcon(Bitmap paramBitmap)
    {
      this.mLargeIcon = paramBitmap;
      return this;
    }
    
    public Builder setLights(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      this.mNotification.ledARGB = paramInt1;
      this.mNotification.ledOnMS = paramInt2;
      this.mNotification.ledOffMS = paramInt3;
      int k;
      if ((this.mNotification.ledOnMS == 0) || (this.mNotification.ledOffMS == 0)) {
        k = 0;
      } else {
        k = i;
      }
      Notification localNotification = this.mNotification;
      int j = 0xFFFFFFFE & this.mNotification.flags;
      if (k == 0) {
        i = 0;
      }
      localNotification.flags = (i | j);
      return this;
    }
    
    public Builder setNumber(int paramInt)
    {
      this.mNumber = paramInt;
      return this;
    }
    
    public Builder setOngoing(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }
    
    public Builder setOnlyAlertOnce(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }
    
    public Builder setSmallIcon(int paramInt)
    {
      this.mNotification.icon = paramInt;
      return this;
    }
    
    public Builder setSmallIcon(int paramInt1, int paramInt2)
    {
      this.mNotification.icon = paramInt1;
      this.mNotification.iconLevel = paramInt2;
      return this;
    }
    
    public Builder setSound(Uri paramUri)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = -1;
      return this;
    }
    
    public Builder setSound(Uri paramUri, int paramInt)
    {
      this.mNotification.sound = paramUri;
      this.mNotification.audioStreamType = paramInt;
      return this;
    }
    
    public Builder setTicker(CharSequence paramCharSequence)
    {
      this.mNotification.tickerText = paramCharSequence;
      return this;
    }
    
    public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
    {
      this.mNotification.tickerText = paramCharSequence;
      this.mTickerView = paramRemoteViews;
      return this;
    }
    
    public Builder setVibrate(long[] paramArrayOfLong)
    {
      this.mNotification.vibrate = paramArrayOfLong;
      return this;
    }
    
    public Builder setWhen(long paramLong)
    {
      this.mNotification.when = paramLong;
      return this;
    }
  }
  
  static class NotificationCompatImplHoneycomb
    implements NotificationCompat.NotificationCompatImpl
  {
    public Notification getNotification(NotificationCompat.Builder paramBuilder)
    {
      return NotificationCompatHoneycomb.add(paramBuilder.mContext, paramBuilder.mNotification, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentInfo, paramBuilder.mTickerView, paramBuilder.mNumber, paramBuilder.mContentIntent, paramBuilder.mFullScreenIntent, paramBuilder.mLargeIcon);
    }
  }
  
  static class NotificationCompatImplBase
    implements NotificationCompat.NotificationCompatImpl
  {
    public Notification getNotification(NotificationCompat.Builder paramBuilder)
    {
      Notification localNotification = paramBuilder.mNotification;
      localNotification.setLatestEventInfo(paramBuilder.mContext, paramBuilder.mContentTitle, paramBuilder.mContentText, paramBuilder.mContentIntent);
      return localNotification;
    }
  }
  
  static abstract interface NotificationCompatImpl
  {
    public abstract Notification getNotification(NotificationCompat.Builder paramBuilder);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat
 * JD-Core Version:    0.7.0.1
 */