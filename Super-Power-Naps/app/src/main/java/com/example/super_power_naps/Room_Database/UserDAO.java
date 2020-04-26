package com.example.super_power_naps.Room_Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM Users WHERE id = :uid")
    public User getUser(String uid);

    @Query("SELECT alarms from Users where id = :uid")
    LiveData<List<String>> getAllAlarms(String uid);

    @Query("UPDATE Users SET alarms = :newAlarms WHERE id = :uid")
    public void updateAlarms(List<String> newAlarms, String uid);
}
