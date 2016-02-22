package org.gricsan.callifity.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import org.gricsan.callifity.R;
import org.gricsan.callifity.adapters.MealsFragmentRecyclerAdapter;

import java.util.ArrayList;

public class HomeMealsFragmentHome extends HomeBaseFragment {

    private static final String TAB_NAME = "MEALS";

    private RecyclerView mRecyclerView;
    private FrameLayout mBottomFrame;
    private MealsFragmentRecyclerAdapter mMealsFragmentRecyclerAdapter;

    public static HomeMealsFragmentHome newInstance() {
        HomeMealsFragmentHome homeMealsFragment = new HomeMealsFragmentHome();

        homeMealsFragment.mTabTitle = TAB_NAME;

        return homeMealsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> mData = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            mData.add("Item " + i);
        }
        mMealsFragmentRecyclerAdapter = new MealsFragmentRecyclerAdapter(mData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_meals, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.meals_fragment_recycler);
        mBottomFrame = (FrameLayout) view.findViewById(R.id.meals_fragment_bottom_frame);
        return view;
    }

}
