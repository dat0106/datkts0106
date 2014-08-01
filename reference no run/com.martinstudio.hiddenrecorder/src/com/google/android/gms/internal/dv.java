package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class dv
  implements SafeParcelable
{
  public static final dw CREATOR = new dw();
  public final int errorCode;
  public final List<String> nr;
  public final List<String> ns;
  public final long nv;
  public final int orientation;
  public final String oy;
  public final String qb;
  public final long qc;
  public final boolean qd;
  public final long qe;
  public final List<String> qf;
  public final String qg;
  public final long qh;
  public final String qi;
  public final boolean qj;
  public final String qk;
  public final String ql;
  public final int versionCode;
  
  public dv(int paramInt)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null);
  }
  
  public dv(int paramInt, long paramLong)
  {
    this(7, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null);
  }
  
  dv(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this.versionCode = paramInt1;
    this.oy = paramString1;
    this.qb = paramString2;
    List localList;
    if (paramList1 == null) {
      localList = null;
    } else {
      localList = Collections.unmodifiableList(paramList1);
    }
    this.nr = localList;
    this.errorCode = paramInt2;
    if (paramList2 == null) {
      localList = null;
    } else {
      localList = Collections.unmodifiableList(paramList2);
    }
    this.ns = localList;
    this.qc = paramLong1;
    this.qd = paramBoolean1;
    this.qe = paramLong2;
    if (paramList3 == null) {
      localList = null;
    } else {
      localList = Collections.unmodifiableList(paramList3);
    }
    this.qf = localList;
    this.nv = paramLong3;
    this.orientation = paramInt3;
    this.qg = paramString3;
    this.qh = paramLong4;
    this.qi = paramString4;
    this.qj = paramBoolean2;
    this.qk = paramString5;
    this.ql = paramString6;
  }
  
  public dv(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, String paramString5)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, false, null, paramString5);
  }
  
  public dv(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6)
  {
    this(7, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dw.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dv
 * JD-Core Version:    0.7.0.1
 */