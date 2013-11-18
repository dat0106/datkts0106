package com.hitek.settingsscheduler;

import android.content.Context;
import android.content.res.Resources;

public class TaskTypes
{
  private String[] taskTypeArray;
  
  public TaskTypes(Context paramContext)
  {
    String[] arrayOfString = new String[12];
    arrayOfString[0] = paramContext.getResources().getString(2131034129);
    arrayOfString[1] = paramContext.getResources().getString(2131034119);
    arrayOfString[2] = paramContext.getResources().getString(2131034120);
    arrayOfString[3] = paramContext.getResources().getString(2131034121);
    arrayOfString[4] = paramContext.getResources().getString(2131034122);
    arrayOfString[5] = (paramContext.getResources().getString(2131034123) + "-" + paramContext.getResources().getString(2131034125));
    arrayOfString[6] = (paramContext.getResources().getString(2131034123) + "-" + paramContext.getResources().getString(2131034124));
    arrayOfString[7] = (paramContext.getResources().getString(2131034123) + "-" + paramContext.getResources().getString(2131034127));
    arrayOfString[8] = (paramContext.getResources().getString(2131034123) + "-" + paramContext.getResources().getString(2131034128));
    arrayOfString[9] = (paramContext.getResources().getString(2131034123) + "-" + paramContext.getResources().getString(2131034126));
    arrayOfString[10] = paramContext.getResources().getString(2131034131);
    arrayOfString[11] = (paramContext.getResources().getString(2131034131) + "-" + paramContext.getResources().getString(2131034132));
    this.taskTypeArray = arrayOfString;
  }
  
  public int getTaskTypeImage(int paramInt)
  {
    int i = 2130837517;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5)
              {
                if (paramInt != 6)
                {
                  if (paramInt != 7)
                  {
                    if (paramInt != 8)
                    {
                      if (paramInt != 9)
                      {
                        if ((paramInt != 10) && (paramInt != 11)) {
                          if (paramInt != 12) {
                            i = 2130837513;
                          } else {
                            i = 2130837515;
                          }
                        }
                      }
                      else {
                        i = 2130837519;
                      }
                    }
                    else {
                      i = 2130837519;
                    }
                  }
                  else {
                    i = 2130837519;
                  }
                }
                else {
                  i = 2130837519;
                }
              }
              else {
                i = 2130837519;
              }
            }
            else {
              i = 2130837520;
            }
          }
          else {
            i = 2130837519;
          }
        }
        else {
          i = 2130837507;
        }
      }
      else {
        i = 2130837521;
      }
    }
    return i;
  }
  
  public int getTaskTypeIndex(String paramString)
  {
    for (int i = 0; i < this.taskTypeArray.length; i++) {
      if (this.taskTypeArray[i].equals(paramString)) {
        return i;
      }
    }
    i = -1;
    return i;
  }
  
  public String getTaskTypeString(int paramInt)
  {
    return this.taskTypeArray[paramInt];
  }
  
  public String[] getTaskTypesArray()
  {
    return this.taskTypeArray;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.TaskTypes
 * JD-Core Version:    0.7.0.1
 */