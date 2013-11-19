package com.sonyericsson.extras.liveware.ui;

import android.content.Context;
import android.widget.ArrayAdapter;
import java.util.List;

public abstract class ReplaceAllArrayAdapter<T>
  extends ArrayAdapter<T>
{
  public ReplaceAllArrayAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    setNotifyOnChange(false);
  }
  
  public void refresh()
  {
    notifyDataSetChanged();
    setNotifyOnChange(false);
  }
  
  public void setData(List<T> paramList)
  {
    clear();
    if (paramList != null) {
      addAll(paramList);
    }
    refresh();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ReplaceAllArrayAdapter
 * JD-Core Version:    0.7.0.1
 */