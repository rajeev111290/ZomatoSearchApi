
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer implements Parcelable
{

    @SerializedName("offer")
    @Expose
    private Offer_ offer;
    public final static Creator<Offer> CREATOR = new Creator<Offer>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Offer createFromParcel(Parcel in) {
            return new Offer(in);
        }

        public Offer[] newArray(int size) {
            return (new Offer[size]);
        }

    }
    ;

    protected Offer(Parcel in) {
        this.offer = ((Offer_) in.readValue((Offer_.class.getClassLoader())));
    }

    public Offer() {
    }

    public Offer_ getOffer() {
        return offer;
    }

    public void setOffer(Offer_ offer) {
        this.offer = offer;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(offer);
    }

    public int describeContents() {
        return  0;
    }

}
