package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator()
  {
    public BackStackState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BackStackState(paramAnonymousParcel);
    }
    
    public BackStackState[] newArray(int paramAnonymousInt)
    {
      return new BackStackState[paramAnonymousInt];
    }
  };
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int mIndex;
  final String mName;
  final int[] mOps;
  final int mTransition;
  final int mTransitionStyle;
  
  public BackStackState(Parcel paramParcel)
  {
    this.mOps = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mTransitionStyle = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
  }
  
  public BackStackState(FragmentManagerImpl paramFragmentManagerImpl, BackStackRecord paramBackStackRecord)
  {
    int i = 0;
    int m;
    BackStackRecord.Op localOp3;
    for (BackStackRecord.Op localOp2 = paramBackStackRecord.mHead;; localOp3 = m.next)
    {
      BackStackRecord.Op localOp1;
      if (localOp2 == null)
      {
        this.mOps = new int[i + 7 * paramBackStackRecord.mNumOp];
        if (paramBackStackRecord.mAddToBackStack)
        {
          localOp1 = paramBackStackRecord.mHead;
          int i1 = 0;
          if (localOp1 == null)
          {
            this.mTransition = paramBackStackRecord.mTransition;
            this.mTransitionStyle = paramBackStackRecord.mTransitionStyle;
            this.mName = paramBackStackRecord.mName;
            this.mIndex = paramBackStackRecord.mIndex;
            this.mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
            return;
          }
          int[] arrayOfInt2 = this.mOps;
          int k = i1 + 1;
          arrayOfInt2[i1] = localOp1.cmd;
          int[] arrayOfInt5 = this.mOps;
          int n = k + 1;
          int i3;
          if (localOp1.fragment == null) {
            i3 = -1;
          } else {
            i3 = localOp1.fragment.mIndex;
          }
          arrayOfInt5[k] = i3;
          arrayOfInt5 = this.mOps;
          k = n + 1;
          arrayOfInt5[n] = localOp1.enterAnim;
          int[] arrayOfInt3 = this.mOps;
          int i2 = k + 1;
          arrayOfInt3[k] = localOp1.exitAnim;
          int[] arrayOfInt1 = this.mOps;
          int[] arrayOfInt4 = i2 + 1;
          arrayOfInt1[i2] = localOp1.popEnterAnim;
          int[] arrayOfInt6 = this.mOps;
          m = arrayOfInt4 + 1;
          arrayOfInt6[arrayOfInt4] = localOp1.popExitAnim;
          int[] arrayOfInt7;
          if (localOp1.removed == null)
          {
            arrayOfInt6 = this.mOps;
            arrayOfInt4 = m + 1;
            arrayOfInt6[m] = 0;
          }
          else
          {
            arrayOfInt4 = localOp1.removed.size();
            arrayOfInt9 = this.mOps;
            arrayOfInt7 = m + 1;
            arrayOfInt9[m] = arrayOfInt4;
            m = 0;
          }
          int[] arrayOfInt10;
          for (int[] arrayOfInt9 = arrayOfInt7;; arrayOfInt9 = arrayOfInt10)
          {
            if (m >= arrayOfInt4)
            {
              arrayOfInt4 = arrayOfInt9;
              localOp1 = localOp1.next;
              arrayOfInt7 = arrayOfInt4;
              break;
            }
            int[] arrayOfInt8 = this.mOps;
            arrayOfInt10 = arrayOfInt9 + 1;
            arrayOfInt8[arrayOfInt9] = ((Fragment)localOp1.removed.get(m)).mIndex;
            m++;
          }
        }
        throw new IllegalStateException("Not on back stack");
      }
      if (m.removed != null)
      {
        int j;
        localOp1 += m.removed.size();
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int j = 0;
    int i = 0;
    if (j >= this.mOps.length)
    {
      localBackStackRecord.mTransition = this.mTransition;
      localBackStackRecord.mTransitionStyle = this.mTransitionStyle;
      localBackStackRecord.mName = this.mName;
      localBackStackRecord.mIndex = this.mIndex;
      localBackStackRecord.mAddToBackStack = true;
      localBackStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
      localBackStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
      localBackStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
      localBackStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
      localBackStackRecord.bumpBackStackNesting(1);
      return localBackStackRecord;
    }
    BackStackRecord.Op localOp = new BackStackRecord.Op();
    int[] arrayOfInt3 = this.mOps;
    int m = j + 1;
    localOp.cmd = arrayOfInt3[j];
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " op #" + i + " base fragment #" + this.mOps[m]);
    }
    arrayOfInt3 = this.mOps;
    j = m + 1;
    m = arrayOfInt3[m];
    if (m < 0) {
      localOp.fragment = null;
    } else {
      localOp.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(m));
    }
    arrayOfInt3 = this.mOps;
    m = j + 1;
    localOp.enterAnim = arrayOfInt3[j];
    arrayOfInt3 = this.mOps;
    j = m + 1;
    localOp.exitAnim = arrayOfInt3[m];
    int[] arrayOfInt2 = this.mOps;
    int n = j + 1;
    localOp.popEnterAnim = arrayOfInt2[j];
    int[] arrayOfInt1 = this.mOps;
    Fragment localFragment2 = n + 1;
    localOp.popExitAnim = arrayOfInt1[n];
    int[] arrayOfInt4 = this.mOps;
    int k = localFragment2 + 1;
    int i2 = arrayOfInt4[localFragment2];
    int i1;
    if (i2 > 0)
    {
      localOp.removed = new ArrayList(i2);
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2)
      {
        k = k;
        localBackStackRecord.addOp(localOp);
        i++;
        break;
      }
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " set remove fragment #" + this.mOps[k]);
      }
      ArrayList localArrayList = paramFragmentManagerImpl.mActive;
      int[] arrayOfInt5 = this.mOps;
      localFragment2 = k + 1;
      Fragment localFragment1 = (Fragment)localArrayList.get(arrayOfInt5[k]);
      localOp.removed.add(localFragment1);
      i1++;
      localFragment1 = localFragment2;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.mOps);
    paramParcel.writeInt(this.mTransition);
    paramParcel.writeInt(this.mTransitionStyle);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.mBreadCrumbTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(this.mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, paramParcel, 0);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */