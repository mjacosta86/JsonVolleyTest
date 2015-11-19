package com.macostay.jsonvolleytest.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by macostay on 14/10/2015.
 */
public class PersonSerialized implements Parcelable{

    @SerializedName("index")
    private int index;
    @SerializedName("name")
    private String name;
    @SerializedName("age")
    private int age;
    @SerializedName("address")
    private String address;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;
    @SerializedName("image")
    private String image;

    public PersonSerialized() {
    }

    public PersonSerialized(int index, String name, int age, String address, String email, String phone, String image) {
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

    protected PersonSerialized(Parcel in) {
        this.index = in.readInt();
        this.name = in.readString();
        this.age = in.readInt();
        this.address = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
        this.image = in.readString();
    }

    public static final Creator<PersonSerialized> CREATOR = new Creator<PersonSerialized>() {
        public PersonSerialized createFromParcel(Parcel source) {
            return new PersonSerialized(source);
        }

        public PersonSerialized[] newArray(int size) {
            return new PersonSerialized[size];
        }
    };
}
