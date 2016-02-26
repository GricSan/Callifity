package org.gricsan.callifity.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.gricsan.callifity.R;
import org.gricsan.callifity.db.FoodItem;
import org.gricsan.callifity.utils.MealUtils;

import java.util.List;

public class MealsFragmentRecyclerAdapter extends RecyclerView.Adapter<MealsFragmentRecyclerAdapter.ViewHolder> {

    private List<FoodItem> mData;
    private Context mContext;

    public MealsFragmentRecyclerAdapter(List<FoodItem> data, Context context) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.meals_adapter_viewholder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        FoodItem foodItem = mData.get(position);
        viewHolder.mName.setText(MealUtils.convertToProductNameString(foodItem.getName()));
        viewHolder.mCalories.setText(MealUtils.convertToCaloriesString(foodItem.getCalories()));
        viewHolder.mProteins.setText(MealUtils.convertToProteinsString(foodItem.getProteins()));
        viewHolder.mCarbs.setText(MealUtils.convertToCarbsString(foodItem.getCarbs()));
        viewHolder.mFats.setText(MealUtils.convertToFatsString(foodItem.getFats()));
        Target picassoTarget = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                viewHolder.mImage.setImageBitmap(bitmap);
                viewHolder.mImage.setVisibility(View.VISIBLE);
                viewHolder.mImageMask.setVisibility(View.VISIBLE);
                viewHolder.mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                viewHolder.mImage.setImageResource(R.drawable.food_item_no_image);
                viewHolder.mImage.setVisibility(View.VISIBLE);
                viewHolder.mImageMask.setVisibility(View.VISIBLE);
                viewHolder.mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
        viewHolder.mImage.setTag(picassoTarget);
        Picasso.with(mContext).load(foodItem.getImageUrl()).into(picassoTarget);
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
        private ImageView mImageMask;
        private ProgressBar mProgressBar;

        public ViewHolder(LinearLayout itemView) {
            super(itemView);
            mRootView = itemView;
            mName = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_name);
            mCalories = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_calories);
            mProteins = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_protein);
            mCarbs = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_carbs);
            mFats = (TextView) mRootView.findViewById(R.id.meal_card_nutrition_fats);
            mImage = (ImageView) mRootView.findViewById(R.id.meal_card_image);
            mImageMask = (ImageView) mRootView.findViewById(R.id.meal_card_image_mask);
            mProgressBar = (ProgressBar) mRootView.findViewById(R.id.image_progress_bar);
        }
    }

    public List<FoodItem> getData() {
        return mData;
    }

}
