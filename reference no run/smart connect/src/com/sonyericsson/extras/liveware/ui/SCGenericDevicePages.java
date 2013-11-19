package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.sonyericsson.bidi.BidiUtils;
import com.sonyericsson.extras.liveware.db.ExperienceDef.DeviceTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ExperienceTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.FeatureTable;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.ui.list.ListDetail;
import com.sonyericsson.extras.liveware.ui.list.ListDetailAdapter;
import com.sonyericsson.extras.liveware.ui.list.ListSeparator;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.MarketUtils;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SCGenericDevicePages
  extends BaseActivity
  implements LoaderManager.LoaderCallbacks<DevicePageItem>
{
  private static final String EXTRA_DEVICE_ID = "extra_device_id";
  private ListDetailAdapter mAdapter;
  
  private void fillListWithEvents(DevicePageItem paramDevicePageItem, ArrayList<Object> paramArrayList)
  {
    paramArrayList.add(new ListSeparator(getString(2131099969)));
    Iterator localIterator = paramDevicePageItem.mExperiences.iterator();
    while (localIterator.hasNext()) {
      paramArrayList.add(new DeviceDetail(((Experience)localIterator.next()).getName()));
    }
  }
  
  private void fillListWithGenericDeviceInfo(DevicePageItem paramDevicePageItem, ArrayList<Object> paramArrayList)
  {
    fillListWithEvents(paramDevicePageItem, paramArrayList);
  }
  
  private void fillListWithHeadsetInfo(DevicePageItem paramDevicePageItem, ArrayList<Object> paramArrayList)
  {
    Device localDevice = paramDevicePageItem.getDevice();
    ArrayList localArrayList = new ArrayList();
    if (localDevice.getBearerType() != 4) {
      localArrayList.add(new CallKeyDetail(this));
    }
    if (localDevice.hasFeature(2)) {
      localArrayList.add(new AppKeyDetail(this, localDevice.getId()));
    }
    if (!localArrayList.isEmpty())
    {
      paramArrayList.add(new ListSeparator(getString(2131099968)));
      paramArrayList.addAll(localArrayList);
    }
    fillListWithEvents(paramDevicePageItem, paramArrayList);
  }
  
  private void fillPage(DevicePageItem paramDevicePageItem)
  {
    if (paramDevicePageItem != null)
    {
      Object localObject = paramDevicePageItem.getDevice();
      if (localObject != null)
      {
        setTitle(((Device)localObject).getProductName());
        ((ImageView)findViewById(2131558414)).setImageResource(getCategoryImageResourceId((Device)localObject));
        localObject = new ArrayList();
        if (paramDevicePageItem.getDevice().getType() != 5) {
          fillListWithGenericDeviceInfo(paramDevicePageItem, (ArrayList)localObject);
        } else {
          fillListWithHeadsetInfo(paramDevicePageItem, (ArrayList)localObject);
        }
        this.mAdapter.setData((List)localObject);
      }
      else
      {
        Dbg.w("DeviceActivity.fillPage: device == null");
      }
    }
    else
    {
      Dbg.w("DeviceActivity.fillPage: devicePageItem == null");
    }
  }
  
  private int getCategoryImageResourceId(Device paramDevice)
  {
    int i = 2130837649;
    if (paramDevice.getBearerType() != 4) {
      if (paramDevice.getType() != 6)
      {
        if (paramDevice.getType() == 5) {
          i = 2130837651;
        }
      }
      else {
        i = 2130837650;
      }
    }
    return i;
  }
  
  public static void show(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, SCGenericDevicePages.class);
    localIntent.putExtra("extra_device_id", paramLong);
    localIntent.addFlags(67108864);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = LayoutInflater.from(this).inflate(2130903049, null);
    setContentView((View)localObject);
    localObject = (ListView)((View)localObject).findViewById(16908298);
    this.mAdapter = new ListDetailAdapter(this);
    ((ListView)localObject).setAdapter(this.mAdapter);
    ((ListView)localObject).setOnItemClickListener(new DeviceDetailListListener());
    findViewById(2131558413).setVisibility(8);
    getLoaderManager().restartLoader(0, getIntent().getExtras(), this);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    localObject = (ImageView)findViewById(2131558414);
    if ((BidiUtils.shouldMirror((View)localObject)) || (UIUtils.isVanillaRtl(this))) {
      ((ImageView)localObject).setScaleX(-1.0F);
    }
  }
  
  public Loader<DevicePageItem> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new DevicePageLoader(this, paramBundle);
  }
  
  public void onLoadFinished(Loader<DevicePageItem> paramLoader, DevicePageItem paramDevicePageItem)
  {
    findViewById(2131558413).setVisibility(0);
    fillPage(paramDevicePageItem);
  }
  
  public void onLoaderReset(Loader<DevicePageItem> paramLoader) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      HomeScreenActivity.showDeviceTab(this);
      finish();
      bool = true;
    }
    return bool;
  }
  
  class AppKeyDetail
    extends ListDetail
  {
    private Context mContext;
    private long mDeviceId;
    
    public AppKeyDetail(Context paramContext, long paramLong)
    {
      super(null, 2130837594);
      this.mContext = paramContext;
      this.mDeviceId = paramLong;
    }
    
    public boolean isClickable()
    {
      return true;
    }
    
    public void onClick()
    {
      Intent localIntent = new Intent("com.sonyericsson.extras.liveware.START_SMART_KEY_VIEW");
      localIntent.putExtra("com.sonyericsson.extras.liveware.extra.smartdevice", this.mDeviceId);
      this.mContext.startActivity(localIntent);
    }
  }
  
  class CallKeyDetail
    extends ListDetail
  {
    private String cls = "com.sonymobile.extras.liveware.extension.smartkey/com.sonymobile.extras.liveware.extension.smartkey.view.activity.SmartKeyMain";
    private Context ctx;
    private ApplicationData hostApp;
    
    public CallKeyDetail(Context paramContext)
    {
      super(null, 2130837643);
      this.ctx = paramContext;
      ComponentName localComponentName = ComponentName.unflattenFromString(this.cls);
      this.hostApp = new ApplicationData(this.ctx, localComponentName);
    }
    
    private boolean trySendStartActivity(String paramString, ComponentName paramComponentName)
    {
      Intent localIntent = new Intent(paramString);
      localIntent.setComponent(paramComponentName);
      localIntent.addFlags(268435456);
      if (PackageUtils.canHandleIntent(this.ctx, paramComponentName, localIntent)) {
        try
        {
          this.ctx.startActivity(localIntent);
          boolean bool = true;
          return bool;
        }
        catch (Exception localException)
        {
          if (Dbg.e()) {
            Dbg.e("Cannot launch activity " + localException.getMessage());
          }
        }
      }
      for (;;)
      {
        int i = 0;
        break;
        if (Dbg.e()) {
          Dbg.e("Cannot launch activity, it does not handle " + i);
        }
      }
    }
    
    public String getDescription()
    {
      String str;
      if (this.hostApp.exists()) {
        str = null;
      } else {
        str = SCGenericDevicePages.this.getString(2131099737);
      }
      return str;
    }
    
    public boolean isClickable()
    {
      return true;
    }
    
    public void onClick()
    {
      if (!this.hostApp.exists()) {
        MarketUtils.launchInfo(this.ctx, this.hostApp.getPackageName());
      } else {
        trySendStartActivity("android.intent.action.MAIN", this.hostApp.getComponentName());
      }
    }
  }
  
  static class DeviceDetail
    extends ListDetail
  {
    public DeviceDetail(String paramString)
    {
      super();
    }
    
    public boolean isClickable()
    {
      return true;
    }
  }
  
  protected class DeviceDetailListListener
    implements AdapterView.OnItemClickListener
  {
    protected DeviceDetailListListener() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Object localObject = SCGenericDevicePages.this.mAdapter.getItem(paramInt);
      if ((localObject instanceof ListDetail)) {
        ((ListDetail)localObject).onClick();
      }
    }
  }
  
  static class DevicePageItem
  {
    private final Device mDevice;
    private final List<Experience> mExperiences;
    
    DevicePageItem(Device paramDevice, List<Experience> paramList)
    {
      this.mDevice = paramDevice;
      this.mExperiences = paramList;
    }
    
    Device getDevice()
    {
      return this.mDevice;
    }
    
    List<Experience> getExperiences()
    {
      return this.mExperiences;
    }
  }
  
  private static class DevicePageLoader
    extends AsyncTaskLoader<SCGenericDevicePages.DevicePageItem>
  {
    private final Bundle mArgs;
    private final ExperienceManager mManager;
    private final Loader<SCGenericDevicePages.DevicePageItem>.ForceLoadContentObserver mObserver;
    private final ContentResolver mResolver;
    
    public DevicePageLoader(Context paramContext, Bundle paramBundle)
    {
      super();
      this.mArgs = paramBundle;
      this.mManager = ExperienceManager.getInstance(paramContext);
      this.mResolver = paramContext.getContentResolver();
      this.mObserver = new Loader.ForceLoadContentObserver(this);
    }
    
    public void deliverResult(SCGenericDevicePages.DevicePageItem paramDevicePageItem)
    {
      if (isStarted()) {
        super.deliverResult(paramDevicePageItem);
      }
    }
    
    public SCGenericDevicePages.DevicePageItem loadInBackground()
    {
      this.mResolver.registerContentObserver(ExperienceDef.DeviceTable.URI, true, this.mObserver);
      this.mResolver.registerContentObserver(ExperienceDef.FeatureTable.URI, true, this.mObserver);
      this.mResolver.registerContentObserver(ExperienceDef.ExperienceTable.URI, true, this.mObserver);
      Object localObject;
      Device localDevice;
      if (!this.mArgs.containsKey("extra_device_id"))
      {
        localObject = this.mArgs.getString("com.sonymobile.smartconnect.EXTRA_DEVICE_UNIQUE_ID");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          localDevice = this.mManager.getDeviceByProductIdAndBearer(this.mArgs.getString("com.sonymobile.smartconnect.EXTRA_DEVICE_IDENTIFY_NAME"), this.mArgs.getInt("com.sonymobile.smartconnect.EXTRA_DEVICE_CATEGORY"));
        } else {
          localDevice = this.mManager.getDeviceByKeyId((String)localObject);
        }
      }
      else
      {
        localDevice = this.mManager.getDeviceById(this.mArgs.getLong("extra_device_id"));
      }
      if (localDevice == null) {
        localObject = null;
      } else {
        localObject = this.mManager.getExperiencesByDeviceId(localDevice.getId());
      }
      return new SCGenericDevicePages.DevicePageItem(localDevice, (List)localObject);
    }
    
    protected void onReset()
    {
      super.onReset();
      onStopLoading();
      this.mResolver.unregisterContentObserver(this.mObserver);
    }
    
    protected void onStartLoading()
    {
      forceLoad();
    }
    
    protected void onStopLoading()
    {
      cancelLoad();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.SCGenericDevicePages
 * JD-Core Version:    0.7.0.1
 */