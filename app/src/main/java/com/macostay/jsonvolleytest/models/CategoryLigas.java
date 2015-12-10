package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/**
 * Created by macostay on 04/12/2015.
 */
public class CategoryLigas implements Parcelable {

    private ArrayList<CategoryLiga> ligas;

    public CategoryLigas() {
    }

    public CategoryLigas(ArrayList<CategoryLiga> ligas) {
        this.ligas = ligas;
    }

    public ArrayList<CategoryLiga> getLigas() {
        return ligas;
    }

    public void setLigas(ArrayList<CategoryLiga> ligas) {
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

    protected CategoryLigas(Parcel in) {
        this.ligas = in.createTypedArrayList(CategoryLiga.CREATOR);
    }

    public static final Creator<CategoryLigas> CREATOR = new Creator<CategoryLigas>() {
        public CategoryLigas createFromParcel(Parcel source) {
            return new CategoryLigas(source);
        }

        public CategoryLigas[] newArray(int size) {
            return new CategoryLigas[size];
        }
    };
}
