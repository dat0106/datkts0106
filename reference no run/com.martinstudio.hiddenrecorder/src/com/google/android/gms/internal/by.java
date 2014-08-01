package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.Iterator;
import org.json.JSONObject;

public final class by
  extends bv.a
{
  private final MediationAdapter nQ;
  
  public by(MediationAdapter paramMediationAdapter)
  {
    this.nQ = paramMediationAdapter;
  }
  
  private Bundle a(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    ev.D("Server parameters: " + paramString1);
    try
    {
      Object localObject1 = new Bundle();
      if (paramString1 != null)
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        Bundle localBundle = new Bundle();
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          localObject1 = (String)localIterator.next();
          localBundle.putString((String)localObject1, localJSONObject.getString((String)localObject1));
        }
        localObject2 = localBundle;
      }
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not get Server Parameters Bundle.", localThrowable);
      throw new RemoteException();
    }
    Object localObject2;
    if ((this.nQ instanceof AdMobAdapter))
    {
      localObject2.putString("adJson", paramString2);
      localObject2.putInt("tagForChildDirectedTreatment", paramInt);
    }
    return localObject2;
  }
  
  public void a(d paramd, aj paramaj, String paramString, bw parambw)
    throws RemoteException
  {
    a(paramd, paramaj, paramString, null, parambw);
  }
  
  /* Error */
  public void a(d paramd, aj paramaj, String paramString1, String paramString2, bw parambw)
    throws RemoteException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   7: instanceof 92
    //   10: ifne +42 -> 52
    //   13: new 21	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   20: ldc 94
    //   22: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   29: invokevirtual 100	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: invokevirtual 105	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   35: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 38	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   44: new 17	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 76	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: ldc 107
    //   54: invokestatic 110	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   61: checkcast 92	com/google/android/gms/ads/mediation/MediationInterstitialAdapter
    //   64: astore 6
    //   66: aload_2
    //   67: getfield 116	com/google/android/gms/internal/aj:lS	Ljava/util/List;
    //   70: ifnull +113 -> 183
    //   73: new 118	java/util/HashSet
    //   76: dup
    //   77: aload_2
    //   78: getfield 116	com/google/android/gms/internal/aj:lS	Ljava/util/List;
    //   81: invokespecial 121	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   84: astore 8
    //   86: new 123	com/google/android/gms/internal/bx
    //   89: dup
    //   90: new 125	java/util/Date
    //   93: dup
    //   94: aload_2
    //   95: getfield 129	com/google/android/gms/internal/aj:lQ	J
    //   98: invokespecial 132	java/util/Date:<init>	(J)V
    //   101: aload_2
    //   102: getfield 136	com/google/android/gms/internal/aj:lR	I
    //   105: aload 8
    //   107: aload_2
    //   108: getfield 140	com/google/android/gms/internal/aj:lT	Z
    //   111: aload_2
    //   112: getfield 143	com/google/android/gms/internal/aj:lU	I
    //   115: invokespecial 146	com/google/android/gms/internal/bx:<init>	(Ljava/util/Date;ILjava/util/Set;ZI)V
    //   118: astore 8
    //   120: aload_2
    //   121: getfield 150	com/google/android/gms/internal/aj:ma	Landroid/os/Bundle;
    //   124: ifnull +20 -> 144
    //   127: aload_2
    //   128: getfield 150	com/google/android/gms/internal/aj:ma	Landroid/os/Bundle;
    //   131: aload 6
    //   133: invokevirtual 100	java/lang/Object:getClass	()Ljava/lang/Class;
    //   136: invokevirtual 153	java/lang/Class:getName	()Ljava/lang/String;
    //   139: invokevirtual 157	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   142: astore 7
    //   144: aload 6
    //   146: aload_1
    //   147: invokestatic 163	com/google/android/gms/dynamic/e:e	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   150: checkcast 165	android/content/Context
    //   153: new 167	com/google/android/gms/internal/bz
    //   156: dup
    //   157: aload 5
    //   159: invokespecial 170	com/google/android/gms/internal/bz:<init>	(Lcom/google/android/gms/internal/bw;)V
    //   162: aload_0
    //   163: aload_3
    //   164: aload_2
    //   165: getfield 143	com/google/android/gms/internal/aj:lU	I
    //   168: aload 4
    //   170: invokespecial 172	com/google/android/gms/internal/by:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
    //   173: aload 8
    //   175: aload 7
    //   177: invokeinterface 176 6 0
    //   182: return
    //   183: aconst_null
    //   184: astore 8
    //   186: goto -100 -> 86
    //   189: astore 6
    //   191: ldc 178
    //   193: aload 6
    //   195: invokestatic 75	com/google/android/gms/internal/ev:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: new 17	android/os/RemoteException
    //   201: dup
    //   202: invokespecial 76	android/os/RemoteException:<init>	()V
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	by
    //   0	206	1	paramd	d
    //   0	206	2	paramaj	aj
    //   0	206	3	paramString1	String
    //   0	206	4	paramString2	String
    //   0	206	5	parambw	bw
    //   64	81	6	localMediationInterstitialAdapter	MediationInterstitialAdapter
    //   189	5	6	localThrowable	Throwable
    //   1	175	7	localBundle	Bundle
    //   84	101	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	182	189	java/lang/Throwable
  }
  
  public void a(d paramd, am paramam, aj paramaj, String paramString, bw parambw)
    throws RemoteException
  {
    a(paramd, paramam, paramaj, paramString, null, parambw);
  }
  
  /* Error */
  public void a(d paramd, am paramam, aj paramaj, String paramString1, String paramString2, bw parambw)
    throws RemoteException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   7: instanceof 184
    //   10: ifne +42 -> 52
    //   13: new 21	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   20: ldc 186
    //   22: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   29: invokevirtual 100	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: invokevirtual 105	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   35: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 38	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   44: new 17	android/os/RemoteException
    //   47: dup
    //   48: invokespecial 76	android/os/RemoteException:<init>	()V
    //   51: athrow
    //   52: ldc 188
    //   54: invokestatic 110	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 13	com/google/android/gms/internal/by:nQ	Lcom/google/android/gms/ads/mediation/MediationAdapter;
    //   61: checkcast 184	com/google/android/gms/ads/mediation/MediationBannerAdapter
    //   64: astore 7
    //   66: aload_3
    //   67: getfield 116	com/google/android/gms/internal/aj:lS	Ljava/util/List;
    //   70: ifnull +129 -> 199
    //   73: new 118	java/util/HashSet
    //   76: dup
    //   77: aload_3
    //   78: getfield 116	com/google/android/gms/internal/aj:lS	Ljava/util/List;
    //   81: invokespecial 121	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   84: astore 9
    //   86: new 123	com/google/android/gms/internal/bx
    //   89: dup
    //   90: new 125	java/util/Date
    //   93: dup
    //   94: aload_3
    //   95: getfield 129	com/google/android/gms/internal/aj:lQ	J
    //   98: invokespecial 132	java/util/Date:<init>	(J)V
    //   101: aload_3
    //   102: getfield 136	com/google/android/gms/internal/aj:lR	I
    //   105: aload 9
    //   107: aload_3
    //   108: getfield 140	com/google/android/gms/internal/aj:lT	Z
    //   111: aload_3
    //   112: getfield 143	com/google/android/gms/internal/aj:lU	I
    //   115: invokespecial 146	com/google/android/gms/internal/bx:<init>	(Ljava/util/Date;ILjava/util/Set;ZI)V
    //   118: astore 9
    //   120: aload_3
    //   121: getfield 150	com/google/android/gms/internal/aj:ma	Landroid/os/Bundle;
    //   124: ifnull +20 -> 144
    //   127: aload_3
    //   128: getfield 150	com/google/android/gms/internal/aj:ma	Landroid/os/Bundle;
    //   131: aload 7
    //   133: invokevirtual 100	java/lang/Object:getClass	()Ljava/lang/Class;
    //   136: invokevirtual 153	java/lang/Class:getName	()Ljava/lang/String;
    //   139: invokevirtual 157	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   142: astore 8
    //   144: aload 7
    //   146: aload_1
    //   147: invokestatic 163	com/google/android/gms/dynamic/e:e	(Lcom/google/android/gms/dynamic/d;)Ljava/lang/Object;
    //   150: checkcast 165	android/content/Context
    //   153: new 167	com/google/android/gms/internal/bz
    //   156: dup
    //   157: aload 6
    //   159: invokespecial 170	com/google/android/gms/internal/bz:<init>	(Lcom/google/android/gms/internal/bw;)V
    //   162: aload_0
    //   163: aload 4
    //   165: aload_3
    //   166: getfield 143	com/google/android/gms/internal/aj:lU	I
    //   169: aload 5
    //   171: invokespecial 172	com/google/android/gms/internal/by:a	(Ljava/lang/String;ILjava/lang/String;)Landroid/os/Bundle;
    //   174: aload_2
    //   175: getfield 193	com/google/android/gms/internal/am:width	I
    //   178: aload_2
    //   179: getfield 196	com/google/android/gms/internal/am:height	I
    //   182: aload_2
    //   183: getfield 200	com/google/android/gms/internal/am:mc	Ljava/lang/String;
    //   186: invokestatic 205	com/google/android/gms/ads/a:a	(IILjava/lang/String;)Lcom/google/android/gms/ads/AdSize;
    //   189: aload 9
    //   191: aload 8
    //   193: invokeinterface 209 7 0
    //   198: return
    //   199: aconst_null
    //   200: astore 9
    //   202: goto -116 -> 86
    //   205: astore 7
    //   207: ldc 211
    //   209: aload 7
    //   211: invokestatic 75	com/google/android/gms/internal/ev:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: new 17	android/os/RemoteException
    //   217: dup
    //   218: invokespecial 76	android/os/RemoteException:<init>	()V
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	by
    //   0	222	1	paramd	d
    //   0	222	2	paramam	am
    //   0	222	3	paramaj	aj
    //   0	222	4	paramString1	String
    //   0	222	5	paramString2	String
    //   0	222	6	parambw	bw
    //   64	81	7	localMediationBannerAdapter	MediationBannerAdapter
    //   205	5	7	localThrowable	Throwable
    //   1	191	8	localBundle	Bundle
    //   84	117	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	198	205	java/lang/Throwable
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.nQ.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public d getView()
    throws RemoteException
  {
    if (!(this.nQ instanceof MediationBannerAdapter))
    {
      ev.D("MediationAdapter is not a MediationBannerAdapter: " + this.nQ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      d locald = e.h(((MediationBannerAdapter)this.nQ).getBannerView());
      return locald;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      this.nQ.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      this.nQ.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.nQ instanceof MediationInterstitialAdapter))
    {
      ev.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nQ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ev.z("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nQ).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.c("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.by
 * JD-Core Version:    0.7.0.1
 */