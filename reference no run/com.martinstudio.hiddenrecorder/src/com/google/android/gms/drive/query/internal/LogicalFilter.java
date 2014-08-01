package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
  implements SafeParcelable, Filter
{
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new h();
  private List<Filter> KE;
  final Operator KI;
  final List<FilterHolder> KV;
  final int xJ;
  
  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    this.xJ = paramInt;
    this.KI = paramOperator;
    this.KV = paramList;
  }
  
  public LogicalFilter(Operator paramOperator, Filter paramFilter, Filter... paramVarArgs)
  {
    this.xJ = 1;
    this.KI = paramOperator;
    this.KV = new ArrayList(1 + paramVarArgs.length);
    this.KV.add(new FilterHolder(paramFilter));
    this.KE = new ArrayList(1 + paramVarArgs.length);
    this.KE.add(paramFilter);
    int i = paramVarArgs.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      Filter localFilter = paramVarArgs[j];
      this.KV.add(new FilterHolder(localFilter));
      this.KE.add(localFilter);
    }
  }
  
  public LogicalFilter(Operator paramOperator, Iterable<Filter> paramIterable)
  {
    this.xJ = 1;
    this.KI = paramOperator;
    this.KE = new ArrayList();
    this.KV = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Filter localFilter = (Filter)localIterator.next();
      this.KE.add(localFilter);
      this.KV.add(new FilterHolder(localFilter));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.LogicalFilter
 * JD-Core Version:    0.7.0.1
 */