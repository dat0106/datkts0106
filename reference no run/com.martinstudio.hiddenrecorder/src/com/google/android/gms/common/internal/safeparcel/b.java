package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class b
{
  public static int C(Parcel paramParcel)
  {
    return E(paramParcel, 20293);
  }
  
  private static int E(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static void F(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    int j = i - paramInt;
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(j);
    paramParcel.setDataPosition(i);
  }
  
  public static void G(Parcel paramParcel, int paramInt)
  {
    F(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte paramByte)
  {
    b(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void a(Parcel paramParcel, int paramInt, double paramDouble)
  {
    b(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void a(Parcel paramParcel, int paramInt, float paramFloat)
  {
    b(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void a(Parcel paramParcel, int paramInt, long paramLong)
  {
    b(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void a(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle != null)
    {
      int i = E(paramParcel, paramInt);
      paramParcel.writeBundle(paramBundle);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder != null)
    {
      int i = E(paramParcel, paramInt);
      paramParcel.writeStrongBinder(paramIBinder);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean)
  {
    if (paramParcel2 != null)
    {
      int i = E(paramParcel1, paramInt);
      paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
      F(paramParcel1, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel1, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable != null)
    {
      int i = E(paramParcel, paramInt1);
      paramParcelable.writeToParcel(paramParcel, paramInt2);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt1, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1)
  {
    int i = 0;
    if (paramBoolean != null)
    {
      b(paramParcel, paramInt, 4);
      if (paramBoolean.booleanValue()) {
        i = 1;
      }
      paramParcel.writeInt(i);
    }
    else if (paramBoolean1)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if (paramInteger != null)
    {
      b(paramParcel, paramInt, 4);
      paramParcel.writeInt(paramInteger.intValue());
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (paramLong != null)
    {
      b(paramParcel, paramInt, 8);
      paramParcel.writeLong(paramLong.longValue());
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      int i = E(paramParcel, paramInt);
      paramParcel.writeString(paramString);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      int i = E(paramParcel, paramInt);
      paramParcel.writeStringList(paramList);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, short paramShort)
  {
    b(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
  }
  
  public static void a(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    b(paramParcel, paramInt, 4);
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 1;
    }
    paramParcel.writeInt(i);
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      int i = E(paramParcel, paramInt);
      paramParcel.writeByteArray(paramArrayOfByte);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt != null)
    {
      int i = E(paramParcel, paramInt);
      paramParcel.writeIntArray(paramArrayOfInt);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static <T extends Parcelable> void a(Parcel paramParcel, int paramInt1, T[] paramArrayOfT, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfT != null)
    {
      int k = E(paramParcel, paramInt1);
      int j = paramArrayOfT.length;
      paramParcel.writeInt(j);
      for (int i = 0;; i++)
      {
        if (i >= j)
        {
          F(paramParcel, k);
          break;
        }
        T ? = paramArrayOfT[i];
        if (? != null) {
          a(paramParcel, ?, paramInt2);
        } else {
          paramParcel.writeInt(0);
        }
      }
    }
    if (paramBoolean) {
      b(paramParcel, paramInt1, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString != null)
    {
      int i = E(paramParcel, paramInt);
      paramParcel.writeStringArray(paramArrayOfString);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfByte != null)
    {
      int k = E(paramParcel, paramInt);
      int j = paramArrayOfByte.length;
      paramParcel.writeInt(j);
      for (;;)
      {
        if (i >= j)
        {
          F(paramParcel, k);
          break;
        }
        paramParcel.writeByteArray(paramArrayOfByte[i]);
        i++;
      }
    }
    if (paramBoolean) {
      b(paramParcel, paramInt, 0);
    }
  }
  
  private static <T extends Parcelable> void a(Parcel paramParcel, T paramT, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int k = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(j - k);
    paramParcel.setDataPosition(j);
  }
  
  private static void b(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 65535)
    {
      paramParcel.writeInt(paramInt1 | paramInt2 << 16);
    }
    else
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
    }
  }
  
  public static <T extends Parcelable> void b(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      int j = E(paramParcel, paramInt);
      int i = paramList.size();
      paramParcel.writeInt(i);
      for (int k = 0;; k++)
      {
        if (k >= i)
        {
          F(paramParcel, j);
          break;
        }
        Parcelable localParcelable = (Parcelable)paramList.get(k);
        if (localParcelable != null) {
          a(paramParcel, localParcelable, 0);
        } else {
          paramParcel.writeInt(0);
        }
      }
    }
    if (paramBoolean) {
      b(paramParcel, paramInt, 0);
    }
  }
  
  public static void c(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    b(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void c(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      int i = E(paramParcel, paramInt);
      paramParcel.writeList(paramList);
      F(paramParcel, i);
    }
    else if (paramBoolean)
    {
      b(paramParcel, paramInt, 0);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.b
 * JD-Core Version:    0.7.0.1
 */