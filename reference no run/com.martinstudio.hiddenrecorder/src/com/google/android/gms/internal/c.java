package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface c
{
  public static final class j
    extends mb<j>
  {
    public c.i[] fJ;
    public c.f fK;
    public String fL;
    
    public j()
    {
      q();
    }
    
    public static j b(byte[] paramArrayOfByte)
      throws me
    {
      return (j)mf.a(new j(), paramArrayOfByte);
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if ((this.fJ != null) && (this.fJ.length > 0)) {}
      for (int i = 0;; i++)
      {
        if (i >= this.fJ.length)
        {
          if (this.fK != null) {
            paramma.a(2, this.fK);
          }
          if (!this.fL.equals("")) {
            paramma.b(3, this.fL);
          }
          super.a(paramma);
          return;
        }
        c.i locali = this.fJ[i];
        if (locali != null) {
          paramma.a(1, locali);
        }
      }
    }
    
    protected int c()
    {
      int j = super.c();
      if ((this.fJ != null) && (this.fJ.length > 0)) {}
      for (int i = 0;; i++)
      {
        if (i >= this.fJ.length)
        {
          if (this.fK != null) {
            j += ma.b(2, this.fK);
          }
          if (!this.fL.equals("")) {
            j += ma.h(3, this.fL);
          }
          return j;
        }
        c.i locali = this.fJ[i];
        if (locali != null) {
          j += ma.b(1, locali);
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof j))
        {
          j localj = (j)paramObject;
          if ((md.equals(this.fJ, localj.fJ)) && (this.fK != null ? this.fK.equals(localj.fK) : localj.fK == null)) {
            if (this.fL != null ? this.fL.equals(localj.fL) : localj.fL == null) {
              if ((this.amU != null) && (!this.amU.isEmpty())) {
                bool = this.amU.equals(localj.amU);
              } else if ((localj.amU == null) || (localj.amU.isEmpty())) {
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
      int j = 31 * (527 + md.hashCode(this.fJ));
      if (this.fK != null) {
        k = this.fK.hashCode();
      } else {
        k = 0;
      }
      int k = 31 * (k + j);
      if (this.fL != null) {
        j = this.fL.hashCode();
      } else {
        j = 0;
      }
      j = 31 * (j + k);
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      }
      return j + i;
    }
    
    public j k(lz paramlz)
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
          int j = mi.b(paramlz, 10);
          if (this.fJ != null) {
            i = this.fJ.length;
          } else {
            i = 0;
          }
          c.i[] arrayOfi = new c.i[j + i];
          if (i != 0) {
            System.arraycopy(this.fJ, 0, arrayOfi, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfi.length)
            {
              arrayOfi[i] = new c.i();
              paramlz.a(arrayOfi[i]);
              this.fJ = arrayOfi;
              break;
            }
            arrayOfi[i] = new c.i();
            paramlz.a(arrayOfi[i]);
            paramlz.nw();
            i++;
          }
        case 18: 
          if (this.fK == null) {
            this.fK = new c.f();
          }
          paramlz.a(this.fK);
          break;
        }
        this.fL = paramlz.readString();
      }
    }
    
    public j q()
    {
      this.fJ = c.i.o();
      this.fK = null;
      this.fL = "";
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class i
    extends mb<i>
  {
    private static volatile i[] fG;
    public d.a fH;
    public c.d fI;
    public String name;
    
    public i()
    {
      p();
    }
    
    public static i[] o()
    {
      if (fG == null) {}
      synchronized (md.amX)
      {
        if (fG == null) {
          fG = new i[0];
        }
        return fG;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if (!this.name.equals("")) {
        paramma.b(1, this.name);
      }
      if (this.fH != null) {
        paramma.a(2, this.fH);
      }
      if (this.fI != null) {
        paramma.a(3, this.fI);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int i = super.c();
      if (!this.name.equals("")) {
        i += ma.h(1, this.name);
      }
      if (this.fH != null) {
        i += ma.b(2, this.fH);
      }
      if (this.fI != null) {
        i += ma.b(3, this.fI);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof i))
        {
          i locali = (i)paramObject;
          if (this.name != null ? this.name.equals(locali.name) : locali.name == null) {
            if (this.fH != null ? this.fH.equals(locali.fH) : locali.fH == null) {
              if (this.fI != null ? this.fI.equals(locali.fI) : locali.fI == null) {
                if ((this.amU != null) && (!this.amU.isEmpty())) {
                  bool = this.amU.equals(locali.amU);
                } else if ((locali.amU == null) || (locali.amU.isEmpty())) {
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
      if (this.name != null) {
        j = this.name.hashCode();
      } else {
        j = 0;
      }
      int j = 31 * (j + 527);
      int k;
      if (this.fH != null) {
        k = this.fH.hashCode();
      } else {
        k = 0;
      }
      j = 31 * (k + j);
      if (this.fI != null) {
        k = this.fI.hashCode();
      } else {
        k = 0;
      }
      j = 31 * (k + j);
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      }
      return j + i;
    }
    
    public i j(lz paramlz)
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
        case 18: 
          if (this.fH == null) {
            this.fH = new d.a();
          }
          paramlz.a(this.fH);
          break;
        }
        if (this.fI == null) {
          this.fI = new c.d();
        }
        paramlz.a(this.fI);
      }
    }
    
    public i p()
    {
      this.name = "";
      this.fH = null;
      this.fI = null;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class d
    extends mb<d>
  {
    public d.a[] eR;
    public d.a[] eS;
    public c.c[] eT;
    
    public d()
    {
      h();
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int i = 0;
      if ((this.eR != null) && (this.eR.length > 0)) {}
      c.c localc;
      for (int j = 0;; localc++)
      {
        if (j >= this.eR.length)
        {
          if ((this.eS != null) && (this.eS.length > 0)) {}
          for (j = 0;; localc++)
          {
            if (j >= this.eS.length)
            {
              if ((this.eT != null) && (this.eT.length > 0)) {}
              for (;;)
              {
                if (i >= this.eT.length)
                {
                  super.a(paramma);
                  return;
                }
                localc = this.eT[i];
                if (localc != null) {
                  paramma.a(3, localc);
                }
                i++;
              }
            }
            locala = this.eS[localc];
            if (locala != null) {
              paramma.a(2, locala);
            }
          }
        }
        d.a locala = this.eR[localc];
        if (locala != null) {
          paramma.a(1, locala);
        }
      }
    }
    
    protected int c()
    {
      int i = 0;
      int m = super.c();
      int n;
      if ((this.eR != null) && (this.eR.length > 0)) {
        n = m;
      }
      for (m = 0;; m++)
      {
        d.a locala2;
        if (m >= this.eR.length)
        {
          m = n;
          int j;
          if ((this.eS != null) && (this.eS.length > 0)) {
            j = m;
          }
          for (m = 0;; m++)
          {
            c.c localc;
            if (m >= this.eS.length)
            {
              m = j;
              if ((this.eT != null) && (this.eT.length > 0)) {}
              for (;;)
              {
                if (i >= this.eT.length) {
                  return m;
                }
                localc = this.eT[i];
                if (localc != null) {
                  m += ma.b(3, localc);
                }
                i++;
              }
            }
            locala2 = this.eS[m];
            if (locala2 != null)
            {
              int k;
              localc += ma.b(2, locala2);
            }
          }
        }
        d.a locala1 = this.eR[m];
        if (locala1 != null)
        {
          int i1;
          locala2 += ma.b(1, locala1);
        }
      }
    }
    
    public d e(lz paramlz)
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
      if (this.eR != null) {
        i = this.eR.length;
      } else {
        i = 0;
      }
      d.a[] arrayOfa1 = new d.a[j + i];
      if (i != 0) {
        System.arraycopy(this.eR, 0, arrayOfa1, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfa1.length)
        {
          arrayOfa1[i] = new d.a();
          paramlz.a(arrayOfa1[i]);
          this.eR = arrayOfa1;
          break;
        }
        arrayOfa1[i] = new d.a();
        paramlz.a(arrayOfa1[i]);
        paramlz.nw();
        i++;
      }
      int k = mi.b(paramlz, 18);
      if (this.eS != null) {
        i = this.eS.length;
      } else {
        i = 0;
      }
      d.a[] arrayOfa2 = new d.a[k + i];
      if (i != 0) {
        System.arraycopy(this.eS, 0, arrayOfa2, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfa2.length)
        {
          arrayOfa2[i] = new d.a();
          paramlz.a(arrayOfa2[i]);
          this.eS = arrayOfa2;
          break;
        }
        arrayOfa2[i] = new d.a();
        paramlz.a(arrayOfa2[i]);
        paramlz.nw();
        i++;
      }
      int m = mi.b(paramlz, 26);
      if (this.eT != null) {
        i = this.eT.length;
      } else {
        i = 0;
      }
      c.c[] arrayOfc = new c.c[m + i];
      if (i != 0) {
        System.arraycopy(this.eT, 0, arrayOfc, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfc.length)
        {
          arrayOfc[i] = new c.c();
          paramlz.a(arrayOfc[i]);
          this.eT = arrayOfc;
          break;
        }
        arrayOfc[i] = new c.c();
        paramlz.a(arrayOfc[i]);
        paramlz.nw();
        i++;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof d))
        {
          d locald = (d)paramObject;
          if ((md.equals(this.eR, locald.eR)) && (md.equals(this.eS, locald.eS)) && (md.equals(this.eT, locald.eT))) {
            if ((this.amU != null) && (!this.amU.isEmpty())) {
              bool = this.amU.equals(locald.amU);
            } else if ((locald.amU == null) || (locald.amU.isEmpty())) {
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
    
    public d h()
    {
      this.eR = d.a.r();
      this.eS = d.a.r();
      this.eT = c.c.f();
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public int hashCode()
    {
      int i = 31 * (31 * (31 * (527 + md.hashCode(this.eR)) + md.hashCode(this.eS)) + md.hashCode(this.eT));
      int j;
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        j = this.amU.hashCode();
      } else {
        j = 0;
      }
      return j + i;
    }
  }
  
  public static final class c
    extends mb<c>
  {
    private static volatile c[] eL;
    public String eM;
    public long eN;
    public long eO;
    public boolean eP;
    public long eQ;
    
    public c()
    {
      g();
    }
    
    public static c[] f()
    {
      if (eL == null) {}
      synchronized (md.amX)
      {
        if (eL == null) {
          eL = new c[0];
        }
        return eL;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if (!this.eM.equals("")) {
        paramma.b(1, this.eM);
      }
      if (this.eN != 0L) {
        paramma.b(2, this.eN);
      }
      if (this.eO != 2147483647L) {
        paramma.b(3, this.eO);
      }
      if (this.eP) {
        paramma.a(4, this.eP);
      }
      if (this.eQ != 0L) {
        paramma.b(5, this.eQ);
      }
      super.a(paramma);
    }
    
    protected int c()
    {
      int i = super.c();
      if (!this.eM.equals("")) {
        i += ma.h(1, this.eM);
      }
      if (this.eN != 0L) {
        i += ma.d(2, this.eN);
      }
      if (this.eO != 2147483647L) {
        i += ma.d(3, this.eO);
      }
      if (this.eP) {
        i += ma.b(4, this.eP);
      }
      if (this.eQ != 0L) {
        i += ma.d(5, this.eQ);
      }
      return i;
    }
    
    public c d(lz paramlz)
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
          this.eM = paramlz.readString();
          break;
        case 16: 
          this.eN = paramlz.ny();
          break;
        case 24: 
          this.eO = paramlz.ny();
          break;
        case 32: 
          this.eP = paramlz.nA();
          break;
        }
        this.eQ = paramlz.ny();
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof c))
        {
          c localc = (c)paramObject;
          if (this.eM != null ? this.eM.equals(localc.eM) : localc.eM == null) {
            if ((this.eN == localc.eN) && (this.eO == localc.eO) && (this.eP == localc.eP) && (this.eQ == localc.eQ)) {
              if ((this.amU != null) && (!this.amU.isEmpty())) {
                bool = this.amU.equals(localc.amU);
              } else if ((localc.amU == null) || (localc.amU.isEmpty())) {
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
    
    public c g()
    {
      this.eM = "";
      this.eN = 0L;
      this.eO = 2147483647L;
      this.eP = false;
      this.eQ = 0L;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public int hashCode()
    {
      int i = 0;
      if (this.eM != null) {
        j = this.eM.hashCode();
      } else {
        j = 0;
      }
      int j = 31 * (31 * (31 * (j + 527) + (int)(this.eN ^ this.eN >>> 32)) + (int)(this.eO ^ this.eO >>> 32));
      int k;
      if (!this.eP) {
        k = 1237;
      } else {
        k = 1231;
      }
      j = 31 * (31 * (k + j) + (int)(this.eQ ^ this.eQ >>> 32));
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      }
      return j + i;
    }
  }
  
  public static final class f
    extends mb<f>
  {
    public String[] eV;
    public String[] eW;
    public d.a[] eX;
    public c.e[] eY;
    public c.b[] eZ;
    public c.b[] fa;
    public c.b[] fb;
    public c.g[] fc;
    public String fd;
    public String fe;
    public String ff;
    public String fg;
    public c.a fh;
    public float fi;
    public boolean fj;
    public String[] fk;
    public int fl;
    
    public f()
    {
      k();
    }
    
    public static f a(byte[] paramArrayOfByte)
      throws me
    {
      return (f)mf.a(new f(), paramArrayOfByte);
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int i = 0;
      if ((this.eW != null) && (this.eW.length > 0)) {}
      Object localObject1;
      for (int j = 0;; localObject1++)
      {
        if (j >= this.eW.length)
        {
          if ((this.eX != null) && (this.eX.length > 0)) {}
          for (j = 0;; localObject1++)
          {
            if (j >= this.eX.length)
            {
              if ((this.eY != null) && (this.eY.length > 0)) {}
              for (int k = 0;; localObject2++)
              {
                if (k >= this.eY.length)
                {
                  if ((this.eZ != null) && (this.eZ.length > 0)) {}
                  for (j = 0;; localObject1++)
                  {
                    if (j >= this.eZ.length)
                    {
                      if ((this.fa != null) && (this.fa.length > 0)) {}
                      for (k = 0;; localObject2++)
                      {
                        if (k >= this.fa.length)
                        {
                          if ((this.fb != null) && (this.fb.length > 0)) {}
                          for (j = 0;; localObject1++)
                          {
                            if (j >= this.fb.length)
                            {
                              if ((this.fc != null) && (this.fc.length > 0)) {}
                              for (k = 0;; k++)
                              {
                                if (k >= this.fc.length)
                                {
                                  if (!this.fd.equals("")) {
                                    paramma.b(9, this.fd);
                                  }
                                  if (!this.fe.equals("")) {
                                    paramma.b(10, this.fe);
                                  }
                                  if (!this.ff.equals("0")) {
                                    paramma.b(12, this.ff);
                                  }
                                  if (!this.fg.equals("")) {
                                    paramma.b(13, this.fg);
                                  }
                                  if (this.fh != null) {
                                    paramma.a(14, this.fh);
                                  }
                                  if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0F)) {
                                    paramma.b(15, this.fi);
                                  }
                                  if ((this.fk != null) && (this.fk.length > 0)) {}
                                  for (k = 0;; k++)
                                  {
                                    if (k >= this.fk.length)
                                    {
                                      if (this.fl != 0) {
                                        paramma.p(17, this.fl);
                                      }
                                      if (this.fj) {
                                        paramma.a(18, this.fj);
                                      }
                                      if ((this.eV != null) && (this.eV.length > 0)) {}
                                      for (;;)
                                      {
                                        if (i >= this.eV.length)
                                        {
                                          super.a(paramma);
                                          return;
                                        }
                                        localObject1 = this.eV[i];
                                        if (localObject1 != null) {
                                          paramma.b(19, (String)localObject1);
                                        }
                                        i++;
                                      }
                                    }
                                    localObject1 = this.fk[k];
                                    if (localObject1 != null) {
                                      paramma.b(16, (String)localObject1);
                                    }
                                  }
                                }
                                localObject1 = this.fc[k];
                                if (localObject1 != null) {
                                  paramma.a(7, (mf)localObject1);
                                }
                              }
                            }
                            localObject2 = this.fb[localObject1];
                            if (localObject2 != null) {
                              paramma.a(6, (mf)localObject2);
                            }
                          }
                        }
                        localObject1 = this.fa[localObject2];
                        if (localObject1 != null) {
                          paramma.a(5, (mf)localObject1);
                        }
                      }
                    }
                    localObject2 = this.eZ[localObject1];
                    if (localObject2 != null) {
                      paramma.a(4, (mf)localObject2);
                    }
                  }
                }
                localObject1 = this.eY[localObject2];
                if (localObject1 != null) {
                  paramma.a(3, (mf)localObject1);
                }
              }
            }
            localObject2 = this.eX[localObject1];
            if (localObject2 != null) {
              paramma.a(2, (mf)localObject2);
            }
          }
        }
        Object localObject2 = this.eW[localObject1];
        if (localObject2 != null) {
          paramma.b(1, (String)localObject2);
        }
      }
    }
    
    protected int c()
    {
      int i = 0;
      int i4 = super.c();
      int j;
      int m;
      int i2;
      if ((this.eW == null) || (this.eW.length <= 0))
      {
        j = i4;
      }
      else
      {
        m = 0;
        j = 0;
        i2 = 0;
      }
      for (;;)
      {
        int i1;
        d.a locala;
        int k;
        if (m >= this.eW.length)
        {
          j = i4 + j + i2 * 1;
          if ((this.eX != null) && (this.eX.length > 0)) {
            j = j;
          }
          for (m = 0;; i1++)
          {
            c.e locale;
            if (m >= this.eX.length)
            {
              j = j;
              if ((this.eY != null) && (this.eY.length > 0)) {
                m = j;
              }
              int i3;
              for (i2 = 0;; i3++)
              {
                c.b localb;
                if (i2 >= this.eY.length)
                {
                  j = m;
                  if ((this.eZ != null) && (this.eZ.length > 0)) {
                    i2 = j;
                  }
                  for (j = 0;; j++)
                  {
                    if (j >= this.eZ.length)
                    {
                      j = i2;
                      if ((this.fa != null) && (this.fa.length > 0)) {
                        j = j;
                      }
                      for (i2 = 0;; i3++)
                      {
                        if (i2 >= this.fa.length)
                        {
                          j = j;
                          if ((this.fb != null) && (this.fb.length > 0)) {
                            i2 = j;
                          }
                          for (j = 0;; j++)
                          {
                            Object localObject;
                            if (j >= this.fb.length)
                            {
                              j = i2;
                              if ((this.fc != null) && (this.fc.length > 0)) {
                                m = j;
                              }
                              for (j = 0;; j++)
                              {
                                String str1;
                                if (j >= this.fc.length)
                                {
                                  j = m;
                                  if (!this.fd.equals("")) {
                                    j += ma.h(9, this.fd);
                                  }
                                  if (!this.fe.equals("")) {
                                    j += ma.h(10, this.fe);
                                  }
                                  if (!this.ff.equals("0")) {
                                    j += ma.h(12, this.ff);
                                  }
                                  if (!this.fg.equals("")) {
                                    j += ma.h(13, this.fg);
                                  }
                                  if (this.fh != null) {
                                    j += ma.b(14, this.fh);
                                  }
                                  if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0F)) {
                                    j += ma.c(15, this.fi);
                                  }
                                  int i5;
                                  if ((this.fk != null) && (this.fk.length > 0))
                                  {
                                    m = 0;
                                    i4 = 0;
                                    i5 = 0;
                                  }
                                  for (;;)
                                  {
                                    if (m >= this.fk.length)
                                    {
                                      j = j + i4 + i5 * 2;
                                      if (this.fl != 0) {
                                        j += ma.r(17, this.fl);
                                      }
                                      if (this.fj) {
                                        j += ma.b(18, this.fj);
                                      }
                                      if ((this.eV != null) && (this.eV.length > 0))
                                      {
                                        i2 = 0;
                                        i4 = 0;
                                      }
                                      for (;;)
                                      {
                                        if (i >= this.eV.length)
                                        {
                                          j = j + i2 + i4 * 2;
                                          return j;
                                        }
                                        str1 = this.eV[i];
                                        if (str1 != null)
                                        {
                                          i4++;
                                          i2 += ma.cz(str1);
                                        }
                                        i++;
                                      }
                                    }
                                    localObject = this.fk[str1];
                                    if (localObject != null)
                                    {
                                      i5++;
                                      i4 += ma.cz((String)localObject);
                                    }
                                    str1++;
                                  }
                                }
                                localObject = this.fc[j];
                                if (localObject != null)
                                {
                                  int n;
                                  str1 += ma.b(7, (mf)localObject);
                                }
                              }
                            }
                            localb = this.fb[j];
                            if (localb != null) {
                              localObject += ma.b(6, localb);
                            }
                          }
                        }
                        localb = this.fa[i3];
                        if (localb != null) {
                          j += ma.b(5, localb);
                        }
                      }
                    }
                    localb = this.eZ[j];
                    if (localb != null) {
                      i3 += ma.b(4, localb);
                    }
                  }
                }
                locale = this.eY[i3];
                if (locale != null) {
                  localb += ma.b(3, locale);
                }
              }
            }
            locala = this.eX[i1];
            if (locala != null) {
              locale += ma.b(2, locala);
            }
          }
        }
        String str2 = this.eW[i1];
        if (str2 != null)
        {
          locala++;
          k += ma.cz(str2);
        }
        i1++;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof f))
        {
          f localf = (f)paramObject;
          if ((md.equals(this.eV, localf.eV)) && (md.equals(this.eW, localf.eW)) && (md.equals(this.eX, localf.eX)) && (md.equals(this.eY, localf.eY)) && (md.equals(this.eZ, localf.eZ)) && (md.equals(this.fa, localf.fa)) && (md.equals(this.fb, localf.fb)) && (md.equals(this.fc, localf.fc)) && (this.fd != null ? this.fd.equals(localf.fd) : localf.fd == null)) {
            if (this.fe != null ? this.fe.equals(localf.fe) : localf.fe == null) {
              if (this.ff != null ? this.ff.equals(localf.ff) : localf.ff == null) {
                if (this.fg != null ? this.fg.equals(localf.fg) : localf.fg == null) {
                  if (this.fh != null ? this.fh.equals(localf.fh) : localf.fh == null) {
                    if ((Float.floatToIntBits(this.fi) == Float.floatToIntBits(localf.fi)) && (this.fj == localf.fj) && (md.equals(this.fk, localf.fk)) && (this.fl == localf.fl)) {
                      if ((this.amU != null) && (!this.amU.isEmpty())) {
                        bool = this.amU.equals(localf.amU);
                      } else if ((localf.amU == null) || (localf.amU.isEmpty())) {
                        bool = true;
                      }
                    }
                  }
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
    
    public f g(lz paramlz)
      throws IOException
    {
      int i;
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
          int j = mi.b(paramlz, 10);
          if (this.eW != null) {
            i = this.eW.length;
          } else {
            i = 0;
          }
          String[] arrayOfString1 = new String[j + i];
          if (i != 0) {
            System.arraycopy(this.eW, 0, arrayOfString1, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfString1.length)
            {
              arrayOfString1[i] = paramlz.readString();
              this.eW = arrayOfString1;
              break;
            }
            arrayOfString1[i] = paramlz.readString();
            paramlz.nw();
            i++;
          }
        case 18: 
          int k = mi.b(paramlz, 18);
          if (this.eX != null) {
            i = this.eX.length;
          } else {
            i = 0;
          }
          d.a[] arrayOfa = new d.a[k + i];
          if (i != 0) {
            System.arraycopy(this.eX, 0, arrayOfa, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfa.length)
            {
              arrayOfa[i] = new d.a();
              paramlz.a(arrayOfa[i]);
              this.eX = arrayOfa;
              break;
            }
            arrayOfa[i] = new d.a();
            paramlz.a(arrayOfa[i]);
            paramlz.nw();
            i++;
          }
        case 26: 
          int m = mi.b(paramlz, 26);
          if (this.eY != null) {
            i = this.eY.length;
          } else {
            i = 0;
          }
          c.e[] arrayOfe = new c.e[m + i];
          if (i != 0) {
            System.arraycopy(this.eY, 0, arrayOfe, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfe.length)
            {
              arrayOfe[i] = new c.e();
              paramlz.a(arrayOfe[i]);
              this.eY = arrayOfe;
              break;
            }
            arrayOfe[i] = new c.e();
            paramlz.a(arrayOfe[i]);
            paramlz.nw();
            i++;
          }
        case 34: 
          int n = mi.b(paramlz, 34);
          if (this.eZ != null) {
            i = this.eZ.length;
          } else {
            i = 0;
          }
          c.b[] arrayOfb1 = new c.b[n + i];
          if (i != 0) {
            System.arraycopy(this.eZ, 0, arrayOfb1, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfb1.length)
            {
              arrayOfb1[i] = new c.b();
              paramlz.a(arrayOfb1[i]);
              this.eZ = arrayOfb1;
              break;
            }
            arrayOfb1[i] = new c.b();
            paramlz.a(arrayOfb1[i]);
            paramlz.nw();
            i++;
          }
        case 42: 
          int i1 = mi.b(paramlz, 42);
          if (this.fa != null) {
            i = this.fa.length;
          } else {
            i = 0;
          }
          c.b[] arrayOfb2 = new c.b[i1 + i];
          if (i != 0) {
            System.arraycopy(this.fa, 0, arrayOfb2, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfb2.length)
            {
              arrayOfb2[i] = new c.b();
              paramlz.a(arrayOfb2[i]);
              this.fa = arrayOfb2;
              break;
            }
            arrayOfb2[i] = new c.b();
            paramlz.a(arrayOfb2[i]);
            paramlz.nw();
            i++;
          }
        case 50: 
          int i2 = mi.b(paramlz, 50);
          if (this.fb != null) {
            i = this.fb.length;
          } else {
            i = 0;
          }
          c.b[] arrayOfb3 = new c.b[i2 + i];
          if (i != 0) {
            System.arraycopy(this.fb, 0, arrayOfb3, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfb3.length)
            {
              arrayOfb3[i] = new c.b();
              paramlz.a(arrayOfb3[i]);
              this.fb = arrayOfb3;
              break;
            }
            arrayOfb3[i] = new c.b();
            paramlz.a(arrayOfb3[i]);
            paramlz.nw();
            i++;
          }
        case 58: 
          int i3 = mi.b(paramlz, 58);
          if (this.fc != null) {
            i = this.fc.length;
          } else {
            i = 0;
          }
          c.g[] arrayOfg = new c.g[i3 + i];
          if (i != 0) {
            System.arraycopy(this.fc, 0, arrayOfg, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfg.length)
            {
              arrayOfg[i] = new c.g();
              paramlz.a(arrayOfg[i]);
              this.fc = arrayOfg;
              break;
            }
            arrayOfg[i] = new c.g();
            paramlz.a(arrayOfg[i]);
            paramlz.nw();
            i++;
          }
        case 74: 
          this.fd = paramlz.readString();
          break;
        case 82: 
          this.fe = paramlz.readString();
          break;
        case 98: 
          this.ff = paramlz.readString();
          break;
        case 106: 
          this.fg = paramlz.readString();
          break;
        case 114: 
          if (this.fh == null) {
            this.fh = new c.a();
          }
          paramlz.a(this.fh);
          break;
        case 125: 
          this.fi = paramlz.readFloat();
          break;
        case 130: 
          int i4 = mi.b(paramlz, 130);
          if (this.fk != null) {
            i = this.fk.length;
          } else {
            i = 0;
          }
          String[] arrayOfString2 = new String[i4 + i];
          if (i != 0) {
            System.arraycopy(this.fk, 0, arrayOfString2, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfString2.length)
            {
              arrayOfString2[i] = paramlz.readString();
              this.fk = arrayOfString2;
              break;
            }
            arrayOfString2[i] = paramlz.readString();
            paramlz.nw();
            i++;
          }
        case 136: 
          this.fl = paramlz.nz();
          break;
        case 144: 
          this.fj = paramlz.nA();
        }
      }
      int i5 = mi.b(paramlz, 154);
      if (this.eV != null) {
        i = this.eV.length;
      } else {
        i = 0;
      }
      String[] arrayOfString3 = new String[i5 + i];
      if (i != 0) {
        System.arraycopy(this.eV, 0, arrayOfString3, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfString3.length)
        {
          arrayOfString3[i] = paramlz.readString();
          this.eV = arrayOfString3;
          break;
        }
        arrayOfString3[i] = paramlz.readString();
        paramlz.nw();
        i++;
      }
    }
    
    public int hashCode()
    {
      int i = 0;
      int j = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + md.hashCode(this.eV)) + md.hashCode(this.eW)) + md.hashCode(this.eX)) + md.hashCode(this.eY)) + md.hashCode(this.eZ)) + md.hashCode(this.fa)) + md.hashCode(this.fb)) + md.hashCode(this.fc));
      if (this.fd != null) {
        k = this.fd.hashCode();
      } else {
        k = 0;
      }
      int k = 31 * (k + j);
      if (this.fe != null) {
        j = this.fe.hashCode();
      } else {
        j = 0;
      }
      k = 31 * (j + k);
      if (this.ff != null) {
        j = this.ff.hashCode();
      } else {
        j = 0;
      }
      j = 31 * (j + k);
      if (this.fg != null) {
        k = this.fg.hashCode();
      } else {
        k = 0;
      }
      k = 31 * (k + j);
      if (this.fh != null) {
        j = this.fh.hashCode();
      } else {
        j = 0;
      }
      k = 31 * (31 * (j + k) + Float.floatToIntBits(this.fi));
      if (!this.fj) {
        j = 1237;
      } else {
        j = 1231;
      }
      j = 31 * (31 * (31 * (j + k) + md.hashCode(this.fk)) + this.fl);
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      }
      return j + i;
    }
    
    public f k()
    {
      this.eV = mi.anf;
      this.eW = mi.anf;
      this.eX = d.a.r();
      this.eY = c.e.i();
      this.eZ = c.b.d();
      this.fa = c.b.d();
      this.fb = c.b.d();
      this.fc = c.g.l();
      this.fd = "";
      this.fe = "";
      this.ff = "0";
      this.fg = "";
      this.fh = null;
      this.fi = 0.0F;
      this.fj = false;
      this.fk = mi.anf;
      this.fl = 0;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class a
    extends mb<a>
  {
    public int eE;
    public int eF;
    public int level;
    
    public a()
    {
      b();
    }
    
    public a a(lz paramlz)
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
          this.level = i;
          break;
        case 16: 
          this.eE = paramlz.nz();
          break;
        }
        this.eF = paramlz.nz();
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if (this.level != 1) {
        paramma.p(1, this.level);
      }
      if (this.eE != 0) {
        paramma.p(2, this.eE);
      }
      if (this.eF != 0) {
        paramma.p(3, this.eF);
      }
      super.a(paramma);
    }
    
    public a b()
    {
      this.level = 1;
      this.eE = 0;
      this.eF = 0;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    protected int c()
    {
      int i = super.c();
      if (this.level != 1) {
        i += ma.r(1, this.level);
      }
      if (this.eE != 0) {
        i += ma.r(2, this.eE);
      }
      if (this.eF != 0) {
        i += ma.r(3, this.eF);
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
          if ((this.level == locala.level) && (this.eE == locala.eE) && (this.eF == locala.eF)) {
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
      int j = 31 * (31 * (31 * (527 + this.level) + this.eE) + this.eF);
      int i;
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      } else {
        i = 0;
      }
      return i + j;
    }
  }
  
  public static final class g
    extends mb<g>
  {
    private static volatile g[] fm;
    public int[] fn;
    public int[] fo;
    public int[] fp;
    public int[] fq;
    public int[] fr;
    public int[] fs;
    public int[] ft;
    public int[] fu;
    public int[] fv;
    public int[] fw;
    
    public g()
    {
      m();
    }
    
    public static g[] l()
    {
      if (fm == null) {}
      synchronized (md.amX)
      {
        if (fm == null) {
          fm = new g[0];
        }
        return fm;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int i = 0;
      if ((this.fn != null) && (this.fn.length > 0)) {}
      for (int j = 0;; j++)
      {
        if (j >= this.fn.length)
        {
          if ((this.fo != null) && (this.fo.length > 0)) {}
          for (j = 0;; j++)
          {
            if (j >= this.fo.length)
            {
              if ((this.fp != null) && (this.fp.length > 0)) {}
              for (j = 0;; j++)
              {
                if (j >= this.fp.length)
                {
                  if ((this.fq != null) && (this.fq.length > 0)) {}
                  for (j = 0;; j++)
                  {
                    if (j >= this.fq.length)
                    {
                      if ((this.fr != null) && (this.fr.length > 0)) {}
                      for (j = 0;; j++)
                      {
                        if (j >= this.fr.length)
                        {
                          if ((this.fs != null) && (this.fs.length > 0)) {}
                          for (j = 0;; j++)
                          {
                            if (j >= this.fs.length)
                            {
                              if ((this.ft != null) && (this.ft.length > 0)) {}
                              for (j = 0;; j++)
                              {
                                if (j >= this.ft.length)
                                {
                                  if ((this.fu != null) && (this.fu.length > 0)) {}
                                  for (j = 0;; j++)
                                  {
                                    if (j >= this.fu.length)
                                    {
                                      if ((this.fv != null) && (this.fv.length > 0)) {}
                                      for (j = 0;; j++)
                                      {
                                        if (j >= this.fv.length)
                                        {
                                          if ((this.fw != null) && (this.fw.length > 0)) {}
                                          for (;;)
                                          {
                                            if (i >= this.fw.length)
                                            {
                                              super.a(paramma);
                                              return;
                                            }
                                            paramma.p(10, this.fw[i]);
                                            i++;
                                          }
                                        }
                                        paramma.p(9, this.fv[j]);
                                      }
                                    }
                                    paramma.p(8, this.fu[j]);
                                  }
                                }
                                paramma.p(7, this.ft[j]);
                              }
                            }
                            paramma.p(6, this.fs[j]);
                          }
                        }
                        paramma.p(5, this.fr[j]);
                      }
                    }
                    paramma.p(4, this.fq[j]);
                  }
                }
                paramma.p(3, this.fp[j]);
              }
            }
            paramma.p(2, this.fo[j]);
          }
        }
        paramma.p(1, this.fn[j]);
      }
    }
    
    protected int c()
    {
      int i = 0;
      int k = super.c();
      int j;
      int m;
      if ((this.fn == null) || (this.fn.length <= 0))
      {
        j = k;
      }
      else
      {
        m = 0;
        j = 0;
      }
      for (;;)
      {
        if (m >= this.fn.length)
        {
          j = k + j + 1 * this.fn.length;
          if ((this.fo != null) && (this.fo.length > 0))
          {
            m = 0;
            k = 0;
          }
          for (;;)
          {
            if (m >= this.fo.length)
            {
              j = j + k + 1 * this.fo.length;
              if ((this.fp != null) && (this.fp.length > 0))
              {
                k = 0;
                m = 0;
              }
              for (;;)
              {
                if (k >= this.fp.length)
                {
                  j = j + m + 1 * this.fp.length;
                  if ((this.fq != null) && (this.fq.length > 0))
                  {
                    k = 0;
                    m = 0;
                  }
                  for (;;)
                  {
                    if (k >= this.fq.length)
                    {
                      j = j + m + 1 * this.fq.length;
                      if ((this.fr != null) && (this.fr.length > 0))
                      {
                        k = 0;
                        m = 0;
                      }
                      for (;;)
                      {
                        if (k >= this.fr.length)
                        {
                          j = j + m + 1 * this.fr.length;
                          if ((this.fs != null) && (this.fs.length > 0))
                          {
                            k = 0;
                            m = 0;
                          }
                          for (;;)
                          {
                            if (k >= this.fs.length)
                            {
                              j = j + m + 1 * this.fs.length;
                              if ((this.ft != null) && (this.ft.length > 0))
                              {
                                m = 0;
                                k = 0;
                              }
                              for (;;)
                              {
                                if (m >= this.ft.length)
                                {
                                  j = j + k + 1 * this.ft.length;
                                  if ((this.fu != null) && (this.fu.length > 0))
                                  {
                                    k = 0;
                                    m = 0;
                                  }
                                  for (;;)
                                  {
                                    if (k >= this.fu.length)
                                    {
                                      j = j + m + 1 * this.fu.length;
                                      if ((this.fv != null) && (this.fv.length > 0))
                                      {
                                        m = 0;
                                        k = 0;
                                      }
                                      for (;;)
                                      {
                                        if (m >= this.fv.length)
                                        {
                                          j = j + k + 1 * this.fv.length;
                                          if ((this.fw != null) && (this.fw.length > 0)) {
                                            k = 0;
                                          }
                                          for (;;)
                                          {
                                            if (i >= this.fw.length)
                                            {
                                              j = j + k + 1 * this.fw.length;
                                              return j;
                                            }
                                            k += ma.eE(this.fw[i]);
                                            i++;
                                          }
                                        }
                                        k += ma.eE(this.fv[m]);
                                        m++;
                                      }
                                    }
                                    m += ma.eE(this.fu[k]);
                                    k++;
                                  }
                                }
                                k += ma.eE(this.ft[m]);
                                m++;
                              }
                            }
                            m += ma.eE(this.fs[k]);
                            k++;
                          }
                        }
                        m += ma.eE(this.fr[k]);
                        k++;
                      }
                    }
                    m += ma.eE(this.fq[k]);
                    k++;
                  }
                }
                m += ma.eE(this.fp[k]);
                k++;
              }
            }
            k += ma.eE(this.fo[m]);
            m++;
          }
        }
        j += ma.eE(this.fn[m]);
        m++;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof g))
        {
          g localg = (g)paramObject;
          if ((md.equals(this.fn, localg.fn)) && (md.equals(this.fo, localg.fo)) && (md.equals(this.fp, localg.fp)) && (md.equals(this.fq, localg.fq)) && (md.equals(this.fr, localg.fr)) && (md.equals(this.fs, localg.fs)) && (md.equals(this.ft, localg.ft)) && (md.equals(this.fu, localg.fu)) && (md.equals(this.fv, localg.fv)) && (md.equals(this.fw, localg.fw))) {
            if ((this.amU != null) && (!this.amU.isEmpty())) {
              bool = this.amU.equals(localg.amU);
            } else if ((localg.amU == null) || (localg.amU.isEmpty())) {
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
    
    public g h(lz paramlz)
      throws IOException
    {
      do
      {
        i = paramlz.nw();
        switch (i)
        {
        }
      } while (a(paramlz, i));
      return this;
      int j = mi.b(paramlz, 8);
      if (this.fn != null) {
        i = this.fn.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt1 = new int[j + i];
      if (i != 0) {
        System.arraycopy(this.fn, 0, arrayOfInt1, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt1.length)
        {
          arrayOfInt1[i] = paramlz.nz();
          this.fn = arrayOfInt1;
          break;
        }
        arrayOfInt1[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      int i = paramlz.ex(paramlz.nD());
      int i12 = paramlz.getPosition();
      int[] arrayOfInt2;
      for (int k = 0;; arrayOfInt2++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i12);
          if (this.fn != null) {
            i12 = this.fn.length;
          } else {
            i12 = 0;
          }
          arrayOfInt2 = new int[k + i12];
          if (i12 != 0) {
            System.arraycopy(this.fn, 0, arrayOfInt2, 0, i12);
          }
          for (;;)
          {
            if (i12 >= arrayOfInt2.length)
            {
              this.fn = arrayOfInt2;
              paramlz.ey(i);
              break;
            }
            arrayOfInt2[i12] = paramlz.nz();
            i12++;
          }
        }
        paramlz.nz();
      }
      int m = mi.b(paramlz, 16);
      if (this.fo != null) {
        i = this.fo.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt3 = new int[m + i];
      if (i != 0) {
        System.arraycopy(this.fo, 0, arrayOfInt3, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt3.length)
        {
          arrayOfInt3[i] = paramlz.nz();
          this.fo = arrayOfInt3;
          break;
        }
        arrayOfInt3[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      i12 = paramlz.getPosition();
      int[] arrayOfInt4;
      for (int n = 0;; arrayOfInt4++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i12);
          if (this.fo != null) {
            i12 = this.fo.length;
          } else {
            i12 = 0;
          }
          arrayOfInt4 = new int[n + i12];
          if (i12 != 0) {
            System.arraycopy(this.fo, 0, arrayOfInt4, 0, i12);
          }
          for (;;)
          {
            if (i12 >= arrayOfInt4.length)
            {
              this.fo = arrayOfInt4;
              paramlz.ey(i);
              break;
            }
            arrayOfInt4[i12] = paramlz.nz();
            i12++;
          }
        }
        paramlz.nz();
      }
      int i1 = mi.b(paramlz, 24);
      if (this.fp != null) {
        i = this.fp.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt5 = new int[i1 + i];
      if (i != 0) {
        System.arraycopy(this.fp, 0, arrayOfInt5, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt5.length)
        {
          arrayOfInt5[i] = paramlz.nz();
          this.fp = arrayOfInt5;
          break;
        }
        arrayOfInt5[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      int i2 = paramlz.getPosition();
      int[] arrayOfInt15;
      for (i12 = 0;; arrayOfInt15++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i2);
          if (this.fp != null) {
            i2 = this.fp.length;
          } else {
            i2 = 0;
          }
          arrayOfInt15 = new int[i12 + i2];
          if (i2 != 0) {
            System.arraycopy(this.fp, 0, arrayOfInt15, 0, i2);
          }
          for (;;)
          {
            if (i2 >= arrayOfInt15.length)
            {
              this.fp = arrayOfInt15;
              paramlz.ey(i);
              break;
            }
            arrayOfInt15[i2] = paramlz.nz();
            i2++;
          }
        }
        paramlz.nz();
      }
      i2 = mi.b(paramlz, 32);
      if (this.fq != null) {
        i = this.fq.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt6 = new int[i2 + i];
      if (i != 0) {
        System.arraycopy(this.fq, 0, arrayOfInt6, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt6.length)
        {
          arrayOfInt6[i] = paramlz.nz();
          this.fq = arrayOfInt6;
          break;
        }
        arrayOfInt6[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      int i13 = paramlz.getPosition();
      int[] arrayOfInt7;
      for (int i3 = 0;; arrayOfInt7++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i13);
          if (this.fq != null) {
            i13 = this.fq.length;
          } else {
            i13 = 0;
          }
          arrayOfInt7 = new int[i3 + i13];
          if (i13 != 0) {
            System.arraycopy(this.fq, 0, arrayOfInt7, 0, i13);
          }
          for (;;)
          {
            if (i13 >= arrayOfInt7.length)
            {
              this.fq = arrayOfInt7;
              paramlz.ey(i);
              break;
            }
            arrayOfInt7[i13] = paramlz.nz();
            i13++;
          }
        }
        paramlz.nz();
      }
      int i4 = mi.b(paramlz, 40);
      if (this.fr != null) {
        i = this.fr.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt8 = new int[i4 + i];
      if (i != 0) {
        System.arraycopy(this.fr, 0, arrayOfInt8, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt8.length)
        {
          arrayOfInt8[i] = paramlz.nz();
          this.fr = arrayOfInt8;
          break;
        }
        arrayOfInt8[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      i13 = paramlz.getPosition();
      int[] arrayOfInt9;
      for (int i5 = 0;; arrayOfInt9++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i13);
          if (this.fr != null) {
            i13 = this.fr.length;
          } else {
            i13 = 0;
          }
          arrayOfInt9 = new int[i5 + i13];
          if (i13 != 0) {
            System.arraycopy(this.fr, 0, arrayOfInt9, 0, i13);
          }
          for (;;)
          {
            if (i13 >= arrayOfInt9.length)
            {
              this.fr = arrayOfInt9;
              paramlz.ey(i);
              break;
            }
            arrayOfInt9[i13] = paramlz.nz();
            i13++;
          }
        }
        paramlz.nz();
      }
      int i6 = mi.b(paramlz, 48);
      if (this.fs != null) {
        i = this.fs.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt10 = new int[i6 + i];
      if (i != 0) {
        System.arraycopy(this.fs, 0, arrayOfInt10, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt10.length)
        {
          arrayOfInt10[i] = paramlz.nz();
          this.fs = arrayOfInt10;
          break;
        }
        arrayOfInt10[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      int i7 = paramlz.getPosition();
      int[] arrayOfInt16;
      for (i13 = 0;; arrayOfInt16++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i7);
          if (this.fs != null) {
            i7 = this.fs.length;
          } else {
            i7 = 0;
          }
          arrayOfInt16 = new int[i13 + i7];
          if (i7 != 0) {
            System.arraycopy(this.fs, 0, arrayOfInt16, 0, i7);
          }
          for (;;)
          {
            if (i7 >= arrayOfInt16.length)
            {
              this.fs = arrayOfInt16;
              paramlz.ey(i);
              break;
            }
            arrayOfInt16[i7] = paramlz.nz();
            i7++;
          }
        }
        paramlz.nz();
      }
      i7 = mi.b(paramlz, 56);
      if (this.ft != null) {
        i = this.ft.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt11 = new int[i7 + i];
      if (i != 0) {
        System.arraycopy(this.ft, 0, arrayOfInt11, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt11.length)
        {
          arrayOfInt11[i] = paramlz.nz();
          this.ft = arrayOfInt11;
          break;
        }
        arrayOfInt11[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      int i8 = paramlz.getPosition();
      int[] arrayOfInt17;
      for (int i14 = 0;; arrayOfInt17++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i8);
          if (this.ft != null) {
            i8 = this.ft.length;
          } else {
            i8 = 0;
          }
          arrayOfInt17 = new int[i14 + i8];
          if (i8 != 0) {
            System.arraycopy(this.ft, 0, arrayOfInt17, 0, i8);
          }
          for (;;)
          {
            if (i8 >= arrayOfInt17.length)
            {
              this.ft = arrayOfInt17;
              paramlz.ey(i);
              break;
            }
            arrayOfInt17[i8] = paramlz.nz();
            i8++;
          }
        }
        paramlz.nz();
      }
      i8 = mi.b(paramlz, 64);
      if (this.fu != null) {
        i = this.fu.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt12 = new int[i8 + i];
      if (i != 0) {
        System.arraycopy(this.fu, 0, arrayOfInt12, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt12.length)
        {
          arrayOfInt12[i] = paramlz.nz();
          this.fu = arrayOfInt12;
          break;
        }
        arrayOfInt12[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      int i9 = paramlz.getPosition();
      int[] arrayOfInt18;
      for (int i15 = 0;; arrayOfInt18++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i9);
          if (this.fu != null) {
            i9 = this.fu.length;
          } else {
            i9 = 0;
          }
          arrayOfInt18 = new int[i15 + i9];
          if (i9 != 0) {
            System.arraycopy(this.fu, 0, arrayOfInt18, 0, i9);
          }
          for (;;)
          {
            if (i9 >= arrayOfInt18.length)
            {
              this.fu = arrayOfInt18;
              paramlz.ey(i);
              break;
            }
            arrayOfInt18[i9] = paramlz.nz();
            i9++;
          }
        }
        paramlz.nz();
      }
      i9 = mi.b(paramlz, 72);
      if (this.fv != null) {
        i = this.fv.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt13 = new int[i9 + i];
      if (i != 0) {
        System.arraycopy(this.fv, 0, arrayOfInt13, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt13.length)
        {
          arrayOfInt13[i] = paramlz.nz();
          this.fv = arrayOfInt13;
          break;
        }
        arrayOfInt13[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      int i10 = paramlz.getPosition();
      int[] arrayOfInt19;
      for (int i16 = 0;; arrayOfInt19++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i10);
          if (this.fv != null) {
            i10 = this.fv.length;
          } else {
            i10 = 0;
          }
          arrayOfInt19 = new int[i16 + i10];
          if (i10 != 0) {
            System.arraycopy(this.fv, 0, arrayOfInt19, 0, i10);
          }
          for (;;)
          {
            if (i10 >= arrayOfInt19.length)
            {
              this.fv = arrayOfInt19;
              paramlz.ey(i);
              break;
            }
            arrayOfInt19[i10] = paramlz.nz();
            i10++;
          }
        }
        paramlz.nz();
      }
      i10 = mi.b(paramlz, 80);
      if (this.fw != null) {
        i = this.fw.length;
      } else {
        i = 0;
      }
      int[] arrayOfInt14 = new int[i10 + i];
      if (i != 0) {
        System.arraycopy(this.fw, 0, arrayOfInt14, 0, i);
      }
      for (;;)
      {
        if (i >= -1 + arrayOfInt14.length)
        {
          arrayOfInt14[i] = paramlz.nz();
          this.fw = arrayOfInt14;
          break;
        }
        arrayOfInt14[i] = paramlz.nz();
        paramlz.nw();
        i++;
      }
      i = paramlz.ex(paramlz.nD());
      int i11 = paramlz.getPosition();
      int[] arrayOfInt20;
      for (int i17 = 0;; arrayOfInt20++)
      {
        if (paramlz.nI() <= 0)
        {
          paramlz.ez(i11);
          if (this.fw != null) {
            i11 = this.fw.length;
          } else {
            i11 = 0;
          }
          arrayOfInt20 = new int[i17 + i11];
          if (i11 != 0) {
            System.arraycopy(this.fw, 0, arrayOfInt20, 0, i11);
          }
          for (;;)
          {
            if (i11 >= arrayOfInt20.length)
            {
              this.fw = arrayOfInt20;
              paramlz.ey(i);
              break;
            }
            arrayOfInt20[i11] = paramlz.nz();
            i11++;
          }
        }
        paramlz.nz();
      }
    }
    
    public int hashCode()
    {
      int i = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + md.hashCode(this.fn)) + md.hashCode(this.fo)) + md.hashCode(this.fp)) + md.hashCode(this.fq)) + md.hashCode(this.fr)) + md.hashCode(this.fs)) + md.hashCode(this.ft)) + md.hashCode(this.fu)) + md.hashCode(this.fv)) + md.hashCode(this.fw));
      int j;
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        j = this.amU.hashCode();
      } else {
        j = 0;
      }
      return j + i;
    }
    
    public g m()
    {
      this.fn = mi.ana;
      this.fo = mi.ana;
      this.fp = mi.ana;
      this.fq = mi.ana;
      this.fr = mi.ana;
      this.fs = mi.ana;
      this.ft = mi.ana;
      this.fu = mi.ana;
      this.fv = mi.ana;
      this.fw = mi.ana;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class b
    extends mb<b>
  {
    private static volatile b[] eG;
    public int[] eH;
    public int eI;
    public boolean eJ;
    public boolean eK;
    public int name;
    
    public b()
    {
      e();
    }
    
    public static b[] d()
    {
      if (eG == null) {}
      synchronized (md.amX)
      {
        if (eG == null) {
          eG = new b[0];
        }
        return eG;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      if (this.eK) {
        paramma.a(1, this.eK);
      }
      paramma.p(2, this.eI);
      if ((this.eH != null) && (this.eH.length > 0)) {}
      for (int i = 0;; i++)
      {
        if (i >= this.eH.length)
        {
          if (this.name != 0) {
            paramma.p(4, this.name);
          }
          if (this.eJ) {
            paramma.a(6, this.eJ);
          }
          super.a(paramma);
          return;
        }
        paramma.p(3, this.eH[i]);
      }
    }
    
    protected int c()
    {
      int i = 0;
      int j = super.c();
      if (this.eK) {
        j += ma.b(1, this.eK);
      }
      int k = j + ma.r(2, this.eI);
      if ((this.eH == null) || (this.eH.length <= 0)) {
        i = k;
      }
      for (j = 0;; j++)
      {
        if (j >= this.eH.length)
        {
          i = k + i + 1 * this.eH.length;
          if (this.name != 0) {
            i += ma.r(4, this.name);
          }
          if (this.eJ) {
            i += ma.b(6, this.eJ);
          }
          return i;
        }
        i += ma.eE(this.eH[j]);
      }
    }
    
    public b c(lz paramlz)
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
          this.eK = paramlz.nA();
          break;
        case 16: 
          this.eI = paramlz.nz();
          break;
        case 24: 
          int j = mi.b(paramlz, 24);
          if (this.eH != null) {
            i = this.eH.length;
          } else {
            i = 0;
          }
          int[] arrayOfInt1 = new int[j + i];
          if (i != 0) {
            System.arraycopy(this.eH, 0, arrayOfInt1, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfInt1.length)
            {
              arrayOfInt1[i] = paramlz.nz();
              this.eH = arrayOfInt1;
              break;
            }
            arrayOfInt1[i] = paramlz.nz();
            paramlz.nw();
            i++;
          }
        case 26: 
          i = paramlz.ex(paramlz.nD());
          int k = paramlz.getPosition();
          int[] arrayOfInt2;
          for (int m = 0;; arrayOfInt2++)
          {
            if (paramlz.nI() <= 0)
            {
              paramlz.ez(k);
              if (this.eH != null) {
                k = this.eH.length;
              } else {
                k = 0;
              }
              arrayOfInt2 = new int[m + k];
              if (k != 0) {
                System.arraycopy(this.eH, 0, arrayOfInt2, 0, k);
              }
              for (;;)
              {
                if (k >= arrayOfInt2.length)
                {
                  this.eH = arrayOfInt2;
                  paramlz.ey(i);
                  break;
                }
                arrayOfInt2[k] = paramlz.nz();
                k++;
              }
            }
            paramlz.nz();
          }
        case 32: 
          this.name = paramlz.nz();
          break;
        }
        this.eJ = paramlz.nA();
      }
    }
    
    public b e()
    {
      this.eH = mi.ana;
      this.eI = 0;
      this.name = 0;
      this.eJ = false;
      this.eK = false;
      this.amU = null;
      this.amY = -1;
      return this;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof b))
        {
          b localb = (b)paramObject;
          if ((md.equals(this.eH, localb.eH)) && (this.eI == localb.eI) && (this.name == localb.name) && (this.eJ == localb.eJ) && (this.eK == localb.eK)) {
            if ((this.amU != null) && (!this.amU.isEmpty())) {
              bool = this.amU.equals(localb.amU);
            } else if ((localb.amU == null) || (localb.amU.isEmpty())) {
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
      int i = 1231;
      int k = 31 * (31 * (31 * (527 + md.hashCode(this.eH)) + this.eI) + this.name);
      if (!this.eJ) {
        j = 1237;
      } else {
        j = i;
      }
      int j = 31 * (j + k);
      if (!this.eK) {
        i = 1237;
      }
      j = 31 * (j + i);
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      } else {
        i = 0;
      }
      return i + j;
    }
  }
  
  public static final class e
    extends mb<e>
  {
    private static volatile e[] eU;
    public int key;
    public int value;
    
    public e()
    {
      j();
    }
    
    public static e[] i()
    {
      if (eU == null) {}
      synchronized (md.amX)
      {
        if (eU == null) {
          eU = new e[0];
        }
        return eU;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      paramma.p(1, this.key);
      paramma.p(2, this.value);
      super.a(paramma);
    }
    
    protected int c()
    {
      return super.c() + ma.r(1, this.key) + ma.r(2, this.value);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof e))
        {
          e locale = (e)paramObject;
          if ((this.key == locale.key) && (this.value == locale.value)) {
            if ((this.amU != null) && (!this.amU.isEmpty())) {
              bool = this.amU.equals(locale.amU);
            } else if ((locale.amU == null) || (locale.amU.isEmpty())) {
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
    
    public e f(lz paramlz)
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
          this.key = paramlz.nz();
          break;
        }
        this.value = paramlz.nz();
      }
    }
    
    public int hashCode()
    {
      int i = 31 * (31 * (527 + this.key) + this.value);
      int j;
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        j = this.amU.hashCode();
      } else {
        j = 0;
      }
      return j + i;
    }
    
    public e j()
    {
      this.key = 0;
      this.value = 0;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
  
  public static final class h
    extends mb<h>
  {
    public static final mc<d.a, h> fx = mc.a(11, h.class, 810);
    private static final h[] fy = new h[0];
    public int[] fA;
    public int[] fB;
    public int fC;
    public int[] fD;
    public int fE;
    public int fF;
    public int[] fz;
    
    public h()
    {
      n();
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int i = 0;
      if ((this.fz != null) && (this.fz.length > 0)) {}
      for (int j = 0;; j++)
      {
        if (j >= this.fz.length)
        {
          if ((this.fA != null) && (this.fA.length > 0)) {}
          for (j = 0;; j++)
          {
            if (j >= this.fA.length)
            {
              if ((this.fB != null) && (this.fB.length > 0)) {}
              for (j = 0;; j++)
              {
                if (j >= this.fB.length)
                {
                  if (this.fC != 0) {
                    paramma.p(4, this.fC);
                  }
                  if ((this.fD != null) && (this.fD.length > 0)) {}
                  for (;;)
                  {
                    if (i >= this.fD.length)
                    {
                      if (this.fE != 0) {
                        paramma.p(6, this.fE);
                      }
                      if (this.fF != 0) {
                        paramma.p(7, this.fF);
                      }
                      super.a(paramma);
                      return;
                    }
                    paramma.p(5, this.fD[i]);
                    i++;
                  }
                }
                paramma.p(3, this.fB[j]);
              }
            }
            paramma.p(2, this.fA[j]);
          }
        }
        paramma.p(1, this.fz[j]);
      }
    }
    
    protected int c()
    {
      int i = 0;
      int m = super.c();
      int j;
      int k;
      if ((this.fz == null) || (this.fz.length <= 0))
      {
        j = m;
      }
      else
      {
        k = 0;
        j = 0;
      }
      for (;;)
      {
        if (k >= this.fz.length)
        {
          j = m + j + 1 * this.fz.length;
          if ((this.fA != null) && (this.fA.length > 0))
          {
            k = 0;
            m = 0;
          }
          for (;;)
          {
            if (k >= this.fA.length)
            {
              j = j + m + 1 * this.fA.length;
              if ((this.fB != null) && (this.fB.length > 0))
              {
                k = 0;
                m = 0;
              }
              for (;;)
              {
                if (k >= this.fB.length)
                {
                  j = j + m + 1 * this.fB.length;
                  if (this.fC != 0) {
                    j += ma.r(4, this.fC);
                  }
                  if ((this.fD != null) && (this.fD.length > 0)) {
                    k = 0;
                  }
                  for (;;)
                  {
                    if (i >= this.fD.length)
                    {
                      j = j + k + 1 * this.fD.length;
                      if (this.fE != 0) {
                        j += ma.r(6, this.fE);
                      }
                      if (this.fF != 0) {
                        j += ma.r(7, this.fF);
                      }
                      return j;
                    }
                    k += ma.eE(this.fD[i]);
                    i++;
                  }
                }
                m += ma.eE(this.fB[k]);
                k++;
              }
            }
            m += ma.eE(this.fA[k]);
            k++;
          }
        }
        j += ma.eE(this.fz[k]);
        k++;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != this)
      {
        if ((paramObject instanceof h))
        {
          h localh = (h)paramObject;
          if ((md.equals(this.fz, localh.fz)) && (md.equals(this.fA, localh.fA)) && (md.equals(this.fB, localh.fB)) && (this.fC == localh.fC) && (md.equals(this.fD, localh.fD)) && (this.fE == localh.fE) && (this.fF == localh.fF)) {
            if ((this.amU != null) && (!this.amU.isEmpty())) {
              bool = this.amU.equals(localh.amU);
            } else if ((localh.amU == null) || (localh.amU.isEmpty())) {
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
      int j = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + md.hashCode(this.fz)) + md.hashCode(this.fA)) + md.hashCode(this.fB)) + this.fC) + md.hashCode(this.fD)) + this.fE) + this.fF);
      int i;
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      } else {
        i = 0;
      }
      return i + j;
    }
    
    public h i(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        int i4;
        int i2;
        switch (i)
        {
        default: 
          if (a(paramlz, i)) {
            continue;
          }
        case 0: 
          return this;
        case 8: 
          int j = mi.b(paramlz, 8);
          if (this.fz != null) {
            i = this.fz.length;
          } else {
            i = 0;
          }
          int[] arrayOfInt1 = new int[j + i];
          if (i != 0) {
            System.arraycopy(this.fz, 0, arrayOfInt1, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfInt1.length)
            {
              arrayOfInt1[i] = paramlz.nz();
              this.fz = arrayOfInt1;
              break;
            }
            arrayOfInt1[i] = paramlz.nz();
            paramlz.nw();
            i++;
          }
        case 10: 
          i = paramlz.ex(paramlz.nD());
          i4 = paramlz.getPosition();
          int[] arrayOfInt2;
          for (int k = 0;; arrayOfInt2++)
          {
            if (paramlz.nI() <= 0)
            {
              paramlz.ez(i4);
              if (this.fz != null) {
                i4 = this.fz.length;
              } else {
                i4 = 0;
              }
              arrayOfInt2 = new int[k + i4];
              if (i4 != 0) {
                System.arraycopy(this.fz, 0, arrayOfInt2, 0, i4);
              }
              for (;;)
              {
                if (i4 >= arrayOfInt2.length)
                {
                  this.fz = arrayOfInt2;
                  paramlz.ey(i);
                  break;
                }
                arrayOfInt2[i4] = paramlz.nz();
                i4++;
              }
            }
            paramlz.nz();
          }
        case 16: 
          int m = mi.b(paramlz, 16);
          if (this.fA != null) {
            i = this.fA.length;
          } else {
            i = 0;
          }
          int[] arrayOfInt3 = new int[m + i];
          if (i != 0) {
            System.arraycopy(this.fA, 0, arrayOfInt3, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfInt3.length)
            {
              arrayOfInt3[i] = paramlz.nz();
              this.fA = arrayOfInt3;
              break;
            }
            arrayOfInt3[i] = paramlz.nz();
            paramlz.nw();
            i++;
          }
        case 18: 
          i = paramlz.ex(paramlz.nD());
          i4 = paramlz.getPosition();
          int[] arrayOfInt4;
          for (int n = 0;; arrayOfInt4++)
          {
            if (paramlz.nI() <= 0)
            {
              paramlz.ez(i4);
              if (this.fA != null) {
                i4 = this.fA.length;
              } else {
                i4 = 0;
              }
              arrayOfInt4 = new int[n + i4];
              if (i4 != 0) {
                System.arraycopy(this.fA, 0, arrayOfInt4, 0, i4);
              }
              for (;;)
              {
                if (i4 >= arrayOfInt4.length)
                {
                  this.fA = arrayOfInt4;
                  paramlz.ey(i);
                  break;
                }
                arrayOfInt4[i4] = paramlz.nz();
                i4++;
              }
            }
            paramlz.nz();
          }
        case 24: 
          int i1 = mi.b(paramlz, 24);
          if (this.fB != null) {
            i = this.fB.length;
          } else {
            i = 0;
          }
          int[] arrayOfInt5 = new int[i1 + i];
          if (i != 0) {
            System.arraycopy(this.fB, 0, arrayOfInt5, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfInt5.length)
            {
              arrayOfInt5[i] = paramlz.nz();
              this.fB = arrayOfInt5;
              break;
            }
            arrayOfInt5[i] = paramlz.nz();
            paramlz.nw();
            i++;
          }
        case 26: 
          i = paramlz.ex(paramlz.nD());
          i2 = paramlz.getPosition();
          int[] arrayOfInt7;
          for (i4 = 0;; arrayOfInt7++)
          {
            if (paramlz.nI() <= 0)
            {
              paramlz.ez(i2);
              if (this.fB != null) {
                i2 = this.fB.length;
              } else {
                i2 = 0;
              }
              arrayOfInt7 = new int[i4 + i2];
              if (i2 != 0) {
                System.arraycopy(this.fB, 0, arrayOfInt7, 0, i2);
              }
              for (;;)
              {
                if (i2 >= arrayOfInt7.length)
                {
                  this.fB = arrayOfInt7;
                  paramlz.ey(i);
                  break;
                }
                arrayOfInt7[i2] = paramlz.nz();
                i2++;
              }
            }
            paramlz.nz();
          }
        case 32: 
          this.fC = paramlz.nz();
          break;
        case 40: 
          i2 = mi.b(paramlz, 40);
          if (this.fD != null) {
            i = this.fD.length;
          } else {
            i = 0;
          }
          int[] arrayOfInt6 = new int[i2 + i];
          if (i != 0) {
            System.arraycopy(this.fD, 0, arrayOfInt6, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfInt6.length)
            {
              arrayOfInt6[i] = paramlz.nz();
              this.fD = arrayOfInt6;
              break;
            }
            arrayOfInt6[i] = paramlz.nz();
            paramlz.nw();
            i++;
          }
        case 42: 
          i = paramlz.ex(paramlz.nD());
          int i3 = paramlz.getPosition();
          int[] arrayOfInt8;
          for (int i5 = 0;; arrayOfInt8++)
          {
            if (paramlz.nI() <= 0)
            {
              paramlz.ez(i3);
              if (this.fD != null) {
                i3 = this.fD.length;
              } else {
                i3 = 0;
              }
              arrayOfInt8 = new int[i5 + i3];
              if (i3 != 0) {
                System.arraycopy(this.fD, 0, arrayOfInt8, 0, i3);
              }
              for (;;)
              {
                if (i3 >= arrayOfInt8.length)
                {
                  this.fD = arrayOfInt8;
                  paramlz.ey(i);
                  break;
                }
                arrayOfInt8[i3] = paramlz.nz();
                i3++;
              }
            }
            paramlz.nz();
          }
        case 48: 
          this.fE = paramlz.nz();
          break;
        }
        this.fF = paramlz.nz();
      }
    }
    
    public h n()
    {
      this.fz = mi.ana;
      this.fA = mi.ana;
      this.fB = mi.ana;
      this.fC = 0;
      this.fD = mi.ana;
      this.fE = 0;
      this.fF = 0;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.c
 * JD-Core Version:    0.7.0.1
 */