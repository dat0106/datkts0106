package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LibraryManager
{
  private static final String NAMESPACE_PREFIX = "com.sony";
  private static final Pattern VERSION_PATTERN = Pattern.compile("_(\\d+)(p?)$");
  private static final int VERSION_PATTERN_GROUP_NUMBER = 1;
  private static final int VERSION_PATTERN_GROUP_PROTOTYPE = 2;
  public static final int VERSION_UNKNOWN;
  private final Set<LibraryInfo> mLibraries;
  private final Map<String, LibraryInfo> mLibraryMap = new HashMap();
  
  private LibraryManager(Context paramContext)
  {
    for (String str2 : paramContext.getPackageManager().getSystemSharedLibraryNames()) {
      if (isSemcApi(str2))
      {
        int j = 0;
        Object localObject = VERSION_PATTERN.matcher(str2);
        String str1 = str2;
        if (((Matcher)localObject).find())
        {
          str1 = str2.substring(0, ((Matcher)localObject).start());
          if (((Matcher)localObject).group(2).isEmpty()) {
            j = Integer.parseInt(((Matcher)localObject).group(1));
          }
        }
        localObject = (LibraryInfo)this.mLibraryMap.get(str1);
        if (localObject == null)
        {
          localObject = new LibraryInfo(str1, null);
          this.mLibraryMap.put(str1, localObject);
        }
        ((LibraryInfo)localObject).addVersion(j);
      }
    }
    this.mLibraries = Collections.unmodifiableSet(new HashSet(this.mLibraryMap.values()));
  }
  
  public static LibraryManager getLibraryManager(Context paramContext)
  {
    return new LibraryManager(paramContext);
  }
  
  private boolean isSemcApi(String paramString)
  {
    return paramString.startsWith("com.sony");
  }
  
  public Set<LibraryInfo> getLibraries()
  {
    return this.mLibraries;
  }
  
  public LibraryInfo getLibrary(String paramString)
    throws IllegalArgumentException
  {
    LibraryInfo localLibraryInfo = (LibraryInfo)this.mLibraryMap.get(paramString);
    if (localLibraryInfo == null) {
      throw new IllegalArgumentException("No such library installed");
    }
    return localLibraryInfo;
  }
  
  public static final class LibraryInfo
  {
    private final String mName;
    private final TreeSet<Integer> mVersions = new TreeSet();
    
    private LibraryInfo(String paramString)
    {
      this.mName = paramString;
    }
    
    private void addVersion(int paramInt)
    {
      this.mVersions.add(Integer.valueOf(paramInt));
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((!(paramObject instanceof LibraryInfo)) || (!this.mName.equals(((LibraryInfo)paramObject).mName))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public int getLatestVersion()
    {
      return ((Integer)this.mVersions.last()).intValue();
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public int hashCode()
    {
      return this.mName.hashCode();
    }
    
    public boolean isVersionSupported(int paramInt)
    {
      return this.mVersions.contains(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.LibraryManager
 * JD-Core Version:    0.7.0.1
 */