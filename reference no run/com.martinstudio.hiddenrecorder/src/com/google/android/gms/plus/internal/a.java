package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.if;
import com.google.android.gms.internal.kt;

public abstract class a
  extends b.a
{
  public void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
    throws RemoteException
  {}
  
  public void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
    throws RemoteException
  {}
  
  public final void a(int paramInt, Bundle paramBundle, if paramif) {}
  
  public void a(int paramInt, kt paramkt) {}
  
  public void a(DataHolder paramDataHolder, String paramString) {}
  
  public void a(DataHolder paramDataHolder, String paramString1, String paramString2) {}
  
  public void am(Status paramStatus) {}
  
  public void bw(String paramString)
    throws RemoteException
  {}
  
  public void bx(String paramString) {}
  
  public void h(int paramInt, Bundle paramBundle) {}
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.a
 * JD-Core Version:    0.7.0.1
 */