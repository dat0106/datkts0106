package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet
  extends Animator
{
  private ValueAnimator mDelayAnim = null;
  private long mDuration = -1L;
  private boolean mNeedsSort = true;
  private HashMap<Animator, Node> mNodeMap = new HashMap();
  private ArrayList<Node> mNodes = new ArrayList();
  private ArrayList<Animator> mPlayingSet = new ArrayList();
  private AnimatorSetListener mSetListener = null;
  private ArrayList<Node> mSortedNodes = new ArrayList();
  private long mStartDelay = 0L;
  private boolean mStarted = false;
  boolean mTerminated = false;
  
  private void sortNodes()
  {
    int m;
    ArrayList localArrayList;
    if (!this.mNeedsSort)
    {
      int k = this.mNodes.size();
      m = 0;
      if (m < k)
      {
        Node localNode1 = (Node)this.mNodes.get(m);
        int i;
        if ((localNode1.dependencies != null) && (localNode1.dependencies.size() > 0)) {
          i = localNode1.dependencies.size();
        }
        for (int n = 0;; n++)
        {
          if (n >= i)
          {
            localNode1.done = false;
            m++;
            break;
          }
          Dependency localDependency = (Dependency)localNode1.dependencies.get(n);
          if (localNode1.nodeDependencies == null) {
            localNode1.nodeDependencies = new ArrayList();
          }
          if (!localNode1.nodeDependencies.contains(localDependency.node)) {
            localNode1.nodeDependencies.add(localDependency.node);
          }
        }
      }
    }
    else
    {
      this.mSortedNodes.clear();
      localArrayList = new ArrayList();
      m = this.mNodes.size();
    }
    for (int j = 0;; j++)
    {
      if (j >= m)
      {
        localObject = new ArrayList();
        int i3;
        for (;;)
        {
          if (localArrayList.size() <= 0)
          {
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() == this.mNodes.size()) {
              return;
            }
            throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
          }
          int i2 = localArrayList.size();
          i3 = 0;
          if (i3 < i2) {
            break;
          }
          localArrayList.clear();
          localArrayList.addAll((Collection)localObject);
          ((ArrayList)localObject).clear();
        }
        Node localNode2 = (Node)localArrayList.get(i3);
        this.mSortedNodes.add(localNode2);
        if (localNode2.nodeDependents != null) {
          j = localNode2.nodeDependents.size();
        }
        for (int i1 = 0;; i1++)
        {
          if (i1 >= j)
          {
            i3++;
            break;
          }
          Node localNode3 = (Node)localNode2.nodeDependents.get(i1);
          localNode3.nodeDependencies.remove(localNode2);
          if (localNode3.nodeDependencies.size() == 0) {
            ((ArrayList)localObject).add(localNode3);
          }
        }
      }
      Object localObject = (Node)this.mNodes.get(j);
      if ((((Node)localObject).dependencies == null) || (((Node)localObject).dependencies.size() == 0)) {
        localArrayList.add(localObject);
      }
    }
  }
  
  public void cancel()
  {
    this.mTerminated = true;
    Object localObject;
    Iterator localIterator;
    if (isStarted())
    {
      localObject = null;
      if (this.mListeners != null)
      {
        localObject = (ArrayList)this.mListeners.clone();
        localIterator = ((ArrayList)localObject).iterator();
      }
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if ((this.mDelayAnim == null) || (!this.mDelayAnim.isRunning()))
        {
          if (this.mSortedNodes.size() > 0) {
            localIterator = this.mSortedNodes.iterator();
          }
        }
        else {
          while (localIterator.hasNext())
          {
            ((Node)localIterator.next()).animation.cancel();
            continue;
            this.mDelayAnim.cancel();
          }
        }
        if (localObject != null) {
          localObject = ((ArrayList)localObject).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext())
          {
            this.mStarted = false;
            return;
          }
          ((Animator.AnimatorListener)((Iterator)localObject).next()).onAnimationEnd(this);
        }
      }
      ((Animator.AnimatorListener)localIterator.next()).onAnimationCancel(this);
    }
  }
  
  public AnimatorSet clone()
  {
    AnimatorSet localAnimatorSet = (AnimatorSet)super.clone();
    localAnimatorSet.mNeedsSort = true;
    localAnimatorSet.mTerminated = false;
    localAnimatorSet.mStarted = false;
    localAnimatorSet.mPlayingSet = new ArrayList();
    localAnimatorSet.mNodeMap = new HashMap();
    localAnimatorSet.mNodes = new ArrayList();
    localAnimatorSet.mSortedNodes = new ArrayList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.mNodes.iterator();
    Object localObject1;
    do
    {
      if (!localIterator.hasNext())
      {
        localIterator = this.mNodes.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            return localAnimatorSet;
          }
          localObject2 = (Node)localIterator.next();
          localObject1 = (Node)localHashMap.get(localObject2);
          if (((Node)localObject2).dependencies != null)
          {
            localObject3 = ((Node)localObject2).dependencies.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject2 = (Dependency)((Iterator)localObject3).next();
              ((Node)localObject1).addDependency(new Dependency((Node)localHashMap.get(((Dependency)localObject2).node), ((Dependency)localObject2).rule));
            }
          }
        }
      }
      localObject1 = (Node)localIterator.next();
      localObject2 = ((Node)localObject1).clone();
      localHashMap.put(localObject1, localObject2);
      localAnimatorSet.mNodes.add(localObject2);
      localAnimatorSet.mNodeMap.put(((Node)localObject2).animation, localObject2);
      ((Node)localObject2).dependencies = null;
      ((Node)localObject2).tmpDependencies = null;
      ((Node)localObject2).nodeDependents = null;
      ((Node)localObject2).nodeDependencies = null;
      localObject1 = ((Node)localObject2).animation.getListeners();
    } while (localObject1 == null);
    Object localObject3 = null;
    Object localObject2 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        if (localObject3 == null) {
          break;
        }
        localObject2 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).remove((Animator.AnimatorListener)((Iterator)localObject2).next());
        }
        break;
      }
      Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)((Iterator)localObject2).next();
      if ((localAnimatorListener instanceof AnimatorSetListener))
      {
        if (localObject3 == null) {
          localObject3 = new ArrayList();
        }
        ((ArrayList)localObject3).add(localAnimatorListener);
      }
    }
  }
  
  public void end()
  {
    this.mTerminated = true;
    Iterator localIterator;
    if (isStarted()) {
      if (this.mSortedNodes.size() != this.mNodes.size())
      {
        sortNodes();
        localIterator = this.mSortedNodes.iterator();
      }
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (this.mDelayAnim != null) {
          this.mDelayAnim.cancel();
        }
        if (this.mSortedNodes.size() > 0) {
          localObject = this.mSortedNodes.iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject).hasNext())
          {
            if (this.mListeners != null) {
              localObject = ((ArrayList)this.mListeners.clone()).iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject).hasNext())
              {
                this.mStarted = false;
                return;
              }
              ((Animator.AnimatorListener)((Iterator)localObject).next()).onAnimationEnd(this);
            }
          }
          ((Node)((Iterator)localObject).next()).animation.end();
        }
      }
      Object localObject = (Node)localIterator.next();
      if (this.mSetListener == null) {
        this.mSetListener = new AnimatorSetListener(this);
      }
      ((Node)localObject).animation.addListener(this.mSetListener);
    }
  }
  
  public ArrayList<Animator> getChildAnimations()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      localArrayList.add(((Node)localIterator.next()).animation);
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public long getStartDelay()
  {
    return this.mStartDelay;
  }
  
  public boolean isRunning()
  {
    Iterator localIterator = this.mNodes.iterator();
    do
    {
      if (!localIterator.hasNext())
      {
        bool = false;
        break;
      }
    } while (!((Node)bool.next()).animation.isRunning());
    boolean bool = true;
    return bool;
  }
  
  public boolean isStarted()
  {
    return this.mStarted;
  }
  
  public Builder play(Animator paramAnimator)
  {
    Builder localBuilder;
    if (paramAnimator == null)
    {
      localBuilder = null;
    }
    else
    {
      this.mNeedsSort = true;
      localBuilder = new Builder(paramAnimator);
    }
    return localBuilder;
  }
  
  public void playSequentially(List<Animator> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.mNeedsSort = true;
      if (paramList.size() != 1) {
        for (int i = 0; i < -1 + paramList.size(); i++) {
          play((Animator)paramList.get(i)).before((Animator)paramList.get(i + 1));
        }
      }
      play((Animator)paramList.get(0));
    }
  }
  
  public void playSequentially(Animator... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      this.mNeedsSort = true;
      if (paramVarArgs.length != 1) {
        for (int i = 0; i < -1 + paramVarArgs.length; i++) {
          play(paramVarArgs[i]).before(paramVarArgs[(i + 1)]);
        }
      }
      play(paramVarArgs[0]);
    }
  }
  
  public void playTogether(Collection<Animator> paramCollection)
  {
    Builder localBuilder;
    Iterator localIterator;
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      this.mNeedsSort = true;
      localBuilder = null;
      localIterator = paramCollection.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Animator localAnimator = (Animator)localIterator.next();
      if (localBuilder != null) {
        localBuilder.with(localAnimator);
      } else {
        localBuilder = play(localAnimator);
      }
    }
  }
  
  public void playTogether(Animator... paramVarArgs)
  {
    Builder localBuilder;
    if (paramVarArgs != null)
    {
      this.mNeedsSort = true;
      localBuilder = play(paramVarArgs[0]);
    }
    for (int i = 1;; i++)
    {
      if (i >= paramVarArgs.length) {
        return;
      }
      localBuilder.with(paramVarArgs[i]);
    }
  }
  
  public AnimatorSet setDuration(long paramLong)
  {
    if (paramLong >= 0L)
    {
      Iterator localIterator = this.mNodes.iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          this.mDuration = paramLong;
          return this;
        }
        ((Node)localIterator.next()).animation.setDuration(paramLong);
      }
    }
    throw new IllegalArgumentException("duration must be a value of zero or greater");
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((Node)localIterator.next()).animation.setInterpolator(paramInterpolator);
    }
  }
  
  public void setStartDelay(long paramLong)
  {
    this.mStartDelay = paramLong;
  }
  
  public void setTarget(Object paramObject)
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Animator localAnimator = ((Node)localIterator.next()).animation;
      if (!(localAnimator instanceof AnimatorSet))
      {
        if ((localAnimator instanceof ObjectAnimator)) {
          ((ObjectAnimator)localAnimator).setTarget(paramObject);
        }
      }
      else {
        ((AnimatorSet)localAnimator).setTarget(paramObject);
      }
    }
  }
  
  public void setupEndValues()
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((Node)localIterator.next()).animation.setupEndValues();
    }
  }
  
  public void setupStartValues()
  {
    Iterator localIterator = this.mNodes.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((Node)localIterator.next()).animation.setupStartValues();
    }
  }
  
  public void start()
  {
    this.mTerminated = false;
    this.mStarted = true;
    sortNodes();
    int i = this.mSortedNodes.size();
    int k = 0;
    Node localNode1;
    if (k >= i)
    {
      Object localObject2 = new ArrayList();
      for (int n = 0;; n++)
      {
        if (n >= i)
        {
          Object localObject1;
          if (this.mStartDelay > 0L)
          {
            localObject1 = new float[2];
            localObject1[0] = 0.0F;
            localObject1[1] = 1.0F;
            this.mDelayAnim = ValueAnimator.ofFloat((float[])localObject1);
            this.mDelayAnim.setDuration(this.mStartDelay);
            localObject1 = this.mDelayAnim;
            localObject2 = new AnimatorListenerAdapter()
            {
              boolean canceled = false;
              
              public void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                this.canceled = true;
              }
              
              public void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                int j;
                if (!this.canceled) {
                  j = this.val$nodesToStart.size();
                }
                for (int i = 0;; i++)
                {
                  if (i >= j) {
                    return;
                  }
                  AnimatorSet.Node localNode = (AnimatorSet.Node)this.val$nodesToStart.get(i);
                  localNode.animation.start();
                  AnimatorSet.this.mPlayingSet.add(localNode.animation);
                }
              }
            };
            ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)localObject2);
            this.mDelayAnim.start();
          }
          else
          {
            localObject1 = ((ArrayList)localObject2).iterator();
          }
          for (;;)
          {
            ArrayList localArrayList;
            if (!((Iterator)localObject1).hasNext())
            {
              if (this.mListeners != null)
              {
                localObject2 = (ArrayList)this.mListeners.clone();
                n = ((ArrayList)localObject2).size();
              }
              for (int j = 0;; localArrayList++)
              {
                int m;
                if (j >= n)
                {
                  if ((this.mNodes.size() == 0) && (this.mStartDelay == 0L))
                  {
                    this.mStarted = false;
                    if (this.mListeners != null)
                    {
                      localArrayList = (ArrayList)this.mListeners.clone();
                      n = localArrayList.size();
                    }
                  }
                  for (m = 0;; m++)
                  {
                    if (m >= n) {
                      return;
                    }
                    ((Animator.AnimatorListener)localArrayList.get(m)).onAnimationEnd(this);
                  }
                }
                ((Animator.AnimatorListener)m.get(localArrayList)).onAnimationStart(this);
              }
            }
            localNode1 = (Node)localArrayList.next();
            localNode1.animation.start();
            this.mPlayingSet.add(localNode1.animation);
          }
        }
        localObject3 = (Node)this.mSortedNodes.get(n);
        if (this.mSetListener == null)
        {
          AnimatorSetListener localAnimatorSetListener = new AnimatorSetListener(this);
          this.mSetListener = localAnimatorSetListener;
        }
        if ((((Node)localObject3).dependencies != null) && (((Node)localObject3).dependencies.size() != 0))
        {
          int i2 = ((Node)localObject3).dependencies.size();
          for (int i1 = 0;; i1++)
          {
            if (i1 >= i2)
            {
              ((Node)localObject3).tmpDependencies = ((ArrayList)((Node)localObject3).dependencies.clone());
              break;
            }
            Object localObject4 = (Dependency)((Node)localObject3).dependencies.get(i1);
            Animator localAnimator = ((Dependency)localObject4).node.animation;
            localObject4 = new DependencyListener(this, (Node)localObject3, ((Dependency)localObject4).rule);
            localAnimator.addListener((Animator.AnimatorListener)localObject4);
          }
        }
        localNode1.add(localObject3);
        ((Node)localObject3).animation.addListener(this.mSetListener);
      }
    }
    Node localNode2 = (Node)this.mSortedNodes.get(localNode1);
    Object localObject3 = localNode2.animation.getListeners();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
      localObject3 = new ArrayList((Collection)localObject3).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext())
      {
        localNode1++;
        break;
      }
      Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)((Iterator)localObject3).next();
      if (((localAnimatorListener instanceof DependencyListener)) || ((localAnimatorListener instanceof AnimatorSetListener))) {
        localNode2.animation.removeListener(localAnimatorListener);
      }
    }
  }
  
  public class Builder
  {
    private AnimatorSet.Node mCurrentNode;
    
    Builder(Animator paramAnimator)
    {
      this.mCurrentNode = ((AnimatorSet.Node)AnimatorSet.this.mNodeMap.get(paramAnimator));
      if (this.mCurrentNode == null)
      {
        this.mCurrentNode = new AnimatorSet.Node(paramAnimator);
        AnimatorSet.this.mNodeMap.put(paramAnimator, this.mCurrentNode);
        AnimatorSet.this.mNodes.add(this.mCurrentNode);
      }
    }
    
    public Builder after(long paramLong)
    {
      Object localObject = new float[2];
      localObject[0] = 0.0F;
      localObject[1] = 1.0F;
      localObject = ValueAnimator.ofFloat((float[])localObject);
      ((ValueAnimator)localObject).setDuration(paramLong);
      after((Animator)localObject);
      return this;
    }
    
    public Builder after(Animator paramAnimator)
    {
      Object localObject = (AnimatorSet.Node)AnimatorSet.this.mNodeMap.get(paramAnimator);
      if (localObject == null)
      {
        localObject = new AnimatorSet.Node(paramAnimator);
        AnimatorSet.this.mNodeMap.put(paramAnimator, localObject);
        AnimatorSet.this.mNodes.add(localObject);
      }
      localObject = new AnimatorSet.Dependency((AnimatorSet.Node)localObject, 1);
      this.mCurrentNode.addDependency((AnimatorSet.Dependency)localObject);
      return this;
    }
    
    public Builder before(Animator paramAnimator)
    {
      AnimatorSet.Node localNode = (AnimatorSet.Node)AnimatorSet.this.mNodeMap.get(paramAnimator);
      if (localNode == null)
      {
        localNode = new AnimatorSet.Node(paramAnimator);
        AnimatorSet.this.mNodeMap.put(paramAnimator, localNode);
        AnimatorSet.this.mNodes.add(localNode);
      }
      localNode.addDependency(new AnimatorSet.Dependency(this.mCurrentNode, 1));
      return this;
    }
    
    public Builder with(Animator paramAnimator)
    {
      AnimatorSet.Node localNode = (AnimatorSet.Node)AnimatorSet.this.mNodeMap.get(paramAnimator);
      if (localNode == null)
      {
        localNode = new AnimatorSet.Node(paramAnimator);
        AnimatorSet.this.mNodeMap.put(paramAnimator, localNode);
        AnimatorSet.this.mNodes.add(localNode);
      }
      localNode.addDependency(new AnimatorSet.Dependency(this.mCurrentNode, 0));
      return this;
    }
  }
  
  private static class Node
    implements Cloneable
  {
    public Animator animation;
    public ArrayList<AnimatorSet.Dependency> dependencies = null;
    public boolean done = false;
    public ArrayList<Node> nodeDependencies = null;
    public ArrayList<Node> nodeDependents = null;
    public ArrayList<AnimatorSet.Dependency> tmpDependencies = null;
    
    public Node(Animator paramAnimator)
    {
      this.animation = paramAnimator;
    }
    
    public void addDependency(AnimatorSet.Dependency paramDependency)
    {
      if (this.dependencies == null)
      {
        this.dependencies = new ArrayList();
        this.nodeDependencies = new ArrayList();
      }
      this.dependencies.add(paramDependency);
      if (!this.nodeDependencies.contains(paramDependency.node)) {
        this.nodeDependencies.add(paramDependency.node);
      }
      Node localNode = paramDependency.node;
      if (localNode.nodeDependents == null) {
        localNode.nodeDependents = new ArrayList();
      }
      localNode.nodeDependents.add(this);
    }
    
    public Node clone()
    {
      try
      {
        Node localNode = (Node)super.clone();
        localNode.animation = this.animation.clone();
        return localNode;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError();
      }
    }
  }
  
  private static class Dependency
  {
    static final int AFTER = 1;
    static final int WITH;
    public AnimatorSet.Node node;
    public int rule;
    
    public Dependency(AnimatorSet.Node paramNode, int paramInt)
    {
      this.node = paramNode;
      this.rule = paramInt;
    }
  }
  
  private class AnimatorSetListener
    implements Animator.AnimatorListener
  {
    private AnimatorSet mAnimatorSet;
    
    AnimatorSetListener(AnimatorSet paramAnimatorSet)
    {
      this.mAnimatorSet = paramAnimatorSet;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      int i;
      if ((!AnimatorSet.this.mTerminated) && (AnimatorSet.this.mPlayingSet.size() == 0) && (AnimatorSet.this.mListeners != null)) {
        i = AnimatorSet.this.mListeners.size();
      }
      for (int j = 0;; j++)
      {
        if (j >= i) {
          return;
        }
        ((Animator.AnimatorListener)AnimatorSet.this.mListeners.get(j)).onAnimationCancel(this.mAnimatorSet);
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator.removeListener(this);
      AnimatorSet.this.mPlayingSet.remove(paramAnimator);
      ((AnimatorSet.Node)this.mAnimatorSet.mNodeMap.get(paramAnimator)).done = true;
      ArrayList localArrayList2;
      int j;
      if (!AnimatorSet.this.mTerminated)
      {
        ArrayList localArrayList1 = this.mAnimatorSet.mSortedNodes;
        i = 1;
        int m = localArrayList1.size();
        int k = 0;
        while (k < m) {
          if (((AnimatorSet.Node)localArrayList1.get(k)).done) {
            k++;
          } else {
            i = 0;
          }
        }
        if (i != 0) {
          if (AnimatorSet.this.mListeners != null)
          {
            localArrayList2 = (ArrayList)AnimatorSet.this.mListeners.clone();
            j = localArrayList2.size();
          }
        }
      }
      for (int i = 0;; i++)
      {
        if (i >= j)
        {
          AnimatorSet.access$302(this.mAnimatorSet, false);
          return;
        }
        ((Animator.AnimatorListener)localArrayList2.get(i)).onAnimationEnd(this.mAnimatorSet);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  private static class DependencyListener
    implements Animator.AnimatorListener
  {
    private AnimatorSet mAnimatorSet;
    private AnimatorSet.Node mNode;
    private int mRule;
    
    public DependencyListener(AnimatorSet paramAnimatorSet, AnimatorSet.Node paramNode, int paramInt)
    {
      this.mAnimatorSet = paramAnimatorSet;
      this.mNode = paramNode;
      this.mRule = paramInt;
    }
    
    private void startIfReady(Animator paramAnimator)
    {
      if (!this.mAnimatorSet.mTerminated)
      {
        Object localObject = null;
        int j = this.mNode.tmpDependencies.size();
        int i = 0;
        while (i < j)
        {
          AnimatorSet.Dependency localDependency = (AnimatorSet.Dependency)this.mNode.tmpDependencies.get(i);
          if ((localDependency.rule != this.mRule) || (localDependency.node.animation != paramAnimator))
          {
            i++;
          }
          else
          {
            localObject = localDependency;
            paramAnimator.removeListener(this);
          }
        }
        this.mNode.tmpDependencies.remove(localObject);
        if (this.mNode.tmpDependencies.size() == 0)
        {
          this.mNode.animation.start();
          this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
        }
      }
    }
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (this.mRule == 1) {
        startIfReady(paramAnimator);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (this.mRule == 0) {
        startIfReady(paramAnimator);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet
 * JD-Core Version:    0.7.0.1
 */