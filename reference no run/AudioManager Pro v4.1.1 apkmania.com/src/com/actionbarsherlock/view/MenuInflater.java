package com.actionbarsherlock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.View;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MenuInflater
{
  private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  private static final String LOG_TAG = "MenuInflater";
  private static final int NO_ID = 0;
  private static final String XML_GROUP = "group";
  private static final String XML_ITEM = "item";
  private static final String XML_MENU = "menu";
  private final Object[] mActionProviderConstructorArguments;
  private final Object[] mActionViewConstructorArguments;
  private Context mContext;
  
  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    ACTION_VIEW_CONSTRUCTOR_SIGNATURE = arrayOfClass;
  }
  
  public MenuInflater(Context paramContext)
  {
    this.mContext = paramContext;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramContext;
    this.mActionViewConstructorArguments = arrayOfObject;
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }
  
  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
    throws XmlPullParserException, IOException
  {
    MenuState localMenuState = new MenuState(paramMenu);
    int k = paramXmlPullParser.getEventType();
    int i = 0;
    String str1 = null;
    while (k != 2)
    {
      k = paramXmlPullParser.next();
      if (k == 1) {
        break label102;
      }
    }
    String str2 = paramXmlPullParser.getName();
    if (!str2.equals("menu")) {
      throw new RuntimeException("Expecting menu, got " + str2);
    }
    k = paramXmlPullParser.next();
    label102:
    int j = 0;
    for (;;)
    {
      if (j != 0) {
        return;
      }
      String str3;
      switch (k)
      {
      case 1: 
        throw new RuntimeException("Unexpected end of document");
      case 2: 
        if (i == 0)
        {
          str3 = paramXmlPullParser.getName();
          if (!str3.equals("group"))
          {
            if (!str3.equals("item"))
            {
              if (!str3.equals("menu"))
              {
                i = 1;
                str1 = str3;
              }
              else
              {
                parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
              }
            }
            else {
              localMenuState.readItem(paramAttributeSet);
            }
          }
          else {
            localMenuState.readGroup(paramAttributeSet);
          }
        }
        break;
      case 3: 
        str3 = paramXmlPullParser.getName();
        if ((i == 0) || (!str3.equals(str1)))
        {
          if (!str3.equals("group"))
          {
            if (!str3.equals("item"))
            {
              if (str3.equals("menu")) {
                j = 1;
              }
            }
            else if (!localMenuState.hasAddedItem()) {
              if ((localMenuState.itemActionProvider == null) || (!localMenuState.itemActionProvider.hasSubMenu())) {
                localMenuState.addItem();
              } else {
                localMenuState.addSubMenuItem();
              }
            }
          }
          else {
            localMenuState.resetGroup();
          }
        }
        else
        {
          i = 0;
          str1 = null;
        }
        break;
      }
      int m = paramXmlPullParser.next();
    }
  }
  
  /* Error */
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 51	com/actionbarsherlock/view/MenuInflater:mContext	Landroid/content/Context;
    //   6: invokevirtual 148	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: iload_1
    //   10: invokevirtual 154	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   13: astore_3
    //   14: aload_0
    //   15: aload_3
    //   16: aload_3
    //   17: invokestatic 160	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   20: aload_2
    //   21: invokespecial 116	com/actionbarsherlock/view/MenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Lcom/actionbarsherlock/view/Menu;)V
    //   24: aload_3
    //   25: ifnull +9 -> 34
    //   28: aload_3
    //   29: invokeinterface 165 1 0
    //   34: return
    //   35: astore 4
    //   37: new 167	android/view/InflateException
    //   40: dup
    //   41: ldc 169
    //   43: aload 4
    //   45: invokespecial 172	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   48: athrow
    //   49: astore 4
    //   51: aload_3
    //   52: ifnull +9 -> 61
    //   55: aload_3
    //   56: invokeinterface 165 1 0
    //   61: aload 4
    //   63: athrow
    //   64: astore 4
    //   66: new 167	android/view/InflateException
    //   69: dup
    //   70: ldc 169
    //   72: aload 4
    //   74: invokespecial 172	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	MenuInflater
    //   0	78	1	paramInt	int
    //   0	78	2	paramMenu	Menu
    //   1	55	3	localXmlResourceParser	android.content.res.XmlResourceParser
    //   35	9	4	localXmlPullParserException	XmlPullParserException
    //   49	13	4	localObject	Object
    //   64	9	4	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	24	35	org/xmlpull/v1/XmlPullParserException
    //   2	24	49	finally
    //   37	49	49	finally
    //   66	78	49	finally
    //   2	24	64	java/io/IOException
  }
  
  private class MenuState
  {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    private ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private boolean itemEnabled;
    private int itemIconResId;
    private int itemId;
    private String itemListenerMethodName;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private boolean itemVisible;
    private Menu menu;
    
    public MenuState(Menu paramMenu)
    {
      this.menu = paramMenu;
      resetGroup();
    }
    
    private char getShortcut(String paramString)
    {
      char c = '\000';
      if (paramString != null) {
        c = paramString.charAt(0);
      }
      return c;
    }
    
    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        localObject1 = MenuInflater.this.mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
        localObject1 = localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Log.w("MenuInflater", "Cannot instantiate class: " + paramString, localException);
          Object localObject2 = null;
        }
      }
      return localObject1;
    }
    
    private void setItem(MenuItem paramMenuItem)
    {
      MenuItem localMenuItem = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
      boolean bool;
      if (this.itemCheckable < 1) {
        bool = false;
      } else {
        bool = true;
      }
      localMenuItem.setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
      if (this.itemShowAsAction >= 0) {
        paramMenuItem.setShowAsAction(this.itemShowAsAction);
      }
      if (this.itemListenerMethodName != null)
      {
        if (!MenuInflater.this.mContext.isRestricted()) {
          paramMenuItem.setOnMenuItemClickListener(new MenuInflater.InflatedOnMenuItemClickListener(MenuInflater.this.mContext, this.itemListenerMethodName));
        }
      }
      else
      {
        if (this.itemCheckable >= 2) {
          if (!(paramMenuItem instanceof MenuItemImpl)) {
            this.menu.setGroupCheckable(this.groupId, true, true);
          } else {
            ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
          }
        }
        int i = 0;
        if (this.itemActionViewClassName != null)
        {
          paramMenuItem.setActionView((View)newInstance(this.itemActionViewClassName, MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionViewConstructorArguments));
          i = 1;
        }
        if (this.itemActionViewLayout > 0) {
          if (i != 0) {
            Log.w("MenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
          } else {
            paramMenuItem.setActionView(this.itemActionViewLayout);
          }
        }
        if (this.itemActionProvider != null) {
          paramMenuItem.setActionProvider(this.itemActionProvider);
        }
        return;
      }
      throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
    }
    
    public void addItem()
    {
      this.itemAdded = true;
      setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }
    
    public SubMenu addSubMenuItem()
    {
      this.itemAdded = true;
      SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
      setItem(localSubMenu.getItem());
      return localSubMenu;
    }
    
    public boolean hasAddedItem()
    {
      return this.itemAdded;
    }
    
    public void readGroup(AttributeSet paramAttributeSet)
    {
      TypedArray localTypedArray = MenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockMenuGroup);
      this.groupId = localTypedArray.getResourceId(1, 0);
      this.groupCategory = localTypedArray.getInt(3, 0);
      this.groupOrder = localTypedArray.getInt(4, 0);
      this.groupCheckable = localTypedArray.getInt(5, 0);
      this.groupVisible = localTypedArray.getBoolean(2, true);
      this.groupEnabled = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
    }
    
    public void readItem(AttributeSet paramAttributeSet)
    {
      TypedArray localTypedArray = MenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockMenuItem);
      this.itemId = localTypedArray.getResourceId(2, 0);
      int i = localTypedArray.getInt(5, this.groupCategory);
      int k = localTypedArray.getInt(6, this.groupOrder);
      this.itemCategoryOrder = (0xFFFF0000 & i | 0xFFFF & k);
      this.itemTitle = localTypedArray.getText(7);
      this.itemTitleCondensed = localTypedArray.getText(8);
      this.itemIconResId = localTypedArray.getResourceId(0, 0);
      this.itemAlphabeticShortcut = getShortcut(localTypedArray.getString(9));
      this.itemNumericShortcut = getShortcut(localTypedArray.getString(10));
      if (!localTypedArray.hasValue(11))
      {
        this.itemCheckable = this.groupCheckable;
      }
      else
      {
        if (!localTypedArray.getBoolean(11, false)) {
          i = 0;
        } else {
          i = 1;
        }
        this.itemCheckable = i;
      }
      this.itemChecked = localTypedArray.getBoolean(3, false);
      this.itemVisible = localTypedArray.getBoolean(4, this.groupVisible);
      this.itemEnabled = localTypedArray.getBoolean(1, this.groupEnabled);
      TypedValue localTypedValue = new TypedValue();
      localTypedArray.getValue(13, localTypedValue);
      int j;
      if (localTypedValue.type != 17) {
        j = -1;
      } else {
        j = j.data;
      }
      this.itemShowAsAction = j;
      this.itemListenerMethodName = localTypedArray.getString(12);
      this.itemActionViewLayout = localTypedArray.getResourceId(14, 0);
      this.itemActionViewClassName = localTypedArray.getString(15);
      this.itemActionProviderClassName = localTypedArray.getString(16);
      if (this.itemActionProviderClassName == null) {
        j = 0;
      } else {
        j = 1;
      }
      if ((j == 0) || (this.itemActionViewLayout != 0) || (this.itemActionViewClassName != null))
      {
        if (j != 0) {
          Log.w("MenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
        }
        this.itemActionProvider = null;
      }
      else
      {
        this.itemActionProvider = ((ActionProvider)newInstance(this.itemActionProviderClassName, MenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionProviderConstructorArguments));
      }
      localTypedArray.recycle();
      this.itemAdded = false;
    }
    
    public void resetGroup()
    {
      this.groupId = 0;
      this.groupCategory = 0;
      this.groupOrder = 0;
      this.groupCheckable = 0;
      this.groupVisible = true;
      this.groupEnabled = true;
    }
  }
  
  private static class InflatedOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] PARAM_TYPES;
    private Context mContext;
    private Method mMethod;
    
    static
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = MenuItem.class;
      PARAM_TYPES = arrayOfClass;
    }
    
    public InflatedOnMenuItemClickListener(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      Object localObject = paramContext.getClass();
      try
      {
        this.mMethod = ((Class)localObject).getMethod(paramString, PARAM_TYPES);
        return;
      }
      catch (Exception localException)
      {
        localObject = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + ((Class)localObject).getName());
        ((InflateException)localObject).initCause(localException);
        throw ((Throwable)localObject);
      }
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      boolean bool = true;
      try
      {
        Object localObject2;
        Context localContext;
        Object localObject1;
        if (this.mMethod.getReturnType() == Boolean.TYPE)
        {
          localObject2 = this.mMethod;
          localContext = this.mContext;
          localObject1 = new Object[1];
          localObject1[0] = paramMenuItem;
          bool = ((Boolean)((Method)localObject2).invoke(localContext, (Object[])localObject1)).booleanValue();
        }
        else
        {
          localObject1 = this.mMethod;
          localContext = this.mContext;
          localObject2 = new Object[1];
          localObject2[0] = paramMenuItem;
          ((Method)localObject1).invoke(localContext, (Object[])localObject2);
        }
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
      return bool;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.view.MenuInflater
 * JD-Core Version:    0.7.0.1
 */