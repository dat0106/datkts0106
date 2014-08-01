package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.af;
import com.google.android.gms.internal.hn;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.mf;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new c();
  final String HK;
  final long HL;
  final long HM;
  private volatile String HN = null;
  final int xJ;
  
  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.xJ = paramInt;
    this.HK = paramString;
    boolean bool2;
    if ("".equals(paramString)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    hn.C(bool2);
    if ((paramString != null) || (paramLong1 != -1L)) {
      bool1 = true;
    }
    hn.C(bool1);
    this.HL = paramLong1;
    this.HM = paramLong2;
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2)
  {
    this(1, paramString, paramLong1, paramLong2);
  }
  
  public static DriveId aL(String paramString)
  {
    hn.f(paramString);
    return new DriveId(paramString, -1L, -1L);
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    hn.b(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
    return f(Base64.decode(paramString.substring("DriveId:".length()), 10));
  }
  
  static DriveId f(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      af localaf;
      try
      {
        localaf = af.g(paramArrayOfByte);
        if ("".equals(localaf.Jq))
        {
          str = null;
          return new DriveId(localaf.versionCode, str, localaf.Jr, localaf.Js);
        }
      }
      catch (me localme)
      {
        throw new IllegalArgumentException();
      }
      String str = localaf.Jq;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.HN == null)
    {
      String str = Base64.encodeToString(gf(), 10);
      this.HN = ("DriveId:" + str);
    }
    return this.HN;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof DriveId))
    {
      DriveId localDriveId = (DriveId)paramObject;
      if (localDriveId.HM == this.HM)
      {
        if ((localDriveId.HL != -1L) || (this.HL != -1L))
        {
          if (localDriveId.HL == this.HL) {
            bool = true;
          }
        }
        else {
          bool = localDriveId.HK.equals(this.HK);
        }
      }
      else {
        Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
      }
    }
    return bool;
  }
  
  public String getResourceId()
  {
    return this.HK;
  }
  
  final byte[] gf()
  {
    af localaf = new af();
    localaf.versionCode = this.xJ;
    String str;
    if (this.HK != null) {
      str = this.HK;
    } else {
      str = "";
    }
    localaf.Jq = str;
    localaf.Jr = this.HL;
    localaf.Js = this.HM;
    return mf.d(localaf);
  }
  
  public int hashCode()
  {
    int i;
    if (this.HL != -1L) {
      i = (String.valueOf(this.HM) + String.valueOf(this.HL)).hashCode();
    } else {
      i = this.HK.hashCode();
    }
    return i;
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveId
 * JD-Core Version:    0.7.0.1
 */