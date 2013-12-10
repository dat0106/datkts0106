package com.smartandroidapps.audiowidgetlib.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockFragment;
import java.util.ArrayList;
import java.util.List;

public class PagerAdapter
  extends FragmentPagerAdapter
{
  private List<SherlockFragment> fragments;
  public ArrayList<String> tags;
  
  public PagerAdapter(FragmentManager paramFragmentManager, List<SherlockFragment> paramList)
  {
    super(paramFragmentManager);
    this.tags = new ArrayList(paramList.size());
    this.fragments = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramInt >= getCount())
    {
      FragmentTransaction localFragmentTransaction = ((Fragment)paramObject).getFragmentManager().beginTransaction();
      localFragmentTransaction.remove((Fragment)paramObject);
      localFragmentTransaction.commit();
    }
  }
  
  public int getCount()
  {
    return this.fragments.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.fragments.get(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Fragment localFragment = (Fragment)super.instantiateItem(paramViewGroup, paramInt);
    this.tags.add(localFragment.getTag());
    return localFragment;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.adapters.PagerAdapter
 * JD-Core Version:    0.7.0.1
 */