package com.google.android.gms.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;
import java.util.List;

public class is
  extends j<AppVisibleCustomProperties>
{
  public is(int paramInt)
  {
    super("customFileProperties", localList, Arrays.asList(arrayOfString), paramInt);
  }
  
  protected AppVisibleCustomProperties j(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return (AppVisibleCustomProperties)paramDataHolder.eP().getSparseParcelableArray("customPropertiesExtra").get(paramInt1, AppVisibleCustomProperties.JK);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.is
 * JD-Core Version:    0.7.0.1
 */