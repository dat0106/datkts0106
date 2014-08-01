package com.google.android.gms.internal;

import android.content.Context;
import org.json.JSONObject;

public class ag
  implements af
{
  private final ey lL;
  
  public ag(Context paramContext, ew paramew)
  {
    this.lL = ey.a(paramContext, new am(), false, false, null, paramew);
  }
  
  public void a(final af.a parama)
  {
    this.lL.bW().a(new ez.a()
    {
      public void a(ey paramAnonymousey)
      {
        parama.az();
      }
    });
  }
  
  public void a(String paramString, bd parambd)
  {
    this.lL.bW().a(paramString, parambd);
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.lL.a(paramString, paramJSONObject);
  }
  
  public void d(String paramString)
  {
    this.lL.loadUrl(paramString);
  }
  
  public void e(String paramString)
  {
    this.lL.bW().a(paramString, null);
  }
  
  public void pause()
  {
    ep.a(this.lL);
  }
  
  public void resume()
  {
    ep.b(this.lL);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ag
 * JD-Core Version:    0.7.0.1
 */