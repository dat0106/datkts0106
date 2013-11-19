package com.sonyericsson.extras.liveware.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sonyericsson.extras.liveware.utils.ApplicationData;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.List;

public class ApplicationDataAdapter
  extends ArrayAdapter<ApplicationData>
{
  private final Context mCtx;
  
  public ApplicationDataAdapter(Context paramContext)
  {
    super(paramContext, 2130903068);
    this.mCtx = paramContext;
    setNotifyOnChange(false);
  }
  
  private void renderView(View paramView, ApplicationData paramApplicationData, String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    CheckableListItem localCheckableListItem = (CheckableListItem)paramView.findViewById(2131558474);
    localCheckableListItem.showCheckable(true);
    localCheckableListItem.setName(paramString);
    localCheckableListItem.setIcon(paramDrawable);
    paramView.setTag(paramApplicationData);
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
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
    ApplicationData localApplicationData = (ApplicationData)getItem(paramInt);
    renderView(localView, localApplicationData, localApplicationData.getName(), localApplicationData.getIcon(), false);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public void refresh()
  {
    notifyDataSetChanged();
    setNotifyOnChange(false);
  }
  
  public void setData(List<ApplicationData> paramList)
  {
    clear();
    if (paramList != null) {
      addAll(paramList);
    }
    refresh();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ApplicationDataAdapter
 * JD-Core Version:    0.7.0.1
 */