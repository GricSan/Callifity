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

    public MealsFragmentRecyclerAdapter(ArrayList<String> mData) {
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.meals_adapter_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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
