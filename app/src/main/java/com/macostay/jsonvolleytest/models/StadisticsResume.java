package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by macostay on 21/12/2015.
 */
public class StadisticsResume implements Serializable, Parcelable {

    private ArrayList<StadisticsPlayer> stadistics_resume;

    public StadisticsResume() {
    }

    public StadisticsResume(ArrayList<StadisticsPlayer> stadistics_resume) {
        this.stadistics_resume = stadistics_resume;
    }

    public ArrayList<StadisticsPlayer> getStadistics_resume() {
        return stadistics_resume;
    }

    public void setStadistics_resume(ArrayList<StadisticsPlayer> stadistics_resume) {
        this.stadistics_resume = stadistics_resume;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(stadistics_resume);
    }

    protected StadisticsResume(Parcel in) {
        this.stadistics_resume = in.createTypedArrayList(StadisticsPlayer.CREATOR);
    }

    public static final Parcelable.Creator<StadisticsResume> CREATOR = new Parcelable.Creator<StadisticsResume>() {
        public StadisticsResume createFromParcel(Parcel source) {
            return new StadisticsResume(source);
        }

        public StadisticsResume[] newArray(int size) {
            return new StadisticsResume[size];
        }
    };
}
