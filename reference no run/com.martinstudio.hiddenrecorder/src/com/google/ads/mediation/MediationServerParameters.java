package com.google.ads.mediation;

import com.google.android.gms.internal.ev;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public abstract class MediationServerParameters
{
  protected void a() {}
  
  public void load(Map<String, String> paramMap)
    throws MediationServerParameters.MappingException
  {
    Object localObject1 = new HashMap();
    for (Field localField : getClass().getFields())
    {
      localObject3 = (Parameter)localField.getAnnotation(Parameter.class);
      if (localObject3 != null) {
        ((Map)localObject1).put(((Parameter)localObject3).name(), localField);
      }
    }
    if (((Map)localObject1).isEmpty()) {
      ev.D("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Map.Entry)localIterator.next();
      localObject3 = (Field)((Map)localObject1).remove(((Map.Entry)localObject2).getKey());
      if (localObject3 != null) {
        try
        {
          ((Field)localObject3).set(this, ((Map.Entry)localObject2).getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          ev.D("Server option \"" + (String)((Map.Entry)localObject2).getKey() + "\" could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          ev.D("Server option \"" + (String)((Map.Entry)localObject2).getKey() + "\" could not be set: Bad Type");
        }
      } else {
        ev.z("Unexpected server option: " + (String)((Map.Entry)localObject2).getKey() + " = \"" + (String)((Map.Entry)localObject2).getValue() + "\"");
      }
    }
    Object localObject2 = new StringBuilder();
    Object localObject3 = ((Map)localObject1).values().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Field)((Iterator)localObject3).next();
      if (((Parameter)((Field)localObject1).getAnnotation(Parameter.class)).required())
      {
        ev.D("Required server option missing: " + ((Parameter)((Field)localObject1).getAnnotation(Parameter.class)).name());
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(", ");
        }
        ((StringBuilder)localObject2).append(((Parameter)((Field)localObject1).getAnnotation(Parameter.class)).name());
      }
    }
    if (((StringBuilder)localObject2).length() > 0) {
      throw new MappingException("Required server option(s) missing: " + ((StringBuilder)localObject2).toString());
    }
    a();
  }
  
  public static final class MappingException
    extends Exception
  {
    public MappingException(String paramString)
    {
      super();
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  protected static @interface Parameter
  {
    String name();
    
    boolean required() default true;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationServerParameters
 * JD-Core Version:    0.7.0.1
 */