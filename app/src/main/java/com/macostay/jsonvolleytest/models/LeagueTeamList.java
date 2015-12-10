package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by macostay on 09/12/2015.
 */
public class LeagueTeamList implements Parcelable {

    private ArrayList<LeagueTeam> team;

    public LeagueTeamList() {
    }

    public LeagueTeamList(ArrayList<LeagueTeam> team) {
        this.team = team;
    }

    public ArrayList<LeagueTeam> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<LeagueTeam> team) {
        this.team = team;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(team);
    }

    protected LeagueTeamList(Parcel in) {
        this.team = in.createTypedArrayList(LeagueTeam.CREATOR);
    }

    public static final Creator<LeagueTeamList> CREATOR = new Creator<LeagueTeamList>() {
        public LeagueTeamList createFromParcel(Parcel source) {
            return new LeagueTeamList(source);
        }

        public LeagueTeamList[] newArray(int size) {
            return new LeagueTeamList[size];
        }
    };
}
