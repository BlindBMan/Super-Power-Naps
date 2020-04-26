package com.example.super_power_naps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements TakeANapFragment.OnTakeNapClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_btn_container, new TakeANapFragment()).commit();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.logout_btn_container, new LogoutFragment()).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.unsigned_btns_container, new SignInFragment()).commit();
        }
    }


    @Override
    public void onNapBtnClick() {
        startActivity(new Intent(getApplicationContext(), AlarmActivity.class));
    }
}
