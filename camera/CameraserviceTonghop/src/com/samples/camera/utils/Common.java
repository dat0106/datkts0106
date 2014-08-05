package com.samples.camera.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class Common
{
  public static Point getScreenSize(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    return localPoint;
  }
}

