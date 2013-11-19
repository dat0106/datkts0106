package com.sonyericsson.extras.liveware.actions.appshortcut;

import android.app.ActionBar;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.sonyericsson.extras.liveware.ui.ApplicationDataAdapter;
import com.sonyericsson.extras.liveware.ui.ApplicationDataLoader;
import com.sonyericsson.extras.liveware.ui.ApplicationDataLoader.ApplicationFilter;
import com.sonyericsson.extras.liveware.ui.BaseActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AppShortcutSelectionActivity
  extends BaseActivity
  implements LoaderManager.LoaderCallbacks<List<ApplicationData>>
{
  private static final String KEY_COMPONENT_NAME = "key_component_name";
  private ApplicationDataAdapter mAdapter;
  private ListView mListView;
  private String mRawSetting;
  private ApplicationData mSelectedAppData;
  
  private void renderApplicationView()
  {
    this.mAdapter.refresh();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      this.mSelectedAppData = null;
      if (!TextUtils.isEmpty(this.mRawSetting)) {}
    }
    for (;;)
    {
      return;
      try
      {
        Object localObject1 = new JSONObject(this.mRawSetting).getString("app_shortcut_component");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localObject1 = ComponentName.unflattenFromString((String)localObject1);
        if (localObject1 == null) {
          continue;
        }
        this.mSelectedAppData = new ApplicationData(this, (ComponentName)localObject1);
      }
      catch (JSONException localJSONException1)
      {
        Dbg.e(localJSONException1);
      }
      continue;
      Object localObject2 = (Intent)paramIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
      String str2 = paramIntent.getStringExtra("android.intent.extra.shortcut.NAME");
      String str1 = null;
      JSONObject localJSONObject = new JSONObject();
      localObject2 = ((Intent)localObject2).toUri(0);
      String str3 = this.mSelectedAppData.getFlatComponentName();
      try
      {
        localJSONObject.put("app_shortcut_setting", localObject2);
        localJSONObject.put("app_shortcut_settings_label", str2);
        localJSONObject.put("app_shortcut_component", str3);
        str1 = localJSONObject.toString();
        str1 = str1;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          Dbg.e(localJSONException2);
        }
      }
      ActionUtils.finishActivityWithSetting(this, str1, AppShortcut.getLabelByRawSetting(this, str1));
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    setContentView(View.inflate(this, 2130903079, null));
    setTitle(2131099953);
    Object localObject = null;
    if (paramBundle != null) {
      localObject = paramBundle.getString("key_component_name");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ComponentName.unflattenFromString((String)localObject);
        if (localObject != null) {
          this.mSelectedAppData = new ApplicationData(this, (ComponentName)localObject);
        }
      }
      this.mAdapter = new ApplicationDataAdapter(this);
      this.mListView = ((ListView)findViewById(16908298));
      this.mListView.setChoiceMode(1);
      this.mListView.setAdapter(this.mAdapter);
      this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppShortcutSelectionActivity.this.onItemClicker(paramAnonymousView);
        }
      });
      getLoaderManager().initLoader(0, null, this);
      getActionBar().setDisplayHomeAsUpEnabled(true);
      return;
      if (!TextUtils.isEmpty(this.mRawSetting)) {
        try
        {
          localObject = new JSONObject(this.mRawSetting).getString("app_shortcut_component");
          localObject = localObject;
        }
        catch (JSONException localJSONException)
        {
          Dbg.e(localJSONException);
        }
      }
    }
  }
  
  public Loader<List<ApplicationData>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    new ApplicationDataLoader(this, new ApplicationDataLoader.ApplicationFilter()
    {
      public List<ResolveInfo> getApplications(Context paramAnonymousContext)
      {
        return paramAnonymousContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0);
      }
    });
  }
  
  public void onItemClicker(View paramView)
  {
    Object localObject = (ApplicationData)paramView.getTag();
    if (localObject != null)
    {
      this.mSelectedAppData = ((ApplicationData)localObject);
      localObject = new Intent("android.intent.action.CREATE_SHORTCUT");
      ((Intent)localObject).setComponent(ComponentName.unflattenFromString(this.mSelectedAppData.getFlatComponentName()));
      startActivityForResult((Intent)localObject, 0);
    }
  }
  
  public void onLoadFinished(Loader<List<ApplicationData>> paramLoader, List<ApplicationData> paramList)
  {
    this.mAdapter.setData(paramList);
    if (this.mSelectedAppData != null)
    {
      int i = this.mAdapter.getPosition(this.mSelectedAppData);
      this.mListView.setSelection(i);
      this.mListView.setItemChecked(i, true);
    }
  }
  
  public void onLoaderReset(Loader<List<ApplicationData>> paramLoader)
  {
    this.mAdapter.setData(null);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
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
    renderApplicationView();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mSelectedAppData != null) {
      paramBundle.putString("key_component_name", this.mSelectedAppData.getFlatComponentName());
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.appshortcut.AppShortcutSelectionActivity
 * JD-Core Version:    0.7.0.1
 */