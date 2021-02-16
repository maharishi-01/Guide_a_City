package com.stupedia.guide_a_city.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.model.FeaturedModel;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedModel> featuredLocations;
    //this will hold the data
    public FeaturedAdapter(ArrayList<FeaturedModel> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);


        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        FeaturedModel featuredModel = featuredLocations.get(position);

        holder.image.setImageResource(featuredModel.getImage());
        holder.title.setText(featuredModel.getTitle());
        holder.desc.setText(featuredModel.getDescription());


    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }
    //this will hold the design and view of recycler view

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{


        ImageView image;
        TextView title,desc;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks

            image= itemView.findViewById(R.id.featured_image);
            title= itemView.findViewById(R.id.featured_title);
            desc= itemView.findViewById(R.id.featured_desc);

        }
    }





}
