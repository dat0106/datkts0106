package android.support.v4.util;

public class SparseArrayCompat<E>
{
  private static final Object DELETED = new Object();
  private boolean mGarbage = false;
  private int[] mKeys;
  private int mSize;
  private Object[] mValues;
  
  public SparseArrayCompat()
  {
    this(10);
  }
  
  public SparseArrayCompat(int paramInt)
  {
    int i = idealIntArraySize(paramInt);
    this.mKeys = new int[i];
    this.mValues = new Object[i];
    this.mSize = 0;
  }
  
  private static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 + paramInt2;
    int j = paramInt1 - 1;
    for (;;)
    {
      if (i - j <= 1)
      {
        if (i != paramInt1 + paramInt2)
        {
          if (paramArrayOfInt[i] != paramInt3) {
            i ^= 0xFFFFFFFF;
          }
        }
        else {
          i = 0xFFFFFFFF ^ paramInt1 + paramInt2;
        }
        return i;
      }
      int k = (i + j) / 2;
      if (paramArrayOfInt[k] >= paramInt3) {
        i = k;
      } else {
        j = k;
      }
    }
  }
  
  private void gc()
  {
    int k = this.mSize;
    int j = 0;
    int[] arrayOfInt = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    for (int i = 0;; i++)
    {
      if (i >= k)
      {
        this.mGarbage = false;
        this.mSize = j;
        return;
      }
      Object localObject = arrayOfObject[i];
      if (localObject != DELETED)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
        }
        j++;
      }
    }
  }
  
  static int idealByteArraySize(int paramInt)
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
  
  static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public void append(int paramInt, E paramE)
  {
    if ((this.mSize == 0) || (paramInt > this.mKeys[(-1 + this.mSize)]))
    {
      if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
        gc();
      }
      int i = this.mSize;
      if (i >= this.mKeys.length)
      {
        int j = idealIntArraySize(i + 1);
        int[] arrayOfInt = new int[j];
        Object[] arrayOfObject = new Object[j];
        System.arraycopy(this.mKeys, 0, arrayOfInt, 0, this.mKeys.length);
        System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
        this.mKeys = arrayOfInt;
        this.mValues = arrayOfObject;
      }
      this.mKeys[i] = paramInt;
      this.mValues[i] = paramE;
      this.mSize = (i + 1);
    }
    else
    {
      put(paramInt, paramE);
    }
  }
  
  public void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.mValues;
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        this.mSize = 0;
        this.mGarbage = false;
        return;
      }
      arrayOfObject[i] = null;
    }
  }
  
  public void delete(int paramInt)
  {
    int i = binarySearch(this.mKeys, 0, this.mSize, paramInt);
    if ((i >= 0) && (this.mValues[i] != DELETED))
    {
      this.mValues[i] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public E get(int paramInt)
  {
    return get(paramInt, null);
  }
  
  public E get(int paramInt, E paramE)
  {
    int i = binarySearch(this.mKeys, 0, this.mSize, paramInt);
    if ((i >= 0) && (this.mValues[i] != DELETED)) {
      paramE = this.mValues[i];
    }
    return paramE;
  }
  
  public int indexOfKey(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return binarySearch(this.mKeys, 0, this.mSize, paramInt);
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
  
  public int keyAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mKeys[paramInt];
  }
  
  public void put(int paramInt, E paramE)
  {
    int i = binarySearch(this.mKeys, 0, this.mSize, paramInt);
    int[] arrayOfInt;
    if (i < 0)
    {
      int j = i ^ 0xFFFFFFFF;
      if ((j >= this.mSize) || (this.mValues[j] != DELETED))
      {
        if ((this.mGarbage) && (this.mSize >= this.mKeys.length))
        {
          gc();
          j = 0xFFFFFFFF ^ binarySearch(this.mKeys, 0, this.mSize, paramInt);
        }
        if (this.mSize >= this.mKeys.length)
        {
          int k = idealIntArraySize(1 + this.mSize);
          arrayOfInt = new int[k];
          Object[] arrayOfObject = new Object[k];
          System.arraycopy(this.mKeys, 0, arrayOfInt, 0, this.mKeys.length);
          System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
          this.mKeys = arrayOfInt;
          this.mValues = arrayOfObject;
        }
        if (this.mSize - j != 0)
        {
          System.arraycopy(this.mKeys, j, this.mKeys, j + 1, this.mSize - j);
          System.arraycopy(this.mValues, j, this.mValues, j + 1, this.mSize - j);
        }
        this.mKeys[j] = paramInt;
        this.mValues[j] = paramE;
        this.mSize = (1 + this.mSize);
      }
      else
      {
        this.mKeys[j] = paramInt;
        this.mValues[j] = paramE;
      }
    }
    else
    {
      this.mValues[arrayOfInt] = paramE;
    }
  }
  
  public void remove(int paramInt)
  {
    delete(paramInt);
  }
  
  public void removeAt(int paramInt)
  {
    if (this.mValues[paramInt] != DELETED)
    {
      this.mValues[paramInt] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public void removeAtRange(int paramInt1, int paramInt2)
  {
    int i = Math.min(this.mSize, paramInt1 + paramInt2);
    for (int j = paramInt1;; j++)
    {
      if (j >= i) {
        return;
      }
      removeAt(j);
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
 * Qualified Name:     android.support.v4.util.SparseArrayCompat
 * JD-Core Version:    0.7.0.1
 */