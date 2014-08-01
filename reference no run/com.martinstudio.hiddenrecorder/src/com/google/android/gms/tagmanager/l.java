package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class l<K, V>
{
  final a<K, V> aeo = new a()
  {
    public int sizeOf(K paramAnonymousK, V paramAnonymousV)
    {
      return 1;
    }
  };
  
  public k<K, V> a(int paramInt, a<K, V> parama)
  {
    if (paramInt > 0)
    {
      Object localObject;
      if (le() >= 12) {
        localObject = new bb(paramInt, parama);
      } else {
        localObject = new cz(paramInt, parama);
      }
      return localObject;
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  int le()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static abstract interface a<K, V>
  {
    public abstract int sizeOf(K paramK, V paramV);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.l
 * JD-Core Version:    0.7.0.1
 */