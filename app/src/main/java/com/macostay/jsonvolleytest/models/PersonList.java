package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by macostay on 15/10/2015.
 */
public class PersonList implements Parcelable{

    private ArrayList<Person> list;

    public PersonList() {
    }

    public PersonList(ArrayList<Person> list) {
        this.list = list;
    }

    public ArrayList<Person> getList() {
        return list;
    }

    public void setList(ArrayList<Person> list) {
        this.list = list;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(list);
    }

    protected PersonList(Parcel in) {
        this.list = in.createTypedArrayList(Person.CREATOR);
    }

    public static final Creator<PersonList> CREATOR = new Creator<PersonList>() {
        public PersonList createFromParcel(Parcel source) {
            return new PersonList(source);
        }

        public PersonList[] newArray(int size) {
            return new PersonList[size];
        }
    };
}
