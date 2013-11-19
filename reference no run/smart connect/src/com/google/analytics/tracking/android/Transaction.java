package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Transaction
{
  private final String mAffiliation;
  private final String mCurrencyCode;
  private final Map<String, Item> mItems;
  private final long mShippingCostInMicros;
  private final long mTotalCostInMicros;
  private final long mTotalTaxInMicros;
  private final String mTransactionId;
  
  private Transaction(Builder paramBuilder)
  {
    this.mTransactionId = paramBuilder.mTransactionId;
    this.mTotalCostInMicros = paramBuilder.mTotalCostInMicros;
    this.mAffiliation = paramBuilder.mAffiliation;
    this.mTotalTaxInMicros = paramBuilder.mTotalTaxInMicros;
    this.mShippingCostInMicros = paramBuilder.mShippingCostInMicros;
    this.mCurrencyCode = paramBuilder.mCurrencyCode;
    this.mItems = new HashMap();
  }
  
  public void addItem(Item paramItem)
  {
    this.mItems.put(paramItem.getSKU(), paramItem);
  }
  
  public String getAffiliation()
  {
    return this.mAffiliation;
  }
  
  public String getCurrencyCode()
  {
    return this.mCurrencyCode;
  }
  
  public List<Item> getItems()
  {
    return new ArrayList(this.mItems.values());
  }
  
  public long getShippingCostInMicros()
  {
    return this.mShippingCostInMicros;
  }
  
  public long getTotalCostInMicros()
  {
    return this.mTotalCostInMicros;
  }
  
  public long getTotalTaxInMicros()
  {
    return this.mTotalTaxInMicros;
  }
  
  public String getTransactionId()
  {
    return this.mTransactionId;
  }
  
  public static final class Item
  {
    private final String mCategory;
    private final String mName;
    private final long mPriceInMicros;
    private final long mQuantity;
    private final String mSKU;
    
    private Item(Builder paramBuilder)
    {
      this.mSKU = paramBuilder.mSKU;
      this.mPriceInMicros = paramBuilder.mPriceInMicros;
      this.mQuantity = paramBuilder.mQuantity;
      this.mName = paramBuilder.mName;
      this.mCategory = paramBuilder.mCategory;
    }
    
    public String getCategory()
    {
      return this.mCategory;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public long getPriceInMicros()
    {
      return this.mPriceInMicros;
    }
    
    public long getQuantity()
    {
      return this.mQuantity;
    }
    
    public String getSKU()
    {
      return this.mSKU;
    }
    
    public static final class Builder
    {
      private String mCategory = null;
      private final String mName;
      private final long mPriceInMicros;
      private final long mQuantity;
      private final String mSKU;
      
      public Builder(String paramString1, String paramString2, long paramLong1, long paramLong2)
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          if (!TextUtils.isEmpty(paramString2))
          {
            this.mSKU = paramString1;
            this.mName = paramString2;
            this.mPriceInMicros = paramLong1;
            this.mQuantity = paramLong2;
            return;
          }
          throw new IllegalArgumentException("name must not be empty or null");
        }
        throw new IllegalArgumentException("SKU must not be empty or null");
      }
      
      public Transaction.Item build()
      {
        return new Transaction.Item(this, null);
      }
      
      public Builder setProductCategory(String paramString)
      {
        this.mCategory = paramString;
        return this;
      }
    }
  }
  
  public static final class Builder
  {
    private String mAffiliation = null;
    private String mCurrencyCode = null;
    private long mShippingCostInMicros = 0L;
    private final long mTotalCostInMicros;
    private long mTotalTaxInMicros = 0L;
    private final String mTransactionId;
    
    public Builder(String paramString, long paramLong)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.mTransactionId = paramString;
        this.mTotalCostInMicros = paramLong;
        return;
      }
      throw new IllegalArgumentException("orderId must not be empty or null");
    }
    
    public Transaction build()
    {
      return new Transaction(this, null);
    }
    
    public Builder setAffiliation(String paramString)
    {
      this.mAffiliation = paramString;
      return this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      this.mCurrencyCode = paramString;
      return this;
    }
    
    public Builder setShippingCostInMicros(long paramLong)
    {
      this.mShippingCostInMicros = paramLong;
      return this;
    }
    
    public Builder setTotalTaxInMicros(long paramLong)
    {
      this.mTotalTaxInMicros = paramLong;
      return this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Transaction
 * JD-Core Version:    0.7.0.1
 */