package org.gricsan.callifity.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.gricsan.callifity.fragments.HomeBaseFragment;


public class HomePageViewPagerAdapter extends FragmentPagerAdapter {

    private HomeBaseFragment[] mPages;
    private String[] mTabsTitles;

    public HomePageViewPagerAdapter(FragmentManager fm, HomeBaseFragment[] pages) {
        super(fm);
        mPages = pages;
        mTabsTitles = new String[mPages.length];

        for (int i = 0; i < pages.length; i++) {
            mTabsTitles[i] = pages[i].getTabTitle();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mPages[position];
    }

    @Override
    public int getCount() {
        return mPages.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabsTitles[position];
    }
}
