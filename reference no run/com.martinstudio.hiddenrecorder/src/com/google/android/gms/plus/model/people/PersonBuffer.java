package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.le;

public final class PersonBuffer
  extends DataBuffer<Person>
{
  private final e<kt> adW;
  
  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.eP() == null) || (!paramDataHolder.eP().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false))) {
      this.adW = null;
    } else {
      this.adW = new e(paramDataHolder, kt.CREATOR);
    }
  }
  
  public Person get(int paramInt)
  {
    Object localObject;
    if (this.adW == null) {
      localObject = new le(this.DD, paramInt);
    } else {
      localObject = (Person)this.adW.ad(paramInt);
    }
    return localObject;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.model.people.PersonBuffer
 * JD-Core Version:    0.7.0.1
 */