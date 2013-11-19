package com.sonyericsson.extras.liveware.utils;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

public class TagParser
{
  public static final int CONCEPT_BLUETOOTH_TAG = 3;
  public static final int CONCEPT_ERROR = -1;
  public static final int CONCEPT_KEY_TAG = 1;
  public static final int CONCEPT_UID_TAG = 2;
  public static final int CONCEPT_UNKNOWN = 0;
  private static final String SEMC_PACKAGE_BASE = "com.sonyericsson.extras.";
  
  private static List<String> fixupProductNameField(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    if (!Character.isUpperCase(((String)paramList.get(0)).charAt(0))) {
      localArrayList.add(2, null);
    }
    return localArrayList;
  }
  
  public static int getConcept(Uri paramUri)
  {
    int j = 1;
    String str = paramUri.getPath().toLowerCase();
    if ((str != null) && (str.length() >= 3))
    {
      int i = str.charAt(j);
      int k = str.charAt(2);
      switch (i)
      {
      case 97: 
        switch (k)
        {
        }
        break;
      }
      j = 0;
    }
    else
    {
      j = -1;
    }
    return j;
  }
  
  public static BluetoothTag parseBluetoothTag(Uri paramUri)
    throws TagParser.TagParseException
  {
    Object localObject = paramUri.getPathSegments();
    try
    {
      localObject = (String)fixupProductNameField((List)localObject).get(3);
      return new BluetoothTag((String)localObject);
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new TagParseException("Wrong no. of segments");
    }
  }
  
  private static int parseIntegerOrFail(String paramString)
    throws TagParser.TagParseException
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new TagParseException(localNumberFormatException);
    }
  }
  
  /* Error */
  public static TagKey parseTagKey(Uri paramUri)
    throws TagParser.TagParseException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 87	android/net/Uri:getPathSegments	()Ljava/util/List;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_3
    //   8: iconst_0
    //   9: invokeinterface 48 2 0
    //   14: checkcast 50	java/lang/String
    //   17: iconst_1
    //   18: invokevirtual 54	java/lang/String:charAt	(I)C
    //   21: istore_1
    //   22: aload_3
    //   23: invokestatic 89	com/sonyericsson/extras/liveware/utils/TagParser:fixupProductNameField	(Ljava/util/List;)Ljava/util/List;
    //   26: astore 4
    //   28: aload 4
    //   30: iconst_1
    //   31: invokeinterface 48 2 0
    //   36: checkcast 50	java/lang/String
    //   39: astore 5
    //   41: aload 4
    //   43: iconst_2
    //   44: invokeinterface 48 2 0
    //   49: checkcast 50	java/lang/String
    //   52: astore 6
    //   54: aload 4
    //   56: iconst_3
    //   57: invokeinterface 48 2 0
    //   62: checkcast 50	java/lang/String
    //   65: invokestatic 111	com/sonyericsson/extras/liveware/utils/TagParser:parseIntegerOrFail	(Ljava/lang/String;)I
    //   68: istore_3
    //   69: iload_1
    //   70: bipush 49
    //   72: if_icmpne +45 -> 117
    //   75: new 113	java/lang/StringBuilder
    //   78: dup
    //   79: ldc 31
    //   81: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload 4
    //   86: iconst_4
    //   87: invokeinterface 48 2 0
    //   92: checkcast 50	java/lang/String
    //   95: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_2
    //   102: new 9	com/sonyericsson/extras/liveware/utils/TagParser$TagKey
    //   105: dup
    //   106: iconst_1
    //   107: aload 5
    //   109: aload 6
    //   111: aload_2
    //   112: iload_3
    //   113: invokespecial 124	com/sonyericsson/extras/liveware/utils/TagParser$TagKey:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   116: areturn
    //   117: iload_1
    //   118: bipush 50
    //   120: if_icmpne -18 -> 102
    //   123: aload 4
    //   125: iconst_4
    //   126: invokeinterface 48 2 0
    //   131: checkcast 50	java/lang/String
    //   134: astore_2
    //   135: goto -33 -> 102
    //   138: pop
    //   139: new 12	com/sonyericsson/extras/liveware/utils/TagParser$TagParseException
    //   142: dup
    //   143: ldc 94
    //   145: invokespecial 95	com/sonyericsson/extras/liveware/utils/TagParser$TagParseException:<init>	(Ljava/lang/String;)V
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramUri	Uri
    //   21	100	1	i	int
    //   6	129	2	str1	String
    //   4	19	3	localList1	List
    //   68	45	3	j	int
    //   26	98	4	localList2	List
    //   39	69	5	str2	String
    //   52	58	6	str3	String
    //   138	1	8	localIndexOutOfBoundsException	IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   0	135	138	java/lang/IndexOutOfBoundsException
  }
  
  public static UidTag parseUidTag(Uri paramUri)
  {
    return null;
  }
  
  public static class BluetoothTag
  {
    private String mBtAddress;
    
    public BluetoothTag(String paramString)
    {
      this.mBtAddress = paramString;
    }
    
    public String getAddress()
    {
      return this.mBtAddress;
    }
  }
  
  public static class TagKey
  {
    private int mConcept;
    private String mPackageName;
    private String mProductId;
    private String mProductName;
    private int mTagCode;
    
    public TagKey(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
    {
      this.mConcept = paramInt1;
      this.mProductId = paramString1;
      this.mProductName = paramString2;
      this.mPackageName = paramString3;
      this.mTagCode = paramInt2;
    }
    
    public int getConcept()
    {
      return this.mConcept;
    }
    
    public String getPackageName()
    {
      return this.mPackageName;
    }
    
    public String getProductId()
    {
      return this.mProductId;
    }
    
    public String getProductName()
    {
      return this.mProductName;
    }
    
    public int getTagCode()
    {
      return this.mTagCode;
    }
  }
  
  public static class TagParseException
    extends Exception
  {
    private static final long serialVersionUID = 2621415302462519454L;
    
    public TagParseException() {}
    
    public TagParseException(String paramString)
    {
      super();
    }
    
    public TagParseException(Throwable paramThrowable)
    {
      super();
    }
  }
  
  public static class UidTag {}
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.TagParser
 * JD-Core Version:    0.7.0.1
 */