package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Iterator;
import java.util.Set;

class e
{
  static MetadataField<?> b(MetadataBundle paramMetadataBundle)
  {
    Set localSet = paramMetadataBundle.gB();
    if (localSet.size() == 1) {
      return (MetadataField)localSet.iterator().next();
    }
    throw new IllegalArgumentException("bundle should have exactly 1 populated field");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.e
 * JD-Core Version:    0.7.0.1
 */