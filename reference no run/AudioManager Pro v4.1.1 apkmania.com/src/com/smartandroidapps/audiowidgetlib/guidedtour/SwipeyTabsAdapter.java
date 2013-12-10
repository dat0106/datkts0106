package com.smartandroidapps.audiowidgetlib.guidedtour;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.astuetz.viewpager.extensions.SwipeyTabButton;
import com.astuetz.viewpager.extensions.TabsAdapter;
import com.smartandroidapps.audiowidgetlib.R.array;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;

public class SwipeyTabsAdapter
  implements TabsAdapter
{
  private Activity mContext;
  private String[] mTitles;
  
  public SwipeyTabsAdapter(Activity paramActivity)
  {
    this.mContext = paramActivity;
    if (!RunTimeConfig.isFullVersion(paramActivity)) {
      this.mTitles = paramActivity.getResources().getStringArray(R.array.swipe_titles);
    } else {
      this.mTitles = paramActivity.getResources().getStringArray(R.array.swipe_titles_paid);
    }
  }
  
  public View getView(int paramInt)
  {
    SwipeyTabButton localSwipeyTabButton = (SwipeyTabButton)this.mContext.getLayoutInflater().inflate(R.layout.tab_swipey, null);
    if (paramInt < this.mTitles.length) {
      localSwipeyTabButton.setText(this.mTitles[paramInt]);
    }
    return localSwipeyTabButton;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.guidedtour.SwipeyTabsAdapter
 * JD-Core Version:    0.7.0.1
 */