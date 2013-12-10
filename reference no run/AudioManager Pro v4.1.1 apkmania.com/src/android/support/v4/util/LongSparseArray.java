package android.support.v4.util;

public class LongSparseArray<E>
  implements Cloneable
{
  private static final Object DELETED = new Object();
  private boolean mGarbage = false;
  private long[] mKeys;
  private int mSize;
  private Object[] mValues;
  
  public LongSparseArray()
  {
    this(10);
  }
  
  public LongSparseArray(int paramInt)
  {
    int i = idealLongArraySize(paramInt);
    this.mKeys = new long[i];
    this.mValues = new Object[i];
    this.mSize = 0;
  }
  
  private static int binarySearch(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    int j = paramInt1 + paramInt2;
    int k = paramInt1 - 1;
    for (;;)
    {
      if (j - k <= 1)
      {
        if (j != paramInt1 + paramInt2)
        {
          if (paramArrayOfLong[j] != paramLong) {
            j ^= 0xFFFFFFFF;
          }
        }
        else {
          j = 0xFFFFFFFF ^ paramInt1 + paramInt2;
        }
        return j;
      }
      int i = (j + k) / 2;
      if (paramArrayOfLong[i] >= paramLong) {
        j = i;
      } else {
        k = i;
      }
    }
  }
  
  private void gc()
  {
    int i = this.mSize;
    int k = 0;
    long[] arrayOfLong = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        this.mGarbage = false;
        this.mSize = k;
        return;
      }
      Object localObject = arrayOfObject[j];
      if (localObject != DELETED)
      {
        if (j != k)
        {
          arrayOfLong[k] = arrayOfLong[j];
          arrayOfObject[k] = localObject;
          arrayOfObject[j] = null;
        }
        k++;
      }
    }
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    int i = 4;
    while (i < 32) {
      if (paramInt > -12 + (1 << i)) {
        i++;
      } else {
        paramInt = -12 + (1 << i);
      }
    }
    return paramInt;
  }
  
  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
  
  public void append(long paramLong, E paramE)
  {
    if ((this.mSize == 0) || (paramLong > this.mKeys[(-1 + this.mSize)]))
    {
      if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
        gc();
      }
      int i = this.mSize;
      if (i >= this.mKeys.length)
      {
        int j = idealLongArraySize(i + 1);
        long[] arrayOfLong = new long[j];
        Object[] arrayOfObject = new Object[j];
        System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
        System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
        this.mKeys = arrayOfLong;
        this.mValues = arrayOfObject;
      }
      this.mKeys[i] = paramLong;
      this.mValues[i] = paramE;
      this.mSize = (i + 1);
    }
    else
    {
      put(paramLong, paramE);
    }
  }
  
  public void clear()
  {
    int i = this.mSize;
    Object[] arrayOfObject = this.mValues;
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        this.mSize = 0;
        this.mGarbage = false;
        return;
      }
      arrayOfObject[j] = null;
    }
  }
  
  public LongSparseArray<E> clone()
  {
    LongSparseArray localLongSparseArray = null;
    try
    {
      localLongSparseArray = (LongSparseArray)super.clone();
      localLongSparseArray.mKeys = ((long[])this.mKeys.clone());
      localLongSparseArray.mValues = ((Object[])this.mValues.clone());
      label38:
      return localLongSparseArray;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      break label38;
    }
  }
  
  public void delete(long paramLong)
  {
    int i = binarySearch(this.mKeys, 0, this.mSize, paramLong);
    if ((i >= 0) && (this.mValues[i] != DELETED))
    {
      this.mValues[i] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public E get(long paramLong)
  {
    return get(paramLong, null);
  }
  
  public E get(long paramLong, E paramE)
  {
    int i = binarySearch(this.mKeys, 0, this.mSize, paramLong);
    if ((i >= 0) && (this.mValues[i] != DELETED)) {
      paramE = this.mValues[i];
    }
    return paramE;
  }
  
  public int indexOfKey(long paramLong)
  {
    if (this.mGarbage) {
      gc();
    }
    return binarySearch(this.mKeys, 0, this.mSize, paramLong);
  }
  
  public int indexOfValue(E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    for (int i = 0;; i++)
    {
      if (i >= this.mSize)
      {
        i = -1;
        break;
      }
      if (this.mValues[i] == paramE) {
        break;
      }
    }
    return i;
  }
  
  public long keyAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mKeys[paramInt];
  }
  
  public void put(long paramLong, E paramE)
  {
    int i = binarySearch(this.mKeys, 0, this.mSize, paramLong);
    if (i < 0)
    {
      i ^= 0xFFFFFFFF;
      if ((i >= this.mSize) || (this.mValues[i] != DELETED))
      {
        if ((this.mGarbage) && (this.mSize >= this.mKeys.length))
        {
          gc();
          i = 0xFFFFFFFF ^ binarySearch(this.mKeys, 0, this.mSize, paramLong);
        }
        if (this.mSize >= this.mKeys.length)
        {
          int j = idealLongArraySize(1 + this.mSize);
          long[] arrayOfLong = new long[j];
          Object[] arrayOfObject = new Object[j];
          System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
          System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
          this.mKeys = arrayOfLong;
          this.mValues = arrayOfObject;
        }
        if (this.mSize - i != 0)
        {
          System.arraycopy(this.mKeys, i, this.mKeys, i + 1, this.mSize - i);
          System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
        }
        this.mKeys[i] = paramLong;
        this.mValues[i] = paramE;
        this.mSize = (1 + this.mSize);
      }
      else
      {
        this.mKeys[i] = paramLong;
        this.mValues[i] = paramE;
      }
    }
    else
    {
      this.mValues[i] = paramE;
    }
  }
  
  public void remove(long paramLong)
  {
    delete(paramLong);
  }
  
  public void removeAt(int paramInt)
  {
    if (this.mValues[paramInt] != DELETED)
    {
      this.mValues[paramInt] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public void setValueAt(int paramInt, E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    this.mValues[paramInt] = paramE;
  }
  
  public int size()
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mSize;
  }
  
  public E valueAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mValues[paramInt];
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.LongSparseArray
 * JD-Core Version:    0.7.0.1
 */