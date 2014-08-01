package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class kt
  extends hz
  implements SafeParcelable, Person
{
  public static final ku CREATOR = new ku();
  private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
  private String Ao;
  private String Lk;
  private final Set<Integer> acp;
  private List<g> adA;
  private int adB;
  private int adC;
  private String adD;
  private List<h> adE;
  private boolean adF;
  private String adn;
  private a ado;
  private String adp;
  private String adq;
  private int adr;
  private b ads;
  private String adt;
  private c adu;
  private boolean adv;
  private d adw;
  private String adx;
  private int ady;
  private List<f> adz;
  private int mj;
  private String qV;
  private String xD;
  private final int xJ;
  
  static
  {
    aco.put("aboutMe", hz.a.j("aboutMe", 2));
    aco.put("ageRange", hz.a.a("ageRange", 3, a.class));
    aco.put("birthday", hz.a.j("birthday", 4));
    aco.put("braggingRights", hz.a.j("braggingRights", 5));
    aco.put("circledByCount", hz.a.g("circledByCount", 6));
    aco.put("cover", hz.a.a("cover", 7, b.class));
    aco.put("currentLocation", hz.a.j("currentLocation", 8));
    aco.put("displayName", hz.a.j("displayName", 9));
    aco.put("gender", hz.a.a("gender", 12, new hw().f("male", 0).f("female", 1).f("other", 2), false));
    aco.put("id", hz.a.j("id", 14));
    aco.put("image", hz.a.a("image", 15, c.class));
    aco.put("isPlusUser", hz.a.i("isPlusUser", 16));
    aco.put("language", hz.a.j("language", 18));
    aco.put("name", hz.a.a("name", 19, d.class));
    aco.put("nickname", hz.a.j("nickname", 20));
    aco.put("objectType", hz.a.a("objectType", 21, new hw().f("person", 0).f("page", 1), false));
    aco.put("organizations", hz.a.b("organizations", 22, f.class));
    aco.put("placesLived", hz.a.b("placesLived", 23, g.class));
    aco.put("plusOneCount", hz.a.g("plusOneCount", 24));
    aco.put("relationshipStatus", hz.a.a("relationshipStatus", 25, new hw().f("single", 0).f("in_a_relationship", 1).f("engaged", 2).f("married", 3).f("its_complicated", 4).f("open_relationship", 5).f("widowed", 6).f("in_domestic_partnership", 7).f("in_civil_union", 8), false));
    aco.put("tagline", hz.a.j("tagline", 26));
    aco.put("url", hz.a.j("url", 27));
    aco.put("urls", hz.a.b("urls", 28, h.class));
    aco.put("verified", hz.a.i("verified", 29));
  }
  
  public kt()
  {
    this.xJ = 2;
    this.acp = new HashSet();
  }
  
  public kt(String paramString1, String paramString2, c paramc, int paramInt, String paramString3)
  {
    this.xJ = 2;
    this.acp = new HashSet();
    this.Lk = paramString1;
    this.acp.add(Integer.valueOf(9));
    this.xD = paramString2;
    this.acp.add(Integer.valueOf(14));
    this.adu = paramc;
    this.acp.add(Integer.valueOf(15));
    this.ady = paramInt;
    this.acp.add(Integer.valueOf(21));
    this.qV = paramString3;
    this.acp.add(Integer.valueOf(27));
  }
  
  kt(Set<Integer> paramSet, int paramInt1, String paramString1, a parama, String paramString2, String paramString3, int paramInt2, b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, c paramc, boolean paramBoolean1, String paramString7, d paramd, String paramString8, int paramInt4, List<f> paramList, List<g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<h> paramList2, boolean paramBoolean2)
  {
    this.acp = paramSet;
    this.xJ = paramInt1;
    this.adn = paramString1;
    this.ado = parama;
    this.adp = paramString2;
    this.adq = paramString3;
    this.adr = paramInt2;
    this.ads = paramb;
    this.adt = paramString4;
    this.Lk = paramString5;
    this.mj = paramInt3;
    this.xD = paramString6;
    this.adu = paramc;
    this.adv = paramBoolean1;
    this.Ao = paramString7;
    this.adw = paramd;
    this.adx = paramString8;
    this.ady = paramInt4;
    this.adz = paramList;
    this.adA = paramList1;
    this.adB = paramInt5;
    this.adC = paramInt6;
    this.adD = paramString9;
    this.qV = paramString10;
    this.adE = paramList2;
    this.adF = paramBoolean2;
  }
  
  public static kt i(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    kt localkt = CREATOR.bG(localParcel);
    localParcel.recycle();
    return localkt;
  }
  
  protected boolean a(hz.a parama)
  {
    return this.acp.contains(Integer.valueOf(parama.fI()));
  }
  
  protected Object aF(String paramString)
  {
    return null;
  }
  
  protected boolean aG(String paramString)
  {
    return false;
  }
  
  protected Object b(hz.a parama)
  {
    Object localObject;
    switch (parama.fI())
    {
    case 10: 
    case 11: 
    case 13: 
    case 17: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
    case 2: 
      localObject = this.adn;
      break;
    case 3: 
      localObject = this.ado;
      break;
    case 4: 
      localObject = this.adp;
      break;
    case 5: 
      localObject = this.adq;
      break;
    case 6: 
      localObject = Integer.valueOf(this.adr);
      break;
    case 7: 
      localObject = this.ads;
      break;
    case 8: 
      localObject = this.adt;
      break;
    case 9: 
      localObject = this.Lk;
      break;
    case 12: 
      localObject = Integer.valueOf(this.mj);
      break;
    case 14: 
      localObject = this.xD;
      break;
    case 15: 
      localObject = this.adu;
      break;
    case 16: 
      localObject = Boolean.valueOf(this.adv);
      break;
    case 18: 
      localObject = this.Ao;
      break;
    case 19: 
      localObject = this.adw;
      break;
    case 20: 
      localObject = this.adx;
      break;
    case 21: 
      localObject = Integer.valueOf(this.ady);
      break;
    case 22: 
      localObject = this.adz;
      break;
    case 23: 
      localObject = this.adA;
      break;
    case 24: 
      localObject = Integer.valueOf(this.adB);
      break;
    case 25: 
      localObject = Integer.valueOf(this.adC);
      break;
    case 26: 
      localObject = this.adD;
      break;
    case 27: 
      localObject = this.qV;
      break;
    case 28: 
      localObject = this.adE;
      break;
    case 29: 
      localObject = Boolean.valueOf(this.adF);
    }
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof kt))
    {
      if (this != paramObject)
      {
        kt localkt = (kt)paramObject;
        Iterator localIterator = aco.values().iterator();
        do
        {
          hz.a locala;
          do
          {
            if (!localIterator.hasNext())
            {
              int i = 1;
              return ???;
            }
            locala = (hz.a)localIterator.next();
            if (a(locala)) {
              break;
            }
          } while (!localkt.a(locala));
          bool = false;
          break;
          if (!localkt.a(bool))
          {
            bool = false;
            break;
          }
        } while (b(bool).equals(localkt.b(bool)));
        bool = false;
      }
      else
      {
        bool = true;
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  public HashMap<String, hz.a<?, ?>> fB()
  {
    return aco;
  }
  
  public String getAboutMe()
  {
    return this.adn;
  }
  
  public Person.AgeRange getAgeRange()
  {
    return this.ado;
  }
  
  public String getBirthday()
  {
    return this.adp;
  }
  
  public String getBraggingRights()
  {
    return this.adq;
  }
  
  public int getCircledByCount()
  {
    return this.adr;
  }
  
  public Person.Cover getCover()
  {
    return this.ads;
  }
  
  public String getCurrentLocation()
  {
    return this.adt;
  }
  
  public String getDisplayName()
  {
    return this.Lk;
  }
  
  public int getGender()
  {
    return this.mj;
  }
  
  public String getId()
  {
    return this.xD;
  }
  
  public Person.Image getImage()
  {
    return this.adu;
  }
  
  public String getLanguage()
  {
    return this.Ao;
  }
  
  public Person.Name getName()
  {
    return this.adw;
  }
  
  public String getNickname()
  {
    return this.adx;
  }
  
  public int getObjectType()
  {
    return this.ady;
  }
  
  public List<Person.Organizations> getOrganizations()
  {
    return (ArrayList)this.adz;
  }
  
  public List<Person.PlacesLived> getPlacesLived()
  {
    return (ArrayList)this.adA;
  }
  
  public int getPlusOneCount()
  {
    return this.adB;
  }
  
  public int getRelationshipStatus()
  {
    return this.adC;
  }
  
  public String getTagline()
  {
    return this.adD;
  }
  
  public String getUrl()
  {
    return this.qV;
  }
  
  public List<Person.Urls> getUrls()
  {
    return (ArrayList)this.adE;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public boolean hasAboutMe()
  {
    return this.acp.contains(Integer.valueOf(2));
  }
  
  public boolean hasAgeRange()
  {
    return this.acp.contains(Integer.valueOf(3));
  }
  
  public boolean hasBirthday()
  {
    return this.acp.contains(Integer.valueOf(4));
  }
  
  public boolean hasBraggingRights()
  {
    return this.acp.contains(Integer.valueOf(5));
  }
  
  public boolean hasCircledByCount()
  {
    return this.acp.contains(Integer.valueOf(6));
  }
  
  public boolean hasCover()
  {
    return this.acp.contains(Integer.valueOf(7));
  }
  
  public boolean hasCurrentLocation()
  {
    return this.acp.contains(Integer.valueOf(8));
  }
  
  public boolean hasDisplayName()
  {
    return this.acp.contains(Integer.valueOf(9));
  }
  
  public boolean hasGender()
  {
    return this.acp.contains(Integer.valueOf(12));
  }
  
  public boolean hasId()
  {
    return this.acp.contains(Integer.valueOf(14));
  }
  
  public boolean hasImage()
  {
    return this.acp.contains(Integer.valueOf(15));
  }
  
  public boolean hasIsPlusUser()
  {
    return this.acp.contains(Integer.valueOf(16));
  }
  
  public boolean hasLanguage()
  {
    return this.acp.contains(Integer.valueOf(18));
  }
  
  public boolean hasName()
  {
    return this.acp.contains(Integer.valueOf(19));
  }
  
  public boolean hasNickname()
  {
    return this.acp.contains(Integer.valueOf(20));
  }
  
  public boolean hasObjectType()
  {
    return this.acp.contains(Integer.valueOf(21));
  }
  
  public boolean hasOrganizations()
  {
    return this.acp.contains(Integer.valueOf(22));
  }
  
  public boolean hasPlacesLived()
  {
    return this.acp.contains(Integer.valueOf(23));
  }
  
  public boolean hasPlusOneCount()
  {
    return this.acp.contains(Integer.valueOf(24));
  }
  
  public boolean hasRelationshipStatus()
  {
    return this.acp.contains(Integer.valueOf(25));
  }
  
  public boolean hasTagline()
  {
    return this.acp.contains(Integer.valueOf(26));
  }
  
  public boolean hasUrl()
  {
    return this.acp.contains(Integer.valueOf(27));
  }
  
  public boolean hasUrls()
  {
    return this.acp.contains(Integer.valueOf(28));
  }
  
  public boolean hasVerified()
  {
    return this.acp.contains(Integer.valueOf(29));
  }
  
  public int hashCode()
  {
    Iterator localIterator = aco.values().iterator();
    hz.a locala2;
    for (hz.a locala3 = 0;; locala3 = locala2)
    {
      if (!localIterator.hasNext()) {
        return locala3;
      }
      hz.a locala1 = (hz.a)localIterator.next();
      if (!a(locala1)) {
        locala1 = locala3;
      } else {
        locala2 = locala3 + locala1.fI() + b(locala1).hashCode();
      }
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isPlusUser()
  {
    return this.adv;
  }
  
  public boolean isVerified()
  {
    return this.adF;
  }
  
  a kA()
  {
    return this.ado;
  }
  
  b kB()
  {
    return this.ads;
  }
  
  c kC()
  {
    return this.adu;
  }
  
  d kD()
  {
    return this.adw;
  }
  
  List<f> kE()
  {
    return this.adz;
  }
  
  List<g> kF()
  {
    return this.adA;
  }
  
  List<h> kG()
  {
    return this.adE;
  }
  
  public kt kH()
  {
    return this;
  }
  
  Set<Integer> kf()
  {
    return this.acp;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ku.a(this, paramParcel, paramInt);
  }
  
  public static final class h
    extends hz
    implements SafeParcelable, Person.Urls
  {
    public static final ld CREATOR = new ld();
    private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
    private int AQ;
    private final Set<Integer> acp;
    private String adU;
    private final int adV = 4;
    private String mValue;
    private final int xJ;
    
    static
    {
      aco.put("label", hz.a.j("label", 5));
      aco.put("type", hz.a.a("type", 6, new hw().f("home", 0).f("work", 1).f("blog", 2).f("profile", 3).f("other", 4).f("otherProfile", 5).f("contributor", 6).f("website", 7), false));
      aco.put("value", hz.a.j("value", 4));
    }
    
    public h()
    {
      this.xJ = 2;
      this.acp = new HashSet();
    }
    
    h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
    {
      this.acp = paramSet;
      this.xJ = paramInt1;
      this.adU = paramString1;
      this.AQ = paramInt2;
      this.mValue = paramString2;
    }
    
    protected boolean a(hz.a parama)
    {
      return this.acp.contains(Integer.valueOf(parama.fI()));
    }
    
    protected Object aF(String paramString)
    {
      return null;
    }
    
    protected boolean aG(String paramString)
    {
      return false;
    }
    
    protected Object b(hz.a parama)
    {
      Object localObject;
      switch (parama.fI())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
      case 4: 
        localObject = this.mValue;
        break;
      case 5: 
        localObject = this.adU;
        break;
      case 6: 
        localObject = Integer.valueOf(this.AQ);
      }
      return localObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject instanceof h))
      {
        if (this != paramObject)
        {
          h localh = (h)paramObject;
          Iterator localIterator = aco.values().iterator();
          hz.a locala;
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                return true;
              }
              locala = (hz.a)bool.next();
              if (a(locala)) {
                break;
              }
            } while (!localh.a(locala));
            bool = false;
            break;
            if (!localh.a(locala))
            {
              bool = false;
              break;
            }
          } while (b(locala).equals(localh.b(locala)));
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public HashMap<String, hz.a<?, ?>> fB()
    {
      return aco;
    }
    
    public String getLabel()
    {
      return this.adU;
    }
    
    public int getType()
    {
      return this.AQ;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    int getVersionCode()
    {
      return this.xJ;
    }
    
    public boolean hasLabel()
    {
      return this.acp.contains(Integer.valueOf(5));
    }
    
    public boolean hasType()
    {
      return this.acp.contains(Integer.valueOf(6));
    }
    
    public boolean hasValue()
    {
      return this.acp.contains(Integer.valueOf(4));
    }
    
    public int hashCode()
    {
      Iterator localIterator = aco.values().iterator();
      for (int i = 0;; i = i)
      {
        if (!localIterator.hasNext()) {
          return i;
        }
        hz.a locala = (hz.a)localIterator.next();
        if (!a(locala)) {
          i = i;
        } else {
          i = i + locala.fI() + b(locala).hashCode();
        }
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    @Deprecated
    public int kS()
    {
      return 4;
    }
    
    public h kT()
    {
      return this;
    }
    
    Set<Integer> kf()
    {
      return this.acp;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ld.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class g
    extends hz
    implements SafeParcelable, Person.PlacesLived
  {
    public static final lc CREATOR = new lc();
    private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
    private final Set<Integer> acp;
    private boolean adT;
    private String mValue;
    private final int xJ;
    
    static
    {
      aco.put("primary", hz.a.i("primary", 2));
      aco.put("value", hz.a.j("value", 3));
    }
    
    public g()
    {
      this.xJ = 1;
      this.acp = new HashSet();
    }
    
    g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
    {
      this.acp = paramSet;
      this.xJ = paramInt;
      this.adT = paramBoolean;
      this.mValue = paramString;
    }
    
    protected boolean a(hz.a parama)
    {
      return this.acp.contains(Integer.valueOf(parama.fI()));
    }
    
    protected Object aF(String paramString)
    {
      return null;
    }
    
    protected boolean aG(String paramString)
    {
      return false;
    }
    
    protected Object b(hz.a parama)
    {
      Object localObject;
      switch (parama.fI())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
      case 2: 
        localObject = Boolean.valueOf(this.adT);
        break;
      case 3: 
        localObject = this.mValue;
      }
      return localObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject instanceof g))
      {
        if (this != paramObject)
        {
          g localg = (g)paramObject;
          Iterator localIterator = aco.values().iterator();
          hz.a locala;
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                return true;
              }
              locala = (hz.a)localIterator.next();
              if (a(locala)) {
                break;
              }
            } while (!bool.a(locala));
            bool = false;
            break;
            if (!bool.a(locala))
            {
              bool = false;
              break;
            }
          } while (b(locala).equals(bool.b(locala)));
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public HashMap<String, hz.a<?, ?>> fB()
    {
      return aco;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
    
    int getVersionCode()
    {
      return this.xJ;
    }
    
    public boolean hasPrimary()
    {
      return this.acp.contains(Integer.valueOf(2));
    }
    
    public boolean hasValue()
    {
      return this.acp.contains(Integer.valueOf(3));
    }
    
    public int hashCode()
    {
      Iterator localIterator = aco.values().iterator();
      for (int i = 0;; i = i)
      {
        if (!localIterator.hasNext()) {
          return i;
        }
        hz.a locala = (hz.a)localIterator.next();
        if (!a(locala)) {
          i = i;
        } else {
          i = i + locala.fI() + b(locala).hashCode();
        }
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public boolean isPrimary()
    {
      return this.adT;
    }
    
    public g kR()
    {
      return this;
    }
    
    Set<Integer> kf()
    {
      return this.acp;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      lc.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class f
    extends hz
    implements SafeParcelable, Person.Organizations
  {
    public static final lb CREATOR = new lb();
    private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
    private int AQ;
    private String HV;
    private String Mm;
    private String acM;
    private final Set<Integer> acp;
    private String adR;
    private String adS;
    private boolean adT;
    private String adc;
    private String mName;
    private final int xJ;
    
    static
    {
      aco.put("department", hz.a.j("department", 2));
      aco.put("description", hz.a.j("description", 3));
      aco.put("endDate", hz.a.j("endDate", 4));
      aco.put("location", hz.a.j("location", 5));
      aco.put("name", hz.a.j("name", 6));
      aco.put("primary", hz.a.i("primary", 7));
      aco.put("startDate", hz.a.j("startDate", 8));
      aco.put("title", hz.a.j("title", 9));
      aco.put("type", hz.a.a("type", 10, new hw().f("work", 0).f("school", 1), false));
    }
    
    public f()
    {
      this.xJ = 1;
      this.acp = new HashSet();
    }
    
    f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
    {
      this.acp = paramSet;
      this.xJ = paramInt1;
      this.adR = paramString1;
      this.Mm = paramString2;
      this.acM = paramString3;
      this.adS = paramString4;
      this.mName = paramString5;
      this.adT = paramBoolean;
      this.adc = paramString6;
      this.HV = paramString7;
      this.AQ = paramInt2;
    }
    
    protected boolean a(hz.a parama)
    {
      return this.acp.contains(Integer.valueOf(parama.fI()));
    }
    
    protected Object aF(String paramString)
    {
      return null;
    }
    
    protected boolean aG(String paramString)
    {
      return false;
    }
    
    protected Object b(hz.a parama)
    {
      Object localObject;
      switch (parama.fI())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
      case 2: 
        localObject = this.adR;
        break;
      case 3: 
        localObject = this.Mm;
        break;
      case 4: 
        localObject = this.acM;
        break;
      case 5: 
        localObject = this.adS;
        break;
      case 6: 
        localObject = this.mName;
        break;
      case 7: 
        localObject = Boolean.valueOf(this.adT);
        break;
      case 8: 
        localObject = this.adc;
        break;
      case 9: 
        localObject = this.HV;
        break;
      case 10: 
        localObject = Integer.valueOf(this.AQ);
      }
      return localObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject instanceof f))
      {
        if (this != paramObject)
        {
          f localf = (f)paramObject;
          Iterator localIterator = aco.values().iterator();
          do
          {
            hz.a locala;
            do
            {
              if (!localIterator.hasNext())
              {
                int i = 1;
                return ???;
              }
              locala = (hz.a)localIterator.next();
              if (a(locala)) {
                break;
              }
            } while (!localf.a(locala));
            bool = false;
            break;
            if (!localf.a(bool))
            {
              bool = false;
              break;
            }
          } while (b(bool).equals(localf.b(bool)));
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public HashMap<String, hz.a<?, ?>> fB()
    {
      return aco;
    }
    
    public String getDepartment()
    {
      return this.adR;
    }
    
    public String getDescription()
    {
      return this.Mm;
    }
    
    public String getEndDate()
    {
      return this.acM;
    }
    
    public String getLocation()
    {
      return this.adS;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public String getStartDate()
    {
      return this.adc;
    }
    
    public String getTitle()
    {
      return this.HV;
    }
    
    public int getType()
    {
      return this.AQ;
    }
    
    int getVersionCode()
    {
      return this.xJ;
    }
    
    public boolean hasDepartment()
    {
      return this.acp.contains(Integer.valueOf(2));
    }
    
    public boolean hasDescription()
    {
      return this.acp.contains(Integer.valueOf(3));
    }
    
    public boolean hasEndDate()
    {
      return this.acp.contains(Integer.valueOf(4));
    }
    
    public boolean hasLocation()
    {
      return this.acp.contains(Integer.valueOf(5));
    }
    
    public boolean hasName()
    {
      return this.acp.contains(Integer.valueOf(6));
    }
    
    public boolean hasPrimary()
    {
      return this.acp.contains(Integer.valueOf(7));
    }
    
    public boolean hasStartDate()
    {
      return this.acp.contains(Integer.valueOf(8));
    }
    
    public boolean hasTitle()
    {
      return this.acp.contains(Integer.valueOf(9));
    }
    
    public boolean hasType()
    {
      return this.acp.contains(Integer.valueOf(10));
    }
    
    public int hashCode()
    {
      Iterator localIterator = aco.values().iterator();
      for (int i = 0;; i = i)
      {
        if (!localIterator.hasNext()) {
          return i;
        }
        hz.a locala = (hz.a)localIterator.next();
        if (!a(locala)) {
          i = i;
        } else {
          i = i + locala.fI() + b(locala).hashCode();
        }
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public boolean isPrimary()
    {
      return this.adT;
    }
    
    public f kQ()
    {
      return this;
    }
    
    Set<Integer> kf()
    {
      return this.acp;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      lb.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class d
    extends hz
    implements SafeParcelable, Person.Name
  {
    public static final la CREATOR = new la();
    private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
    private String acN;
    private String acQ;
    private final Set<Integer> acp;
    private String adN;
    private String adO;
    private String adP;
    private String adQ;
    private final int xJ;
    
    static
    {
      aco.put("familyName", hz.a.j("familyName", 2));
      aco.put("formatted", hz.a.j("formatted", 3));
      aco.put("givenName", hz.a.j("givenName", 4));
      aco.put("honorificPrefix", hz.a.j("honorificPrefix", 5));
      aco.put("honorificSuffix", hz.a.j("honorificSuffix", 6));
      aco.put("middleName", hz.a.j("middleName", 7));
    }
    
    public d()
    {
      this.xJ = 1;
      this.acp = new HashSet();
    }
    
    d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.acp = paramSet;
      this.xJ = paramInt;
      this.acN = paramString1;
      this.adN = paramString2;
      this.acQ = paramString3;
      this.adO = paramString4;
      this.adP = paramString5;
      this.adQ = paramString6;
    }
    
    protected boolean a(hz.a parama)
    {
      return this.acp.contains(Integer.valueOf(parama.fI()));
    }
    
    protected Object aF(String paramString)
    {
      return null;
    }
    
    protected boolean aG(String paramString)
    {
      return false;
    }
    
    protected Object b(hz.a parama)
    {
      String str;
      switch (parama.fI())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
      case 2: 
        str = this.acN;
        break;
      case 3: 
        str = this.adN;
        break;
      case 4: 
        str = this.acQ;
        break;
      case 5: 
        str = this.adO;
        break;
      case 6: 
        str = this.adP;
        break;
      case 7: 
        str = this.adQ;
      }
      return str;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject instanceof d))
      {
        if (this != paramObject)
        {
          d locald = (d)paramObject;
          Iterator localIterator = aco.values().iterator();
          hz.a locala;
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                return true;
              }
              locala = (hz.a)bool.next();
              if (a(locala)) {
                break;
              }
            } while (!locald.a(locala));
            bool = false;
            break;
            if (!locald.a(locala))
            {
              bool = false;
              break;
            }
          } while (b(locala).equals(locald.b(locala)));
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public HashMap<String, hz.a<?, ?>> fB()
    {
      return aco;
    }
    
    public String getFamilyName()
    {
      return this.acN;
    }
    
    public String getFormatted()
    {
      return this.adN;
    }
    
    public String getGivenName()
    {
      return this.acQ;
    }
    
    public String getHonorificPrefix()
    {
      return this.adO;
    }
    
    public String getHonorificSuffix()
    {
      return this.adP;
    }
    
    public String getMiddleName()
    {
      return this.adQ;
    }
    
    int getVersionCode()
    {
      return this.xJ;
    }
    
    public boolean hasFamilyName()
    {
      return this.acp.contains(Integer.valueOf(2));
    }
    
    public boolean hasFormatted()
    {
      return this.acp.contains(Integer.valueOf(3));
    }
    
    public boolean hasGivenName()
    {
      return this.acp.contains(Integer.valueOf(4));
    }
    
    public boolean hasHonorificPrefix()
    {
      return this.acp.contains(Integer.valueOf(5));
    }
    
    public boolean hasHonorificSuffix()
    {
      return this.acp.contains(Integer.valueOf(6));
    }
    
    public boolean hasMiddleName()
    {
      return this.acp.contains(Integer.valueOf(7));
    }
    
    public int hashCode()
    {
      Iterator localIterator = aco.values().iterator();
      for (int i = 0;; i = i)
      {
        if (!localIterator.hasNext()) {
          return i;
        }
        hz.a locala = (hz.a)localIterator.next();
        if (!a(locala)) {
          i = i;
        } else {
          i = i + locala.fI() + b(locala).hashCode();
        }
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public d kP()
    {
      return this;
    }
    
    Set<Integer> kf()
    {
      return this.acp;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      la.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class c
    extends hz
    implements SafeParcelable, Person.Image
  {
    public static final kz CREATOR = new kz();
    private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
    private final Set<Integer> acp;
    private String qV;
    private final int xJ;
    
    static
    {
      aco.put("url", hz.a.j("url", 2));
    }
    
    public c()
    {
      this.xJ = 1;
      this.acp = new HashSet();
    }
    
    public c(String paramString)
    {
      this.acp = new HashSet();
      this.xJ = 1;
      this.qV = paramString;
      this.acp.add(Integer.valueOf(2));
    }
    
    c(Set<Integer> paramSet, int paramInt, String paramString)
    {
      this.acp = paramSet;
      this.xJ = paramInt;
      this.qV = paramString;
    }
    
    protected boolean a(hz.a parama)
    {
      return this.acp.contains(Integer.valueOf(parama.fI()));
    }
    
    protected Object aF(String paramString)
    {
      return null;
    }
    
    protected boolean aG(String paramString)
    {
      return false;
    }
    
    protected Object b(hz.a parama)
    {
      switch (parama.fI())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
      }
      return this.qV;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject instanceof c))
      {
        if (this != paramObject)
        {
          c localc = (c)paramObject;
          Iterator localIterator = aco.values().iterator();
          hz.a locala;
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                return true;
              }
              locala = (hz.a)bool.next();
              if (a(locala)) {
                break;
              }
            } while (!localc.a(locala));
            bool = false;
            break;
            if (!localc.a(locala))
            {
              bool = false;
              break;
            }
          } while (b(locala).equals(localc.b(locala)));
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public HashMap<String, hz.a<?, ?>> fB()
    {
      return aco;
    }
    
    public String getUrl()
    {
      return this.qV;
    }
    
    int getVersionCode()
    {
      return this.xJ;
    }
    
    public boolean hasUrl()
    {
      return this.acp.contains(Integer.valueOf(2));
    }
    
    public int hashCode()
    {
      Iterator localIterator = aco.values().iterator();
      hz.a locala2;
      for (hz.a locala3 = 0;; locala3 = locala2)
      {
        if (!localIterator.hasNext()) {
          return locala3;
        }
        hz.a locala1 = (hz.a)localIterator.next();
        if (!a(locala1)) {
          locala1 = locala3;
        } else {
          locala2 = locala3 + locala1.fI() + b(locala1).hashCode();
        }
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public c kO()
    {
      return this;
    }
    
    Set<Integer> kf()
    {
      return this.acp;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      kz.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class b
    extends hz
    implements SafeParcelable, Person.Cover
  {
    public static final kw CREATOR = new kw();
    private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
    private final Set<Integer> acp;
    private a adI;
    private b adJ;
    private int adK;
    private final int xJ;
    
    static
    {
      aco.put("coverInfo", hz.a.a("coverInfo", 2, a.class));
      aco.put("coverPhoto", hz.a.a("coverPhoto", 3, b.class));
      aco.put("layout", hz.a.a("layout", 4, new hw().f("banner", 0), false));
    }
    
    public b()
    {
      this.xJ = 1;
      this.acp = new HashSet();
    }
    
    b(Set<Integer> paramSet, int paramInt1, a parama, b paramb, int paramInt2)
    {
      this.acp = paramSet;
      this.xJ = paramInt1;
      this.adI = parama;
      this.adJ = paramb;
      this.adK = paramInt2;
    }
    
    protected boolean a(hz.a parama)
    {
      return this.acp.contains(Integer.valueOf(parama.fI()));
    }
    
    protected Object aF(String paramString)
    {
      return null;
    }
    
    protected boolean aG(String paramString)
    {
      return false;
    }
    
    protected Object b(hz.a parama)
    {
      Object localObject;
      switch (parama.fI())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
      case 2: 
        localObject = this.adI;
        break;
      case 3: 
        localObject = this.adJ;
        break;
      case 4: 
        localObject = Integer.valueOf(this.adK);
      }
      return localObject;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject instanceof b))
      {
        if (this != paramObject)
        {
          b localb = (b)paramObject;
          Iterator localIterator = aco.values().iterator();
          hz.a locala;
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                return true;
              }
              locala = (hz.a)localIterator.next();
              if (a(locala)) {
                break;
              }
            } while (!bool.a(locala));
            bool = false;
            break;
            if (!bool.a(locala))
            {
              bool = false;
              break;
            }
          } while (b(locala).equals(bool.b(locala)));
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public HashMap<String, hz.a<?, ?>> fB()
    {
      return aco;
    }
    
    public Person.Cover.CoverInfo getCoverInfo()
    {
      return this.adI;
    }
    
    public Person.Cover.CoverPhoto getCoverPhoto()
    {
      return this.adJ;
    }
    
    public int getLayout()
    {
      return this.adK;
    }
    
    int getVersionCode()
    {
      return this.xJ;
    }
    
    public boolean hasCoverInfo()
    {
      return this.acp.contains(Integer.valueOf(2));
    }
    
    public boolean hasCoverPhoto()
    {
      return this.acp.contains(Integer.valueOf(3));
    }
    
    public boolean hasLayout()
    {
      return this.acp.contains(Integer.valueOf(4));
    }
    
    public int hashCode()
    {
      Iterator localIterator = aco.values().iterator();
      for (int i = 0;; i = i)
      {
        if (!localIterator.hasNext()) {
          return i;
        }
        hz.a locala = (hz.a)localIterator.next();
        if (!a(locala)) {
          i = i;
        } else {
          i = i + locala.fI() + b(locala).hashCode();
        }
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    a kJ()
    {
      return this.adI;
    }
    
    b kK()
    {
      return this.adJ;
    }
    
    public b kL()
    {
      return this;
    }
    
    Set<Integer> kf()
    {
      return this.acp;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      kw.a(this, paramParcel, paramInt);
    }
    
    public static final class b
      extends hz
      implements SafeParcelable, Person.Cover.CoverPhoto
    {
      public static final ky CREATOR = new ky();
      private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
      private final Set<Integer> acp;
      private int ks;
      private int kt;
      private String qV;
      private final int xJ;
      
      static
      {
        aco.put("height", hz.a.g("height", 2));
        aco.put("url", hz.a.j("url", 3));
        aco.put("width", hz.a.g("width", 4));
      }
      
      public b()
      {
        this.xJ = 1;
        this.acp = new HashSet();
      }
      
      b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        this.acp = paramSet;
        this.xJ = paramInt1;
        this.kt = paramInt2;
        this.qV = paramString;
        this.ks = paramInt3;
      }
      
      protected boolean a(hz.a parama)
      {
        return this.acp.contains(Integer.valueOf(parama.fI()));
      }
      
      protected Object aF(String paramString)
      {
        return null;
      }
      
      protected boolean aG(String paramString)
      {
        return false;
      }
      
      protected Object b(hz.a parama)
      {
        Object localObject;
        switch (parama.fI())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
        case 2: 
          localObject = Integer.valueOf(this.kt);
          break;
        case 3: 
          localObject = this.qV;
          break;
        case 4: 
          localObject = Integer.valueOf(this.ks);
        }
        return localObject;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        boolean bool;
        if ((paramObject instanceof b))
        {
          if (this != paramObject)
          {
            b localb = (b)paramObject;
            Iterator localIterator = aco.values().iterator();
            hz.a locala;
            do
            {
              do
              {
                if (!localIterator.hasNext()) {
                  return true;
                }
                locala = (hz.a)localIterator.next();
                if (a(locala)) {
                  break;
                }
              } while (!bool.a(locala));
              bool = false;
              break;
              if (!bool.a(locala))
              {
                bool = false;
                break;
              }
            } while (b(locala).equals(bool.b(locala)));
            bool = false;
          }
          else
          {
            bool = true;
          }
        }
        else {
          bool = false;
        }
        return bool;
      }
      
      public HashMap<String, hz.a<?, ?>> fB()
      {
        return aco;
      }
      
      public int getHeight()
      {
        return this.kt;
      }
      
      public String getUrl()
      {
        return this.qV;
      }
      
      int getVersionCode()
      {
        return this.xJ;
      }
      
      public int getWidth()
      {
        return this.ks;
      }
      
      public boolean hasHeight()
      {
        return this.acp.contains(Integer.valueOf(2));
      }
      
      public boolean hasUrl()
      {
        return this.acp.contains(Integer.valueOf(3));
      }
      
      public boolean hasWidth()
      {
        return this.acp.contains(Integer.valueOf(4));
      }
      
      public int hashCode()
      {
        Iterator localIterator = aco.values().iterator();
        for (int i = 0;; i = i)
        {
          if (!localIterator.hasNext()) {
            return i;
          }
          hz.a locala = (hz.a)localIterator.next();
          if (!a(locala)) {
            i = i;
          } else {
            i = i + locala.fI() + b(locala).hashCode();
          }
        }
      }
      
      public boolean isDataValid()
      {
        return true;
      }
      
      public b kN()
      {
        return this;
      }
      
      Set<Integer> kf()
      {
        return this.acp;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        ky.a(this, paramParcel, paramInt);
      }
    }
    
    public static final class a
      extends hz
      implements SafeParcelable, Person.Cover.CoverInfo
    {
      public static final kx CREATOR = new kx();
      private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
      private final Set<Integer> acp;
      private int adL;
      private int adM;
      private final int xJ;
      
      static
      {
        aco.put("leftImageOffset", hz.a.g("leftImageOffset", 2));
        aco.put("topImageOffset", hz.a.g("topImageOffset", 3));
      }
      
      public a()
      {
        this.xJ = 1;
        this.acp = new HashSet();
      }
      
      a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
      {
        this.acp = paramSet;
        this.xJ = paramInt1;
        this.adL = paramInt2;
        this.adM = paramInt3;
      }
      
      protected boolean a(hz.a parama)
      {
        return this.acp.contains(Integer.valueOf(parama.fI()));
      }
      
      protected Object aF(String paramString)
      {
        return null;
      }
      
      protected boolean aG(String paramString)
      {
        return false;
      }
      
      protected Object b(hz.a parama)
      {
        Integer localInteger;
        switch (parama.fI())
        {
        default: 
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
        case 2: 
          localInteger = Integer.valueOf(this.adL);
          break;
        case 3: 
          localInteger = Integer.valueOf(this.adM);
        }
        return localInteger;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        boolean bool;
        if ((paramObject instanceof a))
        {
          if (this != paramObject)
          {
            a locala = (a)paramObject;
            Iterator localIterator = aco.values().iterator();
            hz.a locala1;
            do
            {
              do
              {
                if (!localIterator.hasNext()) {
                  return true;
                }
                locala1 = (hz.a)bool.next();
                if (a(locala1)) {
                  break;
                }
              } while (!locala.a(locala1));
              bool = false;
              break;
              if (!locala.a(locala1))
              {
                bool = false;
                break;
              }
            } while (b(locala1).equals(locala.b(locala1)));
            bool = false;
          }
          else
          {
            bool = true;
          }
        }
        else {
          bool = false;
        }
        return bool;
      }
      
      public HashMap<String, hz.a<?, ?>> fB()
      {
        return aco;
      }
      
      public int getLeftImageOffset()
      {
        return this.adL;
      }
      
      public int getTopImageOffset()
      {
        return this.adM;
      }
      
      int getVersionCode()
      {
        return this.xJ;
      }
      
      public boolean hasLeftImageOffset()
      {
        return this.acp.contains(Integer.valueOf(2));
      }
      
      public boolean hasTopImageOffset()
      {
        return this.acp.contains(Integer.valueOf(3));
      }
      
      public int hashCode()
      {
        Iterator localIterator = aco.values().iterator();
        hz.a locala2;
        for (hz.a locala3 = 0;; locala3 = locala2)
        {
          if (!localIterator.hasNext()) {
            return locala3;
          }
          hz.a locala1 = (hz.a)localIterator.next();
          if (!a(locala1)) {
            locala1 = locala3;
          } else {
            locala2 = locala3 + locala1.fI() + b(locala1).hashCode();
          }
        }
      }
      
      public boolean isDataValid()
      {
        return true;
      }
      
      public a kM()
      {
        return this;
      }
      
      Set<Integer> kf()
      {
        return this.acp;
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        kx.a(this, paramParcel, paramInt);
      }
    }
  }
  
  public static final class a
    extends hz
    implements SafeParcelable, Person.AgeRange
  {
    public static final kv CREATOR = new kv();
    private static final HashMap<String, hz.a<?, ?>> aco = new HashMap();
    private final Set<Integer> acp;
    private int adG;
    private int adH;
    private final int xJ;
    
    static
    {
      aco.put("max", hz.a.g("max", 2));
      aco.put("min", hz.a.g("min", 3));
    }
    
    public a()
    {
      this.xJ = 1;
      this.acp = new HashSet();
    }
    
    a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
    {
      this.acp = paramSet;
      this.xJ = paramInt1;
      this.adG = paramInt2;
      this.adH = paramInt3;
    }
    
    protected boolean a(hz.a parama)
    {
      return this.acp.contains(Integer.valueOf(parama.fI()));
    }
    
    protected Object aF(String paramString)
    {
      return null;
    }
    
    protected boolean aG(String paramString)
    {
      return false;
    }
    
    protected Object b(hz.a parama)
    {
      Integer localInteger;
      switch (parama.fI())
      {
      default: 
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.fI());
      case 2: 
        localInteger = Integer.valueOf(this.adG);
        break;
      case 3: 
        localInteger = Integer.valueOf(this.adH);
      }
      return localInteger;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject instanceof a))
      {
        if (this != paramObject)
        {
          a locala = (a)paramObject;
          Iterator localIterator = aco.values().iterator();
          hz.a locala1;
          do
          {
            do
            {
              if (!localIterator.hasNext()) {
                return true;
              }
              locala1 = (hz.a)localIterator.next();
              if (a(locala1)) {
                break;
              }
            } while (!bool.a(locala1));
            bool = false;
            break;
            if (!bool.a(locala1))
            {
              bool = false;
              break;
            }
          } while (b(locala1).equals(bool.b(locala1)));
          bool = false;
        }
        else
        {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public HashMap<String, hz.a<?, ?>> fB()
    {
      return aco;
    }
    
    public int getMax()
    {
      return this.adG;
    }
    
    public int getMin()
    {
      return this.adH;
    }
    
    int getVersionCode()
    {
      return this.xJ;
    }
    
    public boolean hasMax()
    {
      return this.acp.contains(Integer.valueOf(2));
    }
    
    public boolean hasMin()
    {
      return this.acp.contains(Integer.valueOf(3));
    }
    
    public int hashCode()
    {
      Iterator localIterator = aco.values().iterator();
      for (int i = 0;; i = i)
      {
        if (!localIterator.hasNext()) {
          return i;
        }
        hz.a locala = (hz.a)localIterator.next();
        if (!a(locala)) {
          i = i;
        } else {
          i = i + locala.fI() + b(locala).hashCode();
        }
      }
    }
    
    public boolean isDataValid()
    {
      return true;
    }
    
    public a kI()
    {
      return this;
    }
    
    Set<Integer> kf()
    {
      return this.acp;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      kv.a(this, paramParcel, paramInt);
    }
  }
  
  public static class e
  {
    public static int bA(String paramString)
    {
      int i;
      if (!paramString.equals("person"))
      {
        if (!paramString.equals("page")) {
          throw new IllegalArgumentException("Unknown objectType string: " + paramString);
        }
        i = 1;
      }
      else
      {
        i = 0;
      }
      return i;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kt
 * JD-Core Version:    0.7.0.1
 */