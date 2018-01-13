package pf.aqsa.com.retromvp.View;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import pf.aqsa.com.retromvp.HomeScreen;
import pf.aqsa.com.retromvp.Presenter.HomeScreenBasicMethods;
import pf.aqsa.com.retromvp.Presenter.HomeScreenPresenter;
import pf.aqsa.com.retromvp.R;

/**
 * Created by AQSA SHaaPARR on 1/13/2018.
 */

public class HomeScreenViewPresenter implements HomeScreenBasicMethods {

    Context context;
    Activity activity;
    android.support.v4.app.FragmentManager fragmentManager;
    public   HomeScreenViewPresenter(Context context){
        this.context = context;

    }
    public void closeDrawer(){




    }


    @Override
    public void setTabs(TabLayout tabLayout, final ViewPager viewPager) {
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        try{
         activity = (Activity) context;

            // Return the fragment manager
            fragmentManager = ((HomeScreen)context ).getSupportFragmentManager();
            // If using the Support lib.
            // return activity.getSupportFragmentManager();

        } catch (ClassCastException e) {
            Log.d("Errorrrrr", "Can't get the fragment manager with this");
        }

        PagerAdapter adapter = new PagerAdapter(fragmentManager, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void setNaigationItemClickListener(MenuItem item, DrawerLayout mDrawer) {


        switch (item.getItemId()){

            case R.id.nav_profile:
                mDrawer.closeDrawer(Gravity.RIGHT);
                Toast.makeText(context.getApplicationContext(),"Profile",Toast.LENGTH_SHORT).show();

                break;

            case R.id.nav_settings:
                mDrawer.closeDrawer(Gravity.RIGHT);
                Toast.makeText(context.getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();


                break;



    }










    }
}
