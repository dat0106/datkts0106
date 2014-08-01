package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class EventEntity
  implements SafeParcelable, Event
{
  public static final EventEntityCreator CREATOR = new EventEntityCreator();
  private final String Mm;
  private final Uri Mo;
  private final String Mz;
  private final String Nf;
  private final PlayerEntity Ng;
  private final long Nh;
  private final String Ni;
  private final boolean Nj;
  private final String mName;
  private final int xJ;
  
  EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean)
  {
    this.xJ = paramInt;
    this.Nf = paramString1;
    this.mName = paramString2;
    this.Mm = paramString3;
    this.Mo = paramUri;
    this.Mz = paramString4;
    this.Ng = new PlayerEntity(paramPlayer);
    this.Nh = paramLong;
    this.Ni = paramString5;
    this.Nj = paramBoolean;
  }
  
  public EventEntity(Event paramEvent)
  {
    this.xJ = 1;
    this.Nf = paramEvent.getEventId();
    this.mName = paramEvent.getName();
    this.Mm = paramEvent.getDescription();
    this.Mo = paramEvent.getIconImageUri();
    this.Mz = paramEvent.getIconImageUrl();
    this.Ng = ((PlayerEntity)paramEvent.getPlayer().freeze());
    this.Nh = paramEvent.getValue();
    this.Ni = paramEvent.getFormattedValue();
    this.Nj = paramEvent.isVisible();
  }
  
  static int a(Event paramEvent)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramEvent.getEventId();
    arrayOfObject[1] = paramEvent.getName();
    arrayOfObject[2] = paramEvent.getDescription();
    arrayOfObject[3] = paramEvent.getIconImageUri();
    arrayOfObject[4] = paramEvent.getIconImageUrl();
    arrayOfObject[5] = paramEvent.getPlayer();
    arrayOfObject[6] = Long.valueOf(paramEvent.getValue());
    arrayOfObject[7] = paramEvent.getFormattedValue();
    arrayOfObject[8] = Boolean.valueOf(paramEvent.isVisible());
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(Event paramEvent, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Event))
    {
      if (paramEvent != paramObject)
      {
        Event localEvent = (Event)paramObject;
        if ((!hl.equal(localEvent.getEventId(), paramEvent.getEventId())) || (!hl.equal(localEvent.getName(), paramEvent.getName())) || (!hl.equal(localEvent.getDescription(), paramEvent.getDescription())) || (!hl.equal(localEvent.getIconImageUri(), paramEvent.getIconImageUri())) || (!hl.equal(localEvent.getIconImageUrl(), paramEvent.getIconImageUrl())) || (!hl.equal(localEvent.getPlayer(), paramEvent.getPlayer())) || (!hl.equal(Long.valueOf(localEvent.getValue()), Long.valueOf(paramEvent.getValue()))) || (!hl.equal(localEvent.getFormattedValue(), paramEvent.getFormattedValue())) || (!hl.equal(Boolean.valueOf(localEvent.isVisible()), Boolean.valueOf(paramEvent.isVisible())))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(Event paramEvent)
  {
    return hl.e(paramEvent).a("Id", paramEvent.getEventId()).a("Name", paramEvent.getName()).a("Description", paramEvent.getDescription()).a("IconImageUri", paramEvent.getIconImageUri()).a("IconImageUrl", paramEvent.getIconImageUrl()).a("Player", paramEvent.getPlayer()).a("Value", Long.valueOf(paramEvent.getValue())).a("FormattedValue", paramEvent.getFormattedValue()).a("isVisible", Boolean.valueOf(paramEvent.isVisible())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Event freeze()
  {
    return this;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public String getEventId()
  {
    return this.Nf;
  }
  
  public String getFormattedValue()
  {
    return this.Ni;
  }
  
  public void getFormattedValue(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Ni, paramCharArrayBuffer);
  }
  
  public Uri getIconImageUri()
  {
    return this.Mo;
  }
  
  public String getIconImageUrl()
  {
    return this.Mz;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.Ng;
  }
  
  public long getValue()
  {
    return this.Nh;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isVisible()
  {
    return this.Nj;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    EventEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.event.EventEntity
 * JD-Core Version:    0.7.0.1
 */