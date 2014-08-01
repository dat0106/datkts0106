package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents
  implements SafeParcelable
{
  public static final Parcelable.Creator<Contents> CREATOR = new a();
  final ParcelFileDescriptor Fg;
  private boolean HA = false;
  private boolean HB = false;
  final int Hv;
  final DriveId Hw;
  String Hx;
  boolean Hy;
  private boolean Hz = false;
  private boolean mClosed = false;
  final int qX;
  final int xJ;
  
  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, String paramString, boolean paramBoolean)
  {
    this.xJ = paramInt1;
    this.Fg = paramParcelFileDescriptor;
    this.qX = paramInt2;
    this.Hv = paramInt3;
    this.Hw = paramDriveId;
    this.Hx = paramString;
    this.Hy = paramBoolean;
  }
  
  public void close()
  {
    this.mClosed = true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Hw;
  }
  
  public InputStream getInputStream()
  {
    if (!this.mClosed)
    {
      if (this.Hv == 268435456)
      {
        if (!this.Hz)
        {
          this.Hz = true;
          return new FileInputStream(this.Fg.getFileDescriptor());
        }
        throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
      }
      throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
    }
    throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
  }
  
  public int getMode()
  {
    return this.Hv;
  }
  
  public OutputStream getOutputStream()
  {
    if (!this.mClosed)
    {
      if (this.Hv == 536870912)
      {
        if (!this.HA)
        {
          this.HA = true;
          return new FileOutputStream(this.Fg.getFileDescriptor());
        }
        throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
      }
      throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
    }
    throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (!this.mClosed) {
      return this.Fg;
    }
    throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
  }
  
  public int getRequestId()
  {
    return this.qX;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.Contents
 * JD-Core Version:    0.7.0.1
 */