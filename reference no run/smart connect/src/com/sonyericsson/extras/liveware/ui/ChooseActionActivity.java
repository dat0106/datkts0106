package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.AsyncTask;
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
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.ActionSet.ActionSetEditor;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.SyncedProperty;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class ChooseActionActivity
  extends BaseListActivity
{
  private static final int ACTION_LIST_LOADER = 1;
  private static final String EXTRA_ACTION_TYPE = "extra_action_type";
  private static final String EXTRA_EXP_ID = "extra_exp_id";
  private static final String EXTRA_IS_EDIT = "extra_is_edit";
  public static final String EXTRA_UUID = "extra_uuid";
  private static final String KEY_ACTION_SET_UUID = "key_action_set_uuid";
  private static final int REQUEST_CODE_CREATE_ACTION = 1;
  private UUID mActionSetUuid = null;
  private int mActionType;
  private ActionListAdapter mAdapter = null;
  private long mExperienceId;
  private boolean mIsEventEdit = false;
  SyncedProperty<Boolean> mSaved = new SyncedProperty(Boolean.valueOf(false));
  
  public static Intent getIntent(Context paramContext, Experience paramExperience, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ChooseActionActivity.class);
    localIntent.putExtra("extra_exp_id", paramExperience.getId());
    localIntent.putExtra("extra_action_type", paramInt);
    localIntent.putExtra("extra_is_edit", paramBoolean);
    return localIntent;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getExtras();
      if (localObject2 != null)
      {
        Object localObject1 = ((Bundle)localObject2).getString("setting_raw");
        localObject2 = ((Bundle)localObject2).getString("setting_label");
        if ((paramInt2 != -1) || (localObject1 == null))
        {
          Dbg.e("ChooseActionActivity result: resultCode: " + paramInt2 + " rawSetting: " + (String)localObject1);
        }
        else
        {
          localObject1 = new ActionSetUpdateTask(this, this.mActionSetUuid.toString(), (String)localObject1, (String)localObject2);
          localObject2 = new String[1];
          localObject2[0] = this.mActionSetUuid.toString();
          ((ActionSetUpdateTask)localObject1).execute((Object[])localObject2);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_uuid", this.mActionSetUuid.toString());
          setResult(-1, (Intent)localObject1);
          finish();
        }
      }
      else
      {
        Dbg.e("ChooseActionActivity result: null extras");
      }
    }
    else
    {
      Dbg.e("ChooseActionActivity result: null intent");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("key_action_set_uuid"))) {
      this.mActionSetUuid = UUID.fromString(paramBundle.getString("key_action_set_uuid"));
    }
    this.mActionType = getIntent().getIntExtra("extra_action_type", 0);
    this.mExperienceId = getIntent().getLongExtra("extra_exp_id", -1L);
    this.mIsEventEdit = getIntent().getBooleanExtra("extra_is_edit", false);
    if (this.mExperienceId == -1L)
    {
      Dbg.e("No experience");
      finish();
    }
    setContentView(LayoutInflater.from(this).inflate(2130903045, null));
    this.mAdapter = new ActionListAdapter(this);
    setListAdapter(this.mAdapter);
    getListView().setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!((Boolean)ChooseActionActivity.this.mSaved.get()).booleanValue())
        {
          if (ChooseActionActivity.this.mAdapter.getItemViewType(paramAnonymousInt) == 1)
          {
            Action localAction = (Action)ChooseActionActivity.this.mAdapter.getItem(paramAnonymousInt);
            ChooseActionActivity.this.mActionSetUuid = UUID.randomUUID();
            ChooseActionActivity.ActionSetCreateTask localActionSetCreateTask = new ChooseActionActivity.ActionSetCreateTask(ChooseActionActivity.this, ChooseActionActivity.this, ChooseActionActivity.this.mActionSetUuid);
            Action[] arrayOfAction = new Action[1];
            arrayOfAction[0] = localAction;
            localActionSetCreateTask.execute(arrayOfAction);
            if (ChooseActionActivity.this.mIsEventEdit) {
              SmartConnectAnalytics.trackEventAction(ChooseActionActivity.this, "ActionAdd", localAction);
            }
          }
        }
        else {
          Dbg.w("ChooseActionActivity onItemClick ignored");
        }
      }
    });
    getLoaderManager().initLoader(1, null, new ActionListLoaderCallback(null));
    getActionBar().setDisplayHomeAsUpEnabled(true);
    if (this.mActionType != 0) {
      setTitle(2131099832);
    } else {
      setTitle(2131099831);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Dbg.d("ChooseActionActivity.onOptionsItemSelected");
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
  
  public void onResume()
  {
    super.onResume();
    this.mSaved.set(Boolean.valueOf(false));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mActionSetUuid != null) {
      paramBundle.putString("key_action_set_uuid", this.mActionSetUuid.toString());
    }
    this.mSaved.set(Boolean.valueOf(true));
  }
  
  private static class ActionListAdapter
    extends ArrayAdapter<Object>
  {
    public static final int TYPE_ACTION = 1;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_UNKNOWN = 2;
    
    public ActionListAdapter(Context paramContext)
    {
      super(17367055);
    }
    
    public boolean areAllItemsEnabled()
    {
      return false;
    }
    
    public int getItemViewType(int paramInt)
    {
      Object localObject = getItem(paramInt);
      int i;
      if (!(localObject instanceof String))
      {
        if (!(localObject instanceof Action))
        {
          Dbg.e("Unknown element type");
          i = 2;
        }
        else
        {
          i = 1;
        }
      }
      else {
        i = 0;
      }
      return i;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      if (i != 1)
      {
        if (i == 0)
        {
          if (paramView == null)
          {
            paramView = LayoutInflater.from(getContext()).inflate(2130903070, paramViewGroup, false);
            UIUtils.applyDirectionality(paramView);
          }
          ((TextView)paramView.findViewById(2131558480)).setText((String)getItem(paramInt));
        }
      }
      else
      {
        if (paramView == null)
        {
          paramView = LayoutInflater.from(getContext()).inflate(2130903066, paramViewGroup, false);
          UIUtils.applyDirectionality(paramView);
        }
        Action localAction = (Action)getItem(paramInt);
        CheckableListItem localCheckableListItem = (CheckableListItem)paramView.findViewById(2131558474);
        localCheckableListItem.setName(localAction.getName());
        if (localAction.getIconUri() == null)
        {
          Dbg.d("Using default action icon");
          localCheckableListItem.setIcon(2130837544);
        }
        else
        {
          localCheckableListItem.setIcon(UIUtils.getDrawable(getContext(), localAction.getIconUri()));
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
      boolean bool;
      if (getItemViewType(paramInt) == 0) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void setData(List<Object> paramList)
    {
      clear();
      if (paramList != null) {
        addAll(paramList);
      }
    }
  }
  
  private static class ActionListLoader
    extends AsyncTaskLoader<List<Object>>
  {
    private final int mActionType;
    private final long mExperienceId;
    private final ExperienceManager mManager;
    
    public ActionListLoader(Context paramContext, long paramLong, int paramInt)
    {
      super();
      this.mManager = ExperienceManager.getInstance(paramContext);
      this.mExperienceId = paramLong;
      this.mActionType = paramInt;
    }
    
    private List<Object> arrangeCategories(List<Action> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      Collections.sort(paramList, new Comparator()
      {
        public int compare(Action paramAnonymousAction1, Action paramAnonymousAction2)
        {
          Integer localInteger1 = Integer.valueOf(paramAnonymousAction1.getCategory());
          Integer localInteger2 = Integer.valueOf(paramAnonymousAction2.getCategory());
          if (localInteger1.intValue() == 0) {
            localInteger1 = Integer.valueOf(8);
          }
          if (localInteger2.intValue() == 0) {
            localInteger2 = Integer.valueOf(8);
          }
          return localInteger1.compareTo(localInteger2);
        }
      });
      int i = -1;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Action localAction = (Action)localIterator.next();
        int j = localAction.getCategory();
        if (j != i)
        {
          localArrayList.add(ActionUtils.getCategoryName(getContext(), j));
          i = j;
        }
        localArrayList.add(localAction);
      }
      return localArrayList;
    }
    
    private boolean containsAction(List<ActionSet> paramList, Action paramAction)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((ActionSet)localIterator.next()).getAction().getId() == paramAction.getId()) {
          return true;
        }
      }
      boolean bool = false;
      return bool;
    }
    
    public void deliverResult(List<Object> paramList)
    {
      if (isStarted()) {
        super.deliverResult(paramList);
      }
    }
    
    public List<Object> loadInBackground()
    {
      Object localObject = this.mManager.getExperience(this.mExperienceId);
      List localList;
      if (this.mActionType != 0) {
        localList = ((Experience)localObject).getAvailableStopActions();
      } else {
        localList = ((Experience)localObject).getAvailableStartActions();
      }
      localObject = new ArrayList();
      Iterator localIterator = this.mManager.getAllEnabledActions().iterator();
      while (localIterator.hasNext())
      {
        Action localAction = (Action)localIterator.next();
        if (!containsAction(localList, localAction)) {
          ((List)localObject).add(localAction);
        }
      }
      return arrangeCategories((List)localObject);
    }
    
    protected void onReset()
    {
      super.onReset();
      onStopLoading();
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
  
  private class ActionListLoaderCallback
    implements LoaderManager.LoaderCallbacks<List<Object>>
  {
    private ActionListLoaderCallback() {}
    
    public Loader<List<Object>> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      return new ChooseActionActivity.ActionListLoader(ChooseActionActivity.this, ChooseActionActivity.this.mExperienceId, ChooseActionActivity.this.mActionType);
    }
    
    public void onLoadFinished(Loader<List<Object>> paramLoader, List<Object> paramList)
    {
      ChooseActionActivity.this.mAdapter.setData(paramList);
    }
    
    public void onLoaderReset(Loader<List<Object>> paramLoader)
    {
      ChooseActionActivity.this.mAdapter.setData(null);
    }
  }
  
  private class ActionSetCreateTask
    extends AsyncTask<Action, Void, Void>
  {
    private final Activity mActivity;
    private final UUID mUuid;
    
    public ActionSetCreateTask(Activity paramActivity, UUID paramUUID)
    {
      this.mActivity = paramActivity;
      this.mUuid = paramUUID;
    }
    
    protected Void doInBackground(Action... paramVarArgs)
    {
      int i = ActionUtils.createActionSet(this.mActivity, paramVarArgs[0], ChooseActionActivity.this.mExperienceId, ChooseActionActivity.this.mActionType, this.mUuid, 1);
      if ((i == 0) || (i == 1))
      {
        ActionUtils.sendInjectSettingsResponseIntent(ChooseActionActivity.this, this.mUuid.toString(), i, "");
        ChooseActionActivity.this.finish();
      }
      return null;
    }
  }
  
  private static class ActionSetUpdateTask
    extends AsyncTask<String, Void, Void>
  {
    private final String mActionSetUuid;
    private final String mLabel;
    private final ExperienceManager mManager;
    private final String mRawSetting;
    
    public ActionSetUpdateTask(Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      this.mManager = ExperienceManager.getInstance(paramContext);
      this.mActionSetUuid = paramString1;
      this.mLabel = paramString3;
      this.mRawSetting = paramString2;
    }
    
    protected Void doInBackground(String... paramVarArgs)
    {
      ActionSet localActionSet = this.mManager.getActionSetByUuid(this.mActionSetUuid.toString());
      if (localActionSet != null)
      {
        if (this.mRawSetting.equals(localActionSet.getRawSetting()))
        {
          Dbg.d("ActionSetUpdateTask: not changed " + this.mRawSetting);
        }
        else
        {
          this.mManager.updateActionSet(localActionSet.edit().setRawSetting(this.mRawSetting).setFinalizedStatus(1).setSettingsLabel(this.mLabel));
          Dbg.d("ActionSetUpdateTask: updated to " + this.mRawSetting + " label: " + this.mLabel);
        }
      }
      else {
        Dbg.e("ActionSetUpdateTask: failed finding actionSet " + this.mActionSetUuid);
      }
      return null;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ChooseActionActivity
 * JD-Core Version:    0.7.0.1
 */