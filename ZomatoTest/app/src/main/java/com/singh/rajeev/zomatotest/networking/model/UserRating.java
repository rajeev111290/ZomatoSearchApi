
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRating implements Parcelable
{

    @SerializedName("aggregate_rating")
    @Expose
    private String aggregateRating;
    @SerializedName("rating_text")
    @Expose
    private String ratingText;
    @SerializedName("rating_color")
    @Expose
    private String ratingColor;
    @SerializedName("rating_obj")
    @Expose
    private RatingObj ratingObj;
    @SerializedName("votes")
    @Expose
    private String votes;
    public final static Creator<UserRating> CREATOR = new Creator<UserRating>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserRating createFromParcel(Parcel in) {
            return new UserRating(in);
        }

        public UserRating[] newArray(int size) {
            return (new UserRating[size]);
        }

    }
    ;

    protected UserRating(Parcel in) {
        this.aggregateRating = ((String) in.readValue((String.class.getClassLoader())));
        this.ratingText = ((String) in.readValue((String.class.getClassLoader())));
        this.ratingColor = ((String) in.readValue((String.class.getClassLoader())));
        this.ratingObj = ((RatingObj) in.readValue((RatingObj.class.getClassLoader())));
        this.votes = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserRating() {
    }

    public String getAggregateRating() {
        return aggregateRating;
    }

    public void setAggregateRating(String aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public RatingObj getRatingObj() {
        return ratingObj;
    }

    public void setRatingObj(RatingObj ratingObj) {
        this.ratingObj = ratingObj;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(aggregateRating);
        dest.writeValue(ratingText);
        dest.writeValue(ratingColor);
        dest.writeValue(ratingObj);
        dest.writeValue(votes);
    }

    public int describeContents() {
        return  0;
    }

}
