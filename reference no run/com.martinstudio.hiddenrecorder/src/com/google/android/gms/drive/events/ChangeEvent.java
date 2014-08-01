package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<ChangeEvent> CREATOR = new a();
  final DriveId Hw;
  final int Id;
  final int xJ;
  
  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.xJ = paramInt1;
    this.Hw = paramDriveId;
    this.Id = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Hw;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public boolean hasContentChanged()
  {
    boolean bool;
    if ((0x2 & this.Id) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean hasMetadataChanged()
  {
    boolean bool;
    if ((0x1 & this.Id) == 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Hw;
    arrayOfObject[1] = Integer.valueOf(this.Id);
    return String.format("ChangeEvent [id=%s,changeFlags=%x]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.ChangeEvent
 * JD-Core Version:    0.7.0.1
 */