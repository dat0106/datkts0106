package com.google.ads.mediation;

import com.google.ads.util.b;
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

public abstract class MediationServerParameters
{
  protected void a() {}
  
  public void load(Map<String, String> paramMap)
    throws MediationServerParameters.MappingException
  {
    Object localObject1 = new HashMap();
    for (localObject3 : getClass().getFields())
    {
      localObject4 = (Parameter)((Field)localObject3).getAnnotation(Parameter.class);
      if (localObject4 != null) {
        ((Map)localObject1).put(((Parameter)localObject4).name(), localObject3);
      }
    }
    if (((Map)localObject1).isEmpty()) {
      b.e("No server options fields detected.  To suppress this message either add a field with the @Parameter annotation, or override the load() method");
    }
    Object localObject4 = paramMap.entrySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      ??? = (Map.Entry)((Iterator)localObject4).next();
      localObject3 = (Field)((Map)localObject1).remove(((Map.Entry)???).getKey());
      if (localObject3 != null) {
        try
        {
          ((Field)localObject3).set(this, ((Map.Entry)???).getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          b.b("Server Option '" + (String)((Map.Entry)???).getKey() + "' could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          b.b("Server Option '" + (String)((Map.Entry)???).getKey() + "' could not be set: Bad Type");
        }
      } else {
        b.e("Unexpected Server Option: " + (String)((Map.Entry)???).getKey() + " = '" + (String)((Map.Entry)???).getValue() + "'");
      }
    }
    Object localObject3 = null;
    localObject1 = ((Map)localObject1).values().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      ??? = (Field)((Iterator)localObject1).next();
      if (!((Parameter)((Field)???).getAnnotation(Parameter.class)).required()) {
        break label494;
      }
      b.b("Required Server Option missing: " + ((Parameter)((Field)???).getAnnotation(Parameter.class)).name());
      localObject4 = new StringBuilder();
      if (localObject3 == null) {
        localObject3 = "";
      }
    }
    label397:
    label494:
    for (??? = (String)localObject3 + ((Parameter)((Field)???).getAnnotation(Parameter.class)).name();; ??? = localObject3)
    {
      localObject3 = ???;
      break;
      localObject3 = (String)localObject3 + ", ";
      break label397;
      if (localObject3 != null) {
        throw new MappingException("Required Server Option(s) missing: " + (String)localObject3);
      }
      a();
      return;
    }
  }
  
  public static class MappingException
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


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationServerParameters
 * JD-Core Version:    0.7.0.1
 */