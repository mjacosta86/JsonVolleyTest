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
    private String CountryCode;
    private String weight;
    private String height;
    private String twitter;
    private String website;
    private String squad_number;
    private String year;
    private String competition_name;
    private String competition_logo;
    private String table_suffix;
    private String team_name;
    private String basealias;
    private String team_id;
    private String player_avatar;
    private String team_shield;
    private String country_flag;
    private StadisticsResume stadisticsResume;
    private boolean hasNews;

    public PlayerDetails() {
    }

    public PlayerDetails(String player_id, String nick, String name, String last_name, String role, String country, String birthdate, String age, String countryCode, String weight, String height, String twitter, String website, String squad_number, String year, String competition_name, String competition_logo, String table_suffix, String team_name, String basealias, String team_id, String player_avatar, String team_shield, String country_flag, StadisticsResume stadisticsResume, boolean hasNews) {
        this.player_id = player_id;
        this.nick = nick;
        this.name = name;
        this.last_name = last_name;
        this.role = role;
        this.country = country;
        this.birthdate = birthdate;
        this.age = age;
        CountryCode = countryCode;
        this.weight = weight;
        this.height = height;
        this.twitter = twitter;
        this.website = website;
        this.squad_number = squad_number;
        this.year = year;
        this.competition_name = competition_name;
        this.competition_logo = competition_logo;
        this.table_suffix = table_suffix;
        this.team_name = team_name;
        this.basealias = basealias;
        this.team_id = team_id;
        this.player_avatar = player_avatar;
        this.team_shield = team_shield;
        this.country_flag = country_flag;
        this.stadisticsResume = stadisticsResume;
        this.hasNews = hasNews;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getCompetition_logo() {
        return competition_logo;
    }

    public void setCompetition_logo(String competition_logo) {
        this.competition_logo = competition_logo;
    }

    public String getTable_suffix() {
        return table_suffix;
    }

    public void setTable_suffix(String table_suffix) {
        this.table_suffix = table_suffix;
    }

    public String getBasealias() {
        return basealias;
    }

    public void setBasealias(String basealias) {
        this.basealias = basealias;
    }

    public boolean isHasNews() {
        return hasNews;
    }

    public void setHasNews(boolean hasNews) {
        this.hasNews = hasNews;
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
        dest.writeString(this.CountryCode);
        dest.writeString(this.weight);
        dest.writeString(this.height);
        dest.writeString(this.twitter);
        dest.writeString(this.website);
        dest.writeString(this.squad_number);
        dest.writeString(this.year);
        dest.writeString(this.competition_name);
        dest.writeString(this.competition_logo);
        dest.writeString(this.table_suffix);
        dest.writeString(this.team_name);
        dest.writeString(this.basealias);
        dest.writeString(this.team_id);
        dest.writeString(this.player_avatar);
        dest.writeString(this.team_shield);
        dest.writeString(this.country_flag);
        dest.writeParcelable(this.stadisticsResume, 0);
        dest.writeByte(hasNews ? (byte) 1 : (byte) 0);
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
        this.CountryCode = in.readString();
        this.weight = in.readString();
        this.height = in.readString();
        this.twitter = in.readString();
        this.website = in.readString();
        this.squad_number = in.readString();
        this.year = in.readString();
        this.competition_name = in.readString();
        this.competition_logo = in.readString();
        this.table_suffix = in.readString();
        this.team_name = in.readString();
        this.basealias = in.readString();
        this.team_id = in.readString();
        this.player_avatar = in.readString();
        this.team_shield = in.readString();
        this.country_flag = in.readString();
        this.stadisticsResume = in.readParcelable(StadisticsResume.class.getClassLoader());
        this.hasNews = in.readByte() != 0;
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
