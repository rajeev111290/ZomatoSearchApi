
package com.singh.rajeev.zomatotest.networking.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title implements Parcelable
{

    @SerializedName("text")
    @Expose
    private String text;
    public final static Creator<Title> CREATOR = new Creator<Title>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Title createFromParcel(Parcel in) {
            return new Title(in);
        }

        public Title[] newArray(int size) {
            return (new Title[size]);
        }

    }
    ;

    protected Title(Parcel in) {
        this.text = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Title() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(text);
    }

    public int describeContents() {
        return  0;
    }

}
