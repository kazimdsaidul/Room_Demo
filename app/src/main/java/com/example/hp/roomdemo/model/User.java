package com.example.hp.roomdemo.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

/**
 * Created by Name name on 12/6/2017.
 * company Ltd
 * example@gmail.com
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String firstName;
    public String lastName;

    @Ignore
    Bitmap picture;

    @Ignore
    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", picture=" + picture +
                '}';
    }
}
