package com.example.super_power_naps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.super_power_naps.R;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nap_options_container, new AlarmOptionsFragment()).commit();
    }
}
