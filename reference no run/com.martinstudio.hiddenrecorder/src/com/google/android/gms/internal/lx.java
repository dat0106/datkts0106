package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class lx
  extends mb<lx>
{
  public a[] amo;
  
  public lx()
  {
    nq();
  }
  
  public static lx n(byte[] paramArrayOfByte)
    throws me
  {
    return (lx)mf.a(new lx(), paramArrayOfByte);
  }
  
  public void a(ma paramma)
    throws IOException
  {
    if ((this.amo != null) && (this.amo.length > 0)) {}
    for (int i = 0;; i++)
    {
      if (i >= this.amo.length)
      {
        super.a(paramma);
        return;
      }
      a locala = this.amo[i];
      if (locala != null) {
        paramma.a(1, locala);
      }
    }
  }
  
  protected int c()
  {
    int j = super.c();
    if ((this.amo != null) && (this.amo.length > 0)) {}
    for (int i = 0;; i++)
    {
      if (i >= this.amo.length) {
        return j;
      }
      a locala = this.amo[i];
      if (locala != null) {
        j += ma.b(1, locala);
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject != this)
    {
      if ((paramObject instanceof lx))
      {
        lx locallx = (lx)paramObject;
        if (md.equals(this.amo, locallx.amo)) {
          if ((this.amU != null) && (!this.amU.isEmpty())) {
            bool = this.amU.equals(locallx.amU);
          } else if ((locallx.amU == null) || (locallx.amU.isEmpty())) {
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
    int j = 31 * (527 + md.hashCode(this.amo));
    int i;
    if ((this.amU != null) && (!this.amU.isEmpty())) {
      i = this.amU.hashCode();
    } else {
      i = 0;
    }
    return i + j;
  }
  
  public lx nq()
  {
    this.amo = a.nr();
    this.amU = null;
    this.amY = -1;
    return this;
  }
  
  public lx q(lz paramlz)
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
    if (this.amo != null) {
      i = this.amo.length;
    } else {
      i = 0;
    }
    a[] arrayOfa = new a[j + i];
    if (i != 0) {
      System.arraycopy(this.amo, 0, arrayOfa, 0, i);
    }
    for (;;)
    {
      if (i >= -1 + arrayOfa.length)
      {
        arrayOfa[i] = new a();
        paramlz.a(arrayOfa[i]);
        this.amo = arrayOfa;
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
    private static volatile a[] amp;
    public a amq;
    public String name;
    
    public a()
    {
      ns();
    }
    
    public static a[] nr()
    {
      if (amp == null) {}
      synchronized (md.amX)
      {
        if (amp == null) {
          amp = new a[0];
        }
        return amp;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      paramma.b(1, this.name);
      if (this.amq != null) {
        paramma.a(2, this.amq);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int i = super.c() + ma.h(1, this.name);
      if (this.amq != null) {
        i += ma.b(2, this.amq);
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
          if (this.name != null ? this.name.equals(locala.name) : locala.name == null) {
            if (this.amq != null ? this.amq.equals(locala.amq) : locala.amq == null) {
              if ((this.amU != null) && (!this.amU.isEmpty())) {
                bool = this.amU.equals(locala.amU);
              } else if ((locala.amU == null) || (locala.amU.isEmpty())) {
                bool = true;
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
      if (this.name != null) {
        j = this.name.hashCode();
      } else {
        j = 0;
      }
      int k = 31 * (j + 527);
      if (this.amq != null) {
        j = this.amq.hashCode();
      } else {
        j = 0;
      }
      int j = 31 * (j + k);
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      }
      return j + i;
    }
    
    public a ns()
    {
      this.name = "";
      this.amq = null;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public a r(lz paramlz)
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
          this.name = paramlz.readString();
          break;
        }
        if (this.amq == null) {
          this.amq = new a();
        }
        paramlz.a(this.amq);
      }
    }
    
    public static final class a
      extends mb<a>
    {
      private static volatile a[] amr;
      public a ams;
      public int type;
      
      public a()
      {
        nu();
      }
      
      public static a[] nt()
      {
        if (amr == null) {}
        synchronized (md.amX)
        {
          if (amr == null) {
            amr = new a[0];
          }
          return amr;
        }
      }
      
      public void a(ma paramma)
        throws IOException
      {
        paramma.p(1, this.type);
        if (this.ams != null) {
          paramma.a(2, this.ams);
        }
        super.a(paramma);
      }
      
      protected int c()
      {
        int i = super.c() + ma.r(1, this.type);
        if (this.ams != null) {
          i += ma.b(2, this.ams);
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
            if ((this.type == locala.type) && (this.ams != null ? this.ams.equals(locala.ams) : locala.ams == null)) {
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
        int i = 0;
        int k = 31 * (527 + this.type);
        if (this.ams != null) {
          j = this.ams.hashCode();
        } else {
          j = 0;
        }
        int j = 31 * (j + k);
        if ((this.amU != null) && (!this.amU.isEmpty())) {
          i = this.amU.hashCode();
        }
        return j + i;
      }
      
      public a nu()
      {
        this.type = 1;
        this.ams = null;
        this.amU = null;
        this.amY = -1;
        return this;
      }
      
      public a s(lz paramlz)
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
          case 8: 
            i = paramlz.nz();
            switch (i)
            {
            default: 
              break;
            }
            this.type = i;
            break;
          }
          if (this.ams == null) {
            this.ams = new a();
          }
          paramlz.a(this.ams);
        }
      }
      
      public static final class a
        extends mb<a>
      {
        public boolean amA;
        public lx.a[] amB;
        public lx.a.a[] amC;
        public String[] amD;
        public long[] amE;
        public float[] amF;
        public long amG;
        public byte[] amt;
        public String amu;
        public double amv;
        public float amw;
        public long amx;
        public int amy;
        public int amz;
        
        public a()
        {
          nv();
        }
        
        public void a(ma paramma)
          throws IOException
        {
          int i = 0;
          if (!Arrays.equals(this.amt, mi.anh)) {
            paramma.a(1, this.amt);
          }
          if (!this.amu.equals("")) {
            paramma.b(2, this.amu);
          }
          if (Double.doubleToLongBits(this.amv) != Double.doubleToLongBits(0.0D)) {
            paramma.a(3, this.amv);
          }
          if (Float.floatToIntBits(this.amw) != Float.floatToIntBits(0.0F)) {
            paramma.b(4, this.amw);
          }
          if (this.amx != 0L) {
            paramma.b(5, this.amx);
          }
          if (this.amy != 0) {
            paramma.p(6, this.amy);
          }
          if (this.amz != 0) {
            paramma.q(7, this.amz);
          }
          if (this.amA) {
            paramma.a(8, this.amA);
          }
          if ((this.amB != null) && (this.amB.length > 0)) {}
          Object localObject;
          for (int j = 0;; localObject++)
          {
            if (j >= this.amB.length)
            {
              if ((this.amC != null) && (this.amC.length > 0)) {}
              for (int k = 0;; k++)
              {
                if (k >= this.amC.length)
                {
                  if ((this.amD != null) && (this.amD.length > 0)) {}
                  for (k = 0;; k++)
                  {
                    if (k >= this.amD.length)
                    {
                      if ((this.amE != null) && (this.amE.length > 0)) {}
                      for (j = 0;; j++)
                      {
                        if (j >= this.amE.length)
                        {
                          if (this.amG != 0L) {
                            paramma.b(13, this.amG);
                          }
                          if ((this.amF != null) && (this.amF.length > 0)) {}
                          for (;;)
                          {
                            if (i >= this.amF.length)
                            {
                              super.a(paramma);
                              return;
                            }
                            paramma.b(14, this.amF[i]);
                            i++;
                          }
                        }
                        paramma.b(12, this.amE[j]);
                      }
                    }
                    localObject = this.amD[k];
                    if (localObject != null) {
                      paramma.b(11, (String)localObject);
                    }
                  }
                }
                localObject = this.amC[k];
                if (localObject != null) {
                  paramma.a(10, (mf)localObject);
                }
              }
            }
            lx.a locala = this.amB[localObject];
            if (locala != null) {
              paramma.a(9, locala);
            }
          }
        }
        
        protected int c()
        {
          int i = 0;
          int j = super.c();
          if (!Arrays.equals(this.amt, mi.anh)) {
            j += ma.b(1, this.amt);
          }
          if (!this.amu.equals("")) {
            j += ma.h(2, this.amu);
          }
          if (Double.doubleToLongBits(this.amv) != Double.doubleToLongBits(0.0D)) {
            j += ma.b(3, this.amv);
          }
          if (Float.floatToIntBits(this.amw) != Float.floatToIntBits(0.0F)) {
            j += ma.c(4, this.amw);
          }
          if (this.amx != 0L) {
            j += ma.d(5, this.amx);
          }
          if (this.amy != 0) {
            j += ma.r(6, this.amy);
          }
          if (this.amz != 0) {
            j += ma.s(7, this.amz);
          }
          if (this.amA) {
            j += ma.b(8, this.amA);
          }
          int k;
          if ((this.amB != null) && (this.amB.length > 0)) {
            k = j;
          }
          for (int n = 0;; n++)
          {
            int m;
            if (n >= this.amB.length)
            {
              j = k;
              if ((this.amC != null) && (this.amC.length > 0)) {
                k = j;
              }
              for (n = 0;; n++)
              {
                String str;
                if (n >= this.amC.length)
                {
                  j = k;
                  int i2;
                  int i1;
                  if ((this.amD != null) && (this.amD.length > 0))
                  {
                    i2 = 0;
                    n = 0;
                    i1 = 0;
                  }
                  for (;;)
                  {
                    if (i2 >= this.amD.length)
                    {
                      j = j + n + i1 * 1;
                      if ((this.amE != null) && (this.amE.length > 0)) {
                        k = 0;
                      }
                      for (;;)
                      {
                        if (i >= this.amE.length)
                        {
                          j = j + k + 1 * this.amE.length;
                          if (this.amG != 0L) {
                            j += ma.d(13, this.amG);
                          }
                          if ((this.amF != null) && (this.amF.length > 0)) {
                            j = j + 4 * this.amF.length + 1 * this.amF.length;
                          }
                          return j;
                        }
                        k += ma.D(this.amE[i]);
                        i++;
                      }
                    }
                    str = this.amD[i2];
                    if (str != null)
                    {
                      i1++;
                      n += ma.cz(str);
                    }
                    i2++;
                  }
                }
                localObject = this.amC[n];
                if (localObject != null) {
                  str += ma.b(10, (mf)localObject);
                }
              }
            }
            Object localObject = this.amB[n];
            if (localObject != null) {
              m += ma.b(9, (mf)localObject);
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
              if ((Arrays.equals(this.amt, locala.amt)) && (this.amu != null ? this.amu.equals(locala.amu) : locala.amu == null)) {
                if ((Double.doubleToLongBits(this.amv) == Double.doubleToLongBits(locala.amv)) && (Float.floatToIntBits(this.amw) == Float.floatToIntBits(locala.amw)) && (this.amx == locala.amx) && (this.amy == locala.amy) && (this.amz == locala.amz) && (this.amA == locala.amA) && (md.equals(this.amB, locala.amB)) && (md.equals(this.amC, locala.amC)) && (md.equals(this.amD, locala.amD)) && (md.equals(this.amE, locala.amE)) && (md.equals(this.amF, locala.amF)) && (this.amG == locala.amG)) {
                  if ((this.amU != null) && (!this.amU.isEmpty())) {
                    bool = this.amU.equals(locala.amU);
                  } else if ((locala.amU == null) || (locala.amU.isEmpty())) {
                    bool = true;
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
          int j = 31 * (527 + Arrays.hashCode(this.amt));
          int m;
          if (this.amu != null) {
            m = this.amu.hashCode();
          } else {
            m = 0;
          }
          int n = m + j;
          long l = Double.doubleToLongBits(this.amv);
          int k = 31 * (31 * (31 * (31 * (31 * (n * 31 + (int)(l ^ l >>> 32)) + Float.floatToIntBits(this.amw)) + (int)(this.amx ^ this.amx >>> 32)) + this.amy) + this.amz);
          if (!this.amA) {
            m = 1237;
          } else {
            m = 1231;
          }
          k = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (m + k) + md.hashCode(this.amB)) + md.hashCode(this.amC)) + md.hashCode(this.amD)) + md.hashCode(this.amE)) + md.hashCode(this.amF)) + (int)(this.amG ^ this.amG >>> 32));
          if ((this.amU != null) && (!this.amU.isEmpty())) {
            i = this.amU.hashCode();
          }
          return k + i;
        }
        
        public a nv()
        {
          this.amt = mi.anh;
          this.amu = "";
          this.amv = 0.0D;
          this.amw = 0.0F;
          this.amx = 0L;
          this.amy = 0;
          this.amz = 0;
          this.amA = false;
          this.amB = lx.a.nr();
          this.amC = lx.a.a.nt();
          this.amD = mi.anf;
          this.amE = mi.anb;
          this.amF = mi.anc;
          this.amG = 0L;
          this.amU = null;
          this.amY = -1;
          return this;
        }
        
        public a t(lz paramlz)
          throws IOException
        {
          for (;;)
          {
            i = paramlz.nw();
            switch (i)
            {
            default: 
              if (a(paramlz, i)) {}
              break;
            case 0: 
              return this;
            case 10: 
              this.amt = paramlz.readBytes();
              break;
            case 18: 
              this.amu = paramlz.readString();
              break;
            case 25: 
              this.amv = paramlz.readDouble();
              break;
            case 37: 
              this.amw = paramlz.readFloat();
              break;
            case 40: 
              this.amx = paramlz.ny();
              break;
            case 48: 
              this.amy = paramlz.nz();
              break;
            case 56: 
              this.amz = paramlz.nB();
              break;
            case 64: 
              this.amA = paramlz.nA();
              break;
            case 74: 
              int j = mi.b(paramlz, 74);
              if (this.amB != null) {
                i = this.amB.length;
              } else {
                i = 0;
              }
              lx.a[] arrayOfa = new lx.a[j + i];
              if (i != 0) {
                System.arraycopy(this.amB, 0, arrayOfa, 0, i);
              }
              for (;;)
              {
                if (i >= -1 + arrayOfa.length)
                {
                  arrayOfa[i] = new lx.a();
                  paramlz.a(arrayOfa[i]);
                  this.amB = arrayOfa;
                  break;
                }
                arrayOfa[i] = new lx.a();
                paramlz.a(arrayOfa[i]);
                paramlz.nw();
                i++;
              }
            case 82: 
              int k = mi.b(paramlz, 82);
              if (this.amC != null) {
                i = this.amC.length;
              } else {
                i = 0;
              }
              lx.a.a[] arrayOfa1 = new lx.a.a[k + i];
              if (i != 0) {
                System.arraycopy(this.amC, 0, arrayOfa1, 0, i);
              }
              for (;;)
              {
                if (i >= -1 + arrayOfa1.length)
                {
                  arrayOfa1[i] = new lx.a.a();
                  paramlz.a(arrayOfa1[i]);
                  this.amC = arrayOfa1;
                  break;
                }
                arrayOfa1[i] = new lx.a.a();
                paramlz.a(arrayOfa1[i]);
                paramlz.nw();
                i++;
              }
            case 90: 
              int m = mi.b(paramlz, 90);
              if (this.amD != null) {
                i = this.amD.length;
              } else {
                i = 0;
              }
              String[] arrayOfString = new String[m + i];
              if (i != 0) {
                System.arraycopy(this.amD, 0, arrayOfString, 0, i);
              }
              for (;;)
              {
                if (i >= -1 + arrayOfString.length)
                {
                  arrayOfString[i] = paramlz.readString();
                  this.amD = arrayOfString;
                  break;
                }
                arrayOfString[i] = paramlz.readString();
                paramlz.nw();
                i++;
              }
            case 96: 
              int n = mi.b(paramlz, 96);
              if (this.amE != null) {
                i = this.amE.length;
              } else {
                i = 0;
              }
              long[] arrayOfLong1 = new long[n + i];
              if (i != 0) {
                System.arraycopy(this.amE, 0, arrayOfLong1, 0, i);
              }
              for (;;)
              {
                if (i >= -1 + arrayOfLong1.length)
                {
                  arrayOfLong1[i] = paramlz.ny();
                  this.amE = arrayOfLong1;
                  break;
                }
                arrayOfLong1[i] = paramlz.ny();
                paramlz.nw();
                i++;
              }
            case 98: 
              i = paramlz.ex(paramlz.nD());
              i3 = paramlz.getPosition();
              long[] arrayOfLong2;
              for (int i1 = 0;; arrayOfLong2++)
              {
                if (paramlz.nI() <= 0)
                {
                  paramlz.ez(i3);
                  if (this.amE != null) {
                    i3 = this.amE.length;
                  } else {
                    i3 = 0;
                  }
                  arrayOfLong2 = new long[i1 + i3];
                  if (i3 != 0) {
                    System.arraycopy(this.amE, 0, arrayOfLong2, 0, i3);
                  }
                  for (;;)
                  {
                    if (i3 >= arrayOfLong2.length)
                    {
                      this.amE = arrayOfLong2;
                      paramlz.ey(i);
                      break;
                    }
                    arrayOfLong2[i3] = paramlz.ny();
                    i3++;
                  }
                }
                paramlz.ny();
              }
            case 104: 
              this.amG = paramlz.ny();
            }
          }
          int i2 = paramlz.nD();
          int i = paramlz.ex(i2);
          int i3 = i2 / 4;
          if (this.amF != null) {
            i2 = this.amF.length;
          } else {
            i2 = 0;
          }
          float[] arrayOfFloat2 = new float[i3 + i2];
          if (i2 != 0) {
            System.arraycopy(this.amF, 0, arrayOfFloat2, 0, i2);
          }
          for (;;)
          {
            if (i2 >= arrayOfFloat2.length)
            {
              this.amF = arrayOfFloat2;
              paramlz.ey(i);
              break;
            }
            arrayOfFloat2[i2] = paramlz.readFloat();
            i2++;
          }
          i2 = mi.b(paramlz, 117);
          if (this.amF != null) {
            i = this.amF.length;
          } else {
            i = 0;
          }
          float[] arrayOfFloat1 = new float[i2 + i];
          if (i != 0) {
            System.arraycopy(this.amF, 0, arrayOfFloat1, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfFloat1.length)
            {
              arrayOfFloat1[i] = paramlz.readFloat();
              this.amF = arrayOfFloat1;
              break;
            }
            arrayOfFloat1[i] = paramlz.readFloat();
            paramlz.nw();
            i++;
          }
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lx
 * JD-Core Version:    0.7.0.1
 */