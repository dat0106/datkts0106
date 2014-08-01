package android.support.v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile
{
  private final File mBackupName;
  private final File mBaseName;
  
  public AtomicFile(File paramFile)
  {
    this.mBaseName = paramFile;
    this.mBackupName = new File(paramFile.getPath() + ".bak");
  }
  
  static boolean sync(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {}
    try
    {
      paramFileOutputStream.getFD().sync();
      bool = true;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public void delete()
  {
    this.mBaseName.delete();
    this.mBackupName.delete();
  }
  
  public void failWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {
      sync(paramFileOutputStream);
    }
    try
    {
      paramFileOutputStream.close();
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("AtomicFile", "failWrite: Got exception:", localIOException);
      }
    }
  }
  
  public void finishWrite(FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream != null) {
      sync(paramFileOutputStream);
    }
    try
    {
      paramFileOutputStream.close();
      this.mBackupName.delete();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("AtomicFile", "finishWrite: Got exception:", localIOException);
      }
    }
  }
  
  public File getBaseFile()
  {
    return this.mBaseName;
  }
  
  public FileInputStream openRead()
    throws FileNotFoundException
  {
    if (this.mBackupName.exists())
    {
      this.mBaseName.delete();
      this.mBackupName.renameTo(this.mBaseName);
    }
    return new FileInputStream(this.mBaseName);
  }
  
  /* Error */
  public byte[] readFully()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 96	android/support/v4/util/AtomicFile:openRead	()Ljava/io/FileInputStream;
    //   4: astore_1
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_1
    //   8: invokevirtual 100	java/io/FileInputStream:available	()I
    //   11: newarray byte
    //   13: astore_2
    //   14: aload_1
    //   15: aload_2
    //   16: iload_3
    //   17: aload_2
    //   18: arraylength
    //   19: iload_3
    //   20: isub
    //   21: invokevirtual 104	java/io/FileInputStream:read	([BII)I
    //   24: istore 4
    //   26: iload 4
    //   28: ifgt +9 -> 37
    //   31: aload_1
    //   32: invokevirtual 105	java/io/FileInputStream:close	()V
    //   35: aload_2
    //   36: areturn
    //   37: iload_3
    //   38: iload 4
    //   40: iadd
    //   41: istore_3
    //   42: aload_1
    //   43: invokevirtual 100	java/io/FileInputStream:available	()I
    //   46: istore 4
    //   48: iload 4
    //   50: aload_2
    //   51: arraylength
    //   52: iload_3
    //   53: isub
    //   54: if_icmple -40 -> 14
    //   57: iload_3
    //   58: iload 4
    //   60: iadd
    //   61: newarray byte
    //   63: astore 4
    //   65: aload_2
    //   66: iconst_0
    //   67: aload 4
    //   69: iconst_0
    //   70: iload_3
    //   71: invokestatic 111	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   74: aload 4
    //   76: astore_2
    //   77: goto -63 -> 14
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 105	java/io/FileInputStream:close	()V
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	AtomicFile
    //   4	78	1	localFileInputStream	FileInputStream
    //   13	64	2	localObject1	Object
    //   80	6	2	localObject2	Object
    //   6	65	3	i	int
    //   24	37	4	j	int
    //   63	12	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   7	26	80	finally
    //   42	74	80	finally
  }
  
  public FileOutputStream startWrite()
    throws IOException
  {
    if (this.mBaseName.exists())
    {
      if (this.mBackupName.exists()) {
        break label88;
      }
      if (!this.mBaseName.renameTo(this.mBackupName)) {
        Log.w("AtomicFile", "Couldn't rename file " + this.mBaseName + " to backup file " + this.mBackupName);
      }
    }
    try
    {
      for (;;)
      {
        localFileOutputStream = new FileOutputStream(this.mBaseName);
        return localFileOutputStream;
        label88:
        this.mBaseName.delete();
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        FileOutputStream localFileOutputStream;
        if (!this.mBaseName.getParentFile().mkdir()) {
          throw new IOException("Couldn't create directory " + this.mBaseName);
        }
        try
        {
          localFileOutputStream = new FileOutputStream(this.mBaseName);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          throw new IOException("Couldn't create " + this.mBaseName);
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.AtomicFile
 * JD-Core Version:    0.7.0.1
 */