package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 19/11/2015.
 */
public class Teams implements Parcelable {

    private String id;
    private String name;
    private String groupCode;
    private String image;

    public Teams() {
    }

    public Teams(String id, String name, String group_code, String image) {
        this.id = id;
        this.name = name;
        this.groupCode = group_code;
        this.image = image;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String group_code) {
        this.groupCode = group_code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.groupCode);
        dest.writeString(this.image);
    }

    protected Teams(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.groupCode = in.readString();
        this.image = in.readString();
    }

    public static final Parcelable.Creator<Teams> CREATOR = new Parcelable.Creator<Teams>() {
        public Teams createFromParcel(Parcel source) {
            return new Teams(source);
        }

        public Teams[] newArray(int size) {
            return new Teams[size];
        }
    };
}
