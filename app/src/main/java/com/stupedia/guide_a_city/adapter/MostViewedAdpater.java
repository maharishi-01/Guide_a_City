package com.stupedia.guide_a_city.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.model.MostViewedModel;

import java.util.List;

public class MostViewedAdpater extends RecyclerView.Adapter<MostViewedAdpater.MostViewedViewHolder> {

    List<MostViewedModel> mostViewedLocations;

    public MostViewedAdpater(List<MostViewedModel> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        MostViewedModel helperClass = mostViewedLocations.get(position);

        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitle());
    }

    public void setData(List<MostViewedModel> mostViewedLocations) {
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

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.mv_image);

            textView = itemView.findViewById(R.id.mv_title);
        }
    }
}