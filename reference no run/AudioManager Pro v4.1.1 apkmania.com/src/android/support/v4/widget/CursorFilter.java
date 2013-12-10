package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class CursorFilter
  extends Filter
{
  CursorFilterClient mClient;
  
  CursorFilter(CursorFilterClient paramCursorFilterClient)
  {
    this.mClient = paramCursorFilterClient;
  }
  
  public CharSequence convertResultToString(Object paramObject)
  {
    return this.mClient.convertToString((Cursor)paramObject);
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Cursor localCursor = this.mClient.runQueryOnBackgroundThread(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (localCursor == null)
    {
      localFilterResults.count = 0;
      localFilterResults.values = null;
    }
    else
    {
      localFilterResults.count = localCursor.getCount();
      localFilterResults.values = localCursor;
    }
    return localFilterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    Cursor localCursor = this.mClient.getCursor();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != localCursor)) {
      this.mClient.changeCursor((Cursor)paramFilterResults.values);
    }
  }
  
  static abstract interface CursorFilterClient
  {
    public abstract void changeCursor(Cursor paramCursor);
    
    public abstract CharSequence convertToString(Cursor paramCursor);
    
    public abstract Cursor getCursor();
    
    public abstract Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.CursorFilter
 * JD-Core Version:    0.7.0.1
 */