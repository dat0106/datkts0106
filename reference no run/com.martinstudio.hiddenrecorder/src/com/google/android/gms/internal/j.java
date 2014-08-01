package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public abstract class j
  extends i
{
  private static Method jS;
  private static Method jT;
  private static Method jU;
  private static Method jV;
  private static Method jW;
  private static Method jX;
  private static String jY;
  private static p jZ;
  static boolean ka = false;
  private static long startTime = 0L;
  
  protected j(Context paramContext, n paramn, o paramo)
  {
    super(paramContext, paramn, paramo);
  }
  
  static String a(Context paramContext, n paramn)
    throws j.a
  {
    if (jU == null) {
      throw new a();
    }
    try
    {
      Object localObject = jU;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      localObject = (ByteBuffer)((Method)localObject).invoke(null, arrayOfObject);
      if (localObject == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
      String str = paramn.a(localIllegalAccessException.array(), true);
      return str;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }
  
  static ArrayList<Long> a(MotionEvent paramMotionEvent, DisplayMetrics paramDisplayMetrics)
    throws j.a
  {
    if ((jV == null) || (paramMotionEvent == null)) {
      throw new a();
    }
    try
    {
      Method localMethod = jV;
      Object localObject = new Object[2];
      localObject[0] = paramMotionEvent;
      localObject[1] = paramDisplayMetrics;
      localObject = (ArrayList)localMethod.invoke(null, (Object[])localObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  protected static void a(String paramString, Context paramContext, n paramn)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 30	com/google/android/gms/internal/j:ka	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +36 -> 44
    //   11: new 75	com/google/android/gms/internal/p
    //   14: dup
    //   15: aload_2
    //   16: aconst_null
    //   17: invokespecial 78	com/google/android/gms/internal/p:<init>	(Lcom/google/android/gms/internal/n;Ljava/security/SecureRandom;)V
    //   20: putstatic 80	com/google/android/gms/internal/j:jZ	Lcom/google/android/gms/internal/p;
    //   23: aload_0
    //   24: putstatic 82	com/google/android/gms/internal/j:jY	Ljava/lang/String;
    //   27: aload_1
    //   28: invokestatic 86	com/google/android/gms/internal/j:e	(Landroid/content/Context;)V
    //   31: invokestatic 90	com/google/android/gms/internal/j:w	()Ljava/lang/Long;
    //   34: invokevirtual 96	java/lang/Long:longValue	()J
    //   37: putstatic 28	com/google/android/gms/internal/j:startTime	J
    //   40: iconst_1
    //   41: putstatic 30	com/google/android/gms/internal/j:ka	Z
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: astore_3
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_3
    //   53: athrow
    //   54: pop
    //   55: goto -11 -> 44
    //   58: pop
    //   59: goto -15 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramString	String
    //   0	62	1	paramContext	Context
    //   0	62	2	paramn	n
    //   6	2	3	bool	boolean
    //   48	5	3	localObject	Object
    //   54	1	5	localUnsupportedOperationException	java.lang.UnsupportedOperationException
    //   58	1	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   3	7	48	finally
    //   11	44	48	finally
    //   11	44	54	java/lang/UnsupportedOperationException
    //   11	44	58	com/google/android/gms/internal/j$a
  }
  
  static String b(Context paramContext, n paramn)
    throws j.a
  {
    if (jX == null) {
      throw new a();
    }
    try
    {
      Method localMethod = jX;
      Object localObject = new Object[1];
      localObject[0] = paramContext;
      localObject = (ByteBuffer)localMethod.invoke(null, (Object[])localObject);
      if (localObject == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
      String str = paramn.a(localIllegalAccessException.array(), true);
      return str;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }
  
  private static String b(byte[] paramArrayOfByte, String paramString)
    throws j.a
  {
    try
    {
      String str = new String(jZ.c(paramArrayOfByte, paramString), "UTF-8");
      return str;
    }
    catch (p.a locala)
    {
      throw new a(locala);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new a(localUnsupportedEncodingException);
    }
  }
  
  static String d(Context paramContext)
    throws j.a
  {
    if (jW == null) {
      throw new a();
    }
    try
    {
      Object localObject = jW;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      localObject = (String)((Method)localObject).invoke(null, arrayOfObject);
      if (localObject == null) {
        throw new a();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
    return localInvocationTargetException;
  }
  
  private static void e(Context paramContext)
    throws j.a
  {
    try
    {
      localObject1 = jZ.b(r.getKey());
      localObject2 = jZ.c((byte[])localObject1, r.A());
      File localFile1 = paramContext.getCacheDir();
      if (localFile1 == null)
      {
        localFile1 = paramContext.getDir("dex", 0);
        if (localFile1 == null) {
          throw new a();
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      throw new a(localFileNotFoundException);
      File localFile2 = File.createTempFile("ads", ".jar", localFileNotFoundException);
      Object localObject3 = new FileOutputStream(localFile2);
      ((FileOutputStream)localObject3).write((byte[])localObject2, 0, localObject2.length);
      ((FileOutputStream)localObject3).close();
      Object localObject2 = new DexClassLoader(localFile2.getAbsolutePath(), localFileNotFoundException.getAbsolutePath(), null, paramContext.getClassLoader());
      Object localObject7 = ((DexClassLoader)localObject2).loadClass(b((byte[])localObject1, r.B()));
      Object localObject6 = ((DexClassLoader)localObject2).loadClass(b((byte[])localObject1, r.H()));
      Object localObject5 = ((DexClassLoader)localObject2).loadClass(b((byte[])localObject1, r.F()));
      Object localObject4 = ((DexClassLoader)localObject2).loadClass(b((byte[])localObject1, r.L()));
      localObject3 = ((DexClassLoader)localObject2).loadClass(b((byte[])localObject1, r.D()));
      localObject2 = ((DexClassLoader)localObject2).loadClass(b((byte[])localObject1, r.J()));
      jS = ((Class)localObject7).getMethod(b((byte[])localObject1, r.C()), new Class[0]);
      jT = ((Class)localObject6).getMethod(b((byte[])localObject1, r.I()), new Class[0]);
      localObject7 = b((byte[])localObject1, r.G());
      localObject6 = new Class[1];
      localObject6[0] = Context.class;
      jU = ((Class)localObject5).getMethod((String)localObject7, (Class[])localObject6);
      localObject5 = b((byte[])localObject1, r.M());
      localObject6 = new Class[2];
      localObject6[0] = MotionEvent.class;
      localObject6[1] = DisplayMetrics.class;
      jV = ((Class)localObject4).getMethod((String)localObject5, (Class[])localObject6);
      localObject4 = b((byte[])localObject1, r.E());
      localObject5 = new Class[1];
      localObject5[0] = Context.class;
      jW = ((Class)localObject3).getMethod((String)localObject4, (Class[])localObject5);
      localObject3 = b((byte[])localObject1, r.K());
      Object localObject1 = new Class[1];
      localObject1[0] = Context.class;
      jX = ((Class)localObject2).getMethod((String)localObject3, (Class[])localObject1);
      localObject1 = localFile2.getName();
      localFile2.delete();
      new File(localFileNotFoundException, ((String)localObject1).replace(".jar", ".dex")).delete();
      return;
    }
    catch (IOException localIOException)
    {
      throw new a(localIOException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new a(localClassNotFoundException);
    }
    catch (p.a locala)
    {
      throw new a(locala);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new a(localNoSuchMethodException);
    }
    catch (NullPointerException localNullPointerException)
    {
      throw new a(localNullPointerException);
    }
  }
  
  static String v()
    throws j.a
  {
    if (jY != null) {
      return jY;
    }
    throw new a();
  }
  
  static Long w()
    throws j.a
  {
    if (jS == null) {
      throw new a();
    }
    try
    {
      Long localLong = (Long)jS.invoke(null, new Object[0]);
      return localLong;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }
  
  static String x()
    throws j.a
  {
    if (jT == null) {
      throw new a();
    }
    try
    {
      String str = (String)jT.invoke(null, new Object[0]);
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new a(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new a(localInvocationTargetException);
    }
  }
  
  /* Error */
  protected void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokestatic 262	com/google/android/gms/internal/j:x	()Ljava/lang/String;
    //   5: invokevirtual 265	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_2
    //   10: invokestatic 267	com/google/android/gms/internal/j:v	()Ljava/lang/String;
    //   13: invokevirtual 265	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   16: aload_0
    //   17: bipush 25
    //   19: invokestatic 90	com/google/android/gms/internal/j:w	()Ljava/lang/Long;
    //   22: invokevirtual 96	java/lang/Long:longValue	()J
    //   25: invokevirtual 270	com/google/android/gms/internal/j:a	(IJ)V
    //   28: aload_0
    //   29: bipush 24
    //   31: aload_1
    //   32: invokestatic 272	com/google/android/gms/internal/j:d	(Landroid/content/Context;)Ljava/lang/String;
    //   35: invokevirtual 265	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   38: return
    //   39: pop
    //   40: goto -2 -> 38
    //   43: pop
    //   44: goto -6 -> 38
    //   47: pop
    //   48: goto -20 -> 28
    //   51: pop
    //   52: goto -36 -> 16
    //   55: pop
    //   56: goto -48 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	j
    //   0	59	1	paramContext	Context
    //   39	1	2	localIOException	IOException
    //   43	1	3	locala1	a
    //   47	1	4	locala2	a
    //   51	1	5	locala3	a
    //   55	1	6	locala4	a
    // Exception table:
    //   from	to	target	type
    //   0	8	39	java/io/IOException
    //   8	16	39	java/io/IOException
    //   16	28	39	java/io/IOException
    //   28	38	39	java/io/IOException
    //   28	38	43	com/google/android/gms/internal/j$a
    //   16	28	47	com/google/android/gms/internal/j$a
    //   8	16	51	com/google/android/gms/internal/j$a
    //   0	8	55	com/google/android/gms/internal/j$a
  }
  
  /* Error */
  protected void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokestatic 267	com/google/android/gms/internal/j:v	()Ljava/lang/String;
    //   5: invokevirtual 265	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 262	com/google/android/gms/internal/j:x	()Ljava/lang/String;
    //   13: invokevirtual 265	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   16: invokestatic 90	com/google/android/gms/internal/j:w	()Ljava/lang/Long;
    //   19: invokevirtual 96	java/lang/Long:longValue	()J
    //   22: lstore_2
    //   23: aload_0
    //   24: bipush 25
    //   26: lload_2
    //   27: invokevirtual 270	com/google/android/gms/internal/j:a	(IJ)V
    //   30: getstatic 28	com/google/android/gms/internal/j:startTime	J
    //   33: ldc2_w 25
    //   36: lcmp
    //   37: ifeq +23 -> 60
    //   40: aload_0
    //   41: bipush 17
    //   43: lload_2
    //   44: getstatic 28	com/google/android/gms/internal/j:startTime	J
    //   47: lsub
    //   48: invokevirtual 270	com/google/android/gms/internal/j:a	(IJ)V
    //   51: aload_0
    //   52: bipush 23
    //   54: getstatic 28	com/google/android/gms/internal/j:startTime	J
    //   57: invokevirtual 270	com/google/android/gms/internal/j:a	(IJ)V
    //   60: aload_0
    //   61: getfield 276	com/google/android/gms/internal/j:jO	Landroid/view/MotionEvent;
    //   64: aload_0
    //   65: getfield 280	com/google/android/gms/internal/j:jP	Landroid/util/DisplayMetrics;
    //   68: invokestatic 282	com/google/android/gms/internal/j:a	(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
    //   71: astore_2
    //   72: aload_0
    //   73: bipush 14
    //   75: aload_2
    //   76: iconst_0
    //   77: invokevirtual 286	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   80: checkcast 92	java/lang/Long
    //   83: invokevirtual 96	java/lang/Long:longValue	()J
    //   86: invokevirtual 270	com/google/android/gms/internal/j:a	(IJ)V
    //   89: aload_0
    //   90: bipush 15
    //   92: aload_2
    //   93: iconst_1
    //   94: invokevirtual 286	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   97: checkcast 92	java/lang/Long
    //   100: invokevirtual 96	java/lang/Long:longValue	()J
    //   103: invokevirtual 270	com/google/android/gms/internal/j:a	(IJ)V
    //   106: aload_2
    //   107: invokevirtual 290	java/util/ArrayList:size	()I
    //   110: iconst_3
    //   111: if_icmplt +20 -> 131
    //   114: aload_0
    //   115: bipush 16
    //   117: aload_2
    //   118: iconst_2
    //   119: invokevirtual 286	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   122: checkcast 92	java/lang/Long
    //   125: invokevirtual 96	java/lang/Long:longValue	()J
    //   128: invokevirtual 270	com/google/android/gms/internal/j:a	(IJ)V
    //   131: aload_0
    //   132: bipush 27
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 294	com/google/android/gms/internal/j:jQ	Lcom/google/android/gms/internal/n;
    //   139: invokestatic 296	com/google/android/gms/internal/j:a	(Landroid/content/Context;Lcom/google/android/gms/internal/n;)Ljava/lang/String;
    //   142: invokevirtual 265	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   145: aload_0
    //   146: bipush 29
    //   148: aload_1
    //   149: aload_0
    //   150: getfield 294	com/google/android/gms/internal/j:jQ	Lcom/google/android/gms/internal/n;
    //   153: invokestatic 298	com/google/android/gms/internal/j:b	(Landroid/content/Context;Lcom/google/android/gms/internal/n;)Ljava/lang/String;
    //   156: invokevirtual 265	com/google/android/gms/internal/j:a	(ILjava/lang/String;)V
    //   159: return
    //   160: pop
    //   161: goto -2 -> 159
    //   164: pop
    //   165: goto -6 -> 159
    //   168: pop
    //   169: goto -24 -> 145
    //   172: pop
    //   173: goto -42 -> 131
    //   176: pop
    //   177: goto -117 -> 60
    //   180: pop
    //   181: goto -165 -> 16
    //   184: pop
    //   185: goto -177 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	j
    //   0	188	1	paramContext	Context
    //   22	22	2	l	long
    //   71	47	2	localArrayList	ArrayList
    //   160	1	4	localIOException	IOException
    //   164	1	5	locala1	a
    //   168	1	6	locala2	a
    //   172	1	7	locala3	a
    //   176	1	8	locala4	a
    //   180	1	9	locala5	a
    //   184	1	10	locala6	a
    // Exception table:
    //   from	to	target	type
    //   0	8	160	java/io/IOException
    //   8	16	160	java/io/IOException
    //   16	60	160	java/io/IOException
    //   60	131	160	java/io/IOException
    //   131	145	160	java/io/IOException
    //   145	159	160	java/io/IOException
    //   145	159	164	com/google/android/gms/internal/j$a
    //   131	145	168	com/google/android/gms/internal/j$a
    //   60	131	172	com/google/android/gms/internal/j$a
    //   16	60	176	com/google/android/gms/internal/j$a
    //   8	16	180	com/google/android/gms/internal/j$a
    //   0	8	184	com/google/android/gms/internal/j$a
  }
  
  static class a
    extends Exception
  {
    public a() {}
    
    public a(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.j
 * JD-Core Version:    0.7.0.1
 */