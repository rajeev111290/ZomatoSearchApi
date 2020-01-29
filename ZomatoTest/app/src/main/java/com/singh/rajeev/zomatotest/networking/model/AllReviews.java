
package com.singh.rajeev.zomatotest.networking.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllReviews implements Parcelable
{

    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = null;
    public final static Creator<AllReviews> CREATOR = new Creator<AllReviews>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AllReviews createFromParcel(Parcel in) {
            return new AllReviews(in);
        }

        public AllReviews[] newArray(int size) {
            return (new AllReviews[size]);
        }

    }
    ;

    protected AllReviews(Parcel in) {
        in.readList(this.reviews, (Review.class.getClassLoader()));
    }

    public AllReviews() {
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(reviews);
    }

    public int describeContents() {
        return  0;
    }

}
