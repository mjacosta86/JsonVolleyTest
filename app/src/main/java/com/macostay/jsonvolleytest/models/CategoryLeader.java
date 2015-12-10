package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 04/12/2015.
 */
public class CategoryLeader implements Parcelable {
    private String shield;

    public CategoryLeader() {
    }

    public CategoryLeader(String shield) {
        this.shield = shield;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.shield);
    }

    protected CategoryLeader(Parcel in) {
        this.shield = in.readString();
    }

    public static final Creator<CategoryLeader> CREATOR = new Creator<CategoryLeader>() {
        public CategoryLeader createFromParcel(Parcel source) {
            return new CategoryLeader(source);
        }

        public CategoryLeader[] newArray(int size) {
            return new CategoryLeader[size];
        }
    };
}
