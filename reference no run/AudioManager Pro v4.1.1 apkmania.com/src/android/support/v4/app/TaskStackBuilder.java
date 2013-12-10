package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskStackBuilder
  implements Iterable<Intent>
{
  private static final TaskStackBuilderImpl IMPL;
  private static final String TAG = "TaskStackBuilder";
  private final ArrayList<Intent> mIntents = new ArrayList();
  private final Context mSourceContext;
  
  static
  {
    if (Build.VERSION.SDK_INT < 11) {
      IMPL = new TaskStackBuilderImplBase();
    } else {
      IMPL = new TaskStackBuilderImplHoneycomb();
    }
  }
  
  private TaskStackBuilder(Context paramContext)
  {
    this.mSourceContext = paramContext;
  }
  
  public static TaskStackBuilder create(Context paramContext)
  {
    return new TaskStackBuilder(paramContext);
  }
  
  public static TaskStackBuilder from(Context paramContext)
  {
    return create(paramContext);
  }
  
  public TaskStackBuilder addNextIntent(Intent paramIntent)
  {
    this.mIntents.add(paramIntent);
    return this;
  }
  
  public TaskStackBuilder addParentStack(Activity paramActivity)
  {
    int i = this.mIntents.size();
    Intent localIntent = NavUtils.getParentActivityIntent(paramActivity);
    while (localIntent != null)
    {
      this.mIntents.add(i, localIntent);
      try
      {
        localIntent = NavUtils.getParentActivityIntent(paramActivity, localIntent.getComponent());
        localIntent = localIntent;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(localNameNotFoundException);
      }
    }
    return this;
  }
  
  public TaskStackBuilder addParentStack(Class<?> paramClass)
  {
    int i = this.mIntents.size();
    try
    {
      for (Intent localIntent = NavUtils.getParentActivityIntent(this.mSourceContext, paramClass); localIntent != null; localIntent = localIntent)
      {
        this.mIntents.add(i, localIntent);
        localIntent = NavUtils.getParentActivityIntent(this.mSourceContext, localIntent.getComponent());
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(localNameNotFoundException);
    }
  }
  
  public Intent editIntentAt(int paramInt)
  {
    return (Intent)this.mIntents.get(paramInt);
  }
  
  public Intent getIntent(int paramInt)
  {
    return editIntentAt(paramInt);
  }
  
  public int getIntentCount()
  {
    return this.mIntents.size();
  }
  
  public Intent[] getIntents()
  {
    return (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
  }
  
  public PendingIntent getPendingIntent(int paramInt1, int paramInt2)
  {
    return getPendingIntent(paramInt1, paramInt2, null);
  }
  
  public PendingIntent getPendingIntent(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (!this.mIntents.isEmpty())
    {
      Intent[] arrayOfIntent = (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
      arrayOfIntent[0].addFlags(268484608);
      return IMPL.getPendingIntent(this.mSourceContext, arrayOfIntent, paramInt1, paramInt2, paramBundle);
    }
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
  }
  
  public Iterator<Intent> iterator()
  {
    return this.mIntents.iterator();
  }
  
  public void startActivities()
  {
    startActivities(null);
  }
  
  public void startActivities(Bundle paramBundle)
  {
    if (!this.mIntents.isEmpty())
    {
      Object localObject = (Intent[])this.mIntents.toArray(new Intent[this.mIntents.size()]);
      localObject[0].addFlags(268484608);
      if (!ContextCompat.startActivities(this.mSourceContext, (Intent[])localObject, paramBundle))
      {
        localObject = localObject[(-1 + localObject.length)];
        ((Intent)localObject).addFlags(268435456);
        this.mSourceContext.startActivity((Intent)localObject);
      }
      return;
    }
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
  }
  
  static class TaskStackBuilderImplJellybean
    implements TaskStackBuilder.TaskStackBuilderImpl
  {
    public PendingIntent getPendingIntent(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2, Bundle paramBundle)
    {
      paramArrayOfIntent[0].addFlags(268468224);
      return TaskStackBuilderJellybean.getActivitiesPendingIntent(paramContext, paramInt1, paramArrayOfIntent, paramInt2, paramBundle);
    }
  }
  
  static class TaskStackBuilderImplHoneycomb
    implements TaskStackBuilder.TaskStackBuilderImpl
  {
    public PendingIntent getPendingIntent(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2, Bundle paramBundle)
    {
      paramArrayOfIntent[0].addFlags(268468224);
      return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(paramContext, paramInt1, paramArrayOfIntent, paramInt2);
    }
  }
  
  static class TaskStackBuilderImplBase
    implements TaskStackBuilder.TaskStackBuilderImpl
  {
    public PendingIntent getPendingIntent(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2, Bundle paramBundle)
    {
      Intent localIntent = paramArrayOfIntent[(-1 + paramArrayOfIntent.length)];
      localIntent.addFlags(268435456);
      return PendingIntent.getActivity(paramContext, paramInt1, localIntent, paramInt2);
    }
  }
  
  static abstract interface TaskStackBuilderImpl
  {
    public abstract PendingIntent getPendingIntent(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2, Bundle paramBundle);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.TaskStackBuilder
 * JD-Core Version:    0.7.0.1
 */