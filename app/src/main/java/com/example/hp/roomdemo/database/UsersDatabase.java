package com.example.hp.roomdemo.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.hp.roomdemo.model.User;

/**
 * Created by Name name on 12/6/2017.
 * company Ltd
 * example@gmail.com
 */
@Database(entities = {User.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {


    private static UsersDatabase INSTANCE;

    public abstract MyDao myDao();

    public static UsersDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), UsersDatabase.class, "user-database.db")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
