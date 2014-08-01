package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class ho
  extends g<hk>
{
  private static final ho GI = new ho();
  
  private ho()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View b(Context paramContext, int paramInt1, int paramInt2)
    throws g.a
  {
    return GI.c(paramContext, paramInt1, paramInt2);
  }
  
  private View c(Context paramContext, int paramInt1, int paramInt2)
    throws g.a
  {
    try
    {
      Object localObject = e.h(paramContext);
      localObject = (View)e.e(((hk)D(paramContext)).a((d)localObject, paramInt1, paramInt2));
      return localObject;
    }
    catch (Exception localException)
    {
      throw new g.a("Could not get button with size " + paramInt1 + " and color " + paramInt2, localException);
    }
  }
  
  public hk N(IBinder paramIBinder)
  {
    return hk.a.M(paramIBinder);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ho
 * JD-Core Version:    0.7.0.1
 */