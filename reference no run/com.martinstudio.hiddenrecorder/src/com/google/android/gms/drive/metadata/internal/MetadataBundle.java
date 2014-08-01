package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new h();
  final Bundle JP;
  final int xJ;
  
  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.xJ = paramInt;
    this.JP = ((Bundle)hn.f(paramBundle));
    this.JP.setClassLoader(getClass().getClassLoader());
    Object localObject1 = new ArrayList();
    Object localObject2 = this.JP.keySet().iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            return;
          }
          localObject2 = (String)((Iterator)localObject1).next();
          this.JP.remove((String)localObject2);
        }
      }
      String str = (String)((Iterator)localObject2).next();
      if (e.aN(str) == null)
      {
        ((List)localObject1).add(str);
        Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
      }
    }
  }
  
  private MetadataBundle(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public static <T> MetadataBundle a(MetadataField<T> paramMetadataField, T paramT)
  {
    MetadataBundle localMetadataBundle = gA();
    localMetadataBundle.b(paramMetadataField, paramT);
    return localMetadataBundle;
  }
  
  public static MetadataBundle a(MetadataBundle paramMetadataBundle)
  {
    return new MetadataBundle(new Bundle(paramMetadataBundle.JP));
  }
  
  public static MetadataBundle gA()
  {
    return new MetadataBundle(new Bundle());
  }
  
  public <T> T a(MetadataField<T> paramMetadataField)
  {
    return paramMetadataField.e(this.JP);
  }
  
  public <T> void b(MetadataField<T> paramMetadataField, T paramT)
  {
    if (e.aN(paramMetadataField.getName()) != null)
    {
      paramMetadataField.a(paramT, this.JP);
      return;
    }
    throw new IllegalArgumentException("Unregistered field: " + paramMetadataField.getName());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this != paramObject)
    {
      if ((paramObject instanceof MetadataBundle))
      {
        MetadataBundle localMetadataBundle = (MetadataBundle)paramObject;
        Object localObject = this.JP.keySet();
        if (((Set)localObject).equals(localMetadataBundle.JP.keySet()))
        {
          localObject = ((Set)localObject).iterator();
          String str;
          do
          {
            if (!((Iterator)localObject).hasNext())
            {
              bool = true;
              break;
            }
            str = (String)((Iterator)localObject).next();
          } while (hl.equal(this.JP.get(str), bool.JP.get(str)));
          bool = false;
        }
        else
        {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
    else {
      bool = true;
    }
    return bool;
  }
  
  public Set<MetadataField<?>> gB()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.JP.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashSet;
      }
      localHashSet.add(e.aN((String)localIterator.next()));
    }
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.JP.keySet().iterator();
    String str;
    for (int i = 1;; i = i * 31 + this.JP.get(str).hashCode())
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      str = (String)localIterator.next();
    }
  }
  
  public String toString()
  {
    return "MetadataBundle [values=" + this.JP + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.MetadataBundle
 * JD-Core Version:    0.7.0.1
 */