package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.ir;
import com.google.android.gms.internal.it;
import com.google.android.gms.internal.iv;
import java.util.Date;

public abstract class Metadata
  implements Freezable<Metadata>
{
  public static final int CONTENT_AVAILABLE_LOCALLY = 1;
  public static final int CONTENT_NOT_AVAILABLE_LOCALLY;
  
  protected abstract <T> T a(MetadataField<T> paramMetadataField);
  
  public String getAlternateLink()
  {
    return (String)a(ir.JR);
  }
  
  public int getContentAvailability()
  {
    Integer localInteger = (Integer)a(iv.Kz);
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    return i;
  }
  
  public Date getCreatedDate()
  {
    return (Date)a(it.Kt);
  }
  
  public String getDescription()
  {
    return (String)a(ir.JT);
  }
  
  public DriveId getDriveId()
  {
    return (DriveId)a(ir.JQ);
  }
  
  public String getEmbedLink()
  {
    return (String)a(ir.JU);
  }
  
  public String getFileExtension()
  {
    return (String)a(ir.JV);
  }
  
  public long getFileSize()
  {
    return ((Long)a(ir.JW)).longValue();
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)a(it.Ku);
  }
  
  public String getMimeType()
  {
    return (String)a(ir.Kh);
  }
  
  public Date getModifiedByMeDate()
  {
    return (Date)a(it.Kw);
  }
  
  public Date getModifiedDate()
  {
    return (Date)a(it.Kv);
  }
  
  public String getOriginalFilename()
  {
    return (String)a(ir.Ki);
  }
  
  public long getQuotaBytesUsed()
  {
    return ((Long)a(ir.Kl)).longValue();
  }
  
  public Date getSharedWithMeDate()
  {
    return (Date)a(it.Kx);
  }
  
  public String getTitle()
  {
    return (String)a(ir.Ko);
  }
  
  public String getWebContentLink()
  {
    return (String)a(ir.Kq);
  }
  
  public String getWebViewLink()
  {
    return (String)a(ir.Kr);
  }
  
  public boolean isEditable()
  {
    Boolean localBoolean = (Boolean)a(ir.Kb);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isFolder()
  {
    return "application/vnd.google-apps.folder".equals(getMimeType());
  }
  
  public boolean isInAppFolder()
  {
    Boolean localBoolean = (Boolean)a(ir.JZ);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isPinnable()
  {
    Boolean localBoolean = (Boolean)a(iv.KA);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isPinned()
  {
    Boolean localBoolean = (Boolean)a(ir.Kc);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isRestricted()
  {
    Boolean localBoolean = (Boolean)a(ir.Kd);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isShared()
  {
    Boolean localBoolean = (Boolean)a(ir.Ke);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isStarred()
  {
    Boolean localBoolean = (Boolean)a(ir.Km);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isTrashed()
  {
    Boolean localBoolean = (Boolean)a(ir.Kp);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isViewed()
  {
    Boolean localBoolean = (Boolean)a(ir.Kg);
    boolean bool;
    if (localBoolean != null) {
      bool = localBoolean.booleanValue();
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.Metadata
 * JD-Core Version:    0.7.0.1
 */