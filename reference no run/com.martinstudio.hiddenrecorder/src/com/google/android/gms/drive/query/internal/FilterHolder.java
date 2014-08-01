package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new d();
  final ComparisonFilter<?> KM;
  final FieldOnlyFilter KN;
  final LogicalFilter KO;
  final NotFilter KP;
  final InFilter<?> KQ;
  final MatchAllFilter KR;
  final HasFilter KS;
  private final Filter KT;
  final int xJ;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter)
  {
    this.xJ = paramInt;
    this.KM = paramComparisonFilter;
    this.KN = paramFieldOnlyFilter;
    this.KO = paramLogicalFilter;
    this.KP = paramNotFilter;
    this.KQ = paramInFilter;
    this.KR = paramMatchAllFilter;
    this.KS = paramHasFilter;
    if (this.KM == null)
    {
      if (this.KN == null)
      {
        if (this.KO == null)
        {
          if (this.KP == null)
          {
            if (this.KQ == null)
            {
              if (this.KR == null)
              {
                if (this.KS == null) {
                  throw new IllegalArgumentException("At least one filter must be set.");
                }
                this.KT = this.KS;
              }
              else
              {
                this.KT = this.KR;
              }
            }
            else {
              this.KT = this.KQ;
            }
          }
          else {
            this.KT = this.KP;
          }
        }
        else {
          this.KT = this.KO;
        }
      }
      else {
        this.KT = this.KN;
      }
    }
    else {
      this.KT = this.KM;
    }
  }
  
  public FilterHolder(Filter paramFilter)
  {
    this.xJ = 2;
    Object localObject;
    if (!(paramFilter instanceof ComparisonFilter)) {
      localObject = null;
    } else {
      localObject = (ComparisonFilter)paramFilter;
    }
    this.KM = ((ComparisonFilter)localObject);
    if (!(paramFilter instanceof FieldOnlyFilter)) {
      localObject = null;
    } else {
      localObject = (FieldOnlyFilter)paramFilter;
    }
    this.KN = ((FieldOnlyFilter)localObject);
    if (!(paramFilter instanceof LogicalFilter)) {
      localObject = null;
    } else {
      localObject = (LogicalFilter)paramFilter;
    }
    this.KO = ((LogicalFilter)localObject);
    if (!(paramFilter instanceof NotFilter)) {
      localObject = null;
    } else {
      localObject = (NotFilter)paramFilter;
    }
    this.KP = ((NotFilter)localObject);
    if (!(paramFilter instanceof InFilter)) {
      localObject = null;
    } else {
      localObject = (InFilter)paramFilter;
    }
    this.KQ = ((InFilter)localObject);
    if (!(paramFilter instanceof MatchAllFilter)) {
      localObject = null;
    } else {
      localObject = (MatchAllFilter)paramFilter;
    }
    this.KR = ((MatchAllFilter)localObject);
    if (!(paramFilter instanceof HasFilter)) {
      localObject = null;
    } else {
      localObject = (HasFilter)paramFilter;
    }
    this.KS = ((HasFilter)localObject);
    if ((this.KM != null) || (this.KN != null) || (this.KO != null) || (this.KP != null) || (this.KQ != null) || (this.KR != null) || (this.KS != null))
    {
      this.KT = paramFilter;
      return;
    }
    throw new IllegalArgumentException("Invalid filter type or null filter.");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FilterHolder
 * JD-Core Version:    0.7.0.1
 */