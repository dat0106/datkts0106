package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class MapCollections<K, V>
{
  MapCollections<K, V>.EntrySet mEntrySet;
  MapCollections<K, V>.KeySet mKeySet;
  MapCollections<K, V>.ValuesCollection mValues;
  
  public static <K, V> boolean containsAllHelper(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    do
    {
      if (!localIterator.hasNext())
      {
        bool = true;
        break;
      }
    } while (paramMap.containsKey(bool.next()));
    boolean bool = false;
    return bool;
  }
  
  public static <T> boolean equalsSetHelper(Set<T> paramSet, Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramSet == paramObject) {
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      if ((paramObject instanceof Set))
      {
        Set localSet = (Set)paramObject;
        try
        {
          if (paramSet.size() == localSet.size())
          {
            bool2 = paramSet.containsAll(localSet);
            if (!bool2) {}
          }
          for (;;)
          {
            bool2 = bool1;
            break;
            bool1 = false;
          }
        }
        catch (NullPointerException localNullPointerException) {}catch (ClassCastException localClassCastException) {}
      }
    }
  }
  
  public static <K, V> boolean removeAllHelper(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramCollection.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (i == paramMap.size()) {
          i = 0;
        } else {
          i = 1;
        }
        return i;
      }
      paramMap.remove(localIterator.next());
    }
  }
  
  public static <K, V> boolean retainAllHelper(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      boolean bool;
      if (!localIterator.hasNext())
      {
        if (i == paramMap.size()) {
          bool = false;
        } else {
          bool = true;
        }
        return bool;
      }
      if (!paramCollection.contains(bool.next())) {
        bool.remove();
      }
    }
  }
  
  protected abstract void colClear();
  
  protected abstract Object colGetEntry(int paramInt1, int paramInt2);
  
  protected abstract Map<K, V> colGetMap();
  
  protected abstract int colGetSize();
  
  protected abstract int colIndexOfKey(Object paramObject);
  
  protected abstract int colIndexOfValue(Object paramObject);
  
  protected abstract void colPut(K paramK, V paramV);
  
  protected abstract void colRemoveAt(int paramInt);
  
  protected abstract V colSetValue(int paramInt, V paramV);
  
  public Set<Map.Entry<K, V>> getEntrySet()
  {
    if (this.mEntrySet == null) {
      this.mEntrySet = new EntrySet();
    }
    return this.mEntrySet;
  }
  
  public Set<K> getKeySet()
  {
    if (this.mKeySet == null) {
      this.mKeySet = new KeySet();
    }
    return this.mKeySet;
  }
  
  public Collection<V> getValues()
  {
    if (this.mValues == null) {
      this.mValues = new ValuesCollection();
    }
    return this.mValues;
  }
  
  public Object[] toArrayHelper(int paramInt)
  {
    int i = colGetSize();
    Object[] arrayOfObject = new Object[i];
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return arrayOfObject;
      }
      arrayOfObject[j] = colGetEntry(j, paramInt);
    }
  }
  
  public <T> T[] toArrayHelper(T[] paramArrayOfT, int paramInt)
  {
    int j = colGetSize();
    if (paramArrayOfT.length < j) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    for (int i = 0;; i++)
    {
      if (i >= j)
      {
        if (paramArrayOfT.length > j) {
          paramArrayOfT[j] = null;
        }
        return paramArrayOfT;
      }
      paramArrayOfT[i] = colGetEntry(i, paramInt);
    }
  }
  
  final class ValuesCollection
    implements Collection<V>
  {
    ValuesCollection() {}
    
    public boolean add(V paramV)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends V> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      MapCollections.this.colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (MapCollections.this.colIndexOfValue(paramObject) < 0) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      Iterator localIterator = paramCollection.iterator();
      do
      {
        if (!localIterator.hasNext())
        {
          bool = true;
          break;
        }
      } while (contains(bool.next()));
      boolean bool = false;
      return bool;
    }
    
    public boolean isEmpty()
    {
      boolean bool;
      if (MapCollections.this.colGetSize() != 0) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public Iterator<V> iterator()
    {
      return new MapCollections.ArrayIterator(MapCollections.this, 1);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = MapCollections.this.colIndexOfValue(paramObject);
      if (i < 0)
      {
        i = 0;
      }
      else
      {
        MapCollections.this.colRemoveAt(i);
        i = 1;
      }
      return i;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      int i = MapCollections.this.colGetSize();
      boolean bool = false;
      for (int j = 0;; j++)
      {
        if (j >= i) {
          return bool;
        }
        if (paramCollection.contains(MapCollections.this.colGetEntry(j, 1)))
        {
          MapCollections.this.colRemoveAt(j);
          j--;
          i--;
          bool = true;
        }
      }
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      int i = MapCollections.this.colGetSize();
      boolean bool = false;
      for (int j = 0;; j++)
      {
        if (j >= i) {
          return bool;
        }
        if (!paramCollection.contains(MapCollections.this.colGetEntry(j, 1)))
        {
          MapCollections.this.colRemoveAt(j);
          j--;
          i--;
          bool = true;
        }
      }
    }
    
    public int size()
    {
      return MapCollections.this.colGetSize();
    }
    
    public Object[] toArray()
    {
      return MapCollections.this.toArrayHelper(1);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return MapCollections.this.toArrayHelper(paramArrayOfT, 1);
    }
  }
  
  final class KeySet
    implements Set<K>
  {
    KeySet() {}
    
    public boolean add(K paramK)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends K> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      MapCollections.this.colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool;
      if (MapCollections.this.colIndexOfKey(paramObject) < 0) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), paramCollection);
    }
    
    public boolean equals(Object paramObject)
    {
      return MapCollections.equalsSetHelper(this, paramObject);
    }
    
    public int hashCode()
    {
      int j = 0;
      for (int i = -1 + MapCollections.this.colGetSize();; i--)
      {
        if (i < 0) {
          return j;
        }
        Object localObject = MapCollections.this.colGetEntry(i, 0);
        int k;
        if (localObject != null) {
          k = localObject.hashCode();
        } else {
          k = 0;
        }
        j += k;
      }
    }
    
    public boolean isEmpty()
    {
      boolean bool;
      if (MapCollections.this.colGetSize() != 0) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public Iterator<K> iterator()
    {
      return new MapCollections.ArrayIterator(MapCollections.this, 0);
    }
    
    public boolean remove(Object paramObject)
    {
      int i = MapCollections.this.colIndexOfKey(paramObject);
      if (i < 0)
      {
        i = 0;
      }
      else
      {
        MapCollections.this.colRemoveAt(i);
        i = 1;
      }
      return i;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), paramCollection);
    }
    
    public int size()
    {
      return MapCollections.this.colGetSize();
    }
    
    public Object[] toArray()
    {
      return MapCollections.this.toArrayHelper(0);
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return MapCollections.this.toArrayHelper(paramArrayOfT, 0);
    }
  }
  
  final class EntrySet
    implements Set<Map.Entry<K, V>>
  {
    EntrySet() {}
    
    public boolean add(Map.Entry<K, V> paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
    {
      int i = MapCollections.this.colGetSize();
      Iterator localIterator = paramCollection.iterator();
      for (;;)
      {
        boolean bool;
        if (!localIterator.hasNext())
        {
          if (i == MapCollections.this.colGetSize()) {
            bool = false;
          } else {
            bool = true;
          }
          return bool;
        }
        Map.Entry localEntry = (Map.Entry)bool.next();
        MapCollections.this.colPut(localEntry.getKey(), localEntry.getValue());
      }
    }
    
    public void clear()
    {
      MapCollections.this.colClear();
    }
    
    public boolean contains(Object paramObject)
    {
      boolean bool = false;
      if ((paramObject instanceof Map.Entry))
      {
        Map.Entry localEntry = (Map.Entry)paramObject;
        int i = MapCollections.this.colIndexOfKey(localEntry.getKey());
        if (i >= 0) {
          bool = ContainerHelpers.equal(MapCollections.this.colGetEntry(i, 1), localEntry.getValue());
        }
      }
      return bool;
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      Iterator localIterator = paramCollection.iterator();
      do
      {
        if (!localIterator.hasNext())
        {
          bool = true;
          break;
        }
      } while (contains(bool.next()));
      boolean bool = false;
      return bool;
    }
    
    public boolean equals(Object paramObject)
    {
      return MapCollections.equalsSetHelper(this, paramObject);
    }
    
    public int hashCode()
    {
      int j = 0;
      for (int i = -1 + MapCollections.this.colGetSize();; i--)
      {
        if (i < 0) {
          return j;
        }
        Object localObject2 = MapCollections.this.colGetEntry(i, 0);
        Object localObject1 = MapCollections.this.colGetEntry(i, 1);
        int m;
        if (localObject2 != null) {
          m = localObject2.hashCode();
        } else {
          m = 0;
        }
        int k;
        if (localObject1 != null) {
          k = localObject1.hashCode();
        } else {
          k = 0;
        }
        j += (k ^ m);
      }
    }
    
    public boolean isEmpty()
    {
      boolean bool;
      if (MapCollections.this.colGetSize() != 0) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new MapCollections.MapIterator(MapCollections.this);
    }
    
    public boolean remove(Object paramObject)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return MapCollections.this.colGetSize();
    }
    
    public Object[] toArray()
    {
      throw new UnsupportedOperationException();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  final class MapIterator
    implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
  {
    int mEnd = -1 + MapCollections.this.colGetSize();
    boolean mEntryValid = false;
    int mIndex = -1;
    
    MapIterator() {}
    
    public final boolean equals(Object paramObject)
    {
      Map.Entry localEntry1 = 1;
      int i = 0;
      if (this.mEntryValid)
      {
        Map.Entry localEntry2;
        if ((paramObject instanceof Map.Entry))
        {
          localEntry2 = (Map.Entry)paramObject;
          if ((!ContainerHelpers.equal(localEntry2.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0))) || (!ContainerHelpers.equal(localEntry2.getValue(), MapCollections.this.colGetEntry(this.mIndex, localEntry1)))) {
            localEntry1 = 0;
          }
          localEntry2 = localEntry1;
        }
        return localEntry2;
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public K getKey()
    {
      if (this.mEntryValid) {
        return MapCollections.this.colGetEntry(this.mIndex, 0);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public V getValue()
    {
      if (this.mEntryValid) {
        return MapCollections.this.colGetEntry(this.mIndex, 1);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.mIndex >= this.mEnd) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public final int hashCode()
    {
      int i = 0;
      if (this.mEntryValid)
      {
        Object localObject2 = MapCollections.this.colGetEntry(this.mIndex, 0);
        Object localObject1 = MapCollections.this.colGetEntry(this.mIndex, 1);
        int j;
        if (localObject2 != null) {
          j = localObject2.hashCode();
        } else {
          j = 0;
        }
        if (localObject1 != null) {
          i = localObject1.hashCode();
        }
        return i ^ j;
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public Map.Entry<K, V> next()
    {
      this.mIndex = (1 + this.mIndex);
      this.mEntryValid = true;
      return this;
    }
    
    public void remove()
    {
      if (this.mEntryValid)
      {
        MapCollections.this.colRemoveAt(this.mIndex);
        this.mIndex = (-1 + this.mIndex);
        this.mEnd = (-1 + this.mEnd);
        this.mEntryValid = false;
        return;
      }
      throw new IllegalStateException();
    }
    
    public V setValue(V paramV)
    {
      if (this.mEntryValid) {
        return MapCollections.this.colSetValue(this.mIndex, paramV);
      }
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    
    public final String toString()
    {
      return getKey() + "=" + getValue();
    }
  }
  
  final class ArrayIterator<T>
    implements Iterator<T>
  {
    boolean mCanRemove = false;
    int mIndex;
    final int mOffset;
    int mSize;
    
    ArrayIterator(int paramInt)
    {
      this.mOffset = paramInt;
      this.mSize = MapCollections.this.colGetSize();
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.mIndex >= this.mSize) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public T next()
    {
      Object localObject = MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
      this.mIndex = (1 + this.mIndex);
      this.mCanRemove = true;
      return localObject;
    }
    
    public void remove()
    {
      if (this.mCanRemove)
      {
        this.mIndex = (-1 + this.mIndex);
        this.mSize = (-1 + this.mSize);
        this.mCanRemove = false;
        MapCollections.this.colRemoveAt(this.mIndex);
        return;
      }
      throw new IllegalStateException();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.MapCollections
 * JD-Core Version:    0.7.0.1
 */