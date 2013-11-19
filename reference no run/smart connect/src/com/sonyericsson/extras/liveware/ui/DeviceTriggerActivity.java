package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.db.ExperienceDef.DeviceTable;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DeviceTriggerActivity
  extends BaseListActivity
  implements LoaderManager.LoaderCallbacks<List<Device>>
{
  public static final int DEVICE_ID_NONE = -1;
  private static final String EXTRA_CURRENT_DEVICE_ID = "current_device_id";
  public static final String EXTRA_SELECTED_DEVICE_ID = "selected_device_id";
  private static final int ITEM_TYPE_COUNT = 2;
  private static final int ITEM_TYPE_DEVICE = 0;
  private static final int ITEM_TYPE_SEPARATOR = 1;
  private DeviceListAdapter mAdapter = null;
  private long mCurrentDeviceId;
  
  public static Intent createIntent(Context paramContext, Device paramDevice)
  {
    Intent localIntent = new Intent(paramContext, DeviceTriggerActivity.class);
    if (paramDevice != null) {
      localIntent.putExtra("current_device_id", paramDevice.getId());
    }
    return localIntent;
  }
  
  private int getFirstNotUsedPosition(ArrayList<Object> paramArrayList)
  {
    for (int i = 0; i < paramArrayList.size(); i++) {
      if (((paramArrayList.get(i) instanceof Device)) && (((Device)paramArrayList.get(i)).getTimestamp() == 0L)) {
        return i;
      }
    }
    i = paramArrayList.size();
    return i;
  }
  
  private Device getNoneDevice()
  {
    Device localDevice = new Device("none", getString(2131099825), null, 0, 0, false, false, false, null, System.currentTimeMillis());
    localDevice.setId(-1L);
    return localDevice;
  }
  
  private boolean hasUsedDevice(List<Device> paramList)
  {
    boolean bool = false;
    if (paramList.size() != 0)
    {
      Device localDevice = (Device)paramList.get(0);
      if ((localDevice != null) && (localDevice.getTimestamp() > 0L)) {
        bool = true;
      }
    }
    return bool;
  }
  
  private void setSelection(List<Device> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Device localDevice = (Device)localIterator.next();
      if (localDevice.getId() == this.mCurrentDeviceId)
      {
        int i = this.mAdapter.getPosition(localDevice);
        getListView().setItemChecked(i, true);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    View localView = LayoutInflater.from(this).inflate(2130903079, null, false);
    this.mCurrentDeviceId = getIntent().getLongExtra("current_device_id", -1L);
    setContentView(localView);
    this.mAdapter = new DeviceListAdapter(this);
    setListAdapter(this.mAdapter);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    getListView().setItemsCanFocus(false);
    getListView().setChoiceMode(1);
    getListView().setFocusable(true);
    getListView().setFocusableInTouchMode(true);
    getListView().requestFocus();
    getListView().setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousInt >= 0)
        {
          Object localObject = DeviceTriggerActivity.this.mAdapter.getItem(paramAnonymousInt);
          if ((localObject instanceof Device))
          {
            localObject = (Device)localObject;
            Intent localIntent = new Intent();
            localIntent.putExtra("selected_device_id", ((Device)localObject).getId());
            DeviceTriggerActivity.this.setResult(-1, localIntent);
            DeviceTriggerActivity.this.finish();
          }
          else
          {
            if (Dbg.e()) {
              Dbg.e("Not valid selection");
            }
            DeviceTriggerActivity.this.finish();
          }
        }
        else
        {
          DeviceTriggerActivity.this.finish();
        }
      }
    });
    getLoaderManager().initLoader(0, null, this);
    setTitle(2131099824);
  }
  
  public Loader<List<Device>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new DeviceListLoader(this);
  }
  
  public void onLoadFinished(Loader<List<Device>> paramLoader, List<Device> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Device localDevice = getNoneDevice();
    localArrayList.add(localDevice);
    if (hasUsedDevice(paramList)) {
      localArrayList.add(new DeviceSeparator(getString(2131099822)));
    }
    localArrayList.addAll(paramList);
    if (getFirstNotUsedPosition(localArrayList) < localArrayList.size()) {
      localArrayList.add(getFirstNotUsedPosition(localArrayList), new DeviceSeparator(getString(2131099823)));
    }
    this.mAdapter.setData(localArrayList);
    if (this.mCurrentDeviceId != -1L) {
      setSelection(paramList);
    } else {
      getListView().setItemChecked(this.mAdapter.getPosition(localDevice), true);
    }
  }
  
  public void onLoaderReset(Loader<List<Device>> paramLoader)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getNoneDevice());
    localArrayList.add(new DeviceSeparator(getString(2131099822)));
    localArrayList.add(new DeviceSeparator(getString(2131099823)));
    this.mAdapter.setData(localArrayList);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Dbg.d("DeviceTriggerActivity.onOptionsItemSelected");
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      finish();
      bool = true;
    }
    return bool;
  }
  
  private static class DeviceListAdapter
    extends ArrayAdapter<Object>
  {
    public DeviceListAdapter(Context paramContext)
    {
      super(17367055);
    }
    
    public boolean areAllItemsEnabled()
    {
      return false;
    }
    
    public int getItemViewType(int paramInt)
    {
      int i;
      if (!(getItem(paramInt) instanceof DeviceTriggerActivity.DeviceSeparator)) {
        i = 0;
      } else {
        i = 1;
      }
      return i;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = getItemViewType(paramInt);
      if (paramView == null)
      {
        int i;
        if (j != 0) {
          i = 2130903070;
        } else {
          i = 2130903068;
        }
        paramView = LayoutInflater.from(getContext()).inflate(i, paramViewGroup, false);
        UIUtils.applyDirectionality(paramView);
      }
      Object localObject;
      if (j != 0)
      {
        localObject = (DeviceTriggerActivity.DeviceSeparator)getItem(paramInt);
        ((TextView)paramView.findViewById(2131558480)).setText(((DeviceTriggerActivity.DeviceSeparator)localObject).getName());
      }
      else
      {
        Device localDevice = (Device)getItem(paramInt);
        localObject = (CheckableListItem)paramView.findViewById(2131558474);
        ((CheckableListItem)localObject).showCheckable(true);
        ((CheckableListItem)localObject).setName(localDevice.getProductName());
        if (localDevice.getIconName() == null)
        {
          if (localDevice.getId() != -1L) {
            ((CheckableListItem)localObject).setIcon(2130837647);
          } else {
            ((CheckableListItem)localObject).hideIcon();
          }
        }
        else {
          ((CheckableListItem)localObject).setIcon(UIUtils.getDrawable(getContext(), localDevice.getIconName()));
        }
      }
      return paramView;
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean isEnabled(int paramInt)
    {
      int i = 1;
      if (getItemViewType(paramInt) == i) {
        i = 0;
      }
      return i;
    }
    
    public void setData(List<Object> paramList)
    {
      clear();
      if (paramList != null) {
        addAll(paramList);
      }
    }
  }
  
  private static class DeviceListLoader
    extends AsyncTaskLoader<List<Device>>
  {
    public static final Comparator<Device> TIME_COMPARATOR = new Comparator()
    {
      public int compare(Device paramAnonymousDevice1, Device paramAnonymousDevice2)
      {
        return Long.valueOf(paramAnonymousDevice2.getTimestamp()).compareTo(Long.valueOf(paramAnonymousDevice1.getTimestamp()));
      }
    };
    private final ExperienceManager mManager;
    private final Loader<List<Device>>.ForceLoadContentObserver mObserver;
    private final ContentResolver mResolver;
    
    public DeviceListLoader(Context paramContext)
    {
      super();
      this.mManager = ExperienceManager.getInstance(paramContext);
      this.mResolver = paramContext.getContentResolver();
      this.mObserver = new Loader.ForceLoadContentObserver(this);
    }
    
    public void deliverResult(List<Device> paramList)
    {
      if (isStarted()) {
        super.deliverResult(paramList);
      }
    }
    
    public List<Device> loadInBackground()
    {
      this.mResolver.registerContentObserver(ExperienceDef.DeviceTable.URI, true, this.mObserver);
      Object localObject = this.mManager.getAllDevices();
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Device localDevice = (Device)((Iterator)localObject).next();
        if (localDevice.getConfigured() == 1) {
          localArrayList.add(localDevice);
        }
      }
      Collections.sort(localArrayList, TIME_COMPARATOR);
      return localArrayList;
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
  
  private static class DeviceSeparator
  {
    private final String mName;
    
    DeviceSeparator(String paramString)
    {
      this.mName = paramString;
    }
    
    String getName()
    {
      return this.mName;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.DeviceTriggerActivity
 * JD-Core Version:    0.7.0.1
 */