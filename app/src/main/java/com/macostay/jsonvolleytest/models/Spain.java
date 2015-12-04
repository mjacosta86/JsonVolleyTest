package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 04/12/2015.
 */
public class Spain implements Parcelable {

    private Ligas ligas;

    public Spain() {
    }

    public Spain(Ligas ligas) {
        this.ligas = ligas;
    }

    public Ligas getLigas() {
        return ligas;
    }

    public void setLigas(Ligas ligas) {
        this.ligas = ligas;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.ligas, 0);
    }

    protected Spain(Parcel in) {
        this.ligas = in.readParcelable(Ligas.class.getClassLoader());
    }

    public static final Creator<Spain> CREATOR = new Creator<Spain>() {
        public Spain createFromParcel(Parcel source) {
            return new Spain(source);
        }

        public Spain[] newArray(int size) {
            return new Spain[size];
        }
    };
}
