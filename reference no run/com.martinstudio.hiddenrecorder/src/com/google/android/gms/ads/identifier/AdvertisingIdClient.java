package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.hn;
import java.io.IOException;

public final class AdvertisingIdClient
{
  /* Error */
  static Info a(Context paramContext, a parama)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 27	com/google/android/gms/common/a:er	()Landroid/os/IBinder;
    //   4: invokestatic 33	com/google/android/gms/internal/t$a:b	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/t;
    //   7: astore_2
    //   8: new 6	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   11: dup
    //   12: aload_2
    //   13: invokeinterface 39 1 0
    //   18: aload_2
    //   19: iconst_1
    //   20: invokeinterface 42 2 0
    //   25: invokespecial 45	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   28: astore_3
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 51	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   34: aload_3
    //   35: areturn
    //   36: astore_2
    //   37: ldc 53
    //   39: ldc 55
    //   41: aload_2
    //   42: invokestatic 61	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   45: pop
    //   46: goto -12 -> 34
    //   49: astore_2
    //   50: ldc 53
    //   52: ldc 63
    //   54: aload_2
    //   55: invokestatic 61	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   58: pop
    //   59: new 15	java/io/IOException
    //   62: dup
    //   63: ldc 65
    //   65: invokespecial 68	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: astore_3
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 51	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   75: aload_3
    //   76: athrow
    //   77: pop
    //   78: new 15	java/io/IOException
    //   81: dup
    //   82: ldc 70
    //   84: invokespecial 68	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   87: athrow
    //   88: astore_2
    //   89: ldc 53
    //   91: ldc 55
    //   93: aload_2
    //   94: invokestatic 61	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   97: pop
    //   98: goto -23 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramContext	Context
    //   0	101	1	parama	a
    //   7	12	2	localt	com.google.android.gms.internal.t
    //   36	6	2	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   49	6	2	localRemoteException	android.os.RemoteException
    //   88	6	2	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   28	7	3	localInfo	Info
    //   69	7	3	localObject	Object
    //   77	1	8	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   29	34	36	java/lang/IllegalArgumentException
    //   0	29	49	android/os/RemoteException
    //   0	29	69	finally
    //   50	69	69	finally
    //   78	88	69	finally
    //   0	29	77	java/lang/InterruptedException
    //   70	75	88	java/lang/IllegalArgumentException
  }
  
  static a g(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      a locala;
      Intent localIntent;
      throw new IOException("Connection failure");
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        GooglePlayServicesUtil.w(paramContext);
        locala = new a();
        localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
        localIntent.setPackage("com.google.android.gms");
        if (!paramContext.bindService(localIntent, locala, 1)) {
          break label73;
        }
        return locala;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        throw new IOException(localGooglePlayServicesNotAvailableException);
      }
      localNameNotFoundException;
      throw new GooglePlayServicesNotAvailableException(9);
    }
  }
  
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    hn.az("Calling this from your main thread can lead to deadlock");
    return a(paramContext, g(paramContext));
  }
  
  public static final class Info
  {
    private final String kx;
    private final boolean ky;
    
    public Info(String paramString, boolean paramBoolean)
    {
      this.kx = paramString;
      this.ky = paramBoolean;
    }
    
    public String getId()
    {
      return this.kx;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.ky;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient
 * JD-Core Version:    0.7.0.1
 */