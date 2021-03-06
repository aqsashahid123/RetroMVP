package pf.aqsa.com.retromvp.View;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import pf.aqsa.com.retromvp.Presenter.HomeScreenBasicMethods;
import pf.aqsa.com.retromvp.Presenter.HomeScreenViewPresenter;
import pf.aqsa.com.retromvp.R;

public class HomeScreen extends AppCompatActivity  {

//implements HomeScreenBasicMethods
    Toolbar toolbar;

    DrawerLayout mDrawer;
    NavigationView nav_view;
    HomeScreenBasicMethods presenter;
     TabLayout tabLayout;
    private ViewPager viewPager;

    TextView tvName,tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("RetroMVP");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

       // presenter = new HomeScreenPresenterCompl(this);
        presenter = new HomeScreenViewPresenter(this);
        mDrawer = (DrawerLayout) findViewById(R.id.mDrawer);
        nav_view = (NavigationView) findViewById(R.id.nav_view);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);

        presenter.setTabs(tabLayout,viewPager);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            presenter.setNaigationItemClickListener(item,mDrawer);

                return true;
            }
        });

      //  setTabs(tabLayout,viewPager);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){

                    case (R.id.openMenu):
                        mDrawer.openDrawer(Gravity.END);
                        break;


                }

                return true;
            }
        });


        View headerLayout = nav_view.getHeaderView(0);

        tvName = (TextView) headerLayout.findViewById(R.id.userName);
        tvEmail = (TextView) headerLayout.findViewById(R.id.tvEmail);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //SharedPreferences.Editor editor = prefs.edit();


      //  prefs.getString("id","");



        tvEmail.setText( prefs.getString("email",""));
        tvName.setText( prefs.getString("userName",""));
///////////////////////////////////////////////////////////////////////////////////
//        tvEmail.setText( "EMAIL");
//        tvName.setText( "USERNAME");

//        nav_view.setNavigationItemSelectedListener(
//                new NavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        mDrawer.closeDrawer(GravityCompat.START);
//                        switch (item.getItemId()) {
//                            case R.id.profile:
//                                mPresenter.onDrawerOptionAboutClick();
//                                return true;
//                            case R.id.nav_item_rate_us:
//                                mPresenter.onDrawerRateUsClick();
//                                return true;
//                            case R.id.nav_item_feed:
//                                mPresenter.onDrawerMyFeedClick();
//                                return true;
//                            case R.id.nav_item_logout:
//                                mPresenter.onDrawerOptionLogoutClick();
//                                return true;
//                            default:
//                                return false;
//                        }
//                    }
//                });

    }

}
