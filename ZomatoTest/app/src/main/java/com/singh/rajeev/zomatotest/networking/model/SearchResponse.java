package com.singh.rajeev.zomatotest.networking.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponse implements Parcelable
{

    @SerializedName("results_found")
    @Expose
    private Integer resultsFound;
    @SerializedName("results_start")
    @Expose
    private Integer resultsStart;
    @SerializedName("results_shown")
    @Expose
    private Integer resultsShown;
    @SerializedName("restaurants")
    @Expose
    private List<SearchResult> restaurants = null;
    public final static Parcelable.Creator<SearchResponse> CREATOR = new Creator<SearchResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchResponse createFromParcel(Parcel in) {
            return new SearchResponse(in);
        }

        public SearchResponse[] newArray(int size) {
            return (new SearchResponse[size]);
        }

    }
            ;

    protected SearchResponse(Parcel in) {
        this.resultsFound = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.resultsStart = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.resultsShown = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.restaurants, (com.singh.rajeev.zomatotest.networking.model.SearchResult.class.getClassLoader()));
    }

    public SearchResponse() {
    }

    public Integer getResultsFound() {
        return resultsFound;
    }

    public void setResultsFound(Integer resultsFound) {
        this.resultsFound = resultsFound;
    }

    public Integer getResultsStart() {
        return resultsStart;
    }

    public void setResultsStart(Integer resultsStart) {
        this.resultsStart = resultsStart;
    }

    public Integer getResultsShown() {
        return resultsShown;
    }

    public void setResultsShown(Integer resultsShown) {
        this.resultsShown = resultsShown;
    }

    public List<SearchResult> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<SearchResult> restaurants) {
        this.restaurants = restaurants;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(resultsFound);
        dest.writeValue(resultsStart);
        dest.writeValue(resultsShown);
        dest.writeList(restaurants);
    }

    public int describeContents() {
        return 0;
    }

}