package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class i
  implements h
{
  protected MotionEvent jO;
  protected DisplayMetrics jP;
  protected n jQ;
  private o jR;
  
  protected i(Context paramContext, n paramn, o paramo)
  {
    this.jQ = paramn;
    this.jR = paramo;
    try
    {
      this.jP = paramContext.getResources().getDisplayMetrics();
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        this.jP = new DisplayMetrics();
        this.jP.density = 1.0F;
      }
    }
  }
  
  /* Error */
  private String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 58	com/google/android/gms/internal/i:t	()V
    //   6: iload_3
    //   7: ifeq +35 -> 42
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 62	com/google/android/gms/internal/i:c	(Landroid/content/Context;)V
    //   15: aload_0
    //   16: invokespecial 66	com/google/android/gms/internal/i:u	()[B
    //   19: astore 4
    //   21: aload_0
    //   22: monitorexit
    //   23: aload 4
    //   25: arraylength
    //   26: ifne +42 -> 68
    //   29: iconst_5
    //   30: invokestatic 72	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   33: astore 4
    //   35: aload 4
    //   37: astore 4
    //   39: aload 4
    //   41: areturn
    //   42: aload_0
    //   43: aload_1
    //   44: invokevirtual 75	com/google/android/gms/internal/i:b	(Landroid/content/Context;)V
    //   47: goto -32 -> 15
    //   50: astore 4
    //   52: aload_0
    //   53: monitorexit
    //   54: aload 4
    //   56: athrow
    //   57: pop
    //   58: bipush 7
    //   60: invokestatic 72	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   63: astore 4
    //   65: goto -26 -> 39
    //   68: aload_0
    //   69: aload 4
    //   71: aload_2
    //   72: invokevirtual 78	com/google/android/gms/internal/i:a	([BLjava/lang/String;)Ljava/lang/String;
    //   75: astore 4
    //   77: aload 4
    //   79: astore 4
    //   81: goto -42 -> 39
    //   84: pop
    //   85: bipush 7
    //   87: invokestatic 72	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   90: astore 4
    //   92: goto -53 -> 39
    //   95: pop
    //   96: iconst_3
    //   97: invokestatic 72	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   100: astore 4
    //   102: goto -63 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	i
    //   0	105	1	paramContext	Context
    //   0	105	2	paramString	String
    //   0	105	3	paramBoolean	boolean
    //   19	21	4	localObject1	Object
    //   50	5	4	localObject2	Object
    //   63	38	4	str	String
    //   57	1	7	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   84	1	8	localUnsupportedEncodingException	UnsupportedEncodingException
    //   95	1	9	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	23	50	finally
    //   42	54	50	finally
    //   0	2	57	java/security/NoSuchAlgorithmException
    //   23	35	57	java/security/NoSuchAlgorithmException
    //   54	57	57	java/security/NoSuchAlgorithmException
    //   68	77	57	java/security/NoSuchAlgorithmException
    //   0	2	84	java/io/UnsupportedEncodingException
    //   23	35	84	java/io/UnsupportedEncodingException
    //   54	57	84	java/io/UnsupportedEncodingException
    //   68	77	84	java/io/UnsupportedEncodingException
    //   0	2	95	java/io/IOException
    //   23	35	95	java/io/IOException
    //   54	57	95	java/io/IOException
    //   68	77	95	java/io/IOException
  }
  
  private void t()
  {
    this.jR.reset();
  }
  
  private byte[] u()
    throws IOException
  {
    return this.jR.z();
  }
  
  public String a(Context paramContext)
  {
    return a(paramContext, null, false);
  }
  
  public String a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true);
  }
  
  String a(byte[] paramArrayOfByte, String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException
  {
    if (paramArrayOfByte.length > 239)
    {
      t();
      a(20, 1L);
      paramArrayOfByte = u();
    }
    if (paramArrayOfByte.length >= 239)
    {
      arrayOfByte = ByteBuffer.allocate(240).put((byte)paramArrayOfByte.length).put(paramArrayOfByte).array();
    }
    else
    {
      arrayOfByte = new byte[239 - paramArrayOfByte.length];
      new SecureRandom().nextBytes(arrayOfByte);
      arrayOfByte = ByteBuffer.allocate(240).put((byte)paramArrayOfByte.length).put(paramArrayOfByte).put(arrayOfByte).array();
    }
    Object localObject = MessageDigest.getInstance("MD5");
    ((MessageDigest)localObject).update(arrayOfByte);
    localObject = ((MessageDigest)localObject).digest();
    byte[] arrayOfByte = ByteBuffer.allocate(256).put((byte[])localObject).put(arrayOfByte).array();
    localObject = new byte[256];
    new f().a(arrayOfByte, (byte[])localObject);
    if ((paramString != null) && (paramString.length() > 0)) {
      a(paramString, (byte[])localObject);
    }
    return this.jQ.a((byte[])localObject, true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jO != null) {
      this.jO.recycle();
    }
    this.jO = MotionEvent.obtain(0L, paramInt3, 1, paramInt1 * this.jP.density, paramInt2 * this.jP.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
  }
  
  protected void a(int paramInt, long paramLong)
    throws IOException
  {
    this.jR.b(paramInt, paramLong);
  }
  
  protected void a(int paramInt, String paramString)
    throws IOException
  {
    this.jR.b(paramInt, paramString);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (this.jO != null) {
        this.jO.recycle();
      }
      this.jO = MotionEvent.obtain(paramMotionEvent);
    }
  }
  
  void a(String paramString, byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    if (paramString.length() > 32) {
      paramString = paramString.substring(0, 32);
    }
    new ly(paramString.getBytes("UTF-8")).o(paramArrayOfByte);
  }
  
  protected abstract void b(Context paramContext);
  
  protected abstract void c(Context paramContext);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.i
 * JD-Core Version:    0.7.0.1
 */