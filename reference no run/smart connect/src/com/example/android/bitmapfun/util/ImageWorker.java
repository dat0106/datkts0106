package com.example.android.bitmapfun.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.lang.ref.WeakReference;

public abstract class ImageWorker
{
  private static final int FADE_IN_TIME = 200;
  private static final String TAG = "ImageWorker";
  protected Context mContext;
  private boolean mExitTasksEarly = false;
  private boolean mFadeInBitmap = true;
  private ImageCache mImageCache;
  protected ImageWorkerAdapter mImageWorkerAdapter;
  private Bitmap mLoadingBitmap;
  
  protected ImageWorker(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static boolean cancelPotentialWork(Object paramObject, ImageView paramImageView)
  {
    boolean bool = true;
    BitmapWorkerTask localBitmapWorkerTask = getBitmapWorkerTask(paramImageView);
    if (localBitmapWorkerTask != null)
    {
      Object localObject = localBitmapWorkerTask.data;
      if ((localObject != null) && (localObject.equals(paramObject)))
      {
        bool = false;
      }
      else
      {
        localBitmapWorkerTask.cancel(bool);
        if (Dbg.d()) {
          Log.d("ImageWorker", "cancelPotentialWork - cancelled work for " + paramObject);
        }
      }
    }
    return bool;
  }
  
  public static void cancelWork(ImageView paramImageView)
  {
    Object localObject = getBitmapWorkerTask(paramImageView);
    if (localObject != null)
    {
      ((BitmapWorkerTask)localObject).cancel(true);
      if (Dbg.d())
      {
        localObject = ((BitmapWorkerTask)localObject).data;
        Log.d("ImageWorker", "cancelWork - cancelled work for " + localObject);
      }
    }
  }
  
  public static BitmapWorkerTask getBitmapWorkerTask(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      localObject = paramImageView.getDrawable();
      if ((localObject instanceof AsyncDrawable)) {}
    }
    else
    {
      return null;
    }
    Object localObject = ((AsyncDrawable)localObject).getBitmapWorkerTask();
    return localObject;
  }
  
  private void setImageBitmap(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (!this.mFadeInBitmap)
    {
      paramImageView.setImageBitmap(paramBitmap);
    }
    else
    {
      Object localObject = new Drawable[2];
      localObject[0] = new ColorDrawable(17170445);
      localObject[1] = new BitmapDrawable(this.mContext.getResources(), paramBitmap);
      localObject = new TransitionDrawable((Drawable[])localObject);
      paramImageView.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), this.mLoadingBitmap));
      paramImageView.setImageDrawable((Drawable)localObject);
      ((TransitionDrawable)localObject).startTransition(200);
    }
  }
  
  public static String viewTagFromPictureName(String paramString)
  {
    return "picture_" + paramString;
  }
  
  public ImageWorkerAdapter getAdapter()
  {
    return this.mImageWorkerAdapter;
  }
  
  public ImageCache getImageCache()
  {
    return this.mImageCache;
  }
  
  public void loadImage(int paramInt, ImageView paramImageView)
  {
    if (this.mImageWorkerAdapter == null) {
      throw new NullPointerException("Data not set, must call setAdapter() first.");
    }
    loadImage(this.mImageWorkerAdapter.getItem(paramInt), paramImageView);
  }
  
  public void loadImage(Object paramObject, ImageView paramImageView)
  {
    Object localObject = null;
    if (this.mImageCache != null) {
      localObject = this.mImageCache.getBitmapFromMemCache(String.valueOf(paramObject));
    }
    if (localObject == null)
    {
      if (cancelPotentialWork(paramObject, paramImageView))
      {
        localObject = new BitmapWorkerTask(paramImageView);
        paramImageView.setImageDrawable(new AsyncDrawable(this.mContext.getResources(), this.mLoadingBitmap, (BitmapWorkerTask)localObject));
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramObject;
        ((BitmapWorkerTask)localObject).execute(arrayOfObject);
      }
    }
    else {
      paramImageView.setImageBitmap((Bitmap)localObject);
    }
  }
  
  protected abstract Bitmap processBitmap(Object paramObject);
  
  public void setAdapter(ImageWorkerAdapter paramImageWorkerAdapter)
  {
    this.mImageWorkerAdapter = paramImageWorkerAdapter;
  }
  
  public void setExitTasksEarly(boolean paramBoolean)
  {
    this.mExitTasksEarly = paramBoolean;
  }
  
  public void setImageCache(ImageCache paramImageCache)
  {
    this.mImageCache = paramImageCache;
  }
  
  public void setImageFadeIn(boolean paramBoolean)
  {
    this.mFadeInBitmap = paramBoolean;
  }
  
  public void setLoadingImage(int paramInt)
  {
    this.mLoadingBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
  }
  
  public void setLoadingImage(Bitmap paramBitmap)
  {
    this.mLoadingBitmap = paramBitmap;
  }
  
  private static class AsyncDrawable
    extends BitmapDrawable
  {
    private final WeakReference<ImageWorker.BitmapWorkerTask> bitmapWorkerTaskReference;
    
    public AsyncDrawable(Resources paramResources, Bitmap paramBitmap, ImageWorker.BitmapWorkerTask paramBitmapWorkerTask)
    {
      super(paramBitmap);
      this.bitmapWorkerTaskReference = new WeakReference(paramBitmapWorkerTask);
    }
    
    public ImageWorker.BitmapWorkerTask getBitmapWorkerTask()
    {
      return (ImageWorker.BitmapWorkerTask)this.bitmapWorkerTaskReference.get();
    }
  }
  
  private class BitmapWorkerTask
    extends AsyncTask<Object, Void, Bitmap>
  {
    private Object data;
    private final WeakReference<ImageView> imageViewReference;
    
    public BitmapWorkerTask(ImageView paramImageView)
    {
      this.imageViewReference = new WeakReference(paramImageView);
    }
    
    private ImageView getAttachedImageView()
    {
      ImageView localImageView = (ImageView)this.imageViewReference.get();
      if (this != ImageWorker.getBitmapWorkerTask(localImageView)) {
        localImageView = null;
      }
      return localImageView;
    }
    
    protected Bitmap doInBackground(Object... paramVarArgs)
    {
      this.data = paramVarArgs[0];
      String str = String.valueOf(this.data);
      Bitmap localBitmap = null;
      if ((0 == 0) && (!isCancelled()) && (getAttachedImageView() != null) && (!ImageWorker.this.mExitTasksEarly)) {
        localBitmap = ImageWorker.this.processBitmap(paramVarArgs[0]);
      }
      if ((localBitmap != null) && (ImageWorker.this.mImageCache != null)) {
        ImageWorker.this.mImageCache.addBitmapToCache(str, localBitmap);
      }
      return localBitmap;
    }
    
    protected void onPostExecute(Bitmap paramBitmap)
    {
      if ((isCancelled()) || (ImageWorker.this.mExitTasksEarly)) {
        paramBitmap = null;
      }
      ImageView localImageView = getAttachedImageView();
      if (localImageView != null)
      {
        ImageWorker.this.setImageBitmap(localImageView, paramBitmap);
        if (paramBitmap != null) {
          localImageView.setTag(ImageWorker.viewTagFromPictureName(String.valueOf(this.data)));
        }
      }
    }
  }
  
  public static abstract class ImageWorkerAdapter
  {
    public abstract Object getItem(int paramInt);
    
    public abstract int getSize();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.example.android.bitmapfun.util.ImageWorker
 * JD-Core Version:    0.7.0.1
 */