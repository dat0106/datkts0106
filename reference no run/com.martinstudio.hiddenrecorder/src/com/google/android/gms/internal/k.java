package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

public class k
  extends j
{
  private k(Context paramContext, n paramn, o paramo)
  {
    super(paramContext, paramn, paramo);
  }
  
  public static k a(String paramString, Context paramContext)
  {
    e locale = new e();
    a(paramString, paramContext, locale);
    return new k(paramContext, locale, new q(239));
  }
  
  protected void b(Context paramContext)
  {
    long l1 = 1L;
    super.b(paramContext);
    try
    {
      a locala = f(paramContext);
      String str;
      label68:
      long l2;
      return;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          if (!locala.isLimitAdTrackingEnabled()) {
            break label68;
          }
          a(28, l1);
          str = locala.getId();
          if (str == null) {
            break;
          }
          a(30, str);
        }
        catch (IOException localIOException2) {}
        localIOException1;
        a(28, 1L);
        break;
        l2 = 0L;
      }
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
  }
  
  a f(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException
  {
    int i = 0;
    String str;
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
      str = localInfo.getId();
      if ((str != null) && (str.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")))
      {
        byte[] arrayOfByte = new byte[16];
        int j = 0;
        while (i < str.length())
        {
          if ((i == 8) || (i == 13) || (i == 18) || (i == 23)) {
            i++;
          }
          arrayOfByte[j] = ((byte)((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16)));
          j++;
          i += 2;
        }
        localObject = this.jQ.a(arrayOfByte, true);
      }
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      throw new IOException(localGooglePlayServicesRepairableException);
    }
    for (;;)
    {
      return new a((String)localObject, localGooglePlayServicesRepairableException.isLimitAdTrackingEnabled());
      Object localObject = str;
    }
  }
  
  class a
  {
    private String kb;
    private boolean kc;
    
    public a(String paramString, boolean paramBoolean)
    {
      this.kb = paramString;
      this.kc = paramBoolean;
    }
    
    public String getId()
    {
      return this.kb;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.kc;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.k
 * JD-Core Version:    0.7.0.1
 */