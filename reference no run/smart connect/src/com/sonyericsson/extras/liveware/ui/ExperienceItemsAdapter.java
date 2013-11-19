package com.sonyericsson.extras.liveware.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Time;
import com.sonyericsson.extras.liveware.ui.list.ListSeparator;
import com.sonyericsson.extras.liveware.utils.AsfTimeUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class ExperienceItemsAdapter
  extends ReplaceAllArrayAdapter<Object>
{
  public static final int ITEM_TYPE_ACTION_SET = 2;
  public static final int ITEM_TYPE_ADD_ACTION = 4;
  public static final int ITEM_TYPE_ADD_TRIGGER = 5;
  private static final int ITEM_TYPE_COUNT = 6;
  public static final int ITEM_TYPE_INITATOR_DEVICE = 0;
  public static final int ITEM_TYPE_INITATOR_TIME = 1;
  public static final int ITEM_TYPE_SEPARATOR = 3;
  
  public ExperienceItemsAdapter(Context paramContext)
  {
    super(paramContext, 17367055);
  }
  
  private int getResourceId(int paramInt)
  {
    int i;
    if (paramInt != 3) {
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
    int i = 3;
    Object localObject = getItem(paramInt);
    if (!(localObject instanceof ListSeparator)) {
      if (!(localObject instanceof Device))
      {
        if (!(localObject instanceof Time))
        {
          if (!(localObject instanceof ActionSet))
          {
            if (!(localObject instanceof AddAction))
            {
              if (!(localObject instanceof AddTrigger))
              {
                if (Dbg.e()) {
                  Dbg.e("Invalid position: " + paramInt);
                }
              }
              else {
                i = 5;
              }
            }
            else {
              i = 4;
            }
          }
          else {
            i = 2;
          }
        }
        else {
          i = 1;
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
    boolean bool = paramViewGroup.isEnabled();
    UIUtils.setViewEnabled(paramView, bool);
    Object localObject1;
    if (i != 3)
    {
      localObject1 = (CheckableListItem)paramView;
      Object localObject2;
      Time localTime;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                ((CheckableListItem)localObject1).setIcon(2130837669);
                ((CheckableListItem)localObject1).setName(((AddTrigger)getItem(paramInt)).getStringId());
              }
            }
            else
            {
              ((CheckableListItem)localObject1).setIcon(2130837669);
              ((CheckableListItem)localObject1).setName(((AddAction)getItem(paramInt)).getStringId());
            }
          }
          else
          {
            localObject2 = (ActionSet)getItem(paramInt);
            Action localAction = ((ActionSet)localObject2).getAction();
            ((CheckableListItem)localObject1).setName(localAction.getName());
            ((CheckableListItem)localObject1).setDescription(((ActionSet)localObject2).getSettingsLabel());
            ((CheckableListItem)localObject1).setIcon(UIUtils.getDrawable(getContext(), localAction.getIconUri(), bool));
          }
        }
        else
        {
          localTime = (Time)getItem(paramInt);
          ((CheckableListItem)localObject1).setName(AsfTimeUtils.getFormattedTimeSpan(localTime, getContext()));
          if (localTime.getDaysRaw() != 254) {
            ((CheckableListItem)localObject1).setDescription(AsfTimeUtils.getFormattedWeekDays(localTime.getDaysRaw(), 20));
          } else {
            ((CheckableListItem)localObject1).setDescription(2131099935);
          }
          ((CheckableListItem)localObject1).setIcon(2130837664);
        }
      }
      else
      {
        localObject2 = (Device)getItem(paramInt);
        ((CheckableListItem)localObject1).setName(((Device)localObject2).getProductName());
        ((CheckableListItem)localObject1).setIcon(UIUtils.getDrawable(getContext(), ((Device)localObject2).getIconName(), localTime));
      }
    }
    else
    {
      localObject1 = (ListSeparator)getItem(paramInt);
      ((TextView)paramView.findViewById(2131558480)).setText(((ListSeparator)localObject1).getName());
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
  
  public boolean isEnabled(int paramInt)
  {
    boolean bool;
    if (getItemViewType(paramInt) == 3) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected static class AddAction
  {
    private int mActionType;
    private int mStringId;
    
    protected AddAction(int paramInt1, int paramInt2)
    {
      this.mStringId = paramInt1;
      this.mActionType = paramInt2;
    }
    
    protected int getActionType()
    {
      return this.mActionType;
    }
    
    protected int getStringId()
    {
      return this.mStringId;
    }
  }
  
  protected static class AddTrigger
  {
    private int mStringId;
    
    protected AddTrigger(int paramInt)
    {
      this.mStringId = paramInt;
    }
    
    protected int getStringId()
    {
      return this.mStringId;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ExperienceItemsAdapter
 * JD-Core Version:    0.7.0.1
 */