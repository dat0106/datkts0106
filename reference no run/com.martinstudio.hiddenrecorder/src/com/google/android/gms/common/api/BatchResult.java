package com.google.android.gms.common.api;

import com.google.android.gms.internal.hn;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final PendingResult<?>[] Dz;
  private final Status yw;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.yw = paramStatus;
    this.Dz = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return this.yw;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    boolean bool;
    if (paramBatchResultToken.mId >= this.Dz.length) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "The result token does not belong to this batch");
    return this.Dz[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BatchResult
 * JD-Core Version:    0.7.0.1
 */