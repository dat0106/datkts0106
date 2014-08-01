package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import java.util.HashMap;

public final class ScoreSubmissionData
{
  private static final String[] Sk;
  private int CQ;
  private String MP;
  private HashMap<Integer, Result> SQ;
  private String Sm;
  
  static
  {
    String[] arrayOfString = new String[8];
    arrayOfString[0] = "leaderboardId";
    arrayOfString[1] = "playerId";
    arrayOfString[2] = "timeSpan";
    arrayOfString[3] = "hasResult";
    arrayOfString[4] = "rawScore";
    arrayOfString[5] = "formattedScore";
    arrayOfString[6] = "newBest";
    arrayOfString[7] = "scoreTag";
    Sk = arrayOfString;
  }
  
  public ScoreSubmissionData(DataHolder paramDataHolder)
  {
    this.CQ = paramDataHolder.getStatusCode();
    this.SQ = new HashMap();
    int i = paramDataHolder.getCount();
    if (i != 3) {
      j = 0;
    } else {
      j = 1;
    }
    hn.C(j);
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      int k = paramDataHolder.ae(j);
      if (j == 0)
      {
        this.Sm = paramDataHolder.c("leaderboardId", j, k);
        this.MP = paramDataHolder.c("playerId", j, k);
      }
      if (paramDataHolder.d("hasResult", j, k)) {
        a(new Result(paramDataHolder.a("rawScore", j, k), paramDataHolder.c("formattedScore", j, k), paramDataHolder.c("scoreTag", j, k), paramDataHolder.d("newBest", j, k)), paramDataHolder.b("timeSpan", j, k));
      }
    }
  }
  
  private void a(Result paramResult, int paramInt)
  {
    this.SQ.put(Integer.valueOf(paramInt), paramResult);
  }
  
  public String getLeaderboardId()
  {
    return this.Sm;
  }
  
  public String getPlayerId()
  {
    return this.MP;
  }
  
  public Result getScoreResult(int paramInt)
  {
    return (Result)this.SQ.get(Integer.valueOf(paramInt));
  }
  
  public String toString()
  {
    hl.a locala = hl.e(this).a("PlayerId", this.MP).a("StatusCode", Integer.valueOf(this.CQ));
    for (int i = 0;; i++)
    {
      if (i >= 3) {
        return locala.toString();
      }
      Object localObject = (Result)this.SQ.get(Integer.valueOf(i));
      locala.a("TimesSpan", TimeSpan.cm(i));
      if (localObject != null) {
        localObject = ((Result)localObject).toString();
      } else {
        localObject = "null";
      }
      locala.a("Result", localObject);
    }
  }
  
  public static final class Result
  {
    public final String formattedScore;
    public final boolean newBest;
    public final long rawScore;
    public final String scoreTag;
    
    public Result(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.rawScore = paramLong;
      this.formattedScore = paramString1;
      this.scoreTag = paramString2;
      this.newBest = paramBoolean;
    }
    
    public String toString()
    {
      return hl.e(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.ScoreSubmissionData
 * JD-Core Version:    0.7.0.1
 */