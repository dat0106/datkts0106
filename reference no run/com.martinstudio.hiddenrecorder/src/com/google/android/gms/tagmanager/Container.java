package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.c.j;
import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  private final String aeq;
  private final DataLayer aer;
  private cs aes;
  private Map<String, FunctionCallMacroCallback> aet = new HashMap();
  private Map<String, FunctionCallTagCallback> aeu = new HashMap();
  private volatile long aev;
  private volatile String aew = "";
  private final Context mContext;
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, c.j paramj)
  {
    this.mContext = paramContext;
    this.aer = paramDataLayer;
    this.aeq = paramString;
    this.aev = paramLong;
    a(paramj.fK);
    if (paramj.fJ != null) {
      a(paramj.fJ);
    }
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, cq.c paramc)
  {
    this.mContext = paramContext;
    this.aer = paramDataLayer;
    this.aeq = paramString;
    this.aev = paramLong;
    a(paramc);
  }
  
  private void a(c.f paramf)
  {
    if (paramf == null) {
      throw new NullPointerException();
    }
    try
    {
      cq.c localc = cq.b(paramf);
      a(localc);
      return;
    }
    catch (cq.g localg)
    {
      for (;;)
      {
        bh.A("Not loading resource: " + paramf + " because it is invalid: " + localg.toString());
      }
    }
  }
  
  private void a(cq.c paramc)
  {
    this.aew = paramc.getVersion();
    ag localag = bI(this.aew);
    a(new cs(this.mContext, paramc, this.aer, new a(null), new b(null), localag));
  }
  
  /**
   * @deprecated
   */
  private void a(cs paramcs)
  {
    try
    {
      this.aes = paramcs;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(c.i[] paramArrayOfi)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfi.length;
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        li().h(localArrayList);
        return;
      }
      localArrayList.add(paramArrayOfi[j]);
    }
  }
  
  /**
   * @deprecated
   */
  private cs li()
  {
    try
    {
      cs localcs = this.aes;
      return localcs;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  FunctionCallMacroCallback bF(String paramString)
  {
    synchronized (this.aet)
    {
      FunctionCallMacroCallback localFunctionCallMacroCallback = (FunctionCallMacroCallback)this.aet.get(paramString);
      return localFunctionCallMacroCallback;
    }
  }
  
  FunctionCallTagCallback bG(String paramString)
  {
    synchronized (this.aeu)
    {
      FunctionCallTagCallback localFunctionCallTagCallback = (FunctionCallTagCallback)this.aeu.get(paramString);
      return localFunctionCallTagCallback;
    }
  }
  
  void bH(String paramString)
  {
    li().bH(paramString);
  }
  
  ag bI(String paramString)
  {
    if (cd.lY().lZ().equals(cd.a.agA)) {}
    return new bq();
  }
  
  public boolean getBoolean(String paramString)
  {
    cs localcs = li();
    boolean bool1;
    if (localcs == null)
    {
      bh.A("getBoolean called for closed container.");
      bool1 = dh.mV().booleanValue();
    }
    for (;;)
    {
      return bool1;
      try
      {
        bool1 = dh.n((d.a)bool1.cj(paramString).getObject()).booleanValue();
        bool1 = bool1;
      }
      catch (Exception localException)
      {
        bh.A("Calling getBoolean() threw an exception: " + localException.getMessage() + " Returning default value.");
        boolean bool2 = dh.mV().booleanValue();
      }
    }
  }
  
  public String getContainerId()
  {
    return this.aeq;
  }
  
  public double getDouble(String paramString)
  {
    cs localcs = li();
    double d1;
    if (localcs == null)
    {
      bh.A("getDouble called for closed container.");
      d1 = dh.mU().doubleValue();
    }
    for (;;)
    {
      return d1;
      try
      {
        d1 = dh.m((d.a)d1.cj(paramString).getObject()).doubleValue();
        d1 = d1;
      }
      catch (Exception localException)
      {
        bh.A("Calling getDouble() threw an exception: " + localException.getMessage() + " Returning default value.");
        double d2 = dh.mU().doubleValue();
      }
    }
  }
  
  public long getLastRefreshTime()
  {
    return this.aev;
  }
  
  public long getLong(String paramString)
  {
    cs localcs = li();
    long l1;
    if (localcs == null)
    {
      bh.A("getLong called for closed container.");
      l1 = dh.mT().longValue();
    }
    for (;;)
    {
      return l1;
      try
      {
        l1 = dh.l((d.a)l1.cj(paramString).getObject()).longValue();
        l1 = l1;
      }
      catch (Exception localException)
      {
        bh.A("Calling getLong() threw an exception: " + localException.getMessage() + " Returning default value.");
        long l2 = dh.mT().longValue();
      }
    }
  }
  
  public String getString(String paramString)
  {
    Object localObject = li();
    if (localObject == null)
    {
      bh.A("getString called for closed container.");
      localObject = dh.mX();
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = dh.j((d.a)((cs)localObject).cj(paramString).getObject());
        localObject = localObject;
      }
      catch (Exception localException)
      {
        bh.A("Calling getString() threw an exception: " + localException.getMessage() + " Returning default value.");
        String str = dh.mX();
      }
    }
  }
  
  public boolean isDefault()
  {
    boolean bool;
    if (getLastRefreshTime() != 0L) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  String lh()
  {
    return this.aew;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.aet)
    {
      this.aet.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.aeu)
    {
      this.aeu.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.aes = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.aet)
    {
      this.aet.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.aeu)
    {
      this.aeu.remove(paramString);
      return;
    }
  }
  
  private class b
    implements s.a
  {
    private b() {}
    
    public Object b(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallTagCallback localFunctionCallTagCallback = Container.this.bG(paramString);
      if (localFunctionCallTagCallback != null) {
        localFunctionCallTagCallback.execute(paramString, paramMap);
      }
      return dh.mX();
    }
  }
  
  private class a
    implements s.a
  {
    private a() {}
    
    public Object b(String paramString, Map<String, Object> paramMap)
    {
      Object localObject = Container.this.bF(paramString);
      if (localObject != null) {
        localObject = ((Container.FunctionCallMacroCallback)localObject).getValue(paramString, paramMap);
      } else {
        localObject = null;
      }
      return localObject;
    }
  }
  
  public static abstract interface FunctionCallTagCallback
  {
    public abstract void execute(String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface FunctionCallMacroCallback
  {
    public abstract Object getValue(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.Container
 * JD-Core Version:    0.7.0.1
 */