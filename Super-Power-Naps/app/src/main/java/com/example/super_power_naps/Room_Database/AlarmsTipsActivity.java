package com.example.super_power_naps.Room_Database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.super_power_naps.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AlarmsTipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms_tips);

        RecyclerView recyclerView = findViewById(R.id.all_alarms);
        final AlarmAdapter alarmAdapter = new AlarmAdapter(this);

        ArrayList<String> tips = new ArrayList<String>() {};
        try (InputStreamReader is = new InputStreamReader(getAssets().open("tips.json"))) {
            BufferedReader bf = new BufferedReader(is);
            Gson gson = new Gson();
            Tip tip = gson.fromJson(bf, Tip.class);

            for (TipContainer tc: tip.tip) {
                tips.add(tc.text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        alarmAdapter.setTips(tips);
        recyclerView.setAdapter(alarmAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

    }

    private class Tip {
        ArrayList<TipContainer> tip;
    }

    private class TipContainer {
        String text;
    }
}
