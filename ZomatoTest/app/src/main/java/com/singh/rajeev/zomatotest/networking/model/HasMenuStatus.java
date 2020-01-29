
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HasMenuStatus implements Parcelable
{

    @SerializedName("delivery")
    @Expose
    private Integer delivery;
    @SerializedName("takeaway")
    @Expose
    private Integer takeaway;
    public final static Creator<HasMenuStatus> CREATOR = new Creator<HasMenuStatus>() {


        @SuppressWarnings({
            "unchecked"
        })
        public HasMenuStatus createFromParcel(Parcel in) {
            return new HasMenuStatus(in);
        }

        public HasMenuStatus[] newArray(int size) {
            return (new HasMenuStatus[size]);
        }

    }
    ;

    protected HasMenuStatus(Parcel in) {
        this.delivery = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.takeaway = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public HasMenuStatus() {
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getTakeaway() {
        return takeaway;
    }

    public void setTakeaway(Integer takeaway) {
        this.takeaway = takeaway;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(delivery);
        dest.writeValue(takeaway);
    }

    public int describeContents() {
        return  0;
    }

}
