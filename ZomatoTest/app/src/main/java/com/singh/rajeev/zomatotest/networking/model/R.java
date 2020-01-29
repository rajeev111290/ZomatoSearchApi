
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class R implements Parcelable
{

    @SerializedName("has_menu_status")
    @Expose
    private HasMenuStatus hasMenuStatus;
    @SerializedName("res_id")
    @Expose
    private Integer resId;
    public final static Creator<R> CREATOR = new Creator<R>() {


        @SuppressWarnings({
            "unchecked"
        })
        public R createFromParcel(Parcel in) {
            return new R(in);
        }

        public R[] newArray(int size) {
            return (new R[size]);
        }

    }
    ;

    protected R(Parcel in) {
        this.hasMenuStatus = ((HasMenuStatus) in.readValue((HasMenuStatus.class.getClassLoader())));
        this.resId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public R() {
    }

    public HasMenuStatus getHasMenuStatus() {
        return hasMenuStatus;
    }

    public void setHasMenuStatus(HasMenuStatus hasMenuStatus) {
        this.hasMenuStatus = hasMenuStatus;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hasMenuStatus);
        dest.writeValue(resId);
    }

    public int describeContents() {
        return  0;
    }

}
