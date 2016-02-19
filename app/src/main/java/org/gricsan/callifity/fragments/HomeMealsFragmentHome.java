package org.gricsan.callifity.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gricsan.callifity.R;

public class HomeMealsFragmentHome extends HomeBaseFragment {

    private static final String TAB_NAME = "MEALS";

    public static HomeMealsFragmentHome newInstance() {
        HomeMealsFragmentHome homeMealsFragment = new HomeMealsFragmentHome();

        homeMealsFragment.mTabTitle = TAB_NAME;

        return homeMealsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_meals, container, false);
    }

}
