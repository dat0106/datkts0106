package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.gx.a;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hl;
import java.lang.ref.WeakReference;

public abstract class a
{
  final a Fj;
  protected int Fk = 0;
  protected int Fl = 0;
  private boolean Fm = true;
  private boolean Fn = false;
  protected int Fo;
  
  public a(Uri paramUri, int paramInt)
  {
    this.Fj = new a(paramUri);
    this.Fl = paramInt;
  }
  
  private Drawable a(Context paramContext, gx paramgx, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    Drawable localDrawable;
    if (this.Fo <= 0)
    {
      localDrawable = localResources.getDrawable(paramInt);
    }
    else
    {
      gx.a locala = new gx.a(paramInt, this.Fo);
      localDrawable = (Drawable)paramgx.get(locala);
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        if ((0x1 & this.Fo) != 0) {
          localDrawable = a(localResources, localDrawable);
        }
        paramgx.put(locala, localDrawable);
      }
    }
    return localDrawable;
  }
  
  protected Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return gv.a(paramResources, paramDrawable);
  }
  
  protected gu a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 == null) {
      paramDrawable1 = null;
    } else if ((paramDrawable1 instanceof gu)) {
      paramDrawable1 = ((gu)paramDrawable1).fb();
    }
    return new gu(paramDrawable1, paramDrawable2);
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    gy.c(paramBitmap);
    if ((0x1 & this.Fo) != 0) {
      paramBitmap = gv.a(paramBitmap);
    }
    a(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }
  
  void a(Context paramContext, gx paramgx)
  {
    Drawable localDrawable = null;
    if (this.Fk != 0) {
      localDrawable = a(paramContext, paramgx, this.Fk);
    }
    a(localDrawable, false, true, false);
  }
  
  void a(Context paramContext, gx paramgx, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.Fl != 0) {
      localDrawable = a(paramContext, paramgx, this.Fl);
    }
    a(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public void aj(int paramInt)
  {
    this.Fl = paramInt;
  }
  
  protected boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if ((!this.Fm) || (paramBoolean2) || ((paramBoolean1) && (!this.Fn))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  static final class a
  {
    public final Uri uri;
    
    public a(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject instanceof a))
      {
        if (this != paramObject) {
          bool = hl.equal(((a)paramObject).uri, this.uri);
        } else {
          bool = true;
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.uri;
      return hl.hashCode(arrayOfObject);
    }
  }
  
  public static final class c
    extends a
  {
    private WeakReference<ImageManager.OnImageLoadedListener> Fq;
    
    public c(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      gy.c(paramOnImageLoadedListener);
      this.Fq = new WeakReference(paramOnImageLoadedListener);
    }
    
    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.Fq.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.Fj.uri, paramDrawable, paramBoolean3);
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      int i = 0;
      boolean bool;
      if ((paramObject instanceof c)) {
        if (this != paramObject)
        {
          c localc = (c)paramObject;
          ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)this.Fq.get();
          ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)localc.Fq.get();
          if ((localOnImageLoadedListener1 == null) || (localOnImageLoadedListener2 == null) || (!hl.equal(localOnImageLoadedListener1, localOnImageLoadedListener2)) || (!hl.equal(localc.Fj, this.Fj))) {
            bool = false;
          } else {
            bool = true;
          }
          bool = bool;
        }
        else
        {
          bool = true;
        }
      }
      return bool;
    }
    
    public int hashCode()
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.Fj;
      return hl.hashCode(arrayOfObject);
    }
  }
  
  public static final class b
    extends a
  {
    private WeakReference<ImageView> Fp;
    
    public b(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      gy.c(paramImageView);
      this.Fp = new WeakReference(paramImageView);
    }
    
    public b(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      gy.c(paramImageView);
      this.Fp = new WeakReference(paramImageView);
    }
    
    private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      int j;
      if ((paramBoolean2) || (paramBoolean3)) {
        j = 0;
      } else {
        j = 1;
      }
      if ((j != 0) && ((paramImageView instanceof gw)))
      {
        int i = ((gw)paramImageView).fd();
        if ((this.Fl != 0) && (i == this.Fl)) {}
      }
      else
      {
        boolean bool = b(paramBoolean1, paramBoolean2);
        Object localObject;
        if (!bool) {
          localObject = paramDrawable;
        } else {
          localObject = a(paramImageView.getDrawable(), paramDrawable);
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        if ((paramImageView instanceof gw))
        {
          gw localgw = (gw)paramImageView;
          Uri localUri;
          if (!paramBoolean3) {
            localUri = null;
          } else {
            localUri = this.Fj.uri;
          }
          localgw.f(localUri);
          if (j == 0) {
            j = 0;
          } else {
            j = this.Fl;
          }
          localgw.al(j);
        }
        if (bool) {
          ((gu)localObject).startTransition(250);
        }
      }
    }
    
    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.Fp.get();
      if (localImageView != null) {
        a(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      int i = 0;
      boolean bool;
      if ((paramObject instanceof b)) {
        if (this != paramObject)
        {
          Object localObject = (b)paramObject;
          ImageView localImageView = (ImageView)this.Fp.get();
          localObject = (ImageView)((b)localObject).Fp.get();
          if ((localObject == null) || (localImageView == null) || (!hl.equal(localObject, localImageView))) {
            bool = false;
          } else {
            bool = true;
          }
          bool = bool;
        }
        else
        {
          bool = true;
        }
      }
      return bool;
    }
    
    public int hashCode()
    {
      return 0;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.a
 * JD-Core Version:    0.7.0.1
 */