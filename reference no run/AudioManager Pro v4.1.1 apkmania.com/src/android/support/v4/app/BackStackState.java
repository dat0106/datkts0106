

android.os.Parcel
android.os.Parcelable
android.os.Parcelable.Creator
android.text.TextUtils
android.util.Log
java.util.ArrayList

BackStackState
  

  CREATOR = ()
  
    createFromParcel
    
      
    
    
    []newArray
    
      
    
  
  mBreadCrumbShortTitleRes
  mBreadCrumbShortTitleText
  mBreadCrumbTitleRes
  mBreadCrumbTitleText
  mIndex
  mName
  []mOps
  mTransition
  mTransitionStyle
  
  BackStackState
  
    mOps = paramParcel.createIntArray();
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
    for (BackStackRecord.Op localOp = paramBackStackRecord.mHead;; localOp = localOp.next)
    {
      int j;
      if (localOp == null)
      {
        this.mOps = new int[i + 7 * paramBackStackRecord.mNumOp];
        if (paramBackStackRecord.mAddToBackStack)
        {
          localOp = paramBackStackRecord.mHead;
          int k = 0;
          if (localOp == null)
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
          int[] arrayOfInt4 = this.mOps;
          i = k + 1;
          arrayOfInt4[k] = localOp.cmd;
          arrayOfInt4 = this.mOps;
          k = i + 1;
          int i2;
          if (localOp.fragment == null) {
            i2 = -1;
          } else {
            i2 = localOp.fragment.mIndex;
          }
          arrayOfInt4[i] = i2;
          int[] arrayOfInt1 = this.mOps;
          int i1 = k + 1;
          arrayOfInt1[k] = localOp.enterAnim;
          int[] arrayOfInt2 = this.mOps;
          j = i1 + 1;
          arrayOfInt2[i1] = localOp.exitAnim;
          int[] arrayOfInt5 = this.mOps;
          int m = j + 1;
          arrayOfInt5[j] = localOp.popEnterAnim;
          arrayOfInt5 = this.mOps;
          j = m + 1;
          arrayOfInt5[m] = localOp.popExitAnim;
          int[] arrayOfInt6;
          int n;
          if (localOp.removed == null)
          {
            int[] arrayOfInt3 = this.mOps;
            arrayOfInt6 = j + 1;
            arrayOfInt3[j] = 0;
          }
          else
          {
            n = localOp.removed.size();
            arrayOfInt8 = this.mOps;
            arrayOfInt6 = j + 1;
            arrayOfInt8[j] = n;
            j = 0;
          }
          int[] arrayOfInt9;
          for (int[] arrayOfInt8 = arrayOfInt6;; arrayOfInt8 = arrayOfInt9)
          {
            if (j >= n)
            {
              arrayOfInt6 = arrayOfInt8;
              localOp = localOp.next;
              n = arrayOfInt6;
              break;
            }
            int[] arrayOfInt7 = this.mOps;
            arrayOfInt9 = arrayOfInt8 + 1;
            arrayOfInt7[arrayOfInt8] = ((Fragment)localOp.removed.get(j)).mIndex;
            j++;
          }
        }
        throw new IllegalStateException("Not on back stack");
      }
      if (localOp.removed != null) {
        j += localOp.removed.size();
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
    int i = 0;
    if (i >= this.mOps.length)
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
    int k = i + 1;
    localOp.cmd = arrayOfInt3[i];
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "BSE " + localBackStackRecord + " set base fragment #" + this.mOps[k]);
    }
    arrayOfInt3 = this.mOps;
    i = k + 1;
    k = arrayOfInt3[k];
    if (k < 0) {
      localOp.fragment = null;
    } else {
      localOp.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(k));
    }
    arrayOfInt3 = this.mOps;
    k = i + 1;
    localOp.enterAnim = arrayOfInt3[i];
    int[] arrayOfInt1 = this.mOps;
    int n = k + 1;
    localOp.exitAnim = arrayOfInt1[k];
    int[] arrayOfInt2 = this.mOps;
    int j = n + 1;
    localOp.popEnterAnim = arrayOfInt2[n];
    int[] arrayOfInt4 = this.mOps;
    int m = j + 1;
    localOp.popExitAnim = arrayOfInt4[j];
    arrayOfInt4 = this.mOps;
    j = m + 1;
    m = arrayOfInt4[m];
    int i1;
    if (m > 0)
    {
      localOp.removed = new ArrayList(m);
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= m)
      {
        j = j;
        localBackStackRecord.addOp(localOp);
        break;
      }
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "BSE " + localBackStackRecord + " set remove fragment #" + this.mOps[j]);
      }
      ArrayList localArrayList = paramFragmentManagerImpl.mActive;
      int[] arrayOfInt5 = this.mOps;
      Fragment localFragment2 = j + 1;
      Fragment localFragment1 = (Fragment)localArrayList.get(arrayOfInt5[j]);
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


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */