package com.sonyericsson.extras.liveware.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.List;

public class RadioListAdapter
  extends BaseAdapter
{
  private Context mContext;
  private RadioListDialog.IBucket mCurrentSetting;
  private List<RadioListDialog.IBucket> mItems;
  
  public RadioListAdapter(Context paramContext, List<RadioListDialog.IBucket> paramList, RadioListDialog.IBucket paramIBucket)
  {
    this.mContext = paramContext;
    this.mItems = paramList;
    this.mCurrentSetting = paramIBucket;
  }
  
  public int getCount()
  {
    return this.mItems.size();
  }
  
  public RadioListDialog.IBucket getItem(int paramInt)
  {
    return (RadioListDialog.IBucket)this.mItems.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    UIUtils.applyDirectionality(paramViewGroup);
    View localView = LayoutInflater.from(this.mContext).inflate(17367055, paramViewGroup, false);
    RadioListDialog.IBucket localIBucket = (RadioListDialog.IBucket)this.mItems.get(paramInt);
    String str = localIBucket.getKey();
    CheckedTextView localCheckedTextView = (CheckedTextView)localView.findViewById(16908308);
    localCheckedTextView.setText(localIBucket.getValue());
    if ((this.mCurrentSetting != null) && (!TextUtils.isEmpty(this.mCurrentSetting.getKey()))) {
      localCheckedTextView.setChecked(str.equalsIgnoreCase(this.mCurrentSetting.getKey()));
    }
    return localView;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.RadioListAdapter
 * JD-Core Version:    0.7.0.1
 */