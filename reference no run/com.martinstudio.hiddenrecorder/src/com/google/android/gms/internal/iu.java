package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;
import java.util.Collection;

public class iu
  extends j<DriveId>
{
  public static final iu Ky = new iu();
  
  private iu()
  {
    super("driveId", (Collection)localObject, Arrays.asList(arrayOfString), 4100000);
  }
  
  protected DriveId k(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    long l = paramDataHolder.eP().getLong("dbInstanceId");
    String str = paramDataHolder.c("resourceId", paramInt1, paramInt2);
    if ((str != null) && (str.startsWith("generated-android-"))) {
      str = null;
    }
    return new DriveId(str, Long.valueOf(paramDataHolder.a("sqlId", paramInt1, paramInt2)).longValue(), l);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iu
 * JD-Core Version:    0.7.0.1
 */