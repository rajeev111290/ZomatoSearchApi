
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.singh.rajeev.zomatotest.common.Constants;
import com.singh.rajeev.zomatotest.common.base.BaseModel;

public class SearchResult implements Parcelable, BaseModel {

    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;
    public final static Creator<SearchResult> CREATOR = new Creator<SearchResult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SearchResult createFromParcel(Parcel in) {
            return new SearchResult(in);
        }

        public SearchResult[] newArray(int size) {
            return (new SearchResult[size]);
        }

    }
    ;

    protected SearchResult(Parcel in) {
        this.restaurant = ((Restaurant) in.readValue((Restaurant.class.getClassLoader())));
    }

    public SearchResult() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(restaurant);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public int getModelType() {
        return Constants.RESTAURANT_BINDER;
    }
}
