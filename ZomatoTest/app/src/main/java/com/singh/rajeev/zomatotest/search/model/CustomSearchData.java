package com.singh.rajeev.zomatotest.search.model;

import com.singh.rajeev.zomatotest.common.Constants;
import com.singh.rajeev.zomatotest.common.base.BaseModel;
import com.singh.rajeev.zomatotest.networking.model.SearchResult;

import java.util.ArrayList;

public class CustomSearchData implements BaseModel {
    String cuisine;
    ArrayList<SearchResult> restaurants;

    public CustomSearchData(String cuisine) {
        this.cuisine = cuisine;
        this.restaurants = new ArrayList<>();
    }

    public ArrayList<SearchResult> getRestaurants() {
        return restaurants;
    }

    public String getCuisine() {
        return cuisine;
    }

    @Override
    public int getModelType() {
        return Constants.CUISINE_HEADER;
    }

}