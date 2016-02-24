package org.gricsan.callifity.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gricsan.callifity.R;

import java.util.ArrayList;

public class MealsFragmentRecyclerAdapter extends RecyclerView.Adapter<MealsFragmentRecyclerAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private final double PROTEIN_CALORIES = 4.5;
    private final double CARB_CALORIES = 4.5;
    private final double FAT_CALORIES = 9.0;

    public MealsFragmentRecyclerAdapter(ArrayList<String> mData) {
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.meals_adapter_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mProteins.append(" 4.4");
        viewHolder.mCarbs.append(" 16.3");
        viewHolder.mFats.append(" 2.1");

        double proteins = Double.parseDouble(viewHolder.mProteins.getText().toString().split(": ")[1]);
        viewHolder.mProteins.append("g");
        double carbs = Double.parseDouble(viewHolder.mCarbs.getText().toString().split(": ")[1]);
        viewHolder.mCarbs.append("g");
        double fats = Double.parseDouble(viewHolder.mFats.getText().toString().split(": ")[1]);
        viewHolder.mFats.append("g");

        double calories = proteins * PROTEIN_CALORIES + carbs * CARB_CALORIES + fats * FAT_CALORIES;

        viewHolder.mCalories.append(" " + String.valueOf(calories).substring(0, 6) + " kcal");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mRootView;
        private TextView mCalories;
        private TextView mProteins;
        private TextView mCarbs;
        private TextView mFats;
        private FrameLayout mImage;

        public ViewHolder(LinearLayout itemView) {
            super(itemView);
            mRootView = itemView;
            mCalories = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_calories);
            mProteins = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_protein);
            mCarbs = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_carbs);
            mFats = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_fats);
            mImage = (FrameLayout) mRootView.findViewById(R.id.meal_card_image);
        }
    }

}
