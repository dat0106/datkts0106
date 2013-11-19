package com.sonyericsson.extras.liveware.ui;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApplicationAdapter
  implements ListAdapter
{
  private List<ApplicationData> mApps;
  private ApplicationSelectionActivity mCtx;
  private Device mCurrentDevice;
  private Set<DataSetObserver> mObservers = new HashSet();
  private ApplicationData mSelectedApp = null;
  
  public ApplicationAdapter(ApplicationSelectionActivity paramApplicationSelectionActivity, Device paramDevice)
  {
    this.mCtx = paramApplicationSelectionActivity;
    if (paramDevice != null)
    {
      this.mCurrentDevice = paramDevice;
      return;
    }
    throw new IllegalArgumentException("accyData cannot be null");
  }
  
  private void renderView(View paramView, ApplicationData paramApplicationData, String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    Object localObject = (CheckableListItem)paramView.findViewById(2131558474);
    ((CheckableListItem)localObject).setName(paramString);
    ((CheckableListItem)localObject).setIcon(paramDrawable);
    localObject = (RadioButton)paramView.findViewById(2131558475);
    if (localObject != null) {
      ((RadioButton)localObject).setChecked(paramBoolean);
    }
    paramView.setTag(paramApplicationData);
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public int getCount()
  {
    int i;
    if (this.mApps == null) {
      i = 0;
    } else {
      i = this.mApps.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return this.mApps.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public ApplicationData getSelectedApp()
  {
    return this.mSelectedApp;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    boolean bool = false;
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mCtx).inflate(2130903068, paramViewGroup, false);
      UIUtils.applyDirectionality(localView);
    }
    else
    {
      localView = paramView;
    }
    if (this.mApps != null)
    {
      localObject = (ApplicationData)this.mApps.get(paramInt);
      if (localObject != null)
      {
        bool = ((ApplicationData)localObject).isDefaultLiveKey(this.mCtx, this.mCurrentDevice);
        renderView(localView, (ApplicationData)localObject, ((ApplicationData)localObject).getName(), ((ApplicationData)localObject).getIcon(), bool);
      }
      else
      {
        ApplicationData localApplicationData = PackageUtils.getLiveKeyDefault(this.mCtx, this.mCurrentDevice);
        String str = this.mCtx.getString(2131099766);
        Drawable localDrawable = this.mCtx.getResources().getDrawable(2130837601);
        if (localApplicationData == null) {
          bool = true;
        }
        renderView(localView, null, str, localDrawable, bool);
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ApplicationAdapter.this.mCtx.onItemClicker(paramAnonymousView);
        }
      });
      localView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener()
      {
        public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          int i = 1;
          ApplicationAdapter.this.mSelectedApp = this.val$ad;
          if (this.val$ad != null)
          {
            paramAnonymousContextMenu.add(0, i, 0, 2131099739);
            MenuItem localMenuItem = paramAnonymousContextMenu.add(i, 2, 0, 2131099774);
            if ((0x1 & this.val$ad.getApplicationInfo().flags) != 0) {
              i = 0;
            }
            localMenuItem.setEnabled(i);
          }
        }
      });
      localObject = localView;
    }
    return localObject;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if ((this.mApps == null) || (!this.mApps.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  public void loadDataSet()
  {
    this.mApps = PackageUtils.getLiveKeyApps(this.mCtx, this.mCurrentDevice);
    this.mApps.add(0, null);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mObservers.add(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mObservers.remove(paramDataSetObserver);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ApplicationAdapter
 * JD-Core Version:    0.7.0.1
 */