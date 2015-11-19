package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by macostay on 19/11/2015.
 */
public class TeamList implements Parcelable {

    private ArrayList<Teams> list;

    public TeamList() {
    }

    public TeamList(ArrayList<Teams> list) {
        this.list = list;
    }

    public ArrayList<Teams> getList() {
        return list;
    }

    public void setList(ArrayList<Teams> list) {
        this.list = list;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(list);
    }

    protected TeamList(Parcel in) {
        this.list = in.createTypedArrayList(Teams.CREATOR);
    }

    public static final Parcelable.Creator<TeamList> CREATOR = new Parcelable.Creator<TeamList>() {
        public TeamList createFromParcel(Parcel source) {
            return new TeamList(source);
        }

        public TeamList[] newArray(int size) {
            return new TeamList[size];
        }
    };
}
