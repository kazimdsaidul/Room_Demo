package com.example.hp.roomdemo.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.hp.roomdemo.model.User;

import java.util.List;

/**
 * Created by Name name on 12/6/2017.
 * company Ltd
 * example@gmail.com
 */
@Dao
public interface MyDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void insertUsers(User... users);

    @Insert
    public void insertBothUsers(User user1, User user2);

    @Insert
    public void insertUsersAndFriends(User user, List<User> friends);

    @Update
    public void updateUsers(User... users);

    @Delete
    public void deleteUsers(User... users);

    @Query("SELECT * FROM user")
    public User[] loadAllUsers();



}
