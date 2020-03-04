package com.singh.rajeev.zomatotest.search.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.singh.rajeev.zomatotest.R;
import com.singh.rajeev.zomatotest.common.base.DataBindAdapter;
import com.singh.rajeev.zomatotest.common.base.DataBinder;
import com.singh.rajeev.zomatotest.search.model.CustomSearchData;

public class CuisineListBinder extends DataBinder<CuisineListBinder.ViewHolder> {

    CuisineListBinder(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.cuisine_list_card,
                parent, false));
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        CustomSearchData searchResult = (CustomSearchData) this.adapter.getDataForPosition(position);
        holder.cuisine.setText(searchResult.getCuisine());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView cuisine;

        ViewHolder(View itemView) {
            super(itemView);
            cuisine = itemView.findViewById(R.id.cuisine);
        }
    }
}