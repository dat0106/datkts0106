package com.google.android.gms.internal;

public abstract class en
{
  private final Runnable le = new Runnable()
  {
    public final void run()
    {
      en.a(en.this, Thread.currentThread());
      en.this.bc();
    }
  };
  private volatile Thread sc;
  
  public abstract void bc();
  
  public final void cancel()
  {
    onStop();
    if (this.sc != null) {
      this.sc.interrupt();
    }
  }
  
  public abstract void onStop();
  
  public final void start()
  {
    eo.execute(this.le);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.en
 * JD-Core Version:    0.7.0.1
 */