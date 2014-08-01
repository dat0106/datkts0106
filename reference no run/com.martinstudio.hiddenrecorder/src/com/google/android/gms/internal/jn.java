package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class jn
  implements SafeParcelable
{
  public static final jo CREATOR = new jo();
  final List<jt> VZ;
  private final String Wa;
  private final boolean Wb;
  final List<jx> Wc;
  private final String Wd;
  final List<String> We;
  private final Set<jt> Wf;
  private final Set<jx> Wg;
  private final Set<String> Wh;
  final int xJ;
  
  jn(int paramInt, List<jt> paramList, String paramString1, boolean paramBoolean, List<jx> paramList1, String paramString2, List<String> paramList2)
  {
    this.xJ = paramInt;
    List localList;
    if (paramList != null) {
      localList = Collections.unmodifiableList(paramList);
    } else {
      localList = Collections.emptyList();
    }
    this.VZ = localList;
    if (paramString1 == null) {
      paramString1 = "";
    }
    this.Wa = paramString1;
    this.Wb = paramBoolean;
    if (paramList1 != null) {
      localList = Collections.unmodifiableList(paramList1);
    } else {
      localList = Collections.emptyList();
    }
    this.Wc = localList;
    if (paramString2 == null) {
      paramString2 = "";
    }
    this.Wd = paramString2;
    if (paramList2 != null) {
      localList = Collections.unmodifiableList(paramList2);
    } else {
      localList = Collections.emptyList();
    }
    this.We = localList;
    this.Wf = c(this.VZ);
    this.Wg = c(this.Wc);
    this.Wh = c(this.We);
  }
  
  private static <E> Set<E> c(List<E> paramList)
  {
    Set localSet;
    if (!paramList.isEmpty()) {
      localSet = Collections.unmodifiableSet(new HashSet(paramList));
    } else {
      localSet = Collections.emptySet();
    }
    return localSet;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof jn))
      {
        jn localjn = (jn)paramObject;
        if ((!this.Wf.equals(localjn.Wf)) || (this.Wb != localjn.Wb) || (!this.Wd.equals(localjn.Wd)) || (!this.Wg.equals(localjn.Wg)) || (!this.Wh.equals(localjn.Wh))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.Wf;
    arrayOfObject[1] = Boolean.valueOf(this.Wb);
    arrayOfObject[2] = this.Wg;
    arrayOfObject[3] = this.Wd;
    arrayOfObject[4] = this.Wh;
    return hl.hashCode(arrayOfObject);
  }
  
  @Deprecated
  public String jb()
  {
    return this.Wa;
  }
  
  public boolean jc()
  {
    return this.Wb;
  }
  
  public String jd()
  {
    return this.Wd;
  }
  
  public String toString()
  {
    return hl.e(this).a("types", this.Wf).a("placeIds", this.Wh).a("requireOpenNow", Boolean.valueOf(this.Wb)).a("userAccountName", this.Wd).a("requestedUserDataTypes", this.Wg).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jo.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jn
 * JD-Core Version:    0.7.0.1
 */