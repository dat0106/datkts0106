package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class u
{
  private static final u uS = new u();
  private SortedSet<a> uP = new TreeSet();
  private StringBuilder uQ = new StringBuilder();
  private boolean uR = false;
  
  public static u cP()
  {
    return uS;
  }
  
  /**
   * @deprecated
   */
  public void a(a parama)
  {
    try
    {
      if (!this.uR)
      {
        this.uP.add(parama);
        this.uQ.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parama.ordinal()));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public String cQ()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      int j = 6;
      int k = 0;
      while (this.uP.size() > 0)
      {
        a locala = (a)this.uP.first();
        this.uP.remove(locala);
        int i = locala.ordinal();
        while (i >= j)
        {
          ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(k));
          j += 6;
          k = 0;
        }
        k += (1 << locala.ordinal() % 6);
      }
      if ((k > 0) || (((StringBuilder)localObject1).length() == 0)) {
        ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(k));
      }
      this.uP.clear();
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public String cR()
  {
    try
    {
      if (this.uQ.length() > 0) {
        this.uQ.insert(0, ".");
      }
      String str = this.uQ.toString();
      this.uQ = new StringBuilder();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void u(boolean paramBoolean)
  {
    try
    {
      this.uR = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static enum a
  {
    static
    {
      vA = new a("CONSTRUCT_EXCEPTION", 33);
      vB = new a("CONSTRUCT_RAW_EXCEPTION", 34);
      vC = new a("CONSTRUCT_TIMING", 35);
      vD = new a("CONSTRUCT_SOCIAL", 36);
      vE = new a("BLANK_37", 37);
      vF = new a("BLANK_38", 38);
      vG = new a("GET_TRACKER", 39);
      vH = new a("GET_DEFAULT_TRACKER", 40);
      vI = new a("SET_DEFAULT_TRACKER", 41);
      vJ = new a("SET_APP_OPT_OUT", 42);
      vK = new a("GET_APP_OPT_OUT", 43);
      vL = new a("DISPATCH", 44);
      vM = new a("SET_DISPATCH_PERIOD", 45);
      vN = new a("BLANK_46", 46);
      vO = new a("REPORT_UNCAUGHT_EXCEPTIONS", 47);
      vP = new a("SET_AUTO_ACTIVITY_TRACKING", 48);
      vQ = new a("SET_SESSION_TIMEOUT", 49);
      vR = new a("CONSTRUCT_EVENT", 50);
      vS = new a("CONSTRUCT_ITEM", 51);
      vT = new a("BLANK_52", 52);
      vU = new a("BLANK_53", 53);
      vV = new a("SET_DRY_RUN", 54);
      vW = new a("GET_DRY_RUN", 55);
      vX = new a("SET_LOGGER", 56);
      vY = new a("SET_FORCE_LOCAL_DISPATCH", 57);
      vZ = new a("GET_TRACKER_NAME", 58);
      wa = new a("CLOSE_TRACKER", 59);
      wb = new a("EASY_TRACKER_ACTIVITY_START", 60);
      wc = new a("EASY_TRACKER_ACTIVITY_STOP", 61);
      wd = new a("CONSTRUCT_APP_VIEW", 62);
      a[] arrayOfa = new a[63];
      arrayOfa[0] = uT;
      arrayOfa[1] = uU;
      arrayOfa[2] = uV;
      arrayOfa[3] = uW;
      arrayOfa[4] = uX;
      arrayOfa[5] = uY;
      arrayOfa[6] = uZ;
      arrayOfa[7] = va;
      arrayOfa[8] = vb;
      arrayOfa[9] = vc;
      arrayOfa[10] = vd;
      arrayOfa[11] = ve;
      arrayOfa[12] = vf;
      arrayOfa[13] = vg;
      arrayOfa[14] = vh;
      arrayOfa[15] = vi;
      arrayOfa[16] = vj;
      arrayOfa[17] = vk;
      arrayOfa[18] = vl;
      arrayOfa[19] = vm;
      arrayOfa[20] = vn;
      arrayOfa[21] = vo;
      arrayOfa[22] = vp;
      arrayOfa[23] = vq;
      arrayOfa[24] = vr;
      arrayOfa[25] = vs;
      arrayOfa[26] = vt;
      arrayOfa[27] = vu;
      arrayOfa[28] = vv;
      arrayOfa[29] = vw;
      arrayOfa[30] = vx;
      arrayOfa[31] = vy;
      arrayOfa[32] = vz;
      arrayOfa[33] = vA;
      arrayOfa[34] = vB;
      arrayOfa[35] = vC;
      arrayOfa[36] = vD;
      arrayOfa[37] = vE;
      arrayOfa[38] = vF;
      arrayOfa[39] = vG;
      arrayOfa[40] = vH;
      arrayOfa[41] = vI;
      arrayOfa[42] = vJ;
      arrayOfa[43] = vK;
      arrayOfa[44] = vL;
      arrayOfa[45] = vM;
      arrayOfa[46] = vN;
      arrayOfa[47] = vO;
      arrayOfa[48] = vP;
      arrayOfa[49] = vQ;
      arrayOfa[50] = vR;
      arrayOfa[51] = vS;
      arrayOfa[52] = vT;
      arrayOfa[53] = vU;
      arrayOfa[54] = vV;
      arrayOfa[55] = vW;
      arrayOfa[56] = vX;
      arrayOfa[57] = vY;
      arrayOfa[58] = vZ;
      arrayOfa[59] = wa;
      arrayOfa[60] = wb;
      arrayOfa[61] = wc;
      arrayOfa[62] = wd;
      we = arrayOfa;
    }
    
    private a() {}
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.u
 * JD-Core Version:    0.7.0.1
 */