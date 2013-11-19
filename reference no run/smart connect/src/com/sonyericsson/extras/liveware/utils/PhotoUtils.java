package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoUtils
{
  private static final String NEW_PHOTO_DIR_PATH = Environment.getExternalStorageDirectory() + "/DCIM/Camera";
  private static final Point PHOTO_ASPECT = new Point(289, 172);
  private static final String PHOTO_DATE_FORMAT = "yyyyMMdd_HHmmss";
  private static final Point PHOTO_SIZE = new Point(578, 344);
  
  public static void addGalleryIntentExtras(Intent paramIntent, Uri paramUri)
  {
    paramIntent.putExtra("crop", "true");
    paramIntent.putExtra("scale", true);
    paramIntent.putExtra("scaleUpIfNeeded", true);
    paramIntent.putExtra("aspectX", PHOTO_ASPECT.x);
    paramIntent.putExtra("aspectY", PHOTO_ASPECT.y);
    paramIntent.putExtra("outputX", PHOTO_SIZE.x);
    paramIntent.putExtra("outputY", PHOTO_SIZE.y);
    paramIntent.putExtra("output", paramUri);
  }
  
  public static String generateFileName()
  {
    Date localDate = new Date(System.currentTimeMillis());
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
    return "EventImage-IMG_" + localSimpleDateFormat.format(localDate) + ".jpg";
  }
  
  public static Intent getCropImageIntent(String paramString1, String paramString2)
  {
    Uri localUri1 = Uri.fromFile(new File(paramString1));
    Uri localUri2 = Uri.fromFile(new File(paramString2));
    Intent localIntent = new Intent("com.android.camera.action.CROP");
    localIntent.setDataAndType(localUri1, "image/*");
    addGalleryIntentExtras(localIntent, localUri2);
    return localIntent;
  }
  
  public static Intent getPhotoPickIntent(Context paramContext, String paramString)
  {
    Uri localUri = Uri.fromFile(new File(pathForCroppedPhoto(paramContext, paramString)));
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT", null);
    localIntent.setType("image/*");
    addGalleryIntentExtras(localIntent, localUri);
    return localIntent;
  }
  
  public static Intent getTakePhotoIntent(String paramString)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE", null);
    localIntent.putExtra("output", Uri.fromFile(new File(pathForNewCameraPhoto(paramString))));
    return localIntent;
  }
  
  public static String pathForCroppedPhoto(Context paramContext, String paramString)
  {
    File localFile = new File(paramContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/events");
    if ((!localFile.exists()) && (!localFile.mkdirs()) && (Dbg.w())) {
      Dbg.w("Could not create directory: " + localFile.toString());
    }
    return new File(localFile, paramString).getAbsolutePath();
  }
  
  public static String pathForNewCameraPhoto(String paramString)
  {
    File localFile = new File(NEW_PHOTO_DIR_PATH);
    if ((!localFile.exists()) && (!localFile.mkdirs()) && (Dbg.w())) {
      Dbg.w("Could not create directory: " + localFile.toString());
    }
    return new File(localFile, paramString).getAbsolutePath();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */