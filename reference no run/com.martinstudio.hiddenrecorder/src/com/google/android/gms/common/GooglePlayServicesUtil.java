package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R.string;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hf;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.iq;
import java.io.UnsupportedEncodingException;

public final class GooglePlayServicesUtil
{
  static final byte[][] CS;
  static final byte[][] CT;
  static final byte[][] CU;
  static final byte[][] CV;
  static final byte[][] CW;
  static final byte[][] CX;
  static final byte[][] CY;
  static final byte[][] CZ;
  private static final byte[][] Da;
  private static final byte[][] Db;
  public static boolean Dc = false;
  public static boolean Dd = false;
  private static int De = -1;
  private static final Object Df = new Object();
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 5077000;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  static
  {
    Object localObject = new byte[2][];
    localObject[0] = au("0\004C0\003+ \003\002\001\002\002\t��ÂàFdJ00\r\006\t*H÷\r\001\001\004\005��0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\036\027\r080821231334Z\027\r360107231334Z0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��«V.��Ø;¢\b®\no\022N)Ú\021ò«VÐXâÌ©\023\003é·TÓrö@§\033\035Ë\023\tgbNFV§wj\031=²å¿·$©\036w\030\016jG¤;3Ù`w\0301EÌß{.XftÉáV[\037LjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\025Jd_qhÀ±¿Æ\022ê¿xWi»4ªyÜ~.¢vL®\007ØÁqT×î_d¥\032D¦\002ÂI\005AWÜ\002Í_\\\016Uûï\031ûã'ð±Q\026Å o\031ÑõÄÛÂÖ¹?hÌ)yÇ\016\030«k;ÕÛU*\016;LßXûíÁº5à\003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\013\024[j¡y\002\001\003£Ù0Ö0\035\006\003U\035\016\004\026\004\024Ç}Â!\027V%Óßkãä×¥0¦\006\003U\035#\0040\024Ç}Â!\027V%Óßkãä×¥¡x¤v0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android\t��ÂàFdJ00\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005��\003\001\001��mÒRÎï0,6\nªÎÏòÌ©\004»]z\026aø®F²B\004ÐÿJhÇí\032S\036ÄYZb<æ\007c±g)zzãW\022Ä\007ò\bðË\020)\022M{\020b\031ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\005»?âËD~s\020v­E³?`\tê\031Áaæ&Aª'\035ýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\013\020q§Ä@ðþ \034¶'ÊgCiÐ½/Ù\021ÿ\006Í¿,ú\020Ü\017:ãWbHÇïÆLqD\027B÷\005ÉÞW:õ[9\r×ý¹A1]_u0\021&ÿb\024\020Ài0");
    localObject[1] = au("0\004¨0\003 \003\002\001\002\002\t��Õ¸l}ÓNõ0\r\006\t*H÷\r\001\001\004\005��01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\036\027\r080415233656Z\027\r350901233656Z01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��ÖÎ.\b\n¿â1MÑ³ÏÓ\030\\´=3ú\ftá½¶ÑÛ\023ö,\\9ßVøF=e¾ÀóÊBk\007Å¨íZ9ÁgçkÉ¹'K\013\"��\031©)\025årÅm*0\033£oÅü\021:ÖËt5¡m#«}úîáeäß\037\n½§\nQlN\005\021Ê|\fU\027[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\006¸Ì\030^±Uyîøm\b\013\035aÀù¯±ÂëÑ\007êE«Ûh£Ç^TÇlSÔ\013\022\035ç»Ó\016b\f\030áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\032¾^òÑ\030á¸®ó)ðf¿láD¬èm\034\033\017\002\001\003£ü0ù0\035\006\003U\035\016\004\026\004\024\034Å¾LC<a:\025°L¼\003òOà²0É\006\003U\035#\004Á0¾\024\034Å¾LC<a:\025°L¼\003òOà²¡¤01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com\t��Õ¸l}ÓNõ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005��\003\001\001��\031Ó\fñ\005ûx?L\r}Ò##=@zÏÎ��\b\035[×ÆéÖí k\016\021 \006Al¢D\023ÒkJ àõ$ÊÒ»\\nL¡\001j\025n¡ì]ÉZ^:\001��6ôHÕ\020¿.\036ag:;åm¯\013w±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\0319u3¯Øª\026\017BÂÐ\026>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\022þû¤Ä#ûOøÌIL\002ðõ\005\026\022ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\0035iÞ;¿ÿ|©Ú>\022Cö\013");
    CS = (byte[][])localObject;
    localObject = new byte[2][];
    localObject[0] = au("0\002R0\001»\002\004I4~0\r\006\t*H÷\r\001\001\004\005��0p1\0130\t\006\003U\004\006\023\002US1\0130\t\006\003U\004\b\023\002CA1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google, Inc1\0240\022\006\003U\004\013\023\013Google, Inc1\0200\016\006\003U\004\003\023\007Unknown0\036\027\r081202020758Z\027\r360419020758Z0p1\0130\t\006\003U\004\006\023\002US1\0130\t\006\003U\004\b\023\002CA1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google, Inc1\0240\022\006\003U\004\013\023\013Google, Inc1\0200\016\006\003U\004\003\023\007Unknown00\r\006\t*H÷\r\001\001\001\005��\003��0\002��H\003\031ù±G&8N\004SÑ\013¿Ç{%\004¤± |LlDº¼��­Æa\017¦¶«-¨\0163òîñk&£ö¸[úÊû¾³ôÉO~\"§àë§\\í=Ò)úseô\025\026AZ©Áa}ÕÎ\031ºè »Øü\027©´½&@Q!ªÛwÞ´��\0238\024\030.Å\"üX\r\002\003\001��\0010\r\006\t*H÷\r\001\001\004\005��\003��@fÖ1ÚCÝÐaÒ&às¹Ä¹øµä¾<¾P\036ß\034o©YÀÎ`\\OÒ¬m\034ÎÞ Glº±èò :ÿw\027­e-Ì\007\bÑ!m¨DWY&IàéÓÄ»Lõ¡±ÔüA¼¹XOdæ_A\r\005)ý[h\024\035\nÑÛ\021Ë*\r÷ê\f±-³¤");
    localObject[1] = au("0\004¨0\003 \003\002\001\002\002\t��~OòÖµÞ0\r\006\t*H÷\r\001\001\005\005��01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\036\027\r100120010135Z\027\r370607010135Z01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��Ø(q|6Ñ\027\017ÔM\n{\017\007\021&è[¿ß3°4`��ZÌûe¥Û ²Cß`±¿\006ß\035\\\n3âÑcõ\023ß\035\"SAê<3y\"è\\\002ì4ÎÙL¸\007#¦#ÿK¯û´åïæw;>¢¾¸¼²\002gÏçQ\037.ù«uþ\036)Ï¼M\b:\037\022R��wsò\026[i{��£ Á:Ì0ò!cÁn=J²\0246LEÀC\0242p9ñÚ\t`ñ³ü\030¶V\020Æ\"_Ç\020+|o\023¤]$ãàÅNgã[g\b'\023ÒÖðWÝ4WÑÄþÝì:O?#\005\031§\n(64¬5£J½¡}Z\n\tûø\006\013\003j'x`cú\f7¹çò¡\016v¼w\002\001\003£ü0ù0\035\006\003U\035\016\004\026\004\024µÇù\022ox\r:ûÊess?õ\"k\02770É\006\003U\035#\004Á0¾\024µÇù\022ox\r:ûÊess?õ\"k\0277¡¤01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com\t��~OòÖµÞ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��L>§e}&æ»×\021\f\031ß\037¡\t}3\017iÞ¿ÊÛF£~å³\017»4{\034uU¼»<T\024F_y*\002ÐÛå¦Ga³yG«kÿ°ºÆ¢Á Íøbøw©g\rýo\006.@nÎ\030\006\f`Iü6'\021qåoË¡Ræ\005ÎÎY\037Äô©+3ºØ\031mwoU·Ð\032Ï1Ý×\fì·xv\006e\020ùI¥RJ11³ËeAÏ5B\016¼ÄR%Y?Bfi\005rfbO³ÏÛR\027\035\021\034n\003F\026øQ!\030Ð¢¦\023×ðÍ\021ÛÕ#ZT¥JÂQçÒ,Dj?î\024\022\020éDGK@c\007»&+OkÓU\034sQÿ¢`[\005â$×\025Øzö");
    CT = (byte[][])localObject;
    localObject = new byte[1][];
    localObject[0] = au("0\002§0\002e \003\002\001\002\002\004P\005|B0\013\006\007*HÎ8\004\003\005��071\0130\t\006\003U\004\006\023\002US1\0200\016\006\003U\004\n\023\007Android1\0260\024\006\003U\004\003\023\rAndroid Debug0\036\027\r120717145250Z\027\r220715145250Z071\0130\t\006\003U\004\006\023\002US1\0200\016\006\003U\004\n\023\007Android1\0260\024\006\003U\004\003\023\rAndroid Debug0\001·0\001,\006\007*HÎ8\004\0010\001\037\002��ýS\035u\022)RßJ.ìäçö\021·R<ïD��Ã\036?¶Q&iE]@\"QûY=Xú¿Åõº0öËUl×;\0354oòf`·kP¥¤è\004{\020\"ÂO»©×þ·Æ\033ø;WçÆ¨¦\025\017\004ûöÓÅ\036Ã\0025T\023Z\0262öuó®+a×*ïò\"\003\031ÑH\001Ç\002\025��`P\025#\013Ì²¹¢ë\013ðX\034õ\002��÷á Ö=ÞË¼«\\6¸W¹y¯»ú:êùWL\013=\007gQYWºÔYOæq\007\020´I\026q#èL(\026\023·Ï\t2È¦á<\026zT|(à£®\036+³¦un£\013ú!5bñûbz\001$;Ì¤ñ¾¨Q¨ßáZå\006f^{U%d\001L;þÏI*\003��\002jÑ\033×ÕfÒzô9À.Ah¬ýE´¾¼{\034wTi?\rB¤üá\0208BO¦Ñ0RNïöñ78c/¦7)þMF ¸feîðA\0279\001\003[\034j£\030\030\r0:¨ÌY#àjo«úuh<E;²\007w|òýçÏ±\02408\024ª\035÷´=[\"+W\006´0\013\006\007*HÎ8\004\003\005��\003/��0,\002\024\tÒÑ°G\002)µ¾Ò&aÑ\022òpÅæ\035\002\024gP\002\006§Pºx®Ç\027O\026\004ê¢÷");
    CU = (byte[][])localObject;
    localObject = new byte[2][];
    localObject[0] = au("0\004L0\0034 \003\002\001\002\002\t��¨Í\027É=¥Ù0\r\006\t*H÷\r\001\001\005\005��0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\036\027\r110324010653Z\027\r380809010653Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��Ã\017­Ù´\tj,XjZ5kú\002iXøÿ\f]úõI&ØpÞè!¥>\037[\027\017ÉbE£É§ËE'\005;ã^4óÒK\"ì\fRn&teàhuêb\037ù@ã4[ I\007ÌTt:ÍªÎeV_HºtÍA!ÍÈvß5\"ºÛ\t\\ Ù4Åj>\\9>åðà/àb\037\0375¨$%,o¦¶3§hk>Ha-\006©ÏoI¿ñ\035](þ\024¬WbCÝ)êý¹\rã&5\023©\005¬¯ ~Fu\nZ·¿w&/G°?Z<nm{Q4?iÇ÷%÷\013Ì\033JÕ%\013pZæè>â®7þW\001¼½²oîýÿö\017j[ßµ¶G\002\001\003£Ü0Ù0\035\006\003U\035\016\004\026\004\024\034ÎÎ\016êMÁ\022\037ÇQ_\r\n\fràÉm0©\006\003U\035#\004¡0\024\034ÎÎ\016êMÁ\022\037ÇQ_\r\n\fràÉm¡{¤y0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC\t��¨Í\027É=¥Ù0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��¤pÇ(áÓ\033\006Ù¯jçhµe\004lWkCrI1×]L¡\f2\025 Ó<Ïí*¦Tb#Lù¶ù\020ÌgkËÖÀgcWO»x3\022uÜ\\óº©\030×\005\037û¢­èó\003ÍèÙæ\004\037Û|*I²\"ÆÿB+ñUi¸^îí°J£\bsÛæKtøòÂöÄ\001$ª¨Ñx\r\030Q+T\nÝ(³éX\031q¤\027\rØhÏ_1äG\022²Â;µ\0207×ï¦å½³^,ëk°\"cl\027¥j¼zP%\013Òí{1UZ\030E.\0272\032\rRö?t-tÿyXj\\»¯q¨KÏtC\020éé'Y��¢=Ð\006`\f\"8Ù\013/³rßÛºu½.");
    localObject[1] = au("0\004L0\0034 \003\002\001\002\002\t��Þv\004\035vPÀ0\r\006\t*H÷\r\001\001\005\005��0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\036\027\r110324010324Z\027\r380809010324Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��æÿ=ïé*¡\rqë\017¦@À6·âCîíh¦¤v=Ç¥*1u|ÚÆ\037å\020»sÇ\026ä��\001\004&[4ÎÎôÄ+ñá7Ð¨vð(\"»Áù½Õ×\023²ö©5£yÒË©ÉoÒÐx|\021ñë\031T\b¦ r³Klú\ná'gé��u0\026i¡\034ïFÎ÷Ç\004mÞ1û`(M\022\n°çÞ\035c?\007h}FQ\023ÿýÆ¼ |©\004¸¾\035 ª{NuoC`d¾\\®<hè»yBÍõ\026\007É0¢üÚe[uÐuº­\006ç9½\013¢\037@BÂÀ¨ZZ°ÐgÆÃìI! B¬c§å;Tle´`´ãæâ>\037wÏçöÞtK\032e\002\001\003£Ü0Ù0\035\006\003U\035\016\004\026\004\024¢èd°]\b\\4Û\n��P\021zì0©\006\003U\035#\004¡0\024¢èd°]\b\\4Û\n��P\021zì¡{¤y0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0230\021\006\003U\004\003\023\nGoogle NFC\t��Þv\004\035vPÀ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��7q\fè|<Rê0ÆébÙKM_\022Â]&\025AýµU]\022Îó¸1,?]ö¨ªàL¹³\005ä'ý\035-\031áÒxñ<R\017\030!\002cØÔ½6QHØØº&Ø¹¿\tõý>»\016£ÂðÉ7o\036\037Êvó¦¤\005B\b\033u*z·Vé«DÚA«ÈáèøÂu§CûsæPqW\fËkzÝ!¹ÆäVá,\"=\\\007JßUö«Ú&-dê\nEîÍ´\022~uÇSÃÿ0ËÆxµ\034R\024rñ}¢\n\rÆ'J¢F44Á©¶\024ßi}õÊ\001ç¢\\}³û\005]eV\004°\0358«ºW³¡p>ÂçJÓ4");
    CV = (byte[][])localObject;
    localObject = new byte[2][];
    localObject[0] = au("0\005a0\003K\002\006\001DÓ0\013\006\t*H÷\r\001\001\0050v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0220\020\006\003U\004\003\023\tClockWork0\036\027\r140307220225Z\027\r380119031407Z0v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0220\020\006\003U\004\003\023\tClockWork0\002\"0\r\006\t*H÷\r\001\001\001\005��\003\002\017��0\002\n\002\002\001��º<9\013þYb¼ü<Æ'Z\025íÜÝ7:Uj\013âýC÷\030³\001Ò@'ãr\tÎýâ|&° Þ6}\032ßãN§®7óõà&rzN\b(;ïvøöC¼\025'6 H?É·«R<ó½{f-*'L��Øç\021è°&_í©uÜÈåB\023jbq.\013/9yQÛ$±W¡¿çÅkÎJ8\013%ú¹&c>¨\0048à¶\013¹~.ú\005<2)Ùao¤½!{7C\037ÍØí!§òðFà\034¼ZbãJ\025káZ\027ÿ\002\027dDÖ\023±\036×_\030î´ýäZã\034ä¯¤68¶,\\ÒÛ\n\001Ä2a(äÅ\031z¾¬ÌmÂè­¤B_\017Õ¥¥X$a¿x\021á.Î\016ê\006\003?T9íàqÿÄl òß¾##:dÁÎ\t­¡ËÎkö¼¢.JÀÉjluOì\030qØ{\020Á Þ`¼}wÞ0ÕN¸GÎk\022|\031\036§o\nFÁFó6¹4êºZ_\034\003d·RUD2Pýcªå{ë«à&?\t\bM\031D\006\f:Ù»ºyôÞ<+-7º³\rK¹\021ÜQià¯RôÓ=³òË\034R\002Rpa¿\001°BÐ~ä\021©ª 'ðDÚ(ÅÝØSW§\0369»Q³Wëor\030üÌ\027\030¦0gF1àU9\032zgòZ b\001Ö\"¸Ð\tÝ\021Õ\006¢\003\017$'®gØ\03347yy\002\003\001��\0010\013\006\t*H÷\r\001\001\005\003\002\001��¤Ä4aÈ5¥±\nÍ\001$7jÚ'C¬0\003Hg\013 +­ã?/º*\007d\003µ\013èqÊ*²¾½»Ä\006Û\t9AÉ\027j\016Fÿÿ��\026\026\004DnÜá0þ\020\036ã\005·~=©¢­4©Ò´Ú\033&ýZ[p\034Õlþédzä\024;¦|\002e±\024ò2¥ï\027ád¡I\027\0340½Z6«øóBÈã¯¼oICs\007}j\021×9\"\rZ×µ\031/\034þJr±¸Tuàé¾hrfe±+ôîÃ\"VTõáò+ëU¾fwÖ_\t-ù^þï\017ÇêÊ]\016¾\035A\004\037ç Ë20~9.\023ñ 9Ti0\002\027@-öÇ rçß8ºÃ×\"5oæTj|WßgÉ=+5T5ðù¡\023Î-ìÍm¡ÃKAì®Ö ëR0%Åà\004ì´Q¼EáHZÌ6¶I¯YLU\033\013É8ËÖ\032ÕgY ÷:eá©È¤Û¬\036ë\f)\t^ÞA\005{<®êN\026Å¹EKâY\021´¢\037?z¿Àgô\030.A¤ä4ð/í¯WrJU3WÚ_³ÍüùTÿØÉQwçu\004¦B¾\\Û á��eü|h\022í'³¨\004×¤ÍÙ\fÓìË\005¨È`ÐV N´\036\005ý9\\\037§{³\035¥$4^\n½N\001µ\006OêºBÓ-Ôg>ÏÀ\027\035&éÍ\\FïÐ");
    localObject[1] = au("0\003¿0\002§ \003\002\001\002\002\t��ÚÃÙ\025sÓï0\r\006\t*H÷\r\001\001\005\005��0v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0220\020\006\003U\004\003\f\tClockWork0\036\027\r140307220118Z\027\r410723220118Z0v1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0220\020\006\003U\004\003\f\tClockWork0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��Ü\035oK(í80\024²öÚÿÓ\035Þ{\036c\b@e\013X±e£j®¶,qS.\004E\t¯\037ºO\030dÃ§µÖSÌ��\025��\020áåfú7ªÿ\0306]®{JÝ±óÌGp¢>bþµrÁi1Z¯Nôê¥®\037ÍÖçåêÔ1\023tFF\f|(û2,\\\\z¨wÃp?à·~¶ n¬krê ­!\n°*\037ÜüvbttA©?<ê\026ô\"Áã2A2~ÂÉ÷01.\033ïî)\013E\0324,¬ï[\024rÖÙ~ùT(ÌÕï\004¸Äñõ\rÒBÕ]rXfP[^K\033\036Y­\035/ H\025g;ÆæC)ìÄêÔÛd©k1ÛÉ\007\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024G\020¤<³êø?«!b ��Î,z0\037\006\003U\035#\004\0300\026\024G\020¤<³êø?«!b ��Î,z0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��\0079b\013¢}*\017TC­\033`\034)Ù\001(êü?Ö(__bj>ðWæî²¬\\¢æ\005Ê=3õk��2ÄGæP\017%½\027Êù\0039@ÈîlÜµ;íä±òHçÐ çÊê¥2ÏÚþJ¥í@@ND÷[ïÒÊÛ5¸²\033xF^\027\"òzû+\013n\025DÄ«\fOe{\031×}SÉÏ¹î-OE¶Tà\022¼éäÂâÃÓQ\003Ø®M,ÁÈbxW®u?\035{\002£§\005xÆ\005ã\005\034l\035©I\032Î\023»Ð}}Ô&Q®¤G5\rë@^ò«óf®/ÊXÒö¿\035¿K\034Hà \001TßÏ\002%\022õ¡Ç\"s\035ãðGÖø");
    CW = (byte[][])localObject;
    localObject = new byte[2][];
    localObject[0] = au("0\003m0\002W\002\006\001=døÖ³0\013\006\t*H÷\r\001\001\0050|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0250\023\006\003U\004\n\023\fGoogle, Inc.1\0200\016\006\003U\004\013\023\007GoogleX1\0270\025\006\003U\004\003\023\016Glass Platform0\036\027\r130313181742Z\027\r380119031407Z0|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0250\023\006\003U\004\n\023\fGoogle, Inc.1\0200\016\006\003U\004\013\023\007GoogleX1\0270\025\006\003U\004\003\023\016Glass Platform0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��¡3¦Òi¯Ø6ã®Ü-¤­9¿øâ\031æH3´\030µ=5lì\024¸GF´\013ß\036B¡þôÑõ×B\fÀØ+çÚe\tÄ¯?ÛÎ/PTïìçA©éRZ\023#\003ÿÎ\025D¦9»ÊØt¯ ¼¼õ\026öYÚ7Á­/è£ÄZæ\036Ê¨W¢\005C9í¿oð@nÂA½\buqc).s©)\004ù=ìk½@c¼¥>y¸©Cp|¹üA;X\0170ðGE´õ7­§æ\032ÿüw\013NÓ<><ttb\036z­Ôw­\005ÜuL\r3\rÁXõæáõ¢`<Q&¬Bô\030Û xF)à\r§ë\0065ÙºGµE\fZ¢dØ/\002\003\001��\0010\013\006\t*H÷\r\001\001\005\003\001\001��è\025JôØôu°ã[ðÒR\006c\bLÏÑr%éKþÁJ\037¾7ErpÀÿVöVÁPéË¹Ùl\034;\013¡æ<êõÔæ«C*Ü±\023Wòc´èÍ®Ð¼p}ó\026í.©¶VxÔMþíä/°#¯cc±NSÄB²+ø«À¿i\005÷ó[(\022Kæc\035F\f9_5éu«FÞ\f?ß0Ï\017\007ÙE­}Ç¨d;ICà.&[\020tÕùKùXìÚúªoÅ¾¨Ìfý!»²nÏeéø.µ{gìÁéx·Ú'\027æÖ\035ç¦l!¿ÂY¶ÞÉ½zµòÓÛÅ\023\005ÚÚ¨ïâ)<¢\027:ì#\b`pNwÉÀ¦b0§");
    localObject[1] = au("0\003É0\002± \003\002\001\002\002\t��Ãi ­ßtÇ0\r\006\t*H÷\r\001\001\005\005��0|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0250\023\006\003U\004\n\f\fGoogle, Inc.1\0200\016\006\003U\004\013\f\007GoogleX1\0270\025\006\003U\004\003\f\016Glass Platform0\036\027\r130226205628Z\027\r400714205628Z0|1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0250\023\006\003U\004\n\f\fGoogle, Inc.1\0200\016\006\003U\004\013\f\007GoogleX1\0270\025\006\003U\004\003\f\016Glass Platform0\001 0\r\006\t*H÷\r\001\001\001\005��\003\001\r��0\001\b\002\001\001��¯ÊGêäÐ;\036\bà\tw¢ø\006Æ¢\027\035í§[pâ:¢ñ¹¿h¥/?v,¾Æ:\bÑBZÃ\033é2m\001\036|\006Î¡ÈJëp?Ð9*1\006²}\004^|áT\004K\"Ê¥\035[õù±$â\"ºsA-ÔY0h,Fg1°Y¯¦¤èÝ?^µ@øº\021](G@)×\0371å»°ê^0 äuµ¤ý4\027\nÔ.ØPë9T,+éµm5þ¶²¨4iúKæ+È¤|è��\003l®ðõ3sÉX\025¸ÊÙs[¿·��eh¾mæw\020-E¿¶9z:\037\001%¸\025\005\005·«ÝÂ`\037~ñXÕ(á­;pmhE\017%:\023íyÀ\002l¨\023\021ÕËß·\002\001\003£P0N0\035\006\003U\035\016\004\026\004\024óSB\037\017Í{#j_µ\037fWc\031Ð{0\037\006\003U\035#\004\0300\026\024óSB\037\017Í{#j_µ\037fWc\031Ð{0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��©X±/\007ï\024}CÅ=ÂÉèá\001¥b\bfF¼\004·\035÷yxÜ!/ü|\003ú¯Y%;èõ2Â_]uºæïº´XRp(hk\001B'¥A·C§³/4Ñ[Yô \025X%ý¼ì>ÒtÎìÇ\001Ë«[Ug\"3wn÷ä´â\001R\016FÕEI\\\024Ày­}\037ýã¢±Ê\033Q[ +7[÷/6\017ó-­`S:Ú×Å~#dRE¥ºÊÊBTý!³d!_\004vòéI\031÷W \023Xv\nF!î\003UÙ»@h\017Úó±¨f\004+Ë@3àw,Öãª\036 Æñ\002\004úå[£áÙßëÔ@Uü\007¨æ­;Ô\0217ö/_f£÷\030$õO({Úø?");
    CX = (byte[][])localObject;
    localObject = new byte[2][];
    localObject[0] = au("0\003Á0\002© \003\002\001\002\002\t��é\005DY+P0\r\006\t*H÷\r\001\001\005\005��0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\036\027\r140527043400Z\027\r411012043400Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��Ðuk\027*HI*Õî>r~ë`\"¬Ø\b»W\fECÚCÄaåçb\034\005\n]ç¢½\017\f\002`ÿâr]ØHH$\032\006îf¬+ýáÞ\r\tEWËÇ\"ne¿)\035\017å-¨ÑRg7ìj\016.7ù³ÎÓÓÙå°\tªYÛ!VÈÊ#u´\034fö9\n-\016\016IÁxt\tÀÙ%_ËÅY\022\033Oòâ-±ât\032��ÚIYôan­\016\022mÀKeðï\017¼BzÔ2ÏOïM:d`ÊÄ÷rXê-è½@¿\007ó?`]}Wf¾z!òJ',ªX¥9\\Íÿ&}\013Ôò~D-É¼ÄJ\024dW§:J½!_w\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024³ÌD*Ûè6xð[4q4¬c\036` 0\037\006\003U\035#\004\0300\026\024³ÌD*Ûè6xð[4q4¬c\036` 0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��+ù\033qéèî\002[Ué<â¨R\027%¡ª\031\020Bï­6¸) É\033'\037ãûiD3\023gú¦&¤â(\035ì¥ßÌÝ\003ÆBªñ{tÜ&ü^P½OLââ\033kûìë\033ÝpåÿÈ[þ²A\031D'3ôÐÚMc<^¾å\n\037\024?E£ÏÎ@®ÐaÕ+\007¹b¼fÑ_>ÔùÖÆH²\0218ÊúþvôÜ»å\"¢l.Õ\b¦·\táW*P¯SÑ\006:\0271½\027i[GÙ¡4!g.\fp\034ÊÎ¶\026g5.IaÁ\f×JD6y+6N5³\020 _+\024²hsbK7èi:\034´í3oVáØ zé\002³>9\016Q²Ê4@\"");
    localObject[1] = au("0\003Á0\002© \003\002\001\002\002\t��ÐTãÎÛÎ\0040\r\006\t*H÷\r\001\001\005\005��0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\036\027\r140603192622Z\027\r411019192622Z0w1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\0230\021\006\003U\004\003\f\nmediashell0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��µ\037{°ìÎp4cÎÓ\0354r¬¶©£õ?ßÐæ#ð={4]\037õ\"Øízeå3´â>ñ@k}Õ\024h\035>vÎÐe\005óM#\021_��WG6I-hÏ|¶Ø|§uÂeÞ!\037­pg\bø¯1,í3.Çgb\bà/{í{4f¡2\005tu²gm¸q\034và;Ì7¤c\005(#ä_*rN8'\020&\007oTÂéÈ¹ÿ#Az/Èµ s®\t_\036«ÜJÎzó%\003s\003d\022Ôñó,(Lâ¾ý_öèÃ\021äÎ\033TgHûý¡ãß0¦ø,ä¥ËÕ*?ò\025s:°ÈKz\030ïQlÐá¯°\017\b­\037\006ÿ2é;©\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024§L:À:o°\núúÉ×@(\\ «\0200\037\006\003U\035#\004\0300\026\024§L:À:o°\núúÉ×@(\\ «\0200\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001�� >dBCQ¼>Y_Ôà¥\n=-à\"s7��KÌ;7|yê²¬\031íÎ]$<W2¤sóPh9��þÖd\006Î\bÈ\023&Ò\023ÔûÃ%ßkøê»¹\033<.a°ÚtFS`sj\037H-Ét;â÷a\024\030èCY]\032\032¶¡-ÐvÆ}L#ª\017×°ñ\bã;÷\037En·RÃº\007öÐ{¤Wß\001t²\b§¡^ÉD#n[ÔØ7\001Ý_\f  r8bø\002aÈ4r9¤\013Í\020\017\f(âÏ*~º#%o_¬$f#\017§Ï}ÆâDD\020\017Ý¾)Áí|G\0200ïV\006ý\005Ç`\027¥¯ð2Sh¯\001£ ÷\017O\r��+E\026¨4ÚÌ\tÍq6");
    CY = (byte[][])localObject;
    localObject = new byte[2][];
    localObject[0] = au("0\003µ0\002 \003\002\001\002\002\t��å×\027Ît¡0\r\006\t*H÷\r\001\001\005\005��0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\036\027\r140529162639Z\027\r411014162639Z0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��¾¡ÀW\037¸\f]xw#T\021;\003b\032ÖrV&-.-hI°\021ÑùK7ký\027üÞ7¤ÿ\021+*?/Rn\013ïæÅÌÃBátÑ2Ã$_{ó\030U'ï²-µ\016¿yËò3ÝÚ1K\004»Íò|è/75ì$e\\Ô+/5®JRÍ¢îtÒ+ÛR\023SègZÉ¸ýR®\031ªªo^ë_Ùºs³b &©hÔÂnW'f\017p®A\031/v;=pUV1*ý\037\n`Öþ\021úR¦\022: Î3A$ýÆ\n~*z6yÛ£=ø\"´\007mÊº»«ÎÛ\034&Ë\001ëÏÂ\023fð\0330\016µHÊñ\005xÆ\r:kihR\\x<\003Ý\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024Â¸ç\001Að\nà\013\\\006?Mnú\007p¦0\037\006\003U\035#\004\0300\026\024Â¸ç\001Að\nà\013\\\006?Mnú\007p¦0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��H¡LÏsf¦\005óS\003,P\020$Ze%\020Å)@ìÛ¾_Ü} Ý4­Ò\033ÏVðÂ-Ã9þI\023:ûÐÂ!£í_rEå!9¼\022VwòI2í34·|«­\025F\022tN¼\030Ý&Cóc#UHÌ^Á?JqxP?c÷\0176C@ùc7]ÈÉ=úzO'ÂØZîý¬¢¹Ï\013q¤\rrþAÌ\004d¯,1\bì|\006Uõ«Ò«¢UáÍY\"³v·Kº\033\005[Ç×¶ó' §Òõ ¼\003çµn+Û'¦ð)qG\025$ éÑDÀþåÎ¢)ß\b-ù\0207p��uî<èÀÎ\\\003¹5Óý\025v\005Fl");
    localObject[1] = au("0\003µ0\002 \003\002\001\002\002\t��åo\t\033\0370\r\006\t*H÷\r\001\001\005\005��0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\036\027\r140529162612Z\027\r411014162612Z0q1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\f\nCalifornia1\0260\024\006\003U\004\007\f\rMountain View1\0240\022\006\003U\004\n\f\013Google Inc.1\0200\016\006\003U\004\013\f\007Android1\r0\013\006\003U\004\003\f\004nova0\001\"0\r\006\t*H÷\r\001\001\001\005��\003\001\017��0\001\n\002\001\001��Ä_Uº4\\Ñ@_IÚÏ96Ör\017Ë6áMÚÿ��ß[rÂÑN­ÌdÑþÈ/ðLÂ®Öæ¤ÑKc\037ØÖ\030]à\020A\024\036w\tUñq­«*­ÉV94O+úzQ×ëÜ.Îñh~¶\036\001ÀñI?\003Tj\032­­$\\÷22ZÿZ·À\033\t\001a~\022\036\025»Æ{(WiËZ6+6¦2s§\001y ë@QÅ¦@ùvTOo\025Á»À\\®r&.t#2¡ßK°ð;àU·6TÛ?óú)°ÔÍZË=§Äø~jü\033Yy\t·\025Å\"eÖÃh,æ\025E­ê)å­ÎçWà¯\002õx\r©\030Z9\030-#G\002\003\001��\001£P0N0\035\006\003U\035\016\004\026\004\024à»øÁWûã»ùfÉä;¤Ü\004'\nõH0\037\006\003U\035#\004\0300\026\024à»øÁWûã»ùfÉä;¤Ü\004'\nõH0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\005\005��\003\001\001��îÅô/jêâ6\035ðÇÕ\bQér\026eàF��ÅøÌ×^64Ì õÅÓ2»gÖà­\025k\003oímÒ[\036h¿7åiå[vN\f\031\027¾\035Ï¿|\t\016Q¿¯\006\004¬\031Ï×@åøväj'½ü¾¦·®\036 Up\035\"0\005ì ½Àþz\021a¤Û}Ñ\027ë\024th¾Ø(¬JbåîW·5Â\022¿ò^tòIJ\nZÖ8Y½\feóÍÒDN±*\024Å¸\n*Ý×{\006ÓqÌ·Î¢«S:\037z[(S4é\020 ó²EÜkÊ¦Ä,Ë(;ìá/1Û\024t%KPIÙ\027yÍ#}ò¦*b£\bÜ?Ñ7$gÍ`q");
    CZ = (byte[][])localObject;
    localObject = new byte[8][][];
    localObject[0] = CS;
    localObject[1] = CT;
    localObject[2] = CU;
    localObject[3] = CV;
    localObject[4] = CW;
    localObject[5] = CX;
    localObject[6] = CY;
    localObject[7] = CZ;
    Da = a((byte[][][])localObject);
    localObject = new byte[7][];
    localObject[0] = CS[0];
    localObject[1] = CT[0];
    localObject[2] = CV[0];
    localObject[3] = CW[0];
    localObject[4] = CX[0];
    localObject[5] = CY[0];
    localObject[6] = CZ[0];
    Db = (byte[][])localObject;
  }
  
  public static Intent Z(int paramInt)
  {
    Intent localIntent;
    switch (paramInt)
    {
    default: 
      localIntent = null;
      break;
    case 1: 
    case 2: 
      localIntent = hf.aD("com.google.android.gms");
      break;
    case 3: 
      localIntent = hf.aB("com.google.android.gms");
      break;
    case 12: 
      localIntent = hf.fv();
    }
    return localIntent;
  }
  
  private static Dialog a(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (iq.ga())
    {
      localObject1 = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, (TypedValue)localObject1, true);
      if ("Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(((TypedValue)localObject1).resourceId))) {}
    }
    else
    {
      localObject1 = null;
      break label65;
    }
    Object localObject1 = new AlertDialog.Builder(paramActivity, 5);
    label65:
    if (localObject1 == null) {
      localObject1 = new AlertDialog.Builder(paramActivity);
    }
    ((AlertDialog.Builder)localObject1).setMessage(d(paramActivity, paramInt1));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject1).setOnCancelListener(paramOnCancelListener);
    }
    Object localObject2 = c(paramActivity, paramInt1);
    ha localha;
    if (paramFragment != null) {
      localha = new ha(paramFragment, (Intent)localObject2, paramInt2);
    } else {
      localha = new ha(paramActivity, (Intent)localObject2, paramInt2);
    }
    localObject2 = e(paramActivity, paramInt1);
    if (localObject2 != null) {
      ((AlertDialog.Builder)localObject1).setPositiveButton((CharSequence)localObject2, localha);
    }
    switch (paramInt1)
    {
    default: 
      Log.e("GooglePlayServicesUtil", "Unexpected error code " + paramInt1);
      localObject1 = ((AlertDialog.Builder)localObject1).create();
      break;
    case 0: 
      localObject1 = null;
      break;
    case 1: 
      localObject1 = ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_install_title).create();
      break;
    case 2: 
      localObject1 = ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_update_title).create();
      break;
    case 3: 
      localObject1 = ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_enable_title).create();
      break;
    case 4: 
    case 6: 
      localObject1 = ((AlertDialog.Builder)localObject1).create();
      break;
    case 5: 
      Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
      localObject1 = ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_invalid_account_title).create();
      break;
    case 7: 
      Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
      localObject1 = ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_network_error_title).create();
      break;
    case 8: 
      Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
      localObject1 = ((AlertDialog.Builder)localObject1).create();
      break;
    case 9: 
      Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
      localObject1 = ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_unsupported_title).create();
      break;
    case 10: 
      Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
      localObject1 = ((AlertDialog.Builder)localObject1).create();
      break;
    case 11: 
      Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
      localObject1 = ((AlertDialog.Builder)localObject1).create();
      break;
    case 12: 
      Log.e("GooglePlayServicesUtil", "The date of the device is not valid.");
      localObject1 = ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_unsupported_title).create();
    }
    return localObject1;
  }
  
  public static boolean a(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramPackageInfo != null) {
      if (!c(paramPackageManager))
      {
        if (a(paramPackageInfo, Db) != null) {
          bool1 = bool2;
        }
        if ((!bool1) && (a(paramPackageInfo, Da) != null)) {
          Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
        }
      }
      else
      {
        if (a(paramPackageInfo, Da) == null) {
          bool2 = false;
        }
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public static boolean a(Resources paramResources)
  {
    boolean bool = false;
    if (paramResources != null)
    {
      int i;
      if ((0xF & paramResources.getConfiguration().screenLayout) <= 3) {
        i = 0;
      } else {
        i = 1;
      }
      if (((iq.fX()) && (i != 0)) || (b(paramResources))) {
        bool = true;
      }
    }
    return bool;
  }
  
  /* Error */
  private static byte[] a(PackageInfo paramPackageInfo, byte[]... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 307
    //   3: invokestatic 313	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 319	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   11: arraylength
    //   12: iconst_1
    //   13: if_icmpeq +31 -> 44
    //   16: ldc 208
    //   18: ldc_w 321
    //   21: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: aconst_null
    //   26: astore_2
    //   27: aload_2
    //   28: areturn
    //   29: pop
    //   30: ldc 208
    //   32: ldc_w 323
    //   35: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aconst_null
    //   40: astore_2
    //   41: goto -14 -> 27
    //   44: aload_0
    //   45: getfield 319	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   48: iconst_0
    //   49: aaload
    //   50: invokevirtual 329	android/content/pm/Signature:toByteArray	()[B
    //   53: astore_2
    //   54: new 331	java/io/ByteArrayInputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 334	java/io/ByteArrayInputStream:<init>	([B)V
    //   62: astore 4
    //   64: aload_3
    //   65: aload 4
    //   67: invokevirtual 338	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   70: checkcast 340	java/security/cert/X509Certificate
    //   73: astore_3
    //   74: aload_3
    //   75: invokevirtual 343	java/security/cert/X509Certificate:checkValidity	()V
    //   78: iconst_0
    //   79: istore 4
    //   81: iload 4
    //   83: aload_1
    //   84: arraylength
    //   85: if_icmpge +72 -> 157
    //   88: aload_1
    //   89: iload 4
    //   91: aaload
    //   92: astore_3
    //   93: aload_3
    //   94: aload_2
    //   95: invokestatic 348	java/util/Arrays:equals	([B[B)Z
    //   98: ifeq +53 -> 151
    //   101: aload_3
    //   102: astore_2
    //   103: goto -76 -> 27
    //   106: pop
    //   107: ldc 208
    //   109: ldc_w 350
    //   112: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aconst_null
    //   117: astore_2
    //   118: goto -91 -> 27
    //   121: pop
    //   122: ldc 208
    //   124: ldc_w 352
    //   127: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aconst_null
    //   132: astore_2
    //   133: goto -106 -> 27
    //   136: pop
    //   137: ldc 208
    //   139: ldc_w 354
    //   142: invokestatic 283	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   145: pop
    //   146: aconst_null
    //   147: astore_2
    //   148: goto -121 -> 27
    //   151: iinc 4 1
    //   154: goto -73 -> 81
    //   157: ldc 208
    //   159: iconst_2
    //   160: invokestatic 358	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   163: ifeq +33 -> 196
    //   166: ldc 208
    //   168: new 210	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 360
    //   178: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_2
    //   182: iconst_0
    //   183: invokestatic 366	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   186: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 369	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: aconst_null
    //   197: astore_2
    //   198: goto -171 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramPackageInfo	PackageInfo
    //   0	201	1	paramVarArgs	byte[][]
    //   26	172	2	localObject1	Object
    //   6	96	3	localObject2	Object
    //   62	4	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   79	73	4	i	int
    //   29	1	6	localCertificateException1	java.security.cert.CertificateException
    //   106	1	7	localCertificateException2	java.security.cert.CertificateException
    //   121	1	8	localCertificateExpiredException	java.security.cert.CertificateExpiredException
    //   136	1	9	localCertificateNotYetValidException	java.security.cert.CertificateNotYetValidException
    // Exception table:
    //   from	to	target	type
    //   0	7	29	java/security/cert/CertificateException
    //   64	74	106	java/security/cert/CertificateException
    //   74	78	121	java/security/cert/CertificateExpiredException
    //   74	78	136	java/security/cert/CertificateNotYetValidException
  }
  
  private static byte[][] a(byte[][]... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      byte[][] arrayOfByte;
      if (j >= k)
      {
        byte[][] arrayOfByte1 = new byte[i][];
        int m = paramVarArgs.length;
        i = 0;
        int n = 0;
        if (i >= m) {
          return arrayOfByte1;
        }
        arrayOfByte = paramVarArgs[i];
        int i1 = n;
        n = 0;
        for (;;)
        {
          if (n >= arrayOfByte.length)
          {
            i++;
            n = i1;
            break;
          }
          int i2 = i1 + 1;
          arrayOfByte1[i1] = arrayOfByte[n];
          n++;
          i1 = i2;
        }
      }
      i += paramVarArgs[arrayOfByte].length;
      arrayOfByte++;
    }
  }
  
  private static byte[] au(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO-8859-1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }
  
  public static boolean b(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    boolean bool = false;
    Dialog localDialog = a(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    if (localDialog == null) {}
    for (;;)
    {
      return bool;
      try
      {
        bool = paramActivity instanceof FragmentActivity;
        label28:
        if (bool)
        {
          android.support.v4.app.FragmentManager localFragmentManager = ((FragmentActivity)paramActivity).getSupportFragmentManager();
          SupportErrorDialogFragment.newInstance(localDialog, paramOnCancelListener).show(localFragmentManager, "GooglePlayServicesErrorDialog");
        }
        for (;;)
        {
          int i = 1;
          break;
          if (!iq.fX()) {
            break label91;
          }
          android.app.FragmentManager localFragmentManager1 = paramActivity.getFragmentManager();
          ErrorDialogFragment.newInstance(localDialog, paramOnCancelListener).show(localFragmentManager1, "GooglePlayServicesErrorDialog");
        }
        label91:
        throw new RuntimeException("This Activity does not support Fragments.");
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        break label28;
      }
    }
  }
  
  public static boolean b(PackageManager paramPackageManager)
  {
    int i;
    for (boolean bool = true;; i = 0) {
      synchronized (Df)
      {
        int j = De;
        if (j == -1) {}
        try
        {
          PackageInfo localPackageInfo = paramPackageManager.getPackageInfo("com.google.android.gms", 64);
          byte[][] arrayOfByte = new byte[1][];
          arrayOfByte[0] = Da[1];
          if (a(localPackageInfo, arrayOfByte) != null) {}
          for (De = 1; De != 0; De = 0) {
            return bool;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            De = 0;
          }
        }
      }
    }
  }
  
  public static boolean b(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo = paramPackageManager.getPackageInfo(paramString, 64);
      bool = a(paramPackageManager, localPackageInfo);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
          Log.d("GooglePlayServicesUtil", "Package manager can't find package " + paramString + ", defaulting to false");
        }
        boolean bool = false;
      }
    }
    return bool;
  }
  
  private static boolean b(Resources paramResources)
  {
    boolean bool = false;
    Configuration localConfiguration = paramResources.getConfiguration();
    if ((iq.fZ()) && ((0xF & localConfiguration.screenLayout) <= 3) && (localConfiguration.smallestScreenWidthDp >= 600)) {
      bool = true;
    }
    return bool;
  }
  
  @Deprecated
  public static Intent c(Context paramContext, int paramInt)
  {
    return Z(paramInt);
  }
  
  public static boolean c(PackageManager paramPackageManager)
  {
    boolean bool;
    if ((!b(paramPackageManager)) && (et())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static String d(Context paramContext, int paramInt)
  {
    Object localObject = paramContext.getResources();
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    default: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_unknown_issue);
      break;
    case 1: 
      if (!a(paramContext.getResources())) {
        localObject = ((Resources)localObject).getString(R.string.common_google_play_services_install_text_phone);
      } else {
        localObject = ((Resources)localObject).getString(R.string.common_google_play_services_install_text_tablet);
      }
      break;
    case 2: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_update_text);
      break;
    case 3: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_enable_text);
      break;
    case 5: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_invalid_account_text);
      break;
    case 7: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_network_error_text);
      break;
    case 9: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_unsupported_text);
      break;
    case 12: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_unsupported_date_text);
    }
    return localObject;
  }
  
  public static String e(Context paramContext, int paramInt)
  {
    Object localObject = paramContext.getResources();
    switch (paramInt)
    {
    default: 
      localObject = ((Resources)localObject).getString(17039370);
      break;
    case 1: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_install_button);
      break;
    case 2: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_update_button);
      break;
    case 3: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_enable_button);
    }
    return localObject;
  }
  
  public static boolean et()
  {
    boolean bool;
    if (!Dc) {
      bool = "user".equals(Build.TYPE);
    } else {
      bool = Dd;
    }
    return bool;
  }
  
  public static String f(Context paramContext, int paramInt)
  {
    Object localObject = paramContext.getResources();
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    default: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_unknown_issue);
      break;
    case 1: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_notification_needs_installation_title);
      break;
    case 2: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_notification_needs_update_title);
      break;
    case 3: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_needs_enabling_title);
      break;
    case 5: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_invalid_account_text);
      break;
    case 7: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_network_error_text);
      break;
    case 9: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_unsupported_text);
      break;
    case 12: 
      localObject = ((Resources)localObject).getString(R.string.common_google_play_services_unsupported_date_text);
    }
    return localObject;
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    Object localObject = c(paramContext, paramInt1);
    if (localObject != null) {
      localObject = PendingIntent.getActivity(paramContext, paramInt2, (Intent)localObject, 268435456);
    } else {
      localObject = null;
    }
    return localObject;
  }
  
  public static String getErrorString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "UNKNOWN_ERROR_CODE";
      break;
    case 0: 
      str = "SUCCESS";
      break;
    case 1: 
      str = "SERVICE_MISSING";
      break;
    case 2: 
      str = "SERVICE_VERSION_UPDATE_REQUIRED";
      break;
    case 3: 
      str = "SERVICE_DISABLED";
      break;
    case 4: 
      str = "SIGN_IN_REQUIRED";
      break;
    case 5: 
      str = "INVALID_ACCOUNT";
      break;
    case 6: 
      str = "RESOLUTION_REQUIRED";
      break;
    case 7: 
      str = "NETWORK_ERROR";
      break;
    case 8: 
      str = "INTERNAL_ERROR";
      break;
    case 9: 
      str = "SERVICE_INVALID";
      break;
    case 10: 
      str = "DEVELOPER_ERROR";
      break;
    case 11: 
      str = "LICENSE_CHECK_FAILED";
      break;
    case 12: 
      str = "DATE_INVALID";
    }
    return str;
  }
  
  /* Error */
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    // Byte code:
    //   0: new 565	android/net/Uri$Builder
    //   3: dup
    //   4: invokespecial 566	android/net/Uri$Builder:<init>	()V
    //   7: ldc_w 568
    //   10: invokevirtual 572	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   13: ldc 30
    //   15: invokevirtual 575	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   18: ldc_w 577
    //   21: invokevirtual 580	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   24: ldc_w 582
    //   27: invokevirtual 580	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   30: invokevirtual 586	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   33: astore_1
    //   34: aload_0
    //   35: invokevirtual 590	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: aload_1
    //   39: invokevirtual 596	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   42: astore_1
    //   43: new 598	java/util/Scanner
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 601	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   51: ldc_w 603
    //   54: invokevirtual 607	java/util/Scanner:useDelimiter	(Ljava/lang/String;)Ljava/util/Scanner;
    //   57: invokevirtual 610	java/util/Scanner:next	()Ljava/lang/String;
    //   60: astore_2
    //   61: aload_2
    //   62: astore_2
    //   63: aload_1
    //   64: ifnull +36 -> 100
    //   67: aload_1
    //   68: invokevirtual 615	java/io/InputStream:close	()V
    //   71: goto +29 -> 100
    //   74: pop
    //   75: aload_1
    //   76: ifnull +26 -> 102
    //   79: aload_1
    //   80: invokevirtual 615	java/io/InputStream:close	()V
    //   83: goto +19 -> 102
    //   86: astore_2
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 615	java/io/InputStream:close	()V
    //   95: aload_2
    //   96: athrow
    //   97: pop
    //   98: aconst_null
    //   99: astore_2
    //   100: aload_2
    //   101: areturn
    //   102: aconst_null
    //   103: astore_2
    //   104: goto -4 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramContext	Context
    //   33	59	1	localObject1	Object
    //   60	3	2	str1	String
    //   86	10	2	localObject2	Object
    //   99	5	2	str2	String
    //   74	1	5	localNoSuchElementException	java.util.NoSuchElementException
    //   97	1	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   43	61	74	java/util/NoSuchElementException
    //   43	61	86	finally
    //   34	43	97	java/lang/Exception
    //   67	97	97	java/lang/Exception
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      localContext = paramContext.createPackageContext("com.google.android.gms", 3);
      localContext = localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Context localContext = null;
      }
    }
    return localContext;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      localResources = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      localResources = localResources;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Resources localResources = null;
      }
    }
    return localResources;
  }
  
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    int i = 9;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if (System.currentTimeMillis() < 1227312000288L)
      {
        i = 12;
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        continue;
        x(paramContext);
        Object localObject1;
        Object localObject2;
        try
        {
          localObject1 = localPackageManager.getPackageInfo("com.google.android.gms", 64);
          if (!ij.aD(((PackageInfo)localObject1).versionCode)) {
            break label343;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          try
          {
            localObject2 = localPackageManager.getPackageInfo(paramContext.getPackageName(), 64);
            if (et()) {
              break label234;
            }
            arrayOfByte = new byte[2][];
            arrayOfByte[0] = CS[1];
            arrayOfByte[1] = CX[1];
            if (a((PackageInfo)localObject1, arrayOfByte) != null) {
              break label161;
            }
            Log.w("GooglePlayServicesUtil", "Google Play services signature (test key) invalid on Glass.");
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException3)
          {
            Log.w("GooglePlayServicesUtil", "Calling package info missing.");
          }
          localNameNotFoundException2;
          Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
          i = 1;
        }
        continue;
        continue;
        label161:
        byte[][] arrayOfByte = new byte[2][];
        arrayOfByte[0] = CS[1];
        arrayOfByte[1] = CX[1];
        if (a((PackageInfo)localObject2, arrayOfByte) == null)
        {
          Log.w("GooglePlayServicesUtil", "Calling package " + ((PackageInfo)localObject2).packageName + " signature (test key) invalid on Glass.");
          continue;
          label234:
          arrayOfByte = new byte[2][];
          arrayOfByte[0] = CS[0];
          arrayOfByte[1] = CX[0];
          if (a((PackageInfo)localObject1, arrayOfByte) == null)
          {
            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid (release key) on Glass.");
            continue;
          }
          arrayOfByte = new byte[1][];
          arrayOfByte[0] = CX[0];
          label422:
          if (a((PackageInfo)localObject2, arrayOfByte) == null)
          {
            Log.w("GooglePlayServicesUtil", "Calling package " + ((PackageInfo)localObject2).packageName + " signature (release key) invalid on Glass.");
            continue;
            label343:
            if (ij.C(paramContext))
            {
              if (a((PackageInfo)localObject1, CS) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
              }
            }
            else
            {
              try
              {
                localObject2 = localPackageManager.getPackageInfo("com.android.vending", 64);
                localObject2 = a((PackageInfo)localObject2, CS);
                if (localObject2 != null) {
                  break label422;
                }
                Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
              }
              catch (PackageManager.NameNotFoundException localNameNotFoundException4)
              {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
              }
              continue;
              arrayOfByte = new byte[1][];
              arrayOfByte[0] = localObject2;
              if (a((PackageInfo)localObject1, arrayOfByte) == null)
              {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                continue;
              }
            }
          }
        }
        i = ij.aB(5077000);
        if (ij.aB(((PackageInfo)localObject1).versionCode) < i)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 5077000 but found " + ((PackageInfo)localObject1).versionCode);
          i = 2;
        }
        else
        {
          try
          {
            localObject1 = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
            if (((ApplicationInfo)localObject1).enabled) {
              break label545;
            }
            i = 3;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException1)
          {
            Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
            localNameNotFoundException1.printStackTrace();
            i = 1;
          }
          continue;
          label545:
          i = 0;
        }
      }
    }
  }
  
  public static boolean isUserRecoverableError(int paramInt)
  {
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      break;
    case 1: 
    case 2: 
    case 3: 
    case 9: 
    case 12: 
      bool = true;
    }
    return bool;
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return b(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    Notification localNotification = new Notification(17301642, localResources.getString(R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
    localNotification.flags = (0x10 | localNotification.flags);
    String str2 = f(paramContext, paramInt);
    String str1 = y(paramContext);
    int i = R.string.common_google_play_services_error_notification_requested_by_msg;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = str1;
    localNotification.setLatestEventInfo(paramContext, str2, localResources.getString(i, arrayOfObject), getErrorPendingIntent(paramInt, paramContext, 0));
    ((NotificationManager)paramContext.getSystemService("notification")).notify(39789, localNotification);
  }
  
  public static void w(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = isGooglePlayServicesAvailable(paramContext);
    if (i == 0) {
      return;
    }
    Intent localIntent = c(paramContext, i);
    Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + i);
    if (localIntent != null) {
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", localIntent);
    }
    throw new GooglePlayServicesNotAvailableException(i);
  }
  
  private static void x(Context paramContext)
  {
    Object localObject = null;
    try
    {
      localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      localObject = localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.wtf("GooglePlayServicesUtil", "This should never happen.", localNameNotFoundException);
      }
    }
    localObject = ((ApplicationInfo)localObject).metaData;
    if (localObject != null)
    {
      int i = ((Bundle)localObject).getInt("com.google.android.gms.version");
      if (i == 5077000) {
        return;
      }
      throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 5077000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
    }
    throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  private static String y(Context paramContext)
  {
    String str = paramContext.getApplicationInfo().name;
    PackageManager localPackageManager;
    if (TextUtils.isEmpty(str))
    {
      str = paramContext.getPackageName();
      localPackageManager = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      localApplicationInfo = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      localApplicationInfo = localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        ApplicationInfo localApplicationInfo = null;
      }
    }
    if (localApplicationInfo != null) {
      str = localPackageManager.getApplicationLabel(localApplicationInfo).toString();
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * JD-Core Version:    0.7.0.1
 */