package android.support.v4.database;

import android.text.TextUtils;

public class DatabaseUtilsCompat
{
  public static String[] appendSelectionArgs(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    String[] arrayOfString;
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length != 0))
    {
      arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
      System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
      System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
    }
    else
    {
      arrayOfString = paramArrayOfString2;
    }
    return arrayOfString;
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      if (!TextUtils.isEmpty(paramString2)) {
        paramString2 = "(" + paramString1 + ") AND (" + paramString2 + ")";
      } else {
        paramString2 = paramString1;
      }
    }
    return paramString2;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.database.DatabaseUtilsCompat
 * JD-Core Version:    0.7.0.1
 */