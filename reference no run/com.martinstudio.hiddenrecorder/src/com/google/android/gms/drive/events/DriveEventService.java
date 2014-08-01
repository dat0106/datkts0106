package com.google.android.gms.drive.events;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.internal.hn;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class DriveEventService
  extends IntentService
{
  private static final LinkedBlockingDeque<DriveEvent> Ie = new LinkedBlockingDeque();
  private final String mName;
  
  protected DriveEventService()
  {
    this("DriveEventService");
  }
  
  protected DriveEventService(String paramString)
  {
    super(paramString);
    this.mName = paramString;
  }
  
  private void a(DriveEvent paramDriveEvent)
  {
    try
    {
      switch (paramDriveEvent.getType())
      {
      default: 
        Log.w(this.mName, "Unrecognized event: " + paramDriveEvent);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      boolean bool1;
      Log.wtf(this.mName, "Service does not implement listener for type:" + paramDriveEvent.getType(), localClassCastException);
      return;
      boolean bool2 = paramDriveEvent instanceof FileConflictEvent;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramDriveEvent;
      hn.a(bool2, "Unexpected event type: %s", arrayOfObject);
      a((FileConflictEvent)paramDriveEvent);
    }
    catch (Exception localException)
    {
      Log.w(this.mName, "Error handling event: " + paramDriveEvent, localException);
    }
    bool1 = paramDriveEvent instanceof ChangeEvent;
    arrayOfObject = new Object[1];
    arrayOfObject[0] = paramDriveEvent;
    hn.a(bool1, "Unexpected event type: %s", arrayOfObject);
    onChangeEvent((ChangeEvent)paramDriveEvent);
  }
  
  public void a(FileConflictEvent paramFileConflictEvent)
  {
    Log.w("DriveEventService", "Unhandled FileConflictEvent: " + paramFileConflictEvent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    new Binder()
    {
      protected boolean onTransact(int paramAnonymousInt1, Parcel paramAnonymousParcel1, Parcel paramAnonymousParcel2, int paramAnonymousInt2)
      {
        Log.d("DriveEventService", "onTransact");
        DriveEvent localDriveEvent = (DriveEvent)paramAnonymousParcel1.readParcelable(DriveEventService.this.getClassLoader());
        DriveEventService.gi().add(localDriveEvent);
        DriveEventService.this.startService(new Intent(DriveEventService.this, DriveEventService.this.getClass()));
        return true;
      }
    };
  }
  
  public void onChangeEvent(ChangeEvent paramChangeEvent)
  {
    Log.w("DriveEventService", "Unhandled ChangeEvent: " + paramChangeEvent);
  }
  
  protected final void onHandleIntent(Intent paramIntent)
  {
    paramIntent.setExtrasClassLoader(getClassLoader());
    DriveEvent localDriveEvent = (DriveEvent)paramIntent.getParcelableExtra("event");
    if (localDriveEvent == null) {
      localDriveEvent = (DriveEvent)Ie.poll();
    }
    if (localDriveEvent == null) {
      Log.e("DriveEventService", "The event queue is unexpectedly empty.");
    } else {
      a(localDriveEvent);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.DriveEventService
 * JD-Core Version:    0.7.0.1
 */