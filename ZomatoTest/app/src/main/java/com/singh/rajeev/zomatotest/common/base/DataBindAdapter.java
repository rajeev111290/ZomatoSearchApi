package com.singh.rajeev.zomatotest.common.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.singh.rajeev.zomatotest.common.Constants;
import com.singh.rajeev.zomatotest.common.binders.GenericCardDividerBinder;

import java.util.HashMap;
import java.util.List;

public class DataBindAdapter<M extends BaseModel> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected SparseArray<DataBinder> binders;

    public List<M> data;

    private int
            headerIndex = Constants.HEADERS_START_INDEX,
            footerIndex = Constants.FOOTERS_START_INDEX,
            headersCount, footersCount;

    private HashMap<Integer, Integer> supportedType = new HashMap<>();


    public DataBindAdapter(List<M> data) {
        this.data = data;
        binders = new SparseArray<>();
        addHeader(new GenericCardDividerBinder(this));
        addFooter(new GenericCardDividerBinder(this));
        addBinder(Constants.GENERIC_CARD_DIVIDER, new GenericCardDividerBinder(this));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DataBinder dataBinder = getDataBinder(viewType);
        return dataBinder.newViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (viewHolder != null)
            getDataBinder(getItemViewType(position)).bindViewHolder(viewHolder, position);
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0 + headersCount + footersCount;
        }
        return data.size() + headersCount + footersCount;
    }

    @Override
    public int getItemViewType(int position) {

        int itemViewType;

        if (position < headersCount) {
            itemViewType = Constants.HEADERS_START_INDEX + position;
        } else if (position >= headersCount + data.size()) {
            itemViewType = Constants.FOOTERS_START_INDEX + (position -
                    (headersCount + data.size()));
        } else {
            itemViewType = getDataForPosition(position).getModelType();
        }

        if (supportedType.get(itemViewType) != null) {
            return itemViewType;
        } else {
            return Constants.EMPTY_BINDER;
        }
    }

    public <T extends DataBinder> T getDataBinder(int viewType) {
        return (T) binders.get(viewType);
    }

    public M getDataForPosition(int position) {
        int index = position - headersCount;
        if (data.size() < index) {
            return null;
        }
        return data.get(index);
    }

    public void notifyAllExceptHeader() {
        this.notifyItemRangeChanged(headersCount, getItemCount());
    }

    protected <D extends DataBinder> void addBinder(int type, D binder) {
        binders.put(type, binder);
        supportedType.put(type, type);
    }

    protected <D extends DataBinder> int addHeader(D headerBinder) {
        int position = headersCount;
        headersCount++;
        binders.put(headerIndex++, headerBinder);
        supportedType.put(headerIndex - 1, headerIndex - 1);
        return position;
    }

    protected <D extends DataBinder> int addFooter(D footerBinder) {
        footersCount++;
        binders.put(footerIndex++, footerBinder);
        supportedType.put(footerIndex - 1, footerIndex - 1);
        return getItemCount() - 1;
    }

}