package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cz<K, V>
  implements k<K, V>
{
  private final Map<K, V> ahU = new HashMap();
  private final int ahV;
  private final l.a<K, V> ahW;
  private int ahX;
  
  cz(int paramInt, l.a<K, V> parama)
  {
    this.ahV = paramInt;
    this.ahW = parama;
  }
  
  /**
   * @deprecated
   */
  public void e(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      try
      {
        throw new NullPointerException("key == null || value == null");
      }
      finally {}
    }
    this.ahX += this.ahW.sizeOf(paramK, paramV);
    if (this.ahX > this.ahV)
    {
      Iterator localIterator = this.ahU.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.ahX -= this.ahW.sizeOf(localEntry.getKey(), localEntry.getValue());
        localIterator.remove();
      } while (this.ahX > this.ahV);
    }
    this.ahU.put(paramK, paramV);
  }
  
  /**
   * @deprecated
   */
  public V get(K paramK)
  {
    try
    {
      Object localObject1 = this.ahU.get(paramK);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cz
 * JD-Core Version:    0.7.0.1
 */