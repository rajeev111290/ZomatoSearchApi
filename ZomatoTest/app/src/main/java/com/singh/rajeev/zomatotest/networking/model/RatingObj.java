
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingObj implements Parcelable
{

    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("bg_color")
    @Expose
    private BgColor bgColor;
    public final static Creator<RatingObj> CREATOR = new Creator<RatingObj>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RatingObj createFromParcel(Parcel in) {
            return new RatingObj(in);
        }

        public RatingObj[] newArray(int size) {
            return (new RatingObj[size]);
        }

    }
    ;

    protected RatingObj(Parcel in) {
        this.title = ((Title) in.readValue((Title.class.getClassLoader())));
        this.bgColor = ((BgColor) in.readValue((BgColor.class.getClassLoader())));
    }

    public RatingObj() {
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public BgColor getBgColor() {
        return bgColor;
    }

    public void setBgColor(BgColor bgColor) {
        this.bgColor = bgColor;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(bgColor);
    }

    public int describeContents() {
        return  0;
    }

}
