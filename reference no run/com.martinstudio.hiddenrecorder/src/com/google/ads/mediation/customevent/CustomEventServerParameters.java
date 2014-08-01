package com.google.ads.mediation.customevent;

import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.Parameter;

public final class CustomEventServerParameters
  extends MediationServerParameters
{
  @MediationServerParameters.Parameter(name="class_name", required=true)
  public String className;
  @MediationServerParameters.Parameter(name="label", required=true)
  public String label;
  @MediationServerParameters.Parameter(name="parameter", required=false)
  public String parameter = null;
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.customevent.CustomEventServerParameters
 * JD-Core Version:    0.7.0.1
 */