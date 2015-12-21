package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 21/12/2015.
 */
public class PlayerDetails implements Parcelable {

    private String player_id;
    private String nick;
    private String name;
    private String last_name;
    private String role;
    private String country;
    private String birthdate;
    private String age;
    private String team_name;
    private String squad_number;
    private String team_id;
    private String CountryCode;
    private String player_avatar;
    private String team_shield;
    private String country_flag;
    private StadisticsResume stadisticsResume;

    public PlayerDetails() {
    }

    public PlayerDetails(String player_id, String nick, String name, String last_name, String role, String country, String birthdate, String age, String team_name, String squad_number, String team_id, String countryCode, String player_avatar, String team_shield, String country_flag, StadisticsResume stadisticsResume) {
        this.player_id = player_id;
        this.nick = nick;
        this.name = name;
        this.last_name = last_name;
        this.role = role;
        this.country = country;
        this.birthdate = birthdate;
        this.age = age;
        this.team_name = team_name;
        this.squad_number = squad_number;
        this.team_id = team_id;
        CountryCode = countryCode;
        this.player_avatar = player_avatar;
        this.team_shield = team_shield;
        this.country_flag = country_flag;
        this.stadisticsResume = stadisticsResume;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getSquad_number() {
        return squad_number;
    }

    public void setSquad_number(String squad_number) {
        this.squad_number = squad_number;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getPlayer_avatar() {
        return player_avatar;
    }

    public void setPlayer_avatar(String player_avatar) {
        this.player_avatar = player_avatar;
    }

    public String getTeam_shield() {
        return team_shield;
    }

    public void setTeam_shield(String team_shield) {
        this.team_shield = team_shield;
    }

    public String getCountry_flag() {
        return country_flag;
    }

    public void setCountry_flag(String country_flag) {
        this.country_flag = country_flag;
    }

    public StadisticsResume getStadisticsResume() {
        return stadisticsResume;
    }

    public void setStadisticsResume(StadisticsResume stadisticsResume) {
        this.stadisticsResume = stadisticsResume;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.player_id);
        dest.writeString(this.nick);
        dest.writeString(this.name);
        dest.writeString(this.last_name);
        dest.writeString(this.role);
        dest.writeString(this.country);
        dest.writeString(this.birthdate);
        dest.writeString(this.age);
        dest.writeString(this.team_name);
        dest.writeString(this.squad_number);
        dest.writeString(this.team_id);
        dest.writeString(this.CountryCode);
        dest.writeString(this.player_avatar);
        dest.writeString(this.team_shield);
        dest.writeString(this.country_flag);
        dest.writeParcelable(this.stadisticsResume, 0);
    }

    protected PlayerDetails(Parcel in) {
        this.player_id = in.readString();
        this.nick = in.readString();
        this.name = in.readString();
        this.last_name = in.readString();
        this.role = in.readString();
        this.country = in.readString();
        this.birthdate = in.readString();
        this.age = in.readString();
        this.team_name = in.readString();
        this.squad_number = in.readString();
        this.team_id = in.readString();
        this.CountryCode = in.readString();
        this.player_avatar = in.readString();
        this.team_shield = in.readString();
        this.country_flag = in.readString();
        this.stadisticsResume = in.readParcelable(StadisticsResume.class.getClassLoader());
    }

    public static final Creator<PlayerDetails> CREATOR = new Creator<PlayerDetails>() {
        public PlayerDetails createFromParcel(Parcel source) {
            return new PlayerDetails(source);
        }

        public PlayerDetails[] newArray(int size) {
            return new PlayerDetails[size];
        }
    };
}
