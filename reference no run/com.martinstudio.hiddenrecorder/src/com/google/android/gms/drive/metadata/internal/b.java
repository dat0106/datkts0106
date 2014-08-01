package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class b
  extends a<Boolean>
{
  public b(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void a(Bundle paramBundle, Boolean paramBoolean)
  {
    paramBundle.putBoolean(getName(), paramBoolean.booleanValue());
  }
  
  protected Boolean d(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return Boolean.valueOf(paramDataHolder.d(getName(), paramInt1, paramInt2));
  }
  
  protected Boolean g(Bundle paramBundle)
  {
    return Boolean.valueOf(paramBundle.getBoolean(getName()));
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.b
 * JD-Core Version:    0.7.0.1
 */