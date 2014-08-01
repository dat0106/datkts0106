package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends a.a<BatchResult>
{
  private int Dw;
  private boolean Dx;
  private boolean Dy;
  private final PendingResult<?>[] Dz;
  private final Object lq = new Object();
  
  private Batch(List<PendingResult<?>> paramList, Looper paramLooper)
  {
    super(new a.c(paramLooper));
    this.Dw = paramList.size();
    this.Dz = new PendingResult[this.Dw];
    for (int i = 0;; i++)
    {
      if (i >= paramList.size()) {
        return;
      }
      PendingResult localPendingResult = (PendingResult)paramList.get(i);
      this.Dz[i] = localPendingResult;
      localPendingResult.a(new PendingResult.a()
      {
        /* Error */
        public void n(Status paramAnonymousStatus)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   4: invokestatic 25	com/google/android/gms/common/api/Batch:a	(Lcom/google/android/gms/common/api/Batch;)Ljava/lang/Object;
          //   7: astore_2
          //   8: aload_2
          //   9: monitorenter
          //   10: aload_0
          //   11: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   14: invokevirtual 29	com/google/android/gms/common/api/Batch:isCanceled	()Z
          //   17: ifeq +8 -> 25
          //   20: aload_2
          //   21: monitorexit
          //   22: goto +135 -> 157
          //   25: aload_1
          //   26: invokevirtual 32	com/google/android/gms/common/api/Status:isCanceled	()Z
          //   29: ifeq +57 -> 86
          //   32: aload_0
          //   33: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   36: iconst_1
          //   37: invokestatic 35	com/google/android/gms/common/api/Batch:a	(Lcom/google/android/gms/common/api/Batch;Z)Z
          //   40: pop
          //   41: aload_0
          //   42: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   45: invokestatic 39	com/google/android/gms/common/api/Batch:b	(Lcom/google/android/gms/common/api/Batch;)I
          //   48: pop
          //   49: aload_0
          //   50: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   53: invokestatic 42	com/google/android/gms/common/api/Batch:c	(Lcom/google/android/gms/common/api/Batch;)I
          //   56: ifne +20 -> 76
          //   59: aload_0
          //   60: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   63: invokestatic 46	com/google/android/gms/common/api/Batch:d	(Lcom/google/android/gms/common/api/Batch;)Z
          //   66: ifeq +39 -> 105
          //   69: aload_0
          //   70: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   73: invokestatic 49	com/google/android/gms/common/api/Batch:e	(Lcom/google/android/gms/common/api/Batch;)V
          //   76: aload_2
          //   77: monitorexit
          //   78: goto +79 -> 157
          //   81: astore_3
          //   82: aload_2
          //   83: monitorexit
          //   84: aload_3
          //   85: athrow
          //   86: aload_1
          //   87: invokevirtual 52	com/google/android/gms/common/api/Status:isSuccess	()Z
          //   90: ifne -49 -> 41
          //   93: aload_0
          //   94: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   97: iconst_1
          //   98: invokestatic 54	com/google/android/gms/common/api/Batch:b	(Lcom/google/android/gms/common/api/Batch;Z)Z
          //   101: pop
          //   102: goto -61 -> 41
          //   105: aload_0
          //   106: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   109: invokestatic 57	com/google/android/gms/common/api/Batch:f	(Lcom/google/android/gms/common/api/Batch;)Z
          //   112: ifeq +38 -> 150
          //   115: new 31	com/google/android/gms/common/api/Status
          //   118: dup
          //   119: bipush 13
          //   121: invokespecial 60	com/google/android/gms/common/api/Status:<init>	(I)V
          //   124: astore_3
          //   125: aload_0
          //   126: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   129: new 62	com/google/android/gms/common/api/BatchResult
          //   132: dup
          //   133: aload_3
          //   134: aload_0
          //   135: getfield 16	com/google/android/gms/common/api/Batch$1:DA	Lcom/google/android/gms/common/api/Batch;
          //   138: invokestatic 66	com/google/android/gms/common/api/Batch:g	(Lcom/google/android/gms/common/api/Batch;)[Lcom/google/android/gms/common/api/PendingResult;
          //   141: invokespecial 69	com/google/android/gms/common/api/BatchResult:<init>	(Lcom/google/android/gms/common/api/Status;[Lcom/google/android/gms/common/api/PendingResult;)V
          //   144: invokevirtual 72	com/google/android/gms/common/api/Batch:b	(Lcom/google/android/gms/common/api/Result;)V
          //   147: goto -71 -> 76
          //   150: getstatic 76	com/google/android/gms/common/api/Status:Ek	Lcom/google/android/gms/common/api/Status;
          //   153: astore_3
          //   154: goto -29 -> 125
          //   157: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	158	0	this	1
          //   0	158	1	paramAnonymousStatus	Status
          //   7	76	2	localObject1	Object
          //   81	4	3	localObject2	Object
          //   124	30	3	localStatus	Status
          // Exception table:
          //   from	to	target	type
          //   10	84	81	finally
          //   86	154	81	finally
        }
      });
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.Dz;
    int j = arrayOfPendingResult.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      arrayOfPendingResult[i].cancel();
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.Dz);
  }
  
  public static final class Builder
  {
    private List<PendingResult<?>> DB = new ArrayList();
    private Looper DC;
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.DC = paramGoogleApiClient.getLooper();
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.DB.size());
      this.DB.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(this.DB, this.DC, null);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * JD-Core Version:    0.7.0.1
 */