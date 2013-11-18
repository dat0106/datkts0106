package com.google.ads;

import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.lang.ref.WeakReference;

public class ae
  implements Runnable
{
  private WeakReference<d> a;
  
  public ae(d paramd)
  {
    this.a = new WeakReference(paramd);
  }
  
  public void run()
  {
    d locald = (d)this.a.get();
    if (locald != null) {
      locald.y();
    } else {
      b.a("The ad must be gone, so cancelling the refresh timer.");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.ae
 * JD-Core Version:    0.7.0.1
 */