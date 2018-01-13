package pf.aqsa.com.retromvp.Presenter;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

/**
 * Created by Mahek on 1/13/2018.
 */

public interface HomeScreenBasicMethods {

    public void setTabs(TabLayout tabLayout, ViewPager pager);
    public void setNaigationItemClickListener(MenuItem item, DrawerLayout mDrawer);


}
