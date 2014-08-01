package com.google.android.gms.internal;

import java.io.IOException;
import java.util.List;

public abstract interface d
{
  public static final class a
    extends mb<a>
  {
    private static volatile a[] fM;
    public String fN;
    public a[] fO;
    public a[] fP;
    public a[] fQ;
    public String fR;
    public String fS;
    public long fT;
    public boolean fU;
    public a[] fV;
    public int[] fW;
    public boolean fX;
    public int type;
    
    public a()
    {
      s();
    }
    
    public static a[] r()
    {
      if (fM == null) {}
      synchronized (md.amX)
      {
        if (fM == null) {
          fM = new a[0];
        }
        return fM;
      }
    }
    
    public void a(ma paramma)
      throws IOException
    {
      int i = 0;
      paramma.p(1, this.type);
      if (!this.fN.equals("")) {
        paramma.b(2, this.fN);
      }
      if ((this.fO != null) && (this.fO.length > 0)) {}
      a locala1;
      for (int j = 0;; locala1++)
      {
        if (j >= this.fO.length)
        {
          if ((this.fP != null) && (this.fP.length > 0)) {}
          for (int k = 0;; locala2++)
          {
            if (k >= this.fP.length)
            {
              if ((this.fQ != null) && (this.fQ.length > 0)) {}
              for (j = 0;; locala1++)
              {
                if (j >= this.fQ.length)
                {
                  if (!this.fR.equals("")) {
                    paramma.b(6, this.fR);
                  }
                  if (!this.fS.equals("")) {
                    paramma.b(7, this.fS);
                  }
                  if (this.fT != 0L) {
                    paramma.b(8, this.fT);
                  }
                  if (this.fX) {
                    paramma.a(9, this.fX);
                  }
                  if ((this.fW != null) && (this.fW.length > 0)) {}
                  for (j = 0;; locala1++)
                  {
                    if (j >= this.fW.length)
                    {
                      if ((this.fV != null) && (this.fV.length > 0)) {}
                      for (;;)
                      {
                        if (i >= this.fV.length)
                        {
                          if (this.fU) {
                            paramma.a(12, this.fU);
                          }
                          super.a(paramma);
                          return;
                        }
                        locala1 = this.fV[i];
                        if (locala1 != null) {
                          paramma.a(11, locala1);
                        }
                        i++;
                      }
                    }
                    paramma.p(10, this.fW[locala1]);
                  }
                }
                locala2 = this.fQ[locala1];
                if (locala2 != null) {
                  paramma.a(5, locala2);
                }
              }
            }
            locala1 = this.fP[locala2];
            if (locala1 != null) {
              paramma.a(4, locala1);
            }
          }
        }
        a locala2 = this.fO[locala1];
        if (locala2 != null) {
          paramma.a(3, locala2);
        }
      }
    }
    
    protected int c()
    {
      int i = 0;
      int j = super.c() + ma.r(1, this.type);
      if (!this.fN.equals("")) {
        j += ma.h(2, this.fN);
      }
      if ((this.fO != null) && (this.fO.length > 0)) {
        j = j;
      }
      for (int n = 0;; n++)
      {
        if (n >= this.fO.length)
        {
          j = j;
          if ((this.fP != null) && (this.fP.length > 0)) {
            j = j;
          }
          for (n = 0;; n++)
          {
            if (n >= this.fP.length)
            {
              j = j;
              if ((this.fQ != null) && (this.fQ.length > 0)) {
                j = j;
              }
              for (n = 0;; n++)
              {
                if (n >= this.fQ.length)
                {
                  j = j;
                  if (!this.fR.equals("")) {
                    j += ma.h(6, this.fR);
                  }
                  if (!this.fS.equals("")) {
                    j += ma.h(7, this.fS);
                  }
                  if (this.fT != 0L) {
                    j += ma.d(8, this.fT);
                  }
                  if (this.fX) {
                    j += ma.b(9, this.fX);
                  }
                  int k;
                  if ((this.fW != null) && (this.fW.length > 0))
                  {
                    n = 0;
                    k = 0;
                  }
                  for (;;)
                  {
                    a locala1;
                    if (n >= this.fW.length)
                    {
                      j = j + k + 1 * this.fW.length;
                      if ((this.fV != null) && (this.fV.length > 0)) {}
                      for (;;)
                      {
                        if (i >= this.fV.length)
                        {
                          if (this.fU) {
                            j += ma.b(12, this.fU);
                          }
                          return j;
                        }
                        locala1 = this.fV[i];
                        if (locala1 != null) {
                          j += ma.b(11, locala1);
                        }
                        i++;
                      }
                    }
                    int m;
                    locala1 += ma.eE(this.fW[n]);
                    n++;
                  }
                }
                locala2 = this.fQ[n];
                if (locala2 != null) {
                  j += ma.b(5, locala2);
                }
              }
            }
            locala2 = this.fP[n];
            if (locala2 != null) {
              j += ma.b(4, locala2);
            }
          }
        }
        a locala2 = this.fO[n];
        if (locala2 != null) {
          j += ma.b(3, locala2);
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
          if ((this.type == locala.type) && (this.fN != null ? this.fN.equals(locala.fN) : locala.fN == null)) {
            if ((md.equals(this.fO, locala.fO)) && (md.equals(this.fP, locala.fP)) && (md.equals(this.fQ, locala.fQ)) && (this.fR != null ? this.fR.equals(locala.fR) : locala.fR == null)) {
              if (this.fS != null ? this.fS.equals(locala.fS) : locala.fS == null) {
                if ((this.fT == locala.fT) && (this.fU == locala.fU) && (md.equals(this.fV, locala.fV)) && (md.equals(this.fW, locala.fW)) && (this.fX == locala.fX)) {
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
      }
      else {
        bool = true;
      }
      return bool;
    }
    
    public int hashCode()
    {
      int j = 1231;
      int i = 0;
      int k = 31 * (527 + this.type);
      if (this.fN != null) {
        m = this.fN.hashCode();
      } else {
        m = 0;
      }
      k = 31 * (31 * (31 * (31 * (m + k) + md.hashCode(this.fO)) + md.hashCode(this.fP)) + md.hashCode(this.fQ));
      if (this.fR != null) {
        m = this.fR.hashCode();
      } else {
        m = 0;
      }
      int m = 31 * (m + k);
      if (this.fS != null) {
        k = this.fS.hashCode();
      } else {
        k = 0;
      }
      m = 31 * (31 * (k + m) + (int)(this.fT ^ this.fT >>> 32));
      if (!this.fU) {
        k = 1237;
      } else {
        k = j;
      }
      k = 31 * (31 * (31 * (k + m) + md.hashCode(this.fV)) + md.hashCode(this.fW));
      if (!this.fX) {
        j = 1237;
      }
      j = 31 * (k + j);
      if ((this.amU != null) && (!this.amU.isEmpty())) {
        i = this.amU.hashCode();
      }
      return j + i;
    }
    
    public a l(lz paramlz)
      throws IOException
    {
      for (;;)
      {
        int i = paramlz.nw();
        int i2;
        int i1;
        int[] arrayOfInt2;
        int i4;
        int j;
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
        case 18: 
          this.fN = paramlz.readString();
          break;
        case 26: 
          int k = mi.b(paramlz, 26);
          if (this.fO != null) {
            i = this.fO.length;
          } else {
            i = 0;
          }
          a[] arrayOfa1 = new a[k + i];
          if (i != 0) {
            System.arraycopy(this.fO, 0, arrayOfa1, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfa1.length)
            {
              arrayOfa1[i] = new a();
              paramlz.a(arrayOfa1[i]);
              this.fO = arrayOfa1;
              break;
            }
            arrayOfa1[i] = new a();
            paramlz.a(arrayOfa1[i]);
            paramlz.nw();
            i++;
          }
        case 34: 
          int m = mi.b(paramlz, 34);
          if (this.fP != null) {
            i = this.fP.length;
          } else {
            i = 0;
          }
          a[] arrayOfa2 = new a[m + i];
          if (i != 0) {
            System.arraycopy(this.fP, 0, arrayOfa2, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfa2.length)
            {
              arrayOfa2[i] = new a();
              paramlz.a(arrayOfa2[i]);
              this.fP = arrayOfa2;
              break;
            }
            arrayOfa2[i] = new a();
            paramlz.a(arrayOfa2[i]);
            paramlz.nw();
            i++;
          }
        case 42: 
          int n = mi.b(paramlz, 42);
          if (this.fQ != null) {
            i = this.fQ.length;
          } else {
            i = 0;
          }
          a[] arrayOfa3 = new a[n + i];
          if (i != 0) {
            System.arraycopy(this.fQ, 0, arrayOfa3, 0, i);
          }
          for (;;)
          {
            if (i >= -1 + arrayOfa3.length)
            {
              arrayOfa3[i] = new a();
              paramlz.a(arrayOfa3[i]);
              this.fQ = arrayOfa3;
              break;
            }
            arrayOfa3[i] = new a();
            paramlz.a(arrayOfa3[i]);
            paramlz.nw();
            i++;
          }
        case 50: 
          this.fR = paramlz.readString();
          break;
        case 58: 
          this.fS = paramlz.readString();
          break;
        case 64: 
          this.fT = paramlz.ny();
          break;
        case 72: 
          this.fX = paramlz.nA();
          break;
        case 80: 
          int i3 = mi.b(paramlz, 80);
          int[] arrayOfInt1 = new int[i3];
          i2 = 0;
          for (i1 = 0;; i1 = i4)
          {
            if (i2 >= i3)
            {
              if (i1 == 0) {
                break;
              }
              if (this.fW != null) {
                i2 = this.fW.length;
              } else {
                i2 = 0;
              }
              if ((i2 != 0) || (i1 != arrayOfInt1.length))
              {
                arrayOfInt2 = new int[i2 + i1];
                if (i2 != 0) {
                  System.arraycopy(this.fW, 0, arrayOfInt2, 0, i2);
                }
                System.arraycopy(arrayOfInt1, 0, arrayOfInt2, i2, i1);
                this.fW = arrayOfInt2;
                break;
              }
              this.fW = arrayOfInt1;
              break;
            }
            if (i2 != 0) {
              paramlz.nw();
            }
            int i5 = paramlz.nz();
            switch (i5)
            {
            default: 
              i4 = i1;
              break;
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
              i4 = i1 + 1;
              arrayOfInt1[i1] = i5;
            }
            i2++;
          }
        case 82: 
          j = paramlz.ex(paramlz.nD());
          i1 = paramlz.getPosition();
          i2 = 0;
          for (;;)
          {
            if (paramlz.nI() <= 0)
            {
              if (i2 != 0)
              {
                paramlz.ez(i1);
                if (this.fW != null) {
                  i1 = this.fW.length;
                } else {
                  i1 = 0;
                }
                arrayOfInt2 = new int[i2 + i1];
                if (i1 != 0) {
                  System.arraycopy(this.fW, 0, arrayOfInt2, 0, i1);
                }
              }
              for (;;)
              {
                if (paramlz.nI() <= 0)
                {
                  this.fW = arrayOfInt2;
                  paramlz.ey(j);
                  break;
                }
                i4 = paramlz.nz();
                switch (i4)
                {
                default: 
                  break;
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                  i2 = i1 + 1;
                  arrayOfInt2[i1] = i4;
                  i1 = i2;
                }
              }
            }
            switch (paramlz.nz())
            {
            default: 
              break;
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
              i2++;
            }
          }
        case 90: 
          i1 = mi.b(paramlz, 90);
          if (this.fV != null) {
            j = this.fV.length;
          } else {
            j = 0;
          }
          a[] arrayOfa4 = new a[i1 + j];
          if (j != 0) {
            System.arraycopy(this.fV, 0, arrayOfa4, 0, j);
          }
          for (;;)
          {
            if (j >= -1 + arrayOfa4.length)
            {
              arrayOfa4[j] = new a();
              paramlz.a(arrayOfa4[j]);
              this.fV = arrayOfa4;
              break;
            }
            arrayOfa4[j] = new a();
            paramlz.a(arrayOfa4[j]);
            paramlz.nw();
            j++;
          }
        }
        this.fU = paramlz.nA();
      }
    }
    
    public a s()
    {
      this.type = 1;
      this.fN = "";
      this.fO = r();
      this.fP = r();
      this.fQ = r();
      this.fR = "";
      this.fS = "";
      this.fT = 0L;
      this.fU = false;
      this.fV = r();
      this.fW = mi.ana;
      this.fX = false;
      this.amU = null;
      this.amY = -1;
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.d
 * JD-Core Version:    0.7.0.1
 */