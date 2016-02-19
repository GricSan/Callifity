package org.gricsan.callifity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gricsan.callifity.R;

public class HomeSportsFragmentHome extends HomeBaseFragment {

    private static final String TAB_NAME = "SPORTS";

    public static HomeSportsFragmentHome newInstance() {
        HomeSportsFragmentHome homeSportsFragment = new HomeSportsFragmentHome();

        homeSportsFragment.mTabTitle = TAB_NAME;

        return homeSportsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_sports, container, false);
    }

}
