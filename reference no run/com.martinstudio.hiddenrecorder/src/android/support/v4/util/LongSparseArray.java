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
    if (paramInt != 0)
    {
      int i = ContainerHelpers.idealLongArraySize(paramInt);
      this.mKeys = new long[i];
      this.mValues = new Object[i];
    }
    else
    {
      this.mKeys = ContainerHelpers.EMPTY_LONGS;
      this.mValues = ContainerHelpers.EMPTY_OBJECTS;
    }
    this.mSize = 0;
  }
  
  private void gc()
  {
    int k = this.mSize;
    int i = 0;
    long[] arrayOfLong = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    for (int j = 0;; j++)
    {
      if (j >= k)
      {
        this.mGarbage = false;
        this.mSize = i;
        return;
      }
      Object localObject = arrayOfObject[j];
      if (localObject != DELETED)
      {
        if (j != i)
        {
          arrayOfLong[i] = arrayOfLong[j];
          arrayOfObject[i] = localObject;
          arrayOfObject[j] = null;
        }
        i++;
      }
    }
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
        int j = ContainerHelpers.idealLongArraySize(i + 1);
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
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
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
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
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
    return ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
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
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    long[] arrayOfLong;
    if (i < 0)
    {
      int j = i ^ 0xFFFFFFFF;
      if ((j >= this.mSize) || (this.mValues[j] != DELETED))
      {
        if ((this.mGarbage) && (this.mSize >= this.mKeys.length))
        {
          gc();
          j = 0xFFFFFFFF ^ ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
        }
        if (this.mSize >= this.mKeys.length)
        {
          int k = ContainerHelpers.idealLongArraySize(1 + this.mSize);
          arrayOfLong = new long[k];
          Object[] arrayOfObject = new Object[k];
          System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
          System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
          this.mKeys = arrayOfLong;
          this.mValues = arrayOfObject;
        }
        if (this.mSize - j != 0)
        {
          System.arraycopy(this.mKeys, j, this.mKeys, j + 1, this.mSize - j);
          System.arraycopy(this.mValues, j, this.mValues, j + 1, this.mSize - j);
        }
        this.mKeys[j] = paramLong;
        this.mValues[j] = paramE;
        this.mSize = (1 + this.mSize);
      }
      else
      {
        this.mKeys[j] = paramLong;
        this.mValues[j] = paramE;
      }
    }
    else
    {
      this.mValues[arrayOfLong] = paramE;
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
  
  public String toString()
  {
    if (size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(28 * this.mSize);
      localStringBuilder.append('{');
      for (int i = 0;; str++)
      {
        if (i >= this.mSize)
        {
          localStringBuilder.append('}');
          str = localStringBuilder.toString();
          break;
        }
        if (str > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(keyAt(str));
        localStringBuilder.append('=');
        Object localObject = valueAt(str);
        if (localObject == this) {
          localStringBuilder.append("(this Map)");
        } else {
          localStringBuilder.append(localObject);
        }
      }
    }
    String str = "{}";
    return str;
  }
  
  public E valueAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mValues[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.LongSparseArray
 * JD-Core Version:    0.7.0.1
 */