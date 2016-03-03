package org.gricsan.callifity.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.activeandroid.ActiveAndroid;

import org.gricsan.callifity.R;
import org.gricsan.callifity.adapters.HomePageViewPagerAdapter;
import org.gricsan.callifity.db.FoodItem;
import org.gricsan.callifity.db.MealItem;
import org.gricsan.callifity.fragments.HomeBaseFragment;
import org.gricsan.callifity.fragments.HomeDataBaseFragment;
import org.gricsan.callifity.fragments.HomeMealsFragment;
import org.gricsan.callifity.fragments.HomeSportsFragment;
import org.gricsan.callifity.fragments.HomeStatisticsFragment;
import org.gricsan.callifity.utils.DAOUtils;
import org.gricsan.callifity.utils.MealUtils;


public class MainActivity extends HomeBaseActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Resources mResources;


    // TODO: 03/03/2016 add Cloudinary support
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActiveAndroid.initialize(this);
        setContentView(R.layout.activity_main);
        LinearLayout layout = (LinearLayout) findViewById(R.id.background);
        layout.setBackgroundResource(0);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mResources = getResources();

        HomeBaseFragment[] mPages = new HomeBaseFragment[]{
                HomeMealsFragment.newInstance(),
                HomeSportsFragment.newInstance(),
                HomeStatisticsFragment.newInstance(),
                HomeDataBaseFragment.newInstance()
        };
        HomePageViewPagerAdapter adapter = new HomePageViewPagerAdapter(getSupportFragmentManager(), mPages);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
