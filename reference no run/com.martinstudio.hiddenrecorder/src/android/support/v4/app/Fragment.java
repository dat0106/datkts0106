package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener
{
  static final int ACTIVITY_CREATED = 2;
  static final int CREATED = 1;
  static final int INITIALIZING = 0;
  static final int RESUMED = 5;
  static final int STARTED = 4;
  static final int STOPPED = 3;
  private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap();
  FragmentActivity mActivity;
  boolean mAdded;
  View mAnimatingAway;
  Bundle mArguments;
  int mBackStackNesting;
  boolean mCalled;
  boolean mCheckedForLoaderManager;
  FragmentManagerImpl mChildFragmentManager;
  ViewGroup mContainer;
  int mContainerId;
  boolean mDeferStart;
  boolean mDetached;
  int mFragmentId;
  FragmentManagerImpl mFragmentManager;
  boolean mFromLayout;
  boolean mHasMenu;
  boolean mHidden;
  boolean mInLayout;
  int mIndex = -1;
  View mInnerView;
  LoaderManagerImpl mLoaderManager;
  boolean mLoadersStarted;
  boolean mMenuVisible = true;
  int mNextAnim;
  Fragment mParentFragment;
  boolean mRemoving;
  boolean mRestored;
  boolean mResumed;
  boolean mRetainInstance;
  boolean mRetaining;
  Bundle mSavedFragmentState;
  SparseArray<Parcelable> mSavedViewState;
  int mState = 0;
  int mStateAfterAnimating;
  String mTag;
  Fragment mTarget;
  int mTargetIndex = -1;
  int mTargetRequestCode;
  boolean mUserVisibleHint = true;
  View mView;
  String mWho;
  
  public static Fragment instantiate(Context paramContext, String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }
  
  public static Fragment instantiate(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Object localObject = (Class)sClassMap.get(paramString);
      if (localObject == null)
      {
        localObject = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, localObject);
      }
      localObject = (Fragment)((Class)localObject).newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(localObject.getClass().getClassLoader());
        ((Fragment)localObject).mArguments = paramBundle;
      }
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localClassNotFoundException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an" + " empty constructor that is public", localIllegalAccessException);
    }
  }
  
  static boolean isSupportFragmentClass(Context paramContext, String paramString)
  {
    try
    {
      Class localClass = (Class)sClassMap.get(paramString);
      if (localClass == null)
      {
        localClass = paramContext.getClassLoader().loadClass(paramString);
        sClassMap.put(paramString, localClass);
      }
      bool = Fragment.class.isAssignableFrom(localClass);
      bool = bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.mState);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.mIndex);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.mRemoving);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.mRetainInstance);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(this.mRetaining);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.mUserVisibleHint);
    if (this.mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.mFragmentManager);
    }
    if (this.mActivity != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mActivity=");
      paramPrintWriter.println(this.mActivity);
    }
    if (this.mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.mParentFragment);
    }
    if (this.mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.mArguments);
    }
    if (this.mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.mSavedFragmentState);
    }
    if (this.mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.mSavedViewState);
    }
    if (this.mTarget != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(this.mTarget);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.mTargetRequestCode);
    }
    if (this.mNextAnim != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(this.mNextAnim);
    }
    if (this.mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.mContainer);
    }
    if (this.mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.mView);
    }
    if (this.mInnerView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(this.mView);
    }
    if (this.mAnimatingAway != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(this.mAnimatingAway);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(this.mStateAfterAnimating);
    }
    if (this.mLoaderManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      this.mLoaderManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (this.mChildFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + this.mChildFragmentManager + ":");
      this.mChildFragmentManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  Fragment findFragmentByWho(String paramString)
  {
    if (!paramString.equals(this.mWho)) {
      if (this.mChildFragmentManager == null) {
        this = null;
      } else {
        this = this.mChildFragmentManager.findFragmentByWho(paramString);
      }
    }
    return this;
  }
  
  public final FragmentActivity getActivity()
  {
    return this.mActivity;
  }
  
  public final Bundle getArguments()
  {
    return this.mArguments;
  }
  
  public final FragmentManager getChildFragmentManager()
  {
    if (this.mChildFragmentManager == null)
    {
      instantiateChildFragmentManager();
      if (this.mState < 5)
      {
        if (this.mState < 4)
        {
          if (this.mState < 2)
          {
            if (this.mState >= 1) {
              this.mChildFragmentManager.dispatchCreate();
            }
          }
          else {
            this.mChildFragmentManager.dispatchActivityCreated();
          }
        }
        else {
          this.mChildFragmentManager.dispatchStart();
        }
      }
      else {
        this.mChildFragmentManager.dispatchResume();
      }
    }
    return this.mChildFragmentManager;
  }
  
  public final FragmentManager getFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  public final int getId()
  {
    return this.mFragmentId;
  }
  
  public LayoutInflater getLayoutInflater(Bundle paramBundle)
  {
    return this.mActivity.getLayoutInflater();
  }
  
  public LoaderManager getLoaderManager()
  {
    LoaderManagerImpl localLoaderManagerImpl;
    if (this.mLoaderManager == null)
    {
      if (this.mActivity != null)
      {
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mActivity.getLoaderManager(this.mWho, this.mLoadersStarted, true);
        localLoaderManagerImpl = this.mLoaderManager;
      }
      else
      {
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      }
    }
    else {
      localLoaderManagerImpl = this.mLoaderManager;
    }
    return localLoaderManagerImpl;
  }
  
  public final Fragment getParentFragment()
  {
    return this.mParentFragment;
  }
  
  public final Resources getResources()
  {
    if (this.mActivity != null) {
      return this.mActivity.getResources();
    }
    throw new IllegalStateException("Fragment " + this + " not attached to Activity");
  }
  
  public final boolean getRetainInstance()
  {
    return this.mRetainInstance;
  }
  
  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  public final String getTag()
  {
    return this.mTag;
  }
  
  public final Fragment getTargetFragment()
  {
    return this.mTarget;
  }
  
  public final int getTargetRequestCode()
  {
    return this.mTargetRequestCode;
  }
  
  public final CharSequence getText(int paramInt)
  {
    return getResources().getText(paramInt);
  }
  
  public boolean getUserVisibleHint()
  {
    return this.mUserVisibleHint;
  }
  
  public View getView()
  {
    return this.mView;
  }
  
  public final boolean hasOptionsMenu()
  {
    return this.mHasMenu;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  void initState()
  {
    this.mIndex = -1;
    this.mWho = null;
    this.mAdded = false;
    this.mRemoving = false;
    this.mResumed = false;
    this.mFromLayout = false;
    this.mInLayout = false;
    this.mRestored = false;
    this.mBackStackNesting = 0;
    this.mFragmentManager = null;
    this.mActivity = null;
    this.mFragmentId = 0;
    this.mContainerId = 0;
    this.mTag = null;
    this.mHidden = false;
    this.mDetached = false;
    this.mRetaining = false;
    this.mLoaderManager = null;
    this.mLoadersStarted = false;
    this.mCheckedForLoaderManager = false;
  }
  
  void instantiateChildFragmentManager()
  {
    this.mChildFragmentManager = new FragmentManagerImpl();
    this.mChildFragmentManager.attachActivity(this.mActivity, new FragmentContainer()
    {
      public View findViewById(int paramAnonymousInt)
      {
        if (Fragment.this.mView != null) {
          return Fragment.this.mView.findViewById(paramAnonymousInt);
        }
        throw new IllegalStateException("Fragment does not have a view");
      }
    }, this);
  }
  
  public final boolean isAdded()
  {
    boolean bool;
    if ((this.mActivity == null) || (!this.mAdded)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final boolean isDetached()
  {
    return this.mDetached;
  }
  
  public final boolean isHidden()
  {
    return this.mHidden;
  }
  
  final boolean isInBackStack()
  {
    boolean bool;
    if (this.mBackStackNesting <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final boolean isInLayout()
  {
    return this.mInLayout;
  }
  
  public final boolean isMenuVisible()
  {
    return this.mMenuVisible;
  }
  
  public final boolean isRemoving()
  {
    return this.mRemoving;
  }
  
  public final boolean isResumed()
  {
    return this.mResumed;
  }
  
  public final boolean isVisible()
  {
    boolean bool;
    if ((!isAdded()) || (isHidden()) || (this.mView == null) || (this.mView.getWindowToken() == null) || (this.mView.getVisibility() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAttach(Activity paramActivity)
  {
    this.mCalled = true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mCalled = true;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    getActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public void onDestroy()
  {
    this.mCalled = true;
    if (!this.mCheckedForLoaderManager)
    {
      this.mCheckedForLoaderManager = true;
      this.mLoaderManager = this.mActivity.getLoaderManager(this.mWho, this.mLoadersStarted, false);
    }
    if (this.mLoaderManager != null) {
      this.mLoaderManager.doDestroy();
    }
  }
  
  public void onDestroyOptionsMenu() {}
  
  public void onDestroyView()
  {
    this.mCalled = true;
  }
  
  public void onDetach()
  {
    this.mCalled = true;
  }
  
  public void onHiddenChanged(boolean paramBoolean) {}
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  public void onLowMemory()
  {
    this.mCalled = true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {}
  
  public void onPause()
  {
    this.mCalled = true;
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onResume()
  {
    this.mCalled = true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.mCalled = true;
    if (!this.mLoadersStarted)
    {
      this.mLoadersStarted = true;
      if (!this.mCheckedForLoaderManager)
      {
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mActivity.getLoaderManager(this.mWho, this.mLoadersStarted, false);
      }
      if (this.mLoaderManager != null) {
        this.mLoaderManager.doStart();
      }
    }
  }
  
  public void onStop()
  {
    this.mCalled = true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {}
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  void performActivityCreated(Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    this.mCalled = false;
    onActivityCreated(paramBundle);
    if (this.mCalled)
    {
      if (this.mChildFragmentManager != null) {
        this.mChildFragmentManager.dispatchActivityCreated();
      }
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
  }
  
  void performConfigurationChanged(Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchConfigurationChanged(paramConfiguration);
    }
  }
  
  boolean performContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    if ((this.mHidden) || ((!onContextItemSelected(paramMenuItem)) && ((this.mChildFragmentManager == null) || (!this.mChildFragmentManager.dispatchContextItemSelected(paramMenuItem))))) {
      bool = false;
    }
    return bool;
  }
  
  void performCreate(Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    this.mCalled = false;
    onCreate(paramBundle);
    if (this.mCalled)
    {
      if (paramBundle != null)
      {
        Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
        if (localParcelable != null)
        {
          if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
          }
          this.mChildFragmentManager.restoreAllState(localParcelable, null);
          this.mChildFragmentManager.dispatchCreate();
        }
      }
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
  }
  
  boolean performCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool = false;
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible))
      {
        bool = true;
        onCreateOptionsMenu(paramMenu, paramMenuInflater);
      }
      if (this.mChildFragmentManager != null) {
        bool |= this.mChildFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
      }
    }
    return bool;
  }
  
  View performCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.noteStateNotSaved();
    }
    return onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  void performDestroy()
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchDestroy();
    }
    this.mCalled = false;
    onDestroy();
    if (this.mCalled) {
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
  }
  
  void performDestroyView()
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchDestroyView();
    }
    this.mCalled = false;
    onDestroyView();
    if (this.mCalled)
    {
      if (this.mLoaderManager != null) {
        this.mLoaderManager.doReportNextStart();
      }
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
  }
  
  void performLowMemory()
  {
    onLowMemory();
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchLowMemory();
    }
  }
  
  boolean performOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    if ((this.mHidden) || (((!this.mHasMenu) || (!this.mMenuVisible) || (!onOptionsItemSelected(paramMenuItem))) && ((this.mChildFragmentManager == null) || (!this.mChildFragmentManager.dispatchOptionsItemSelected(paramMenuItem))))) {
      bool = false;
    }
    return bool;
  }
  
  void performOptionsMenuClosed(Menu paramMenu)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      if (this.mChildFragmentManager != null) {
        this.mChildFragmentManager.dispatchOptionsMenuClosed(paramMenu);
      }
    }
  }
  
  void performPause()
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchPause();
    }
    this.mCalled = false;
    onPause();
    if (this.mCalled) {
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
  }
  
  boolean performPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = false;
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible))
      {
        bool = true;
        onPrepareOptionsMenu(paramMenu);
      }
      if (this.mChildFragmentManager != null) {
        bool |= this.mChildFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
      }
    }
    return bool;
  }
  
  void performReallyStop()
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchReallyStop();
    }
    if (this.mLoadersStarted)
    {
      this.mLoadersStarted = false;
      if (!this.mCheckedForLoaderManager)
      {
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mActivity.getLoaderManager(this.mWho, this.mLoadersStarted, false);
      }
      if (this.mLoaderManager != null) {
        if (this.mActivity.mRetaining) {
          this.mLoaderManager.doRetain();
        } else {
          this.mLoaderManager.doStop();
        }
      }
    }
  }
  
  void performResume()
  {
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mCalled = false;
    onResume();
    if (this.mCalled)
    {
      if (this.mChildFragmentManager != null)
      {
        this.mChildFragmentManager.dispatchResume();
        this.mChildFragmentManager.execPendingActions();
      }
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
  }
  
  void performSaveInstanceState(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    if (this.mChildFragmentManager != null)
    {
      Parcelable localParcelable = this.mChildFragmentManager.saveAllState();
      if (localParcelable != null) {
        paramBundle.putParcelable("android:support:fragments", localParcelable);
      }
    }
  }
  
  void performStart()
  {
    if (this.mChildFragmentManager != null)
    {
      this.mChildFragmentManager.noteStateNotSaved();
      this.mChildFragmentManager.execPendingActions();
    }
    this.mCalled = false;
    onStart();
    if (this.mCalled)
    {
      if (this.mChildFragmentManager != null) {
        this.mChildFragmentManager.dispatchStart();
      }
      if (this.mLoaderManager != null) {
        this.mLoaderManager.doReportStart();
      }
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
  }
  
  void performStop()
  {
    if (this.mChildFragmentManager != null) {
      this.mChildFragmentManager.dispatchStop();
    }
    this.mCalled = false;
    onStop();
    if (this.mCalled) {
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
  }
  
  public void registerForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }
  
  final void restoreViewState(Bundle paramBundle)
  {
    if (this.mSavedViewState != null)
    {
      this.mInnerView.restoreHierarchyState(this.mSavedViewState);
      this.mSavedViewState = null;
    }
    this.mCalled = false;
    onViewStateRestored(paramBundle);
    if (this.mCalled) {
      return;
    }
    throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
  }
  
  public void setArguments(Bundle paramBundle)
  {
    if (this.mIndex < 0)
    {
      this.mArguments = paramBundle;
      return;
    }
    throw new IllegalStateException("Fragment already active");
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (this.mHasMenu != paramBoolean)
    {
      this.mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        this.mActivity.supportInvalidateOptionsMenu();
      }
    }
  }
  
  final void setIndex(int paramInt, Fragment paramFragment)
  {
    this.mIndex = paramInt;
    if (paramFragment == null) {
      this.mWho = ("android:fragment:" + this.mIndex);
    } else {
      this.mWho = (paramFragment.mWho + ":" + this.mIndex);
    }
  }
  
  public void setInitialSavedState(SavedState paramSavedState)
  {
    if (this.mIndex < 0)
    {
      Bundle localBundle;
      if ((paramSavedState == null) || (paramSavedState.mState == null)) {
        localBundle = null;
      } else {
        localBundle = paramSavedState.mState;
      }
      this.mSavedFragmentState = localBundle;
      return;
    }
    throw new IllegalStateException("Fragment already active");
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    if (this.mMenuVisible != paramBoolean)
    {
      this.mMenuVisible = paramBoolean;
      if ((this.mHasMenu) && (isAdded()) && (!isHidden())) {
        this.mActivity.supportInvalidateOptionsMenu();
      }
    }
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.mParentFragment == null))
    {
      this.mRetainInstance = paramBoolean;
      return;
    }
    throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
  }
  
  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    this.mTarget = paramFragment;
    this.mTargetRequestCode = paramInt;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!this.mUserVisibleHint) && (paramBoolean) && (this.mState < 4)) {
      this.mFragmentManager.performPendingDeferredStart(this);
    }
    this.mUserVisibleHint = paramBoolean;
    boolean bool;
    if (paramBoolean) {
      bool = false;
    } else {
      bool = true;
    }
    this.mDeferStart = bool;
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (this.mActivity != null)
    {
      this.mActivity.startActivityFromFragment(this, paramIntent, -1);
      return;
    }
    throw new IllegalStateException("Fragment " + this + " not attached to Activity");
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.mActivity != null)
    {
      this.mActivity.startActivityFromFragment(this, paramIntent, paramInt);
      return;
    }
    throw new IllegalStateException("Fragment " + this + " not attached to Activity");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mFragmentId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.mFragmentId));
    }
    if (this.mTag != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mTag);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }
  
  public static class InstantiationException
    extends RuntimeException
  {
    public InstantiationException(String paramString, Exception paramException)
    {
      super(paramException);
    }
  }
  
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public Fragment.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Fragment.SavedState(paramAnonymousParcel, null);
      }
      
      public Fragment.SavedState[] newArray(int paramAnonymousInt)
      {
        return new Fragment.SavedState[paramAnonymousInt];
      }
    };
    final Bundle mState;
    
    SavedState(Bundle paramBundle)
    {
      this.mState = paramBundle;
    }
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.mState = paramParcel.readBundle();
      if ((paramClassLoader != null) && (this.mState != null)) {
        this.mState.setClassLoader(paramClassLoader);
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeBundle(this.mState);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.Fragment
 * JD-Core Version:    0.7.0.1
 */