package com.sonyericsson.extras.liveware.actions.bluetooth.a2dp;

import android.app.ActionBar;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sonyericsson.extras.liveware.ui.BaseListActivity;
import com.sonyericsson.extras.liveware.ui.CheckableListItem;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class BluetoothA2dpSettings
  extends BaseListActivity
{
  private String mRawSetting;
  private String mSelectedDevice;
  
  private List<BluetoothDevice> getBondedDevices()
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    ArrayList localArrayList = new ArrayList();
    localObject = ((BluetoothAdapter)localObject).getBondedDevices().iterator();
    while (((Iterator)localObject).hasNext())
    {
      BluetoothDevice localBluetoothDevice = (BluetoothDevice)((Iterator)localObject).next();
      if (new ReflectedBluetoothClass(localBluetoothDevice.getBluetoothClass()).doesClassMatch(ReflectedBluetoothClass.PROFILE_A2DP)) {
        localArrayList.add(localBluetoothDevice);
      }
    }
    return localArrayList;
  }
  
  private void renderView()
  {
    this.mSelectedDevice = "";
    if (!TextUtils.isEmpty(this.mRawSetting)) {}
    try
    {
      this.mSelectedDevice = new JSONObject(this.mRawSetting).getString(getString(2131099651));
      ListView localListView = getListView();
      Object localObject2;
      if (localListView.getHeaderViewsCount() == 0)
      {
        localObject1 = LayoutInflater.from(this).inflate(2130903066, localListView, false);
        UIUtils.applyDirectionality((View)localObject1);
        localObject2 = (CheckableListItem)((View)localObject1).findViewById(2131558474);
        ((CheckableListItem)localObject2).setIcon(2130837550);
        ((CheckableListItem)localObject2).setName(2131099875);
        localListView.addHeaderView((View)localObject1);
        ((CheckableListItem)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent = new Intent("android.settings.BLUETOOTH_SETTINGS");
            BluetoothA2dpSettings.this.startActivity(localIntent);
          }
        });
      }
      Object localObject1 = getBondedDevices();
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        Dbg.d("No bonded devices");
        if (localListView.getFooterViewsCount() == 0)
        {
          localObject2 = LayoutInflater.from(this).inflate(2130903050, localListView, false);
          UIUtils.applyDirectionality((View)localObject2);
          localListView.addFooterView((View)localObject2, null, false);
          setListAdapter(new DeviceAdapter(this, (List)localObject1));
          setInitialCheck((List)localObject1);
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
        continue;
        View localView = findViewById(2131558415);
        if (localView != null)
        {
          localView.setVisibility(0);
          continue;
          localView = findViewById(2131558415);
          if (localView != null) {
            localView.setVisibility(8);
          }
        }
      }
    }
  }
  
  private void setInitialCheck(List<BluetoothDevice> paramList)
  {
    for (int i = 0; i < paramList.size(); i++) {
      if (this.mSelectedDevice.equals(((BluetoothDevice)paramList.get(i)).getAddress())) {
        getListView().setItemChecked(i + 1, true);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903079);
    setTitle(2131099881);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    getListView().setChoiceMode(1);
    getActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  protected void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    BluetoothDevice localBluetoothDevice = (BluetoothDevice)getListAdapter().getItem(paramInt);
    String str1 = null;
    String str2 = null;
    if (localBluetoothDevice != null) {}
    try
    {
      str1 = BluetoothA2dp.buildRawSetting(this, localBluetoothDevice.getAddress(), localBluetoothDevice.getName());
      str2 = BluetoothA2dp.getLabelByRawSetting(this, str1);
      getListView().setItemChecked(paramInt, true);
      ActionUtils.finishActivityWithSetting(this, str1, str2);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Dbg.d("ExperienceActivity.onOptionsItemSelected");
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
  
  protected void onResume()
  {
    super.onResume();
    renderView();
  }
  
  private static class DeviceAdapter
    extends BaseAdapter
  {
    private Context mContext;
    private final List<BluetoothDevice> mDevices;
    
    public DeviceAdapter(Context paramContext, List<BluetoothDevice> paramList)
    {
      this.mDevices = paramList;
      this.mContext = paramContext;
    }
    
    public int getCount()
    {
      return this.mDevices.size();
    }
    
    public Object getItem(int paramInt)
    {
      Object localObject;
      if ((this.mDevices == null) || (this.mDevices.size() <= 0) || (paramInt <= 0)) {
        localObject = null;
      } else {
        localObject = this.mDevices.get(paramInt - 1);
      }
      return localObject;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      BluetoothDevice localBluetoothDevice = (BluetoothDevice)this.mDevices.get(paramInt);
      View localView = LayoutInflater.from(this.mContext).inflate(2130903080, paramViewGroup, false);
      UIUtils.applyDirectionality(localView);
      ((CheckedTextView)localView.findViewById(2131558506)).setText(localBluetoothDevice.getName());
      return localView;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.bluetooth.a2dp.BluetoothA2dpSettings
 * JD-Core Version:    0.7.0.1
 */