package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class l
  extends Metadata
{
  private final MetadataBundle IF;
  
  public l(MetadataBundle paramMetadataBundle)
  {
    this.IF = paramMetadataBundle;
  }
  
  protected <T> T a(MetadataField<T> paramMetadataField)
  {
    return this.IF.a(paramMetadataField);
  }
  
  public Metadata gg()
  {
    return new l(MetadataBundle.a(this.IF));
  }
  
  public boolean isDataValid()
  {
    boolean bool;
    if (this.IF == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return "Metadata [mImpl=" + this.IF + "]";
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.l
 * JD-Core Version:    0.7.0.1
 */