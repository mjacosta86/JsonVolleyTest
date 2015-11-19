package com.macostay.jsonvolleytest.models;

import android.animation.TypeConverter;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 14/10/2015.
 */
public class Person implements Parcelable {

    private int index;
    private String name;
    private int age;
    private String address;
    private String email;
    private String phone;
    private String image;

    public Person() {
    }

    public Person(int index, String name, int age, String address, String email, String phone, String image) {
        this.index = index;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.image = image;
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

    public int getAge() {
        return age;
    }

    public void setEdad(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        dest.writeInt(this.index);
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeString(this.address);
        dest.writeString(this.email);
        dest.writeString(this.phone);
        dest.writeString(this.image);
    }

    protected Person(Parcel in) {
        this.index = in.readInt();
        this.name = in.readString();
        this.age = in.readInt();
        this.address = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
        this.image = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
