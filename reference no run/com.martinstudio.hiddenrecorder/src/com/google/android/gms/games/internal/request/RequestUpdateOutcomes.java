package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.hn;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
  private static final String[] Sk;
  private final int CQ;
  private final HashMap<String, Integer> Sl;
  
  static
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "requestId";
    arrayOfString[1] = "outcome";
    Sk = arrayOfString;
  }
  
  private RequestUpdateOutcomes(int paramInt, HashMap<String, Integer> paramHashMap)
  {
    this.CQ = paramInt;
    this.Sl = paramHashMap;
  }
  
  public static RequestUpdateOutcomes U(DataHolder paramDataHolder)
  {
    Builder localBuilder = new Builder();
    localBuilder.cw(paramDataHolder.getStatusCode());
    int k = paramDataHolder.getCount();
    for (int j = 0;; j++)
    {
      if (j >= k) {
        return localBuilder.it();
      }
      int i = paramDataHolder.ae(j);
      localBuilder.v(paramDataHolder.c("requestId", j, i), paramDataHolder.b("outcome", j, i));
    }
  }
  
  public Set<String> getRequestIds()
  {
    return this.Sl.keySet();
  }
  
  public int getRequestOutcome(String paramString)
  {
    hn.b(this.Sl.containsKey(paramString), "Request " + paramString + " was not part of the update operation!");
    return ((Integer)this.Sl.get(paramString)).intValue();
  }
  
  public static final class Builder
  {
    private int CQ = 0;
    private HashMap<String, Integer> Sl = new HashMap();
    
    public Builder cw(int paramInt)
    {
      this.CQ = paramInt;
      return this;
    }
    
    public RequestUpdateOutcomes it()
    {
      return new RequestUpdateOutcomes(this.CQ, this.Sl, null);
    }
    
    public Builder v(String paramString, int paramInt)
    {
      if (RequestUpdateResultOutcome.isValid(paramInt)) {
        this.Sl.put(paramString, Integer.valueOf(paramInt));
      }
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.RequestUpdateOutcomes
 * JD-Core Version:    0.7.0.1
 */