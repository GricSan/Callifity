package org.gricsan.callifity.fragments;

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

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.android.Utils;

import org.gricsan.callifity.R;
import org.gricsan.callifity.adapters.MealsFragmentRecyclerAdapter;
import org.gricsan.callifity.db.FoodItem;
import org.gricsan.callifity.db.MealItem;
import org.gricsan.callifity.utils.DAOUtils;
import org.gricsan.callifity.utils.MealUtils;

import java.util.HashMap;
import java.util.Map;

public class HomeMealsFragment extends HomeBaseFragment {

    private static final String TAB_NAME = "MEALS";

    private RecyclerView mRecyclerView;

    private TextView mTotalProteins;
    private TextView mTotalCarbs;
    private TextView mTotalFats;
    private TextView mTotalCalories;
    private TextView mCaloryLimit;
    private TextView mCaloryBalance;

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
        mEatButton = (ImageButton) view.findViewById(R.id.meals_fragment_fab);
        LinearLayout mBottomFrame = (LinearLayout) view.findViewById(R.id.meals_fragment_bottom_frame);
        Map config = new HashMap();
        config.put("cloud_name", "duzolgrco");
        config.put("api_key", "775383968365434");
        config.put("api_secret", "cc4FMIMd7gx4qafHSlj_ysrGRAs");
        final Cloudinary cloudinary = new Cloudinary(config);

        mEatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder aBuilder = new AlertDialog.Builder(getContext());
                aBuilder.setView(R.layout.meals_fragment_eat_dialog);
                aBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DAOUtils.registerMeals(new MealItem(
                                new FoodItem("Mango", 0.5, 11.5, 0.3, 67.0,
                                        cloudinary.url().transformation(new Transformation().width(200).crop("scale")).generate("Mango_fedguz.jpg")), 213.23));
                        mMealsFragmentRecyclerAdapter.setData(DAOUtils.getAllDailyMeals());
                        mMealsFragmentRecyclerAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                        refreshTotalNutritonValues();
                    }
                });
                aBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mMealsFragmentRecyclerAdapter.getItemCount() >= 1) {
                            DAOUtils.removeMealItem(mMealsFragmentRecyclerAdapter.getData().get(mMealsFragmentRecyclerAdapter.getItemCount() - 1));
                            mMealsFragmentRecyclerAdapter.setData(DAOUtils.getAllDailyMeals());
                            mMealsFragmentRecyclerAdapter.notifyDataSetChanged();
                        }
                        dialog.dismiss();
                        refreshTotalNutritonValues();
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
        mCaloryLimit = (TextView) mBottomFrame.findViewById(R.id.daily_stats_cal_limit);
        mCaloryBalance = (TextView) mBottomFrame.findViewById(R.id.daily_stats_cal_balance);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshTotalNutritonValues();
    }

    private void refreshTotalNutritonValues() {
        mTotalCalories.setText(MealUtils.getTotalDailyCalories(mMealsFragmentRecyclerAdapter.getData()));
        mTotalProteins.setText(MealUtils.getTotalDailyProteins(mMealsFragmentRecyclerAdapter.getData()));
        mTotalCarbs.setText(MealUtils.getTotalDailyCarbs(mMealsFragmentRecyclerAdapter.getData()));
        mTotalFats.setText(MealUtils.getTotalDailyFats(mMealsFragmentRecyclerAdapter.getData()));
    }
}
