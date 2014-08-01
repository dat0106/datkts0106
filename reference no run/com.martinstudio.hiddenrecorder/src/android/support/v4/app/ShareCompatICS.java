package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class ShareCompatICS
{
  private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
  
  public static void configureMenuItem(MenuItem paramMenuItem, Activity paramActivity, Intent paramIntent)
  {
    Object localObject = paramMenuItem.getActionProvider();
    if ((localObject instanceof ShareActionProvider)) {
      localObject = (ShareActionProvider)localObject;
    } else {
      localObject = new ShareActionProvider(paramActivity);
    }
    ((ShareActionProvider)localObject).setShareHistoryFileName(".sharecompat_" + paramActivity.getClass().getName());
    ((ShareActionProvider)localObject).setShareIntent(paramIntent);
    paramMenuItem.setActionProvider((ActionProvider)localObject);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ShareCompatICS
 * JD-Core Version:    0.7.0.1
 */