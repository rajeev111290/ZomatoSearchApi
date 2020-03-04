package com.singh.rajeev.zomatotest.search.recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.singh.rajeev.zomatotest.R;
import com.singh.rajeev.zomatotest.networking.model.SearchResult;

import java.util.List;



// NOT IN USE

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private List<Integer> searchResults;

    public RecycleViewAdapter(List<Integer> searchResults) {
        this.searchResults = searchResults;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new MyViewHolder(inflater.inflate(R.layout.restaurant_list_card, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        SearchResult searchResult = (SearchResult) searchResults.get(position);
        holder.restaurantName.setText(" test"+searchResults.get(position));
    }

    @Override
    public int getItemCount() {
        if(searchResults==null){
            return 0;
        }
        return searchResults.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView restaurantName;

        MyViewHolder(View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurantName);
        }
    }
}
