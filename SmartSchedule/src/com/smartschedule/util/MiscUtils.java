package com.smartschedule.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;

public class MiscUtils {

      public static Typeface CreateTypefaceFromRawResource(Context paramContext, int paramInt)
      {
        Object localObject2 = paramContext.getResources();
        Object localObject1 = ((Resources)localObject2).getResourceEntryName(paramInt);
        File localFile = new File(paramContext.getCacheDir(), (String)localObject1);
        try
        {
          if (!localFile.exists())
          {
            localFile.createNewFile();
            localObject1 = new FileOutputStream(localFile);
            InputStream localInputStream = ((Resources)localObject2).openRawResource(paramInt);
            localObject2 = new byte[16384];
            for (;;)
            {
              int i = localInputStream.read((byte[])localObject2);
              if (i == -1) {
                break;
              }
              ((FileOutputStream)localObject1).write((byte[])localObject2, 0, i);
            }
            localInputStream.close();
            ((FileOutputStream)localObject1).flush();
            ((FileOutputStream)localObject1).close();
          }
          localObject1 = Typeface.createFromFile(localFile);
          localObject1 = localObject1;
        }
        catch (Exception localException)
        {
          localObject1 = null;
        }
        return (Typeface) localObject1;
      }
}
