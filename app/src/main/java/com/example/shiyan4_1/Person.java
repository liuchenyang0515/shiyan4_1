package com.example.shiyan4_1;

import android.os.Parcel;
import android.os.Parcelable;

class Person implements Parcelable {
    private String name;
    private String age;
    private String height;

    public Person() {
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            Person person = new Person();
            person.name = in.readString();
            person.age = in.readString();
            person.height = in.readString();
            return person;
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    Person(String name, String age, String height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(height);
    }
}
