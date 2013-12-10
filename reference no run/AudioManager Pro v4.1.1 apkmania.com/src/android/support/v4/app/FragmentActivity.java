package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class FragmentActivity
  extends Activity
{
  private static final String FRAGMENTS_TAG = "android:support:fragments";
  private static final int HONEYCOMB = 11;
  static final int MSG_REALLY_STOPPED = 1;
  static final int MSG_RESUME_PENDING = 2;
  private static final String TAG = "FragmentActivity";
  SparseArrayCompat<LoaderManagerImpl> mAllLoaderManagers;
  boolean mCheckedForLoaderManager;
  boolean mCreated;
  final FragmentManagerImpl mFragments = new FragmentManagerImpl();
  final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        super.handleMessage(paramAnonymousMessage);
        break;
      case 1: 
        if (FragmentActivity.this.mStopped) {
          FragmentActivity.this.doReallyStop(false);
        }
        break;
      case 2: 
        FragmentActivity.this.onResumeFragments();
        FragmentActivity.this.mFragments.execPendingActions();
      }
    }
  };
  LoaderManagerImpl mLoaderManager;
  boolean mLoadersStarted;
  boolean mOptionsMenuInvalidated;
  boolean mReallyStopped;
  boolean mResumed;
  boolean mRetaining;
  boolean mStopped;
  
  void doReallyStop(boolean paramBoolean)
  {
    if (!this.mReallyStopped)
    {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      onReallyStop();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.mReallyStopped);
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.mLoadersStarted);
    if (this.mLoaderManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
      paramPrintWriter.println(":");
      this.mLoaderManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public Object getLastCustomNonConfigurationInstance()
  {
    Object localObject = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((NonConfigurationInstances)localObject).custom;
    }
    return localObject;
  }
  
  LoaderManagerImpl getLoaderManager(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAllLoaderManagers == null) {
      this.mAllLoaderManagers = new SparseArrayCompat();
    }
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramInt);
    if (localLoaderManagerImpl != null)
    {
      localLoaderManagerImpl.updateActivity(this);
    }
    else if (paramBoolean2)
    {
      localLoaderManagerImpl = new LoaderManagerImpl(this, paramBoolean1);
      this.mAllLoaderManagers.put(paramInt, localLoaderManagerImpl);
    }
    return localLoaderManagerImpl;
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return this.mFragments;
  }
  
  public LoaderManager getSupportLoaderManager()
  {
    LoaderManagerImpl localLoaderManagerImpl;
    if (this.mLoaderManager == null)
    {
      this.mCheckedForLoaderManager = true;
      this.mLoaderManager = getLoaderManager(-1, this.mLoadersStarted, true);
      localLoaderManagerImpl = this.mLoaderManager;
    }
    else
    {
      localLoaderManagerImpl = this.mLoaderManager;
    }
    return localLoaderManagerImpl;
  }
  
  void invalidateSupportFragmentIndex(int paramInt)
  {
    if (this.mAllLoaderManagers != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramInt);
      if ((localLoaderManagerImpl != null) && (!localLoaderManagerImpl.mRetaining))
      {
        localLoaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.remove(paramInt);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = paramInt1 >> 16;
    if (i == 0)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    else
    {
      i -= 1;
      if ((this.mFragments.mActive != null) && (i >= 0) && (i < this.mFragments.mActive.size()))
      {
        Fragment localFragment = (Fragment)this.mFragments.mActive.get(i);
        if (localFragment != null) {
          localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
        } else {
          Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
        }
      }
      else
      {
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
      }
    }
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed()
  {
    if (!this.mFragments.popBackStackImmediate()) {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.dispatchConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mFragments.attachActivity(this);
    if (getLayoutInflater().getFactory() == null) {
      getLayoutInflater().setFactory(this);
    }
    super.onCreate(paramBundle);
    Object localObject = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localObject != null) {
      this.mAllLoaderManagers = ((NonConfigurationInstances)localObject).loaders;
    }
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      FragmentManagerImpl localFragmentManagerImpl = this.mFragments;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((NonConfigurationInstances)localObject).fragments;
      }
      localFragmentManagerImpl.restoreAllState(localParcelable, (ArrayList)localObject);
    }
    this.mFragments.dispatchCreate();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    boolean bool;
    if (paramInt != 0)
    {
      bool = super.onCreatePanelMenu(paramInt, paramMenu);
    }
    else
    {
      bool = super.onCreatePanelMenu(paramInt, paramMenu) | this.mFragments.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT < 11) {
        bool = true;
      }
    }
    return bool;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    Fragment localFragment = null;
    TypedArray localTypedArray2 = 0;
    View localView;
    if ("fragment".equals(paramString))
    {
      String str1 = paramAttributeSet.getAttributeValue(null, "class");
      TypedArray localTypedArray3 = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentTag.Fragment);
      if (str1 == null) {
        str1 = localTypedArray3.getString(0);
      }
      TypedArray localTypedArray1 = localTypedArray3.getResourceId(1, -1);
      String str2 = localTypedArray3.getString(2);
      localTypedArray3.recycle();
      if (0 != 0) {
        localTypedArray2 = null.getId();
      }
      if ((localTypedArray2 != -1) || (localTypedArray1 != -1) || (str2 != null))
      {
        if (localTypedArray1 != -1) {
          localFragment = this.mFragments.findFragmentById(localTypedArray1);
        }
        if ((localFragment == null) && (str2 != null)) {
          localFragment = this.mFragments.findFragmentByTag(str2);
        }
        if ((localFragment == null) && (localTypedArray2 != -1)) {
          localFragment = this.mFragments.findFragmentById(localTypedArray2);
        }
        if (FragmentManagerImpl.DEBUG) {
          Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(localTypedArray1) + " fname=" + str1 + " existing=" + localFragment);
        }
        if (localFragment != null)
        {
          if (!localFragment.mInLayout)
          {
            localFragment.mInLayout = true;
            if (!localFragment.mRetaining) {
              localFragment.onInflate(this, paramAttributeSet, localFragment.mSavedFragmentState);
            }
            this.mFragments.moveToState(localFragment);
          }
          else
          {
            throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(localTypedArray1) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(localTypedArray2) + " with another fragment for " + str1);
          }
        }
        else
        {
          localFragment = Fragment.instantiate(this, str1);
          localFragment.mFromLayout = true;
          if (localTypedArray1 == 0) {
            localTypedArray3 = localTypedArray2;
          } else {
            localTypedArray3 = localTypedArray1;
          }
          localFragment.mFragmentId = localTypedArray3;
          localFragment.mContainerId = localTypedArray2;
          localFragment.mTag = str2;
          localFragment.mInLayout = true;
          localFragment.mFragmentManager = this.mFragments;
          localFragment.onInflate(this, paramAttributeSet, localFragment.mSavedFragmentState);
          this.mFragments.addFragment(localFragment, true);
        }
        if (localFragment.mView != null)
        {
          if (localTypedArray1 != 0) {
            localFragment.mView.setId(localTypedArray1);
          }
          if (localFragment.mView.getTag() == null) {
            localFragment.mView.setTag(str2);
          }
          localView = localFragment.mView;
        }
        else
        {
          throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        }
      }
      else
      {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      }
    }
    else
    {
      localView = super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    return localView;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    doReallyStop(false);
    this.mFragments.dispatchDestroy();
    if (this.mLoaderManager != null) {
      this.mLoaderManager.doDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 5) || (paramInt != 4) || (paramKeyEvent.getRepeatCount() != 0))
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
    }
    else
    {
      onBackPressed();
      bool = true;
    }
    return bool;
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool;
    if (!super.onMenuItemSelected(paramInt, paramMenuItem)) {
      switch (paramInt)
      {
      default: 
        bool = false;
        break;
      case 0: 
        bool = this.mFragments.dispatchOptionsItemSelected(paramMenuItem);
        break;
      case 6: 
        bool = this.mFragments.dispatchContextItemSelected(paramMenuItem);
        break;
      }
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    case 0: 
      this.mFragments.dispatchOptionsMenuClosed(paramMenu);
    }
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    }
    this.mFragments.dispatchPause();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.execPendingActions();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    boolean bool = false;
    if ((paramInt != 0) || (paramMenu == null))
    {
      bool = super.onPreparePanel(paramInt, paramView, paramMenu);
    }
    else
    {
      if (this.mOptionsMenuInvalidated)
      {
        this.mOptionsMenuInvalidated = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      if (((super.onPreparePanel(paramInt, paramView, paramMenu) | this.mFragments.dispatchPrepareOptionsMenu(paramMenu))) && (paramMenu.hasVisibleItems())) {
        bool = true;
      }
    }
    return bool;
  }
  
  void onReallyStop()
  {
    if (this.mLoadersStarted)
    {
      this.mLoadersStarted = false;
      if (this.mLoaderManager != null) {
        if (this.mRetaining) {
          this.mLoaderManager.doRetain();
        } else {
          this.mLoaderManager.doStop();
        }
      }
    }
    this.mFragments.dispatchReallyStop();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.execPendingActions();
  }
  
  protected void onResumeFragments()
  {
    this.mFragments.dispatchResume();
  }
  
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (this.mStopped) {
      doReallyStop(true);
    }
    Object localObject = onRetainCustomNonConfigurationInstance();
    ArrayList localArrayList = this.mFragments.retainNonConfig();
    int i = 0;
    if (this.mAllLoaderManagers != null) {}
    for (int k = -1 + this.mAllLoaderManagers.size();; k--)
    {
      if (k < 0)
      {
        NonConfigurationInstances localNonConfigurationInstances;
        if ((localArrayList != null) || (i != 0) || (localObject != null))
        {
          localNonConfigurationInstances = new NonConfigurationInstances();
          localNonConfigurationInstances.activity = null;
          localNonConfigurationInstances.custom = localObject;
          localNonConfigurationInstances.children = null;
          localNonConfigurationInstances.fragments = localArrayList;
          localNonConfigurationInstances.loaders = this.mAllLoaderManagers;
        }
        else
        {
          localNonConfigurationInstances = null;
        }
        return localNonConfigurationInstances;
      }
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(k);
      if (!localLoaderManagerImpl.mRetaining)
      {
        localLoaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.removeAt(k);
      }
      else
      {
        int j = 1;
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.mFragments.saveAllState();
    if (localParcelable != null) {
      paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.mStopped = false;
    this.mReallyStopped = false;
    this.mHandler.removeMessages(1);
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.dispatchActivityCreated();
    }
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
    if (!this.mLoadersStarted)
    {
      this.mLoadersStarted = true;
      if (this.mLoaderManager == null)
      {
        if (!this.mCheckedForLoaderManager) {
          this.mLoaderManager = getLoaderManager(-1, this.mLoadersStarted, false);
        }
      }
      else {
        this.mLoaderManager.doStart();
      }
      this.mCheckedForLoaderManager = true;
    }
    this.mFragments.dispatchStart();
    if (this.mAllLoaderManagers != null) {}
    for (int i = -1 + this.mAllLoaderManagers.size();; i--)
    {
      if (i < 0) {
        return;
      }
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(i);
      localLoaderManagerImpl.finishRetain();
      localLoaderManagerImpl.doReportStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.mStopped = true;
    this.mHandler.sendEmptyMessage(1);
    this.mFragments.dispatchStop();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt == -1) || ((0xFFFF0000 & paramInt) == 0))
    {
      super.startActivityForResult(paramIntent, paramInt);
      return;
    }
    throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt != -1)
    {
      if ((0xFFFF0000 & paramInt) == 0) {
        super.startActivityForResult(paramIntent, (1 + paramFragment.mIndex << 16) + (0xFFFF & paramInt));
      } else {
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
      }
    }
    else {
      super.startActivityForResult(paramIntent, -1);
    }
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (Build.VERSION.SDK_INT < 11) {
      this.mOptionsMenuInvalidated = true;
    } else {
      ActivityCompatHoneycomb.invalidateOptionsMenu(this);
    }
  }
  
  static class FragmentTag
  {
    public static final int[] Fragment;
    public static final int Fragment_id = 1;
    public static final int Fragment_name = 0;
    public static final int Fragment_tag = 2;
    
    static
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = 16842755;
      arrayOfInt[1] = 16842960;
      arrayOfInt[2] = 16842961;
      Fragment = arrayOfInt;
    }
  }
  
  static final class NonConfigurationInstances
  {
    Object activity;
    HashMap<String, Object> children;
    Object custom;
    ArrayList<Fragment> fragments;
    SparseArrayCompat<LoaderManagerImpl> loaders;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * JD-Core Version:    0.7.0.1
 */