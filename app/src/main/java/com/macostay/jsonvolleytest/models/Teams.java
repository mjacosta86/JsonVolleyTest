package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by macostay on 19/11/2015.
 */
public class Teams implements Parcelable {

    private String id;
    private String name;
    private int groupCode;
    private String image;
    private PlayerList players;

    public Teams() {
    }

    public Teams(String id, String name, int groupCode, String image) {
        this.id = id;
        this.name = name;
        this.groupCode = groupCode;
        this.image = image;
    }


    public Teams(String id, String name, int groupCode, String image, PlayerList players) {

        this.id = id;
        this.name = name;
        this.groupCode = groupCode;
        this.image = image;
        this.players = players;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(int group_code) {
        this.groupCode = group_code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PlayerList getPlayers() {
        return players;
    }

    public void setPlayers(PlayerList players) {
        this.players = players;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.groupCode);
        dest.writeString(this.image);
        dest.writeParcelable(this.players, 0);
    }

    protected Teams(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.groupCode = in.readInt();
        this.image = in.readString();
        this.players = in.readParcelable(PlayerList.class.getClassLoader());
    }

    public static final Creator<Teams> CREATOR = new Creator<Teams>() {
        public Teams createFromParcel(Parcel source) {
            return new Teams(source);
        }

        public Teams[] newArray(int size) {
            return new Teams[size];
        }
    };
}
