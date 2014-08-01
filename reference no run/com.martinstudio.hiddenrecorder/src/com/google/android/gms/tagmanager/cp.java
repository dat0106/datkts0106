package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.lf.a;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.mf;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class cp
  implements o.f
{
  private final String aeq;
  private bg<lf.a> agK;
  private final ExecutorService agR;
  private final Context mContext;
  
  cp(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.aeq = paramString;
    this.agR = Executors.newSingleThreadExecutor();
  }
  
  private cq.c a(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    cq.c localc = null;
    try
    {
      localc = ba.bY(paramByteArrayOutputStream.toString("UTF-8"));
      localc = localc;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        bh.z("Tried to convert binary resource to string for JSON parsing; not UTF-8 format");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bh.D("Resource is a UTF-8 encoded string but doesn't contain a JSON container");
      }
    }
    return localc;
  }
  
  private cq.c k(byte[] paramArrayOfByte)
  {
    cq.c localc = null;
    try
    {
      localc = cq.b(c.f.a(paramArrayOfByte));
      localc = localc;
    }
    catch (me localme)
    {
      for (;;)
      {
        bh.D("Resource doesn't contain a binary container");
      }
    }
    catch (cq.g localg)
    {
      for (;;)
      {
        bh.D("Resource doesn't contain a binary container");
      }
    }
    return localc;
  }
  
  public void a(bg<lf.a> parambg)
  {
    this.agK = parambg;
  }
  
  public void b(final lf.a parama)
  {
    this.agR.execute(new Runnable()
    {
      public void run()
      {
        cp.this.c(parama);
      }
    });
  }
  
  boolean c(lf.a parama)
  {
    boolean bool = false;
    localFile = mh();
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      try
      {
        localFileOutputStream.close();
        throw localObject;
      }
      catch (IOException localIOException4)
      {
        for (;;)
        {
          bh.D("error closing stream for writing resource to disk");
        }
      }
    }
    catch (FileNotFoundException localIOException2)
    {
      for (;;)
      {
        try
        {
          localFileOutputStream.write(mf.d(parama));
          bool = true;
        }
        catch (IOException localIOException2)
        {
          localIOException2;
          bh.D("Error writing resource to disk. Removing resource from disk.");
          localFile.delete();
          try
          {
            localFileOutputStream.close();
          }
          catch (IOException localIOException3)
          {
            bh.D("error closing stream for writing resource to disk");
          }
          continue;
        }
        finally {}
        try
        {
          localFileOutputStream.close();
          return bool;
          localFileNotFoundException;
          bh.A("Error opening resource file for writing");
        }
        catch (IOException localIOException1)
        {
          bh.D("error closing stream for writing resource to disk");
        }
      }
    }
  }
  
  public cq.c dn(int paramInt)
  {
    bh.C("Atttempting to load container from resource ID " + paramInt);
    Object localObject2;
    try
    {
      localObject2 = this.mContext.getResources().openRawResource(paramInt);
      Object localObject1 = new ByteArrayOutputStream();
      cq.b((InputStream)localObject2, (OutputStream)localObject1);
      localObject2 = a((ByteArrayOutputStream)localObject1);
      if (localObject2 == null)
      {
        localObject1 = k(((ByteArrayOutputStream)localObject1).toByteArray());
        localObject2 = localObject1;
      }
    }
    catch (IOException localIOException)
    {
      bh.D("Error reading default container resource with ID " + paramInt);
      localObject2 = null;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      bh.D("No default container resource found.");
      localObject2 = null;
    }
    return localObject2;
  }
  
  public void lr()
  {
    this.agR.execute(new Runnable()
    {
      public void run()
      {
        cp.this.mg();
      }
    });
  }
  
  /* Error */
  void mg()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	com/google/android/gms/tagmanager/cp:agK	Lcom/google/android/gms/tagmanager/bg;
    //   4: ifnonnull +13 -> 17
    //   7: new 201	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 203
    //   13: invokespecial 205	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 91	com/google/android/gms/tagmanager/cp:agK	Lcom/google/android/gms/tagmanager/bg;
    //   21: invokeinterface 210 1 0
    //   26: ldc 212
    //   28: invokestatic 166	com/google/android/gms/tagmanager/bh:C	(Ljava/lang/String;)V
    //   31: invokestatic 218	com/google/android/gms/tagmanager/cd:lY	()Lcom/google/android/gms/tagmanager/cd;
    //   34: invokevirtual 222	com/google/android/gms/tagmanager/cd:lZ	()Lcom/google/android/gms/tagmanager/cd$a;
    //   37: getstatic 228	com/google/android/gms/tagmanager/cd$a:agz	Lcom/google/android/gms/tagmanager/cd$a;
    //   40: if_acmpeq +15 -> 55
    //   43: invokestatic 218	com/google/android/gms/tagmanager/cd:lY	()Lcom/google/android/gms/tagmanager/cd;
    //   46: invokevirtual 222	com/google/android/gms/tagmanager/cd:lZ	()Lcom/google/android/gms/tagmanager/cd$a;
    //   49: getstatic 231	com/google/android/gms/tagmanager/cd$a:agA	Lcom/google/android/gms/tagmanager/cd$a;
    //   52: if_acmpne +32 -> 84
    //   55: aload_0
    //   56: getfield 28	com/google/android/gms/tagmanager/cp:aeq	Ljava/lang/String;
    //   59: invokestatic 218	com/google/android/gms/tagmanager/cd:lY	()Lcom/google/android/gms/tagmanager/cd;
    //   62: invokevirtual 234	com/google/android/gms/tagmanager/cd:getContainerId	()Ljava/lang/String;
    //   65: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +16 -> 84
    //   71: aload_0
    //   72: getfield 91	com/google/android/gms/tagmanager/cp:agK	Lcom/google/android/gms/tagmanager/bg;
    //   75: getstatic 246	com/google/android/gms/tagmanager/bg$a:agd	Lcom/google/android/gms/tagmanager/bg$a;
    //   78: invokeinterface 249 2 0
    //   83: return
    //   84: new 251	java/io/FileInputStream
    //   87: dup
    //   88: aload_0
    //   89: invokevirtual 111	com/google/android/gms/tagmanager/cp:mh	()Ljava/io/File;
    //   92: invokespecial 252	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: new 46	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 179	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: aload_1
    //   105: aload_2
    //   106: invokestatic 182	com/google/android/gms/tagmanager/cq:b	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   109: aload_0
    //   110: getfield 91	com/google/android/gms/tagmanager/cp:agK	Lcom/google/android/gms/tagmanager/bg;
    //   113: aload_2
    //   114: invokevirtual 188	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   117: invokestatic 258	com/google/android/gms/internal/lf$a:l	([B)Lcom/google/android/gms/internal/lf$a;
    //   120: invokeinterface 262 2 0
    //   125: aload_1
    //   126: invokevirtual 263	java/io/FileInputStream:close	()V
    //   129: ldc_w 265
    //   132: invokestatic 166	com/google/android/gms/tagmanager/bh:C	(Ljava/lang/String;)V
    //   135: goto -52 -> 83
    //   138: pop
    //   139: ldc_w 267
    //   142: invokestatic 64	com/google/android/gms/tagmanager/bh:z	(Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 91	com/google/android/gms/tagmanager/cp:agK	Lcom/google/android/gms/tagmanager/bg;
    //   149: getstatic 246	com/google/android/gms/tagmanager/bg$a:agd	Lcom/google/android/gms/tagmanager/bg$a;
    //   152: invokeinterface 249 2 0
    //   157: goto -74 -> 83
    //   160: pop
    //   161: ldc_w 269
    //   164: invokestatic 69	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   167: goto -38 -> 129
    //   170: pop
    //   171: ldc_w 271
    //   174: invokestatic 69	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   177: aload_0
    //   178: getfield 91	com/google/android/gms/tagmanager/cp:agK	Lcom/google/android/gms/tagmanager/bg;
    //   181: getstatic 274	com/google/android/gms/tagmanager/bg$a:age	Lcom/google/android/gms/tagmanager/bg$a;
    //   184: invokeinterface 249 2 0
    //   189: aload_1
    //   190: invokevirtual 263	java/io/FileInputStream:close	()V
    //   193: goto -64 -> 129
    //   196: pop
    //   197: ldc_w 269
    //   200: invokestatic 69	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   203: goto -74 -> 129
    //   206: astore_2
    //   207: aload_1
    //   208: invokevirtual 263	java/io/FileInputStream:close	()V
    //   211: aload_2
    //   212: athrow
    //   213: pop
    //   214: ldc_w 269
    //   217: invokestatic 69	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   220: goto -9 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	cp
    //   95	113	1	localFileInputStream	java.io.FileInputStream
    //   103	11	2	localByteArrayOutputStream	ByteArrayOutputStream
    //   206	6	2	localObject	Object
    //   138	1	4	localFileNotFoundException	FileNotFoundException
    //   160	1	5	localIOException1	IOException
    //   170	1	6	localIOException2	IOException
    //   196	1	7	localIOException3	IOException
    //   213	1	8	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   84	96	138	java/io/FileNotFoundException
    //   125	129	160	java/io/IOException
    //   96	125	170	java/io/IOException
    //   189	193	196	java/io/IOException
    //   96	125	206	finally
    //   171	189	206	finally
    //   207	211	213	java/io/IOException
  }
  
  File mh()
  {
    String str = "resource_" + this.aeq;
    return new File(this.mContext.getDir("google_tagmanager", 0), str);
  }
  
  /**
   * @deprecated
   */
  public void release()
  {
    try
    {
      this.agR.shutdown();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cp
 * JD-Core Version:    0.7.0.1
 */