package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 04/12/2015.
 */
public class CategorySpain implements Parcelable {

    private CategoryLigas ligas;

    public CategorySpain() {
    }

    public CategorySpain(CategoryLigas ligas) {
        this.ligas = ligas;
    }

    public CategoryLigas getLigas() {
        return ligas;
    }

    public void setLigas(CategoryLigas ligas) {
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

    protected CategorySpain(Parcel in) {
        this.ligas = in.readParcelable(CategoryLigas.class.getClassLoader());
    }

    public static final Creator<CategorySpain> CREATOR = new Creator<CategorySpain>() {
        public CategorySpain createFromParcel(Parcel source) {
            return new CategorySpain(source);
        }

        public CategorySpain[] newArray(int size) {
            return new CategorySpain[size];
        }
    };
}
