package com.sonyericsson.extras.liveware.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.List;

public class PhoneUtils
{
  public static String getContactName(Context paramContext, Uri paramUri)
  {
    String str = "";
    ContentResolver localContentResolver = paramContext.getContentResolver();
    localObject1 = new String[1];
    localObject1[0] = "display_name";
    localObject1 = localContentResolver.query(paramUri, (String[])localObject1, null, null, null);
    if (localObject1 != null) {}
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        str = ((Cursor)localObject1).getString(0);
        str = str;
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("query failed in getContactName", localSQLException);
        ((Cursor)localObject1).close();
      }
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
    return str;
  }
  
  public static List<PhoneNumber> getContactPhoneNumbers(Context paramContext, Uri paramUri)
  {
    String str1 = paramUri.getLastPathSegment();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramContext.getContentResolver();
    localCursor = null;
    for (;;)
    {
      try
      {
        localCursor = ((ContentResolver)localObject2).query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + str1, null, null);
        if (localCursor != null)
        {
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (SQLException localSQLException)
      {
        int i;
        String str2;
        Dbg.e("query failed in getContactPhoneNumbers", localSQLException);
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        continue;
      }
      finally
      {
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      return localArrayList;
      localObject2 = new PhoneNumber();
      ((PhoneNumber)localObject2).number = localCursor.getString(localCursor.getColumnIndex("data1"));
      i = localCursor.getInt(localCursor.getColumnIndex("data2"));
      str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("data3"));
      ((PhoneNumber)localObject2).label = ContactsContract.CommonDataKinds.Phone.getTypeLabel(paramContext.getResources(), i, str2).toString();
      localArrayList.add(localObject2);
    }
  }
  
  public static boolean hasOngoingCall(Context paramContext)
  {
    boolean bool = false;
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if ((localTelephonyManager != null) && (localTelephonyManager.getCallState() != 0)) {
      bool = true;
    }
    return bool;
  }
  
  public static class PhoneContactInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<PhoneContactInfo> CREATOR = new Parcelable.Creator()
    {
      public PhoneUtils.PhoneContactInfo createFromParcel(Parcel paramAnonymousParcel)
      {
        return new PhoneUtils.PhoneContactInfo(paramAnonymousParcel, null);
      }
      
      public PhoneUtils.PhoneContactInfo[] newArray(int paramAnonymousInt)
      {
        return new PhoneUtils.PhoneContactInfo[paramAnonymousInt];
      }
    };
    public String name;
    public PhoneUtils.PhoneNumber phoneNumber;
    
    public PhoneContactInfo() {}
    
    private PhoneContactInfo(Parcel paramParcel)
    {
      this.name = paramParcel.readString();
      this.phoneNumber = ((PhoneUtils.PhoneNumber)paramParcel.readParcelable(PhoneContactInfo.class.getClassLoader()));
    }
    
    public PhoneContactInfo(String paramString, PhoneUtils.PhoneNumber paramPhoneNumber)
    {
      this.name = paramString;
      this.phoneNumber = paramPhoneNumber;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.name);
      paramParcel.writeParcelable(this.phoneNumber, 0);
    }
  }
  
  public static class PhoneNumber
    implements Parcelable
  {
    public static final Parcelable.Creator<PhoneNumber> CREATOR = new Parcelable.Creator()
    {
      public PhoneUtils.PhoneNumber createFromParcel(Parcel paramAnonymousParcel)
      {
        return new PhoneUtils.PhoneNumber(paramAnonymousParcel, null);
      }
      
      public PhoneUtils.PhoneNumber[] newArray(int paramAnonymousInt)
      {
        return new PhoneUtils.PhoneNumber[paramAnonymousInt];
      }
    };
    public String label;
    public String number;
    
    public PhoneNumber() {}
    
    private PhoneNumber(Parcel paramParcel)
    {
      this.number = paramParcel.readString();
      this.label = paramParcel.readString();
    }
    
    public PhoneNumber(String paramString1, String paramString2)
    {
      this.number = paramString1;
      this.label = paramString2;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.number);
      paramParcel.writeString(this.label);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.PhoneUtils
 * JD-Core Version:    0.7.0.1
 */