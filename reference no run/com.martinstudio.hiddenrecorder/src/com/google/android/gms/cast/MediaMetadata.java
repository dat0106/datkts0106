package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.gt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata
{
  private static final a AA = new a().a("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).a("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).a("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).a("com.google.android.gms.cast.metadata.TITLE", "title", 1).a("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).a("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).a("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).a("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).a("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).a("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).a("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).a("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).a("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).a("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).a("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).a("com.google.android.gms.cast.metadata.WIDTH", "width", 2).a("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).a("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).a("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).a("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
  private static final String[] Az;
  public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
  public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
  public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
  public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
  public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
  public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
  public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
  public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
  public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
  public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
  public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
  public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
  public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
  public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
  public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
  public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
  public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
  public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
  public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
  public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
  public static final int MEDIA_TYPE_GENERIC = 0;
  public static final int MEDIA_TYPE_MOVIE = 1;
  public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
  public static final int MEDIA_TYPE_PHOTO = 4;
  public static final int MEDIA_TYPE_TV_SHOW = 2;
  public static final int MEDIA_TYPE_USER = 100;
  private final Bundle AB = new Bundle();
  private int AC;
  private final List<WebImage> zN = new ArrayList();
  
  static
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = null;
    arrayOfString[1] = "String";
    arrayOfString[2] = "int";
    arrayOfString[3] = "double";
    arrayOfString[4] = "ISO-8601 date String";
    Az = arrayOfString;
  }
  
  public MediaMetadata()
  {
    this(0);
  }
  
  public MediaMetadata(int paramInt)
  {
    this.AC = paramInt;
  }
  
  private void a(JSONObject paramJSONObject, String... paramVarArgs)
  {
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      Object localObject;
      String str;
      if (i < j)
      {
        localObject = paramVarArgs[i];
        if (!this.AB.containsKey((String)localObject)) {}
      }
      else
      {
        switch (AA.ag((String)localObject))
        {
        case 1: 
        case 4: 
          paramJSONObject.put(AA.ae((String)localObject), this.AB.getString((String)localObject));
          break;
        case 2: 
          paramJSONObject.put(AA.ae((String)localObject), this.AB.getInt((String)localObject));
          break;
        case 3: 
          paramJSONObject.put(AA.ae((String)localObject), this.AB.getDouble((String)localObject));
          break;
          Iterator localIterator = this.AB.keySet().iterator();
          while (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            if (!str.startsWith("com.google."))
            {
              localObject = this.AB.get(str);
              if ((localObject instanceof String)) {
                paramJSONObject.put(str, localObject);
              } else if ((localObject instanceof Integer)) {
                paramJSONObject.put(str, localObject);
              } else if ((localObject instanceof Double)) {
                paramJSONObject.put(str, localObject);
              }
            }
          }
        }
      }
      for (;;)
      {
        str++;
        break;
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private boolean a(Bundle paramBundle1, Bundle paramBundle2)
  {
    boolean bool;
    if (paramBundle1.size() == paramBundle2.size())
    {
      Iterator localIterator = paramBundle1.keySet().iterator();
      Object localObject1;
      do
      {
        Object localObject2;
        do
        {
          if (!localIterator.hasNext())
          {
            int i = 1;
            return ???;
          }
          String str = (String)localIterator.next();
          localObject2 = paramBundle1.get(str);
          localObject1 = paramBundle2.get(str);
          if (((localObject2 instanceof Bundle)) && ((localObject1 instanceof Bundle)) && (!a((Bundle)localObject2, (Bundle)localObject1))) {
            break label133;
          }
          if (localObject2 == null) {
            break;
          }
        } while (localObject2.equals(localObject1));
        return false;
      } while ((localObject1 == null) && (paramBundle2.containsKey(bool)));
      return false;
      label133:
      bool = false;
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  private void b(JSONObject paramJSONObject, String... paramVarArgs)
  {
    HashSet localHashSet = new HashSet(Arrays.asList(paramVarArgs));
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        if (!"metadataType".equals(localObject1))
        {
          Object localObject2 = AA.af((String)localObject1);
          if (localObject2 != null)
          {
            boolean bool = localHashSet.contains(localObject2);
            if (!bool) {}
          }
          else
          {
            try
            {
              localObject1 = paramJSONObject.get((String)localObject1);
              if (localObject1 != null) {
                switch (AA.ag((String)localObject2))
                {
                case 1: 
                  if ((localObject1 instanceof String)) {
                    this.AB.putString((String)localObject2, (String)localObject1);
                  }
                  break;
                case 4: 
                  if (((localObject1 instanceof String)) && (gt.aq((String)localObject1) != null)) {
                    this.AB.putString((String)localObject2, (String)localObject1);
                  }
                  break;
                case 2: 
                  if ((localObject1 instanceof Integer)) {
                    this.AB.putInt((String)localObject2, ((Integer)localObject1).intValue());
                  }
                  break;
                case 3: 
                  if ((localObject1 instanceof Double))
                  {
                    this.AB.putDouble((String)localObject2, ((Double)localObject1).doubleValue());
                    continue;
                    localObject2 = paramJSONObject.get((String)localObject1);
                    if ((localObject2 instanceof String)) {
                      this.AB.putString((String)localObject1, (String)localObject2);
                    } else if ((localObject2 instanceof Integer)) {
                      this.AB.putInt((String)localObject1, ((Integer)localObject2).intValue());
                    } else if ((localObject2 instanceof Double)) {
                      this.AB.putDouble((String)localObject1, ((Double)localObject2).doubleValue());
                    }
                  }
                  break;
                }
              }
            }
            catch (JSONException localJSONException1) {}
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException2) {}
  }
  
  private void d(String paramString, int paramInt)
    throws IllegalArgumentException
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = AA.ag(paramString);
      if ((i == paramInt) || (i == 0)) {
        return;
      }
      throw new IllegalArgumentException("Value for " + paramString + " must be a " + Az[paramInt]);
    }
    throw new IllegalArgumentException("null and empty keys are not allowed");
  }
  
  public void addImage(WebImage paramWebImage)
  {
    this.zN.add(paramWebImage);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    clear();
    this.AC = 0;
    try
    {
      this.AC = paramJSONObject.getInt("metadataType");
      label20:
      gt.a(this.zN, paramJSONObject);
      switch (this.AC)
      {
      default: 
        b(paramJSONObject, new String[0]);
      }
      for (;;)
      {
        return;
        String[] arrayOfString = new String[4];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.ARTIST";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.SUBTITLE";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.RELEASE_DATE";
        b(paramJSONObject, arrayOfString);
        continue;
        arrayOfString = new String[4];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.STUDIO";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.SUBTITLE";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.RELEASE_DATE";
        b(paramJSONObject, arrayOfString);
        continue;
        arrayOfString = new String[5];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.SERIES_TITLE";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
        arrayOfString[4] = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
        b(paramJSONObject, arrayOfString);
        continue;
        arrayOfString = new String[8];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.ARTIST";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
        arrayOfString[4] = "com.google.android.gms.cast.metadata.COMPOSER";
        arrayOfString[5] = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
        arrayOfString[6] = "com.google.android.gms.cast.metadata.DISC_NUMBER";
        arrayOfString[7] = "com.google.android.gms.cast.metadata.RELEASE_DATE";
        b(paramJSONObject, arrayOfString);
        continue;
        arrayOfString = new String[8];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.ARTIST";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.LOCATION_NAME";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
        arrayOfString[4] = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
        arrayOfString[5] = "com.google.android.gms.cast.metadata.WIDTH";
        arrayOfString[6] = "com.google.android.gms.cast.metadata.HEIGHT";
        arrayOfString[7] = "com.google.android.gms.cast.metadata.CREATION_DATE";
        b(paramJSONObject, arrayOfString);
      }
    }
    catch (JSONException localJSONException)
    {
      break label20;
    }
  }
  
  public void clear()
  {
    this.AB.clear();
    this.zN.clear();
  }
  
  public void clearImages()
  {
    this.zN.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this.AB.containsKey(paramString);
  }
  
  public JSONObject dU()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("metadataType", this.AC);
      label20:
      gt.a(localJSONObject, this.zN);
      switch (this.AC)
      {
      default: 
        a(localJSONObject, new String[0]);
      }
      for (;;)
      {
        return localJSONObject;
        String[] arrayOfString = new String[4];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.ARTIST";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.SUBTITLE";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.RELEASE_DATE";
        a(localJSONObject, arrayOfString);
        continue;
        arrayOfString = new String[4];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.STUDIO";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.SUBTITLE";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.RELEASE_DATE";
        a(localJSONObject, arrayOfString);
        continue;
        arrayOfString = new String[5];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.SERIES_TITLE";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
        arrayOfString[4] = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
        a(localJSONObject, arrayOfString);
        continue;
        arrayOfString = new String[8];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.ARTIST";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
        arrayOfString[4] = "com.google.android.gms.cast.metadata.COMPOSER";
        arrayOfString[5] = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
        arrayOfString[6] = "com.google.android.gms.cast.metadata.DISC_NUMBER";
        arrayOfString[7] = "com.google.android.gms.cast.metadata.RELEASE_DATE";
        a(localJSONObject, arrayOfString);
        continue;
        arrayOfString = new String[8];
        arrayOfString[0] = "com.google.android.gms.cast.metadata.TITLE";
        arrayOfString[1] = "com.google.android.gms.cast.metadata.ARTIST";
        arrayOfString[2] = "com.google.android.gms.cast.metadata.LOCATION_NAME";
        arrayOfString[3] = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
        arrayOfString[4] = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
        arrayOfString[5] = "com.google.android.gms.cast.metadata.WIDTH";
        arrayOfString[6] = "com.google.android.gms.cast.metadata.HEIGHT";
        arrayOfString[7] = "com.google.android.gms.cast.metadata.CREATION_DATE";
        a(localJSONObject, arrayOfString);
      }
    }
    catch (JSONException localJSONException)
    {
      break label20;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof MediaMetadata))
      {
        MediaMetadata localMediaMetadata = (MediaMetadata)paramObject;
        if ((!a(this.AB, localMediaMetadata.AB)) || (!this.zN.equals(localMediaMetadata.zN))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  public Calendar getDate(String paramString)
  {
    d(paramString, 4);
    Object localObject = this.AB.getString(paramString);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = gt.aq((String)localObject);
    }
    return localObject;
  }
  
  public String getDateAsString(String paramString)
  {
    d(paramString, 4);
    return this.AB.getString(paramString);
  }
  
  public double getDouble(String paramString)
  {
    d(paramString, 3);
    return this.AB.getDouble(paramString);
  }
  
  public List<WebImage> getImages()
  {
    return this.zN;
  }
  
  public int getInt(String paramString)
  {
    d(paramString, 2);
    return this.AB.getInt(paramString);
  }
  
  public int getMediaType()
  {
    return this.AC;
  }
  
  public String getString(String paramString)
  {
    d(paramString, 1);
    return this.AB.getString(paramString);
  }
  
  public boolean hasImages()
  {
    boolean bool;
    if ((this.zN == null) || (this.zN.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.AB.keySet().iterator();
    String str;
    for (int i = 17;; i = i * 31 + this.AB.get(str).hashCode())
    {
      if (!localIterator.hasNext()) {
        return i * 31 + this.zN.hashCode();
      }
      str = (String)localIterator.next();
    }
  }
  
  public Set<String> keySet()
  {
    return this.AB.keySet();
  }
  
  public void putDate(String paramString, Calendar paramCalendar)
  {
    d(paramString, 4);
    this.AB.putString(paramString, gt.a(paramCalendar));
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    d(paramString, 3);
    this.AB.putDouble(paramString, paramDouble);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    d(paramString, 2);
    this.AB.putInt(paramString, paramInt);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    d(paramString1, 1);
    this.AB.putString(paramString1, paramString2);
  }
  
  private static class a
  {
    private final Map<String, String> AD = new HashMap();
    private final Map<String, String> AE = new HashMap();
    private final Map<String, Integer> AF = new HashMap();
    
    public a a(String paramString1, String paramString2, int paramInt)
    {
      this.AD.put(paramString1, paramString2);
      this.AE.put(paramString2, paramString1);
      this.AF.put(paramString1, Integer.valueOf(paramInt));
      return this;
    }
    
    public String ae(String paramString)
    {
      return (String)this.AD.get(paramString);
    }
    
    public String af(String paramString)
    {
      return (String)this.AE.get(paramString);
    }
    
    public int ag(String paramString)
    {
      Integer localInteger = (Integer)this.AF.get(paramString);
      int i;
      if (localInteger == null) {
        i = 0;
      } else {
        i = i.intValue();
      }
      return i;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.MediaMetadata
 * JD-Core Version:    0.7.0.1
 */