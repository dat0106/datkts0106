package com.sonyericsson.extras.liveware.asf;

import android.os.Bundle;
import com.sonyericsson.extras.liveware.service.BtPacket;
import com.sonyericsson.extras.liveware.utils.Dbg;

public abstract class AsfPacket
  extends BtPacket
{
  public static final String METADATA_ADDRESS = "Address";
  public byte[] data;
  public byte feature;
  public byte frame;
  public byte[] identifier;
  public int length;
  private Bundle mMetaData = null;
  public byte type;
  
  protected AsfPacket(byte paramByte1, byte paramByte2)
  {
    if (Dbg.v()) {
      Dbg.v("Asf packet created with feature = " + paramByte1 + "and frame = " + paramByte2);
    }
    this.feature = paramByte1;
    this.frame = paramByte2;
    this.type = 0;
    this.data = null;
    this.length = 0;
  }
  
  protected AsfPacket(byte paramByte1, byte paramByte2, byte paramByte3, int paramInt, byte[] paramArrayOfByte)
  {
    if (Dbg.v()) {
      Dbg.v("Asf packet created with feature = " + paramByte1 + ",frame = " + paramByte2 + "type = " + paramByte3 + ", length = " + paramInt);
    }
    this.feature = paramByte1;
    this.frame = paramByte2;
    this.type = paramByte3;
    this.length = paramInt;
    this.data = paramArrayOfByte;
  }
  
  protected AsfPacket(byte[] paramArrayOfByte)
    throws Exception
  {
    if (Dbg.v()) {
      Dbg.v("Parse incomming header");
    }
    if (paramArrayOfByte.length == 8)
    {
      this.feature = paramArrayOfByte[3];
      this.type = paramArrayOfByte[4];
      this.frame = paramArrayOfByte[5];
      this.length = unsignedShortToInt(paramArrayOfByte);
      if (this.length >= 0) {
        return;
      }
      throw new IllegalArgumentException("Invalid Header: length was = " + this.length);
    }
    throw new IllegalArgumentException("Invalid Header size. Is: " + paramArrayOfByte.length + ". Should be " + 8);
  }
  
  protected AsfPacket(byte[] paramArrayOfByte, int paramInt)
    throws Exception
  {
    if (Dbg.v()) {
      Dbg.v("Parse incomming data");
    }
    if (validateHeader(paramInt))
    {
      this.feature = paramArrayOfByte[3];
      this.type = paramArrayOfByte[4];
      this.frame = paramArrayOfByte[5];
      this.length = unsignedShortToInt(paramArrayOfByte);
      this.data = extractData(paramArrayOfByte, this.length);
      if (Dbg.v()) {
        Dbg.v("Packet after construction: " + meToString());
      }
      return;
    }
    throw new IllegalArgumentException("Invalid Header");
  }
  
  private byte[] extractData(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte;
    if (paramInt > 0)
    {
      arrayOfByte = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, 8, arrayOfByte, 0, paramInt);
    }
    else
    {
      arrayOfByte = null;
    }
    return arrayOfByte;
  }
  
  private byte[] intToByteArray(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    if ((paramInt > 65535) && (Dbg.e())) {
      Dbg.e("length is to long for byte conversion.");
    }
    arrayOfByte[0] = ((byte)(0xFF & paramInt >> 8));
    arrayOfByte[1] = ((byte)(0xFF & paramInt >> 0));
    return arrayOfByte;
  }
  
  private String meToString()
  {
    String str = "Feature: " + this.feature + ".\n" + "Type:" + this.type + ".\n" + "Frame:" + this.frame + ".\n" + "Length:" + this.length + ".\n";
    if (this.data == null) {
      str = str + "No data";
    } else {
      str = str + "First byte of data Data: " + this.data[0] + ".";
    }
    return str;
  }
  
  private int unsignedShortToInt(byte[] paramArrayOfByte)
  {
    return (0x0 | 0xFF & paramArrayOfByte[6]) << 8 | 0xFF & paramArrayOfByte[7];
  }
  
  private boolean validateHeader(int paramInt)
  {
    boolean bool;
    if (paramInt >= 8)
    {
      if (Dbg.v()) {
        Dbg.v("Header is OK.");
      }
      bool = true;
    }
    else
    {
      if (Dbg.e()) {
        Dbg.e("Data is smaller than AAF header");
      }
      bool = false;
    }
    return bool;
  }
  
  public Bundle getMetaData()
  {
    return this.mMetaData;
  }
  
  public void putMetaData(Bundle paramBundle)
  {
    this.mMetaData = paramBundle;
  }
  
  public byte[] toByteArray()
  {
    if (Dbg.v()) {
      Dbg.v("To byte");
    }
    byte[] arrayOfByte2;
    if (this.data == null) {
      arrayOfByte2 = new byte[8];
    } else {
      arrayOfByte2 = new byte[8 + this.data.length];
    }
    if (Dbg.v()) {
      Dbg.v("try to create packet with size:" + this.length);
    }
    arrayOfByte2[0] = this.identifier[0];
    arrayOfByte2[1] = this.identifier[1];
    arrayOfByte2[2] = this.identifier[2];
    arrayOfByte2[3] = this.feature;
    arrayOfByte2[4] = this.type;
    arrayOfByte2[5] = this.frame;
    byte[] arrayOfByte1 = intToByteArray(this.length);
    arrayOfByte2[6] = arrayOfByte1[0];
    arrayOfByte2[7] = arrayOfByte1[1];
    if (this.data != null) {
      System.arraycopy(this.data, 0, arrayOfByte2, 8, this.length);
    }
    return arrayOfByte2;
  }
  
  public String toString()
  {
    return meToString();
  }
  
  protected boolean validateIdentifier(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if ((paramArrayOfByte != null) && (paramArrayOfByte[0] == this.identifier[0]) && (paramArrayOfByte[1] == this.identifier[1]) && (paramArrayOfByte[2] == this.identifier[2])) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.AsfPacket
 * JD-Core Version:    0.7.0.1
 */