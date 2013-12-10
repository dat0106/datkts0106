package com.actionbarsherlock.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.View;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.string;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.actionbarsherlock.view.SubMenu;

public class ShareActionProvider
  extends ActionProvider
{
  private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
  public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
  private final Context mContext;
  private int mMaxShownActivityCount = 4;
  private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
  private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(null);
  private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
  private String mShareHistoryFileName = "share_history.xml";
  
  public ShareActionProvider(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  private void setActivityChooserPolicyIfNeeded()
  {
    if (this.mOnShareTargetSelectedListener != null)
    {
      if (this.mOnChooseActivityListener == null) {
        this.mOnChooseActivityListener = new ShareAcitivityChooserModelPolicy(null);
      }
      ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }
  }
  
  public boolean hasSubMenu()
  {
    return true;
  }
  
  public View onCreateActionView()
  {
    Object localObject = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
    ActivityChooserView localActivityChooserView = new ActivityChooserView(this.mContext);
    localActivityChooserView.setActivityChooserModel((ActivityChooserModel)localObject);
    localObject = new TypedValue();
    this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, (TypedValue)localObject, true);
    localActivityChooserView.setExpandActivityOverflowButtonDrawable(this.mContext.getResources().getDrawable(((TypedValue)localObject).resourceId));
    localActivityChooserView.setProvider(this);
    localActivityChooserView.setDefaultActionButtonContentDescription(R.string.abs__shareactionprovider_share_with_application);
    localActivityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abs__shareactionprovider_share_with);
    return localActivityChooserView;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu)
  {
    paramSubMenu.clear();
    ActivityChooserModel localActivityChooserModel = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
    PackageManager localPackageManager = this.mContext.getPackageManager();
    int i = localActivityChooserModel.getActivityCount();
    int j = Math.min(i, this.mMaxShownActivityCount);
    SubMenu localSubMenu;
    for (int k = 0;; localSubMenu++)
    {
      if (k >= j)
      {
        if (j < i) {
          localSubMenu = paramSubMenu.addSubMenu(0, j, j, this.mContext.getString(R.string.abs__activity_chooser_view_see_all));
        }
        for (j = 0;; j++)
        {
          if (j >= i) {
            return;
          }
          localResolveInfo = localActivityChooserModel.getActivity(j);
          localSubMenu.add(0, j, j, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }
      }
      ResolveInfo localResolveInfo = localActivityChooserModel.getActivity(localSubMenu);
      paramSubMenu.add(0, localSubMenu, localSubMenu, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
    }
  }
  
  public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener paramOnShareTargetSelectedListener)
  {
    this.mOnShareTargetSelectedListener = paramOnShareTargetSelectedListener;
    setActivityChooserPolicyIfNeeded();
  }
  
  public void setShareHistoryFileName(String paramString)
  {
    this.mShareHistoryFileName = paramString;
    setActivityChooserPolicyIfNeeded();
  }
  
  public void setShareIntent(Intent paramIntent)
  {
    ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(paramIntent);
  }
  
  private class ShareAcitivityChooserModelPolicy
    implements ActivityChooserModel.OnChooseActivityListener
  {
    private ShareAcitivityChooserModelPolicy() {}
    
    public boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent)
    {
      boolean bool;
      if (ShareActionProvider.this.mOnShareTargetSelectedListener == null) {
        bool = false;
      } else {
        bool = ShareActionProvider.this.mOnShareTargetSelectedListener.onShareTargetSelected(ShareActionProvider.this, paramIntent);
      }
      return bool;
    }
  }
  
  private class ShareMenuItemOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private ShareMenuItemOnMenuItemClickListener() {}
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      Intent localIntent = ActivityChooserModel.get(ShareActionProvider.this.mContext, ShareActionProvider.this.mShareHistoryFileName).chooseActivity(paramMenuItem.getItemId());
      if (localIntent != null) {
        ShareActionProvider.this.mContext.startActivity(localIntent);
      }
      return true;
    }
  }
  
  public static abstract interface OnShareTargetSelectedListener
  {
    public abstract boolean onShareTargetSelected(ShareActionProvider paramShareActionProvider, Intent paramIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.widget.ShareActionProvider
 * JD-Core Version:    0.7.0.1
 */