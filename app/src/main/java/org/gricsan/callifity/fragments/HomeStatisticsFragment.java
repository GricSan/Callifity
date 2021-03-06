package org.gricsan.callifity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gricsan.callifity.R;

public class HomeStatisticsFragment extends HomeBaseFragment {

    private static final String TAB_NAME = "STATS";

    public static HomeStatisticsFragment newInstance() {
        HomeStatisticsFragment homeStatisticsFragment = new HomeStatisticsFragment();

        homeStatisticsFragment.mTabTitle = TAB_NAME;

        return homeStatisticsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_statistics, container, false);
    }

}
