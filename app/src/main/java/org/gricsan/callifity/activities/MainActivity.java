package org.gricsan.callifity.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.activeandroid.ActiveAndroid;

import org.gricsan.callifity.R;
import org.gricsan.callifity.adapters.HomePageViewPagerAdapter;
import org.gricsan.callifity.fragments.HomeBaseFragment;
import org.gricsan.callifity.fragments.HomeDataHomeBaseFragment;
import org.gricsan.callifity.fragments.HomeMealsFragmentHome;
import org.gricsan.callifity.fragments.HomeSportsFragmentHome;
import org.gricsan.callifity.fragments.HomeStatisticsFragmentHome;


public class MainActivity extends HomeBaseActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Resources mResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(this);
        setContentView(R.layout.activity_main);
        LinearLayout layout =(LinearLayout)findViewById(R.id.background);
        layout.setBackgroundResource(0);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mResources = getResources();

        HomeBaseFragment[] mPages = new HomeBaseFragment[]{
                HomeMealsFragmentHome.newInstance(),
                HomeSportsFragmentHome.newInstance(),
                HomeStatisticsFragmentHome.newInstance(),
                HomeDataHomeBaseFragment.newInstance()
        };
        HomePageViewPagerAdapter adapter = new HomePageViewPagerAdapter(getSupportFragmentManager(), mPages);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
