package com.google.android.gms.common.data;

import java.util.ArrayList;
import java.util.Iterator;

public final class FreezableUtils
{
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int j = paramArrayList.size();
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return localArrayList;
      }
      localArrayList.add(((Freezable)paramArrayList.get(i)).freeze());
    }
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] paramArrayOfE)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfE.length);
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfE.length) {
        return localArrayList;
      }
      localArrayList.add(paramArrayOfE[i].freeze());
    }
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      localArrayList.add(((Freezable)localIterator.next()).freeze());
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.FreezableUtils
 * JD-Core Version:    0.7.0.1
 */