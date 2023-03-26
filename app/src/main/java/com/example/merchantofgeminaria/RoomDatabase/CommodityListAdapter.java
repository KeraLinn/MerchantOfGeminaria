package com.example.merchantofgeminaria.RoomDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.merchantofgeminaria.R;

import java.util.List;

public class CommodityListAdapter extends RecyclerView.Adapter<CommodityListAdapter.ViewHolder> {

    private int commodityItemLayout;
    private List<CommodityItem> commodityItemList;

    public CommodityListAdapter(int layoutID){
        commodityItemLayout = layoutID;
    }

    public void setCommodityItemList(List<CommodityItem> commodityItemList) {
        this.commodityItemList = commodityItemList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return commodityItemList == null ? 0 : commodityItemList.size();
    }

    @Override
    public CommodityListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(fragment_main, parent, false);
        RecyclerView.ViewHolder myViewHolder = new RecyclerView.ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommodityListAdapter.ViewHolder holder,
                                 final int position) {
        TextView item = holder.item;
        item.setText(commodityItemList.get(commodityItemList).getItemName());
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView item;
        RecyclerView.ViewHolder(View itemView){
            super(itemView);
            item = itemView.findViewById(R.id.fragment_main);
        }
    }

}
