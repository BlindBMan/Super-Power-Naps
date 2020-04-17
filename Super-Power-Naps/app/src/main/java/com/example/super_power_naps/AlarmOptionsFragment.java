package com.example.super_power_naps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlarmOptionsFragment extends Fragment {

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_alarm_options, container, false);

        alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getContext(), AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        view.findViewById(R.id.tired).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm(30);
            }
        });

        view.findViewById(R.id.sleepy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm(35);
            }
        });

        view.findViewById(R.id.normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm(40);
            }
        });

        return view;
    }

    private void setAlarm(int minutes) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat mins = new SimpleDateFormat("mm");
        SimpleDateFormat hour = new SimpleDateFormat("hh");

        calendar.set(Calendar.HOUR, Integer.parseInt(hour.format(date)));
        calendar.set(Calendar.MINUTE, Integer.parseInt(mins.format(date)) + minutes);
        Toast.makeText(getContext(), "Get to bed!!!", Toast.LENGTH_SHORT).show();
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.nap_options_container, new AlarmSetFragment())
                .commit();
    }


}
