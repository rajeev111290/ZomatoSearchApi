package com.singh.rajeev.zomatotest.search.recycleview;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.singh.rajeev.zomatotest.R;
import com.singh.rajeev.zomatotest.common.base.DataBindAdapter;
import com.singh.rajeev.zomatotest.common.base.DataBinder;
import com.singh.rajeev.zomatotest.networking.model.Restaurant;
import com.singh.rajeev.zomatotest.networking.model.SearchResult;

public class RestaurantListBinder extends DataBinder<RestaurantListBinder.ViewHolder> {

    RestaurantListBinder(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.restaurant_list_card,
                parent, false));
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        SearchResult searchResult = (SearchResult) this.adapter.getDataForPosition(position);
        Restaurant restaurant = searchResult.getRestaurant();
        holder.restaurantName.setText(restaurant.getName());
        holder.cuisine.setText(restaurant.getCuisines());
        holder.cost.setText("₹" + (restaurant.getAverageCostForTwo() / 2) + " per person");
        holder.time.setText("Timings: " + restaurant.getTimings());
        Glide.with(holder.restaurantName.getContext())
                .load(restaurant.getThumb())
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(holder.image);
        holder.ratingBar.setRating(Float.parseFloat(restaurant.getUserRating().getAggregateRating()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView restaurantName, cost, cuisine, time;
        RatingBar ratingBar;

        ViewHolder(View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            image = itemView.findViewById(R.id.image);
            cost = itemView.findViewById(R.id.cost);
            cuisine = itemView.findViewById(R.id.cuisine);
            time = itemView.findViewById(R.id.time);
            ratingBar = itemView.findViewById(R.id.ratingBar);

        }
    }
}