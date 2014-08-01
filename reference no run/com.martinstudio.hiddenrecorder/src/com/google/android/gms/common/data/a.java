package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class a
  implements SafeParcelable
{
  public static final Parcelable.Creator<a> CREATOR = new b();
  final int AQ;
  ParcelFileDescriptor Et;
  private Bitmap Eu;
  private boolean Ev;
  private File Ew;
  final int xJ;
  
  a(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    this.xJ = paramInt1;
    this.Et = paramParcelFileDescriptor;
    this.AQ = paramInt2;
    this.Eu = null;
    this.Ev = false;
  }
  
  public a(Bitmap paramBitmap)
  {
    this.xJ = 1;
    this.Et = null;
    this.AQ = 0;
    this.Eu = paramBitmap;
    this.Ev = true;
  }
  
  private void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("BitmapTeleporter", "Could not close stream", localIOException);
      }
    }
  }
  
  /* Error */
  private java.io.FileOutputStream eO()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/google/android/gms/common/data/a:Ew	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 69	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 71
    //   13: invokespecial 74	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 76
    //   19: ldc 78
    //   21: aload_0
    //   22: getfield 67	com/google/android/gms/common/data/a:Ew	Ljava/io/File;
    //   25: invokestatic 84	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_1
    //   29: new 86	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_0
    //   39: aload_1
    //   40: ldc 90
    //   42: invokestatic 96	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 35	com/google/android/gms/common/data/a:Et	Landroid/os/ParcelFileDescriptor;
    //   48: aload_1
    //   49: invokevirtual 100	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: new 69	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 102
    //   62: aload_1
    //   63: invokespecial 105	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: pop
    //   68: new 69	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 107
    //   74: invokespecial 74	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	a
    //   28	21	1	localFile	File
    //   55	8	1	localIOException	IOException
    //   37	17	2	localFileOutputStream	java.io.FileOutputStream
    //   67	1	4	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }
  
  public void a(File paramFile)
  {
    if (paramFile != null)
    {
      this.Ew = paramFile;
      return;
    }
    throw new NullPointerException("Cannot set null temp directory");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap eN()
  {
    Object localObject1;
    if (!this.Ev) {
      localObject1 = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.Et));
    }
    try
    {
      byte[] arrayOfByte = new byte[((DataInputStream)localObject1).readInt()];
      int j = ((DataInputStream)localObject1).readInt();
      int i = ((DataInputStream)localObject1).readInt();
      Bitmap.Config localConfig = Bitmap.Config.valueOf(((DataInputStream)localObject1).readUTF());
      ((DataInputStream)localObject1).read(arrayOfByte);
      a((Closeable)localObject1);
      localObject1 = ByteBuffer.wrap(arrayOfByte);
      Bitmap localBitmap = Bitmap.createBitmap(j, i, localConfig);
      localBitmap.copyPixelsFromBuffer((Buffer)localObject1);
      this.Eu = localBitmap;
      this.Ev = true;
      return this.Eu;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Could not read from parcel file descriptor", localIOException);
    }
    finally
    {
      a((Closeable)localObject1);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    Object localObject1;
    byte[] arrayOfByte;
    if (this.Et == null)
    {
      localBitmap = this.Eu;
      localObject1 = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer((Buffer)localObject1);
      arrayOfByte = ((ByteBuffer)localObject1).array();
      localObject1 = new DataOutputStream(eO());
    }
    try
    {
      ((DataOutputStream)localObject1).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject1).writeInt(localBitmap.getWidth());
      ((DataOutputStream)localObject1).writeInt(localBitmap.getHeight());
      ((DataOutputStream)localObject1).writeUTF(localBitmap.getConfig().toString());
      ((DataOutputStream)localObject1).write(arrayOfByte);
      a((Closeable)localObject1);
      b.a(this, paramParcel, paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Could not write into unlinked file", localIOException);
    }
    finally
    {
      a((Closeable)localObject1);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.a
 * JD-Core Version:    0.7.0.1
 */