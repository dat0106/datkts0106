package com.sonyericsson.extras.liveware.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Tracker;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.Iterator;
import java.util.List;

public class AnalyticsService
  extends IntentService
{
  private static final String ACTION_ADD_HIT = "com.sonyericsson.extras.liveware.analytics.addHit";
  private static final String ACTION_DISPATCH = "com.sonyericsson.extras.liveware.analytics.dispatch";
  private static final long DISPATCH_INTERVAL = 604800000L;
  private static final String EXTRA_ACTION = "action";
  private static final String EXTRA_CATEGORY = "category";
  private static final String EXTRA_LABEL = "label";
  private static final String KEY_LAST_DISPATCH_TIME = "AnalyticsLastDispatchTime";
  private AnalyticsDao mAnalyticsDao;
  
  public AnalyticsService()
  {
    super(AnalyticsService.class.getName());
  }
  
  static void addHit(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent("com.sonyericsson.extras.liveware.analytics.addHit");
    localIntent.setClass(paramContext, AnalyticsService.class);
    localIntent.putExtra("category", paramString1);
    localIntent.putExtra("action", paramString2);
    localIntent.putExtra("label", paramString3);
    paramContext.startService(localIntent);
  }
  
  private void addHit(String paramString1, String paramString2, String paramString3)
  {
    Hit localHit = new Hit(paramString1, paramString2, paramString3);
    if (Dbg.d()) {
      Dbg.d("AnalyticsSerivce.addHit:" + localHit);
    }
    this.mAnalyticsDao.addHit(localHit);
  }
  
  private void dispatch()
  {
    Object localObject = this.mAnalyticsDao.removeAllHits();
    Iterator localIterator;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (Dbg.d()) {
        Dbg.d("AnalyticsService.dispatch hits: " + ((List)localObject).size());
      }
      SmartConnectAnalytics.init(this);
      localIterator = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      localObject = (Hit)localIterator.next();
      EasyTracker.getTracker().sendEvent(((Hit)localObject).getCategory(), ((Hit)localObject).getAction(), ((Hit)localObject).getLabel(), Long.valueOf(((Hit)localObject).getValue()));
    }
  }
  
  public static void dispatchIfAllowed(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (isDispatchAllowed(paramContext, l))
    {
      Object localObject = new Intent("com.sonyericsson.extras.liveware.analytics.dispatch");
      ((Intent)localObject).setClass(paramContext, AnalyticsService.class);
      paramContext.startService((Intent)localObject);
      localObject = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      ((SharedPreferences.Editor)localObject).putLong("AnalyticsLastDispatchTime", l);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  private static boolean isDispatchAllowed(Context paramContext, long paramLong)
  {
    boolean bool;
    if (paramLong <= 604800000L + PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("AnalyticsLastDispatchTime", 0L)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mAnalyticsDao = new AnalyticsDao(this);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (!TextUtils.equals("com.sonyericsson.extras.liveware.analytics.dispatch", paramIntent.getAction()))
    {
      if (TextUtils.equals("com.sonyericsson.extras.liveware.analytics.addHit", paramIntent.getAction()))
      {
        addHit(paramIntent.getStringExtra("category"), paramIntent.getStringExtra("action"), paramIntent.getStringExtra("label"));
        dispatchIfAllowed(this);
      }
    }
    else {
      dispatch();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.analytics.AnalyticsService
 * JD-Core Version:    0.7.0.1
 */