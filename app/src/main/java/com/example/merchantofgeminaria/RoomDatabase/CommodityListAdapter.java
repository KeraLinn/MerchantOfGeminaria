package com.example.merchantofgeminaria.RoomDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merchantofgeminaria.R;
import com.example.merchantofgeminaria.ReviewDatabase;

import java.util.List;

public class CommodityListAdapter extends RecyclerView.Adapter<CommodityListAdapter.ViewHolder> {

//    private final int commodityItemLayout;
    private List<CommodityItem> commodityItemList;
/*
    public CommodityListAdapter(ReviewDatabase layoutID){
        commodityItemLayout = layoutID.;
    }*/

    public void setCommodityItemList(List<CommodityItem> commodityItemList) {
        this.commodityItemList = commodityItemList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return commodityItemList == null ? 0 : commodityItemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.db_recyclerview_row, parent,
                false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommodityListAdapter.ViewHolder holder,
                                 final int position) {
        holder.commodityName.setText(commodityItemList.get(position).getItemName());
        holder.commodityPrice.setText(commodityItemList.get(position).getItemPrice());
        holder.commodityLocation.setText(commodityItemList.get(position).getCityLocation());
        holder.commodityImage.setImageResource(commodityItemList.get(position).getItemImage());

    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView commodityName;
        TextView commodityLocation;
        TextView commodityPrice;
        ImageView commodityImage;
        ImageView coinImage;
        ViewHolder(View itemView){
            super(itemView);
            commodityName = itemView.findViewById(R.id.commodityName);
            commodityLocation = itemView.findViewById(R.id.commodityLocation);
            commodityPrice = itemView.findViewById(R.id.commodityPrice);
            commodityImage = itemView.findViewById(R.id.commodityImage);
            coinImage = itemView.findViewById(R.id.coin_image);
        }
    }

}
