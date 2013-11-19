package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.AsyncTask;
import android.os.Bundle;
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
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Time;
import com.sonyericsson.extras.liveware.utils.AsfTimeUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.SyncedProperty;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteItemsActivity
  extends BaseActivity
{
  private static final String DIALOG_TAG_CONFIRM_DELETE = "dialog_confirm_delete";
  private static final int EXPERIENCE_LOADER = 1;
  private static final String EXTRA_EXPERIENCE_ID = "extra_experience_id";
  private static final int ITEM_TYPE_ACTION_SET = 2;
  private static final int ITEM_TYPE_COUNT = 4;
  private static final int ITEM_TYPE_INITATOR_DEVICE = 0;
  private static final int ITEM_TYPE_INITATOR_TIME = 1;
  private static final int ITEM_TYPE_SEPARATOR = 3;
  private static final String KEY_EXPERIENCE_ID = "key_experience_id";
  private DeleteItemsAdapter mAdapter = null;
  private MenuItem mDoneActionItem;
  private Button mDoneButton = null;
  private Experience mExperience = null;
  private ListView mListView = null;
  SyncedProperty<Boolean> mSaved = new SyncedProperty(Boolean.valueOf(false));
  
  public static Intent createIntent(Context paramContext, Experience paramExperience)
  {
    Intent localIntent = new Intent(paramContext, DeleteItemsActivity.class);
    localIntent.putExtra("extra_experience_id", paramExperience.getId());
    return localIntent;
  }
  
  private void deleteCheckedItems()
  {
    Object localObject1 = new ArrayList();
    int i = 0;
    Object localObject2;
    for (int j = 0; j < this.mListView.getCount(); j++) {
      if (this.mListView.isItemChecked(j))
      {
        localObject2 = this.mAdapter.getItem(j);
        if (!(localObject2 instanceof ActionSet))
        {
          if (!(localObject2 instanceof Time))
          {
            if ((localObject2 instanceof Device))
            {
              this.mExperience.setDevice(null);
              i = 1;
              SmartConnectAnalytics.trackEventDevice(this, "TriggerRemove", (Device)localObject2);
            }
          }
          else
          {
            this.mExperience.setTime(null);
            i = 1;
            SmartConnectAnalytics.trackEvent(this, "TriggerRemove", "None", "Time");
          }
        }
        else
        {
          localObject2 = (ActionSet)localObject2;
          ((ArrayList)localObject1).add(localObject2);
          SmartConnectAnalytics.trackEventAction(this, "ActionRemove", ((ActionSet)localObject2).getAction());
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      DeleteActionSetTask localDeleteActionSetTask = new DeleteActionSetTask(this);
      localObject2 = new ArrayList[1];
      localObject2[0] = localObject1;
      localDeleteActionSetTask.execute((Object[])localObject2);
    }
    if (i != 0)
    {
      ExperienceUpdateTask localExperienceUpdateTask = new ExperienceUpdateTask(this);
      localObject1 = new Experience[1];
      localObject1[0] = this.mExperience;
      localExperienceUpdateTask.execute((Object[])localObject1);
    }
  }
  
  private void onCancel()
  {
    finish();
  }
  
  private void onDone()
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    if (getFragmentManager().findFragmentByTag("dialog_confirm_delete") == null)
    {
      localFragmentTransaction.addToBackStack(null);
      new DeleteItemDialog().show(localFragmentTransaction, "dialog_confirm_delete");
    }
  }
  
  private void refreshAdapter()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ListSeparator(getString(2131099795)));
    if (this.mExperience != null)
    {
      if (this.mExperience.getDevice() != null) {
        localArrayList.add(this.mExperience.getDevice());
      }
      if (this.mExperience.getTime() != null) {
        localArrayList.add(this.mExperience.getTime());
      }
    }
    localArrayList.add(new ListSeparator(getString(2131099796)));
    List localList;
    if (this.mExperience != null)
    {
      localList = this.mExperience.getAvailableStartActions();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
    }
    localArrayList.add(new ListSeparator(getString(2131099797)));
    if (this.mExperience != null)
    {
      localList = this.mExperience.getAvailableStopActions();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
    }
    this.mAdapter.setData(localArrayList);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        DeleteItemsActivity.this.updateDoneVisibility();
      }
    });
  }
  
  private void updateDoneVisibility()
  {
    int i = 0;
    if (this.mListView != null) {
      for (int j = 0; j < this.mListView.getCount(); j++) {
        if (this.mListView.isItemChecked(j)) {
          i++;
        }
      }
    }
    if (i != 0)
    {
      Object localObject3;
      Object localObject1;
      Object localObject2;
      if (this.mDoneButton != null)
      {
        this.mDoneButton.setEnabled(true);
        localObject3 = this.mDoneButton;
        localObject1 = getString(2131099835);
        localObject2 = new Object[1];
        localObject2[0] = Integer.valueOf(i);
        ((Button)localObject3).setText(String.format((String)localObject1, (Object[])localObject2));
      }
      if (this.mDoneActionItem != null)
      {
        this.mDoneActionItem.setEnabled(true);
        localObject1 = this.mDoneActionItem;
        localObject2 = getString(2131099835);
        localObject3 = new Object[1];
        localObject3[0] = Integer.valueOf(i);
        ((MenuItem)localObject1).setTitle(String.format((String)localObject2, (Object[])localObject3));
      }
    }
    else
    {
      if (this.mDoneButton != null)
      {
        this.mDoneButton.setEnabled(false);
        this.mDoneButton.setText(2131099834);
      }
      if (this.mDoneActionItem != null)
      {
        this.mDoneActionItem.setEnabled(false);
        this.mDoneActionItem.setTitle(2131099834);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    View localView = LayoutInflater.from(this).inflate(2130903071, null);
    setContentView(localView);
    this.mListView = ((ListView)localView.findViewById(16908298));
    this.mDoneButton = ((Button)localView.findViewById(2131558457));
    if (this.mDoneButton != null) {
      this.mDoneButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (((Boolean)DeleteItemsActivity.this.mSaved.get()).booleanValue()) {
            Dbg.w("DeleteItemsActivity mDoneButton onClick ignored");
          } else {
            DeleteItemsActivity.this.onDone();
          }
        }
      });
    }
    localView = localView.findViewById(2131558456);
    if (localView != null) {
      localView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DeleteItemsActivity.this.onCancel();
        }
      });
    }
    this.mAdapter = new DeleteItemsAdapter(this);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setItemsCanFocus(false);
    this.mListView.setChoiceMode(2);
    this.mListView.setFocusable(true);
    this.mListView.setFocusableInTouchMode(true);
    this.mListView.requestFocus();
    long l;
    if (paramBundle == null) {
      l = getIntent().getLongExtra("extra_experience_id", -1L);
    } else {
      l = paramBundle.getLong("key_experience_id");
    }
    if (l != -1L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_experience_id", l);
      getLoaderManager().initLoader(1, localBundle, new ExperienceLoaderCallbacks(null));
      getActionBar().setDisplayHomeAsUpEnabled(true);
      setTitle(2131099833);
    }
    else
    {
      if (Dbg.e()) {
        Dbg.e("Experience id == -1");
      }
      finish();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689472, paramMenu);
    this.mDoneActionItem = paramMenu.findItem(2131558549);
    updateDoneVisibility();
    return true;
  }
  
  public void onDeleteCancel() {}
  
  public void onDeleteConfirm()
  {
    deleteCheckedItems();
    finish();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    if (!((Boolean)this.mSaved.get()).booleanValue())
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
        bool = false;
        break;
      case 16908332: 
        finish();
        bool = true;
        break;
      case 2131558548: 
        onCancel();
        bool = true;
        break;
      case 2131558549: 
        onDone();
        bool = true;
        break;
      }
    }
    else
    {
      Dbg.w("DeleteItemsActivity onOptionsItemSelected ignored");
      bool = false;
    }
    return bool;
  }
  
  public void onResume()
  {
    super.onResume();
    this.mSaved.set(Boolean.valueOf(false));
    updateDoneVisibility();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mSaved.set(Boolean.valueOf(true));
    if (this.mExperience != null) {
      paramBundle.putLong("key_experience_id", this.mExperience.getId());
    }
  }
  
  private static class DeleteActionSetTask
    extends AsyncTask<ArrayList<ActionSet>, Void, Void>
  {
    private final Context mContext;
    
    public DeleteActionSetTask(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    protected Void doInBackground(ArrayList<ActionSet>... paramVarArgs)
    {
      ExperienceManager localExperienceManager = ExperienceManager.getInstance(this.mContext);
      Iterator localIterator = paramVarArgs[0].iterator();
      while (localIterator.hasNext()) {
        localExperienceManager.deleteActionSet((ActionSet)localIterator.next());
      }
      return null;
    }
  }
  
  private class DeleteItemsAdapter
    extends ArrayAdapter<Object>
  {
    public DeleteItemsAdapter(Context paramContext)
    {
      super(17367055);
    }
    
    private void getActionSetView(CheckableListItem paramCheckableListItem, ActionSet paramActionSet, int paramInt)
    {
      Action localAction = paramActionSet.getAction();
      paramCheckableListItem.setName(localAction.getName());
      paramCheckableListItem.setDescription(paramActionSet.getSettingsLabel());
      if (localAction.getIconUri() != null) {
        paramCheckableListItem.setIcon(UIUtils.getDrawable(getContext(), localAction.getIconUri()));
      }
    }
    
    private int getResourceId(int paramInt)
    {
      int i;
      if (paramInt != 3) {
        i = 2130903066;
      } else {
        i = 2130903070;
      }
      return i;
    }
    
    public boolean areAllItemsEnabled()
    {
      return false;
    }
    
    public int getItemViewType(int paramInt)
    {
      int i = 3;
      Object localObject = getItem(paramInt);
      if (!(localObject instanceof DeleteItemsActivity.ListSeparator)) {
        if (!(localObject instanceof Device))
        {
          if (!(localObject instanceof Time))
          {
            if (!(localObject instanceof ActionSet))
            {
              if (Dbg.e()) {
                Dbg.e("Invalid position: " + paramInt);
              }
            }
            else {
              i = 2;
            }
          }
          else {
            i = 1;
          }
        }
        else {
          i = 0;
        }
      }
      return i;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(getContext()).inflate(getResourceId(i), paramViewGroup, false);
        UIUtils.applyDirectionality(paramView);
      }
      Object localObject1;
      if (i != 3)
      {
        localObject1 = (CheckableListItem)paramView;
        ((CheckableListItem)localObject1).hideDescription();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2) {
              getActionSetView((CheckableListItem)localObject1, (ActionSet)getItem(paramInt), paramInt);
            }
          }
          else
          {
            localObject2 = (Time)getItem(paramInt);
            ((CheckableListItem)localObject1).setName(AsfTimeUtils.getFormattedTimeSpan((Time)localObject2, getContext()));
            if (((Time)localObject2).getDaysRaw() != 254) {
              ((CheckableListItem)localObject1).setDescription(AsfTimeUtils.getFormattedWeekDays(((Time)localObject2).getDaysRaw(), 20));
            } else {
              ((CheckableListItem)localObject1).setDescription(2131099935);
            }
            ((CheckableListItem)localObject1).setIcon(2130837664);
          }
        }
        else
        {
          localObject2 = (Device)getItem(paramInt);
          ((CheckableListItem)localObject1).setName(((Device)localObject2).getProductName());
          ((CheckableListItem)localObject1).setIcon(UIUtils.getDrawable(getContext(), ((Device)localObject2).getIconName()));
        }
        Object localObject2 = (CheckBox)((CheckableListItem)localObject1).findViewById(2131558475);
        ((CheckBox)localObject2).setVisibility(0);
        ((CheckBox)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            this.val$listItem.toggle();
            DeleteItemsActivity.this.mListView.performItemClick(this.val$listItem, paramInt, DeleteItemsActivity.this.mAdapter.getItemId(paramInt));
          }
        });
        ((CheckableListItem)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            this.val$listItem.toggle();
            DeleteItemsActivity.this.mListView.performItemClick(paramAnonymousView, paramInt, DeleteItemsActivity.this.mAdapter.getItemId(paramInt));
          }
        });
      }
      else
      {
        localObject1 = (DeleteItemsActivity.ListSeparator)getItem(paramInt);
        ((TextView)paramView.findViewById(2131558480)).setText(((DeleteItemsActivity.ListSeparator)localObject1).getName());
      }
      return paramView;
    }
    
    public int getViewTypeCount()
    {
      return 4;
    }
    
    public boolean isEnabled(int paramInt)
    {
      boolean bool;
      if (getItemViewType(paramInt) == 3) {
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
  
  private class ExperienceLoaderCallbacks
    implements LoaderManager.LoaderCallbacks<Experience>
  {
    private ExperienceLoaderCallbacks() {}
    
    public Loader<Experience> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      return new ExperienceLoader(DeleteItemsActivity.this, paramBundle.getLong("key_experience_id"));
    }
    
    public void onLoadFinished(Loader<Experience> paramLoader, Experience paramExperience)
    {
      DeleteItemsActivity.this.mExperience = paramExperience;
      DeleteItemsActivity.this.refreshAdapter();
    }
    
    public void onLoaderReset(Loader<Experience> paramLoader)
    {
      DeleteItemsActivity.this.mExperience = null;
    }
  }
  
  private static class ExperienceUpdateTask
    extends AsyncTask<Experience, Void, Void>
  {
    private final Context mContext;
    
    public ExperienceUpdateTask(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    protected Void doInBackground(Experience... paramVarArgs)
    {
      ExperienceManager.getInstance(this.mContext).updateExperience(paramVarArgs[0]);
      return null;
    }
  }
  
  private static class ListSeparator
  {
    private final String mName;
    
    ListSeparator(String paramString)
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
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.DeleteItemsActivity
 * JD-Core Version:    0.7.0.1
 */