package org.gricsan.callifity.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.gricsan.callifity.R;
import org.gricsan.callifity.db.FoodItem;
import org.gricsan.callifity.utils.MealUtils;

import java.util.ArrayList;

public class MealsFragmentRecyclerAdapter extends RecyclerView.Adapter<MealsFragmentRecyclerAdapter.ViewHolder> {

    private ArrayList<FoodItem> mData;
    private Context mContext;

    public MealsFragmentRecyclerAdapter(ArrayList<FoodItem> data, Context context) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.meals_adapter_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        FoodItem foodItem = mData.get(position);
        viewHolder.mName.append(" " + foodItem.getName());
        viewHolder.mCalories.append(MealUtils.convertToCalories(foodItem.getCalories()));
        viewHolder.mProteins.append(MealUtils.convertToGramms(foodItem.getProteins()));
        viewHolder.mCarbs.append(MealUtils.convertToGramms(foodItem.getCarbs()));
        viewHolder.mFats.append(MealUtils.convertToGramms(foodItem.getFats()));
        if (foodItem.getImageUrl().equals("")) {
            viewHolder.mImage.setImageResource(R.color.home_selected_tab_text_color);
        } else {
            Picasso.with(mContext).load(foodItem.getImageUrl()).fit().into(viewHolder.mImage);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mRootView;
        private TextView mName;
        private TextView mCalories;
        private TextView mProteins;
        private TextView mCarbs;
        private TextView mFats;
        private ImageView mImage;

        public ViewHolder(LinearLayout itemView) {
            super(itemView);
            mRootView = itemView;
            mName = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_name);
            mCalories = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_calories);
            mProteins = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_protein);
            mCarbs = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_carbs);
            mFats = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_fats);
            mImage = (ImageView) mRootView.findViewById(R.id.meal_card_image);
        }
    }

}
