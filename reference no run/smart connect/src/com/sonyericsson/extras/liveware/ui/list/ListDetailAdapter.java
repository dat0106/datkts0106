package com.sonyericsson.extras.liveware.ui.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.ui.CheckableListItem;
import com.sonyericsson.extras.liveware.ui.ReplaceAllArrayAdapter;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class ListDetailAdapter
  extends ReplaceAllArrayAdapter<Object>
{
  private static final int ITEM_TYPE_COUNT = 2;
  public static final int ITEM_TYPE_LIST_DETAIL = 0;
  public static final int ITEM_TYPE_SEPARATOR = 1;
  
  public ListDetailAdapter(Context paramContext)
  {
    super(paramContext, 17367055);
  }
  
  private int getResourceId(int paramInt)
  {
    int i;
    if (paramInt != 1) {
      i = 2130903066;
    } else {
      i = 2130903070;
    }
    return i;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 1;
    Object localObject = getItem(paramInt);
    if (!(localObject instanceof ListSeparator)) {
      if (!(localObject instanceof ListDetail))
      {
        if (Dbg.e()) {
          Dbg.e("Invalid position: " + paramInt);
        }
      }
      else {
        i = 0;
      }
    }
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(getContext()).inflate(getResourceId(i), paramViewGroup, false);
      UIUtils.applyDirectionality(paramView);
    }
    Object localObject;
    if (i != 1)
    {
      if (i == 0)
      {
        localObject = (ListDetail)getItem(paramInt);
        UIUtils.setViewEnabled(paramView, ((ListDetail)localObject).isClickable());
        CheckableListItem localCheckableListItem = (CheckableListItem)paramView;
        localCheckableListItem.setName(((ListDetail)localObject).getName());
        if (((ListDetail)localObject).getIconId() == -1) {
          localCheckableListItem.hideIcon();
        } else {
          localCheckableListItem.setIcon(((ListDetail)localObject).getIconId());
        }
        if (TextUtils.isEmpty(((ListDetail)localObject).getDescription())) {
          localCheckableListItem.hideDescription();
        } else {
          localCheckableListItem.setDescription(((ListDetail)localObject).getDescription());
        }
      }
    }
    else
    {
      localObject = (ListSeparator)getItem(paramInt);
      ((TextView)paramView.findViewById(2131558480)).setText(((ListSeparator)localObject).getName());
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnabled(int paramInt)
  {
    int i = 1;
    if (getItemViewType(paramInt) == i) {
      i = 0;
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.list.ListDetailAdapter
 * JD-Core Version:    0.7.0.1
 */