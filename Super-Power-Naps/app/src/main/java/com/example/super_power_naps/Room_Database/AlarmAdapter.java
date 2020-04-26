package com.example.super_power_naps.Room_Database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.super_power_naps.R;

import java.util.ArrayList;
import java.util.List;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder> {
    private ArrayList<String> tips;
    private LayoutInflater layoutInflater;

    public class AlarmViewHolder extends RecyclerView.ViewHolder {
        private TextView alarmTextView;

        public AlarmViewHolder(View itemView) {
            super(itemView);
            alarmTextView = itemView.findViewById(R.id.cv_alarm);
        }

        public void setData(String tip) {
            alarmTextView.setText(tip);
        }
    }

    public AlarmAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new AlarmViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder holder, int position) {
        if (tips != null) {
            String tip = tips.get(position);
            holder.setData(tip);
        } else {
            holder.alarmTextView.setText(R.string.error);
        }
    }

    @Override
    public int getItemCount() {
        if (tips != null) {
            return tips.size();
        } else {
            return 0;
        }
    }

    public void setTips(ArrayList<String> tips) {
        this.tips = tips;
    }
}
