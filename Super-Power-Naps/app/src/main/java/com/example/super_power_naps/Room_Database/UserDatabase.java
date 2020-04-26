package com.example.super_power_naps.Room_Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = User.class, version = 1)
@TypeConverters(Converter.class)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();

    private static UserDatabase userDatabaseInstance;

    static UserDatabase getUserDatabaseInstance(Context context) {
        if (userDatabaseInstance == null) {
            userDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, "user_database").build();
        }
        return userDatabaseInstance;
    }
}
