package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.asf.InstallReceiver;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.MarketUtils;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.List;
import java.util.Locale;

public class SmartDeviceFragment
  extends ListFragment
  implements LoaderManager.LoaderCallbacks<List<Device>>
{
  private static final int APPLICATION_VARIANT_DOWNLOAD = 0;
  private static final int APPLICATION_VARIANT_INSTALLED = 1;
  private static final int APPLICATION_VARIANT_PLUGINS = 2;
  private static final int APPLICATION_VARIANT_SELECT = 3;
  private Activity mActivity;
  private SmartDeviceArrayAdapter mArrayAdapter;
  
  private int getAppVariant(Device paramDevice, int paramInt)
  {
    int i = 3;
    ApplicationData localApplicationData = PackageUtils.getDefault(this.mActivity, paramDevice, paramInt);
    Feature localFeature = paramDevice.getFeature(paramInt);
    if ((localApplicationData == null) || ((!localApplicationData.getPackageName().equals("com.sonyericsson.extras.liveview")) && ((!localApplicationData.getPackageName().equals("com.sonyericsson.extras.liveware.test")) || (!localApplicationData.getComponentName().getShortClassName().equals(".components.FakeLiveView")))) || (!paramDevice.getProductId().equals("LiveView")))
    {
      if ((localFeature.getCompanionPkg() != null) && (localFeature.getType() == 4)) {
        if (localApplicationData != null) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    else {
      i = 2;
    }
    return i;
  }
  
  private void goToWebshop()
  {
    String str1 = "http://www.sonymobile.com/products/accessories/";
    String str2 = null;
    Context localContext = getActivity().getApplicationContext();
    Object localObject = (TelephonyManager)localContext.getSystemService("phone");
    if (localObject != null) {
      str2 = ((TelephonyManager)localObject).getNetworkCountryIso();
    }
    if (TextUtils.isEmpty(str2)) {
      str2 = localContext.getResources().getConfiguration().locale.getCountry().toLowerCase(Locale.ENGLISH);
    }
    if (!TextUtils.isEmpty(str2)) {
      if (!"se".equals(str2))
      {
        if (!"de".equals(str2))
        {
          if (!"gb".equals(str2))
          {
            if (!"es".equals(str2))
            {
              if (!"fr".equals(str2))
              {
                if (!"nl".equals(str2))
                {
                  if ("it".equals(str2)) {
                    str1 = "http://shop.sonymobile.com/it/";
                  }
                }
                else {
                  str1 = "http://shop.sonymobile.com/nl/";
                }
              }
              else {
                str1 = "http://shop.sonymobile.com/fr/";
              }
            }
            else {
              str1 = "http://shop.sonymobile.com/es/";
            }
          }
          else {
            str1 = "http://shop.sonymobile.com/gb/";
          }
        }
        else {
          str1 = "http://shop.sonymobile.com/de/";
        }
      }
      else {
        str1 = "http://shop.sonymobile.com/se/";
      }
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setData(Uri.parse(str1));
    ((Intent)localObject).addFlags(268435456);
    startActivity((Intent)localObject);
  }
  
  private void handleDeviceActivityClick(Device paramDevice)
  {
    paramDevice.showDevicePageActivity(this.mActivity);
  }
  
  private void handleDeviceClick(Device paramDevice)
  {
    SCGenericDevicePages.show(this.mActivity, paramDevice.getId());
  }
  
  private void handleSmartLaunchClick(Device paramDevice)
  {
    int i = getAppVariant(paramDevice, 4);
    ApplicationData localApplicationData = PackageUtils.getDefault(this.mActivity, paramDevice, 4);
    switch (i)
    {
    default: 
      if (Dbg.e()) {
        Dbg.e("Unexpected variant for smart launch: " + i);
      }
      break;
    case 0: 
      Feature localFeature = paramDevice.getFeature(4);
      MarketUtils.launchInfo(this.mActivity, localFeature.getCompanionPkg());
      InstallReceiver.runInstallReceiver(this.mActivity, localFeature.getCompanionPkg(), paramDevice.getId(), localFeature.getType(), false);
      break;
    case 1: 
      if (!tryStartSettings(localApplicationData)) {
        tryLaunch(localApplicationData);
      }
      break;
    case 2: 
      tryLaunch(localApplicationData);
    }
  }
  
  private void renderSmartLaunch(CheckableListItem paramCheckableListItem, Device paramDevice, Context paramContext)
  {
    String str = paramDevice.getIconName();
    if (str == null) {
      paramCheckableListItem.setIcon(2130837647);
    } else {
      paramCheckableListItem.setIcon(paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName()));
    }
    int i = getAppVariant(paramDevice, 4);
    switch (i)
    {
    default: 
      if (Dbg.e()) {
        Dbg.e("Unexpected variant for smart launch: " + i);
      }
      break;
    case 0: 
      paramCheckableListItem.setDescription(2131099737);
      break;
    case 1: 
      paramCheckableListItem.hideDescription();
      break;
    case 2: 
      paramCheckableListItem.setDescription(2131099773);
    }
  }
  
  private void showList()
  {
    View localView = getView();
    if (localView != null) {
      localView.findViewById(2131558507).setVisibility(0);
    }
  }
  
  private void tryLaunch(ApplicationData paramApplicationData)
  {
    if (paramApplicationData != null) {
      trySendStartActivity("android.intent.action.MAIN", "android.intent.category.LAUNCHER", paramApplicationData.getComponentName());
    }
  }
  
  private boolean trySendStartActivity(String paramString1, String paramString2, ComponentName paramComponentName)
  {
    if (paramComponentName.getPackageName().equals("com.sonyericsson.extras.liveview")) {
      paramComponentName = new ComponentName("com.sonyericsson.extras.liveview", "com.sonyericsson.extras.liveview.settings.Preferences");
    }
    Intent localIntent = new Intent(paramString1);
    localIntent.setComponent(paramComponentName);
    localIntent.addFlags(268435456);
    localIntent.addCategory(paramString2);
    if (PackageUtils.canHandleIntent(this.mActivity, paramComponentName, localIntent)) {
      try
      {
        this.mActivity.startActivity(localIntent);
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
  
  private boolean tryStartSettings(ApplicationData paramApplicationData)
  {
    boolean bool = false;
    if (paramApplicationData != null)
    {
      ApplicationData localApplicationData = PackageUtils.getSettingsActivity(this.mActivity, paramApplicationData.getPackageName());
      if (localApplicationData != null) {
        bool = trySendStartActivity("com.sonyericsson.extras.SETTINGS", "android.intent.category.DEFAULT", localApplicationData.getComponentName());
      }
    }
    return bool;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getListView().setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Device localDevice = (Device)SmartDeviceFragment.this.getListAdapter().getItem(paramAnonymousInt);
        if (!localDevice.hasFeature(4))
        {
          if (TextUtils.isEmpty(localDevice.getDevicePageActivity())) {
            SmartDeviceFragment.this.handleDeviceClick(localDevice);
          } else {
            SmartDeviceFragment.this.handleDeviceActivityClick(localDevice);
          }
        }
        else {
          SmartDeviceFragment.this.handleSmartLaunchClick(localDevice);
        }
        SmartConnectAnalytics.trackDevicePageLaunch(SmartDeviceFragment.this.mActivity, localDevice);
      }
    });
    ((Button)getView().findViewById(2131558509)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SmartDeviceFragment.this.goToWebshop();
      }
    });
    this.mArrayAdapter = new SmartDeviceArrayAdapter(this.mActivity);
    setListAdapter(this.mArrayAdapter);
    getLoaderManager().initLoader(0, null, this);
    setHasOptionsMenu(true);
    UIUtils.applyDirectionality(getListView());
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public Loader<List<Device>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new SmartDeviceListLoader(this.mActivity);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131689473, paramMenu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903081, null, false);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Dbg.d("SmartDeviceFragment.onDestroyView");
  }
  
  public void onLoadFinished(Loader<List<Device>> paramLoader, List<Device> paramList)
  {
    this.mArrayAdapter.setData(paramList);
    showList();
  }
  
  public void onLoaderReset(Loader<List<Device>> paramLoader)
  {
    this.mArrayAdapter.setData(null);
    showList();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
    }
    for (;;)
    {
      return bool;
      Dbg.d("Device search");
      try
      {
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.setComponent(ComponentName.unflattenFromString("com.sonymobile.connectivitycenter/.CCDeviceListActivity"));
        startActivityForResult(localIntent, 0);
        int i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
        }
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Dbg.d("SmartDeviceFragment.onSaveInstanceState");
  }
  
  private class SmartDeviceArrayAdapter
    extends ArrayAdapter<Device>
  {
    public SmartDeviceArrayAdapter(Context paramContext)
    {
      super(2130903066);
      setNotifyOnChange(false);
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(getContext()).inflate(2130903066, paramViewGroup, false);
        UIUtils.applyDirectionality(paramView);
      }
      Object localObject = (Device)getItem(paramInt);
      CheckableListItem localCheckableListItem = (CheckableListItem)paramView.findViewById(2131558474);
      localCheckableListItem.hideDescription();
      localCheckableListItem.setName(((Device)localObject).getProductName());
      if (!((Device)localObject).hasFeature(4))
      {
        localObject = ((Device)localObject).getIconName();
        localCheckableListItem.setIcon(UIUtils.getDrawable(SmartDeviceFragment.this.mActivity, (String)localObject));
      }
      else
      {
        SmartDeviceFragment.this.renderSmartLaunch(localCheckableListItem, (Device)localObject, getContext());
      }
      return paramView;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
    
    public void setData(List<Device> paramList)
    {
      clear();
      if (paramList != null) {
        addAll(paramList);
      }
      notifyDataSetChanged();
      setNotifyOnChange(false);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.SmartDeviceFragment
 * JD-Core Version:    0.7.0.1
 */