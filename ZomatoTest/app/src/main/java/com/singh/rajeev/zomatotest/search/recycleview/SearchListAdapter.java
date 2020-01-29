package com.singh.rajeev.zomatotest.search.recycleview;

import com.singh.rajeev.zomatotest.common.Constants;
import com.singh.rajeev.zomatotest.common.base.BaseModel;
import com.singh.rajeev.zomatotest.common.base.DataBindAdapter;
import com.singh.rajeev.zomatotest.common.model.SearchBarModel;

import java.util.List;

import io.reactivex.subjects.PublishSubject;

public class SearchListAdapter extends DataBindAdapter<BaseModel> {

    public SearchListAdapter(List<BaseModel> data, PublishSubject<SearchBarModel> searchBarModelPublishSubject) {
        super(data);
        addHeader(new SearchBarListBinder(this, searchBarModelPublishSubject));

        addBinder(Constants.RESTAURANT_BINDER, new RestaurantListBinder(this));
        addBinder(Constants.CUISINE_HEADER, new CuisineListBinder(this));
    }
}
