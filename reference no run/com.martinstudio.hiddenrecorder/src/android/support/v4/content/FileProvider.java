package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String ATTR_NAME = "name";
  private static final String ATTR_PATH = "path";
  private static final String[] COLUMNS;
  private static final File DEVICE_ROOT = new File("/");
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  private static final String TAG_CACHE_PATH = "cache-path";
  private static final String TAG_EXTERNAL = "external-path";
  private static final String TAG_FILES_PATH = "files-path";
  private static final String TAG_ROOT_PATH = "root-path";
  private static HashMap<String, PathStrategy> sCache = new HashMap();
  private PathStrategy mStrategy;
  
  static
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "_display_name";
    arrayOfString[1] = "_size";
    COLUMNS = arrayOfString;
  }
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject1;
    for (Object localObject2 = paramFile;; localObject2 = localObject1)
    {
      if (i >= j) {
        return localObject2;
      }
      localObject1 = paramVarArgs[i];
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = new File((File)localObject2, (String)localObject1);
      }
      i++;
    }
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static PathStrategy getPathStrategy(Context paramContext, String paramString)
  {
    PathStrategy localPathStrategy;
    synchronized (sCache)
    {
      localPathStrategy = (PathStrategy)sCache.get(paramString);
      if (localPathStrategy != null) {}
    }
    try
    {
      localPathStrategy = parsePathStrategy(paramContext, paramString);
      localPathStrategy = localPathStrategy;
      sCache.put(paramString, localPathStrategy);
      return localPathStrategy;
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", localIOException);
      localObject = finally;
      throw localObject;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", localXmlPullParserException);
    }
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }
  
  private static int modeToMode(String paramString)
  {
    int i;
    if (!"r".equals(paramString))
    {
      if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
      {
        if (!"wa".equals(paramString))
        {
          if (!"rw".equals(paramString))
          {
            if (!"rwt".equals(paramString)) {
              throw new IllegalArgumentException("Invalid mode: " + paramString);
            }
            i = 1006632960;
          }
          else
          {
            i = 939524096;
          }
        }
        else {
          i = 704643072;
        }
      }
      else {
        i = 738197504;
      }
    }
    else {
      i = 268435456;
    }
    return i;
  }
  
  private static PathStrategy parsePathStrategy(Context paramContext, String paramString)
    throws IOException, XmlPullParserException
  {
    SimplePathStrategy localSimplePathStrategy = new SimplePathStrategy(paramString);
    XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser != null) {
      for (;;)
      {
        int i = localXmlResourceParser.next();
        if (i == 1) {
          return localSimplePathStrategy;
        }
        if (i == 2)
        {
          Object localObject2 = localXmlResourceParser.getName();
          String str1 = localXmlResourceParser.getAttributeValue(null, "name");
          String str2 = localXmlResourceParser.getAttributeValue(null, "path");
          Object localObject1 = null;
          if (!"root-path".equals(localObject2))
          {
            if (!"files-path".equals(localObject2))
            {
              if (!"cache-path".equals(localObject2))
              {
                if ("external-path".equals(localObject2))
                {
                  localObject2 = Environment.getExternalStorageDirectory();
                  localObject1 = new String[1];
                  localObject1[0] = str2;
                  localObject1 = buildPath((File)localObject2, (String[])localObject1);
                }
              }
              else
              {
                localObject1 = paramContext.getCacheDir();
                localObject2 = new String[1];
                localObject2[0] = str2;
                localObject1 = buildPath((File)localObject1, (String[])localObject2);
              }
            }
            else
            {
              localObject2 = paramContext.getFilesDir();
              localObject1 = new String[1];
              localObject1[0] = str2;
              localObject1 = buildPath((File)localObject2, (String[])localObject1);
            }
          }
          else
          {
            localObject1 = DEVICE_ROOT;
            localObject2 = new String[1];
            localObject2[0] = str2;
            localObject1 = buildPath((File)localObject1, (String[])localObject2);
          }
          if (localObject1 != null) {
            localSimplePathStrategy.addRoot(str1, (File)localObject1);
          }
        }
      }
    }
    throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!paramProviderInfo.exported)
    {
      if (paramProviderInfo.grantUriPermissions)
      {
        this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority);
        return;
      }
      throw new SecurityException("Provider must grant uri permissions");
    }
    throw new SecurityException("Provider must not be exported");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i;
    if (!this.mStrategy.getFileForUri(paramUri).delete()) {
      i = 0;
    } else {
      i = 1;
    }
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    File localFile = this.mStrategy.getFileForUri(paramUri);
    int i = localFile.getName().lastIndexOf('.');
    String str;
    if (i >= 0)
    {
      str = localFile.getName().substring(i + 1);
      str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
      if (str != null) {}
    }
    else
    {
      str = "application/octet-stream";
    }
    return str;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    File localFile = this.mStrategy.getFileForUri(paramUri);
    if (paramArrayOfString1 == null) {
      paramArrayOfString1 = COLUMNS;
    }
    String[] arrayOfString3 = new String[paramArrayOfString1.length];
    Object[] arrayOfObject = new Object[paramArrayOfString1.length];
    String[] arrayOfString2 = paramArrayOfString1;
    int j = arrayOfString2.length;
    int k = 0;
    MatrixCursor localMatrixCursor1;
    MatrixCursor localMatrixCursor2;
    for (int i = 0;; localMatrixCursor1 = localMatrixCursor2)
    {
      if (k >= j)
      {
        String[] arrayOfString1 = copyOf(arrayOfString3, i);
        arrayOfObject = copyOf(arrayOfObject, i);
        localMatrixCursor1 = new MatrixCursor(arrayOfString1, 1);
        localMatrixCursor1.addRow(arrayOfObject);
        return localMatrixCursor1;
      }
      String str = arrayOfString2[k];
      if (!"_display_name".equals(str))
      {
        if (!"_size".equals(str))
        {
          int m = localMatrixCursor1;
        }
        else
        {
          arrayOfString3[localMatrixCursor1] = "_size";
          localMatrixCursor2 = localMatrixCursor1 + 1;
          arrayOfObject[localMatrixCursor1] = Long.valueOf(localFile.length());
        }
      }
      else
      {
        arrayOfString3[localMatrixCursor1] = "_display_name";
        localMatrixCursor2 = localMatrixCursor1 + 1;
        arrayOfObject[localMatrixCursor1] = localFile.getName();
      }
      k++;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static class SimplePathStrategy
    implements FileProvider.PathStrategy
  {
    private final String mAuthority;
    private final HashMap<String, File> mRoots = new HashMap();
    
    public SimplePathStrategy(String paramString)
    {
      this.mAuthority = paramString;
    }
    
    public void addRoot(String paramString, File paramFile)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Name must not be empty");
      }
      try
      {
        File localFile = paramFile.getCanonicalFile();
        this.mRoots.put(paramString, localFile);
        return;
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile, localIOException);
      }
    }
    
    public File getFileForUri(Uri paramUri)
    {
      String str = paramUri.getEncodedPath();
      int i = str.indexOf('/', 1);
      Object localObject1 = Uri.decode(str.substring(1, i));
      Object localObject2 = Uri.decode(str.substring(i + 1));
      localObject1 = (File)this.mRoots.get(localObject1);
      if (localObject1 == null) {
        throw new IllegalArgumentException("Unable to find configured root for " + paramUri);
      }
      localObject2 = new File((File)localObject1, (String)localObject2);
      try
      {
        localObject2 = ((File)localObject2).getCanonicalFile();
        if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
          throw new SecurityException("Resolved path jumped beyond configured root");
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + localObject2);
      }
      return localObject2;
    }
    
    public Uri getUriForFile(File paramFile)
    {
      Object localObject1;
      try
      {
        str1 = paramFile.getCanonicalPath();
        localObject1 = null;
        localObject2 = this.mRoots.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          String str2 = ((File)localEntry.getValue()).getPath();
          if ((str1.startsWith(str2)) && ((localObject1 == null) || (str2.length() > ((File)((Map.Entry)localObject1).getValue()).getPath().length()))) {
            localObject1 = localEntry;
          }
        }
        if (localObject1 != null) {
          break label159;
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile);
      }
      throw new IllegalArgumentException("Failed to find configured root that contains " + str1);
      label159:
      Object localObject2 = ((File)((Map.Entry)localObject1).getValue()).getPath();
      if (((String)localObject2).endsWith("/")) {}
      for (String str1 = str1.substring(((String)localObject2).length());; str1 = str1.substring(1 + ((String)localObject2).length()))
      {
        localObject1 = Uri.encode((String)((Map.Entry)localObject1).getKey()) + '/' + Uri.encode(str1, "/");
        return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath((String)localObject1).build();
      }
    }
  }
  
  static abstract interface PathStrategy
  {
    public abstract File getFileForUri(Uri paramUri);
    
    public abstract Uri getUriForFile(File paramFile);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */