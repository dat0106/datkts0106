package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import java.io.FileNotFoundException;

class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  private final Object mLock = new Object();
  int mOrientation = 1;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f = paramRectF.width() / paramInt1;
    if (paramInt3 != 2) {
      f = Math.min(f, paramRectF.height() / paramInt2);
    } else {
      f = Math.max(f, paramRectF.height() / paramInt2);
    }
    localMatrix.postScale(f, f);
    localMatrix.postTranslate((paramRectF.width() - f * paramInt1) / 2.0F, (paramRectF.height() - f * paramInt2) / 2.0F);
    return localMatrix;
  }
  
  /* Error */
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getfield 49	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   8: ifnonnull +13 -> 21
    //   11: new 100	java/lang/IllegalArgumentException
    //   14: dup
    //   15: ldc 102
    //   17: invokespecial 105	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: aconst_null
    //   22: astore 4
    //   24: aload_0
    //   25: getfield 49	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   28: invokevirtual 111	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload_1
    //   32: invokevirtual 117	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   35: astore 4
    //   37: aload 4
    //   39: aconst_null
    //   40: aload_2
    //   41: invokestatic 123	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   44: astore_3
    //   45: aload 4
    //   47: ifnull +8 -> 55
    //   50: aload 4
    //   52: invokevirtual 128	java/io/InputStream:close	()V
    //   55: aload_3
    //   56: areturn
    //   57: astore 4
    //   59: ldc 17
    //   61: ldc 130
    //   63: aload 4
    //   65: invokestatic 136	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   68: pop
    //   69: goto -14 -> 55
    //   72: astore_3
    //   73: aload 4
    //   75: ifnull +8 -> 83
    //   78: aload 4
    //   80: invokevirtual 128	java/io/InputStream:close	()V
    //   83: aload_3
    //   84: athrow
    //   85: astore 4
    //   87: ldc 17
    //   89: ldc 130
    //   91: aload 4
    //   93: invokestatic 136	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   96: pop
    //   97: goto -14 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	PrintHelperKitkat
    //   0	100	1	paramUri	Uri
    //   0	100	2	paramOptions	BitmapFactory.Options
    //   44	12	3	localBitmap	Bitmap
    //   72	12	3	localObject	Object
    //   22	29	4	localInputStream	java.io.InputStream
    //   57	22	4	localIOException1	java.io.IOException
    //   85	7	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   50	55	57	java/io/IOException
    //   24	45	72	finally
    //   78	83	85	java/io/IOException
  }
  
  /* Error */
  private Bitmap loadConstrainedBitmap(Uri paramUri, int paramInt)
    throws FileNotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iload_2
    //   3: ifle +14 -> 17
    //   6: aload_1
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: getfield 49	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   14: ifnonnull +13 -> 27
    //   17: new 100	java/lang/IllegalArgumentException
    //   20: dup
    //   21: ldc 138
    //   23: invokespecial 105	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   26: athrow
    //   27: new 140	android/graphics/BitmapFactory$Options
    //   30: dup
    //   31: invokespecial 141	android/graphics/BitmapFactory$Options:<init>	()V
    //   34: astore 4
    //   36: aload 4
    //   38: iconst_1
    //   39: putfield 145	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   42: aload_0
    //   43: aload_1
    //   44: aload 4
    //   46: invokespecial 147	android/support/v4/print/PrintHelperKitkat:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   49: pop
    //   50: aload 4
    //   52: getfield 150	android/graphics/BitmapFactory$Options:outWidth	I
    //   55: istore 5
    //   57: aload 4
    //   59: getfield 153	android/graphics/BitmapFactory$Options:outHeight	I
    //   62: istore 7
    //   64: iload 5
    //   66: ifle +8 -> 74
    //   69: iload 7
    //   71: ifgt +5 -> 76
    //   74: aload_3
    //   75: areturn
    //   76: iload 5
    //   78: iload 7
    //   80: invokestatic 156	java/lang/Math:max	(II)I
    //   83: istore 6
    //   85: iconst_1
    //   86: istore 4
    //   88: iload 6
    //   90: iload_2
    //   91: if_icmple +18 -> 109
    //   94: iload 6
    //   96: iconst_1
    //   97: iushr
    //   98: istore 6
    //   100: iload 4
    //   102: iconst_1
    //   103: ishl
    //   104: istore 4
    //   106: goto -18 -> 88
    //   109: iload 4
    //   111: ifle -37 -> 74
    //   114: iload 5
    //   116: iload 7
    //   118: invokestatic 158	java/lang/Math:min	(II)I
    //   121: iload 4
    //   123: idiv
    //   124: ifle -50 -> 74
    //   127: aload_0
    //   128: getfield 41	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   131: astore_3
    //   132: aload_3
    //   133: monitorenter
    //   134: aload_0
    //   135: new 140	android/graphics/BitmapFactory$Options
    //   138: dup
    //   139: invokespecial 141	android/graphics/BitmapFactory$Options:<init>	()V
    //   142: putfield 39	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   145: aload_0
    //   146: getfield 39	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   149: iconst_1
    //   150: putfield 161	android/graphics/BitmapFactory$Options:inMutable	Z
    //   153: aload_0
    //   154: getfield 39	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   157: iload 4
    //   159: putfield 164	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   162: aload_0
    //   163: getfield 39	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   166: astore 4
    //   168: aload_3
    //   169: monitorexit
    //   170: aload_0
    //   171: aload_1
    //   172: aload 4
    //   174: invokespecial 147	android/support/v4/print/PrintHelperKitkat:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   177: astore_3
    //   178: aload_3
    //   179: astore_3
    //   180: aload_0
    //   181: getfield 41	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   184: astore 4
    //   186: aload 4
    //   188: monitorenter
    //   189: aload_0
    //   190: aconst_null
    //   191: putfield 39	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   194: aload 4
    //   196: monitorexit
    //   197: goto -123 -> 74
    //   200: astore_3
    //   201: aload 4
    //   203: monitorexit
    //   204: aload_3
    //   205: athrow
    //   206: astore 4
    //   208: aload_3
    //   209: monitorexit
    //   210: aload 4
    //   212: athrow
    //   213: astore 4
    //   215: aload_0
    //   216: getfield 41	android/support/v4/print/PrintHelperKitkat:mLock	Ljava/lang/Object;
    //   219: astore_3
    //   220: aload_3
    //   221: monitorenter
    //   222: aload_0
    //   223: aconst_null
    //   224: putfield 39	android/support/v4/print/PrintHelperKitkat:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   227: aload_3
    //   228: monitorexit
    //   229: aload 4
    //   231: athrow
    //   232: astore 4
    //   234: aload_3
    //   235: monitorexit
    //   236: aload 4
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	PrintHelperKitkat
    //   0	239	1	paramUri	Uri
    //   0	239	2	paramInt	int
    //   1	179	3	localObject1	Object
    //   200	9	3	localObject2	Object
    //   219	16	3	localObject3	Object
    //   34	24	4	localOptions	BitmapFactory.Options
    //   86	72	4	i	int
    //   166	36	4	localObject4	Object
    //   206	5	4	localObject5	Object
    //   213	17	4	localObject6	Object
    //   232	5	4	localObject7	Object
    //   55	60	5	j	int
    //   83	16	6	k	int
    //   62	55	7	m	int
    // Exception table:
    //   from	to	target	type
    //   189	204	200	finally
    //   134	170	206	finally
    //   208	210	206	finally
    //   170	178	213	finally
    //   222	229	232	finally
    //   234	236	232	finally
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(final String paramString, final Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      final int i = this.mScaleMode;
      PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
      Object localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
      if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
        localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
      }
      localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintDocumentAdapter()
      {
        private PrintAttributes mAttributes;
        
        public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
        {
          int i = 1;
          this.mAttributes = paramAnonymousPrintAttributes2;
          PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(paramString).setContentType(i).setPageCount(i).build();
          if (paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {
            i = 0;
          }
          paramAnonymousLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
        }
        
        /* Error */
        public void onWrite(android.print.PageRange[] paramAnonymousArrayOfPageRange, android.os.ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
        {
          // Byte code:
          //   0: new 70	android/print/pdf/PrintedPdfDocument
          //   3: dup
          //   4: aload_0
          //   5: getfield 23	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
          //   8: getfield 74	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
          //   11: aload_0
          //   12: getfield 36	android/support/v4/print/PrintHelperKitkat$1:mAttributes	Landroid/print/PrintAttributes;
          //   15: invokespecial 77	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
          //   18: astore 5
          //   20: aload 5
          //   22: iconst_1
          //   23: invokevirtual 81	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
          //   26: astore 6
          //   28: new 83	android/graphics/RectF
          //   31: dup
          //   32: aload 6
          //   34: invokevirtual 89	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
          //   37: invokevirtual 95	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
          //   40: invokespecial 98	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
          //   43: astore 7
          //   45: aload_0
          //   46: getfield 23	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
          //   49: aload_0
          //   50: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   53: invokevirtual 104	android/graphics/Bitmap:getWidth	()I
          //   56: aload_0
          //   57: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   60: invokevirtual 107	android/graphics/Bitmap:getHeight	()I
          //   63: aload 7
          //   65: aload_0
          //   66: getfield 29	android/support/v4/print/PrintHelperKitkat$1:val$fittingMode	I
          //   69: invokestatic 111	android/support/v4/print/PrintHelperKitkat:access$000	(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
          //   72: astore 7
          //   74: aload 6
          //   76: invokevirtual 115	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
          //   79: aload_0
          //   80: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
          //   83: aload 7
          //   85: aconst_null
          //   86: invokevirtual 121	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
          //   89: aload 5
          //   91: aload 6
          //   93: invokevirtual 125	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
          //   96: aload 5
          //   98: new 127	java/io/FileOutputStream
          //   101: dup
          //   102: aload_2
          //   103: invokevirtual 133	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
          //   106: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
          //   109: invokevirtual 140	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
          //   112: iconst_1
          //   113: anewarray 142	android/print/PageRange
          //   116: astore 6
          //   118: aload 6
          //   120: iconst_0
          //   121: getstatic 146	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
          //   124: aastore
          //   125: aload 4
          //   127: aload 6
          //   129: invokevirtual 152	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
          //   132: aload 5
          //   134: ifnull +8 -> 142
          //   137: aload 5
          //   139: invokevirtual 155	android/print/pdf/PrintedPdfDocument:close	()V
          //   142: aload_2
          //   143: ifnull +7 -> 150
          //   146: aload_2
          //   147: invokevirtual 156	android/os/ParcelFileDescriptor:close	()V
          //   150: return
          //   151: astore 6
          //   153: ldc 158
          //   155: ldc 160
          //   157: aload 6
          //   159: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
          //   162: pop
          //   163: aload 4
          //   165: aconst_null
          //   166: invokevirtual 170	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
          //   169: goto -37 -> 132
          //   172: astore 6
          //   174: aload 5
          //   176: ifnull +8 -> 184
          //   179: aload 5
          //   181: invokevirtual 155	android/print/pdf/PrintedPdfDocument:close	()V
          //   184: aload_2
          //   185: ifnull +7 -> 192
          //   188: aload_2
          //   189: invokevirtual 156	android/os/ParcelFileDescriptor:close	()V
          //   192: aload 6
          //   194: athrow
          //   195: pop
          //   196: goto -46 -> 150
          //   199: pop
          //   200: goto -8 -> 192
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	203	0	this	1
          //   0	203	1	paramAnonymousArrayOfPageRange	android.print.PageRange[]
          //   0	203	2	paramAnonymousParcelFileDescriptor	android.os.ParcelFileDescriptor
          //   0	203	3	paramAnonymousCancellationSignal	CancellationSignal
          //   0	203	4	paramAnonymousWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
          //   18	162	5	localPrintedPdfDocument	android.print.pdf.PrintedPdfDocument
          //   26	102	6	localObject1	Object
          //   151	7	6	localIOException1	java.io.IOException
          //   172	21	6	localObject2	Object
          //   43	41	7	localObject3	Object
          //   195	1	10	localIOException2	java.io.IOException
          //   199	1	11	localIOException3	java.io.IOException
          // Exception table:
          //   from	to	target	type
          //   96	132	151	java/io/IOException
          //   20	96	172	finally
          //   96	132	172	finally
          //   153	169	172	finally
          //   146	150	195	java/io/IOException
          //   188	192	199	java/io/IOException
        }
      }, (PrintAttributes)localObject);
    }
  }
  
  public void printBitmap(final String paramString, final Uri paramUri)
    throws FileNotFoundException
  {
    PrintDocumentAdapter local2 = new PrintDocumentAdapter()
    {
      AsyncTask<Uri, Boolean, Bitmap> loadBitmap;
      private PrintAttributes mAttributes;
      Bitmap mBitmap = null;
      
      private void cancelLoad()
      {
        synchronized (PrintHelperKitkat.this.mLock)
        {
          if (PrintHelperKitkat.this.mDecodeOptions != null)
          {
            PrintHelperKitkat.this.mDecodeOptions.requestCancelDecode();
            PrintHelperKitkat.this.mDecodeOptions = null;
          }
          return;
        }
      }
      
      public void onFinish()
      {
        super.onFinish();
        cancelLoad();
        this.loadBitmap.cancel(true);
      }
      
      public void onLayout(final PrintAttributes paramAnonymousPrintAttributes1, final PrintAttributes paramAnonymousPrintAttributes2, final CancellationSignal paramAnonymousCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        int i = 1;
        if (!paramAnonymousCancellationSignal.isCanceled())
        {
          if (this.mBitmap == null)
          {
            this.loadBitmap = new AsyncTask()
            {
              protected Bitmap doInBackground(Uri... paramAnonymous2VarArgs)
              {
                try
                {
                  localBitmap = PrintHelperKitkat.this.loadConstrainedBitmap(PrintHelperKitkat.2.this.val$imageFile, 3500);
                  localBitmap = localBitmap;
                }
                catch (FileNotFoundException localFileNotFoundException)
                {
                  for (;;)
                  {
                    Bitmap localBitmap = null;
                  }
                }
                return localBitmap;
              }
              
              protected void onCancelled(Bitmap paramAnonymous2Bitmap)
              {
                paramAnonymousLayoutResultCallback.onLayoutCancelled();
              }
              
              protected void onPostExecute(Bitmap paramAnonymous2Bitmap)
              {
                int i = 1;
                super.onPostExecute(paramAnonymous2Bitmap);
                PrintHelperKitkat.2.this.mBitmap = paramAnonymous2Bitmap;
                if (paramAnonymous2Bitmap == null)
                {
                  paramAnonymousLayoutResultCallback.onLayoutFailed(null);
                }
                else
                {
                  PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(PrintHelperKitkat.2.this.val$jobName).setContentType(i).setPageCount(i).build();
                  if (paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {
                    i = 0;
                  }
                  paramAnonymousLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
                }
              }
              
              protected void onPreExecute()
              {
                paramAnonymousCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
                {
                  public void onCancel()
                  {
                    PrintHelperKitkat.2.this.cancelLoad();
                    PrintHelperKitkat.2.1.this.cancel(false);
                  }
                });
              }
            };
            this.loadBitmap.execute(new Uri[0]);
            this.mAttributes = paramAnonymousPrintAttributes2;
          }
          else
          {
            PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(paramString).setContentType(i).setPageCount(i).build();
            if (paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {
              i = 0;
            }
            paramAnonymousLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
          }
        }
        else
        {
          paramAnonymousLayoutResultCallback.onLayoutCancelled();
          this.mAttributes = paramAnonymousPrintAttributes2;
        }
      }
      
      /* Error */
      public void onWrite(android.print.PageRange[] paramAnonymousArrayOfPageRange, android.os.ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        // Byte code:
        //   0: new 126	android/print/pdf/PrintedPdfDocument
        //   3: dup
        //   4: aload_0
        //   5: getfield 30	android/support/v4/print/PrintHelperKitkat$2:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   8: getfield 130	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
        //   11: aload_0
        //   12: getfield 89	android/support/v4/print/PrintHelperKitkat$2:mAttributes	Landroid/print/PrintAttributes;
        //   15: invokespecial 133	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
        //   18: astore 5
        //   20: aload 5
        //   22: iconst_1
        //   23: invokevirtual 137	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
        //   26: astore 6
        //   28: new 139	android/graphics/RectF
        //   31: dup
        //   32: aload 6
        //   34: invokevirtual 145	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
        //   37: invokevirtual 151	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
        //   40: invokespecial 154	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
        //   43: astore 7
        //   45: aload_0
        //   46: getfield 30	android/support/v4/print/PrintHelperKitkat$2:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   49: aload_0
        //   50: getfield 41	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   53: invokevirtual 160	android/graphics/Bitmap:getWidth	()I
        //   56: aload_0
        //   57: getfield 41	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   60: invokevirtual 163	android/graphics/Bitmap:getHeight	()I
        //   63: aload 7
        //   65: aload_0
        //   66: getfield 36	android/support/v4/print/PrintHelperKitkat$2:val$fittingMode	I
        //   69: invokestatic 167	android/support/v4/print/PrintHelperKitkat:access$000	(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
        //   72: astore 7
        //   74: aload 6
        //   76: invokevirtual 171	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
        //   79: aload_0
        //   80: getfield 41	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   83: aload 7
        //   85: aconst_null
        //   86: invokevirtual 177	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
        //   89: aload 5
        //   91: aload 6
        //   93: invokevirtual 181	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
        //   96: aload 5
        //   98: new 183	java/io/FileOutputStream
        //   101: dup
        //   102: aload_2
        //   103: invokevirtual 189	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
        //   106: invokespecial 192	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
        //   109: invokevirtual 196	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
        //   112: iconst_1
        //   113: anewarray 198	android/print/PageRange
        //   116: astore 6
        //   118: aload 6
        //   120: iconst_0
        //   121: getstatic 202	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
        //   124: aastore
        //   125: aload 4
        //   127: aload 6
        //   129: invokevirtual 208	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
        //   132: aload 5
        //   134: ifnull +8 -> 142
        //   137: aload 5
        //   139: invokevirtual 211	android/print/pdf/PrintedPdfDocument:close	()V
        //   142: aload_2
        //   143: ifnull +7 -> 150
        //   146: aload_2
        //   147: invokevirtual 212	android/os/ParcelFileDescriptor:close	()V
        //   150: return
        //   151: astore 6
        //   153: ldc 214
        //   155: ldc 216
        //   157: aload 6
        //   159: invokestatic 222	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   162: pop
        //   163: aload 4
        //   165: aconst_null
        //   166: invokevirtual 226	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
        //   169: goto -37 -> 132
        //   172: astore 6
        //   174: aload 5
        //   176: ifnull +8 -> 184
        //   179: aload 5
        //   181: invokevirtual 211	android/print/pdf/PrintedPdfDocument:close	()V
        //   184: aload_2
        //   185: ifnull +7 -> 192
        //   188: aload_2
        //   189: invokevirtual 212	android/os/ParcelFileDescriptor:close	()V
        //   192: aload 6
        //   194: athrow
        //   195: pop
        //   196: goto -46 -> 150
        //   199: pop
        //   200: goto -8 -> 192
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	203	0	this	2
        //   0	203	1	paramAnonymousArrayOfPageRange	android.print.PageRange[]
        //   0	203	2	paramAnonymousParcelFileDescriptor	android.os.ParcelFileDescriptor
        //   0	203	3	paramAnonymousCancellationSignal	CancellationSignal
        //   0	203	4	paramAnonymousWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
        //   18	162	5	localPrintedPdfDocument	android.print.pdf.PrintedPdfDocument
        //   26	102	6	localObject1	Object
        //   151	7	6	localIOException1	java.io.IOException
        //   172	21	6	localObject2	Object
        //   43	41	7	localObject3	Object
        //   195	1	10	localIOException2	java.io.IOException
        //   199	1	11	localIOException3	java.io.IOException
        // Exception table:
        //   from	to	target	type
        //   96	132	151	java/io/IOException
        //   20	96	172	finally
        //   96	132	172	finally
        //   153	169	172	finally
        //   146	150	195	java/io/IOException
        //   188	192	199	java/io/IOException
      }
    };
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(this.mColorMode);
    if (this.mOrientation != 1)
    {
      if (this.mOrientation == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
    else {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    localPrintManager.print(paramString, local2, localBuilder.build());
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.print.PrintHelperKitkat
 * JD-Core Version:    0.7.0.1
 */