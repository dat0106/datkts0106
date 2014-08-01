package com.google.android.gms.tagmanager;

import android.util.LruCache;

class bb<K, V>
  implements k<K, V>
{
  private LruCache<K, V> afZ;
  
  bb(int paramInt, final l.a<K, V> parama)
  {
    this.afZ = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return parama.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public void e(K paramK, V paramV)
  {
    this.afZ.put(paramK, paramV);
  }
  
  public V get(K paramK)
  {
    return this.afZ.get(paramK);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bb
 * JD-Core Version:    0.7.0.1
 */