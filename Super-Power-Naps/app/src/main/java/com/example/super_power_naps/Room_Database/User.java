package com.example.super_power_naps.Room_Database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;
import android.util.Log;

import com.example.super_power_naps.R;

import java.util.ArrayList;

@Entity(tableName = "Users")
public class User {

    @PrimaryKey
    @NonNull
    private String id;

    private ArrayList<String> alarms = new ArrayList<>();

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getAlarms() {
        return alarms;
    }

    public void setAlarms(ArrayList<String> alarms) {
        this.alarms = alarms;
    }

    public void addAlarm(String alarm) {
        this.alarms.add(alarm);
    }
}
