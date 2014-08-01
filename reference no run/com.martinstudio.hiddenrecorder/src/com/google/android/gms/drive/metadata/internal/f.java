package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class f
  extends a<Integer>
{
  public f(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void a(Bundle paramBundle, Integer paramInteger)
  {
    paramBundle.putInt(getName(), paramInteger.intValue());
  }
  
  protected Integer f(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramDataHolder.b(getName(), paramInt1, paramInt2));
  }
  
  protected Integer i(Bundle paramBundle)
  {
    return Integer.valueOf(paramBundle.getInt(getName()));
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.f
 * JD-Core Version:    0.7.0.1
 */