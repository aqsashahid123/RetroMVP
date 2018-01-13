package pf.aqsa.com.retromvp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
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

import javax.inject.Inject;

import pf.aqsa.com.retromvp.Presenter.HomeScreenPresenter;
import pf.aqsa.com.retromvp.Presenter.HomeScreenPresenterCompl;
import pf.aqsa.com.retromvp.View.HomeScreenViewPresenter;
import pf.aqsa.com.retromvp.View.ViewPresenter;

public class HomeScreen extends AppCompatActivity implements HomeScreenPresenter {


    Toolbar toolbar;

    DrawerLayout mDrawer;
    NavigationView nav_view;
    HomeScreenPresenter presenter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    TextView tvName,tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("RetroMVP");

        presenter = new HomeScreenPresenterCompl(this);
        mDrawer = (DrawerLayout) findViewById(R.id.mDrawer);
        nav_view = (NavigationView) findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_profile:
                        mDrawer.closeDrawer(Gravity.RIGHT);
                        break;

                    case R.id.nav_settings:
                        break;

                }


                return true;
            }
        });


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

    @Override
    public void onProfileClicked() {

    }

    @Override
    public void onSettingsClicked() {

    }

    @Override
    public void setUpDrawer() {

//
//        setSupportActionBar(mToolbar);
//        mDrawerToggle = new ActionBarDrawerToggle(
//                this,
//                mDrawer,
//                mToolbar,
//                R.string.open_drawer,
//                R.string.close_drawer) {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//                hideKeyboard();
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//        };
//        mDrawer.addDrawerListener(mDrawerToggle);
//        mDrawerToggle.syncState();
//        setupNavMenu();
//        mPresenter.onNavMenuCreated();
//        setupCardContainerView();
//        mPresenter.onViewInitialized();



    }


    public void setUpNav(){


        View headerLayout = nav_view.getHeaderView(0);

        tvName = (TextView) headerLayout.findViewById(R.id.userName);
        tvEmail = (TextView) headerLayout.findViewById(R.id.tvEmail);


    }
}
