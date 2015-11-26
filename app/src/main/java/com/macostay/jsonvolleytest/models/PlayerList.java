package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by macostay on 15/10/2015.
 */
public class PlayerList implements Parcelable{

    private ArrayList<Player> list;

    public PlayerList() {
    }

    public PlayerList(ArrayList<Player> list) {
        this.list = list;
    }

    public ArrayList<Player> getList() {
        return list;
    }

    public void setList(ArrayList<Player> list) {
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

    protected PlayerList(Parcel in) {
        this.list = in.createTypedArrayList(Player.CREATOR);
    }

    public static final Creator<PlayerList> CREATOR = new Creator<PlayerList>() {
        public PlayerList createFromParcel(Parcel source) {
            return new PlayerList(source);
        }

        public PlayerList[] newArray(int size) {
            return new PlayerList[size];
        }
    };
}
