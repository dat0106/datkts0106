package com.sonyericsson.extras.liveware.service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import com.sonyericsson.extras.liveware.asf.AsfPacket;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class BtServer
  extends Thread
{
  private BtPacketProtocolHandler mPacketHandler;
  private ProtocolHandler mProtocol;
  private BluetoothServerSocket mServerSocket = null;
  private String mServiceName;
  private Boolean mTerminate = Boolean.valueOf(false);
  private int mTestNullPackets = 0;
  private UUID mUuid;
  
  public BtServer(String paramString, UUID paramUUID, BtPacketProtocolHandler paramBtPacketProtocolHandler, ProtocolHandler paramProtocolHandler)
  {
    this.mUuid = paramUUID;
    this.mServiceName = paramString;
    this.mProtocol = paramProtocolHandler;
    this.mPacketHandler = paramBtPacketProtocolHandler;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  private void closeServerSocket()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/sonyericsson/extras/liveware/service/BtServer:mServerSocket	Landroid/bluetooth/BluetoothServerSocket;
    //   6: ifnull +27 -> 33
    //   9: ldc 57
    //   11: invokestatic 63	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   14: pop
    //   15: aload_0
    //   16: getfield 36	com/sonyericsson/extras/liveware/service/BtServer:mServerSocket	Landroid/bluetooth/BluetoothServerSocket;
    //   19: invokevirtual 68	android/bluetooth/BluetoothServerSocket:close	()V
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 36	com/sonyericsson/extras/liveware/service/BtServer:mServerSocket	Landroid/bluetooth/BluetoothServerSocket;
    //   27: ldc 70
    //   29: invokestatic 63	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: pop
    //   37: invokestatic 74	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   40: ifeq -7 -> 33
    //   43: new 76	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 78
    //   49: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   56: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 87
    //   61: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 93	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   70: pop
    //   71: goto -38 -> 33
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	BtServer
    //   74	4	1	localObject	Object
    //   36	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   15	33	36	java/io/IOException
    //   2	15	74	finally
    //   15	33	74	finally
    //   37	71	74	finally
  }
  
  private void communicate(InputStream paramInputStream, OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    for (;;)
    {
      BtPacket localBtPacket = this.mPacketHandler.getPacket(paramInputStream, this.mProtocol);
      if (localBtPacket == null)
      {
        localBtPacket = this.mPacketHandler.getErrorPacket();
        if (Dbg.v()) {
          Dbg.v("Btserver " + this.mServiceName + " communicate packet == null");
        }
      }
      else
      {
        this.mPacketHandler.addPacketMetadata(paramString, localBtPacket);
        localBtPacket = this.mProtocol.processPacket(localBtPacket);
        if (Dbg.v()) {
          Dbg.v("Btserver " + this.mServiceName + " communicate packet != null");
        }
      }
      if (localBtPacket == null) {
        this.mTestNullPackets = (1 + this.mTestNullPackets);
      }
      writePacket(paramOutputStream, localBtPacket);
    }
  }
  
  private BluetoothSocket listen()
    throws IOException
  {
    Object localObject1 = BluetoothAdapter.getDefaultAdapter();
    if (localObject1 == null) {
      throw new IOException("No BT Adapter found");
    }
    try
    {
      Dbg.d("Start Rfcomm listening");
      this.mServerSocket = ((BluetoothAdapter)localObject1).listenUsingInsecureRfcommWithServiceRecord(this.mServiceName, this.mUuid);
      localObject1 = this.mServerSocket.accept();
      closeServerSocket();
      return localObject1;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;)
      {
        this.mServerSocket = ((BluetoothAdapter)localObject1).listenUsingRfcommWithServiceRecord(this.mServiceName, this.mUuid);
      }
    }
    finally {}
  }
  
  /**
   * @deprecated
   */
  private boolean shouldTerminate()
  {
    try
    {
      boolean bool = this.mTerminate.booleanValue();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void writePacket(OutputStream paramOutputStream, BtPacket paramBtPacket)
    throws IOException
  {
    if (paramBtPacket != null) {}
    try
    {
      paramOutputStream.write(paramBtPacket.toByteArray());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ProtocolHandler getProtocolHandler()
  {
    return this.mProtocol;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   3: ifeq +31 -> 34
    //   6: new 76	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 78
    //   12: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   19: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 172
    //   24: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   33: pop
    //   34: aload_0
    //   35: invokespecial 174	com/sonyericsson/extras/liveware/service/BtServer:listen	()Landroid/bluetooth/BluetoothSocket;
    //   38: astore_1
    //   39: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   42: ifeq +38 -> 80
    //   45: new 76	java/lang/StringBuilder
    //   48: dup
    //   49: ldc 78
    //   51: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   58: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 176
    //   63: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: getfield 40	com/sonyericsson/extras/liveware/service/BtServer:mUuid	Ljava/util/UUID;
    //   70: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   79: pop
    //   80: aload_1
    //   81: invokevirtual 185	android/bluetooth/BluetoothSocket:getOutputStream	()Ljava/io/OutputStream;
    //   84: astore_2
    //   85: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   88: ifeq +31 -> 119
    //   91: new 76	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 78
    //   97: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   104: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 187
    //   109: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   118: pop
    //   119: aload_0
    //   120: getfield 44	com/sonyericsson/extras/liveware/service/BtServer:mProtocol	Lcom/sonyericsson/extras/liveware/service/ProtocolHandler;
    //   123: aload_1
    //   124: invokevirtual 191	android/bluetooth/BluetoothSocket:getRemoteDevice	()Landroid/bluetooth/BluetoothDevice;
    //   127: invokevirtual 196	android/bluetooth/BluetoothDevice:getAddress	()Ljava/lang/String;
    //   130: new 6	com/sonyericsson/extras/liveware/service/BtServer$AsyncSender
    //   133: dup
    //   134: aload_0
    //   135: aload_2
    //   136: invokespecial 199	com/sonyericsson/extras/liveware/service/BtServer$AsyncSender:<init>	(Lcom/sonyericsson/extras/liveware/service/BtServer;Ljava/io/OutputStream;)V
    //   139: invokeinterface 203 3 0
    //   144: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   147: ifeq +31 -> 178
    //   150: new 76	java/lang/StringBuilder
    //   153: dup
    //   154: ldc 78
    //   156: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   163: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 205
    //   168: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   177: pop
    //   178: aload_0
    //   179: aload_1
    //   180: invokevirtual 209	android/bluetooth/BluetoothSocket:getInputStream	()Ljava/io/InputStream;
    //   183: aload_2
    //   184: aload_1
    //   185: invokevirtual 191	android/bluetooth/BluetoothSocket:getRemoteDevice	()Landroid/bluetooth/BluetoothDevice;
    //   188: invokevirtual 196	android/bluetooth/BluetoothDevice:getAddress	()Ljava/lang/String;
    //   191: invokespecial 211	com/sonyericsson/extras/liveware/service/BtServer:communicate	(Ljava/io/InputStream;Ljava/io/OutputStream;Ljava/lang/String;)V
    //   194: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   197: ifeq +31 -> 228
    //   200: new 76	java/lang/StringBuilder
    //   203: dup
    //   204: ldc 78
    //   206: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: aload_0
    //   210: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   213: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 213
    //   218: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   227: pop
    //   228: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   231: ifeq +31 -> 262
    //   234: new 76	java/lang/StringBuilder
    //   237: dup
    //   238: ldc 78
    //   240: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   243: aload_0
    //   244: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   247: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 215
    //   252: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   261: pop
    //   262: aload_1
    //   263: ifnull +41 -> 304
    //   266: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   269: ifeq +31 -> 300
    //   272: new 76	java/lang/StringBuilder
    //   275: dup
    //   276: ldc 78
    //   278: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   285: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc 217
    //   290: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   299: pop
    //   300: aload_1
    //   301: invokevirtual 218	android/bluetooth/BluetoothSocket:close	()V
    //   304: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   307: ifeq +31 -> 338
    //   310: new 76	java/lang/StringBuilder
    //   313: dup
    //   314: ldc 78
    //   316: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: aload_0
    //   320: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   323: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 220
    //   328: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   337: pop
    //   338: aload_0
    //   339: getfield 44	com/sonyericsson/extras/liveware/service/BtServer:mProtocol	Lcom/sonyericsson/extras/liveware/service/ProtocolHandler;
    //   342: invokeinterface 223 1 0
    //   347: aload_0
    //   348: invokespecial 225	com/sonyericsson/extras/liveware/service/BtServer:shouldTerminate	()Z
    //   351: ifeq +360 -> 711
    //   354: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   357: ifeq +31 -> 388
    //   360: new 76	java/lang/StringBuilder
    //   363: dup
    //   364: ldc 78
    //   366: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   369: aload_0
    //   370: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   373: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 227
    //   378: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   387: pop
    //   388: return
    //   389: pop
    //   390: ldc 229
    //   392: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   395: pop
    //   396: aload_0
    //   397: invokespecial 148	com/sonyericsson/extras/liveware/service/BtServer:closeServerSocket	()V
    //   400: goto -12 -> 388
    //   403: astore_2
    //   404: invokestatic 231	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   407: ifeq +32 -> 439
    //   410: new 76	java/lang/StringBuilder
    //   413: dup
    //   414: ldc 78
    //   416: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   419: aload_0
    //   420: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   423: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc 233
    //   428: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: aload_2
    //   435: invokestatic 236	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   438: pop
    //   439: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   442: ifeq +31 -> 473
    //   445: new 76	java/lang/StringBuilder
    //   448: dup
    //   449: ldc 78
    //   451: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   454: aload_0
    //   455: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   458: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: ldc 215
    //   463: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   472: pop
    //   473: aload_1
    //   474: ifnull -170 -> 304
    //   477: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   480: ifeq +31 -> 511
    //   483: new 76	java/lang/StringBuilder
    //   486: dup
    //   487: ldc 78
    //   489: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   492: aload_0
    //   493: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   496: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc 217
    //   501: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   510: pop
    //   511: aload_1
    //   512: invokevirtual 218	android/bluetooth/BluetoothSocket:close	()V
    //   515: goto -211 -> 304
    //   518: pop
    //   519: invokestatic 74	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   522: ifeq -218 -> 304
    //   525: new 76	java/lang/StringBuilder
    //   528: dup
    //   529: ldc 78
    //   531: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   534: aload_0
    //   535: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   538: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: ldc 238
    //   543: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 93	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   552: pop
    //   553: goto -249 -> 304
    //   556: astore_2
    //   557: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   560: ifeq +31 -> 591
    //   563: new 76	java/lang/StringBuilder
    //   566: dup
    //   567: ldc 78
    //   569: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   572: aload_0
    //   573: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   576: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: ldc 215
    //   581: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   590: pop
    //   591: aload_1
    //   592: ifnull +41 -> 633
    //   595: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   598: ifeq +31 -> 629
    //   601: new 76	java/lang/StringBuilder
    //   604: dup
    //   605: ldc 78
    //   607: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   610: aload_0
    //   611: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   614: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc 217
    //   619: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   628: pop
    //   629: aload_1
    //   630: invokevirtual 218	android/bluetooth/BluetoothSocket:close	()V
    //   633: aload_2
    //   634: athrow
    //   635: pop
    //   636: invokestatic 74	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   639: ifeq -6 -> 633
    //   642: new 76	java/lang/StringBuilder
    //   645: dup
    //   646: ldc 78
    //   648: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   651: aload_0
    //   652: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   655: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: ldc 238
    //   660: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 93	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   669: pop
    //   670: goto -37 -> 633
    //   673: pop
    //   674: invokestatic 74	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   677: ifeq -373 -> 304
    //   680: new 76	java/lang/StringBuilder
    //   683: dup
    //   684: ldc 78
    //   686: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   689: aload_0
    //   690: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   693: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc 238
    //   698: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 93	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   707: pop
    //   708: goto -404 -> 304
    //   711: invokestatic 108	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   714: ifeq -714 -> 0
    //   717: new 76	java/lang/StringBuilder
    //   720: dup
    //   721: ldc 78
    //   723: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: aload_0
    //   727: getfield 42	com/sonyericsson/extras/liveware/service/BtServer:mServiceName	Ljava/lang/String;
    //   730: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: ldc 240
    //   735: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 112	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   744: pop
    //   745: goto -745 -> 0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	748	0	this	BtServer
    //   38	592	1	localBluetoothSocket	BluetoothSocket
    //   84	100	2	localOutputStream	OutputStream
    //   403	32	2	localIOException1	IOException
    //   556	78	2	localObject	Object
    //   389	1	5	localIOException2	IOException
    //   518	1	6	localIOException3	IOException
    //   635	1	7	localIOException4	IOException
    //   673	1	8	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   0	39	389	java/io/IOException
    //   39	228	403	java/io/IOException
    //   477	515	518	java/io/IOException
    //   39	228	556	finally
    //   404	439	556	finally
    //   595	633	635	java/io/IOException
    //   266	304	673	java/io/IOException
  }
  
  /**
   * @deprecated
   */
  public void terminate()
  {
    try
    {
      Dbg.d("Terminate BTServer");
      if (!shouldTerminate())
      {
        this.mTerminate = Boolean.valueOf(true);
        closeServerSocket();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void testCommunicate(InputStream paramInputStream, OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    communicate(paramInputStream, paramOutputStream, paramString);
  }
  
  public void testConnect(String paramString, OutputStream paramOutputStream)
  {
    this.mProtocol.onConnect(paramString, new AsyncSender(paramOutputStream));
  }
  
  public int testGetNullPackets()
  {
    return this.mTestNullPackets;
  }
  
  private class AsyncSender
    implements AsyncPacketSender
  {
    private final OutputStream os;
    
    public AsyncSender(OutputStream paramOutputStream)
    {
      this.os = paramOutputStream;
    }
    
    public void sendPacket(AsfPacket paramAsfPacket)
      throws IOException
    {
      BtServer.this.writePacket(this.os, paramAsfPacket);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.service.BtServer
 * JD-Core Version:    0.7.0.1
 */