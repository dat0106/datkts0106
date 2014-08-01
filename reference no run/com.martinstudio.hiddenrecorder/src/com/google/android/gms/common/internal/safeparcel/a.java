package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class a
{
  public static int A(Parcel paramParcel)
  {
    return paramParcel.readInt();
  }
  
  public static String[] A(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    String[] arrayOfString;
    if (i != 0)
    {
      arrayOfString = paramParcel.createStringArray();
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      arrayOfString = null;
    }
    return arrayOfString;
  }
  
  public static int B(Parcel paramParcel)
  {
    int j = A(paramParcel);
    int k = a(paramParcel, j);
    int i = paramParcel.dataPosition();
    if (ar(j) == 20293)
    {
      j = i + k;
      if ((j >= i) && (j <= paramParcel.dataSize())) {
        return j;
      }
      throw new a("Size read is invalid start=" + i + " end=" + j, paramParcel);
    }
    throw new a("Expected object header. Got 0x" + Integer.toHexString(j), paramParcel);
  }
  
  public static ArrayList<String> B(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    ArrayList localArrayList;
    if (i != 0)
    {
      localArrayList = paramParcel.createStringArrayList();
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      localArrayList = null;
    }
    return localArrayList;
  }
  
  public static Parcel C(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    Parcel localParcel;
    if (i != 0)
    {
      localParcel = Parcel.obtain();
      localParcel.appendFrom(paramParcel, j, i);
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      localParcel = null;
    }
    return localParcel;
  }
  
  public static Parcel[] D(Parcel paramParcel, int paramInt)
  {
    Object localObject = null;
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    int i1;
    Parcel[] arrayOfParcel;
    if (i != 0)
    {
      i1 = paramParcel.readInt();
      arrayOfParcel = new Parcel[i1];
    }
    for (int n = 0;; n++)
    {
      if (n >= i1)
      {
        paramParcel.setDataPosition(j + i);
        localObject = arrayOfParcel;
        return localObject;
      }
      int k = paramParcel.readInt();
      if (k == 0)
      {
        arrayOfParcel[n] = null;
      }
      else
      {
        int m = paramParcel.dataPosition();
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, m, k);
        arrayOfParcel[n] = localParcel;
        paramParcel.setDataPosition(k + m);
      }
    }
  }
  
  public static int a(Parcel paramParcel, int paramInt)
  {
    int i;
    if ((paramInt & 0xFFFF0000) == -65536) {
      i = paramParcel.readInt();
    } else {
      i = 0xFFFF & paramInt >> 16;
    }
    return i;
  }
  
  public static <T extends Parcelable> T a(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    Parcelable localParcelable;
    if (i != 0)
    {
      localParcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      localParcelable = null;
    }
    return localParcelable;
  }
  
  private static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    int i = a(paramParcel, paramInt1);
    if (i == paramInt2) {
      return;
    }
    throw new a("Expected size " + paramInt2 + " got " + i + " (0x" + Integer.toHexString(i) + ")", paramParcel);
  }
  
  private static void a(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == paramInt3) {
      return;
    }
    throw new a("Expected size " + paramInt3 + " got " + paramInt2 + " (0x" + Integer.toHexString(paramInt2) + ")", paramParcel);
  }
  
  public static void a(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    int j = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (j != 0)
    {
      paramParcel.readList(paramList, paramClassLoader);
      paramParcel.setDataPosition(j + i);
    }
  }
  
  public static int ar(int paramInt)
  {
    return 0xFFFF & paramInt;
  }
  
  public static void b(Parcel paramParcel, int paramInt)
  {
    paramParcel.setDataPosition(a(paramParcel, paramInt) + paramParcel.dataPosition());
  }
  
  public static <T> T[] b(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int j = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    Object[] arrayOfObject;
    if (j != 0)
    {
      arrayOfObject = paramParcel.createTypedArray(paramCreator);
      paramParcel.setDataPosition(j + i);
    }
    else
    {
      arrayOfObject = null;
    }
    return arrayOfObject;
  }
  
  public static <T> ArrayList<T> c(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    ArrayList localArrayList;
    if (i != 0)
    {
      localArrayList = paramParcel.createTypedArrayList(paramCreator);
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      localArrayList = null;
    }
    return localArrayList;
  }
  
  public static boolean c(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    boolean bool;
    if (paramParcel.readInt() == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static Boolean d(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    Boolean localBoolean;
    if (i != 0)
    {
      a(paramParcel, paramInt, i, 4);
      if (paramParcel.readInt() == 0) {
        i = 0;
      } else {
        i = 1;
      }
      localBoolean = Boolean.valueOf(i);
    }
    else
    {
      localBoolean = null;
    }
    return localBoolean;
  }
  
  public static byte e(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static short f(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static int g(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static Integer h(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    Integer localInteger;
    if (i != 0)
    {
      a(paramParcel, paramInt, i, 4);
      localInteger = Integer.valueOf(paramParcel.readInt());
    }
    else
    {
      localInteger = null;
    }
    return localInteger;
  }
  
  public static long i(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static Long j(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    Long localLong;
    if (i != 0)
    {
      a(paramParcel, paramInt, i, 8);
      localLong = Long.valueOf(paramParcel.readLong());
    }
    else
    {
      localLong = null;
    }
    return localLong;
  }
  
  public static BigInteger k(Parcel paramParcel, int paramInt)
  {
    int j = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    BigInteger localBigInteger;
    if (j != 0)
    {
      byte[] arrayOfByte = paramParcel.createByteArray();
      paramParcel.setDataPosition(j + i);
      localBigInteger = new BigInteger(arrayOfByte);
    }
    else
    {
      localBigInteger = null;
    }
    return localBigInteger;
  }
  
  public static float l(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static double m(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static BigDecimal n(Parcel paramParcel, int paramInt)
  {
    int j = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    Object localObject;
    if (j != 0)
    {
      localObject = paramParcel.createByteArray();
      int k = paramParcel.readInt();
      paramParcel.setDataPosition(j + i);
      localObject = new BigDecimal(new BigInteger((byte[])localObject), k);
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public static String o(Parcel paramParcel, int paramInt)
  {
    int j = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    String str;
    if (j != 0)
    {
      str = paramParcel.readString();
      paramParcel.setDataPosition(j + i);
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  public static IBinder p(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    IBinder localIBinder;
    if (i != 0)
    {
      localIBinder = paramParcel.readStrongBinder();
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      localIBinder = null;
    }
    return localIBinder;
  }
  
  public static Bundle q(Parcel paramParcel, int paramInt)
  {
    int j = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    Bundle localBundle;
    if (j != 0)
    {
      localBundle = paramParcel.readBundle();
      paramParcel.setDataPosition(j + i);
    }
    else
    {
      localBundle = null;
    }
    return localBundle;
  }
  
  public static byte[] r(Parcel paramParcel, int paramInt)
  {
    int j = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    byte[] arrayOfByte;
    if (j != 0)
    {
      arrayOfByte = paramParcel.createByteArray();
      paramParcel.setDataPosition(j + i);
    }
    else
    {
      arrayOfByte = null;
    }
    return arrayOfByte;
  }
  
  public static byte[][] s(Parcel paramParcel, int paramInt)
  {
    int k = a(paramParcel, paramInt);
    int m = paramParcel.dataPosition();
    if (k != 0)
    {
      int i = paramParcel.readInt();
      localObject = new byte[i][];
      for (int j = 0;; j++)
      {
        if (j >= i)
        {
          paramParcel.setDataPosition(m + k);
          break;
        }
        localObject[j] = paramParcel.createByteArray();
      }
    }
    Object localObject = (byte[][])null;
    return localObject;
  }
  
  public static boolean[] t(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    boolean[] arrayOfBoolean;
    if (i != 0)
    {
      arrayOfBoolean = paramParcel.createBooleanArray();
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      arrayOfBoolean = null;
    }
    return arrayOfBoolean;
  }
  
  public static int[] u(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    int[] arrayOfInt;
    if (i != 0)
    {
      arrayOfInt = paramParcel.createIntArray();
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      arrayOfInt = null;
    }
    return arrayOfInt;
  }
  
  public static long[] v(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    long[] arrayOfLong;
    if (i != 0)
    {
      arrayOfLong = paramParcel.createLongArray();
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      arrayOfLong = null;
    }
    return arrayOfLong;
  }
  
  public static BigInteger[] w(Parcel paramParcel, int paramInt)
  {
    int k = a(paramParcel, paramInt);
    int m = paramParcel.dataPosition();
    if (k != 0)
    {
      int j = paramParcel.readInt();
      arrayOfBigInteger = new BigInteger[j];
      for (int i = 0;; i++)
      {
        if (i >= j)
        {
          paramParcel.setDataPosition(m + k);
          break;
        }
        arrayOfBigInteger[i] = new BigInteger(paramParcel.createByteArray());
      }
    }
    BigInteger[] arrayOfBigInteger = null;
    return arrayOfBigInteger;
  }
  
  public static float[] x(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    float[] arrayOfFloat;
    if (i != 0)
    {
      arrayOfFloat = paramParcel.createFloatArray();
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      arrayOfFloat = null;
    }
    return arrayOfFloat;
  }
  
  public static double[] y(Parcel paramParcel, int paramInt)
  {
    int i = a(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    double[] arrayOfDouble;
    if (i != 0)
    {
      arrayOfDouble = paramParcel.createDoubleArray();
      paramParcel.setDataPosition(i + j);
    }
    else
    {
      arrayOfDouble = null;
    }
    return arrayOfDouble;
  }
  
  public static BigDecimal[] z(Parcel paramParcel, int paramInt)
  {
    int n = a(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (n != 0)
    {
      int j = paramParcel.readInt();
      arrayOfBigDecimal = new BigDecimal[j];
      for (int m = 0;; m++)
      {
        if (m >= j)
        {
          paramParcel.setDataPosition(i + n);
          break;
        }
        byte[] arrayOfByte = paramParcel.createByteArray();
        int k = paramParcel.readInt();
        arrayOfBigDecimal[m] = new BigDecimal(new BigInteger(arrayOfByte), k);
      }
    }
    BigDecimal[] arrayOfBigDecimal = null;
    return arrayOfBigDecimal;
  }
  
  public static class a
    extends RuntimeException
  {
    public a(String paramString, Parcel paramParcel)
    {
      super();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.a
 * JD-Core Version:    0.7.0.1
 */