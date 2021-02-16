package com.stupedia.guide_a_city.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.model.CategoriesModel;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesViewHolder> {

    List<CategoriesModel> mostViewedLocations;

    public CategoriesAdapter(List<CategoriesModel> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_items, parent, false);
        AdapterAllCategoriesViewHolder lvh = new AdapterAllCategoriesViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {
        holder.textView.setText(mostViewedLocations.get(position).getTitle());
        holder.imageView.setImageResource(mostViewedLocations.get(position).getImage());
        holder.relativeLayout.setBackground(mostViewedLocations.get(position).getGradient());

    }

    public void setData(List<CategoriesModel> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mostViewedLocations != null) {
            return mostViewedLocations.size();
        } else {
            return 0;
        }
    }

    public static class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.category_layout_back);
            imageView = itemView.findViewById(R.id.category_img);
            textView = itemView.findViewById(R.id.category_title);
        }
    }
}