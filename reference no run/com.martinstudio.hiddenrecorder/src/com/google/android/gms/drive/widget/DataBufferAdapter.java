package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataBufferAdapter<T>
  extends BaseAdapter
{
  private final int LO;
  private int LP;
  private final int LQ;
  private final List<DataBuffer<T>> LR;
  private final LayoutInflater LS;
  private boolean LT = true;
  private final Context mContext;
  
  public DataBufferAdapter(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 0, new ArrayList());
  }
  
  public DataBufferAdapter(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, paramInt2, new ArrayList());
  }
  
  public DataBufferAdapter(Context paramContext, int paramInt1, int paramInt2, List<DataBuffer<T>> paramList)
  {
    this.mContext = paramContext;
    this.LP = paramInt1;
    this.LO = paramInt1;
    this.LQ = paramInt2;
    this.LR = paramList;
    this.LS = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public DataBufferAdapter(Context paramContext, int paramInt1, int paramInt2, DataBuffer<T>... paramVarArgs)
  {
    this(paramContext, paramInt1, paramInt2, Arrays.asList(paramVarArgs));
  }
  
  public DataBufferAdapter(Context paramContext, int paramInt, List<DataBuffer<T>> paramList)
  {
    this(paramContext, paramInt, 0, paramList);
  }
  
  public DataBufferAdapter(Context paramContext, int paramInt, DataBuffer<T>... paramVarArgs)
  {
    this(paramContext, paramInt, 0, Arrays.asList(paramVarArgs));
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    View localView;
    if (paramView == null) {
      localView = this.LS.inflate(paramInt2, paramViewGroup, false);
    }
    for (;;)
    {
      try
      {
        Object localObject1;
        Object localObject2;
        if (this.LQ == 0)
        {
          localObject1 = (TextView)localView;
          localObject2 = localObject1;
          localObject1 = getItem(paramInt1);
          if ((localObject1 instanceof CharSequence))
          {
            localObject2.setText((CharSequence)localObject1);
            return localView;
            localView = paramView;
          }
        }
        else
        {
          localObject1 = (TextView)localView.findViewById(this.LQ);
          localObject2 = localObject1;
          continue;
        }
        localObject2.setText(localObject1.toString());
      }
      catch (ClassCastException localClassCastException)
      {
        Log.e("DataBufferAdapter", "You must supply a resource ID for a TextView");
        throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", localClassCastException);
      }
    }
  }
  
  public void append(DataBuffer<T> paramDataBuffer)
  {
    this.LR.add(paramDataBuffer);
    if (this.LT) {
      notifyDataSetChanged();
    }
  }
  
  public void clear()
  {
    Iterator localIterator = this.LR.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.LR.clear();
        if (this.LT) {
          notifyDataSetChanged();
        }
        return;
      }
      ((DataBuffer)localIterator.next()).close();
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getCount()
  {
    Iterator localIterator = this.LR.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      i += ((DataBuffer)localIterator.next()).getCount();
    }
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, this.LP);
  }
  
  public T getItem(int paramInt)
    throws CursorIndexOutOfBoundsException
  {
    Iterator localIterator = this.LR.iterator();
    int i = paramInt;
    while (localIterator.hasNext())
    {
      Object localObject = (DataBuffer)localIterator.next();
      int j = ((DataBuffer)localObject).getCount();
      if (j <= i) {
        i -= j;
      } else {
        try
        {
          localObject = ((DataBuffer)localObject).get(i);
          return localObject;
        }
        catch (CursorIndexOutOfBoundsException localCursorIndexOutOfBoundsException)
        {
          throw new CursorIndexOutOfBoundsException(paramInt, getCount());
        }
      }
    }
    throw new CursorIndexOutOfBoundsException(paramInt, getCount());
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, this.LO);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.LT = true;
  }
  
  public void setDropDownViewResource(int paramInt)
  {
    this.LP = paramInt;
  }
  
  public void setNotifyOnChange(boolean paramBoolean)
  {
    this.LT = paramBoolean;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.widget.DataBufferAdapter
 * JD-Core Version:    0.7.0.1
 */