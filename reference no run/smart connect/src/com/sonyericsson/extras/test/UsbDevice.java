package com.sonyericsson.extras.test;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class UsbDevice
  implements Parcelable
{
  public static final Parcelable.Creator<UsbDevice> CREATOR = new Parcelable.Creator()
  {
    public UsbDevice createFromParcel(Parcel paramAnonymousParcel)
    {
      return new UsbDevice(paramAnonymousParcel, null);
    }
    
    public UsbDevice[] newArray(int paramAnonymousInt)
    {
      return new UsbDevice[paramAnonymousInt];
    }
  };
  private int mDeviceClass;
  private int mDeviceProtocol;
  private int mDeviceSubclass;
  private int mIdProduct;
  private int mIdVendor;
  private String mManufacturer;
  private String mProductName;
  private String mSerial;
  private boolean mSupported;
  private int mUsbDeviceUniqueId;
  
  private UsbDevice(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public UsbDevice(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5, int paramInt6)
  {
    this.mSupported = paramBoolean;
    this.mUsbDeviceUniqueId = paramInt1;
    this.mDeviceClass = paramInt2;
    this.mDeviceSubclass = paramInt3;
    this.mProductName = paramString1;
    this.mManufacturer = paramString2;
    this.mDeviceProtocol = paramInt4;
    this.mSerial = paramString3;
    this.mIdVendor = paramInt5;
    this.mIdProduct = paramInt6;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDeviceClass()
  {
    return this.mDeviceClass;
  }
  
  public int getDeviceProtocol()
  {
    return this.mDeviceProtocol;
  }
  
  public int getDeviceSubclass()
  {
    return this.mDeviceSubclass;
  }
  
  public String getManufacturer()
  {
    return this.mManufacturer;
  }
  
  public int getProductId()
  {
    return this.mIdProduct;
  }
  
  public String getProductName()
  {
    return this.mProductName;
  }
  
  public String getSerialNumber()
  {
    return this.mSerial;
  }
  
  public int getUniqueId()
  {
    return this.mUsbDeviceUniqueId;
  }
  
  public int getVendorId()
  {
    return this.mIdVendor;
  }
  
  public boolean isSupported()
  {
    return this.mSupported;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    this.mUsbDeviceUniqueId = paramParcel.readInt();
    boolean bool;
    if (paramParcel.readByte() <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    this.mSupported = bool;
    this.mDeviceClass = paramParcel.readInt();
    this.mDeviceSubclass = paramParcel.readInt();
    this.mProductName = paramParcel.readString();
    this.mManufacturer = paramParcel.readString();
    this.mDeviceProtocol = paramParcel.readInt();
    this.mSerial = paramParcel.readString();
    this.mIdVendor = paramParcel.readInt();
    this.mIdProduct = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mUsbDeviceUniqueId);
    int i;
    if (!this.mSupported) {
      i = 0;
    } else {
      i = 1;
    }
    paramParcel.writeByte((byte)i);
    paramParcel.writeInt(this.mDeviceClass);
    paramParcel.writeInt(this.mDeviceSubclass);
    paramParcel.writeString(this.mProductName);
    paramParcel.writeString(this.mManufacturer);
    paramParcel.writeInt(this.mDeviceProtocol);
    paramParcel.writeString(this.mSerial);
    paramParcel.writeInt(this.mIdVendor);
    paramParcel.writeInt(this.mIdProduct);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.test.UsbDevice
 * JD-Core Version:    0.7.0.1
 */