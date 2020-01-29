
package com.singh.rajeev.zomatotest.networking.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review implements Parcelable
{

    @SerializedName("review")
    @Expose
    private List<Object> review = null;
    public final static Creator<Review> CREATOR = new Creator<Review>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        public Review[] newArray(int size) {
            return (new Review[size]);
        }

    }
    ;

    protected Review(Parcel in) {
        in.readList(this.review, (Object.class.getClassLoader()));
    }

    public Review() {
    }

    public List<Object> getReview() {
        return review;
    }

    public void setReview(List<Object> review) {
        this.review = review;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(review);
    }

    public int describeContents() {
        return  0;
    }

}
