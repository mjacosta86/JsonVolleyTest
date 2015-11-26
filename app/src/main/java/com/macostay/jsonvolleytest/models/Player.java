package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 14/10/2015.
 */
public class Player implements Parcelable {

    private int index;
    private String name;
    private int dorsal;
    private int age;
    private String position;
    private String info;


    public Player() {
    }

    public Player(int index, String name, int dorsal, int age, String position, String info) {
        this.index = index;
        this.name = name;
        this.dorsal = dorsal;
        this.age = age;
        this.position = position;
        this.info = info;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.index);
        dest.writeString(this.name);
        dest.writeInt(this.dorsal);
        dest.writeInt(this.age);
        dest.writeString(this.position);
        dest.writeString(this.info);
    }

    protected Player(Parcel in) {
        this.index = in.readInt();
        this.name = in.readString();
        this.dorsal = in.readInt();
        this.age = in.readInt();
        this.position = in.readString();
        this.info = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }

        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}
