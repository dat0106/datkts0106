package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class mc<M extends mb<M>, T>
{
  protected final Class<T> amV;
  protected final boolean amW;
  protected final int tag;
  protected final int type;
  
  private mc(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.amV = paramClass;
    this.tag = paramInt2;
    this.amW = paramBoolean;
  }
  
  public static <M extends mb<M>, T extends mf> mc<M, T> a(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    return new mc(paramInt1, paramClass, paramInt2, false);
  }
  
  protected void a(mh parammh, List<Object> paramList)
  {
    paramList.add(u(lz.p(parammh.amZ)));
  }
  
  protected boolean eM(int paramInt)
  {
    boolean bool;
    if (paramInt != this.tag) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  final T i(List<mh> paramList)
  {
    int i = 0;
    if (paramList != null)
    {
      if (!this.amW)
      {
        i = -1 + paramList.size();
        for (localObject2 = null;; localObject2 = localObject1)
        {
          if ((localObject2 != null) || (i < 0))
          {
            if (localObject2 != null)
            {
              localObject2 = this.amV.cast(u(lz.p(((mh)localObject2).amZ)));
              break;
            }
            localObject2 = null;
            break;
          }
          localObject1 = (mh)paramList.get(i);
          if ((!eM(((mh)localObject1).tag)) || (((mh)localObject1).amZ.length == 0)) {
            localObject1 = localObject2;
          }
          i--;
        }
      }
      Object localObject1 = new ArrayList();
      for (int j = 0;; j++)
      {
        if (j >= paramList.size())
        {
          j = ((List)localObject1).size();
          if (j != 0)
          {
            localObject2 = this.amV.cast(Array.newInstance(this.amV.getComponentType(), j));
            while (i < j)
            {
              Array.set(localObject2, i, ((List)localObject1).get(i));
              i++;
            }
          }
          localObject2 = null;
          break;
        }
        localObject2 = (mh)paramList.get(j);
        if ((eM(((mh)localObject2).tag)) && (((mh)localObject2).amZ.length != 0)) {
          a((mh)localObject2, (List)localObject1);
        }
      }
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  protected Object u(lz paramlz)
  {
    Class localClass;
    if (this.amW) {
      localClass = this.amV.getComponentType();
    }
    try
    {
      switch (this.type)
      {
      default: 
        throw new IllegalArgumentException("Unknown type " + this.type);
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        throw new IllegalArgumentException("Error creating instance of class " + localClass, localInstantiationException);
        localClass = this.amV;
      }
      mf localmf = (mf)localClass.newInstance();
      paramlz.a(localmf, mi.eO(this.tag));
      return localmf;
      localmf = (mf)localClass.newInstance();
      paramlz.a(localmf);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalArgumentException("Error creating instance of class " + localClass, localIllegalAccessException);
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Error reading extension field", localIOException);
    }
    return localIllegalAccessException;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mc
 * JD-Core Version:    0.7.0.1
 */