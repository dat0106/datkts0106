package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;

public abstract interface MetadataField<T>
{
  public abstract T a(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public abstract void a(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2);
  
  public abstract void a(T paramT, Bundle paramBundle);
  
  public abstract T e(Bundle paramBundle);
  
  public abstract String getName();
  
  public abstract Collection<String> gx();
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.MetadataField
 * JD-Core Version:    0.7.0.1
 */