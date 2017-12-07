package com.example.hp.roomdemo.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.example.hp.roomdemo.model.User;

/**
 * Created by Name name on 12/6/2017.
 * company Ltd
 * example@gmail.com
 */
@Database(entities = {User.class}, version = 2)
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
                            .addMigrations(MIGRATION_1_2)
                            .build();
        }
        return INSTANCE;
    }


    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE user "
                    + " ADD COLUMN email TEXT");

        }
    };

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
