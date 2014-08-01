package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gp
  extends gh
{
  private static final long Cm = TimeUnit.HOURS.toMillis(24L);
  private static final long Cn = TimeUnit.HOURS.toMillis(24L);
  private static final long Co = TimeUnit.HOURS.toMillis(24L);
  private static final long Cp = TimeUnit.SECONDS.toMillis(1L);
  private static final String NAMESPACE = gj.al("com.google.cast.media");
  private final gs CA;
  private final gs CB;
  private final List<gs> CC = new ArrayList();
  private final Runnable CD = new a(null);
  private boolean CE;
  private long Cq;
  private MediaStatus Cr;
  private final gs Cs = new gs(Cn);
  private final gs Ct;
  private final gs Cu;
  private final gs Cv;
  private final gs Cw;
  private final gs Cx;
  private final gs Cy;
  private final gs Cz;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  
  public gp()
  {
    this(null);
  }
  
  public gp(String paramString)
  {
    super(NAMESPACE, "MediaControlChannel", paramString);
    this.CC.add(this.Cs);
    this.Ct = new gs(Cm);
    this.CC.add(this.Ct);
    this.Cu = new gs(Cm);
    this.CC.add(this.Cu);
    this.Cv = new gs(Cm);
    this.CC.add(this.Cv);
    this.Cw = new gs(Co);
    this.CC.add(this.Cw);
    this.Cx = new gs(Cm);
    this.CC.add(this.Cx);
    this.Cy = new gs(Cm);
    this.CC.add(this.Cy);
    this.Cz = new gs(Cm);
    this.CC.add(this.Cz);
    this.CA = new gs(Cm);
    this.CC.add(this.CA);
    this.CB = new gs(Cm);
    this.CC.add(this.CB);
    eo();
  }
  
  private void a(long paramLong, JSONObject paramJSONObject)
    throws JSONException
  {
    int j = 1;
    boolean bool = this.Cs.p(paramLong);
    int k;
    if ((!this.Cw.eq()) || (this.Cw.p(paramLong))) {
      k = 0;
    } else {
      k = j;
    }
    if (((!this.Cx.eq()) || (this.Cx.p(paramLong))) && ((!this.Cy.eq()) || (this.Cy.p(paramLong)))) {
      j = 0;
    }
    if (k == 0) {
      k = 0;
    } else {
      k = 2;
    }
    if (j != 0) {
      k |= 0x1;
    }
    int i;
    if ((!bool) && (this.Cr != null))
    {
      i = this.Cr.a(paramJSONObject, k);
    }
    else
    {
      this.Cr = new MediaStatus(paramJSONObject);
      this.Cq = SystemClock.elapsedRealtime();
      i = 7;
    }
    if ((i & 0x1) != 0)
    {
      this.Cq = SystemClock.elapsedRealtime();
      onStatusUpdated();
    }
    if ((i & 0x2) != 0)
    {
      this.Cq = SystemClock.elapsedRealtime();
      onStatusUpdated();
    }
    if ((i & 0x4) != 0) {
      onMetadataUpdated();
    }
    Iterator localIterator = this.CC.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((gs)localIterator.next()).c(paramLong, 0);
    }
  }
  
  private void eo()
  {
    z(false);
    this.Cq = 0L;
    this.Cr = null;
    this.Cs.clear();
    this.Cw.clear();
    this.Cx.clear();
  }
  
  private void z(boolean paramBoolean)
  {
    if (this.CE != paramBoolean)
    {
      this.CE = paramBoolean;
      if (!paramBoolean) {
        this.mHandler.removeCallbacks(this.CD);
      } else {
        this.mHandler.postDelayed(this.CD, Cp);
      }
    }
  }
  
  public long a(gr paramgr)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cz.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "GET_STATUS");
      if (this.Cr != null) {
        localJSONObject.put("mediaSessionId", this.Cr.dV());
      }
      label69:
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label69;
    }
  }
  
  public long a(gr paramgr, double paramDouble, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    JSONObject localJSONObject1 = new JSONObject();
    long l = dY();
    this.Cx.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject1.put("requestId", l);
      localJSONObject1.put("type", "SET_VOLUME");
      localJSONObject1.put("mediaSessionId", dV());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("level", paramDouble);
      localJSONObject1.put("volume", localJSONObject2);
      if (paramJSONObject != null) {
        localJSONObject1.put("customData", paramJSONObject);
      }
      label151:
      a(localJSONObject1.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label151;
    }
  }
  
  public long a(gr paramgr, long paramLong, int paramInt, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cw.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SEEK");
      localJSONObject.put("mediaSessionId", dV());
      localJSONObject.put("currentTime", gj.o(paramLong));
      if (paramInt == 1) {
        localJSONObject.put("resumeState", "PLAYBACK_START");
      }
      for (;;)
      {
        if (paramJSONObject != null) {
          localJSONObject.put("customData", paramJSONObject);
        }
        label110:
        a(localJSONObject.toString(), l, null);
        return l;
        if (paramInt == 2) {
          localJSONObject.put("resumeState", "PLAYBACK_PAUSE");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      break label110;
    }
  }
  
  public long a(gr paramgr, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cs.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "LOAD");
      localJSONObject.put("media", paramMediaInfo.dU());
      localJSONObject.put("autoplay", paramBoolean);
      localJSONObject.put("currentTime", gj.o(paramLong));
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
      label104:
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label104;
    }
  }
  
  public long a(gr paramgr, TextTrackStyle paramTextTrackStyle)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.CB.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      if (paramTextTrackStyle != null) {
        localJSONObject.put("textTrackStyle", paramTextTrackStyle.dU());
      }
      localJSONObject.put("mediaSessionId", dV());
      label77:
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label77;
    }
  }
  
  public long a(gr paramgr, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Ct.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PAUSE");
      localJSONObject.put("mediaSessionId", dV());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
      label74:
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label74;
    }
  }
  
  public long a(gr paramgr, boolean paramBoolean, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject1 = new JSONObject();
    long l = dY();
    this.Cy.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject1.put("requestId", l);
      localJSONObject1.put("type", "SET_VOLUME");
      localJSONObject1.put("mediaSessionId", dV());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("muted", paramBoolean);
      localJSONObject1.put("volume", localJSONObject2);
      if (paramJSONObject != null) {
        localJSONObject1.put("customData", paramJSONObject);
      }
      label107:
      a(localJSONObject1.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label107;
    }
  }
  
  public long a(gr paramgr, long[] paramArrayOfLong)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.CA.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      localJSONObject.put("mediaSessionId", dV());
      JSONArray localJSONArray = new JSONArray();
      for (int i = 0; i < paramArrayOfLong.length; i++) {
        localJSONArray.put(i, paramArrayOfLong[i]);
      }
      localJSONObject.put("activeTrackIds", localJSONArray);
      label108:
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label108;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Iterator localIterator = this.CC.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((gs)localIterator.next()).c(paramLong, paramInt);
    }
  }
  
  public final void ai(String paramString)
  {
    Object localObject1 = this.BA;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    ((go)localObject1).b("message received: %s", arrayOfObject);
    Object localObject3;
    go localgo;
    try
    {
      Object localObject2 = new JSONObject(paramString);
      localObject3 = ((JSONObject)localObject2).getString("type");
      long l = ((JSONObject)localObject2).optLong("requestId", -1L);
      if (((String)localObject3).equals("MEDIA_STATUS"))
      {
        localObject2 = ((JSONObject)localObject2).getJSONArray("status");
        if (((JSONArray)localObject2).length() > 0)
        {
          a(l, ((JSONArray)localObject2).getJSONObject(0));
        }
        else
        {
          this.Cr = null;
          onStatusUpdated();
          onMetadataUpdated();
          this.Cz.c(l, 0);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localgo = this.BA;
      localObject1 = new Object[2];
      localObject1[0] = localJSONException.getMessage();
      localObject1[1] = paramString;
      localgo.d("Message is malformed (%s); ignoring: %s", (Object[])localObject1);
    }
    JSONObject localJSONObject;
    if (((String)localObject3).equals("INVALID_PLAYER_STATE"))
    {
      this.BA.d("received unexpected error: Invalid Player State.", new Object[0]);
      localJSONObject = localJSONException.optJSONObject("customData");
      localObject3 = this.CC.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((gs)((Iterator)localObject3).next()).b(localgo, 1, localJSONObject);
      }
    }
    if (((String)localObject3).equals("LOAD_FAILED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.Cs.b(localgo, 1, localJSONObject);
    }
    else if (((String)localObject3).equals("LOAD_CANCELLED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.Cs.b(localgo, 2, localJSONObject);
    }
    else if (((String)localObject3).equals("INVALID_REQUEST"))
    {
      this.BA.d("received unexpected error: Invalid Request.", new Object[0]);
      localJSONObject = localJSONObject.optJSONObject("customData");
      localObject3 = this.CC.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((gs)((Iterator)localObject3).next()).b(localgo, 1, localJSONObject);
      }
    }
  }
  
  public long b(gr paramgr, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cv.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "STOP");
      localJSONObject.put("mediaSessionId", dV());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
      label74:
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label74;
    }
  }
  
  public long c(gr paramgr, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = dY();
    this.Cu.a(l, paramgr);
    z(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PLAY");
      localJSONObject.put("mediaSessionId", dV());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
      label74:
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label74;
    }
  }
  
  public long dV()
    throws IllegalStateException
  {
    if (this.Cr != null) {
      return this.Cr.dV();
    }
    throw new IllegalStateException("No current media session");
  }
  
  public void dZ()
  {
    eo();
  }
  
  public long getApproximateStreamPosition()
  {
    long l1 = 0L;
    MediaInfo localMediaInfo = getMediaInfo();
    if ((localMediaInfo != null) && (this.Cq != l1))
    {
      double d = this.Cr.getPlaybackRate();
      long l2 = this.Cr.getStreamPosition();
      int i = this.Cr.getPlayerState();
      if ((d != 0.0D) && (i == 2))
      {
        long l4 = SystemClock.elapsedRealtime() - this.Cq;
        long l5;
        if (l4 >= l1) {
          l5 = l4;
        } else {
          l5 = l1;
        }
        if (l5 != l1)
        {
          long l3 = localMediaInfo.getStreamDuration();
          l2 += (d * l5);
          if (l2 <= l3) {
            if (l2 >= l1) {
              l3 = l2;
            } else {
              l3 = l1;
            }
          }
          l1 = l3;
        }
        else
        {
          l1 = l2;
        }
      }
      else
      {
        l1 = l2;
      }
    }
    return l1;
  }
  
  public MediaInfo getMediaInfo()
  {
    MediaInfo localMediaInfo;
    if (this.Cr != null) {
      localMediaInfo = this.Cr.getMediaInfo();
    } else {
      localMediaInfo = null;
    }
    return localMediaInfo;
  }
  
  public MediaStatus getMediaStatus()
  {
    return this.Cr;
  }
  
  public long getStreamDuration()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    long l;
    if (localMediaInfo == null) {
      l = 0L;
    } else {
      l = l.getStreamDuration();
    }
    return l;
  }
  
  protected void onMetadataUpdated() {}
  
  protected void onStatusUpdated() {}
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      boolean bool = false;
      gp.a(gp.this, false);
      long l = SystemClock.elapsedRealtime();
      Iterator localIterator2 = gp.a(gp.this).iterator();
      while (localIterator2.hasNext()) {
        ((gs)localIterator2.next()).d(l, 3);
      }
      for (;;)
      {
        synchronized (gs.CK)
        {
          Iterator localIterator1 = gp.a(gp.this).iterator();
          if (localIterator1.hasNext())
          {
            if (((gs)localIterator1.next()).eq())
            {
              bool = true;
              break label124;
            }
          }
          else
          {
            gp.b(gp.this, bool);
            return;
          }
        }
        localObject1 = localObject1;
        label124:
        localObject1 = localObject1;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gp
 * JD-Core Version:    0.7.0.1
 */