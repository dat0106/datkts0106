package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Loader;
import android.content.Loader.ForceLoadContentObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import com.example.android.bitmapfun.util.ImageWorker;
import com.sonyericsson.bidi.BidiUtils;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ActionSetTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ExperienceTable;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.ExperienceManager.EmException;
import com.sonyericsson.extras.liveware.experience.Time;
import com.sonyericsson.extras.liveware.utils.AsfTimeUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ImageGradientWorker;
import com.sonyericsson.extras.liveware.utils.SyncedProperty;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.List;

public class ExperienceListFragment
  extends ListFragment
  implements LoaderManager.LoaderCallbacks<List<Experience>>
{
  private static final String DIALOG_TAG_DELETE = "dialog_tag_delete";
  private static final int EXPERIENCE_LOADER = 1;
  private static final String EXTRA_DUAL_MODE = "extra_dual_mode";
  private static final String EXTRA_EXPERIENCE_ID = "extra_experience_id";
  public static final long FIRST_EXPERIENCE = -2L;
  public static final long NEW_EXPERIENCE = -1L;
  private ActionMode mActionMode;
  private Activity mActivity;
  private ExperienceArrayAdapter mArrayAdapter;
  private ImageGradientWorker mImageWorker;
  private long mInitialExperienceId;
  private boolean mIsDualMode;
  SyncedProperty<Boolean> mSaved = new SyncedProperty(Boolean.valueOf(false));
  
  private Experience[] getCheckedExperiences()
  {
    long[] arrayOfLong = getListView().getCheckedItemIds();
    Experience[] arrayOfExperience = new Experience[arrayOfLong.length];
    for (int i = 0; i < arrayOfLong.length; i++) {
      arrayOfExperience[i] = ((Experience)this.mArrayAdapter.getItem((int)arrayOfLong[i]));
    }
    return arrayOfExperience;
  }
  
  private boolean hasCheckedExperienceWithEnabledState(int paramInt)
  {
    bool = false;
    try
    {
      arrayOfLong = getListView().getCheckedItemIds();
      i = 0;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        long[] arrayOfLong;
        int i;
        continue;
        if ((arrayOfLong[i] < this.mArrayAdapter.getCount()) && (((Experience)this.mArrayAdapter.getItem((int)arrayOfLong[i])).getEnabledState() == paramInt)) {
          bool = true;
        } else {
          i++;
        }
      }
    }
    if (i >= arrayOfLong.length) {
      return bool;
    }
  }
  
  public static ExperienceListFragment newInstance(boolean paramBoolean, long paramLong)
  {
    ExperienceListFragment localExperienceListFragment = new ExperienceListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("extra_dual_mode", paramBoolean);
    localBundle.putLong("extra_experience_id", paramLong);
    localExperienceListFragment.setArguments(localBundle);
    return localExperienceListFragment;
  }
  
  private void setEnabledStateForCheckedExperiences(int paramInt)
  {
    Experience[] arrayOfExperience = getCheckedExperiences();
    int j = arrayOfExperience.length;
    for (int i = 0; i < j; i++) {
      arrayOfExperience[i].setEnabledState(paramInt);
    }
    new ExperienceUpdateTask(null).execute(arrayOfExperience);
  }
  
  private void setTitle(ActionMode paramActionMode)
  {
    try
    {
      int i = getListView().getCheckedItemCount();
      j = i;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        int j = 0;
        continue;
        paramActionMode.setTitle(null);
      }
    }
    switch (j)
    {
    default: 
      String str = getString(2131099813);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(j);
      paramActionMode.setTitle(String.format(str, arrayOfObject));
      return;
    }
  }
  
  private void showDialogFragment(DialogFragment paramDialogFragment, String paramString)
  {
    if (!((Boolean)this.mSaved.get()).booleanValue())
    {
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      if (getFragmentManager().findFragmentByTag(paramString) == null)
      {
        localFragmentTransaction.addToBackStack(null);
        paramDialogFragment.show(localFragmentTransaction, paramString);
      }
    }
    else
    {
      Dbg.w("ExperienceListFragment.showDialogFragment ignored");
    }
  }
  
  private void showList()
  {
    View localView = getView();
    if (localView != null) {
      localView.findViewById(2131558439).setVisibility(0);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Dbg.d("ExperienceListFragment.onActivityCreated");
    ListView localListView = getListView();
    int i;
    if (!this.mIsDualMode) {
      i = 3;
    } else {
      i = 1;
    }
    localListView.setChoiceMode(i);
    localListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener()
    {
      public boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
      {
        boolean bool = true;
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          bool = false;
          break;
        case 2131558560: 
          ExperienceListFragment.this.setEnabledStateForCheckedExperiences(0);
          paramAnonymousActionMode.finish();
          break;
        case 2131558561: 
          ExperienceListFragment.this.setEnabledStateForCheckedExperiences(2);
          paramAnonymousActionMode.finish();
          break;
        case 2131558562: 
          DeleteExperienceListDialog localDeleteExperienceListDialog = new DeleteExperienceListDialog();
          localDeleteExperienceListDialog.setTargetFragment(ExperienceListFragment.this, 0);
          ExperienceListFragment.this.showDialogFragment(localDeleteExperienceListDialog, "dialog_tag_delete");
        }
        return bool;
      }
      
      public boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        ExperienceListFragment.this.mActionMode = paramAnonymousActionMode;
        ExperienceListFragment.this.mActivity.getMenuInflater().inflate(2131689478, paramAnonymousMenu);
        return true;
      }
      
      public void onDestroyActionMode(ActionMode paramAnonymousActionMode)
      {
        ExperienceListFragment.this.mActionMode = null;
      }
      
      public void onItemCheckedStateChanged(ActionMode paramAnonymousActionMode, int paramAnonymousInt, long paramAnonymousLong, boolean paramAnonymousBoolean)
      {
        ExperienceListFragment.this.setTitle(paramAnonymousActionMode);
      }
      
      public boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
      {
        boolean bool1 = false;
        MenuItem localMenuItem2 = paramAnonymousMenu.findItem(2131558561);
        boolean bool2;
        if (!ExperienceListFragment.this.hasCheckedExperienceWithEnabledState(2)) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        localMenuItem2.setVisible(bool2);
        MenuItem localMenuItem1 = paramAnonymousMenu.findItem(2131558560);
        if ((!ExperienceListFragment.this.hasCheckedExperienceWithEnabledState(0)) && (!ExperienceListFragment.this.hasCheckedExperienceWithEnabledState(1))) {
          bool1 = true;
        }
        localMenuItem1.setVisible(bool1);
        ExperienceListFragment.this.setTitle(paramAnonymousActionMode);
        return true;
      }
    });
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!((Boolean)ExperienceListFragment.this.mSaved.get()).booleanValue())
        {
          if (ExperienceListFragment.this.mIsDualMode) {
            ((ListView)paramAnonymousAdapterView).setItemChecked(paramAnonymousInt, true);
          }
          Experience localExperience = (Experience)ExperienceListFragment.this.getListAdapter().getItem(paramAnonymousInt);
          ((HomeScreenActivity)ExperienceListFragment.this.mActivity).showExperience(localExperience.getId());
        }
        else
        {
          Dbg.w("ExperienceListFragment onItemClick ignored");
        }
      }
    });
    localListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        boolean bool = false;
        if (!ExperienceListFragment.this.mIsDualMode)
        {
          ListView localListView = (ListView)paramAnonymousAdapterView;
          if (!localListView.isItemChecked(paramAnonymousInt)) {
            bool = true;
          }
          localListView.setItemChecked(paramAnonymousInt, bool);
          bool = true;
        }
        return bool;
      }
    });
    this.mActivity.setTitle(2131099741);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Dbg.d("ExperienceListFragment.onCreate");
    this.mIsDualMode = getArguments().getBoolean("extra_dual_mode", false);
    this.mInitialExperienceId = getArguments().getLong("extra_experience_id", -1L);
    getArguments().remove("extra_experience_id");
    this.mArrayAdapter = new ExperienceArrayAdapter(this.mActivity);
    setListAdapter(this.mArrayAdapter);
    getLoaderManager().initLoader(1, null, this);
    setHasOptionsMenu(true);
    this.mImageWorker = new ImageGradientWorker(this.mActivity);
    this.mImageWorker.setEventListGradient(true);
  }
  
  public Loader<List<Experience>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new ExperienceListLoader(this.mActivity);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131689477, paramMenu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Dbg.d("ExperienceListFragment.onCreateView");
    View localView = paramLayoutInflater.inflate(2130903058, null, false);
    UIUtils.applyDirectionality(localView);
    return localView;
  }
  
  public void onDelete()
  {
    new ExperienceDeleteTask(null).execute(getCheckedExperiences());
    this.mActionMode.finish();
  }
  
  public void onLoadFinished(Loader<List<Experience>> paramLoader, List<Experience> paramList)
  {
    this.mArrayAdapter.setData(paramList);
    showList();
    if (!((Boolean)this.mSaved.get()).booleanValue())
    {
      if (paramList.size() > 0) {
        ((HomeScreenActivity)this.mActivity).showInitialExperience(((Experience)paramList.get(0)).getId());
      }
      if (this.mActionMode != null) {
        this.mActionMode.invalidate();
      }
    }
    else
    {
      Dbg.w("ExperienceListFragment.onLoadFinished ignored");
    }
  }
  
  public void onLoaderReset(Loader<List<Experience>> paramLoader)
  {
    this.mArrayAdapter.setData(null);
    showList();
    if (this.mActionMode != null) {
      this.mActionMode.invalidate();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
      break;
    case 2131558559: 
      if (((Boolean)this.mSaved.get()).booleanValue())
      {
        Dbg.w("ExperienceListFragment.onOptionsItemSelected ignored");
      }
      else
      {
        ((HomeScreenActivity)this.mActivity).showExperience(-1L);
        SmartConnectAnalytics.trackEvent(this.mActivity, "EventCreate");
      }
      bool = true;
    }
    return bool;
  }
  
  public void onPause()
  {
    super.onPause();
    Dbg.d("ExperienceListFragment.onPause");
    this.mImageWorker.setExitTasksEarly(true);
  }
  
  public void onResume()
  {
    super.onResume();
    this.mSaved.set(Boolean.valueOf(false));
    Dbg.d("ExperienceListFragment.onResume");
    this.mImageWorker.setExitTasksEarly(false);
    this.mArrayAdapter.refresh();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Dbg.d("ExperienceListFragment.onSaveInstanceState");
    this.mSaved.set(Boolean.valueOf(true));
  }
  
  public void onStop()
  {
    super.onStop();
    Dbg.d("ExperienceListFragment.onStop");
    if (this.mActionMode != null)
    {
      this.mActionMode.finish();
      this.mActionMode = null;
    }
  }
  
  public void resetSelection()
  {
    this.mInitialExperienceId = -2L;
    Loader localLoader = getLoaderManager().getLoader(1);
    if (localLoader != null) {
      localLoader.forceLoad();
    }
  }
  
  private class ExperienceArrayAdapter
    extends ReplaceAllArrayAdapter<Experience>
  {
    public ExperienceArrayAdapter(Context paramContext)
    {
      super(2130903056);
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if ((paramView == null) || (ImageWorker.getBitmapWorkerTask((ImageView)paramView.findViewById(2131558427)) != null))
      {
        paramView = LayoutInflater.from(getContext()).inflate(2130903056, null);
        UIUtils.applyDirectionality(paramView);
      }
      Object localObject1 = (Experience)getItem(paramInt);
      if ((ExperienceListFragment.this.mIsDualMode) && ((((Experience)localObject1).getId() == ExperienceListFragment.this.mInitialExperienceId) || (ExperienceListFragment.this.mInitialExperienceId == -2L)))
      {
        ((ListView)paramViewGroup).setItemChecked(paramInt, true);
        ExperienceListFragment.this.mInitialExperienceId = -1L;
      }
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131558427);
      if (localImageView1 != null)
      {
        if ((localImageView1.getDrawable() == null) || (!TextUtils.equals(ImageWorker.viewTagFromPictureName(((Experience)localObject1).getPictureName()), (String)localImageView1.getTag()))) {
          ExperienceListFragment.this.mImageWorker.loadImage(((Experience)localObject1).getPictureName(), localImageView1);
        }
        if ((BidiUtils.shouldMirror(localImageView1)) || (UIUtils.isVanillaRtl(ExperienceListFragment.this.mActivity))) {
          localImageView1.setScaleX(-1.0F);
        }
        localImageView1.setAlpha(((Experience)localObject1).getPictureAlpha());
      }
      boolean bool;
      if (((Experience)localObject1).getEnabledState() != 2) {
        bool = false;
      } else {
        bool = true;
      }
      UIUtils.setViewEnabled(paramView, bool);
      Object localObject2 = (Switch)paramView.findViewById(2131558426);
      if (localObject2 != null) {
        if ((!((Experience)localObject1).isValid()) && (bool))
        {
          ((Switch)localObject2).setVisibility(4);
        }
        else
        {
          ((Switch)localObject2).setVisibility(0);
          ((Switch)localObject2).setOnCheckedChangeListener(null);
          ((Switch)localObject2).setChecked(bool);
          ((Switch)localObject2).setOnCheckedChangeListener(new ExperienceListFragment.ExperienceEnableListener(ExperienceListFragment.this, (Experience)localObject1));
          ((Switch)localObject2).setEnabled(true);
        }
      }
      ((TextView)paramView.findViewById(2131558425)).setText(((Experience)localObject1).getName());
      Device localDevice = ((Experience)localObject1).getDevice();
      View localView = paramView.findViewById(2131558429);
      if (localView != null) {
        if (localDevice == null)
        {
          localView.setVisibility(8);
        }
        else
        {
          localObject2 = (TextView)paramView.findViewById(2131558431);
          ImageView localImageView2 = (ImageView)paramView.findViewById(2131558430);
          ((TextView)localObject2).setText(localDevice.getProductName());
          localImageView2.setImageDrawable(UIUtils.getDrawable(getContext(), localDevice.getIconName(), bool));
          localView.setVisibility(0);
        }
      }
      Time localTime = ((Experience)localObject1).getTime();
      localObject2 = paramView.findViewById(2131558432);
      if (localObject2 != null) {
        if (localTime == null)
        {
          ((View)localObject2).setVisibility(8);
        }
        else
        {
          ((TextView)paramView.findViewById(2131558434)).setText(AsfTimeUtils.getFormattedTimeSpan(localTime, getContext()));
          localObject1 = (TextView)paramView.findViewById(2131558435);
          if (localTime.getDaysRaw() != 254)
          {
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText(AsfTimeUtils.getFormattedWeekDays(localTime.getDaysRaw(), 40));
          }
          else
          {
            ((TextView)localObject1).setVisibility(8);
          }
          ((View)localObject2).setVisibility(0);
        }
      }
      return paramView;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
  }
  
  private class ExperienceDeleteTask
    extends AsyncTask<Experience, Void, Void>
  {
    private ExperienceDeleteTask() {}
    
    protected Void doInBackground(Experience... paramVarArgs)
    {
      ExperienceManager localExperienceManager = ExperienceManager.getInstance(ExperienceListFragment.this.mActivity);
      int i = paramVarArgs.length;
      int j = 0;
      for (;;)
      {
        if (j >= i) {
          return null;
        }
        Experience localExperience = paramVarArgs[j];
        try
        {
          localExperienceManager.deleteExperience(localExperience);
          j++;
        }
        catch (ExperienceManager.EmException localEmException)
        {
          for (;;)
          {
            if (Dbg.e()) {
              Dbg.e("Failed to delete experience: " + localExperience.getName(), localEmException);
            }
          }
        }
      }
    }
  }
  
  private class ExperienceEnableListener
    implements CompoundButton.OnCheckedChangeListener
  {
    private final Experience mExperience;
    
    public ExperienceEnableListener(Experience paramExperience)
    {
      this.mExperience = paramExperience;
    }
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      Object localObject = this.mExperience;
      int i;
      if (!paramBoolean) {
        i = 0;
      } else {
        i = 2;
      }
      ((Experience)localObject).setEnabledState(i);
      ExperienceListFragment.ExperienceUpdateTask localExperienceUpdateTask = new ExperienceListFragment.ExperienceUpdateTask(ExperienceListFragment.this, null);
      localObject = new Experience[1];
      localObject[0] = this.mExperience;
      localExperienceUpdateTask.execute((Object[])localObject);
    }
  }
  
  private static class ExperienceListLoader
    extends AsyncTaskLoader<List<Experience>>
  {
    private final ExperienceManager mManager;
    private final Loader<List<Experience>>.ForceLoadContentObserver mObserver;
    private final ContentResolver mResolver;
    
    public ExperienceListLoader(Context paramContext)
    {
      super();
      this.mManager = ExperienceManager.getInstance(paramContext);
      this.mResolver = paramContext.getContentResolver();
      this.mObserver = new Loader.ForceLoadContentObserver(this);
      this.mResolver.registerContentObserver(ExperienceDef.ExperienceTable.URI, true, this.mObserver);
      this.mResolver.registerContentObserver(ExperienceDef.ActionSetTable.URI, true, this.mObserver);
    }
    
    public void deliverResult(List<Experience> paramList)
    {
      if (isStarted()) {
        super.deliverResult(paramList);
      }
    }
    
    public List<Experience> loadInBackground()
    {
      return this.mManager.getAllExperiences();
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
  
  private class ExperienceUpdateTask
    extends AsyncTask<Experience, Void, Void>
  {
    private ExperienceUpdateTask() {}
    
    protected Void doInBackground(Experience... paramVarArgs)
    {
      ExperienceManager localExperienceManager = ExperienceManager.getInstance(ExperienceListFragment.this.mActivity);
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++) {
        localExperienceManager.updateExperience(paramVarArgs[j]);
      }
      return null;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ExperienceListFragment
 * JD-Core Version:    0.7.0.1
 */