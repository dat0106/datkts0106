package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T>
  extends DataBuffer<T>
{
  private boolean ER = false;
  private ArrayList<Integer> ES;
  
  protected g(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void eV()
  {
    for (;;)
    {
      int k;
      try
      {
        if (!this.ER)
        {
          int i = this.DD.getCount();
          this.ES = new ArrayList();
          if (i > 0)
          {
            this.ES.add(Integer.valueOf(0));
            String str = eU();
            int j = this.DD.ae(0);
            localObject2 = this.DD.c(str, 0, j);
            k = 1;
            if (k < i)
            {
              int m = this.DD.ae(k);
              localObject3 = this.DD.c(str, k, m);
              if (((String)localObject3).equals(localObject2)) {
                break label141;
              }
              this.ES.add(Integer.valueOf(k));
              break label144;
            }
          }
          this.ER = true;
        }
        else
        {
          return;
        }
      }
      finally
      {
        localObject1 = finally;
        throw localObject1;
      }
      label141:
      Object localObject3 = localObject2;
      label144:
      k++;
      Object localObject2 = localObject3;
    }
  }
  
  int ah(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.ES.size())) {
      return ((Integer)this.ES.get(paramInt)).intValue();
    }
    throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
  }
  
  protected int ai(int paramInt)
  {
    int i;
    if ((paramInt >= 0) && (paramInt != this.ES.size()))
    {
      if (paramInt != -1 + this.ES.size()) {
        i = ((Integer)this.ES.get(paramInt + 1)).intValue() - ((Integer)this.ES.get(paramInt)).intValue();
      } else {
        i = this.DD.getCount() - ((Integer)this.ES.get(paramInt)).intValue();
      }
      if (i == 1)
      {
        int j = ah(paramInt);
        int k = this.DD.ae(j);
        String str = eW();
        if ((str != null) && (this.DD.c(str, j, k) == null)) {
          i = 0;
        }
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  protected abstract T c(int paramInt1, int paramInt2);
  
  protected abstract String eU();
  
  protected String eW()
  {
    return null;
  }
  
  public final T get(int paramInt)
  {
    eV();
    return c(ah(paramInt), ai(paramInt));
  }
  
  public int getCount()
  {
    eV();
    return this.ES.size();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.g
 * JD-Core Version:    0.7.0.1
 */