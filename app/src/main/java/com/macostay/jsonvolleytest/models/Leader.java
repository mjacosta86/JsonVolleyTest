package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 04/12/2015.
 */
public class Leader implements Parcelable {
    private String shield;

    public Leader() {
    }

    public Leader(String shield) {
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

    protected Leader(Parcel in) {
        this.shield = in.readString();
    }

    public static final Parcelable.Creator<Leader> CREATOR = new Parcelable.Creator<Leader>() {
        public Leader createFromParcel(Parcel source) {
            return new Leader(source);
        }

        public Leader[] newArray(int size) {
            return new Leader[size];
        }
    };
}
