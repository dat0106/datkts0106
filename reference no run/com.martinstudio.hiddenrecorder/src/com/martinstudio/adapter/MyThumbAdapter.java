package com.martinstudio.adapter;

import android.app.Activity;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.martinstudio.utils.VideoInfo;
import java.util.ArrayList;
import java.util.Date;

public class MyThumbAdapter
  extends ArrayAdapter<VideoInfo>
{
  Activity mContext;
  private SparseBooleanArray mSelectedItemsIds;
  ArrayList<VideoInfo> myData;
  
  public MyThumbAdapter(Activity paramActivity, int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    super(paramActivity, paramInt, paramArrayList);
    this.mContext = paramActivity;
    this.myData = paramArrayList;
    this.mSelectedItemsIds = new SparseBooleanArray();
  }
  
  public int getCount()
  {
    this.myData.size();
    return super.getCount();
  }
  
  public int getSelectedCount()
  {
    return this.mSelectedItemsIds.size();
  }
  
  public SparseBooleanArray getSelectedIds()
  {
    return this.mSelectedItemsIds;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (localView == null)
    {
      localView = this.mContext.getLayoutInflater().inflate(2130903041, null);
      localViewHolder = new ViewHolder();
      localViewHolder.txtTitle = ((TextView)localView.findViewById(2131296285));
      localViewHolder.txt_date = ((TextView)localView.findViewById(2131296286));
      localViewHolder.img_Thumbnail = ((ImageView)localView.findViewById(2131296284));
      localView.setTag(localViewHolder);
    }
    ViewHolder localViewHolder = (ViewHolder)localView.getTag();
    localViewHolder.txtTitle.setText(((VideoInfo)this.myData.get(paramInt)).getName());
    Date localDate = new Date(((VideoInfo)this.myData.get(paramInt)).getDate());
    localViewHolder.txt_date.setText(localDate.toLocaleString());
    int i;
    if (!this.mSelectedItemsIds.get(paramInt)) {
      i = 0;
    } else {
      i = -1724598812;
    }
    localView.setBackgroundColor(i);
    localViewHolder.img_Thumbnail.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localViewHolder.img_Thumbnail.setImageBitmap(((VideoInfo)this.myData.get(paramInt)).getThumbnail());
    return localView;
  }
  
  public void removeSelection()
  {
    this.mSelectedItemsIds = new SparseBooleanArray();
    notifyDataSetChanged();
  }
  
  public void selectView(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.mSelectedItemsIds.delete(paramInt);
    } else {
      this.mSelectedItemsIds.put(paramInt, paramBoolean);
    }
    notifyDataSetChanged();
  }
  
  public void toggleSelection(int paramInt)
  {
    boolean bool;
    if (!this.mSelectedItemsIds.get(paramInt)) {
      bool = true;
    } else {
      bool = false;
    }
    selectView(paramInt, bool);
  }
  
  static class ViewHolder
  {
    public ImageView img_Thumbnail;
    public TextView txtTitle;
    public TextView txt_date;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.martinstudio.adapter.MyThumbAdapter
 * JD-Core Version:    0.7.0.1
 */