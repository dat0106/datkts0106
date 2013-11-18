package com.google.ads.util;

import java.io.UnsupportedEncodingException;

public class c
{
  static
  {
    boolean bool;
    if (c.class.desiredAssertionStatus()) {
      bool = false;
    } else {
      bool = true;
    }
    a = bool;
  }
  
  public static byte[] a(String paramString)
  {
    return a(paramString.getBytes(), 0);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (localb.a(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      byte[] arrayOfByte;
      if (localb.b != localb.a.length)
      {
        arrayOfByte = new byte[localb.b];
        System.arraycopy(localb.a, 0, arrayOfByte, 0, localb.b);
      }
      else
      {
        arrayOfByte = localb.a;
      }
      return arrayOfByte;
    }
    throw new IllegalArgumentException("bad base-64");
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      String str = new String(c(paramArrayOfByte, paramInt), "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3, null);
    int j = 4 * (paramInt2 / 3);
    if (!localc.d) {}
    switch (paramInt2 % 3)
    {
    default: 
      break;
    case 1: 
      j += 2;
      break;
    case 2: 
      j += 3;
      break;
      if (paramInt2 % 3 > 0) {
        j += 4;
      }
      break;
    }
    if ((localc.e) && (paramInt2 > 0))
    {
      int i = 1 + (paramInt2 - 1) / 57;
      int k;
      if (!localc.f) {
        k = 1;
      } else {
        k = 2;
      }
      j += k * i;
    }
    localc.a = new byte[j];
    localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
    if ((a) || (localc.b == j)) {
      return localc.a;
    }
    throw new AssertionError();
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static class c
    extends c.a
  {
    private static final byte[] h;
    private static final byte[] i;
    public int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte[] j;
    private int k;
    private final byte[] l;
    
    static
    {
      boolean bool;
      if (c.class.desiredAssertionStatus()) {
        bool = false;
      } else {
        bool = true;
      }
      g = bool;
      byte[] arrayOfByte = new byte[64];
      arrayOfByte[0] = 65;
      arrayOfByte[1] = 66;
      arrayOfByte[2] = 67;
      arrayOfByte[3] = 68;
      arrayOfByte[4] = 69;
      arrayOfByte[5] = 70;
      arrayOfByte[6] = 71;
      arrayOfByte[7] = 72;
      arrayOfByte[8] = 73;
      arrayOfByte[9] = 74;
      arrayOfByte[10] = 75;
      arrayOfByte[11] = 76;
      arrayOfByte[12] = 77;
      arrayOfByte[13] = 78;
      arrayOfByte[14] = 79;
      arrayOfByte[15] = 80;
      arrayOfByte[16] = 81;
      arrayOfByte[17] = 82;
      arrayOfByte[18] = 83;
      arrayOfByte[19] = 84;
      arrayOfByte[20] = 85;
      arrayOfByte[21] = 86;
      arrayOfByte[22] = 87;
      arrayOfByte[23] = 88;
      arrayOfByte[24] = 89;
      arrayOfByte[25] = 90;
      arrayOfByte[26] = 97;
      arrayOfByte[27] = 98;
      arrayOfByte[28] = 99;
      arrayOfByte[29] = 100;
      arrayOfByte[30] = 101;
      arrayOfByte[31] = 102;
      arrayOfByte[32] = 103;
      arrayOfByte[33] = 104;
      arrayOfByte[34] = 105;
      arrayOfByte[35] = 106;
      arrayOfByte[36] = 107;
      arrayOfByte[37] = 108;
      arrayOfByte[38] = 109;
      arrayOfByte[39] = 110;
      arrayOfByte[40] = 111;
      arrayOfByte[41] = 112;
      arrayOfByte[42] = 113;
      arrayOfByte[43] = 114;
      arrayOfByte[44] = 115;
      arrayOfByte[45] = 116;
      arrayOfByte[46] = 117;
      arrayOfByte[47] = 118;
      arrayOfByte[48] = 119;
      arrayOfByte[49] = 120;
      arrayOfByte[50] = 121;
      arrayOfByte[51] = 122;
      arrayOfByte[52] = 48;
      arrayOfByte[53] = 49;
      arrayOfByte[54] = 50;
      arrayOfByte[55] = 51;
      arrayOfByte[56] = 52;
      arrayOfByte[57] = 53;
      arrayOfByte[58] = 54;
      arrayOfByte[59] = 55;
      arrayOfByte[60] = 56;
      arrayOfByte[61] = 57;
      arrayOfByte[62] = 43;
      arrayOfByte[63] = 47;
      h = arrayOfByte;
      arrayOfByte = new byte[64];
      arrayOfByte[0] = 65;
      arrayOfByte[1] = 66;
      arrayOfByte[2] = 67;
      arrayOfByte[3] = 68;
      arrayOfByte[4] = 69;
      arrayOfByte[5] = 70;
      arrayOfByte[6] = 71;
      arrayOfByte[7] = 72;
      arrayOfByte[8] = 73;
      arrayOfByte[9] = 74;
      arrayOfByte[10] = 75;
      arrayOfByte[11] = 76;
      arrayOfByte[12] = 77;
      arrayOfByte[13] = 78;
      arrayOfByte[14] = 79;
      arrayOfByte[15] = 80;
      arrayOfByte[16] = 81;
      arrayOfByte[17] = 82;
      arrayOfByte[18] = 83;
      arrayOfByte[19] = 84;
      arrayOfByte[20] = 85;
      arrayOfByte[21] = 86;
      arrayOfByte[22] = 87;
      arrayOfByte[23] = 88;
      arrayOfByte[24] = 89;
      arrayOfByte[25] = 90;
      arrayOfByte[26] = 97;
      arrayOfByte[27] = 98;
      arrayOfByte[28] = 99;
      arrayOfByte[29] = 100;
      arrayOfByte[30] = 101;
      arrayOfByte[31] = 102;
      arrayOfByte[32] = 103;
      arrayOfByte[33] = 104;
      arrayOfByte[34] = 105;
      arrayOfByte[35] = 106;
      arrayOfByte[36] = 107;
      arrayOfByte[37] = 108;
      arrayOfByte[38] = 109;
      arrayOfByte[39] = 110;
      arrayOfByte[40] = 111;
      arrayOfByte[41] = 112;
      arrayOfByte[42] = 113;
      arrayOfByte[43] = 114;
      arrayOfByte[44] = 115;
      arrayOfByte[45] = 116;
      arrayOfByte[46] = 117;
      arrayOfByte[47] = 118;
      arrayOfByte[48] = 119;
      arrayOfByte[49] = 120;
      arrayOfByte[50] = 121;
      arrayOfByte[51] = 122;
      arrayOfByte[52] = 48;
      arrayOfByte[53] = 49;
      arrayOfByte[54] = 50;
      arrayOfByte[55] = 51;
      arrayOfByte[56] = 52;
      arrayOfByte[57] = 53;
      arrayOfByte[58] = 54;
      arrayOfByte[59] = 55;
      arrayOfByte[60] = 56;
      arrayOfByte[61] = 57;
      arrayOfByte[62] = 45;
      arrayOfByte[63] = 95;
      i = arrayOfByte;
    }
    
    public c(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      boolean bool2;
      if ((paramInt & 0x1) != 0) {
        bool2 = false;
      } else {
        bool2 = bool1;
      }
      this.d = bool2;
      if ((paramInt & 0x2) != 0) {
        bool2 = false;
      } else {
        bool2 = bool1;
      }
      this.e = bool2;
      if ((paramInt & 0x4) == 0) {
        bool1 = false;
      }
      this.f = bool1;
      byte[] arrayOfByte;
      if ((paramInt & 0x8) != 0) {
        arrayOfByte = i;
      } else {
        arrayOfByte = h;
      }
      this.l = arrayOfByte;
      this.j = new byte[2];
      this.c = 0;
      int m;
      if (!this.e) {
        m = -1;
      } else {
        m = 19;
      }
      this.k = m;
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte4 = this.l;
      byte[] arrayOfByte2 = this.a;
      byte[] arrayOfByte6 = 0;
      int i2 = this.k;
      int m = paramInt2 + paramInt1;
      int i4 = -1;
      switch (this.c)
      {
      case 0: 
        i3 = paramInt1;
        break;
      case 1: 
        if (paramInt1 + 2 <= m)
        {
          arrayOfByte7 = (0xFF & this.j[0]) << 16;
          i3 = paramInt1 + 1;
          i4 = arrayOfByte7 | (0xFF & paramArrayOfByte[paramInt1]) << 8;
          arrayOfByte7 = i3 + 1;
          i4 |= 0xFF & paramArrayOfByte[i3];
          this.c = 0;
          i3 = arrayOfByte7;
        }
        break;
      case 2: 
        if (paramInt1 + 1 <= m) {
          break label154;
        }
      }
      int i3 = paramInt1;
      break label205;
      label154:
      byte[] arrayOfByte7 = (0xFF & this.j[0]) << 16 | (0xFF & this.j[1]) << 8;
      i3 = paramInt1 + 1;
      i4 = arrayOfByte7 | 0xFF & paramArrayOfByte[paramInt1];
      this.c = 0;
      label205:
      if (i4 != -1)
      {
        arrayOfByte2[arrayOfByte6] = arrayOfByte4[(0x3F & i4 >> 18)];
        arrayOfByte2[1] = arrayOfByte4[(0x3F & i4 >> 12)];
        arrayOfByte2[2] = arrayOfByte4[(0x3F & i4 >> 6)];
        arrayOfByte6 = 4;
        arrayOfByte2[3] = arrayOfByte4[(i4 & 0x3F)];
        i2--;
        if (i2 == 0)
        {
          if (!this.f)
          {
            i2 = arrayOfByte6;
          }
          else
          {
            i2 = 5;
            arrayOfByte2[arrayOfByte6] = 13;
          }
          arrayOfByte6 = i2 + 1;
          arrayOfByte2[i2] = 10;
          i2 = 19;
          arrayOfByte6 = arrayOfByte6;
        }
      }
      for (;;)
      {
        byte[] arrayOfByte3;
        byte[] arrayOfByte5;
        if (i3 + 3 > m)
        {
          int n;
          if (!paramBoolean)
          {
            if (i3 != m - 1)
            {
              if (i3 == m - 2)
              {
                byte[] arrayOfByte1 = this.j;
                int i1 = this.c;
                this.c = (i1 + 1);
                arrayOfByte1[i1] = paramArrayOfByte[i3];
                arrayOfByte1 = this.j;
                i1 = this.c;
                this.c = (i1 + 1);
                arrayOfByte1[i1] = paramArrayOfByte[(i3 + 1)];
              }
            }
            else
            {
              arrayOfByte3 = this.j;
              n = this.c;
              this.c = (n + 1);
              arrayOfByte3[n] = paramArrayOfByte[i3];
            }
          }
          else
          {
            int i5;
            if (i3 - this.c != n - 1)
            {
              if (i3 - this.c != n - 2)
              {
                if ((this.e) && (arrayOfByte6 > 0) && (i2 != 19))
                {
                  if (!this.f)
                  {
                    arrayOfByte4 = arrayOfByte6;
                  }
                  else
                  {
                    arrayOfByte5 = arrayOfByte6 + 1;
                    arrayOfByte3[arrayOfByte6] = 13;
                  }
                  arrayOfByte6 = arrayOfByte5 + 1;
                  arrayOfByte3[arrayOfByte5] = 10;
                }
              }
              else
              {
                if (this.c <= 1)
                {
                  arrayOfByte7 = i3 + 1;
                  i4 = paramArrayOfByte[i3];
                  i3 = arrayOfByte7;
                  arrayOfByte7 = 0;
                }
                else
                {
                  byte[] arrayOfByte8 = this.j;
                  arrayOfByte7 = 1;
                  i5 = arrayOfByte8[0];
                }
                i5 = (i5 & 0xFF) << 10;
                byte[] arrayOfByte11;
                int i8;
                if (this.c <= 0)
                {
                  arrayOfByte11 = i3 + 1;
                  int i7 = paramArrayOfByte[i3];
                  i3 = arrayOfByte11;
                }
                else
                {
                  byte[] arrayOfByte10 = this.j;
                  arrayOfByte11 = arrayOfByte7 + 1;
                  i8 = arrayOfByte10[arrayOfByte7];
                  arrayOfByte7 = arrayOfByte11;
                }
                i5 |= (i8 & 0xFF) << 2;
                this.c -= arrayOfByte7;
                arrayOfByte7 = arrayOfByte6 + 1;
                arrayOfByte3[arrayOfByte6] = arrayOfByte5[(0x3F & i5 >> 12)];
                arrayOfByte6 = arrayOfByte7 + 1;
                arrayOfByte3[arrayOfByte7] = arrayOfByte5[(0x3F & i5 >> 6)];
                arrayOfByte7 = arrayOfByte6 + 1;
                arrayOfByte3[arrayOfByte6] = arrayOfByte5[(i5 & 0x3F)];
                if (!this.d)
                {
                  arrayOfByte5 = arrayOfByte7;
                }
                else
                {
                  arrayOfByte5 = arrayOfByte7 + 1;
                  arrayOfByte3[arrayOfByte7] = 61;
                }
                if (this.e)
                {
                  if (this.f)
                  {
                    arrayOfByte6 = arrayOfByte5 + 1;
                    arrayOfByte3[arrayOfByte5] = 13;
                    arrayOfByte5 = arrayOfByte6;
                  }
                  arrayOfByte6 = arrayOfByte5 + 1;
                  arrayOfByte3[arrayOfByte5] = 10;
                  arrayOfByte5 = arrayOfByte6;
                }
                arrayOfByte6 = arrayOfByte5;
              }
            }
            else
            {
              if (this.c <= 0)
              {
                arrayOfByte7 = i3 + 1;
                i5 = paramArrayOfByte[i3];
                i3 = arrayOfByte7;
                arrayOfByte7 = 0;
              }
              else
              {
                byte[] arrayOfByte9 = this.j;
                arrayOfByte7 = 1;
                i6 = arrayOfByte9[0];
                i3 = i3;
              }
              int i6 = (i6 & 0xFF) << 4;
              this.c -= arrayOfByte7;
              arrayOfByte7 = arrayOfByte6 + 1;
              arrayOfByte3[arrayOfByte6] = arrayOfByte5[(0x3F & i6 >> 6)];
              arrayOfByte6 = arrayOfByte7 + 1;
              arrayOfByte3[arrayOfByte7] = arrayOfByte5[(i6 & 0x3F)];
              if (this.d)
              {
                arrayOfByte5 = arrayOfByte6 + 1;
                arrayOfByte3[arrayOfByte6] = 61;
                arrayOfByte6 = arrayOfByte5 + 1;
                arrayOfByte3[arrayOfByte5] = 61;
              }
              if (this.e)
              {
                if (this.f)
                {
                  arrayOfByte5 = arrayOfByte6 + 1;
                  arrayOfByte3[arrayOfByte6] = 13;
                  arrayOfByte6 = arrayOfByte5;
                }
                arrayOfByte5 = arrayOfByte6 + 1;
                arrayOfByte3[arrayOfByte6] = 10;
                arrayOfByte6 = arrayOfByte5;
              }
              i3 = i3;
              arrayOfByte6 = arrayOfByte6;
            }
            if ((!g) && (this.c != 0)) {
              break label1064;
            }
            if ((!g) && (i3 != n)) {
              break label1056;
            }
          }
          this.b = arrayOfByte6;
          this.k = i2;
          return true;
          label1056:
          throw new AssertionError();
          label1064:
          throw new AssertionError();
        }
        arrayOfByte7 = (0xFF & paramArrayOfByte[i3]) << 16 | (0xFF & paramArrayOfByte[(i3 + 1)]) << 8 | 0xFF & paramArrayOfByte[(i3 + 2)];
        arrayOfByte3[arrayOfByte6] = arrayOfByte5[(0x3F & arrayOfByte7 >> 18)];
        arrayOfByte3[(arrayOfByte6 + 1)] = arrayOfByte5[(0x3F & arrayOfByte7 >> 12)];
        arrayOfByte3[(arrayOfByte6 + 2)] = arrayOfByte5[(0x3F & arrayOfByte7 >> 6)];
        arrayOfByte3[(arrayOfByte6 + 3)] = arrayOfByte5[(arrayOfByte7 & 0x3F)];
        i3 += 3;
        arrayOfByte6 += 4;
        i2 -= 1;
        if (i2 != 0)
        {
          i2 = i2;
          arrayOfByte6 = arrayOfByte6;
        }
        else
        {
          if (!this.f)
          {
            i2 = arrayOfByte6;
          }
          else
          {
            i2 = arrayOfByte6 + 1;
            arrayOfByte3[arrayOfByte6] = 13;
          }
          arrayOfByte6 = i2 + 1;
          arrayOfByte3[i2] = 10;
          i2 = 19;
          arrayOfByte6 = arrayOfByte6;
        }
      }
    }
  }
  
  public static class b
    extends c.a
  {
    private static final int[] c;
    private static final int[] d;
    private int e;
    private int f;
    private final int[] g;
    
    static
    {
      int[] arrayOfInt = new int[256];
      arrayOfInt[0] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[4] = -1;
      arrayOfInt[5] = -1;
      arrayOfInt[6] = -1;
      arrayOfInt[7] = -1;
      arrayOfInt[8] = -1;
      arrayOfInt[9] = -1;
      arrayOfInt[10] = -1;
      arrayOfInt[11] = -1;
      arrayOfInt[12] = -1;
      arrayOfInt[13] = -1;
      arrayOfInt[14] = -1;
      arrayOfInt[15] = -1;
      arrayOfInt[16] = -1;
      arrayOfInt[17] = -1;
      arrayOfInt[18] = -1;
      arrayOfInt[19] = -1;
      arrayOfInt[20] = -1;
      arrayOfInt[21] = -1;
      arrayOfInt[22] = -1;
      arrayOfInt[23] = -1;
      arrayOfInt[24] = -1;
      arrayOfInt[25] = -1;
      arrayOfInt[26] = -1;
      arrayOfInt[27] = -1;
      arrayOfInt[28] = -1;
      arrayOfInt[29] = -1;
      arrayOfInt[30] = -1;
      arrayOfInt[31] = -1;
      arrayOfInt[32] = -1;
      arrayOfInt[33] = -1;
      arrayOfInt[34] = -1;
      arrayOfInt[35] = -1;
      arrayOfInt[36] = -1;
      arrayOfInt[37] = -1;
      arrayOfInt[38] = -1;
      arrayOfInt[39] = -1;
      arrayOfInt[40] = -1;
      arrayOfInt[41] = -1;
      arrayOfInt[42] = -1;
      arrayOfInt[43] = 62;
      arrayOfInt[44] = -1;
      arrayOfInt[45] = -1;
      arrayOfInt[46] = -1;
      arrayOfInt[47] = 63;
      arrayOfInt[48] = 52;
      arrayOfInt[49] = 53;
      arrayOfInt[50] = 54;
      arrayOfInt[51] = 55;
      arrayOfInt[52] = 56;
      arrayOfInt[53] = 57;
      arrayOfInt[54] = 58;
      arrayOfInt[55] = 59;
      arrayOfInt[56] = 60;
      arrayOfInt[57] = 61;
      arrayOfInt[58] = -1;
      arrayOfInt[59] = -1;
      arrayOfInt[60] = -1;
      arrayOfInt[61] = -2;
      arrayOfInt[62] = -1;
      arrayOfInt[63] = -1;
      arrayOfInt[64] = -1;
      arrayOfInt[65] = 0;
      arrayOfInt[66] = 1;
      arrayOfInt[67] = 2;
      arrayOfInt[68] = 3;
      arrayOfInt[69] = 4;
      arrayOfInt[70] = 5;
      arrayOfInt[71] = 6;
      arrayOfInt[72] = 7;
      arrayOfInt[73] = 8;
      arrayOfInt[74] = 9;
      arrayOfInt[75] = 10;
      arrayOfInt[76] = 11;
      arrayOfInt[77] = 12;
      arrayOfInt[78] = 13;
      arrayOfInt[79] = 14;
      arrayOfInt[80] = 15;
      arrayOfInt[81] = 16;
      arrayOfInt[82] = 17;
      arrayOfInt[83] = 18;
      arrayOfInt[84] = 19;
      arrayOfInt[85] = 20;
      arrayOfInt[86] = 21;
      arrayOfInt[87] = 22;
      arrayOfInt[88] = 23;
      arrayOfInt[89] = 24;
      arrayOfInt[90] = 25;
      arrayOfInt[91] = -1;
      arrayOfInt[92] = -1;
      arrayOfInt[93] = -1;
      arrayOfInt[94] = -1;
      arrayOfInt[95] = -1;
      arrayOfInt[96] = -1;
      arrayOfInt[97] = 26;
      arrayOfInt[98] = 27;
      arrayOfInt[99] = 28;
      arrayOfInt[100] = 29;
      arrayOfInt[101] = 30;
      arrayOfInt[102] = 31;
      arrayOfInt[103] = 32;
      arrayOfInt[104] = 33;
      arrayOfInt[105] = 34;
      arrayOfInt[106] = 35;
      arrayOfInt[107] = 36;
      arrayOfInt[108] = 37;
      arrayOfInt[109] = 38;
      arrayOfInt[110] = 39;
      arrayOfInt[111] = 40;
      arrayOfInt[112] = 41;
      arrayOfInt[113] = 42;
      arrayOfInt[114] = 43;
      arrayOfInt[115] = 44;
      arrayOfInt[116] = 45;
      arrayOfInt[117] = 46;
      arrayOfInt[118] = 47;
      arrayOfInt[119] = 48;
      arrayOfInt[120] = 49;
      arrayOfInt[121] = 50;
      arrayOfInt[122] = 51;
      arrayOfInt[123] = -1;
      arrayOfInt[124] = -1;
      arrayOfInt[125] = -1;
      arrayOfInt[126] = -1;
      arrayOfInt[127] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[' '] = -1;
      arrayOfInt['¡'] = -1;
      arrayOfInt['¢'] = -1;
      arrayOfInt['£'] = -1;
      arrayOfInt['¤'] = -1;
      arrayOfInt['¥'] = -1;
      arrayOfInt['¦'] = -1;
      arrayOfInt['§'] = -1;
      arrayOfInt['¨'] = -1;
      arrayOfInt['©'] = -1;
      arrayOfInt['ª'] = -1;
      arrayOfInt['«'] = -1;
      arrayOfInt['¬'] = -1;
      arrayOfInt['­'] = -1;
      arrayOfInt['®'] = -1;
      arrayOfInt['¯'] = -1;
      arrayOfInt['°'] = -1;
      arrayOfInt['±'] = -1;
      arrayOfInt['²'] = -1;
      arrayOfInt['³'] = -1;
      arrayOfInt['´'] = -1;
      arrayOfInt['µ'] = -1;
      arrayOfInt['¶'] = -1;
      arrayOfInt['·'] = -1;
      arrayOfInt['¸'] = -1;
      arrayOfInt['¹'] = -1;
      arrayOfInt['º'] = -1;
      arrayOfInt['»'] = -1;
      arrayOfInt['¼'] = -1;
      arrayOfInt['½'] = -1;
      arrayOfInt['¾'] = -1;
      arrayOfInt['¿'] = -1;
      arrayOfInt['À'] = -1;
      arrayOfInt['Á'] = -1;
      arrayOfInt['Â'] = -1;
      arrayOfInt['Ã'] = -1;
      arrayOfInt['Ä'] = -1;
      arrayOfInt['Å'] = -1;
      arrayOfInt['Æ'] = -1;
      arrayOfInt['Ç'] = -1;
      arrayOfInt['È'] = -1;
      arrayOfInt['É'] = -1;
      arrayOfInt['Ê'] = -1;
      arrayOfInt['Ë'] = -1;
      arrayOfInt['Ì'] = -1;
      arrayOfInt['Í'] = -1;
      arrayOfInt['Î'] = -1;
      arrayOfInt['Ï'] = -1;
      arrayOfInt['Ð'] = -1;
      arrayOfInt['Ñ'] = -1;
      arrayOfInt['Ò'] = -1;
      arrayOfInt['Ó'] = -1;
      arrayOfInt['Ô'] = -1;
      arrayOfInt['Õ'] = -1;
      arrayOfInt['Ö'] = -1;
      arrayOfInt['×'] = -1;
      arrayOfInt['Ø'] = -1;
      arrayOfInt['Ù'] = -1;
      arrayOfInt['Ú'] = -1;
      arrayOfInt['Û'] = -1;
      arrayOfInt['Ü'] = -1;
      arrayOfInt['Ý'] = -1;
      arrayOfInt['Þ'] = -1;
      arrayOfInt['ß'] = -1;
      arrayOfInt['à'] = -1;
      arrayOfInt['á'] = -1;
      arrayOfInt['â'] = -1;
      arrayOfInt['ã'] = -1;
      arrayOfInt['ä'] = -1;
      arrayOfInt['å'] = -1;
      arrayOfInt['æ'] = -1;
      arrayOfInt['ç'] = -1;
      arrayOfInt['è'] = -1;
      arrayOfInt['é'] = -1;
      arrayOfInt['ê'] = -1;
      arrayOfInt['ë'] = -1;
      arrayOfInt['ì'] = -1;
      arrayOfInt['í'] = -1;
      arrayOfInt['î'] = -1;
      arrayOfInt['ï'] = -1;
      arrayOfInt['ð'] = -1;
      arrayOfInt['ñ'] = -1;
      arrayOfInt['ò'] = -1;
      arrayOfInt['ó'] = -1;
      arrayOfInt['ô'] = -1;
      arrayOfInt['õ'] = -1;
      arrayOfInt['ö'] = -1;
      arrayOfInt['÷'] = -1;
      arrayOfInt['ø'] = -1;
      arrayOfInt['ù'] = -1;
      arrayOfInt['ú'] = -1;
      arrayOfInt['û'] = -1;
      arrayOfInt['ü'] = -1;
      arrayOfInt['ý'] = -1;
      arrayOfInt['þ'] = -1;
      arrayOfInt['ÿ'] = -1;
      c = arrayOfInt;
      arrayOfInt = new int[256];
      arrayOfInt[0] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[4] = -1;
      arrayOfInt[5] = -1;
      arrayOfInt[6] = -1;
      arrayOfInt[7] = -1;
      arrayOfInt[8] = -1;
      arrayOfInt[9] = -1;
      arrayOfInt[10] = -1;
      arrayOfInt[11] = -1;
      arrayOfInt[12] = -1;
      arrayOfInt[13] = -1;
      arrayOfInt[14] = -1;
      arrayOfInt[15] = -1;
      arrayOfInt[16] = -1;
      arrayOfInt[17] = -1;
      arrayOfInt[18] = -1;
      arrayOfInt[19] = -1;
      arrayOfInt[20] = -1;
      arrayOfInt[21] = -1;
      arrayOfInt[22] = -1;
      arrayOfInt[23] = -1;
      arrayOfInt[24] = -1;
      arrayOfInt[25] = -1;
      arrayOfInt[26] = -1;
      arrayOfInt[27] = -1;
      arrayOfInt[28] = -1;
      arrayOfInt[29] = -1;
      arrayOfInt[30] = -1;
      arrayOfInt[31] = -1;
      arrayOfInt[32] = -1;
      arrayOfInt[33] = -1;
      arrayOfInt[34] = -1;
      arrayOfInt[35] = -1;
      arrayOfInt[36] = -1;
      arrayOfInt[37] = -1;
      arrayOfInt[38] = -1;
      arrayOfInt[39] = -1;
      arrayOfInt[40] = -1;
      arrayOfInt[41] = -1;
      arrayOfInt[42] = -1;
      arrayOfInt[43] = -1;
      arrayOfInt[44] = -1;
      arrayOfInt[45] = 62;
      arrayOfInt[46] = -1;
      arrayOfInt[47] = -1;
      arrayOfInt[48] = 52;
      arrayOfInt[49] = 53;
      arrayOfInt[50] = 54;
      arrayOfInt[51] = 55;
      arrayOfInt[52] = 56;
      arrayOfInt[53] = 57;
      arrayOfInt[54] = 58;
      arrayOfInt[55] = 59;
      arrayOfInt[56] = 60;
      arrayOfInt[57] = 61;
      arrayOfInt[58] = -1;
      arrayOfInt[59] = -1;
      arrayOfInt[60] = -1;
      arrayOfInt[61] = -2;
      arrayOfInt[62] = -1;
      arrayOfInt[63] = -1;
      arrayOfInt[64] = -1;
      arrayOfInt[65] = 0;
      arrayOfInt[66] = 1;
      arrayOfInt[67] = 2;
      arrayOfInt[68] = 3;
      arrayOfInt[69] = 4;
      arrayOfInt[70] = 5;
      arrayOfInt[71] = 6;
      arrayOfInt[72] = 7;
      arrayOfInt[73] = 8;
      arrayOfInt[74] = 9;
      arrayOfInt[75] = 10;
      arrayOfInt[76] = 11;
      arrayOfInt[77] = 12;
      arrayOfInt[78] = 13;
      arrayOfInt[79] = 14;
      arrayOfInt[80] = 15;
      arrayOfInt[81] = 16;
      arrayOfInt[82] = 17;
      arrayOfInt[83] = 18;
      arrayOfInt[84] = 19;
      arrayOfInt[85] = 20;
      arrayOfInt[86] = 21;
      arrayOfInt[87] = 22;
      arrayOfInt[88] = 23;
      arrayOfInt[89] = 24;
      arrayOfInt[90] = 25;
      arrayOfInt[91] = -1;
      arrayOfInt[92] = -1;
      arrayOfInt[93] = -1;
      arrayOfInt[94] = -1;
      arrayOfInt[95] = 63;
      arrayOfInt[96] = -1;
      arrayOfInt[97] = 26;
      arrayOfInt[98] = 27;
      arrayOfInt[99] = 28;
      arrayOfInt[100] = 29;
      arrayOfInt[101] = 30;
      arrayOfInt[102] = 31;
      arrayOfInt[103] = 32;
      arrayOfInt[104] = 33;
      arrayOfInt[105] = 34;
      arrayOfInt[106] = 35;
      arrayOfInt[107] = 36;
      arrayOfInt[108] = 37;
      arrayOfInt[109] = 38;
      arrayOfInt[110] = 39;
      arrayOfInt[111] = 40;
      arrayOfInt[112] = 41;
      arrayOfInt[113] = 42;
      arrayOfInt[114] = 43;
      arrayOfInt[115] = 44;
      arrayOfInt[116] = 45;
      arrayOfInt[117] = 46;
      arrayOfInt[118] = 47;
      arrayOfInt[119] = 48;
      arrayOfInt[120] = 49;
      arrayOfInt[121] = 50;
      arrayOfInt[122] = 51;
      arrayOfInt[123] = -1;
      arrayOfInt[124] = -1;
      arrayOfInt[125] = -1;
      arrayOfInt[126] = -1;
      arrayOfInt[127] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[' '] = -1;
      arrayOfInt['¡'] = -1;
      arrayOfInt['¢'] = -1;
      arrayOfInt['£'] = -1;
      arrayOfInt['¤'] = -1;
      arrayOfInt['¥'] = -1;
      arrayOfInt['¦'] = -1;
      arrayOfInt['§'] = -1;
      arrayOfInt['¨'] = -1;
      arrayOfInt['©'] = -1;
      arrayOfInt['ª'] = -1;
      arrayOfInt['«'] = -1;
      arrayOfInt['¬'] = -1;
      arrayOfInt['­'] = -1;
      arrayOfInt['®'] = -1;
      arrayOfInt['¯'] = -1;
      arrayOfInt['°'] = -1;
      arrayOfInt['±'] = -1;
      arrayOfInt['²'] = -1;
      arrayOfInt['³'] = -1;
      arrayOfInt['´'] = -1;
      arrayOfInt['µ'] = -1;
      arrayOfInt['¶'] = -1;
      arrayOfInt['·'] = -1;
      arrayOfInt['¸'] = -1;
      arrayOfInt['¹'] = -1;
      arrayOfInt['º'] = -1;
      arrayOfInt['»'] = -1;
      arrayOfInt['¼'] = -1;
      arrayOfInt['½'] = -1;
      arrayOfInt['¾'] = -1;
      arrayOfInt['¿'] = -1;
      arrayOfInt['À'] = -1;
      arrayOfInt['Á'] = -1;
      arrayOfInt['Â'] = -1;
      arrayOfInt['Ã'] = -1;
      arrayOfInt['Ä'] = -1;
      arrayOfInt['Å'] = -1;
      arrayOfInt['Æ'] = -1;
      arrayOfInt['Ç'] = -1;
      arrayOfInt['È'] = -1;
      arrayOfInt['É'] = -1;
      arrayOfInt['Ê'] = -1;
      arrayOfInt['Ë'] = -1;
      arrayOfInt['Ì'] = -1;
      arrayOfInt['Í'] = -1;
      arrayOfInt['Î'] = -1;
      arrayOfInt['Ï'] = -1;
      arrayOfInt['Ð'] = -1;
      arrayOfInt['Ñ'] = -1;
      arrayOfInt['Ò'] = -1;
      arrayOfInt['Ó'] = -1;
      arrayOfInt['Ô'] = -1;
      arrayOfInt['Õ'] = -1;
      arrayOfInt['Ö'] = -1;
      arrayOfInt['×'] = -1;
      arrayOfInt['Ø'] = -1;
      arrayOfInt['Ù'] = -1;
      arrayOfInt['Ú'] = -1;
      arrayOfInt['Û'] = -1;
      arrayOfInt['Ü'] = -1;
      arrayOfInt['Ý'] = -1;
      arrayOfInt['Þ'] = -1;
      arrayOfInt['ß'] = -1;
      arrayOfInt['à'] = -1;
      arrayOfInt['á'] = -1;
      arrayOfInt['â'] = -1;
      arrayOfInt['ã'] = -1;
      arrayOfInt['ä'] = -1;
      arrayOfInt['å'] = -1;
      arrayOfInt['æ'] = -1;
      arrayOfInt['ç'] = -1;
      arrayOfInt['è'] = -1;
      arrayOfInt['é'] = -1;
      arrayOfInt['ê'] = -1;
      arrayOfInt['ë'] = -1;
      arrayOfInt['ì'] = -1;
      arrayOfInt['í'] = -1;
      arrayOfInt['î'] = -1;
      arrayOfInt['ï'] = -1;
      arrayOfInt['ð'] = -1;
      arrayOfInt['ñ'] = -1;
      arrayOfInt['ò'] = -1;
      arrayOfInt['ó'] = -1;
      arrayOfInt['ô'] = -1;
      arrayOfInt['õ'] = -1;
      arrayOfInt['ö'] = -1;
      arrayOfInt['÷'] = -1;
      arrayOfInt['ø'] = -1;
      arrayOfInt['ù'] = -1;
      arrayOfInt['ú'] = -1;
      arrayOfInt['û'] = -1;
      arrayOfInt['ü'] = -1;
      arrayOfInt['ý'] = -1;
      arrayOfInt['þ'] = -1;
      arrayOfInt['ÿ'] = -1;
      d = arrayOfInt;
    }
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      int[] arrayOfInt;
      if ((paramInt & 0x8) != 0) {
        arrayOfInt = d;
      } else {
        arrayOfInt = c;
      }
      this.g = arrayOfInt;
      this.e = 0;
      this.f = 0;
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.e != 6)
      {
        int k = paramInt2 + paramInt1;
        int j = this.e;
        int[] arrayOfInt2 = this.f;
        i = 0;
        byte[] arrayOfByte = this.a;
        int[] arrayOfInt1 = this.g;
        int[] arrayOfInt4 = paramInt1;
        if (arrayOfInt4 >= k) {
          arrayOfInt1 = arrayOfInt2;
        } else if (j != 0) {}
        for (;;)
        {
          if (arrayOfInt4 + 4 <= k)
          {
            arrayOfInt2 = arrayOfInt1[(0xFF & paramArrayOfByte[arrayOfInt4])] << 18 | arrayOfInt1[(0xFF & paramArrayOfByte[(arrayOfInt4 + 1)])] << 12 | arrayOfInt1[(0xFF & paramArrayOfByte[(arrayOfInt4 + 2)])] << 6 | arrayOfInt1[(0xFF & paramArrayOfByte[(arrayOfInt4 + 3)])];
            if (arrayOfInt2 >= 0) {}
          }
          else
          {
            if (arrayOfInt4 < k)
            {
              int[] arrayOfInt3 = arrayOfInt4 + 1;
              arrayOfInt4 = arrayOfInt1[(0xFF & paramArrayOfByte[arrayOfInt4])];
              switch (j)
              {
              case 0: 
                if (arrayOfInt4 < 0)
                {
                  if (arrayOfInt4 != -1)
                  {
                    this.e = 6;
                    i = 0;
                    break label764;
                  }
                }
                else
                {
                  j += 1;
                  arrayOfInt2 = arrayOfInt4;
                }
                break;
              case 1: 
                if (arrayOfInt4 < 0)
                {
                  if (arrayOfInt4 != -1)
                  {
                    this.e = 6;
                    i = 0;
                    break label764;
                  }
                }
                else
                {
                  arrayOfInt2 = arrayOfInt4 | arrayOfInt2 << 6;
                  j += 1;
                }
                break;
              case 2: 
                if (arrayOfInt4 < 0)
                {
                  if (arrayOfInt4 != -2)
                  {
                    if (arrayOfInt4 != -1)
                    {
                      this.e = 6;
                      i = 0;
                      break label764;
                    }
                  }
                  else
                  {
                    arrayOfInt4 = i + 1;
                    arrayOfByte[i] = ((byte)(arrayOfInt2 >> 4));
                    j = 4;
                    i = arrayOfInt4;
                    break label526;
                  }
                }
                else
                {
                  arrayOfInt2 = arrayOfInt4 | arrayOfInt2 << 6;
                  j += 1;
                }
                break;
              case 3: 
                if (arrayOfInt4 < 0)
                {
                  if (arrayOfInt4 != -2)
                  {
                    if (arrayOfInt4 != -1)
                    {
                      this.e = 6;
                      i = 0;
                      break label764;
                    }
                  }
                  else
                  {
                    arrayOfByte[(i + 1)] = ((byte)(arrayOfInt2 >> 2));
                    arrayOfByte[i] = ((byte)(arrayOfInt2 >> 10));
                    i += 2;
                    j = 5;
                    break label526;
                  }
                }
                else
                {
                  arrayOfInt2 = arrayOfInt4 | arrayOfInt2 << 6;
                  arrayOfByte[(i + 2)] = ((byte)arrayOfInt2);
                  arrayOfByte[(i + 1)] = ((byte)(arrayOfInt2 >> 8));
                  arrayOfByte[i] = ((byte)(arrayOfInt2 >> 16));
                  i += 3;
                  j = 0;
                }
                break;
              case 4: 
                if (arrayOfInt4 != -2)
                {
                  if (arrayOfInt4 != -1)
                  {
                    this.e = 6;
                    i = 0;
                    break label764;
                  }
                }
                else {
                  j += 1;
                }
                break;
              case 5: 
                if (arrayOfInt4 != -1) {
                  break label537;
                }
              }
              j = j;
              label526:
              j = j;
              arrayOfInt4 = arrayOfInt3;
              break;
              label537:
              this.e = 6;
              i = 0;
              break label764;
            }
            arrayOfInt1 = arrayOfInt2;
            if (paramBoolean)
            {
              switch (j)
              {
              case 1: 
                this.e = 6;
                i = 0;
                break;
              case 2: 
                arrayOfInt2 = i + 1;
                arrayOfByte[i] = ((byte)(arrayOfInt1 >> 4));
                i = arrayOfInt2;
                break;
              case 3: 
                arrayOfInt2 = i + 1;
                arrayOfByte[i] = ((byte)(arrayOfInt1 >> 10));
                i = arrayOfInt2 + 1;
                arrayOfByte[arrayOfInt2] = ((byte)(arrayOfInt1 >> 2));
              case 0: 
              default: 
                this.e = j;
                this.b = i;
                i = 1;
                break;
              }
              this.e = 6;
              i = 0;
              break label764;
            }
            this.e = j;
            this.f = arrayOfInt1;
            this.b = i;
            i = 1;
            break label764;
          }
          arrayOfByte[(i + 2)] = ((byte)arrayOfInt2);
          arrayOfByte[(i + 1)] = ((byte)(arrayOfInt2 >> 8));
          arrayOfByte[i] = ((byte)(arrayOfInt2 >> 16));
          i += 3;
          arrayOfInt4 += 4;
        }
      }
      int i = 0;
      label764:
      return i;
    }
  }
  
  public static abstract class a
  {
    public byte[] a;
    public int b;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.util.c
 * JD-Core Version:    0.7.0.1
 */