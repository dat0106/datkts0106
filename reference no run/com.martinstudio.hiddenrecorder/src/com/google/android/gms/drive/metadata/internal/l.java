package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

public class l
  extends a<String>
{
  public l(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void a(Bundle paramBundle, String paramString)
  {
    paramBundle.putString(getName(), paramString);
  }
  
  protected String h(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return paramDataHolder.c(getName(), paramInt1, paramInt2);
  }
  
  protected String m(Bundle paramBundle)
  {
    return paramBundle.getString(getName());
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.l
 * JD-Core Version:    0.7.0.1
 */