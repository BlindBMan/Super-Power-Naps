package com.example.super_power_naps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements TakeANapFragment.OnTakeNapClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_btn_container, new TakeANapFragment()).commit();

//        Button login = findViewById(R.id.login_btn_main);
//        Button register = findViewById(R.id.register_btn);
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//            }
//        });
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
//            }
//        });
    }


    @Override
    public void onNapBtnClick() {
        startActivity(new Intent(getApplicationContext(), AlarmActivity.class));
    }
}
