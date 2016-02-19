package org.gricsan.callifity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gricsan.callifity.R;

public class HomeDataHomeBaseFragment extends HomeBaseFragment {

    private static final String TAB_NAME = "DB";

    public static HomeDataHomeBaseFragment newInstance() {
        HomeDataHomeBaseFragment homeDataBaseFragment = new HomeDataHomeBaseFragment();

        homeDataBaseFragment.mTabTitle = TAB_NAME;

        return homeDataBaseFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_database, container, false);
    }

}
