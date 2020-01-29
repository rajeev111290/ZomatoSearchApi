
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShareData implements Parcelable
{

    @SerializedName("should_show")
    @Expose
    private Integer shouldShow;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("text")
    @Expose
    private String text;
    public final static Creator<ShareData> CREATOR = new Creator<ShareData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ShareData createFromParcel(Parcel in) {
            return new ShareData(in);
        }

        public ShareData[] newArray(int size) {
            return (new ShareData[size]);
        }

    }
    ;

    protected ShareData(Parcel in) {
        this.shouldShow = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.link = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ShareData() {
    }

    public Integer getShouldShow() {
        return shouldShow;
    }

    public void setShouldShow(Integer shouldShow) {
        this.shouldShow = shouldShow;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(shouldShow);
        dest.writeValue(link);
        dest.writeValue(text);
    }

    public int describeContents() {
        return  0;
    }

}
