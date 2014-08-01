package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface iw
{
  public static final class a
    extends mb<a>
  {
    public a[] Uv;
    
    public a()
    {
      iL();
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if ((this.Uv != null) && (this.Uv.length > 0)) {}
      for (int i = 0;; i++)
      {
        if (i >= this.Uv.length)
        {
          super.a(paramma);
          return;
        }
        a locala = this.Uv[i];
        if (locala != null) {
          paramma.a(1, locala);
        }
      }
    }
    
    protected int c()
    {
      int i = super.c();
      if ((this.Uv != null) && (this.Uv.length > 0)) {}
      for (int j = 0;; j++)
      {
        if (j >= this.Uv.length) {
          return i;
        }
        a locala = this.Uv[j];
        if (locala != null) {
          i += ma.b(1, locala);
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof a))
        {
          a locala = (a)paramObject;
          if (md.equals(this.Uv, locala.Uv)) {
            if ((this.amU != null) && (!this.amU.isEmpty())) {
              bool = this.amU.equals(locala.amU);
            } else if ((locala.amU == null) || (locala.amU.isEmpty())) {
              bool = true;
            }
          }
        }
      }
      else {
        bool = true;
      }
      return bool;
    }
    
    public int hashCode()
    {
      int j = 31 * (527 + md.hashCode(this.Uv));
      int i;
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      } else {
        i = 0;
      }
      return i + j;
    }
    
    public a iL()
    {
      this.Uv = a.iM();
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public a n(lz paramlz)
      throws IOException
    {
      int i;
      do
      {
        i = paramlz.nw();
        switch (i)
        {
        }
      } while (a(paramlz, i));
      return this;
      int j = mi.b(paramlz, 10);
      if (this.Uv != null) {
        i = this.Uv.length;
      } else {
        i = 0;
      }
      a[] arrayOfa = new a[j + i];
      if (i != 0) {
        System.arraycopy(this.Uv, 0, arrayOfa, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfa.length)
        {
          arrayOfa[i] = new a();
          paramlz.a(arrayOfa[i]);
          this.Uv = arrayOfa;
          break;
        }
        arrayOfa[i] = new a();
        paramlz.a(arrayOfa[i]);
        paramlz.nw();
        i++;
      }
    }
    
    public static final class a
      extends mb<a>
    {
      private static volatile a[] Uw;
      public String Ux;
      public String Uy;
      public int viewId;
      
      public a()
      {
        iN();
      }
      
      public static a[] iM()
      {
        if (Uw == null) {}
        synchronized (md.amX)
        {
          if (Uw == null) {
            Uw = new a[0];
          }
          return Uw;
        }
      }
      
      public void a(ma paramma)
        throws IOException
      {
        if (!this.Ux.equals("")) {
          paramma.b(1, this.Ux);
        }
        if (!this.Uy.equals("")) {
          paramma.b(2, this.Uy);
        }
        if (this.viewId != 0) {
          paramma.p(3, this.viewId);
        }
        super.a(paramma);
      }
      
      protected int c()
      {
        int i = super.c();
        if (!this.Ux.equals("")) {
          i += ma.h(1, this.Ux);
        }
        if (!this.Uy.equals("")) {
          i += ma.h(2, this.Uy);
        }
        if (this.viewId != 0) {
          i += ma.r(3, this.viewId);
        }
        return i;
      }
      
      public boolean equals(Object paramObject)
      {
        boolean bool = false;
        if (paramObject != this)
        {
          if ((paramObject instanceof a))
          {
            a locala = (a)paramObject;
            if (this.Ux != null ? this.Ux.equals(locala.Ux) : locala.Ux == null) {
              if (this.Uy != null ? this.Uy.equals(locala.Uy) : locala.Uy == null) {
                if (this.viewId == locala.viewId) {
                  if ((this.amU != null) && (!this.amU.isEmpty())) {
                    bool = this.amU.equals(locala.amU);
                  } else if ((locala.amU == null) || (locala.amU.isEmpty())) {
                    bool = true;
                  }
                }
              }
            }
          }
        }
        else {
          bool = true;
        }
        return bool;
      }
      
      public int hashCode()
      {
        int i = 0;
        if (this.Ux != null) {
          j = this.Ux.hashCode();
        } else {
          j = 0;
        }
        int j = 31 * (j + 527);
        int k;
        if (this.Uy != null) {
          k = this.Uy.hashCode();
        } else {
          k = 0;
        }
        j = 31 * (31 * (k + j) + this.viewId);
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          i = this.amU.hashCode();
        }
        return j + i;
      }
      
      public a iN()
      {
        this.Ux = "";
        this.Uy = "";
        this.viewId = 0;
        this.amU = null;
        this.amY = -1;
        return this;
      }
      
      public a o(lz paramlz)
        throws IOException
      {
        for (;;)
        {
          int i = paramlz.nw();
          switch (i)
          {
          default: 
            if (a(paramlz, i)) {
              continue;
            }
          case 0: 
            return this;
          case 10: 
            this.Ux = paramlz.readString();
            break;
          case 18: 
            this.Uy = paramlz.readString();
            break;
          }
          this.viewId = paramlz.nz();
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iw
 * JD-Core Version:    0.7.0.1
 */