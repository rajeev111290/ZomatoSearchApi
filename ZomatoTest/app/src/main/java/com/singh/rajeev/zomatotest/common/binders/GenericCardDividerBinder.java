package com.singh.rajeev.zomatotest.common.binders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.singh.rajeev.zomatotest.R;
import com.singh.rajeev.zomatotest.common.base.DataBindAdapter;
import com.singh.rajeev.zomatotest.common.base.DataBinder;

public class GenericCardDividerBinder extends DataBinder<GenericCardDividerBinder.ViewHolder> {

    public GenericCardDividerBinder(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_divider, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View divider;
        public ViewHolder(View itemView) {
            super(itemView);
            this.divider=itemView.findViewById(R.id.divider);
        }
    }
}
