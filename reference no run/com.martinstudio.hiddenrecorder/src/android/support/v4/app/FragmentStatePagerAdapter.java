package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter
  extends PagerAdapter
{
  private static final boolean DEBUG = false;
  private static final String TAG = "FragmentStatePagerAdapter";
  private FragmentTransaction mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private final FragmentManager mFragmentManager;
  private ArrayList<Fragment> mFragments = new ArrayList();
  private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
  
  public FragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    for (;;)
    {
      if (this.mSavedState.size() > paramInt)
      {
        this.mSavedState.set(paramInt, this.mFragmentManager.saveFragmentInstanceState(localFragment));
        this.mFragments.set(paramInt, null);
        this.mCurTransaction.remove(localFragment);
        return;
      }
      this.mSavedState.add(null);
    }
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.mCurTransaction != null)
    {
      this.mCurTransaction.commitAllowingStateLoss();
      this.mCurTransaction = null;
      this.mFragmentManager.executePendingTransactions();
    }
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    Fragment localFragment;
    if (this.mFragments.size() > paramInt)
    {
      localObject = (Fragment)this.mFragments.get(paramInt);
      if (localObject != null) {}
    }
    else
    {
      if (this.mCurTransaction == null) {
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }
      localFragment = getItem(paramInt);
      if (this.mSavedState.size() > paramInt)
      {
        localObject = (Fragment.SavedState)this.mSavedState.get(paramInt);
        if (localObject != null) {
          localFragment.setInitialSavedState((Fragment.SavedState)localObject);
        }
      }
    }
    for (;;)
    {
      if (this.mFragments.size() > paramInt)
      {
        localFragment.setMenuVisibility(false);
        localFragment.setUserVisibleHint(false);
        this.mFragments.set(paramInt, localFragment);
        this.mCurTransaction.add(paramViewGroup.getId(), localFragment);
        localObject = localFragment;
        return localObject;
      }
      this.mFragments.add(null);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    boolean bool;
    if (((Fragment)paramObject).getView() != paramView) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    Bundle localBundle;
    Object localObject;
    if (paramParcelable != null)
    {
      localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      localObject = localBundle.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      if (localObject == null) {}
    }
    String str;
    for (int i = 0;; str++)
    {
      if (i >= localObject.length)
      {
        localObject = localBundle.keySet().iterator();
        int j;
        Fragment localFragment;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            return;
          }
          str = (String)((Iterator)localObject).next();
          if (str.startsWith("f"))
          {
            j = Integer.parseInt(str.substring(1));
            localFragment = this.mFragmentManager.getFragment(localBundle, str);
            if (localFragment != null) {
              break;
            }
            Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
          }
        }
        for (;;)
        {
          if (this.mFragments.size() > j)
          {
            localFragment.setMenuVisibility(false);
            this.mFragments.set(j, localFragment);
            break;
          }
          this.mFragments.add(null);
        }
      }
      this.mSavedState.add((Fragment.SavedState)localObject[str]);
    }
  }
  
  public Parcelable saveState()
  {
    Bundle localBundle = null;
    Object localObject;
    if (this.mSavedState.size() > 0)
    {
      localBundle = new Bundle();
      localObject = new Fragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject);
      localBundle.putParcelableArray("states", (Parcelable[])localObject);
    }
    for (int i = 0;; i++)
    {
      if (i >= this.mFragments.size()) {
        return localBundle;
      }
      Fragment localFragment = (Fragment)this.mFragments.get(i);
      if (localFragment != null)
      {
        if (localBundle == null) {
          localBundle = new Bundle();
        }
        localObject = "f" + i;
        this.mFragmentManager.putFragment(localBundle, (String)localObject, localFragment);
      }
    }
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (localFragment != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        this.mCurrentPrimaryItem.setMenuVisibility(false);
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
      }
      if (localFragment != null)
      {
        localFragment.setMenuVisibility(true);
        localFragment.setUserVisibleHint(true);
      }
      this.mCurrentPrimaryItem = localFragment;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentStatePagerAdapter
 * JD-Core Version:    0.7.0.1
 */