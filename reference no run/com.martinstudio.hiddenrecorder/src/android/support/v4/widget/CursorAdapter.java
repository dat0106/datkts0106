package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter
  extends BaseAdapter
  implements Filterable, CursorFilter.CursorFilterClient
{
  @Deprecated
  public static final int FLAG_AUTO_REQUERY = 1;
  public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
  protected boolean mAutoRequery;
  protected ChangeObserver mChangeObserver;
  protected Context mContext;
  protected Cursor mCursor;
  protected CursorFilter mCursorFilter;
  protected DataSetObserver mDataSetObserver;
  protected boolean mDataValid;
  protected FilterQueryProvider mFilterQueryProvider;
  protected int mRowIDColumn;
  
  @Deprecated
  public CursorAdapter(Context paramContext, Cursor paramCursor)
  {
    init(paramContext, paramCursor, 1);
  }
  
  public CursorAdapter(Context paramContext, Cursor paramCursor, int paramInt)
  {
    init(paramContext, paramCursor, paramInt);
  }
  
  public CursorAdapter(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    init(paramContext, paramCursor, i);
  }
  
  public abstract void bindView(View paramView, Context paramContext, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    Cursor localCursor = swapCursor(paramCursor);
    if (localCursor != null) {
      localCursor.close();
    }
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    String str;
    if (paramCursor != null) {
      str = paramCursor.toString();
    } else {
      str = "";
    }
    return str;
  }
  
  public int getCount()
  {
    int i;
    if ((!this.mDataValid) || (this.mCursor == null)) {
      i = 0;
    } else {
      i = this.mCursor.getCount();
    }
    return i;
  }
  
  public Cursor getCursor()
  {
    return this.mCursor;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (!this.mDataValid)
    {
      localView = null;
    }
    else
    {
      this.mCursor.moveToPosition(paramInt);
      if (paramView != null) {
        localView = paramView;
      } else {
        localView = newDropDownView(this.mContext, this.mCursor, paramViewGroup);
      }
      bindView(localView, this.mContext, this.mCursor);
    }
    return localView;
  }
  
  public Filter getFilter()
  {
    if (this.mCursorFilter == null) {
      this.mCursorFilter = new CursorFilter(this);
    }
    return this.mCursorFilter;
  }
  
  public FilterQueryProvider getFilterQueryProvider()
  {
    return this.mFilterQueryProvider;
  }
  
  public Object getItem(int paramInt)
  {
    Cursor localCursor;
    if ((!this.mDataValid) || (this.mCursor == null))
    {
      localCursor = null;
    }
    else
    {
      this.mCursor.moveToPosition(paramInt);
      localCursor = this.mCursor;
    }
    return localCursor;
  }
  
  public long getItemId(int paramInt)
  {
    long l = 0L;
    if ((this.mDataValid) && (this.mCursor != null) && (this.mCursor.moveToPosition(paramInt))) {
      l = this.mCursor.getLong(this.mRowIDColumn);
    }
    return l;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mDataValid)
    {
      if (this.mCursor.moveToPosition(paramInt))
      {
        View localView;
        if (paramView != null) {
          localView = paramView;
        } else {
          localView = newView(this.mContext, this.mCursor, paramViewGroup);
        }
        bindView(localView, this.mContext, this.mCursor);
        return localView;
      }
      throw new IllegalStateException("couldn't move cursor to position " + paramInt);
    }
    throw new IllegalStateException("this should only be called when the cursor is valid");
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  void init(Context paramContext, Cursor paramCursor, int paramInt)
  {
    int i = 1;
    if ((paramInt & 0x1) != i)
    {
      this.mAutoRequery = false;
    }
    else
    {
      paramInt |= 0x2;
      this.mAutoRequery = i;
    }
    if (paramCursor == null) {
      i = 0;
    }
    this.mCursor = paramCursor;
    this.mDataValid = i;
    this.mContext = paramContext;
    int j;
    if (i == 0) {
      j = -1;
    } else {
      j = paramCursor.getColumnIndexOrThrow("_id");
    }
    this.mRowIDColumn = j;
    if ((paramInt & 0x2) != 2)
    {
      this.mChangeObserver = null;
      this.mDataSetObserver = null;
    }
    else
    {
      this.mChangeObserver = new ChangeObserver();
      this.mDataSetObserver = new MyDataSetObserver(null);
    }
    if (i != 0)
    {
      if (this.mChangeObserver != null) {
        paramCursor.registerContentObserver(this.mChangeObserver);
      }
      if (this.mDataSetObserver != null) {
        paramCursor.registerDataSetObserver(this.mDataSetObserver);
      }
    }
  }
  
  @Deprecated
  protected void init(Context paramContext, Cursor paramCursor, boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    init(paramContext, paramCursor, i);
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  protected void onContentChanged()
  {
    if ((this.mAutoRequery) && (this.mCursor != null) && (!this.mCursor.isClosed())) {
      this.mDataValid = this.mCursor.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    Cursor localCursor;
    if (this.mFilterQueryProvider == null) {
      localCursor = this.mCursor;
    } else {
      localCursor = this.mFilterQueryProvider.runQuery(paramCharSequence);
    }
    return localCursor;
  }
  
  public void setFilterQueryProvider(FilterQueryProvider paramFilterQueryProvider)
  {
    this.mFilterQueryProvider = paramFilterQueryProvider;
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    Cursor localCursor;
    if (paramCursor != this.mCursor)
    {
      localCursor = this.mCursor;
      if (localCursor != null)
      {
        if (this.mChangeObserver != null) {
          localCursor.unregisterContentObserver(this.mChangeObserver);
        }
        if (this.mDataSetObserver != null) {
          localCursor.unregisterDataSetObserver(this.mDataSetObserver);
        }
      }
      this.mCursor = paramCursor;
      if (paramCursor == null)
      {
        this.mRowIDColumn = -1;
        this.mDataValid = false;
        notifyDataSetInvalidated();
      }
      else
      {
        if (this.mChangeObserver != null) {
          paramCursor.registerContentObserver(this.mChangeObserver);
        }
        if (this.mDataSetObserver != null) {
          paramCursor.registerDataSetObserver(this.mDataSetObserver);
        }
        this.mRowIDColumn = paramCursor.getColumnIndexOrThrow("_id");
        this.mDataValid = true;
        notifyDataSetChanged();
      }
    }
    else
    {
      localCursor = null;
    }
    return localCursor;
  }
  
  private class MyDataSetObserver
    extends DataSetObserver
  {
    private MyDataSetObserver() {}
    
    public void onChanged()
    {
      CursorAdapter.this.mDataValid = true;
      CursorAdapter.this.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      CursorAdapter.this.mDataValid = false;
      CursorAdapter.this.notifyDataSetInvalidated();
    }
  }
  
  private class ChangeObserver
    extends ContentObserver
  {
    public ChangeObserver()
    {
      super();
    }
    
    public boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public void onChange(boolean paramBoolean)
    {
      CursorAdapter.this.onContentChanged();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.CursorAdapter
 * JD-Core Version:    0.7.0.1
 */