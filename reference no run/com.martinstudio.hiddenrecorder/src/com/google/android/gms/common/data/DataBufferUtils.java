package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils
{
  public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> paramDataBuffer)
  {
    ArrayList localArrayList = new ArrayList(paramDataBuffer.getCount());
    try
    {
      Iterator localIterator = paramDataBuffer.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((Freezable)localIterator.next()).freeze());
      }
      return localArrayList1;
    }
    finally
    {
      paramDataBuffer.close();
    }
  }
  
  public static boolean hasNextPage(DataBuffer<?> paramDataBuffer)
  {
    Bundle localBundle = paramDataBuffer.eP();
    boolean bool;
    if ((localBundle == null) || (localBundle.getString("next_page_token") == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean hasPrevPage(DataBuffer<?> paramDataBuffer)
  {
    Bundle localBundle = paramDataBuffer.eP();
    boolean bool;
    if ((localBundle == null) || (localBundle.getString("prev_page_token") == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferUtils
 * JD-Core Version:    0.7.0.1
 */