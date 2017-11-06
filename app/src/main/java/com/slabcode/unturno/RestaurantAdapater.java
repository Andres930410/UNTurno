package com.slabcode.unturno;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class RestaurantAdapater extends RecyclerView.Adapter<RestaurantAdapater.ViewHolder> {
    private List<String> restaurants;
    private OnRestaurantClickListener onRestaurantClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView restaurantName;
        public LinearLayout linearLayout;

        public ViewHolder(View v){
            super(v);
            restaurantName = v.findViewById(R.id.restaurant_name);
            linearLayout = v.findViewById(R.id.restaurant_linear);
        }
    }

    public RestaurantAdapater(List<String> restaurants, OnRestaurantClickListener onRestaurantClickListener){
        this.restaurants = restaurants;
        this.onRestaurantClickListener = onRestaurantClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.restaurantName.setText(restaurants.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRestaurantClickListener.onItemClick(restaurants.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public interface OnRestaurantClickListener{
        void onItemClick(String c);

    }
}
