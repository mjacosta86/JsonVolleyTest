package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 04/12/2015.
 */
public class Liga implements Parcelable {
    private int group_code;
    private String name;
    private String league_id;
    private String country;
    private String flag;
    private int order;
    private int total_rounds;
    private int total_group;
    private int year;
    private String phase;
    private String logo;
    private Leader leader;
    private int playoff;
    private int current_round;
    private String continent;
    private int id;
    private int c_pending;

    public Liga() {
    }

    public Liga(int group_code, String name, String league_id, String country, String flag, int order, int total_rounds, int total_group, int year, String phase, String logo, Leader leader, int playoff, int current_round, String continent, int id, int c_pending) {
        this.group_code = group_code;
        this.name = name;
        this.league_id = league_id;
        this.country = country;
        this.flag = flag;
        this.order = order;
        this.total_rounds = total_rounds;
        this.total_group = total_group;
        this.year = year;
        this.phase = phase;
        this.logo = logo;
        this.leader = leader;
        this.playoff = playoff;
        this.current_round = current_round;
        this.continent = continent;
        this.id = id;
        this.c_pending = c_pending;
    }

    public int getGroup_code() {
        return group_code;
    }

    public void setGroup_code(int group_code) {
        this.group_code = group_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getTotal_rounds() {
        return total_rounds;
    }

    public void setTotal_rounds(int total_rounds) {
        this.total_rounds = total_rounds;
    }

    public int getTotal_group() {
        return total_group;
    }

    public void setTotal_group(int total_group) {
        this.total_group = total_group;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public int getPlayoff() {
        return playoff;
    }

    public void setPlayoff(int playoff) {
        this.playoff = playoff;
    }

    public int getCurrent_round() {
        return current_round;
    }

    public void setCurrent_round(int current_round) {
        this.current_round = current_round;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getC_pending() {
        return c_pending;
    }

    public void setC_pending(int c_pending) {
        this.c_pending = c_pending;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.group_code);
        dest.writeString(this.name);
        dest.writeString(this.league_id);
        dest.writeString(this.country);
        dest.writeString(this.flag);
        dest.writeInt(this.order);
        dest.writeInt(this.total_rounds);
        dest.writeInt(this.total_group);
        dest.writeInt(this.year);
        dest.writeString(this.phase);
        dest.writeString(this.logo);
        dest.writeParcelable(this.leader, 0);
        dest.writeInt(this.playoff);
        dest.writeInt(this.current_round);
        dest.writeString(this.continent);
        dest.writeInt(this.id);
        dest.writeInt(this.c_pending);
    }

    protected Liga(Parcel in) {
        this.group_code = in.readInt();
        this.name = in.readString();
        this.league_id = in.readString();
        this.country = in.readString();
        this.flag = in.readString();
        this.order = in.readInt();
        this.total_rounds = in.readInt();
        this.total_group = in.readInt();
        this.year = in.readInt();
        this.phase = in.readString();
        this.logo = in.readString();
        this.leader = in.readParcelable(Leader.class.getClassLoader());
        this.playoff = in.readInt();
        this.current_round = in.readInt();
        this.continent = in.readString();
        this.id = in.readInt();
        this.c_pending = in.readInt();
    }

    public static final Creator<Liga> CREATOR = new Creator<Liga>() {
        public Liga createFromParcel(Parcel source) {
            return new Liga(source);
        }

        public Liga[] newArray(int size) {
            return new Liga[size];
        }
    };
}
