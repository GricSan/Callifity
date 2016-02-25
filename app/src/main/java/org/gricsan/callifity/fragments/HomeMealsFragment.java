package org.gricsan.callifity.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gricsan.callifity.R;
import org.gricsan.callifity.adapters.MealsFragmentRecyclerAdapter;
import org.gricsan.callifity.db.FoodItem;
import org.gricsan.callifity.utils.MealUtils;

import java.util.ArrayList;

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

    private MealsFragmentRecyclerAdapter mMealsFragmentRecyclerAdapter;

    public static HomeMealsFragment newInstance() {
        HomeMealsFragment homeMealsFragment = new HomeMealsFragment();

        homeMealsFragment.mTabTitle = TAB_NAME;

        return homeMealsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<FoodItem> data = new ArrayList<>();
        data.add(new FoodItem("Avocado", 2.0, 8.5, 14.7, 160.0, "http://stayfit.pp.ua/wp-content/uploads/2015/12/64500_600.png"));
        data.add(new FoodItem("Greek", 2.0, 8.5, 14.7, 160.0, "http://img1.liveinternet.ru/images/attach/c/10/111/496/111496029_5177462_publication_128219_img228fe3a5356c33457df403041903ee98.png"));
        data.add(new FoodItem("Klubnika", 2.0, 8.5, 14.7, 160.0, "http://img0.liveinternet.ru/images/attach/c/5/86/227/86227496_faa27d0e7877.png"));
        data.add(new FoodItem("Goroshek", 2.0, 8.5, 14.7, 160.0, "http://pagewoman.ru/uploads/fotos/goroh.png"));
        data.add(new FoodItem("Hamburger", 2.0, 8.5, 14.7, 160.0, "http://kylinarocka.ru/wp-content/uploads/2012/10/hamburder-shadow.png"));
        data.add(new FoodItem("French Fries", 2.0, 8.5, 14.7, 160.0, "http://jj-world.com.ua/am/img/parallax/splat.png"));
        mMealsFragmentRecyclerAdapter = new MealsFragmentRecyclerAdapter(data, getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_meals, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.meals_fragment_recycler);
        mRecyclerView.setAdapter(mMealsFragmentRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBottomFrame = (LinearLayout) view.findViewById(R.id.meals_fragment_bottom_frame);

        mTotalProteins = (TextView) mBottomFrame.findViewById(R.id.daily_stats_proteins);
        mTotalCarbs = (TextView) mBottomFrame.findViewById(R.id.daily_stats_carbs);
        mTotalFats = (TextView) mBottomFrame.findViewById(R.id.daily_stats_fats);
        mTotalCalories = (TextView) mBottomFrame.findViewById(R.id.daily_stats_total_cal);
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
