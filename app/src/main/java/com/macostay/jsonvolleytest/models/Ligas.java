package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/**
 * Created by macostay on 04/12/2015.
 */
public class Ligas implements Parcelable {

    private ArrayList<Liga> ligas;

    public Ligas() {
    }

    public Ligas(ArrayList<Liga> ligas) {
        this.ligas = ligas;
    }

    public ArrayList<Liga> getLigas() {
        return ligas;
    }

    public void setLigas(ArrayList<Liga> ligas) {
        this.ligas = ligas;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(ligas);
    }

    protected Ligas(Parcel in) {
        this.ligas = in.createTypedArrayList(Liga.CREATOR);
    }

    public static final Creator<Ligas> CREATOR = new Creator<Ligas>() {
        public Ligas createFromParcel(Parcel source) {
            return new Ligas(source);
        }

        public Ligas[] newArray(int size) {
            return new Ligas[size];
        }
    };
}
