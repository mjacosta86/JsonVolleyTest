package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 10/12/2015.
 */
public class PlayerTeam implements Parcelable {

    private String id;
    private String nick;
    private String name;
    private String last_name;
    private String alias;
    private String role;
    private String year;
    private String squadNumber;
    private String num;
    private String pos;
    private String idplayer;
    private String goals;
    private String reds;
    private String yellows;
    private String CountryCode;
    private String image;

    public PlayerTeam() {
    }

    public PlayerTeam(String id, String nick, String name, String last_name, String alias, String role, String year, String squadNumber, String num, String pos, String idplayer, String goals, String reds, String yellows, String countryCode, String image) {
        this.id = id;
        this.nick = nick;
        this.name = name;
        this.last_name = last_name;
        this.alias = alias;
        this.role = role;
        this.year = year;
        this.squadNumber = squadNumber;
        this.num = num;
        this.pos = pos;
        this.idplayer = idplayer;
        this.goals = goals;
        this.reds = reds;
        this.yellows = yellows;
        CountryCode = countryCode;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(String squadNumber) {
        this.squadNumber = squadNumber;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getIdplayer() {
        return idplayer;
    }

    public void setIdplayer(String idplayer) {
        this.idplayer = idplayer;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getReds() {
        return reds;
    }

    public void setReds(String reds) {
        this.reds = reds;
    }

    public String getYellows() {
        return yellows;
    }

    public void setYellows(String yellows) {
        this.yellows = yellows;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
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
        dest.writeString(this.nick);
        dest.writeString(this.name);
        dest.writeString(this.last_name);
        dest.writeString(this.alias);
        dest.writeString(this.role);
        dest.writeString(this.year);
        dest.writeString(this.squadNumber);
        dest.writeString(this.num);
        dest.writeString(this.pos);
        dest.writeString(this.idplayer);
        dest.writeString(this.goals);
        dest.writeString(this.reds);
        dest.writeString(this.yellows);
        dest.writeString(this.CountryCode);
        dest.writeString(this.image);
    }

    protected PlayerTeam(Parcel in) {
        this.id = in.readString();
        this.nick = in.readString();
        this.name = in.readString();
        this.last_name = in.readString();
        this.alias = in.readString();
        this.role = in.readString();
        this.year = in.readString();
        this.squadNumber = in.readString();
        this.num = in.readString();
        this.pos = in.readString();
        this.idplayer = in.readString();
        this.goals = in.readString();
        this.reds = in.readString();
        this.yellows = in.readString();
        this.CountryCode = in.readString();
        this.image = in.readString();
    }

    public static final Creator<PlayerTeam> CREATOR = new Creator<PlayerTeam>() {
        public PlayerTeam createFromParcel(Parcel source) {
            return new PlayerTeam(source);
        }

        public PlayerTeam[] newArray(int size) {
            return new PlayerTeam[size];
        }
    };
}
