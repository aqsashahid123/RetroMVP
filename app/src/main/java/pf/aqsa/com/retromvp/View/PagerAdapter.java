package pf.aqsa.com.retromvp.View;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import pf.aqsa.com.retromvp.View.Fragments.TabOneFragment;
import pf.aqsa.com.retromvp.View.Fragments.TabThreeFrag;
import pf.aqsa.com.retromvp.View.Fragments.TabTwoFragment;

/**
 * Created by Mahek on 1/13/2018.
 */




    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    TabOneFragment tab1 = new TabOneFragment();
                    return tab1;
                case 1:
                    TabTwoFragment tab2 = new TabTwoFragment();
                    return tab2;
                case 2:
                    TabThreeFrag tab3 = new TabThreeFrag();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }


}
