package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 21/12/2015.
 */
public class StadisticsPlayer implements Parcelable {

    private String year;
    private String squadNumber;
    private String league_id;
    private String team_id;
    private String team_name;
    private String basealias;
    private String category_id;
    private String category_name;
    private String category_alias;
    private String category_logo;
    private String country_alias;
    private String country_name;
    private int games_played;
    private int minutes_played;
    private int reserved;
    private int goals;
    private int yellow_cards;
    private int red_cards;
    private int assits;

    public StadisticsPlayer() {
    }

    public StadisticsPlayer(String year, String squadNumber, String league_id, String team_id, String team_name, String basealias, String category_id, String category_name, String category_alias, String category_logo, String country_alias, String country_name, int games_played, int minutes_played, int reserved, int goals, int yellow_cards, int red_cards, int assits) {
        this.year = year;
        this.squadNumber = squadNumber;
        this.league_id = league_id;
        this.team_id = team_id;
        this.team_name = team_name;
        this.basealias = basealias;
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_alias = category_alias;
        this.category_logo = category_logo;
        this.country_alias = country_alias;
        this.country_name = country_name;
        this.games_played = games_played;
        this.minutes_played = minutes_played;
        this.reserved = reserved;
        this.goals = goals;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.assits = assits;
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

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getBasealias() {
        return basealias;
    }

    public void setBasealias(String basealias) {
        this.basealias = basealias;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_alias() {
        return category_alias;
    }

    public void setCategory_alias(String category_alias) {
        this.category_alias = category_alias;
    }

    public String getCategory_logo() {
        return category_logo;
    }

    public void setCategory_logo(String category_logo) {
        this.category_logo = category_logo;
    }

    public String getCountry_alias() {
        return country_alias;
    }

    public void setCountry_alias(String country_alias) {
        this.country_alias = country_alias;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getMinutes_played() {
        return minutes_played;
    }

    public void setMinutes_played(int minutes_played) {
        this.minutes_played = minutes_played;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(int yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public int getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(int red_cards) {
        this.red_cards = red_cards;
    }

    public int getAssits() {
        return assits;
    }

    public void setAssits(int assits) {
        this.assits = assits;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.year);
        dest.writeString(this.squadNumber);
        dest.writeString(this.league_id);
        dest.writeString(this.team_id);
        dest.writeString(this.team_name);
        dest.writeString(this.basealias);
        dest.writeString(this.category_id);
        dest.writeString(this.category_name);
        dest.writeString(this.category_alias);
        dest.writeString(this.category_logo);
        dest.writeString(this.country_alias);
        dest.writeString(this.country_name);
        dest.writeInt(this.games_played);
        dest.writeInt(this.minutes_played);
        dest.writeInt(this.reserved);
        dest.writeInt(this.goals);
        dest.writeInt(this.yellow_cards);
        dest.writeInt(this.red_cards);
        dest.writeInt(this.assits);
    }

    protected StadisticsPlayer(Parcel in) {
        this.year = in.readString();
        this.squadNumber = in.readString();
        this.league_id = in.readString();
        this.team_id = in.readString();
        this.team_name = in.readString();
        this.basealias = in.readString();
        this.category_id = in.readString();
        this.category_name = in.readString();
        this.category_alias = in.readString();
        this.category_logo = in.readString();
        this.country_alias = in.readString();
        this.country_name = in.readString();
        this.games_played = in.readInt();
        this.minutes_played = in.readInt();
        this.reserved = in.readInt();
        this.goals = in.readInt();
        this.yellow_cards = in.readInt();
        this.red_cards = in.readInt();
        this.assits = in.readInt();
    }

    public static final Creator<StadisticsPlayer> CREATOR = new Creator<StadisticsPlayer>() {
        public StadisticsPlayer createFromParcel(Parcel source) {
            return new StadisticsPlayer(source);
        }

        public StadisticsPlayer[] newArray(int size) {
            return new StadisticsPlayer[size];
        }
    };
}
