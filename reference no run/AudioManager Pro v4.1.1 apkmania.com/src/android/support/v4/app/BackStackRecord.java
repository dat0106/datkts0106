package android.support.v4.app;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, Runnable
{
  static final int OP_ADD = 1;
  static final int OP_ATTACH = 7;
  static final int OP_DETACH = 6;
  static final int OP_HIDE = 4;
  static final int OP_NULL = 0;
  static final int OP_REMOVE = 3;
  static final int OP_REPLACE = 2;
  static final int OP_SHOW = 5;
  static final String TAG = "BackStackEntry";
  boolean mAddToBackStack;
  boolean mAllowAddToBackStack = true;
  int mBreadCrumbShortTitleRes;
  CharSequence mBreadCrumbShortTitleText;
  int mBreadCrumbTitleRes;
  CharSequence mBreadCrumbTitleText;
  boolean mCommitted;
  int mEnterAnim;
  int mExitAnim;
  Op mHead;
  int mIndex;
  final FragmentManagerImpl mManager;
  String mName;
  int mNumOp;
  int mPopEnterAnim;
  int mPopExitAnim;
  Op mTail;
  int mTransition;
  int mTransitionStyle;
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    this.mManager = paramFragmentManagerImpl;
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    paramFragment.mFragmentManager = this.mManager;
    if (paramString != null)
    {
      if ((paramFragment.mTag == null) || (paramString.equals(paramFragment.mTag))) {
        paramFragment.mTag = paramString;
      }
    }
    else
    {
      if (paramInt1 != 0)
      {
        if ((paramFragment.mFragmentId == 0) || (paramFragment.mFragmentId == paramInt1))
        {
          paramFragment.mFragmentId = paramInt1;
          paramFragment.mContainerId = paramInt1;
        }
      }
      else
      {
        Op localOp = new Op();
        localOp.cmd = paramInt2;
        localOp.fragment = paramFragment;
        addOp(localOp);
        return;
      }
      throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.mFragmentId + " now " + paramInt1);
    }
    throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment)
  {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString)
  {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString)
  {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  void addOp(Op paramOp)
  {
    if (this.mHead != null)
    {
      paramOp.prev = this.mTail;
      this.mTail.next = paramOp;
      this.mTail = paramOp;
    }
    else
    {
      this.mTail = paramOp;
      this.mHead = paramOp;
    }
    paramOp.enterAnim = this.mEnterAnim;
    paramOp.exitAnim = this.mExitAnim;
    paramOp.popEnterAnim = this.mPopEnterAnim;
    paramOp.popExitAnim = this.mPopExitAnim;
    this.mNumOp = (1 + this.mNumOp);
  }
  
  public FragmentTransaction addToBackStack(String paramString)
  {
    if (this.mAllowAddToBackStack)
    {
      this.mAddToBackStack = true;
      this.mName = paramString;
      return this;
    }
    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
  }
  
  public FragmentTransaction attach(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 7;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  void bumpBackStackNesting(int paramInt)
  {
    Op localOp;
    if (this.mAddToBackStack)
    {
      if (FragmentManagerImpl.DEBUG) {
        Log.v("BackStackEntry", "Bump nesting in " + this + " by " + paramInt);
      }
      localOp = this.mHead;
      if (localOp != null) {}
    }
    else
    {
      return;
    }
    if (localOp.fragment != null)
    {
      Fragment localFragment1 = localOp.fragment;
      localFragment1.mBackStackNesting = (paramInt + localFragment1.mBackStackNesting);
      if (FragmentManagerImpl.DEBUG) {
        Log.v("BackStackEntry", "Bump nesting of " + localOp.fragment + " to " + localOp.fragment.mBackStackNesting);
      }
    }
    if (localOp.removed != null) {}
    for (int i = -1 + localOp.removed.size();; i--)
    {
      if (i < 0)
      {
        localOp = localOp.next;
        break;
      }
      Fragment localFragment2 = (Fragment)localOp.removed.get(i);
      localFragment2.mBackStackNesting = (paramInt + localFragment2.mBackStackNesting);
      if (FragmentManagerImpl.DEBUG) {
        Log.v("BackStackEntry", "Bump nesting of " + localFragment2 + " to " + localFragment2.mBackStackNesting);
      }
    }
  }
  
  public int commit()
  {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss()
  {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean)
  {
    if (!this.mCommitted)
    {
      if (FragmentManagerImpl.DEBUG) {
        Log.v("BackStackEntry", "Commit: " + this);
      }
      this.mCommitted = true;
      if (!this.mAddToBackStack) {
        this.mIndex = -1;
      } else {
        this.mIndex = this.mManager.allocBackStackIndex(this);
      }
      this.mManager.enqueueAction(this, paramBoolean);
      return this.mIndex;
    }
    throw new IllegalStateException("commit already called");
  }
  
  public FragmentTransaction detach(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 6;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack()
  {
    if (!this.mAddToBackStack)
    {
      this.mAllowAddToBackStack = false;
      return this;
    }
    throw new IllegalStateException("This transaction is already being added to the back stack");
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mName=");
    paramPrintWriter.print(this.mName);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(this.mIndex);
    paramPrintWriter.print(" mCommitted=");
    paramPrintWriter.println(this.mCommitted);
    if (this.mTransition != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTransition=#");
      paramPrintWriter.print(Integer.toHexString(this.mTransition));
      paramPrintWriter.print(" mTransitionStyle=#");
      paramPrintWriter.println(Integer.toHexString(this.mTransitionStyle));
    }
    if ((this.mEnterAnim != 0) || (this.mExitAnim != 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mEnterAnim=#");
      paramPrintWriter.print(Integer.toHexString(this.mEnterAnim));
      paramPrintWriter.print(" mExitAnim=#");
      paramPrintWriter.println(Integer.toHexString(this.mExitAnim));
    }
    if ((this.mPopEnterAnim != 0) || (this.mPopExitAnim != 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mPopEnterAnim=#");
      paramPrintWriter.print(Integer.toHexString(this.mPopEnterAnim));
      paramPrintWriter.print(" mPopExitAnim=#");
      paramPrintWriter.println(Integer.toHexString(this.mPopExitAnim));
    }
    if ((this.mBreadCrumbTitleRes != 0) || (this.mBreadCrumbTitleText != null))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mBreadCrumbTitleRes=#");
      paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
      paramPrintWriter.print(" mBreadCrumbTitleText=");
      paramPrintWriter.println(this.mBreadCrumbTitleText);
    }
    if ((this.mBreadCrumbShortTitleRes != 0) || (this.mBreadCrumbShortTitleText != null))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
      paramPrintWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
      paramPrintWriter.print(" mBreadCrumbShortTitleText=");
      paramPrintWriter.println(this.mBreadCrumbShortTitleText);
    }
    String str;
    Op localOp;
    if (this.mHead != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      str = paramString + "    ";
      localOp = this.mHead;
      if (localOp != null) {}
    }
    else
    {
      return;
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  Op #");
    paramPrintWriter.print(0);
    paramPrintWriter.println(":");
    paramPrintWriter.print(str);
    paramPrintWriter.print("cmd=");
    paramPrintWriter.print(localOp.cmd);
    paramPrintWriter.print(" fragment=");
    paramPrintWriter.println(localOp.fragment);
    if ((localOp.enterAnim != 0) || (localOp.exitAnim != 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("enterAnim=#");
      paramPrintWriter.print(Integer.toHexString(localOp.enterAnim));
      paramPrintWriter.print(" exitAnim=#");
      paramPrintWriter.println(Integer.toHexString(localOp.exitAnim));
    }
    if ((localOp.popEnterAnim != 0) || (localOp.popExitAnim != 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("popEnterAnim=#");
      paramPrintWriter.print(Integer.toHexString(localOp.popEnterAnim));
      paramPrintWriter.print(" popExitAnim=#");
      paramPrintWriter.println(Integer.toHexString(localOp.popExitAnim));
    }
    if ((localOp.removed != null) && (localOp.removed.size() > 0)) {}
    for (int i = 0;; i++)
    {
      if (i >= localOp.removed.size())
      {
        localOp = localOp.next;
        break;
      }
      paramPrintWriter.print(str);
      if (localOp.removed.size() != 1)
      {
        paramPrintWriter.println("Removed:");
        paramPrintWriter.print(str);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(0);
        paramPrintWriter.print(": ");
      }
      else
      {
        paramPrintWriter.print("Removed: ");
      }
      paramPrintWriter.println(localOp.removed.get(i));
    }
  }
  
  public CharSequence getBreadCrumbShortTitle()
  {
    CharSequence localCharSequence;
    if (this.mBreadCrumbShortTitleRes == 0) {
      localCharSequence = this.mBreadCrumbShortTitleText;
    } else {
      localCharSequence = this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes);
    }
    return localCharSequence;
  }
  
  public int getBreadCrumbShortTitleRes()
  {
    return this.mBreadCrumbShortTitleRes;
  }
  
  public CharSequence getBreadCrumbTitle()
  {
    CharSequence localCharSequence;
    if (this.mBreadCrumbTitleRes == 0) {
      localCharSequence = this.mBreadCrumbTitleText;
    } else {
      localCharSequence = this.mManager.mActivity.getText(this.mBreadCrumbTitleRes);
    }
    return localCharSequence;
  }
  
  public int getBreadCrumbTitleRes()
  {
    return this.mBreadCrumbTitleRes;
  }
  
  public int getId()
  {
    return this.mIndex;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getTransition()
  {
    return this.mTransition;
  }
  
  public int getTransitionStyle()
  {
    return this.mTransitionStyle;
  }
  
  public FragmentTransaction hide(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 4;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public boolean isAddToBackStackAllowed()
  {
    return this.mAllowAddToBackStack;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.mNumOp != 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void popFromBackStack(boolean paramBoolean)
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("BackStackEntry", "popFromBackStack: " + this);
    }
    bumpBackStackNesting(-1);
    for (Op localOp = this.mTail;; localOp = localOp.prev)
    {
      if (localOp == null)
      {
        if (paramBoolean) {
          this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle, true);
        }
        if (this.mIndex >= 0)
        {
          this.mManager.freeBackStackIndex(this.mIndex);
          this.mIndex = -1;
        }
        return;
      }
      Fragment localFragment;
      int i;
      switch (localOp.cmd)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
      case 1: 
        localFragment = localOp.fragment;
        localFragment.mNextAnim = localOp.popExitAnim;
        this.mManager.removeFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
        break;
      case 2: 
        localFragment = localOp.fragment;
        if (localFragment != null)
        {
          localFragment.mNextAnim = localOp.popExitAnim;
          this.mManager.removeFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
        }
        if (localOp.removed != null) {
          i = 0;
        }
        break;
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        while (i < localOp.removed.size())
        {
          localFragment = (Fragment)localOp.removed.get(i);
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.addFragment(localFragment, false);
          i++;
          continue;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.addFragment(localFragment, false);
          break;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.showFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
          break;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popExitAnim;
          this.mManager.hideFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
          break;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.attachFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
          break;
          localFragment = localOp.fragment;
          localFragment.mNextAnim = localOp.popEnterAnim;
          this.mManager.detachFragment(localFragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
        }
      }
    }
  }
  
  public FragmentTransaction remove(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 3;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment)
  {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt != 0)
    {
      doAddOp(paramInt, paramFragment, paramString, 2);
      return this;
    }
    throw new IllegalArgumentException("Must use non-zero containerViewId");
  }
  
  public void run()
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("BackStackEntry", "Run: " + this);
    }
    if ((!this.mAddToBackStack) || (this.mIndex >= 0))
    {
      bumpBackStackNesting(1);
      for (Op localOp = this.mHead;; localOp = localOp.next)
      {
        if (localOp == null)
        {
          this.mManager.moveToState(this.mManager.mCurState, this.mTransition, this.mTransitionStyle, true);
          if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
          }
          return;
        }
        Fragment localFragment1;
        switch (localOp.cmd)
        {
        default: 
          throw new IllegalArgumentException("Unknown cmd: " + localOp.cmd);
        case 1: 
          localFragment1 = localOp.fragment;
          localFragment1.mNextAnim = localOp.enterAnim;
          this.mManager.addFragment(localFragment1, false);
          break;
        case 2: 
          Fragment localFragment2 = localOp.fragment;
          if (this.mManager.mAdded != null) {}
          for (int i = 0;; i++)
          {
            if (i >= this.mManager.mAdded.size())
            {
              if (localFragment2 == null) {
                break;
              }
              localFragment2.mNextAnim = localOp.enterAnim;
              this.mManager.addFragment(localFragment2, false);
              break;
            }
            localFragment1 = (Fragment)this.mManager.mAdded.get(i);
            if (FragmentManagerImpl.DEBUG) {
              Log.v("BackStackEntry", "OP_REPLACE: adding=" + localFragment2 + " old=" + localFragment1);
            }
            if ((localFragment2 == null) || (localFragment1.mContainerId == localFragment2.mContainerId)) {
              if (localFragment1 != localFragment2)
              {
                if (localOp.removed == null) {
                  localOp.removed = new ArrayList();
                }
                localOp.removed.add(localFragment1);
                localFragment1.mNextAnim = localOp.exitAnim;
                if (this.mAddToBackStack)
                {
                  localFragment1.mBackStackNesting = (1 + localFragment1.mBackStackNesting);
                  if (FragmentManagerImpl.DEBUG) {
                    Log.v("BackStackEntry", "Bump nesting of " + localFragment1 + " to " + localFragment1.mBackStackNesting);
                  }
                }
                this.mManager.removeFragment(localFragment1, this.mTransition, this.mTransitionStyle);
              }
              else
              {
                localFragment2 = null;
                localOp.fragment = null;
              }
            }
          }
        case 3: 
          localFragment1 = localOp.fragment;
          localFragment1.mNextAnim = localOp.exitAnim;
          this.mManager.removeFragment(localFragment1, this.mTransition, this.mTransitionStyle);
          break;
        case 4: 
          localFragment1 = localOp.fragment;
          localFragment1.mNextAnim = localOp.exitAnim;
          this.mManager.hideFragment(localFragment1, this.mTransition, this.mTransitionStyle);
          break;
        case 5: 
          localFragment1 = localOp.fragment;
          localFragment1.mNextAnim = localOp.enterAnim;
          this.mManager.showFragment(localFragment1, this.mTransition, this.mTransitionStyle);
          break;
        case 6: 
          localFragment1 = localOp.fragment;
          localFragment1.mNextAnim = localOp.exitAnim;
          this.mManager.detachFragment(localFragment1, this.mTransition, this.mTransitionStyle);
          break;
        case 7: 
          localFragment1 = localOp.fragment;
          localFragment1.mNextAnim = localOp.enterAnim;
          this.mManager.attachFragment(localFragment1, this.mTransition, this.mTransitionStyle);
        }
      }
    }
    throw new IllegalStateException("addToBackStack() called after commit()");
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt)
  {
    this.mBreadCrumbShortTitleRes = paramInt;
    this.mBreadCrumbShortTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbShortTitleRes = 0;
    this.mBreadCrumbShortTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt)
  {
    this.mBreadCrumbTitleRes = paramInt;
    this.mBreadCrumbTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence)
  {
    this.mBreadCrumbTitleRes = 0;
    this.mBreadCrumbTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2)
  {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mEnterAnim = paramInt1;
    this.mExitAnim = paramInt2;
    this.mPopEnterAnim = paramInt3;
    this.mPopExitAnim = paramInt4;
    return this;
  }
  
  public FragmentTransaction setTransition(int paramInt)
  {
    this.mTransition = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt)
  {
    this.mTransitionStyle = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment)
  {
    Op localOp = new Op();
    localOp.cmd = 5;
    localOp.fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  static final class Op
  {
    int cmd;
    int enterAnim;
    int exitAnim;
    Fragment fragment;
    Op next;
    int popEnterAnim;
    int popExitAnim;
    Op prev;
    ArrayList<Fragment> removed;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackRecord
 * JD-Core Version:    0.7.0.1
 */