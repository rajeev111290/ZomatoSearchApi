
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BgColor implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tint")
    @Expose
    private String tint;
    public final static Creator<BgColor> CREATOR = new Creator<BgColor>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BgColor createFromParcel(Parcel in) {
            return new BgColor(in);
        }

        public BgColor[] newArray(int size) {
            return (new BgColor[size]);
        }

    }
    ;

    protected BgColor(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.tint = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BgColor() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTint() {
        return tint;
    }

    public void setTint(String tint) {
        this.tint = tint;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(tint);
    }

    public int describeContents() {
        return  0;
    }

}
