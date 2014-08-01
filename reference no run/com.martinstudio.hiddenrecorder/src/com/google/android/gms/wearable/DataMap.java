package com.google.android.gms.wearable;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.lw.a;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.mf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DataMap
{
  public static final String TAG = "DataMap";
  private final HashMap<String, Object> alh = new HashMap();
  
  private static void a(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (!(paramObject instanceof String))
    {
      if (!(paramObject instanceof Integer))
      {
        if (!(paramObject instanceof Long))
        {
          if (!(paramObject instanceof Double))
          {
            if (!(paramObject instanceof Float))
            {
              if (!(paramObject instanceof Boolean))
              {
                if (!(paramObject instanceof Byte))
                {
                  if (!(paramObject instanceof byte[]))
                  {
                    if (!(paramObject instanceof String[]))
                    {
                      if (!(paramObject instanceof long[]))
                      {
                        if (!(paramObject instanceof float[]))
                        {
                          if (!(paramObject instanceof Asset))
                          {
                            if (!(paramObject instanceof DataMap))
                            {
                              if ((paramObject instanceof ArrayList)) {
                                switch (c((ArrayList)paramObject))
                                {
                                default: 
                                  break;
                                case 0: 
                                  paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
                                  break;
                                case 1: 
                                  paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
                                  break;
                                case 2: 
                                  paramBundle.putIntegerArrayList(paramString, (ArrayList)paramObject);
                                  break;
                                case 3: 
                                  paramBundle.putStringArrayList(paramString, (ArrayList)paramObject);
                                  break;
                                case 4: 
                                  ArrayList localArrayList = new ArrayList();
                                  Iterator localIterator = ((ArrayList)paramObject).iterator();
                                  for (;;)
                                  {
                                    if (!localIterator.hasNext())
                                    {
                                      paramBundle.putParcelableArrayList(paramString, localArrayList);
                                      break;
                                    }
                                    localArrayList.add(((DataMap)localIterator.next()).toBundle());
                                  }
                                }
                              }
                            }
                            else {
                              paramBundle.putParcelable(paramString, ((DataMap)paramObject).toBundle());
                            }
                          }
                          else {
                            paramBundle.putParcelable(paramString, (Asset)paramObject);
                          }
                        }
                        else {
                          paramBundle.putFloatArray(paramString, (float[])paramObject);
                        }
                      }
                      else {
                        paramBundle.putLongArray(paramString, (long[])paramObject);
                      }
                    }
                    else {
                      paramBundle.putStringArray(paramString, (String[])paramObject);
                    }
                  }
                  else {
                    paramBundle.putByteArray(paramString, (byte[])paramObject);
                  }
                }
                else {
                  paramBundle.putByte(paramString, ((Byte)paramObject).byteValue());
                }
              }
              else {
                paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
              }
            }
            else {
              paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
            }
          }
          else {
            paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
          }
        }
        else {
          paramBundle.putLong(paramString, ((Long)paramObject).longValue());
        }
      }
      else {
        paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
      }
    }
    else {
      paramBundle.putString(paramString, (String)paramObject);
    }
  }
  
  private static void a(DataMap paramDataMap, String paramString, Object paramObject)
  {
    if (!(paramObject instanceof String))
    {
      if (!(paramObject instanceof Integer))
      {
        if (!(paramObject instanceof Long))
        {
          if (!(paramObject instanceof Double))
          {
            if (!(paramObject instanceof Float))
            {
              if (!(paramObject instanceof Boolean))
              {
                if (!(paramObject instanceof Byte))
                {
                  if (!(paramObject instanceof byte[]))
                  {
                    if (!(paramObject instanceof String[]))
                    {
                      if (!(paramObject instanceof long[]))
                      {
                        if (!(paramObject instanceof float[]))
                        {
                          if (!(paramObject instanceof Asset))
                          {
                            if (!(paramObject instanceof Bundle))
                            {
                              if ((paramObject instanceof ArrayList)) {
                                switch (c((ArrayList)paramObject))
                                {
                                case 4: 
                                default: 
                                  break;
                                case 0: 
                                  paramDataMap.putStringArrayList(paramString, (ArrayList)paramObject);
                                  break;
                                case 1: 
                                  paramDataMap.putStringArrayList(paramString, (ArrayList)paramObject);
                                  break;
                                case 2: 
                                  paramDataMap.putIntegerArrayList(paramString, (ArrayList)paramObject);
                                  break;
                                case 3: 
                                  paramDataMap.putStringArrayList(paramString, (ArrayList)paramObject);
                                  break;
                                case 5: 
                                  paramDataMap.putDataMapArrayList(paramString, arrayListFromBundleArrayList((ArrayList)paramObject));
                                  break;
                                }
                              }
                            }
                            else {
                              paramDataMap.putDataMap(paramString, fromBundle((Bundle)paramObject));
                            }
                          }
                          else {
                            paramDataMap.putAsset(paramString, (Asset)paramObject);
                          }
                        }
                        else {
                          paramDataMap.putFloatArray(paramString, (float[])paramObject);
                        }
                      }
                      else {
                        paramDataMap.putLongArray(paramString, (long[])paramObject);
                      }
                    }
                    else {
                      paramDataMap.putStringArray(paramString, (String[])paramObject);
                    }
                  }
                  else {
                    paramDataMap.putByteArray(paramString, (byte[])paramObject);
                  }
                }
                else {
                  paramDataMap.putByte(paramString, ((Byte)paramObject).byteValue());
                }
              }
              else {
                paramDataMap.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
              }
            }
            else {
              paramDataMap.putFloat(paramString, ((Float)paramObject).floatValue());
            }
          }
          else {
            paramDataMap.putDouble(paramString, ((Double)paramObject).doubleValue());
          }
        }
        else {
          paramDataMap.putLong(paramString, ((Long)paramObject).longValue());
        }
      }
      else {
        paramDataMap.putInt(paramString, ((Integer)paramObject).intValue());
      }
    }
    else {
      paramDataMap.putString(paramString, (String)paramObject);
    }
  }
  
  private void a(String paramString1, Object paramObject, String paramString2, ClassCastException paramClassCastException)
  {
    a(paramString1, paramObject, paramString2, "<null>", paramClassCastException);
  }
  
  private void a(String paramString1, Object paramObject1, String paramString2, Object paramObject2, ClassCastException paramClassCastException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Key ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" expected ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" but value was a ");
    localStringBuilder.append(paramObject1.getClass().getName());
    localStringBuilder.append(".  The default value ");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(" was returned.");
    Log.w("DataMap", localStringBuilder.toString());
    Log.w("DataMap", "Attempt to cast generated internal exception:", paramClassCastException);
  }
  
  private static boolean a(Asset paramAsset1, Asset paramAsset2)
  {
    boolean bool;
    if ((paramAsset1 != null) && (paramAsset2 != null))
    {
      if (TextUtils.isEmpty(paramAsset1.getDigest())) {
        bool = Arrays.equals(paramAsset1.getData(), paramAsset2.getData());
      } else {
        bool = paramAsset1.getDigest().equals(paramAsset2.getDigest());
      }
    }
    else if (paramAsset1 != paramAsset2) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean a(DataMap paramDataMap1, DataMap paramDataMap2)
  {
    boolean bool2 = false;
    label140:
    label268:
    if (paramDataMap1.size() == paramDataMap2.size())
    {
      Iterator localIterator = paramDataMap1.keySet().iterator();
      Object localObject2;
      boolean bool1;
      label172:
      label204:
      label236:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                Object localObject1;
                do
                {
                  if (!localIterator.hasNext())
                  {
                    bool2 = true;
                    break label291;
                  }
                  localObject2 = (String)localIterator.next();
                  localObject1 = paramDataMap1.get((String)localObject2);
                  localObject2 = paramDataMap2.get((String)localObject2);
                  if ((localObject1 instanceof Asset)) {
                    break label268;
                  }
                  if ((localObject1 instanceof String[])) {
                    break label236;
                  }
                  if ((localObject1 instanceof long[])) {
                    break label204;
                  }
                  if ((localObject1 instanceof float[])) {
                    break label172;
                  }
                  if ((localObject1 instanceof byte[])) {
                    break label140;
                  }
                  if ((localObject1 == null) || (localObject2 == null)) {
                    break;
                  }
                } while (localObject1.equals(localObject2));
                break label291;
                if (localObject1 != localObject2) {
                  bool1 = false;
                } else {
                  bool1 = true;
                }
                bool2 = bool1;
                break label291;
                if (!(localObject2 instanceof byte[])) {
                  break label291;
                }
              } while (Arrays.equals((byte[])bool1, (byte[])localObject2));
              break label291;
              if (!(localObject2 instanceof float[])) {
                break label291;
              }
            } while (Arrays.equals((float[])bool1, (float[])localObject2));
            break label291;
            if (!(localObject2 instanceof long[])) {
              break label291;
            }
          } while (Arrays.equals((long[])bool1, (long[])localObject2));
          break label291;
          if (!(localObject2 instanceof String[])) {
            break label291;
          }
        } while (Arrays.equals((String[])bool1, (String[])localObject2));
        break;
      } while (((localObject2 instanceof Asset)) && (a((Asset)bool1, (Asset)localObject2)));
    }
    label291:
    return bool2;
  }
  
  public static ArrayList<DataMap> arrayListFromBundleArrayList(ArrayList<Bundle> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      localArrayList.add(fromBundle((Bundle)localIterator.next()));
    }
  }
  
  private static int c(ArrayList<?> paramArrayList)
  {
    int j;
    if (!paramArrayList.isEmpty())
    {
      Iterator localIterator = paramArrayList.iterator();
      Object localObject;
      do
      {
        do
        {
          if (!localIterator.hasNext())
          {
            int i = 1;
            break;
          }
          localObject = localIterator.next();
        } while (localObject == null);
        if ((localObject instanceof Integer)) {
          break label80;
        }
        if ((localObject instanceof String)) {
          break label75;
        }
        if ((localObject instanceof DataMap)) {
          break;
        }
      } while (!(localObject instanceof Bundle));
      return 5;
      return 4;
      label75:
      return 3;
      label80:
      j = 2;
    }
    else
    {
      j = 0;
    }
    return j;
  }
  
  public static DataMap fromBundle(Bundle paramBundle)
  {
    paramBundle.setClassLoader(Asset.class.getClassLoader());
    DataMap localDataMap = new DataMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localDataMap;
      }
      String str = (String)localIterator.next();
      a(localDataMap, str, paramBundle.get(str));
    }
  }
  
  public static DataMap fromByteArray(byte[] paramArrayOfByte)
  {
    try
    {
      DataMap localDataMap = lw.a(new lw.a(lx.n(paramArrayOfByte), new ArrayList()));
      return localDataMap;
    }
    catch (me localme)
    {
      throw new IllegalArgumentException("Unable to convert data", localme);
    }
  }
  
  public void clear()
  {
    this.alh.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this.alh.containsKey(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof DataMap)) {
      bool = a(this, (DataMap)paramObject);
    } else {
      bool = false;
    }
    return bool;
  }
  
  public <T> T get(String paramString)
  {
    return this.alh.get(paramString);
  }
  
  public Asset getAsset(String paramString)
  {
    Object localObject2 = this.alh.get(paramString);
    Asset localAsset;
    if (localObject2 == null) {
      localAsset = null;
    }
    for (;;)
    {
      return localAsset;
      try
      {
        localAsset = (Asset)localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject2, "Asset", localClassCastException);
        Object localObject1 = null;
      }
    }
  }
  
  public boolean getBoolean(String paramString)
  {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {}
    for (;;)
    {
      return paramBoolean;
      try
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        paramBoolean = bool;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject, "Boolean", Boolean.valueOf(paramBoolean), localClassCastException);
      }
    }
  }
  
  public byte getByte(String paramString)
  {
    return getByte(paramString, (byte)0);
  }
  
  public byte getByte(String paramString, byte paramByte)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {}
    for (;;)
    {
      return paramByte;
      try
      {
        byte b = ((Byte)localObject).byteValue();
        paramByte = b;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject, "Byte", Byte.valueOf(paramByte), localClassCastException);
      }
    }
  }
  
  public byte[] getByteArray(String paramString)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (byte[])localObject;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject, "byte[]", localClassCastException);
        localObject = null;
      }
    }
  }
  
  public DataMap getDataMap(String paramString)
  {
    Object localObject2 = this.alh.get(paramString);
    DataMap localDataMap;
    if (localObject2 == null) {
      localDataMap = null;
    }
    for (;;)
    {
      return localDataMap;
      try
      {
        localDataMap = (DataMap)localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject2, "DataMap", localClassCastException);
        Object localObject1 = null;
      }
    }
  }
  
  public ArrayList<DataMap> getDataMapArrayList(String paramString)
  {
    Object localObject3 = this.alh.get(paramString);
    Object localObject1;
    if (localObject3 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        localObject1 = (ArrayList)localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject3, "ArrayList<DataMap>", localClassCastException);
        Object localObject2 = null;
      }
    }
  }
  
  public double getDouble(String paramString)
  {
    return getDouble(paramString, 0.0D);
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {}
    for (;;)
    {
      return paramDouble;
      try
      {
        double d = ((Double)localObject).doubleValue();
        paramDouble = d;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject, "Double", Double.valueOf(paramDouble), localClassCastException);
      }
    }
  }
  
  public float getFloat(String paramString)
  {
    return getFloat(paramString, 0.0F);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {}
    for (;;)
    {
      return paramFloat;
      try
      {
        float f = ((Float)localObject).floatValue();
        paramFloat = f;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject, "Float", Float.valueOf(paramFloat), localClassCastException);
      }
    }
  }
  
  public float[] getFloatArray(String paramString)
  {
    Object localObject2 = this.alh.get(paramString);
    float[] arrayOfFloat;
    if (localObject2 == null) {
      arrayOfFloat = null;
    }
    for (;;)
    {
      return arrayOfFloat;
      try
      {
        arrayOfFloat = (float[])localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject2, "float[]", localClassCastException);
        Object localObject1 = null;
      }
    }
  }
  
  public int getInt(String paramString)
  {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {}
    for (;;)
    {
      return paramInt;
      try
      {
        i = ((Integer)localObject).intValue();
        paramInt = i;
      }
      catch (ClassCastException localClassCastException)
      {
        int i;
        a(paramString, i, "Integer", localClassCastException);
      }
    }
  }
  
  public ArrayList<Integer> getIntegerArrayList(String paramString)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (ArrayList)localObject;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject, "ArrayList<Integer>", localClassCastException);
        localObject = null;
      }
    }
  }
  
  public long getLong(String paramString)
  {
    return getLong(paramString, 0L);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {}
    for (;;)
    {
      return paramLong;
      try
      {
        long l = ((Long)localObject).longValue();
        paramLong = l;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject, "long", localClassCastException);
      }
    }
  }
  
  public long[] getLongArray(String paramString)
  {
    Object localObject = this.alh.get(paramString);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = (long[])localObject;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject, "long[]", localClassCastException);
        localObject = null;
      }
    }
  }
  
  public String getString(String paramString)
  {
    Object localObject2 = this.alh.get(paramString);
    String str;
    if (localObject2 == null) {
      str = null;
    }
    for (;;)
    {
      return str;
      try
      {
        str = (String)localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject2, "String", localClassCastException);
        Object localObject1 = null;
      }
    }
  }
  
  public String getString(String paramString1, String paramString2)
  {
    String str = getString(paramString1);
    if (str != null) {
      paramString2 = str;
    }
    return paramString2;
  }
  
  public String[] getStringArray(String paramString)
  {
    Object localObject2 = this.alh.get(paramString);
    String[] arrayOfString;
    if (localObject2 == null) {
      arrayOfString = null;
    }
    for (;;)
    {
      return arrayOfString;
      try
      {
        arrayOfString = (String[])localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject2, "String[]", localClassCastException);
        Object localObject1 = null;
      }
    }
  }
  
  public ArrayList<String> getStringArrayList(String paramString)
  {
    Object localObject3 = this.alh.get(paramString);
    Object localObject1;
    if (localObject3 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        localObject1 = (ArrayList)localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        a(paramString, localObject3, "ArrayList<String>", localClassCastException);
        Object localObject2 = null;
      }
    }
  }
  
  public int hashCode()
  {
    return 29 * this.alh.hashCode();
  }
  
  public boolean isEmpty()
  {
    return this.alh.isEmpty();
  }
  
  public Set<String> keySet()
  {
    return this.alh.keySet();
  }
  
  public void putAll(DataMap paramDataMap)
  {
    Iterator localIterator = paramDataMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      this.alh.put(str, paramDataMap.get(str));
    }
  }
  
  public void putAsset(String paramString, Asset paramAsset)
  {
    this.alh.put(paramString, paramAsset);
  }
  
  public void putBoolean(String paramString, boolean paramBoolean)
  {
    this.alh.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void putByte(String paramString, byte paramByte)
  {
    this.alh.put(paramString, Byte.valueOf(paramByte));
  }
  
  public void putByteArray(String paramString, byte[] paramArrayOfByte)
  {
    this.alh.put(paramString, paramArrayOfByte);
  }
  
  public void putDataMap(String paramString, DataMap paramDataMap)
  {
    this.alh.put(paramString, paramDataMap);
  }
  
  public void putDataMapArrayList(String paramString, ArrayList<DataMap> paramArrayList)
  {
    this.alh.put(paramString, paramArrayList);
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    this.alh.put(paramString, Double.valueOf(paramDouble));
  }
  
  public void putFloat(String paramString, float paramFloat)
  {
    this.alh.put(paramString, Float.valueOf(paramFloat));
  }
  
  public void putFloatArray(String paramString, float[] paramArrayOfFloat)
  {
    this.alh.put(paramString, paramArrayOfFloat);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    this.alh.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void putIntegerArrayList(String paramString, ArrayList<Integer> paramArrayList)
  {
    this.alh.put(paramString, paramArrayList);
  }
  
  public void putLong(String paramString, long paramLong)
  {
    this.alh.put(paramString, Long.valueOf(paramLong));
  }
  
  public void putLongArray(String paramString, long[] paramArrayOfLong)
  {
    this.alh.put(paramString, paramArrayOfLong);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    this.alh.put(paramString1, paramString2);
  }
  
  public void putStringArray(String paramString, String[] paramArrayOfString)
  {
    this.alh.put(paramString, paramArrayOfString);
  }
  
  public void putStringArrayList(String paramString, ArrayList<String> paramArrayList)
  {
    this.alh.put(paramString, paramArrayList);
  }
  
  public Object remove(String paramString)
  {
    return this.alh.remove(paramString);
  }
  
  public int size()
  {
    return this.alh.size();
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.alh.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localBundle;
      }
      String str = (String)localIterator.next();
      a(localBundle, str, this.alh.get(str));
    }
  }
  
  public byte[] toByteArray()
  {
    return mf.d(lw.a(this).amm);
  }
  
  public String toString()
  {
    return this.alh.toString();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMap
 * JD-Core Version:    0.7.0.1
 */