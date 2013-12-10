package com.actionbarsherlock.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.integer;

public final class ResourcesCompat
{
  public static boolean getResources_getBoolean(Context paramContext, int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT < 13)
    {
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.density;
      float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.density;
      if (f1 >= f2) {
        f2 = f2;
      } else {
        f2 = f1;
      }
      if (paramInt != R.bool.abs__action_bar_embed_tabs)
      {
        if (paramInt != R.bool.abs__split_action_bar_is_narrow)
        {
          if (paramInt != R.bool.abs__action_bar_expanded_action_views_exclusive)
          {
            if (paramInt != R.bool.abs__config_allowActionMenuItemTextWithIcon) {
              throw new IllegalArgumentException("Unknown boolean resource ID " + paramInt);
            }
            if (f1 < 480.0F) {
              bool = false;
            }
          }
          else if (f2 >= 600.0F)
          {
            bool = false;
          }
        }
        else if (f1 >= 480.0F) {
          bool = false;
        }
      }
      else if (!paramContext.getResources().getBoolean(R.bool.abs__action_bar_embed_tabs)) {
        bool = false;
      }
    }
    else
    {
      bool = paramContext.getResources().getBoolean(paramInt);
    }
    return bool;
  }
  
  public static int getResources_getInteger(Context paramContext, int paramInt)
  {
    int i;
    if (Build.VERSION.SDK_INT < 13)
    {
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      float f = localDisplayMetrics.widthPixels / localDisplayMetrics.density;
      if (paramInt != R.integer.abs__max_action_buttons) {
        throw new IllegalArgumentException("Unknown integer resource ID " + paramInt);
      }
      if (f < 600.0F)
      {
        if (f < 500.0F)
        {
          if (f < 360.0F) {
            i = 2;
          } else {
            i = 3;
          }
        }
        else {
          i = 4;
        }
      }
      else {
        i = 5;
      }
    }
    else
    {
      i = paramContext.getResources().getInteger(paramInt);
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.ResourcesCompat
 * JD-Core Version:    0.7.0.1
 */