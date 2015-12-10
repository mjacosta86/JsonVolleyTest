package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 09/12/2015.
 */
public class LeagueTeam implements Parcelable {

    private String id;
    private String nameShow;
    private String translate;
    private String group_code;
    private String favorite;
    private String basealias;
    private String fullName;
    private String alerts;
    private String shield;

    public LeagueTeam() {
    }

    public LeagueTeam(String id, String nameShow, String translate, String group_code, String favorite, String basealias, String alerts, String fullName, String shield) {
        this.id = id;
        this.nameShow = nameShow;
        this.translate = translate;
        this.group_code = group_code;
        this.favorite = favorite;
        this.basealias = basealias;
        this.alerts = alerts;
        this.fullName = fullName;
        this.shield = shield;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameShow() {
        return nameShow;
    }

    public void setNameShow(String nameShow) {
        this.nameShow = nameShow;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getBasealias() {
        return basealias;
    }

    public void setBasealias(String basealias) {
        this.basealias = basealias;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlerts() {
        return alerts;
    }

    public void setAlerts(String alerts) {
        this.alerts = alerts;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.nameShow);
        dest.writeString(this.translate);
        dest.writeString(this.group_code);
        dest.writeString(this.favorite);
        dest.writeString(this.basealias);
        dest.writeString(this.fullName);
        dest.writeString(this.alerts);
        dest.writeString(this.shield);
    }

    protected LeagueTeam(Parcel in) {
        this.id = in.readString();
        this.nameShow = in.readString();
        this.translate = in.readString();
        this.group_code = in.readString();
        this.favorite = in.readString();
        this.basealias = in.readString();
        this.fullName = in.readString();
        this.alerts = in.readString();
        this.shield = in.readString();
    }

    public static final Creator<LeagueTeam> CREATOR = new Creator<LeagueTeam>() {
        public LeagueTeam createFromParcel(Parcel source) {
            return new LeagueTeam(source);
        }

        public LeagueTeam[] newArray(int size) {
            return new LeagueTeam[size];
        }
    };
}
