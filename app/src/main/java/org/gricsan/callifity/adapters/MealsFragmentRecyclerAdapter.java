package org.gricsan.callifity.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gricsan.callifity.R;

import java.util.ArrayList;

public class MealsFragmentRecyclerAdapter extends RecyclerView.Adapter<MealsFragmentRecyclerAdapter.ViewHolder> {

    private ArrayList<String> mData;

    public MealsFragmentRecyclerAdapter() {
        mData = new ArrayList<>();
    }

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
//        holder.mTextFiel.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout mRootView;
        private TextView mTextFiel;

        public ViewHolder(LinearLayout itemView) {
            super(itemView);
            mRootView = itemView;
            mTextFiel = (TextView) mRootView.findViewById(R.id.vh_textview);
        }
    }

}
