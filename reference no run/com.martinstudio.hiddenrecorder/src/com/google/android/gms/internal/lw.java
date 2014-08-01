package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class lw
{
  private static int a(String paramString, lx.a.a[] paramArrayOfa)
  {
    int k = paramArrayOfa.length;
    int j = 0;
    int i = 14;
    for (;;)
    {
      if (j >= k) {
        return i;
      }
      lx.a.a locala = paramArrayOfa[j];
      if (i != 14)
      {
        if (locala.type != i) {
          throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + i + " and " + locala.type);
        }
      }
      else if ((locala.type != 9) && (locala.type != 2) && (locala.type != 6))
      {
        if (locala.type != 14) {
          throw new IllegalArgumentException("Unexpected TypedValue type: " + locala.type + " for key " + paramString);
        }
      }
      else {
        i = locala.type;
      }
      j++;
    }
  }
  
  static int a(List<Asset> paramList, Asset paramAsset)
  {
    paramList.add(paramAsset);
    return -1 + paramList.size();
  }
  
  public static a a(DataMap paramDataMap)
  {
    lx locallx = new lx();
    ArrayList localArrayList = new ArrayList();
    locallx.amo = a(paramDataMap, localArrayList);
    return new a(locallx, localArrayList);
  }
  
  private static lx.a.a a(List<Asset> paramList, Object paramObject)
  {
    lx.a.a locala = new lx.a.a();
    if (paramObject != null)
    {
      locala.ams = new lx.a.a.a();
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
                                if (!(paramObject instanceof ArrayList)) {
                                  throw new RuntimeException("newFieldValueFromValue: unexpected value " + paramObject.getClass().getSimpleName());
                                }
                                locala.type = 10;
                                ArrayList localArrayList = (ArrayList)paramObject;
                                localObject1 = new lx.a.a[localArrayList.size()];
                                Object localObject5 = null;
                                int i = localArrayList.size();
                                j = 0;
                                int k = 14;
                                for (;;)
                                {
                                  if (j >= i)
                                  {
                                    locala.ams.amC = ((lx.a.a[])localObject1);
                                    break label794;
                                  }
                                  localObject2 = localArrayList.get(j);
                                  localObject4 = a(paramList, localObject2);
                                  if ((((lx.a.a)localObject4).type != 14) && (((lx.a.a)localObject4).type != 2) && (((lx.a.a)localObject4).type != 6) && (((lx.a.a)localObject4).type != 9)) {
                                    break;
                                  }
                                  if ((k != 14) || (((lx.a.a)localObject4).type == 14))
                                  {
                                    if (((lx.a.a)localObject4).type == k)
                                    {
                                      localObject2 = localObject5;
                                      k = k;
                                    }
                                    else
                                    {
                                      throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + localObject5.getClass() + " and a " + localObject2.getClass());
                                    }
                                  }
                                  else {
                                    k = ((lx.a.a)localObject4).type;
                                  }
                                  localObject1[j] = localObject4;
                                  j++;
                                  k = k;
                                  localObject5 = localObject2;
                                }
                                throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + localObject2.getClass());
                              }
                              locala.type = 9;
                              Object localObject1 = (DataMap)paramObject;
                              Object localObject3 = ((DataMap)localObject1).keySet();
                              Object localObject2 = new lx.a[((Set)localObject3).size()];
                              Object localObject4 = ((Set)localObject3).iterator();
                              for (int j = 0;; j++)
                              {
                                if (!((Iterator)localObject4).hasNext())
                                {
                                  locala.ams.amB = ((lx.a[])localObject2);
                                  break;
                                }
                                localObject3 = (String)((Iterator)localObject4).next();
                                localObject2[j] = new lx.a();
                                localObject2[j].name = ((String)localObject3);
                                localObject2[j].amq = a(paramList, ((DataMap)localObject1).get((String)localObject3));
                              }
                            }
                            locala.type = 13;
                            locala.ams.amG = a(paramList, (Asset)paramObject);
                          }
                          else
                          {
                            locala.type = 15;
                            locala.ams.amF = ((float[])paramObject);
                          }
                        }
                        else
                        {
                          locala.type = 12;
                          locala.ams.amE = ((long[])paramObject);
                        }
                      }
                      else
                      {
                        locala.type = 11;
                        locala.ams.amD = ((String[])paramObject);
                      }
                    }
                    else
                    {
                      locala.type = 1;
                      locala.ams.amt = ((byte[])paramObject);
                    }
                  }
                  else
                  {
                    locala.type = 7;
                    locala.ams.amz = ((Byte)paramObject).byteValue();
                  }
                }
                else
                {
                  locala.type = 8;
                  locala.ams.amA = ((Boolean)paramObject).booleanValue();
                }
              }
              else
              {
                locala.type = 4;
                locala.ams.amw = ((Float)paramObject).floatValue();
              }
            }
            else
            {
              locala.type = 3;
              locala.ams.amv = ((Double)paramObject).doubleValue();
            }
          }
          else
          {
            locala.type = 5;
            locala.ams.amx = ((Long)paramObject).longValue();
          }
        }
        else
        {
          locala.type = 6;
          locala.ams.amy = ((Integer)paramObject).intValue();
        }
      }
      else
      {
        locala.type = 2;
        locala.ams.amu = ((String)paramObject);
      }
      label794:
      locala = locala;
    }
    else
    {
      locala.type = 14;
      locala = locala;
    }
    return locala;
  }
  
  public static DataMap a(a parama)
  {
    DataMap localDataMap = new DataMap();
    lx.a[] arrayOfa = parama.amm.amo;
    int j = arrayOfa.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return localDataMap;
      }
      lx.a locala = arrayOfa[i];
      a(parama.amn, localDataMap, locala.name, locala.amq);
    }
  }
  
  private static ArrayList a(List<Asset> paramList, lx.a.a.a parama, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(parama.amC.length);
    lx.a.a[] arrayOfa = parama.amC;
    int j = arrayOfa.length;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return localArrayList;
      }
      Object localObject1 = arrayOfa[i];
      if (((lx.a.a)localObject1).type != 14)
      {
        if (paramInt != 9)
        {
          if (paramInt != 2)
          {
            if (paramInt != 6) {
              throw new IllegalArgumentException("Unexpected typeOfArrayList: " + paramInt);
            }
            localArrayList.add(Integer.valueOf(((lx.a.a)localObject1).ams.amy));
          }
          else
          {
            localArrayList.add(((lx.a.a)localObject1).ams.amu);
          }
        }
        else
        {
          DataMap localDataMap = new DataMap();
          localObject1 = ((lx.a.a)localObject1).ams.amB;
          int m = localObject1.length;
          for (int k = 0;; k++)
          {
            if (k >= m)
            {
              localArrayList.add(localDataMap);
              break;
            }
            Object localObject2 = localObject1[k];
            a(paramList, localDataMap, localObject2.name, localObject2.amq);
          }
        }
      }
      else {
        localArrayList.add(null);
      }
    }
  }
  
  private static void a(List<Asset> paramList, DataMap paramDataMap, String paramString, lx.a.a parama)
  {
    int i = parama.type;
    if (i != 14)
    {
      Object localObject1 = parama.ams;
      if (i != 1)
      {
        if (i != 11)
        {
          if (i != 12)
          {
            if (i != 15)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i != 4)
                  {
                    if (i != 5)
                    {
                      if (i != 6)
                      {
                        if (i != 7)
                        {
                          if (i != 8)
                          {
                            if (i != 13)
                            {
                              if (i != 9)
                              {
                                if (i != 10) {
                                  throw new RuntimeException("populateBundle: unexpected type " + i);
                                }
                                i = a(paramString, ((lx.a.a.a)localObject1).amC);
                                localObject1 = a(paramList, (lx.a.a.a)localObject1, i);
                                if (i != 14)
                                {
                                  if (i != 9)
                                  {
                                    if (i != 2)
                                    {
                                      if (i != 6) {
                                        throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
                                      }
                                      paramDataMap.putIntegerArrayList(paramString, (ArrayList)localObject1);
                                    }
                                    else
                                    {
                                      paramDataMap.putStringArrayList(paramString, (ArrayList)localObject1);
                                    }
                                  }
                                  else {
                                    paramDataMap.putDataMapArrayList(paramString, (ArrayList)localObject1);
                                  }
                                }
                                else {
                                  paramDataMap.putStringArrayList(paramString, (ArrayList)localObject1);
                                }
                              }
                              else
                              {
                                DataMap localDataMap = new DataMap();
                                localObject1 = ((lx.a.a.a)localObject1).amB;
                                int k = localObject1.length;
                                for (int j = 0;; j++)
                                {
                                  if (j >= k)
                                  {
                                    paramDataMap.putDataMap(paramString, localDataMap);
                                    break;
                                  }
                                  Object localObject2 = localObject1[j];
                                  a(paramList, localDataMap, localObject2.name, localObject2.amq);
                                }
                              }
                            }
                            else if (paramList != null) {
                              paramDataMap.putAsset(paramString, (Asset)paramList.get((int)((lx.a.a.a)localObject1).amG));
                            } else {
                              throw new RuntimeException("populateBundle: unexpected type for: " + paramString);
                            }
                          }
                          else {
                            paramDataMap.putBoolean(paramString, ((lx.a.a.a)localObject1).amA);
                          }
                        }
                        else {
                          paramDataMap.putByte(paramString, (byte)((lx.a.a.a)localObject1).amz);
                        }
                      }
                      else {
                        paramDataMap.putInt(paramString, ((lx.a.a.a)localObject1).amy);
                      }
                    }
                    else {
                      paramDataMap.putLong(paramString, ((lx.a.a.a)localObject1).amx);
                    }
                  }
                  else {
                    paramDataMap.putFloat(paramString, ((lx.a.a.a)localObject1).amw);
                  }
                }
                else {
                  paramDataMap.putDouble(paramString, ((lx.a.a.a)localObject1).amv);
                }
              }
              else {
                paramDataMap.putString(paramString, ((lx.a.a.a)localObject1).amu);
              }
            }
            else {
              paramDataMap.putFloatArray(paramString, ((lx.a.a.a)localObject1).amF);
            }
          }
          else {
            paramDataMap.putLongArray(paramString, ((lx.a.a.a)localObject1).amE);
          }
        }
        else {
          paramDataMap.putStringArray(paramString, ((lx.a.a.a)localObject1).amD);
        }
      }
      else {
        paramDataMap.putByteArray(paramString, ((lx.a.a.a)localObject1).amt);
      }
    }
    else
    {
      paramDataMap.putString(paramString, null);
    }
  }
  
  private static lx.a[] a(DataMap paramDataMap, List<Asset> paramList)
  {
    Set localSet = paramDataMap.keySet();
    lx.a[] arrayOfa = new lx.a[localSet.size()];
    Iterator localIterator = localSet.iterator();
    for (int i = 0;; i++)
    {
      if (!localIterator.hasNext()) {
        return arrayOfa;
      }
      String str = (String)localIterator.next();
      Object localObject = paramDataMap.get(str);
      arrayOfa[i] = new lx.a();
      arrayOfa[i].name = str;
      arrayOfa[i].amq = a(paramList, localObject);
    }
  }
  
  public static class a
  {
    public final lx amm;
    public final List<Asset> amn;
    
    public a(lx paramlx, List<Asset> paramList)
    {
      this.amm = paramlx;
      this.amn = paramList;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lw
 * JD-Core Version:    0.7.0.1
 */