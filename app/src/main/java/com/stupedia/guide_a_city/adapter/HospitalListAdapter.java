package com.stupedia.guide_a_city.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stupedia.guide_a_city.R;
import com.stupedia.guide_a_city.interfaces.RecyclerViewItemClick;
import com.stupedia.guide_a_city.model.HospListItemModel;

import java.util.List;

public class HospitalListAdapter extends RecyclerView.Adapter<HospitalListAdapter.ViewHolder> {
    List<HospListItemModel> listItemModels;
    Context context;
    RecyclerViewItemClick recyclerViewItemClick;

    public HospitalListAdapter(List<HospListItemModel> listItemModels, Context context
            , RecyclerViewItemClick recyclerViewItemClick) {
        this.listItemModels = listItemModels;
        this.context = context;
        this.recyclerViewItemClick = recyclerViewItemClick;
    }

    @NonNull
    @Override
    public HospitalListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hospital_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalListAdapter.ViewHolder holder, int position) {

        String title = listItemModels.get(position).getName();
        String desc = listItemModels.get(position).getDescription();
        String rating = listItemModels.get(position).getRating();
        String imageUrl = listItemModels.get(position).getUrl();
        String location = listItemModels.get(position).getLat_lang();

        holder.titleText.setText(title);
        holder.ratingBarText.setText(rating);
        holder.latlangText.setText(location);


    }

    @Override
    public int getItemCount() {
        if (listItemModels != null) {
            return listItemModels.size();
        } else {
            return 0;
        }
    }

    public void setData(List<HospListItemModel> listItemModels) {
        this.listItemModels = listItemModels;
        notifyDataSetChanged();
    }

    public void addNewData(List<HospListItemModel> listItemModels) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleText, descText, latlangText, ratingBarText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hospital_item_imageview);
            titleText = itemView.findViewById(R.id.hospital_item_title);
            latlangText = itemView.findViewById(R.id.hospital_item_latlang);
            ratingBarText = itemView.findViewById(R.id.rating_textview_hospital);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewItemClick.onItemClick(getAdapterPosition());
                }
            });
        }


    }
}
