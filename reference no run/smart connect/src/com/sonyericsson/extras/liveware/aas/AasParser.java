package com.sonyericsson.extras.liveware.aas;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.asf.AsfPacket;
import com.sonyericsson.extras.liveware.asf.AsfParser;
import com.sonyericsson.extras.liveware.asf.AsfProtocol;
import com.sonyericsson.extras.liveware.asf.DeviceServiceHandler;
import com.sonyericsson.extras.liveware.asf.InstallReceiver;
import com.sonyericsson.extras.liveware.config.ExperienceParser;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Device.DeviceEditor;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class AasParser
  extends AsfParser
{
  private static final int AS_NOT_SET = -1;
  private static final int AS_OPTIONAL = 0;
  private static final int BW_ICON = 1;
  private static final int COLOR_ICON;
  private static final int[][] STATUS_RESOURCES;
  static final byte[] VERSION;
  private int mAppSelection;
  private byte mDispType = 0;
  private boolean mHasDisplay = false;
  private byte[] mIcon;
  private String mIntentAction;
  private String mPackageName;
  private String mProductName;
  AasProtocolHandler mProtocolHandler;
  byte mStatusFrame;
  byte mStatusState = 0;
  boolean mStatusSubscribed = false;
  
  static
  {
    Object localObject = new byte[2];
    localObject[0] = 1;
    localObject[1] = 1;
    VERSION = (byte[])localObject;
    localObject = new int[2][];
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = 2131034143;
    arrayOfInt[1] = 2131034143;
    arrayOfInt[2] = 2131034144;
    arrayOfInt[3] = 2131034144;
    arrayOfInt[4] = 2131034145;
    arrayOfInt[5] = 2131034144;
    localObject[0] = arrayOfInt;
    arrayOfInt = new int[6];
    arrayOfInt[0] = 2131034135;
    arrayOfInt[1] = 2131034135;
    arrayOfInt[2] = 2131034136;
    arrayOfInt[3] = 2131034136;
    arrayOfInt[4] = 2131034137;
    arrayOfInt[5] = 2131034136;
    localObject[1] = arrayOfInt;
    STATUS_RESOURCES = (int[][])localObject;
  }
  
  AasParser(Context paramContext, AasProtocolHandler paramAasProtocolHandler)
  {
    super(paramContext);
    this.mProtocolHandler = paramAasProtocolHandler;
  }
  
  private Device addSmartLaunch(ExperienceManager paramExperienceManager, String paramString, Device paramDevice)
  {
    Device localDevice1 = null;
    int i = 2;
    if (this.mAppSelection == 0) {
      i = 1;
    }
    Device localDevice2 = DeviceServiceHandler.getPreconfigDevice(this.mCtx, this.mProductName, 4);
    if ((paramDevice != null) && (localDevice2 != null)) {
      localDevice1 = paramDevice;
    }
    for (;;)
    {
      if (localDevice1 != null)
      {
        localObject1 = new Feature(localDevice1, 4, null, null, this.mIntentAction, i, null, this.mPackageName);
        paramExperienceManager.updateDevice(localDevice1.edit().addFeature((Feature)localObject1).setKeyId(paramString));
        localDevice1 = paramExperienceManager.getDeviceById(localDevice1.getId());
      }
      return localDevice1;
      Object localObject1 = null;
      if (localDevice2 == null) {
        localObject1 = paramString + ".icon";
      }
      try
      {
        if (this.mIcon != null) {
          UIUtils.saveIcon(this.mCtx, (String)localObject1, this.mIcon);
        }
        for (;;)
        {
          if (paramDevice == null) {
            break label213;
          }
          if (localObject1 != null)
          {
            paramDevice.setIcon((String)localObject1);
            paramDevice.setLargeIconName((String)localObject1);
            paramExperienceManager.updateDevice(paramDevice.edit().setIconName((String)localObject1).setLargeIconName((String)localObject1));
          }
          localDevice1 = paramDevice;
          break;
          localObject1 = null;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject1 = null;
        }
        label213:
        Object localObject2 = new ExperienceParser(this.mCtx);
        Object localObject3 = ((ExperienceParser)localObject2).parse(DeviceServiceHandler.getExperienceName(this.mProductName, 4));
        localDevice2 = null;
        if (localObject3 != null) {
          localDevice2 = ((Experience)localObject3).getDevice();
        }
        if (localDevice2 == null)
        {
          localObject3 = DeviceServiceHandler.getExperienceNameByTypeAndBearer(10, 4);
          if (localObject3 != null)
          {
            localObject2 = ((ExperienceParser)localObject2).parse((String)localObject3);
            if (localObject2 != null) {
              localDevice2 = ((Experience)localObject2).getDevice();
            }
          }
          if ((localDevice2 != null) && (localObject1 != null))
          {
            localDevice2.setIcon((String)localObject1);
            localDevice2.setLargeIconName((String)localObject1);
          }
        }
      }
      if (localDevice2 != null)
      {
        localDevice2.setProductId(this.mProductName);
        if (TextUtils.isEmpty(localDevice2.getProductName())) {
          localDevice2.setUserDefinedName(this.mProductName);
        }
        localDevice2.setKeyId(paramString);
        localDevice1 = paramExperienceManager.addDevice(localDevice2);
      }
    }
  }
  
  private Device alreadyInDb(String paramString1, String paramString2)
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(this.mCtx);
    Device localDevice = localExperienceManager.getDeviceByKeyId(paramString2);
    if (localDevice == null)
    {
      localDevice = localExperienceManager.getDeviceByProductIdAndBearer(paramString1, 4);
      if (localDevice != null) {
        localExperienceManager.updateDevice(localDevice.edit().setKeyId(paramString2));
      }
    }
    return localDevice;
  }
  
  private AsfPacket buildStatusAnswer(byte paramByte, byte[] paramArrayOfByte)
  {
    AasPacket localAasPacket = new AasPacket((byte)2, this.mStatusFrame);
    int i = 2;
    if (paramArrayOfByte != null) {
      i += 3 + paramArrayOfByte.length;
    }
    byte[] arrayOfByte = new byte[i];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = paramByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte[2] = 2;
      arrayOfByte[3] = ((byte)(paramArrayOfByte.length / 256));
      arrayOfByte[4] = ((byte)(paramArrayOfByte.length % 256));
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 5, paramArrayOfByte.length);
    }
    localAasPacket.length = i;
    localAasPacket.type = 5;
    localAasPacket.data = arrayOfByte;
    return localAasPacket;
  }
  
  private void getErrorPacket(AsfPacket paramAsfPacket)
  {
    paramAsfPacket.type = 0;
    paramAsfPacket.data = AsfProtocol.ERROR_TYPE;
    paramAsfPacket.length = paramAsfPacket.data.length;
  }
  
  private byte[] getIcon(int paramInt, byte paramByte)
  {
    int i = 0;
    Object localObject = this.mCtx.getResources();
    if (paramByte == 2) {}
    for (;;)
    {
      int k = STATUS_RESOURCES[i][paramInt];
      byte[] arrayOfByte = new byte[2048];
      try
      {
        InputStream localInputStream = ((Resources)localObject).openRawResource(k);
        localObject = new ByteArrayOutputStream();
        int m = 0;
        for (;;)
        {
          if (m == -1)
          {
            localInputStream.close();
            arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
            ((ByteArrayOutputStream)localObject).close();
            break;
          }
          m = localInputStream.read(arrayOfByte);
          if (m > 0) {
            ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, m);
          }
        }
        return arrayOfByte;
      }
      catch (IOException localIOException)
      {
        if (Dbg.e()) {
          Dbg.e("Couldn't open resource");
        }
        arrayOfByte = null;
      }
      int j = 1;
    }
  }
  
  private boolean parseSet(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    int i = 1;
    if (Dbg.v()) {
      Dbg.v("Parse data");
    }
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return bool;
      DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
      for (;;)
      {
        if (i == 0)
        {
          if ((this.mIntentAction != null) && (this.mProductName != null) && (this.mPackageName != null)) {
            break label506;
          }
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("Sanity check failed.");
          break;
        }
        int j;
        try
        {
          j = localDataInputStream.readByte();
          j = j;
        }
        catch (EOFException localEOFException)
        {
          for (;;)
          {
            if (Dbg.v()) {
              Dbg.v("EOF");
            }
            j = 0;
          }
        }
        catch (IOException localIOException1) {}
        switch (j)
        {
        default: 
          if (!Dbg.v()) {
            break;
          }
          Dbg.v("parse error tmp was " + j);
          break;
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("Serious error");
          break;
        case 0: 
          if (Dbg.v()) {
            Dbg.v("Parse done");
          }
          i = 0;
          break;
        case 1: 
          try
          {
            this.mProductName = localDataInputStream.readUTF();
            if (!Dbg.v()) {
              continue;
            }
            Dbg.v("Parser found productname =" + this.mProductName);
          }
          catch (IOException localIOException2) {}
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("readUTF error");
          break;
        case 4: 
          try
          {
            this.mIntentAction = localDataInputStream.readUTF();
            if (!Dbg.v()) {
              continue;
            }
            Dbg.v("Parser found intentAction =" + this.mIntentAction);
          }
          catch (IOException localIOException3) {}
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("readUTF error");
          break;
        case 2: 
          try
          {
            this.mPackageName = localDataInputStream.readUTF();
            if (!Dbg.v()) {
              continue;
            }
            Dbg.v("Parser found packageName =" + this.mPackageName);
          }
          catch (IOException localIOException4) {}
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("readUTF error");
          break;
        case 3: 
          try
          {
            this.mAppSelection = localDataInputStream.readByte();
          }
          catch (IOException localIOException5) {}
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("read error");
          break;
        case 5: 
          try
          {
            j = localDataInputStream.readUnsignedShort();
            if (j == 0) {
              j = localDataInputStream.readUnsignedShort();
            }
            this.mIcon = new byte[j];
            if (localDataInputStream.read(this.mIcon) != -1) {
              break label490;
            }
            throw new IOException();
          }
          catch (IOException localIOException6) {}
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("icon read(byte[]) error");
          break;
          label490:
          if (Dbg.v()) {
            Dbg.v("Parser found icon");
          }
          break;
        }
      }
      label506:
      if (Dbg.v()) {
        Dbg.v("Parse ok");
      }
      bool = true;
    }
  }
  
  private void sendStatus(int paramInt)
  {
    if (this.mStatusSubscribed) {
      this.mProtocolHandler.onAsyncEvent(1, paramInt);
    }
  }
  
  public AsfPacket getStatusAnswer(int paramInt)
  {
    byte[] arrayOfByte = (byte[])null;
    if (this.mHasDisplay) {
      arrayOfByte = getIcon(paramInt, this.mDispType);
    }
    return buildStatusAnswer((byte)paramInt, arrayOfByte);
  }
  
  public boolean getStatusSubscription()
  {
    return this.mStatusSubscribed;
  }
  
  public AsfPacket parse(AsfPacket paramAsfPacket)
  {
    AasPacket localAasPacket = new AasPacket(paramAsfPacket.feature, paramAsfPacket.frame);
    switch (paramAsfPacket.type)
    {
    case 7: 
    case 8: 
    default: 
      if (Dbg.e()) {
        Dbg.e("The type is not supported: field value is:" + paramAsfPacket.type + ".");
      }
      getErrorPacket(localAasPacket);
      break;
    case 6: 
      this.mPackageName = null;
      this.mProductName = null;
      this.mIcon = null;
      this.mIntentAction = null;
      this.mAppSelection = -1;
      if (parseSet(paramAsfPacket.data))
      {
        String str = paramAsfPacket.getMetaData().getString("Address");
        int i = 0;
        Object localObject = ExperienceManager.getInstance(this.mCtx);
        Device localDevice = alreadyInDb(this.mProductName, str);
        int j = 0;
        if (localDevice != null)
        {
          Feature localFeature = localDevice.getFeature(4);
          if (localFeature != null) {
            if (!localFeature.getIntent().equals(this.mIntentAction)) {
              ((ExperienceManager)localObject).updateDevice(localDevice.edit().removeFeature(localFeature));
            } else {
              j = 1;
            }
          }
        }
        if (j == 0)
        {
          localDevice = addSmartLaunch((ExperienceManager)localObject, str, localDevice);
          i = 1;
          if (localDevice == null) {}
        }
        else
        {
          boolean bool = false;
          if (this.mPackageName != null) {
            bool = PackageUtils.existsPackage(this.mCtx, this.mPackageName);
          }
          if ((bool) && (i != 0)) {
            PackageUtils.findAndSetDefaultApp(this.mCtx, localDevice, new Intent(this.mIntentAction), this.mPackageName, 4);
          }
          localObject = localDevice.getFeature(4);
          if ((localObject != null) && (((Feature)localObject).getState() != 0)) {
            if ((!PackageUtils.existsApp(this.mCtx, this.mIntentAction)) || ((i != 0) && (!bool)))
            {
              if (this.mPackageName != null)
              {
                this.mStatusState = 1;
                if (this.mStatusSubscribed) {
                  sendStatus(this.mStatusState);
                }
                UIUtils.attachUI(this.mCtx, localDevice, 4, this.mStatusSubscribed);
                InstallReceiver.runInstallReceiver(this.mCtx, this.mPackageName, localDevice.getId(), 4, true);
              }
            }
            else
            {
              this.mStatusState = 4;
              if (this.mStatusSubscribed) {
                sendStatus(this.mStatusState);
              }
              PackageUtils.startSmartLaunchApplication(this.mCtx, localDevice);
            }
          }
          localAasPacket.type = 1;
          break;
        }
        if (Dbg.e()) {
          Dbg.e("Can't extract accessory from DB");
        }
        getErrorPacket(localAasPacket);
      }
      else
      {
        if (Dbg.e()) {
          Dbg.e("Could not parse data");
        }
        localAasPacket.data = AsfProtocol.ERROR_DATA;
        localAasPacket.length = localAasPacket.data.length;
      }
      break;
    case 9: 
      if (Dbg.v()) {
        Dbg.v("Recived version command");
      }
      localAasPacket.type = 1;
      localAasPacket.data = VERSION;
      localAasPacket.length = localAasPacket.data.length;
    }
    return localAasPacket;
  }
  
  public AsfPacket parseStatus(AsfPacket paramAsfPacket)
  {
    AasPacket localAasPacket = new AasPacket(paramAsfPacket.feature, paramAsfPacket.frame);
    AsfPacket localAsfPacket;
    switch (paramAsfPacket.type)
    {
    default: 
      getErrorPacket(localAasPacket);
      break;
    case 7: 
      this.mStatusSubscribed = true;
      int j = paramAsfPacket.data[0];
      int i = this.mStatusState;
      this.mStatusFrame = paramAsfPacket.frame;
      if (j == 1)
      {
        this.mHasDisplay = true;
        this.mDispType = paramAsfPacket.data[1];
      }
      localAsfPacket = getStatusAnswer(i);
    }
    return localAsfPacket;
  }
  
  public void resetState()
  {
    this.mHasDisplay = false;
    this.mDispType = 0;
    this.mStatusSubscribed = false;
    this.mStatusState = 0;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aas.AasParser
 * JD-Core Version:    0.7.0.1
 */