package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.widget.ImageView;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.iq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object EU = new Object();
  private static HashSet<Uri> EV = new HashSet();
  private static ImageManager EW;
  private static ImageManager EX;
  private final ExecutorService EY;
  private final b EZ;
  private final gx Fa;
  private final Map<a, ImageReceiver> Fb;
  private final Map<Uri, ImageReceiver> Fc;
  private final Map<Uri, Long> Fd;
  private final Context mContext;
  private final Handler mHandler;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.EY = Executors.newFixedThreadPool(4);
    if (!paramBoolean)
    {
      this.EZ = null;
    }
    else
    {
      this.EZ = new b(this.mContext);
      if (iq.ga()) {
        eX();
      }
    }
    this.Fa = new gx();
    this.Fb = new HashMap();
    this.Fc = new HashMap();
    this.Fd = new HashMap();
  }
  
  private Bitmap a(a.a parama)
  {
    Bitmap localBitmap;
    if (this.EZ != null) {
      localBitmap = (Bitmap)this.EZ.get(parama);
    } else {
      localBitmap = null;
    }
    return localBitmap;
  }
  
  public static ImageManager a(Context paramContext, boolean paramBoolean)
  {
    ImageManager localImageManager;
    if (!paramBoolean)
    {
      if (EW == null) {
        EW = new ImageManager(paramContext, false);
      }
      localImageManager = EW;
    }
    else
    {
      if (EX == null) {
        EX = new ImageManager(paramContext, true);
      }
      localImageManager = EX;
    }
    return localImageManager;
  }
  
  public static ImageManager create(Context paramContext)
  {
    return a(paramContext, false);
  }
  
  private void eX()
  {
    this.mContext.registerComponentCallbacks(new e(this.EZ));
  }
  
  public void a(a parama)
  {
    gy.ay("ImageManager.loadImage() must be called in the main thread");
    new d(parama).run();
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    a(new a.b(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    a(new a.b(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    a.b localb = new a.b(paramImageView, paramUri);
    localb.aj(paramInt);
    a(localb);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    a(new a.c(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    a.c localc = new a.c(paramOnImageLoadedListener, paramUri);
    localc.aj(paramInt);
    a(localc);
  }
  
  private static final class a
  {
    static int a(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
  
  private static final class b
    extends hr<a.a, Bitmap>
  {
    public b(Context paramContext)
    {
      super();
    }
    
    private static int A(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      int j;
      if ((0x100000 & paramContext.getApplicationInfo().flags) == 0) {
        j = 0;
      } else {
        j = 1;
      }
      int i;
      if ((j == 0) || (!iq.fX())) {
        i = localActivityManager.getMemoryClass();
      } else {
        i = ImageManager.a.a(i);
      }
      return (int)(0.33F * (i * 1048576));
    }
    
    protected int a(a.a parama, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }
    
    protected void a(boolean paramBoolean, a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, parama, paramBitmap1, paramBitmap2);
    }
  }
  
  private static final class e
    implements ComponentCallbacks2
  {
    private final ImageManager.b EZ;
    
    public e(ImageManager.b paramb)
    {
      this.EZ = paramb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      this.EZ.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt < 60)
      {
        if (paramInt >= 20) {
          this.EZ.trimToSize(this.EZ.size() / 2);
        }
      }
      else {
        this.EZ.evictAll();
      }
    }
  }
  
  private final class f
    implements Runnable
  {
    private boolean Fi;
    private final CountDownLatch kI;
    private final Bitmap mBitmap;
    private final Uri mUri;
    
    public f(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.Fi = paramBoolean;
      this.kI = paramCountDownLatch;
    }
    
    private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      ArrayList localArrayList = ImageManager.ImageReceiver.a(paramImageReceiver);
      int j = localArrayList.size();
      for (int i = 0;; i++)
      {
        if (i >= j) {
          return;
        }
        a locala = (a)localArrayList.get(i);
        if (!paramBoolean)
        {
          ImageManager.d(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          locala.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), false);
        }
        else
        {
          locala.a(ImageManager.b(ImageManager.this), this.mBitmap, false);
        }
        if (!(locala instanceof a.c)) {
          ImageManager.a(ImageManager.this).remove(locala);
        }
      }
    }
    
    public void run()
    {
      gy.ay("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null)
      {
        bool = true;
        if (ImageManager.h(ImageManager.this) == null) {
          break label97;
        }
        if (!this.Fi) {
          break label67;
        }
        ImageManager.h(ImageManager.this).evictAll();
        System.gc();
        this.Fi = false;
        ImageManager.g(ImageManager.this).post(this);
      }
      for (;;)
      {
        return;
        bool = false;
        break;
        label67:
        if (bool) {
          ImageManager.h(ImageManager.this).put(new a.a(this.mUri), this.mBitmap);
        }
        label97:
        ??? = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).remove(this.mUri);
        if (??? != null) {
          a((ImageManager.ImageReceiver)???, bool);
        }
        this.kI.countDown();
        synchronized (ImageManager.eY())
        {
          ImageManager.eZ().remove(this.mUri);
        }
      }
    }
  }
  
  private final class c
    implements Runnable
  {
    private final ParcelFileDescriptor Fg;
    private final Uri mUri;
    
    public c(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.Fg = paramParcelFileDescriptor;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 35
      //   2: invokestatic 41	com/google/android/gms/internal/gy:az	(Ljava/lang/String;)V
      //   5: iconst_0
      //   6: istore_2
      //   7: aconst_null
      //   8: astore_1
      //   9: aload_0
      //   10: getfield 26	com/google/android/gms/common/images/ImageManager$c:Fg	Landroid/os/ParcelFileDescriptor;
      //   13: ifnull +23 -> 36
      //   16: aload_0
      //   17: getfield 26	com/google/android/gms/common/images/ImageManager$c:Fg	Landroid/os/ParcelFileDescriptor;
      //   20: invokevirtual 47	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
      //   23: invokestatic 53	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
      //   26: astore_1
      //   27: aload_1
      //   28: astore_1
      //   29: aload_0
      //   30: getfield 26	com/google/android/gms/common/images/ImageManager$c:Fg	Landroid/os/ParcelFileDescriptor;
      //   33: invokevirtual 56	android/os/ParcelFileDescriptor:close	()V
      //   36: new 58	java/util/concurrent/CountDownLatch
      //   39: dup
      //   40: iconst_1
      //   41: invokespecial 61	java/util/concurrent/CountDownLatch:<init>	(I)V
      //   44: astore_3
      //   45: aload_0
      //   46: getfield 19	com/google/android/gms/common/images/ImageManager$c:Ff	Lcom/google/android/gms/common/images/ImageManager;
      //   49: invokestatic 65	com/google/android/gms/common/images/ImageManager:g	(Lcom/google/android/gms/common/images/ImageManager;)Landroid/os/Handler;
      //   52: new 67	com/google/android/gms/common/images/ImageManager$f
      //   55: dup
      //   56: aload_0
      //   57: getfield 19	com/google/android/gms/common/images/ImageManager$c:Ff	Lcom/google/android/gms/common/images/ImageManager;
      //   60: aload_0
      //   61: getfield 24	com/google/android/gms/common/images/ImageManager$c:mUri	Landroid/net/Uri;
      //   64: aload_1
      //   65: iload_2
      //   66: aload_3
      //   67: invokespecial 70	com/google/android/gms/common/images/ImageManager$f:<init>	(Lcom/google/android/gms/common/images/ImageManager;Landroid/net/Uri;Landroid/graphics/Bitmap;ZLjava/util/concurrent/CountDownLatch;)V
      //   70: invokevirtual 76	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   73: pop
      //   74: aload_3
      //   75: invokevirtual 79	java/util/concurrent/CountDownLatch:await	()V
      //   78: return
      //   79: astore_2
      //   80: ldc 81
      //   82: new 83	java/lang/StringBuilder
      //   85: dup
      //   86: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   89: ldc 86
      //   91: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   94: aload_0
      //   95: getfield 24	com/google/android/gms/common/images/ImageManager$c:mUri	Landroid/net/Uri;
      //   98: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   101: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   104: aload_2
      //   105: invokestatic 103	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   108: pop
      //   109: iconst_1
      //   110: istore_2
      //   111: goto -82 -> 29
      //   114: astore_3
      //   115: ldc 81
      //   117: ldc 105
      //   119: aload_3
      //   120: invokestatic 103	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   123: pop
      //   124: goto -88 -> 36
      //   127: pop
      //   128: ldc 81
      //   130: new 83	java/lang/StringBuilder
      //   133: dup
      //   134: invokespecial 84	java/lang/StringBuilder:<init>	()V
      //   137: ldc 107
      //   139: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   142: aload_0
      //   143: getfield 24	com/google/android/gms/common/images/ImageManager$c:mUri	Landroid/net/Uri;
      //   146: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   149: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   152: invokestatic 111	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   155: pop
      //   156: goto -78 -> 78
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	159	0	this	c
      //   8	57	1	localBitmap	Bitmap
      //   6	60	2	bool	boolean
      //   79	26	2	localOutOfMemoryError	java.lang.OutOfMemoryError
      //   110	1	2	i	int
      //   44	31	3	localCountDownLatch	CountDownLatch
      //   114	6	3	localIOException	java.io.IOException
      //   127	1	7	localInterruptedException	java.lang.InterruptedException
      // Exception table:
      //   from	to	target	type
      //   16	27	79	java/lang/OutOfMemoryError
      //   29	36	114	java/io/IOException
      //   74	78	127	java/lang/InterruptedException
    }
  }
  
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final ArrayList<a> Fe;
    private final Uri mUri;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      this.mUri = paramUri;
      this.Fe = new ArrayList();
    }
    
    public void b(a parama)
    {
      gy.ay("ImageReceiver.addImageRequest() must be called in the main thread");
      this.Fe.add(parama);
    }
    
    public void c(a parama)
    {
      gy.ay("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.Fe.remove(parama);
    }
    
    public void fa()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.b(ImageManager.this).sendBroadcast(localIntent);
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.f(ImageManager.this).execute(new ImageManager.c(ImageManager.this, this.mUri, localParcelFileDescriptor));
    }
  }
  
  private final class d
    implements Runnable
  {
    private final a Fh;
    
    public d(a parama)
    {
      this.Fh = parama;
    }
    
    public void run()
    {
      gy.ay("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.a(ImageManager.this).get(this.Fh);
      if (localObject1 != null)
      {
        ImageManager.a(ImageManager.this).remove(this.Fh);
        ((ImageManager.ImageReceiver)localObject1).c(this.Fh);
      }
      localObject1 = this.Fh.Fj;
      if (((a.a)localObject1).uri == null) {
        this.Fh.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
      }
      for (;;)
      {
        return;
        ??? = ImageManager.a(ImageManager.this, (a.a)localObject1);
        if (??? != null)
        {
          this.Fh.a(ImageManager.b(ImageManager.this), (Bitmap)???, true);
          continue;
        }
        ??? = (Long)ImageManager.d(ImageManager.this).get(((a.a)localObject1).uri);
        if (??? != null)
        {
          if (SystemClock.elapsedRealtime() - ((Long)???).longValue() < 3600000L)
          {
            this.Fh.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
            continue;
          }
          ImageManager.d(ImageManager.this).remove(((a.a)localObject1).uri);
        }
        this.Fh.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this));
        ImageManager.ImageReceiver localImageReceiver = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).get(((a.a)localObject1).uri);
        if (localImageReceiver == null)
        {
          localImageReceiver = new ImageManager.ImageReceiver(ImageManager.this, ((a.a)localObject1).uri);
          ImageManager.e(ImageManager.this).put(((a.a)localObject1).uri, localImageReceiver);
        }
        localImageReceiver.b(this.Fh);
        if (!(this.Fh instanceof a.c)) {
          ImageManager.a(ImageManager.this).put(this.Fh, localImageReceiver);
        }
        synchronized (ImageManager.eY())
        {
          if (!ImageManager.eZ().contains(((a.a)localObject1).uri))
          {
            ImageManager.eZ().add(((a.a)localObject1).uri);
            localImageReceiver.fa();
          }
        }
      }
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.7.0.1
 */