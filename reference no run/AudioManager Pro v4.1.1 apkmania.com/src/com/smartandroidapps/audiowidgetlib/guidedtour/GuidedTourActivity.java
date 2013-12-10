package com.smartandroidapps.audiowidgetlib.guidedtour;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import com.astuetz.viewpager.extensions.SwipeyTabsView;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;

public class GuidedTourActivity
  extends Activity
{
  private ViewPager mPager;
  private PagerAdapter mPagerAdapter;
  private SwipeyTabsView mSwipeyTabs;
  private SwipeyTabsAdapter mSwipeyTabsAdapter;
  
  private void initViewPager(int paramInt)
  {
    this.mPager = ((ViewPager)findViewById(R.id.pager));
    this.mPagerAdapter = new GuidedTourPagerAdapter(this, paramInt);
    this.mPager.setAdapter(this.mPagerAdapter);
    this.mPager.setCurrentItem(0);
    this.mPager.setPageMargin(1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(R.layout.guided_tour_layout);
    if (!RunTimeConfig.isFullVersion(this)) {
      initViewPager(9);
    } else {
      initViewPager(8);
    }
    this.mSwipeyTabs = ((SwipeyTabsView)findViewById(R.id.swipey_tabs));
    this.mSwipeyTabsAdapter = new SwipeyTabsAdapter(this);
    this.mSwipeyTabs.setAdapter(this.mSwipeyTabsAdapter);
    this.mSwipeyTabs.setViewPager(this.mPager);
    super.onCreate(paramBundle);
  }
  
  protected void onStop()
  {
    setResult(0);
    super.onStop();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.guidedtour.GuidedTourActivity
 * JD-Core Version:    0.7.0.1
 */