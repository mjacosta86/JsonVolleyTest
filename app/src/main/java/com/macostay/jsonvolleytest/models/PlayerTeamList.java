package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by macostay on 10/12/2015.
 */
public class PlayerTeamList implements Parcelable {

    private ArrayList<PlayerTeam> list;

    public PlayerTeamList() {
    }

    public PlayerTeamList(ArrayList<PlayerTeam> list) {
        this.list = list;
    }

    public ArrayList<PlayerTeam> getList() {
        return list;
    }

    public void setList(ArrayList<PlayerTeam> list) {
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

    protected PlayerTeamList(Parcel in) {
        this.list = in.createTypedArrayList(PlayerTeam.CREATOR);
    }

    public static final Creator<PlayerTeamList> CREATOR = new Creator<PlayerTeamList>() {
        public PlayerTeamList createFromParcel(Parcel source) {
            return new PlayerTeamList(source);
        }

        public PlayerTeamList[] newArray(int size) {
            return new PlayerTeamList[size];
        }
    };
}
