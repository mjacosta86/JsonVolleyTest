package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 04/12/2015.
 */
public class Category implements Parcelable {

    private CategorySpain spain;

    public Category() {
    }

    public Category(CategorySpain spain) {
        this.spain = spain;
    }

    public CategorySpain getSpain() {
        return spain;
    }

    public void setSpain(CategorySpain spain) {
        this.spain = spain;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.spain, 0);
    }

    protected Category(Parcel in) {
        this.spain = in.readParcelable(CategorySpain.class.getClassLoader());
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        public Category createFromParcel(Parcel source) {
            return new Category(source);
        }

        public Category[] newArray(int size) {
            return new Category[size];
        }
    };
}
