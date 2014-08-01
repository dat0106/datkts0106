package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.l;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.internal.ir;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class MetadataBuffer
  extends DataBuffer<Metadata>
{
  private static final String[] HO;
  private final String HP;
  private a HQ;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = e.gz().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        HO = (String[])localArrayList.toArray(new String[0]);
        return;
      }
      localArrayList.addAll(((MetadataField)localIterator.next()).gx());
    }
  }
  
  public MetadataBuffer(DataHolder paramDataHolder, String paramString)
  {
    super(paramDataHolder);
    this.HP = paramString;
    paramDataHolder.eP().setClassLoader(MetadataBuffer.class.getClassLoader());
  }
  
  public Metadata get(int paramInt)
  {
    a locala = this.HQ;
    if ((locala == null) || (a.a(locala) != paramInt))
    {
      locala = new a(this.DD, paramInt);
      this.HQ = locala;
    }
    return locala;
  }
  
  public String getNextPageToken()
  {
    return this.HP;
  }
  
  private static class a
    extends Metadata
  {
    private final DataHolder DD;
    private final int EA;
    private final int HR;
    
    public a(DataHolder paramDataHolder, int paramInt)
    {
      this.DD = paramDataHolder;
      this.HR = paramInt;
      this.EA = paramDataHolder.ae(paramInt);
    }
    
    protected <T> T a(MetadataField<T> paramMetadataField)
    {
      return paramMetadataField.a(this.DD, this.HR, this.EA);
    }
    
    public Metadata gg()
    {
      MetadataBundle localMetadataBundle = MetadataBundle.gA();
      Iterator localIterator = e.gz().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return new l(localMetadataBundle);
        }
        MetadataField localMetadataField = (MetadataField)localIterator.next();
        if ((!(localMetadataField instanceof b)) && (localMetadataField != ir.Kn)) {
          localMetadataField.a(this.DD, localMetadataBundle, this.HR, this.EA);
        }
      }
    }
    
    public boolean isDataValid()
    {
      boolean bool;
      if (this.DD.isClosed()) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.MetadataBuffer
 * JD-Core Version:    0.7.0.1
 */