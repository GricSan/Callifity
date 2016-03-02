package org.gricsan.callifity.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gricsan.callifity.R;
import org.gricsan.callifity.adapters.MealsFragmentRecyclerAdapter;
import org.gricsan.callifity.utils.DAOUtils;
import org.gricsan.callifity.utils.MealUtils;

public class HomeMealsFragment extends HomeBaseFragment {

    private static final String TAB_NAME = "MEALS";

    private RecyclerView mRecyclerView;

    private LinearLayout mBottomFrame;

    private TextView mTotalProteins;
    private TextView mTotalCarbs;
    private TextView mTotalFats;
    private TextView mTotalCalories;
    private TextView mColoryLimit;
    private TextView mColoryBalance;

    private ImageButton mEatButton;

    private MealsFragmentRecyclerAdapter mMealsFragmentRecyclerAdapter;

    public static HomeMealsFragment newInstance() {
        HomeMealsFragment homeMealsFragment = new HomeMealsFragment();

        homeMealsFragment.mTabTitle = TAB_NAME;

        return homeMealsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMealsFragmentRecyclerAdapter = new MealsFragmentRecyclerAdapter(DAOUtils.getAllDailyMeals(), getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_meals, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.meals_fragment_recycler);
        mRecyclerView.setAdapter(mMealsFragmentRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBottomFrame = (LinearLayout) view.findViewById(R.id.meals_fragment_bottom_frame);
        mEatButton = (ImageButton) view.findViewById(R.id.meals_fragment_fab);
        mEatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder aBuilder = new AlertDialog.Builder(getContext());
                aBuilder.setMessage("Hello there, I'm a dialog!");
                aBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                aBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = aBuilder.create();
                dialog.show();
            }
        });

        mTotalCalories = (TextView) mBottomFrame.findViewById(R.id.daily_stats_total_cal);
        mTotalProteins = (TextView) mBottomFrame.findViewById(R.id.daily_stats_proteins);
        mTotalCarbs = (TextView) mBottomFrame.findViewById(R.id.daily_stats_carbs);
        mTotalFats = (TextView) mBottomFrame.findViewById(R.id.daily_stats_fats);
        mColoryLimit = (TextView) mBottomFrame.findViewById(R.id.daily_stats_cal_limit);
        mColoryBalance = (TextView) mBottomFrame.findViewById(R.id.daily_stats_cal_balance);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mTotalCalories.setText(MealUtils.getTotalCalories(mMealsFragmentRecyclerAdapter.getData()));
        mTotalProteins.setText(MealUtils.getTotalProteins(mMealsFragmentRecyclerAdapter.getData()));
        mTotalCarbs.setText(MealUtils.getTotalCarbs(mMealsFragmentRecyclerAdapter.getData()));
        mTotalFats.setText(MealUtils.getTotalFats(mMealsFragmentRecyclerAdapter.getData()));
    }
}
