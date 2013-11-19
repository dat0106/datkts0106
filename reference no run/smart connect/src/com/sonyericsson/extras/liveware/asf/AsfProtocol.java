package com.sonyericsson.extras.liveware.asf;

public final class AsfProtocol
{
  public static final int ASF_BODY_MAX_SIZE = 65535;
  public static final byte ASF_DATA_POS = 8;
  public static final byte ASF_FEATURE_INIT = 0;
  public static final byte ASF_FEATURE_POS = 3;
  public static final byte ASF_FRAME_POS = 5;
  public static final byte ASF_HEADER_SIZE = 8;
  public static final byte ASF_LENGTH_POS = 6;
  public static final int ASF_PACKET_MAX_SIZE = 65543;
  public static final int ASF_STATUS_DLG_ACCEPT = 2;
  public static final int ASF_STATUS_DLG_REJECT = 3;
  public static final int ASF_STATUS_DLG_START = 1;
  public static final int ASF_STATUS_INIT = 0;
  public static final int ASF_STATUS_INST_ABORT = 5;
  public static final int ASF_STATUS_INST_COMPLETE = 4;
  public static final byte ASF_TYPE_POS = 4;
  public static final byte[] ERROR_DATA;
  public static final byte[] ERROR_FEATURE;
  public static final byte[] ERROR_PACKET;
  public static final byte[] ERROR_SESSION = new byte[1];
  public static final byte[] ERROR_TYPE;
  public static final byte TYPE_ERROR = 0;
  public static final byte TYPE_GET = 2;
  public static final byte TYPE_INFORM = 3;
  public static final byte TYPE_LIST = 4;
  public static final byte TYPE_NOTIFY = 5;
  public static final byte TYPE_OK = 1;
  public static final byte TYPE_SET = 6;
  public static final byte TYPE_SUBSCRIBE = 7;
  public static final byte TYPE_UNSUBSCRIBE = 8;
  public static final byte TYPE_VERSION = 9;
  
  static
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = 1;
    ERROR_FEATURE = arrayOfByte;
    arrayOfByte = new byte[1];
    arrayOfByte[0] = 2;
    ERROR_TYPE = arrayOfByte;
    arrayOfByte = new byte[1];
    arrayOfByte[0] = 3;
    ERROR_DATA = arrayOfByte;
    arrayOfByte = new byte[1];
    arrayOfByte[0] = 4;
    ERROR_PACKET = arrayOfByte;
  }
  
  public static final class AasProtocol
  {
    public static final byte AAS_IDENTIFY_APPSEL = 3;
    public static final byte AAS_IDENTIFY_ICON = 5;
    public static final byte AAS_IDENTIFY_INTENTACTION = 4;
    public static final byte AAS_IDENTIFY_PACKAGENAME = 2;
    public static final byte AAS_IDENTIFY_PRODUCTNAME = 1;
    public static byte[] AAS_PACKET_IDENTIFIER;
    public static final byte FEATURE_AAS_IDENTIFY = 1;
    public static final byte FEATURE_AAS_STATUS = 2;
    
    static
    {
      byte[] arrayOfByte = new byte[3];
      arrayOfByte[0] = 65;
      arrayOfByte[1] = 65;
      arrayOfByte[2] = 83;
      AAS_PACKET_IDENTIFIER = arrayOfByte;
    }
  }
  
  public static final class AisProtocol
  {
    public static final int AIS_APP_SELECTION_MANDATORY = 2;
    public static final int AIS_APP_SELECTION_NONE = 0;
    public static final int AIS_APP_SELECTION_OPTIONAL = 1;
    public static final byte AIS_IDENTIFY_APPSEL = 3;
    public static final byte AIS_IDENTIFY_ICON = 5;
    public static final byte AIS_IDENTIFY_PACKAGENAME = 2;
    public static final byte AIS_IDENTIFY_PRODUCTID = 6;
    public static final byte AIS_IDENTIFY_PRODUCTNAME = 1;
    public static byte[] AIS_PACKET_IDENTIFIER;
    public static final byte FEATURE_AIS_IDENTIFY = 1;
    public static final byte FEATURE_AIS_LIVEKEY = 2;
    
    static
    {
      byte[] arrayOfByte = new byte[3];
      arrayOfByte[0] = 65;
      arrayOfByte[1] = 73;
      arrayOfByte[2] = 83;
      AIS_PACKET_IDENTIFIER = arrayOfByte;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.AsfProtocol
 * JD-Core Version:    0.7.0.1
 */