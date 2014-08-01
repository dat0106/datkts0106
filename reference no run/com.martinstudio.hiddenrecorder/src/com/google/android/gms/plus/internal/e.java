package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.b;
import com.google.android.gms.internal.hc.c;
import com.google.android.gms.internal.hc.d;
import com.google.android.gms.internal.hc.e;
import com.google.android.gms.internal.hc.g;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.if;
import com.google.android.gms.internal.kq;
import com.google.android.gms.internal.kt;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class e
  extends hc<d>
{
  private Person abG;
  private final h abH;
  
  public e(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramh.jU());
    this.abH = paramh;
  }
  
  @Deprecated
  public e(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, h paramh)
  {
    this(paramContext, paramContext.getMainLooper(), new hc.c(paramConnectionCallbacks), new hc.g(paramOnConnectionFailedListener), paramh);
  }
  
  public hh a(a.d<People.LoadPeopleResult> paramd, int paramInt, String paramString)
  {
    ci();
    localObject = new e(paramd);
    try
    {
      localObject = ((d)fo()).a((b)localObject, 1, paramInt, -1, paramString);
      localObject = localObject;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ((e)localObject).a(DataHolder.af(8), null);
        localObject = null;
      }
    }
    return localObject;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null) && (paramBundle.containsKey("loaded_person"))) {
      this.abG = kt.i(paramBundle.getByteArray("loaded_person"));
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(a.d<Moments.LoadMomentsResult> paramd, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    ci();
    b localb;
    if (paramd != null) {
      localb = new b(paramd);
    }
    try
    {
      for (;;)
      {
        ((d)fo()).a(localb, paramInt, paramString1, paramUri, paramString2, paramString3);
        return;
        localb = null;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localb.a(DataHolder.af(8), null, null);
      }
    }
  }
  
  public void a(a.d<Status> paramd, Moment paramMoment)
  {
    ci();
    a locala;
    if (paramd != null) {
      locala = new a(paramd);
    }
    try
    {
      for (;;)
      {
        if localif = if.a((kq)paramMoment);
        ((d)fo()).a(locala, localif);
        return;
        locala = null;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        if (locala == null) {
          throw new IllegalStateException(localRemoteException);
        }
        locala.am(new Status(8, null, null));
      }
    }
  }
  
  public void a(a.d<People.LoadPeopleResult> paramd, Collection<String> paramCollection)
  {
    ci();
    e locale = new e(paramd);
    try
    {
      ((d)fo()).a(locale, new ArrayList(paramCollection));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        locale.a(DataHolder.af(8), null);
      }
    }
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    Bundle localBundle = this.abH.kc();
    localBundle.putStringArray("request_visible_actions", this.abH.jV());
    paramhj.a(parame, 5077000, this.abH.jY(), this.abH.jX(), fn(), this.abH.getAccountName(), localBundle);
  }
  
  protected d bn(IBinder paramIBinder)
  {
    return d.a.bm(paramIBinder);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.plus.service.START";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.plus.internal.IPlusService";
  }
  
  public boolean by(String paramString)
  {
    return Arrays.asList(fn()).contains(paramString);
  }
  
  public void clearDefaultAccount()
  {
    ci();
    try
    {
      this.abG = null;
      ((d)fo()).clearDefaultAccount();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void d(a.d<People.LoadPeopleResult> paramd, String[] paramArrayOfString)
  {
    a(paramd, Arrays.asList(paramArrayOfString));
  }
  
  public String getAccountName()
  {
    ci();
    try
    {
      String str = ((d)fo()).getAccountName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public Person getCurrentPerson()
  {
    ci();
    return this.abG;
  }
  
  public void k(a.d<Moments.LoadMomentsResult> paramd)
  {
    a(paramd, 20, null, null, null, "me");
  }
  
  public void l(a.d<People.LoadPeopleResult> paramd)
  {
    ci();
    e locale = new e(paramd);
    try
    {
      ((d)fo()).a(locale, 2, 1, -1, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        locale.a(DataHolder.af(8), null);
      }
    }
  }
  
  public void m(a.d<Status> paramd)
  {
    ci();
    clearDefaultAccount();
    g localg = new g(paramd);
    try
    {
      ((d)fo()).b(localg);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localg.h(8, null);
      }
    }
  }
  
  public hh r(a.d<People.LoadPeopleResult> paramd, String paramString)
  {
    return a(paramd, 0, paramString);
  }
  
  public void removeMoment(String paramString)
  {
    ci();
    try
    {
      ((d)fo()).removeMoment(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  final class g
    extends a
  {
    private final a.d<Status> abI;
    
    public g()
    {
      Object localObject;
      this.abI = localObject;
    }
    
    public void h(int paramInt, Bundle paramBundle)
    {
      if (paramBundle == null) {
        localObject = null;
      } else {
        localObject = (PendingIntent)paramBundle.getParcelable("pendingIntent");
      }
      Object localObject = new Status(paramInt, null, (PendingIntent)localObject);
      e.this.a(new e.h(e.this, this.abI, (Status)localObject));
    }
  }
  
  final class a
    extends a
  {
    private final a.d<Status> abI;
    
    public a()
    {
      Object localObject;
      this.abI = localObject;
    }
    
    public void am(Status paramStatus)
    {
      e.this.a(new e.d(e.this, this.abI, paramStatus));
    }
  }
  
  final class e
    extends a
  {
    private final a.d<People.LoadPeopleResult> abI;
    
    public e()
    {
      Object localObject;
      this.abI = localObject;
    }
    
    public void a(DataHolder paramDataHolder, String paramString)
    {
      if (paramDataHolder.eP() == null) {
        localObject = null;
      } else {
        localObject = (PendingIntent)paramDataHolder.eP().getParcelable("pendingIntent");
      }
      Object localObject = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
      DataHolder localDataHolder;
      if ((((Status)localObject).isSuccess()) || (paramDataHolder == null))
      {
        localDataHolder = paramDataHolder;
      }
      else
      {
        if (!paramDataHolder.isClosed()) {
          paramDataHolder.close();
        }
        localDataHolder = null;
      }
      e.this.a(new e.f(e.this, this.abI, (Status)localObject, localDataHolder, paramString));
    }
  }
  
  final class b
    extends a
  {
    private final a.d<Moments.LoadMomentsResult> abI;
    
    public b()
    {
      Object localObject;
      this.abI = localObject;
    }
    
    public void a(DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      Object localObject;
      if (paramDataHolder.eP() == null) {
        localObject = null;
      } else {
        localObject = (PendingIntent)paramDataHolder.eP().getParcelable("pendingIntent");
      }
      Status localStatus = new Status(paramDataHolder.getStatusCode(), null, (PendingIntent)localObject);
      if ((localStatus.isSuccess()) || (paramDataHolder == null))
      {
        localObject = paramDataHolder;
      }
      else
      {
        if (!paramDataHolder.isClosed()) {
          paramDataHolder.close();
        }
        localObject = null;
      }
      e.this.a(new e.c(e.this, this.abI, localStatus, (DataHolder)localObject, paramString1, paramString2));
    }
  }
  
  final class d
    extends hc<d>.b<a.d<Status>>
  {
    private final Status yw;
    
    public d(Status paramStatus)
    {
      super(paramStatus);
      Object localObject;
      this.yw = localObject;
    }
    
    protected void fp() {}
    
    protected void n(a.d<Status> paramd)
    {
      if (paramd != null) {
        paramd.a(this.yw);
      }
    }
  }
  
  final class h
    extends hc<d>.b<a.d<Status>>
  {
    private final Status yw;
    
    public h(Status paramStatus)
    {
      super(paramStatus);
      Object localObject;
      this.yw = localObject;
    }
    
    protected void fp() {}
    
    protected void n(a.d<Status> paramd)
    {
      e.this.disconnect();
      if (paramd != null) {
        paramd.a(this.yw);
      }
    }
  }
  
  final class f
    extends hc<d>.d<a.d<People.LoadPeopleResult>>
    implements People.LoadPeopleResult
  {
    private final String HP;
    private PersonBuffer abM;
    private final Status yw;
    
    public f(Status paramStatus, DataHolder paramDataHolder, String paramString)
    {
      super(paramStatus, paramString);
      this.yw = paramDataHolder;
      Object localObject;
      this.HP = localObject;
    }
    
    protected void a(a.d<People.LoadPeopleResult> paramd, DataHolder paramDataHolder)
    {
      PersonBuffer localPersonBuffer;
      if (paramDataHolder == null) {
        localPersonBuffer = null;
      } else {
        localPersonBuffer = new PersonBuffer(paramDataHolder);
      }
      this.abM = localPersonBuffer;
      paramd.a(this);
    }
    
    public String getNextPageToken()
    {
      return this.HP;
    }
    
    public PersonBuffer getPersonBuffer()
    {
      return this.abM;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public void release()
    {
      if (this.abM != null) {
        this.abM.close();
      }
    }
  }
  
  final class c
    extends hc<d>.d<a.d<Moments.LoadMomentsResult>>
    implements Moments.LoadMomentsResult
  {
    private final String HP;
    private final String abK;
    private MomentBuffer abL;
    private final Status yw;
    
    public c(Status paramStatus, DataHolder paramDataHolder, String paramString1, String paramString2)
    {
      super(paramStatus, paramString1);
      this.yw = paramDataHolder;
      this.HP = paramString2;
      Object localObject;
      this.abK = localObject;
    }
    
    protected void a(a.d<Moments.LoadMomentsResult> paramd, DataHolder paramDataHolder)
    {
      MomentBuffer localMomentBuffer;
      if (paramDataHolder == null) {
        localMomentBuffer = null;
      } else {
        localMomentBuffer = new MomentBuffer(paramDataHolder);
      }
      this.abL = localMomentBuffer;
      paramd.a(this);
    }
    
    public MomentBuffer getMomentBuffer()
    {
      return this.abL;
    }
    
    public String getNextPageToken()
    {
      return this.HP;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public String getUpdated()
    {
      return this.abK;
    }
    
    public void release()
    {
      if (this.abL != null) {
        this.abL.close();
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.e
 * JD-Core Version:    0.7.0.1
 */