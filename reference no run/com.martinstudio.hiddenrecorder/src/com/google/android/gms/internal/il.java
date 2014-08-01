package com.google.android.gms.internal;

import android.database.CharArrayBuffer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class il
{
  public static byte[] a(InputStream paramInputStream, boolean paramBoolean)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[10000];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      if (!paramBoolean) {
        break label56;
      }
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
    paramInputStream.close();
    label56:
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static void b(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    if ((paramCharArrayBuffer.data != null) && (paramCharArrayBuffer.data.length >= paramString.length())) {
      paramString.getChars(0, paramString.length(), paramCharArrayBuffer.data, 0);
    } else {
      paramCharArrayBuffer.data = paramString.toCharArray();
    }
    paramCharArrayBuffer.sizeCopied = paramString.length();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.il
 * JD-Core Version:    0.7.0.1
 */