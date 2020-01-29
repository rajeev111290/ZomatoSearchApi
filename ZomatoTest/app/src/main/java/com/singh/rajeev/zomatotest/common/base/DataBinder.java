package com.singh.rajeev.zomatotest.common.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

abstract public class DataBinder<T extends RecyclerView.ViewHolder> {

    protected DataBindAdapter adapter;

    public DataBinder(DataBindAdapter dataBindAdapter) {
        adapter = dataBindAdapter;
    }

    abstract public T newViewHolder(ViewGroup parent);

    abstract public void bindViewHolder(T holder, int position);

    public final void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }

}

