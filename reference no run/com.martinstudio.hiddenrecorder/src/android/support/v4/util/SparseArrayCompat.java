package android.support.v4.util;

public class SparseArrayCompat<E>
  implements Cloneable
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
    if (paramInt != 0)
    {
      int i = ContainerHelpers.idealIntArraySize(paramInt);
      this.mKeys = new int[i];
      this.mValues = new Object[i];
    }
    else
    {
      this.mKeys = ContainerHelpers.EMPTY_INTS;
      this.mValues = ContainerHelpers.EMPTY_OBJECTS;
    }
    this.mSize = 0;
  }
  
  private void gc()
  {
    int j = this.mSize;
    int i = 0;
    int[] arrayOfInt = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    for (int k = 0;; k++)
    {
      if (k >= j)
      {
        this.mGarbage = false;
        this.mSize = i;
        return;
      }
      Object localObject = arrayOfObject[k];
      if (localObject != DELETED)
      {
        if (k != i)
        {
          arrayOfInt[i] = arrayOfInt[k];
          arrayOfObject[i] = localObject;
          arrayOfObject[k] = null;
        }
        i++;
      }
    }
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
        int j = ContainerHelpers.idealIntArraySize(i + 1);
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
  
  public SparseArrayCompat<E> clone()
  {
    SparseArrayCompat localSparseArrayCompat = null;
    try
    {
      localSparseArrayCompat = (SparseArrayCompat)super.clone();
      localSparseArrayCompat.mKeys = ((int[])this.mKeys.clone());
      localSparseArrayCompat.mValues = ((Object[])this.mValues.clone());
      label38:
      return localSparseArrayCompat;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      break label38;
    }
  }
  
  public void delete(int paramInt)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
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
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
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
    return ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
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
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
    if (i < 0)
    {
      i ^= 0xFFFFFFFF;
      if ((i >= this.mSize) || (this.mValues[i] != DELETED))
      {
        if ((this.mGarbage) && (this.mSize >= this.mKeys.length))
        {
          gc();
          i = 0xFFFFFFFF ^ ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
        }
        if (this.mSize >= this.mKeys.length)
        {
          int j = ContainerHelpers.idealIntArraySize(1 + this.mSize);
          int[] arrayOfInt = new int[j];
          Object[] arrayOfObject = new Object[j];
          System.arraycopy(this.mKeys, 0, arrayOfInt, 0, this.mKeys.length);
          System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
          this.mKeys = arrayOfInt;
          this.mValues = arrayOfObject;
        }
        if (this.mSize - i != 0)
        {
          System.arraycopy(this.mKeys, i, this.mKeys, i + 1, this.mSize - i);
          System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
        }
        this.mKeys[i] = paramInt;
        this.mValues[i] = paramE;
        this.mSize = (1 + this.mSize);
      }
      else
      {
        this.mKeys[i] = paramInt;
        this.mValues[i] = paramE;
      }
    }
    else
    {
      this.mValues[i] = paramE;
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
    int j = Math.min(this.mSize, paramInt1 + paramInt2);
    for (int i = paramInt1;; i++)
    {
      if (i >= j) {
        return;
      }
      removeAt(i);
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
 * Qualified Name:     android.support.v4.util.SparseArrayCompat
 * JD-Core Version:    0.7.0.1
 */