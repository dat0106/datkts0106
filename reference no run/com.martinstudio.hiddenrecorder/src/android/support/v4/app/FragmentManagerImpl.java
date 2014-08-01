package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class FragmentManagerImpl
  extends FragmentManager
{
  static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  static final Interpolator ACCELERATE_QUINT;
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final boolean HONEYCOMB = false;
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  ArrayList<Fragment> mActive;
  FragmentActivity mActivity;
  ArrayList<Fragment> mAdded;
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<Integer> mAvailIndices;
  ArrayList<BackStackRecord> mBackStack;
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  ArrayList<BackStackRecord> mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new Runnable()
  {
    public void run()
    {
      FragmentManagerImpl.this.execPendingActions();
    }
  };
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  boolean mNeedMenuInvalidate;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList<Runnable> mPendingActions;
  SparseArray<Parcelable> mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  Runnable[] mTmpActions;
  
  static
  {
    boolean bool = false;
    DEBUG = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    HONEYCOMB = bool;
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  private void checkStateLoss()
  {
    if (!this.mStateSaved)
    {
      if (this.mNoTransactionsBecause == null) {
        return;
      }
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  static Animation makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(DECELERATE_CUBIC);
    localAlphaAnimation.setDuration(220L);
    return localAlphaAnimation;
  }
  
  static Animation makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  public static int reverseTransit(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    case 4097: 
      i = 8194;
      break;
    case 4099: 
      i = 4099;
      break;
    case 8194: 
      i = 4097;
    }
    return i;
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    if (this.mActivity != null) {}
    for (;;)
    {
      try
      {
        this.mActivity.dump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    int i = -1;
    switch (paramInt)
    {
    case 4097: 
      if (!paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      break;
    case 4099: 
      if (!paramBoolean) {
        i = 6;
      } else {
        i = 5;
      }
      break;
    case 8194: 
      if (!paramBoolean) {
        i = 4;
      } else {
        i = 3;
      }
      break;
    }
    return i;
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(paramBackStackRecord);
    reportBackStackChanged();
  }
  
  public void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mAdded == null) {
      this.mAdded = new ArrayList();
    }
    if (DEBUG) {
      Log.v("FragmentManager", "add: " + paramFragment);
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached)
    {
      if (this.mAdded.contains(paramFragment)) {
        break label121;
      }
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
    }
    return;
    label121:
    throw new IllegalStateException("Fragment already added: " + paramFragment);
  }
  
  public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  public int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    try
    {
      int i;
      if ((this.mAvailBackStackIndices == null) || (this.mAvailBackStackIndices.size() <= 0))
      {
        if (this.mBackStackIndices == null) {
          this.mBackStackIndices = new ArrayList();
        }
        i = this.mBackStackIndices.size();
        if (DEBUG) {
          Log.v("FragmentManager", "Setting back stack index " + i + " to " + paramBackStackRecord);
        }
        this.mBackStackIndices.add(paramBackStackRecord);
        i = i;
      }
      else
      {
        i = ((Integer)this.mAvailBackStackIndices.remove(-1 + this.mAvailBackStackIndices.size())).intValue();
        if (DEBUG) {
          Log.v("FragmentManager", "Adding back stack index " + i + " with " + paramBackStackRecord);
        }
        this.mBackStackIndices.set(i, paramBackStackRecord);
        i = i;
      }
    }
    finally {}
    return localObject;
  }
  
  public void attachActivity(FragmentActivity paramFragmentActivity, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (this.mActivity == null)
    {
      this.mActivity = paramFragmentActivity;
      this.mContainer = paramFragmentContainer;
      this.mParent = paramFragment;
      return;
    }
    throw new IllegalStateException("Already attached");
  }
  
  public void attachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.mAdded == null) {
          this.mAdded = new ArrayList();
        }
        if (this.mAdded.contains(paramFragment)) {
          break label158;
        }
        if (DEBUG) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        }
        this.mAdded.add(paramFragment);
        paramFragment.mAdded = true;
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        moveToState(paramFragment, this.mCurState, paramInt1, paramInt2, false);
      }
    }
    return;
    label158:
    throw new IllegalStateException("Fragment already added: " + paramFragment);
  }
  
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  public void detachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (this.mAdded != null)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "remove from detach: " + paramFragment);
          }
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        moveToState(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    moveToState(2, false);
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.mAdded != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mAdded.size()) {
        return;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    if (this.mAdded != null) {}
    for (int j = 0;; j++)
    {
      if (j >= this.mAdded.size())
      {
        int i = 0;
        return ???;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(j);
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
        break;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public void dispatchCreate()
  {
    this.mStateSaved = false;
    moveToState(1, false);
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    boolean bool = false;
    ArrayList localArrayList = null;
    if (this.mAdded != null) {}
    Fragment localFragment2;
    for (int j = 0;; localFragment2++)
    {
      if (j >= this.mAdded.size())
      {
        if (this.mCreatedMenus != null) {}
        for (int i = 0;; i++)
        {
          if (i >= this.mCreatedMenus.size())
          {
            this.mCreatedMenus = localArrayList;
            return bool;
          }
          localFragment2 = (Fragment)this.mCreatedMenus.get(i);
          if ((localArrayList == null) || (!localArrayList.contains(localFragment2))) {
            localFragment2.onDestroyOptionsMenu();
          }
        }
      }
      Fragment localFragment1 = (Fragment)this.mAdded.get(localFragment2);
      if ((localFragment1 != null) && (localFragment1.performCreateOptionsMenu(paramMenu, paramMenuInflater)))
      {
        bool = true;
        if (localArrayList == null) {
          localArrayList = new ArrayList();
        }
        localArrayList.add(localFragment1);
      }
    }
  }
  
  public void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions();
    moveToState(0, false);
    this.mActivity = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public void dispatchDestroyView()
  {
    moveToState(1, false);
  }
  
  public void dispatchLowMemory()
  {
    if (this.mAdded != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mAdded.size()) {
        return;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
    }
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mAdded != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mAdded.size()) {
        return 0;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
        break;
      }
    }
    i = 1;
    return i;
  }
  
  public void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.mAdded != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mAdded.size()) {
        return;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if (localFragment != null) {
        localFragment.performOptionsMenuClosed(paramMenu);
      }
    }
  }
  
  public void dispatchPause()
  {
    moveToState(4, false);
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = false;
    if (this.mAdded != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mAdded.size()) {
        return bool;
      }
      Fragment localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (localFragment.performPrepareOptionsMenu(paramMenu))) {
        bool = true;
      }
    }
  }
  
  public void dispatchReallyStop()
  {
    moveToState(2, false);
  }
  
  public void dispatchResume()
  {
    this.mStateSaved = false;
    moveToState(5, false);
  }
  
  public void dispatchStart()
  {
    this.mStateSaved = false;
    moveToState(4, false);
  }
  
  public void dispatchStop()
  {
    this.mStateSaved = true;
    moveToState(3, false);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = paramString + "    ";
    int j;
    if (this.mActive != null)
    {
      int k = this.mActive.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        for (j = 0; j < k; j++)
        {
          Fragment localFragment2 = (Fragment)this.mActive.get(j);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(j);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment2);
          if (localFragment2 != null) {
            localFragment2.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
        }
      }
    }
    if (this.mAdded != null)
    {
      int i1 = this.mAdded.size();
      if (i1 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        for (j = 0; j < i1; j++)
        {
          Fragment localFragment1 = (Fragment)this.mAdded.get(j);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(j);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment1.toString());
        }
      }
    }
    if (this.mCreatedMenus != null)
    {
      j = this.mCreatedMenus.size();
      if (j > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        for (int m = 0; m < j; m++)
        {
          Fragment localFragment3 = (Fragment)this.mCreatedMenus.get(m);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(m);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment3.toString());
        }
      }
    }
    BackStackRecord localBackStackRecord;
    if (this.mBackStack != null)
    {
      int i2 = this.mBackStack.size();
      if (i2 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        for (j = 0; j < i2; j++)
        {
          localBackStackRecord = (BackStackRecord)this.mBackStack.get(j);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(j);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localBackStackRecord.toString());
          localBackStackRecord.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }
    try
    {
      if (this.mBackStackIndices != null)
      {
        j = this.mBackStackIndices.size();
        if (j > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          for (int i = 0; i < j; i++)
          {
            localBackStackRecord = (BackStackRecord)this.mBackStackIndices.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(localBackStackRecord);
          }
        }
      }
      if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
      }
      if (this.mPendingActions != null)
      {
        j = this.mPendingActions.size();
        if (j > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          for (int n = 0; n < j; n++)
          {
            Runnable localRunnable = (Runnable)this.mPendingActions.get(n);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(n);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(localRunnable);
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mActivity=");
    paramPrintWriter.println(this.mActivity);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.mContainer);
    if (this.mParent != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.mParent);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.mCurState);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.mStateSaved);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.mDestroyed);
    if (this.mNeedMenuInvalidate)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.mNeedMenuInvalidate);
    }
    if (this.mNoTransactionsBecause != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.mNoTransactionsBecause);
    }
    if ((this.mAvailIndices != null) && (this.mAvailIndices.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
    }
  }
  
  /* Error */
  public void enqueueAction(Runnable paramRunnable, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +7 -> 8
    //   4: aload_0
    //   5: invokespecial 517	android/support/v4/app/FragmentManagerImpl:checkStateLoss	()V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 396	android/support/v4/app/FragmentManagerImpl:mDestroyed	Z
    //   14: ifne +10 -> 24
    //   17: aload_0
    //   18: getfield 224	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   21: ifnonnull +19 -> 40
    //   24: new 141	java/lang/IllegalStateException
    //   27: dup
    //   28: ldc_w 519
    //   31: invokespecial 157	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   34: athrow
    //   35: astore_3
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_3
    //   39: athrow
    //   40: aload_0
    //   41: getfield 483	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   44: ifnonnull +14 -> 58
    //   47: aload_0
    //   48: new 248	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 249	java/util/ArrayList:<init>	()V
    //   55: putfield 483	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   58: aload_0
    //   59: getfield 483	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   62: aload_1
    //   63: invokevirtual 253	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload_0
    //   68: getfield 483	android/support/v4/app/FragmentManagerImpl:mPendingActions	Ljava/util/ArrayList;
    //   71: invokevirtual 310	java/util/ArrayList:size	()I
    //   74: iconst_1
    //   75: if_icmpne +32 -> 107
    //   78: aload_0
    //   79: getfield 224	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   82: getfield 523	android/support/v4/app/FragmentActivity:mHandler	Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield 134	android/support/v4/app/FragmentManagerImpl:mExecCommit	Ljava/lang/Runnable;
    //   89: invokevirtual 529	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   92: aload_0
    //   93: getfield 224	android/support/v4/app/FragmentManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   96: getfield 523	android/support/v4/app/FragmentActivity:mHandler	Landroid/os/Handler;
    //   99: aload_0
    //   100: getfield 134	android/support/v4/app/FragmentManagerImpl:mExecCommit	Ljava/lang/Runnable;
    //   103: invokevirtual 533	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	FragmentManagerImpl
    //   0	110	1	paramRunnable	Runnable
    //   0	110	2	paramBoolean	boolean
    //   35	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	38	35	finally
    //   40	109	35	finally
  }
  
  public boolean execPendingActions()
  {
    if (this.mExecutingActions) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != this.mActivity.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    int j;
    boolean bool;
    for (int i = 0;; bool = true) {
      try
      {
        if ((this.mPendingActions == null) || (this.mPendingActions.size() == 0))
        {
          if (!this.mHavePendingDeferredStart) {
            return i;
          }
          j = 0;
          for (int k = 0; k < this.mActive.size(); k++)
          {
            Fragment localFragment = (Fragment)this.mActive.get(k);
            if ((localFragment != null) && (localFragment.mLoaderManager != null)) {
              j |= localFragment.mLoaderManager.hasRunningLoaders();
            }
          }
        }
        i = this.mPendingActions.size();
        if ((this.mTmpActions == null) || (this.mTmpActions.length < i)) {
          this.mTmpActions = new Runnable[i];
        }
        this.mPendingActions.toArray(this.mTmpActions);
        this.mPendingActions.clear();
        this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
        this.mExecutingActions = true;
        for (j = 0; j < i; j++)
        {
          this.mTmpActions[j].run();
          this.mTmpActions[j] = null;
        }
        this.mExecutingActions = false;
      }
      finally {}
    }
    if (j == 0)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
    return bool;
  }
  
  public boolean executePendingTransactions()
  {
    return execPendingActions();
  }
  
  public Fragment findFragmentById(int paramInt)
  {
    if (this.mAdded != null) {}
    Fragment localFragment;
    for (int i = -1 + this.mAdded.size();; i--)
    {
      if (i < 0)
      {
        if (this.mActive != null) {}
        for (i = -1 + this.mActive.size();; i--)
        {
          if (i < 0)
          {
            localFragment = null;
            break;
          }
          localFragment = (Fragment)this.mActive.get(i);
          if ((localFragment != null) && (localFragment.mFragmentId == paramInt)) {
            break;
          }
        }
      }
      localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (localFragment.mFragmentId == paramInt)) {
        break;
      }
    }
    return localFragment;
  }
  
  public Fragment findFragmentByTag(String paramString)
  {
    if ((this.mAdded != null) && (paramString != null)) {}
    Fragment localFragment;
    for (int i = -1 + this.mAdded.size();; i--)
    {
      if (i < 0)
      {
        if ((this.mActive != null) && (paramString != null)) {}
        for (i = -1 + this.mActive.size();; i--)
        {
          if (i < 0)
          {
            localFragment = null;
            break;
          }
          localFragment = (Fragment)this.mActive.get(i);
          if ((localFragment != null) && (paramString.equals(localFragment.mTag))) {
            break;
          }
        }
      }
      localFragment = (Fragment)this.mAdded.get(i);
      if ((localFragment != null) && (paramString.equals(localFragment.mTag))) {
        break;
      }
    }
    return localFragment;
  }
  
  public Fragment findFragmentByWho(String paramString)
  {
    if ((this.mActive != null) && (paramString != null)) {}
    Fragment localFragment;
    for (int i = -1 + this.mActive.size();; i--)
    {
      if (i < 0)
      {
        localFragment = null;
        break;
      }
      localFragment = (Fragment)this.mActive.get(i);
      if (localFragment != null)
      {
        localFragment = localFragment.findFragmentByWho(paramString);
        if (localFragment != null) {
          break;
        }
      }
    }
    return localFragment;
  }
  
  public void freeBackStackIndex(int paramInt)
  {
    try
    {
      this.mBackStackIndices.set(paramInt, null);
      if (this.mAvailBackStackIndices == null) {
        this.mAvailBackStackIndices = new ArrayList();
      }
      if (DEBUG) {
        Log.v("FragmentManager", "Freeing back stack index " + paramInt);
      }
      this.mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    int i;
    if (this.mBackStack == null) {
      i = 0;
    } else {
      i = this.mBackStack.size();
    }
    return i;
  }
  
  public Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    Fragment localFragment;
    if (i != -1)
    {
      if (i >= this.mActive.size()) {
        throwException(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i));
      }
      localFragment = (Fragment)this.mActive.get(i);
      if (localFragment == null) {
        throwException(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i));
      }
    }
    else
    {
      localFragment = null;
    }
    return localFragment;
  }
  
  public List<Fragment> getFragments()
  {
    return this.mActive;
  }
  
  public void hideFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(8);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(true);
    }
  }
  
  Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation1 = paramFragment.onCreateAnimation(paramInt1, paramBoolean, paramFragment.mNextAnim);
    Animation localAnimation2;
    if (localAnimation1 == null)
    {
      if (paramFragment.mNextAnim != 0)
      {
        localAnimation1 = AnimationUtils.loadAnimation(this.mActivity, paramFragment.mNextAnim);
        if (localAnimation1 != null) {}
      }
      else
      {
        if (paramInt1 != 0)
        {
          int i = transitToStyleIndex(paramInt1, paramBoolean);
          if (i >= 0) {
            switch (i)
            {
            default: 
              if ((paramInt2 == 0) && (this.mActivity.getWindow() != null)) {
                paramInt2 = this.mActivity.getWindow().getAttributes().windowAnimations;
              }
              if (paramInt2 != 0) {
                localAnimation2 = null;
              } else {
                localAnimation2 = null;
              }
              break;
            case 1: 
              localAnimation2 = makeOpenCloseAnimation(this.mActivity, 1.125F, 1.0F, 0.0F, 1.0F);
              break;
            case 2: 
              localAnimation2 = makeOpenCloseAnimation(this.mActivity, 1.0F, 0.975F, 1.0F, 0.0F);
              break;
            case 3: 
              localAnimation2 = makeOpenCloseAnimation(this.mActivity, 0.975F, 1.0F, 0.0F, 1.0F);
              break;
            case 4: 
              localAnimation2 = makeOpenCloseAnimation(this.mActivity, 1.0F, 1.075F, 1.0F, 0.0F);
              break;
            case 5: 
              localAnimation2 = makeFadeAnimation(this.mActivity, 0.0F, 1.0F);
              break;
            case 6: 
              localAnimation2 = makeFadeAnimation(this.mActivity, 1.0F, 0.0F);
              break;
            }
          }
          localAnimation2 = null;
          break label295;
        }
        localAnimation2 = null;
        break label295;
      }
      localAnimation2 = localAnimation2;
    }
    label295:
    return localAnimation2;
  }
  
  void makeActive(Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0)
    {
      if ((this.mAvailIndices != null) && (this.mAvailIndices.size() > 0))
      {
        paramFragment.setIndex(((Integer)this.mAvailIndices.remove(-1 + this.mAvailIndices.size())).intValue(), this.mParent);
        this.mActive.set(paramFragment.mIndex, paramFragment);
      }
      else
      {
        if (this.mActive == null) {
          this.mActive = new ArrayList();
        }
        paramFragment.setIndex(this.mActive.size(), this.mParent);
        this.mActive.add(paramFragment);
      }
      if (DEBUG) {
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
      }
    }
  }
  
  void makeInactive(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0)
    {
      if (DEBUG) {
        Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
      }
      this.mActive.set(paramFragment.mIndex, null);
      if (this.mAvailIndices == null) {
        this.mAvailIndices = new ArrayList();
      }
      this.mAvailIndices.add(Integer.valueOf(paramFragment.mIndex));
      this.mActivity.invalidateSupportFragment(paramFragment.mWho);
      paramFragment.initState();
    }
  }
  
  void moveToState(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.mActivity != null) || (paramInt1 == 0))
    {
      boolean bool;
      if ((paramBoolean) || (this.mCurState != paramInt1))
      {
        this.mCurState = paramInt1;
        if (this.mActive != null) {
          bool = false;
        }
      }
      for (int i = 0;; i++)
      {
        if (i >= this.mActive.size())
        {
          if (!bool) {
            startPendingDeferredFragments();
          }
          if ((this.mNeedMenuInvalidate) && (this.mActivity != null) && (this.mCurState == 5))
          {
            this.mActivity.supportInvalidateOptionsMenu();
            this.mNeedMenuInvalidate = false;
          }
          return;
        }
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null)
        {
          moveToState(localFragment, paramInt1, paramInt2, paramInt3, false);
          if (localFragment.mLoaderManager != null) {
            bool |= localFragment.mLoaderManager.hasRunningLoaders();
          }
        }
      }
    }
    throw new IllegalStateException("No activity");
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    moveToState(paramInt, 0, 0, paramBoolean);
  }
  
  void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  void moveToState(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (((!paramFragment.mAdded) || (paramFragment.mDetached)) && (paramInt1 > 1)) {
      paramInt1 = 1;
    }
    if ((paramFragment.mRemoving) && (paramInt1 > paramFragment.mState)) {
      paramInt1 = paramFragment.mState;
    }
    if ((paramFragment.mDeferStart) && (paramFragment.mState < 4) && (paramInt1 > 3)) {
      paramInt1 = 3;
    }
    Object localObject;
    if (paramFragment.mState >= paramInt1)
    {
      if (paramFragment.mState > paramInt1)
      {
        switch (paramFragment.mState)
        {
        default: 
          break;
        case 5: 
          if (paramInt1 < 5)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
            }
            paramFragment.performPause();
            paramFragment.mResumed = false;
          }
        case 4: 
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
            }
            paramFragment.performStop();
          }
        case 3: 
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
            }
            paramFragment.performReallyStop();
          }
        case 2: 
          if (paramInt1 < 2)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
            }
            if ((paramFragment.mView != null) && (!this.mActivity.isFinishing()) && (paramFragment.mSavedViewState == null)) {
              saveFragmentViewState(paramFragment);
            }
            paramFragment.performDestroyView();
            if ((paramFragment.mView != null) && (paramFragment.mContainer != null))
            {
              localObject = null;
              if ((this.mCurState > 0) && (!this.mDestroyed)) {
                localObject = loadAnimation(paramFragment, paramInt2, false, paramInt3);
              }
              if (localObject != null)
              {
                paramFragment.mAnimatingAway = paramFragment.mView;
                paramFragment.mStateAfterAnimating = paramInt1;
                ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
                {
                  public void onAnimationEnd(Animation paramAnonymousAnimation)
                  {
                    if (paramFragment.mAnimatingAway != null)
                    {
                      paramFragment.mAnimatingAway = null;
                      FragmentManagerImpl.this.moveToState(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, false);
                    }
                  }
                  
                  public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
                  
                  public void onAnimationStart(Animation paramAnonymousAnimation) {}
                });
                paramFragment.mView.startAnimation((Animation)localObject);
              }
              paramFragment.mContainer.removeView(paramFragment.mView);
            }
            paramFragment.mContainer = null;
            paramFragment.mView = null;
            paramFragment.mInnerView = null;
          }
          break;
        }
        if (paramInt1 < 1)
        {
          if ((this.mDestroyed) && (paramFragment.mAnimatingAway != null))
          {
            localObject = paramFragment.mAnimatingAway;
            paramFragment.mAnimatingAway = null;
            ((View)localObject).clearAnimation();
          }
          if (paramFragment.mAnimatingAway == null)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
            }
            if (!paramFragment.mRetaining) {
              paramFragment.performDestroy();
            }
            paramFragment.mCalled = false;
            paramFragment.onDetach();
            if (paramFragment.mCalled)
            {
              if (!paramBoolean) {
                if (paramFragment.mRetaining)
                {
                  paramFragment.mActivity = null;
                  paramFragment.mFragmentManager = null;
                }
                else
                {
                  makeInactive(paramFragment);
                }
              }
            }
            else {
              throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDetach()");
            }
          }
          else
          {
            paramFragment.mStateAfterAnimating = paramInt1;
            paramInt1 = 1;
          }
        }
      }
    }
    else
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {
        break label1405;
      }
      if (paramFragment.mAnimatingAway != null)
      {
        paramFragment.mAnimatingAway = null;
        moveToState(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, true);
      }
      switch (paramFragment.mState)
      {
      case 0: 
        if (DEBUG) {
          Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
        }
        if (paramFragment.mSavedFragmentState != null)
        {
          paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
          paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
          if (paramFragment.mTarget != null) {
            paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
          }
          paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
          if (!paramFragment.mUserVisibleHint)
          {
            paramFragment.mDeferStart = true;
            if (paramInt1 > 3) {
              paramInt1 = 3;
            }
          }
        }
        paramFragment.mActivity = this.mActivity;
        paramFragment.mParentFragment = this.mParent;
        if (this.mParent == null) {
          localObject = this.mActivity.mFragments;
        } else {
          localObject = this.mParent.mChildFragmentManager;
        }
        paramFragment.mFragmentManager = ((FragmentManagerImpl)localObject);
        paramFragment.mCalled = false;
        paramFragment.onAttach(this.mActivity);
        if (!paramFragment.mCalled) {
          break label1406;
        }
        if (paramFragment.mParentFragment == null) {
          this.mActivity.onAttachFragment(paramFragment);
        }
        if (!paramFragment.mRetaining) {
          paramFragment.performCreate(paramFragment.mSavedFragmentState);
        }
        paramFragment.mRetaining = false;
        if (paramFragment.mFromLayout)
        {
          paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
          if (paramFragment.mView == null)
          {
            paramFragment.mInnerView = null;
          }
          else
          {
            paramFragment.mInnerView = paramFragment.mView;
            paramFragment.mView = NoSaveStateFrameLayout.wrap(paramFragment.mView);
            if (paramFragment.mHidden) {
              paramFragment.mView.setVisibility(8);
            }
            paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          }
        }
      case 1: 
        if (paramInt1 > 1)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!paramFragment.mFromLayout)
          {
            localObject = null;
            if (paramFragment.mContainerId != 0)
            {
              localObject = (ViewGroup)this.mContainer.findViewById(paramFragment.mContainerId);
              if ((localObject == null) && (!paramFragment.mRestored)) {
                throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + paramFragment.getResources().getResourceName(paramFragment.mContainerId) + ") for fragment " + paramFragment));
              }
            }
            paramFragment.mContainer = ((ViewGroup)localObject);
            paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject, paramFragment.mSavedFragmentState);
            if (paramFragment.mView == null)
            {
              paramFragment.mInnerView = null;
            }
            else
            {
              paramFragment.mInnerView = paramFragment.mView;
              paramFragment.mView = NoSaveStateFrameLayout.wrap(paramFragment.mView);
              if (localObject != null)
              {
                Animation localAnimation = loadAnimation(paramFragment, paramInt2, true, paramInt3);
                if (localAnimation != null) {
                  paramFragment.mView.startAnimation(localAnimation);
                }
                ((ViewGroup)localObject).addView(paramFragment.mView);
              }
              if (paramFragment.mHidden) {
                paramFragment.mView.setVisibility(8);
              }
              paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
            }
          }
          paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
          if (paramFragment.mView != null) {
            paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
          }
          paramFragment.mSavedFragmentState = null;
        }
      case 2: 
      case 3: 
        if (paramInt1 > 3)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
          }
          paramFragment.performStart();
        }
      case 4: 
        if (paramInt1 > 4)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
          }
          paramFragment.mResumed = true;
          paramFragment.performResume();
          paramFragment.mSavedFragmentState = null;
          paramFragment.mSavedViewState = null;
        }
        break;
      }
    }
    paramFragment.mState = paramInt1;
    label1405:
    return;
    label1406:
    throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
  }
  
  public void noteStateNotSaved()
  {
    this.mStateSaved = false;
  }
  
  public void performPendingDeferredStart(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart) {
      if (!this.mExecutingActions)
      {
        paramFragment.mDeferStart = false;
        moveToState(paramFragment, this.mCurState, 0, 0, false);
      }
      else
      {
        this.mHavePendingDeferredStart = true;
      }
    }
  }
  
  public void popBackStack()
  {
    enqueueAction(new Runnable()
    {
      public void run()
      {
        FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, null, -1, 0);
      }
    }, false);
  }
  
  public void popBackStack(final int paramInt1, final int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      enqueueAction(new Runnable()
      {
        public void run()
        {
          FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, null, paramInt1, paramInt2);
        }
      }, false);
      return;
    }
    throw new IllegalArgumentException("Bad id: " + paramInt1);
  }
  
  public void popBackStack(final String paramString, final int paramInt)
  {
    enqueueAction(new Runnable()
    {
      public void run()
      {
        FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, paramString, -1, paramInt);
      }
    }, false);
  }
  
  public boolean popBackStackImmediate()
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    executePendingTransactions();
    if (paramInt1 >= 0) {
      return popBackStackState(this.mActivity.mHandler, null, paramInt1, paramInt2);
    }
    throw new IllegalArgumentException("Bad id: " + paramInt1);
  }
  
  public boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, paramString, -1, paramInt);
  }
  
  boolean popBackStackState(Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool;
    if (this.mBackStack != null)
    {
      if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0))
      {
        int j = -1;
        if ((paramString != null) || (paramInt1 >= 0)) {}
        for (j = -1 + this.mBackStack.size();; j--)
        {
          BackStackRecord localBackStackRecord1;
          if (j >= 0)
          {
            localBackStackRecord1 = (BackStackRecord)this.mBackStack.get(j);
            if (((paramString == null) || (!paramString.equals(localBackStackRecord1.getName()))) && ((paramInt1 < 0) || (paramInt1 != localBackStackRecord1.mIndex))) {}
          }
          else
          {
            if (j < 0) {
              break label382;
            }
            if ((paramInt2 & 0x1) != 0) {
              j--;
            }
            for (;;)
            {
              if (j >= 0)
              {
                localBackStackRecord1 = (BackStackRecord)this.mBackStack.get(j);
                if (((paramString != null) && (paramString.equals(localBackStackRecord1.getName()))) || ((paramInt1 >= 0) && (paramInt1 == localBackStackRecord1.mIndex))) {}
              }
              else
              {
                if (j == -1 + this.mBackStack.size()) {
                  break label382;
                }
                ArrayList localArrayList = new ArrayList();
                int n;
                for (int m = -1 + this.mBackStack.size();; n--)
                {
                  if (m <= j)
                  {
                    n = -1 + localArrayList.size();
                    for (int i1 = 0;; i1++)
                    {
                      if (i1 > n)
                      {
                        reportBackStackChanged();
                        break;
                      }
                      if (DEBUG) {
                        Log.v("FragmentManager", "Popping back stack state: " + localArrayList.get(i1));
                      }
                      BackStackRecord localBackStackRecord2 = (BackStackRecord)localArrayList.get(i1);
                      if (i1 != n) {
                        j = 0;
                      } else {
                        j = 1;
                      }
                      localBackStackRecord2.popFromBackStack(j);
                    }
                  }
                  localArrayList.add(this.mBackStack.remove(n));
                }
              }
              j--;
            }
          }
        }
      }
      int k = -1 + this.mBackStack.size();
      if (k >= 0)
      {
        ((BackStackRecord)this.mBackStack.remove(k)).popFromBackStack(true);
        reportBackStackChanged();
        bool = true;
      }
    }
    label382:
    return bool;
  }
  
  public void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public void removeFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.mBackStackNesting);
    }
    int i;
    if (paramFragment.isInBackStack()) {
      i = 0;
    } else {
      i = 1;
    }
    if ((!paramFragment.mDetached) || (i != 0))
    {
      if (this.mAdded != null) {
        this.mAdded.remove(paramFragment);
      }
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mAdded = false;
      paramFragment.mRemoving = true;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      moveToState(paramFragment, i, paramInt1, paramInt2, false);
    }
  }
  
  public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener);
    }
  }
  
  void reportBackStackChanged()
  {
    if (this.mBackStackChangeListeners != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mBackStackChangeListeners.size()) {
        return;
      }
      ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
    }
  }
  
  void restoreAllState(Parcelable paramParcelable, ArrayList<Fragment> paramArrayList)
  {
    FragmentManagerState localFragmentManagerState;
    if (paramParcelable != null)
    {
      localFragmentManagerState = (FragmentManagerState)paramParcelable;
      if (localFragmentManagerState.mActive != null) {
        if (paramArrayList == null) {}
      }
    }
    for (int k = 0;; k++)
    {
      if (k >= paramArrayList.size())
      {
        this.mActive = new ArrayList(localFragmentManagerState.mActive.length);
        if (this.mAvailIndices != null) {
          this.mAvailIndices.clear();
        }
        for (k = 0;; k++)
        {
          if (k >= localFragmentManagerState.mActive.length)
          {
            if (paramArrayList != null) {}
            for (int i = 0;; localObject1++)
            {
              if (i >= paramArrayList.size())
              {
                if (localFragmentManagerState.mAdded == null) {
                  this.mAdded = null;
                } else {
                  this.mAdded = new ArrayList(localFragmentManagerState.mAdded.length);
                }
                for (int j = 0;; localObject2++)
                {
                  if (j >= localFragmentManagerState.mAdded.length)
                  {
                    if (localFragmentManagerState.mBackStack == null) {
                      this.mBackStack = null;
                    } else {
                      this.mBackStack = new ArrayList(localFragmentManagerState.mBackStack.length);
                    }
                    for (i = 0;; i++)
                    {
                      if (i >= localFragmentManagerState.mBackStack.length) {
                        return;
                      }
                      localObject2 = localFragmentManagerState.mBackStack[i].instantiate(this);
                      if (DEBUG)
                      {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + ((BackStackRecord)localObject2).mIndex + "): " + localObject2);
                        ((BackStackRecord)localObject2).dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
                      }
                      this.mBackStack.add(localObject2);
                      if (((BackStackRecord)localObject2).mIndex >= 0) {
                        setBackStackIndex(((BackStackRecord)localObject2).mIndex, (BackStackRecord)localObject2);
                      }
                    }
                  }
                  localObject1 = (Fragment)this.mActive.get(localFragmentManagerState.mAdded[localObject2]);
                  if (localObject1 == null) {
                    throwException(new IllegalStateException("No instantiated fragment for index #" + localFragmentManagerState.mAdded[localObject2]));
                  }
                  ((Fragment)localObject1).mAdded = true;
                  if (DEBUG) {
                    Log.v("FragmentManager", "restoreAllState: added #" + localObject2 + ": " + localObject1);
                  }
                  if (this.mAdded.contains(localObject1)) {
                    break;
                  }
                  this.mAdded.add(localObject1);
                }
                throw new IllegalStateException("Already added!");
              }
              localObject2 = (Fragment)paramArrayList.get(localObject1);
              if (((Fragment)localObject2).mTargetIndex >= 0) {
                if (((Fragment)localObject2).mTargetIndex >= this.mActive.size())
                {
                  Log.w("FragmentManager", "Re-attaching retained fragment " + localObject2 + " target no longer exists: " + ((Fragment)localObject2).mTargetIndex);
                  ((Fragment)localObject2).mTarget = null;
                }
                else
                {
                  ((Fragment)localObject2).mTarget = ((Fragment)this.mActive.get(((Fragment)localObject2).mTargetIndex));
                }
              }
            }
          }
          localObject1 = localFragmentManagerState.mActive[k];
          if (localObject1 == null)
          {
            this.mActive.add(null);
            if (this.mAvailIndices == null) {
              this.mAvailIndices = new ArrayList();
            }
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: avail #" + k);
            }
            this.mAvailIndices.add(Integer.valueOf(k));
          }
          else
          {
            localObject2 = ((FragmentState)localObject1).instantiate(this.mActivity, this.mParent);
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: active #" + k + ": " + localObject2);
            }
            this.mActive.add(localObject2);
            ((FragmentState)localObject1).mInstance = null;
          }
        }
      }
      Object localObject1 = (Fragment)paramArrayList.get(k);
      if (DEBUG) {
        Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localObject1);
      }
      Object localObject2 = localFragmentManagerState.mActive[localObject1.mIndex];
      ((FragmentState)localObject2).mInstance = ((Fragment)localObject1);
      ((Fragment)localObject1).mSavedViewState = null;
      ((Fragment)localObject1).mBackStackNesting = 0;
      ((Fragment)localObject1).mInLayout = false;
      ((Fragment)localObject1).mAdded = false;
      ((Fragment)localObject1).mTarget = null;
      if (((FragmentState)localObject2).mSavedFragmentState != null)
      {
        ((FragmentState)localObject2).mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
        ((Fragment)localObject1).mSavedViewState = ((FragmentState)localObject2).mSavedFragmentState.getSparseParcelableArray("android:view_state");
      }
    }
  }
  
  ArrayList<Fragment> retainNonConfig()
  {
    Object localObject = null;
    if (this.mActive != null) {}
    for (int j = 0;; j++)
    {
      if (j >= this.mActive.size()) {
        return localObject;
      }
      Fragment localFragment = (Fragment)this.mActive.get(j);
      if ((localFragment != null) && (localFragment.mRetainInstance))
      {
        if (localObject == null) {
          localObject = new ArrayList();
        }
        ((ArrayList)localObject).add(localFragment);
        localFragment.mRetaining = true;
        int i;
        if (localFragment.mTarget == null) {
          i = -1;
        } else {
          i = localFragment.mTarget.mIndex;
        }
        localFragment.mTargetIndex = i;
        if (DEBUG) {
          Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
        }
      }
    }
  }
  
  Parcelable saveAllState()
  {
    Object localObject1 = null;
    execPendingActions();
    if (HONEYCOMB) {
      this.mStateSaved = true;
    }
    int j;
    FragmentState[] arrayOfFragmentState;
    int k;
    if ((this.mActive != null) && (this.mActive.size() > 0))
    {
      j = this.mActive.size();
      arrayOfFragmentState = new FragmentState[j];
      k = 0;
    }
    for (int m = 0;; m++)
    {
      if (m >= j)
      {
        FragmentManagerState localFragmentManagerState;
        if (k != 0)
        {
          int[] arrayOfInt = null;
          localObject2 = null;
          int i;
          if (this.mAdded != null)
          {
            i = this.mAdded.size();
            if (i > 0) {
              arrayOfInt = new int[i];
            }
          }
          for (k = 0;; k++)
          {
            if (k >= i)
            {
              if (this.mBackStack != null)
              {
                k = this.mBackStack.size();
                if (k > 0) {
                  localObject2 = new BackStackState[k];
                }
              }
              for (i = 0;; localFragmentManagerState++)
              {
                if (i >= k)
                {
                  localFragmentManagerState = new FragmentManagerState();
                  localFragmentManagerState.mActive = arrayOfFragmentState;
                  localFragmentManagerState.mAdded = arrayOfInt;
                  localFragmentManagerState.mBackStack = ((BackStackState[])localObject2);
                  break;
                }
                localObject2[localFragmentManagerState] = new BackStackState(this, (BackStackRecord)this.mBackStack.get(localFragmentManagerState));
                if (DEBUG) {
                  Log.v("FragmentManager", "saveAllState: adding back stack #" + localFragmentManagerState + ": " + this.mBackStack.get(localFragmentManagerState));
                }
              }
            }
            arrayOfInt[k] = ((Fragment)this.mAdded.get(k)).mIndex;
            if (arrayOfInt[k] < 0) {
              throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(k) + " has cleared index: " + arrayOfInt[k]));
            }
            if (DEBUG) {
              Log.v("FragmentManager", "saveAllState: adding fragment #" + k + ": " + this.mAdded.get(k));
            }
          }
        }
        if (DEBUG) {
          Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return localFragmentManagerState;
      }
      Object localObject2 = (Fragment)this.mActive.get(m);
      if (localObject2 != null)
      {
        if (((Fragment)localObject2).mIndex < 0) {
          throwException(new IllegalStateException("Failure saving state: active " + localObject2 + " has cleared index: " + ((Fragment)localObject2).mIndex));
        }
        k = 1;
        FragmentState localFragmentState = new FragmentState((Fragment)localObject2);
        arrayOfFragmentState[m] = localFragmentState;
        if ((((Fragment)localObject2).mState <= 0) || (localFragmentState.mSavedFragmentState != null))
        {
          localFragmentState.mSavedFragmentState = ((Fragment)localObject2).mSavedFragmentState;
        }
        else
        {
          localFragmentState.mSavedFragmentState = saveFragmentBasicState((Fragment)localObject2);
          if (((Fragment)localObject2).mTarget != null)
          {
            if (((Fragment)localObject2).mTarget.mIndex < 0) {
              throwException(new IllegalStateException("Failure saving state: " + localObject2 + " has target not in fragment manager: " + ((Fragment)localObject2).mTarget));
            }
            if (localFragmentState.mSavedFragmentState == null) {
              localFragmentState.mSavedFragmentState = new Bundle();
            }
            putFragment(localFragmentState.mSavedFragmentState, "android:target_state", ((Fragment)localObject2).mTarget);
            if (((Fragment)localObject2).mTargetRequestCode != 0) {
              localFragmentState.mSavedFragmentState.putInt("android:target_req_state", ((Fragment)localObject2).mTargetRequestCode);
            }
          }
        }
        if (DEBUG) {
          Log.v("FragmentManager", "Saved state of " + localObject2 + ": " + localFragmentState.mSavedFragmentState);
        }
      }
    }
  }
  
  Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    Bundle localBundle = null;
    if (this.mStateBundle == null) {
      this.mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.mStateBundle);
    if (!this.mStateBundle.isEmpty())
    {
      localBundle = this.mStateBundle;
      this.mStateBundle = null;
    }
    if (paramFragment.mView != null) {
      saveFragmentViewState(paramFragment);
    }
    if (paramFragment.mSavedViewState != null)
    {
      if (localBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
    }
    if (!paramFragment.mUserVisibleHint)
    {
      if (localBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
    }
    return localBundle;
  }
  
  public Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Fragment.SavedState localSavedState = null;
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    if (paramFragment.mState > 0)
    {
      Bundle localBundle = saveFragmentBasicState(paramFragment);
      if (localBundle != null) {
        localSavedState = new Fragment.SavedState(localBundle);
      }
    }
    return localSavedState;
  }
  
  void saveFragmentViewState(Fragment paramFragment)
  {
    if (paramFragment.mInnerView != null)
    {
      if (this.mStateArray != null) {
        this.mStateArray.clear();
      } else {
        this.mStateArray = new SparseArray();
      }
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() > 0)
      {
        paramFragment.mSavedViewState = this.mStateArray;
        this.mStateArray = null;
      }
    }
  }
  
  public void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    try
    {
      if (this.mBackStackIndices == null) {
        this.mBackStackIndices = new ArrayList();
      }
      int i = this.mBackStackIndices.size();
      if (paramInt < i)
      {
        if (DEBUG) {
          Log.v("FragmentManager", "Setting back stack index " + paramInt + " to " + paramBackStackRecord);
        }
        this.mBackStackIndices.set(paramInt, paramBackStackRecord);
        return;
      }
      while (i < paramInt)
      {
        this.mBackStackIndices.add(null);
        if (this.mAvailBackStackIndices == null) {
          this.mAvailBackStackIndices = new ArrayList();
        }
        if (DEBUG) {
          Log.v("FragmentManager", "Adding available back stack index " + i);
        }
        this.mAvailBackStackIndices.add(Integer.valueOf(i));
        i++;
      }
      if (DEBUG) {
        Log.v("FragmentManager", "Adding back stack index " + paramInt + " with " + paramBackStackRecord);
      }
      this.mBackStackIndices.add(paramBackStackRecord);
    }
    finally {}
  }
  
  public void showFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(0);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(false);
    }
  }
  
  void startPendingDeferredFragments()
  {
    if (this.mActive != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mActive.size()) {
        return;
      }
      Fragment localFragment = (Fragment)this.mActive.get(i);
      if (localFragment != null) {
        performPendingDeferredStart(localFragment);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent == null) {
      DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    } else {
      DebugUtils.buildShortClassTag(this.mParent, localStringBuilder);
    }
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl
 * JD-Core Version:    0.7.0.1
 */