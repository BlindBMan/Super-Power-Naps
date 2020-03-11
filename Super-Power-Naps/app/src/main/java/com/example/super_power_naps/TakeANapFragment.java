package com.example.super_power_naps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TakeANapFragment extends Fragment {
    private OnTakeNapClickListener activ_listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_take_anap,  container, false);
        Button nap_btn = view.findViewById(R.id.nap_btn);

        nap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activ_listener.onNapBtnClick();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnTakeNapClickListener) {
            activ_listener = (OnTakeNapClickListener) context;
        } else {
            throw  new RuntimeException(context.toString() + "must implement  OnTakeNapClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activ_listener = null;
    }

    public interface OnTakeNapClickListener {
        void onNapBtnClick();
    }
}
