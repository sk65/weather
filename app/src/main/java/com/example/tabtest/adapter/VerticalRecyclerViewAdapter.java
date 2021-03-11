package com.example.tabtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tabtest.R;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.MyViewHolder> {

    private String[] daysOfWeek;
    private String[] weatherDescription;
    private int[] weatherIcons;
    private final Context context;

    public VerticalRecyclerViewAdapter(Context context, String[] daysOfWeek, String[] weatherDescription, int[] weatherIcons) {
        this.daysOfWeek = daysOfWeek;
        this.weatherDescription = weatherDescription;
        this.weatherIcons = weatherIcons;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_main_fragment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.weatherDesc.setText(weatherDescription[position]);
        holder.dayOfWeek.setText(daysOfWeek[position]);
        holder.temperatureHolder.setText("-2°  /  -6° ");
        holder.icon.setImageResource(weatherIcons[position]);
    }

    @Override
    public int getItemCount() {
        return daysOfWeek.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView weatherDesc;
        private TextView temperatureHolder;
        private TextView dayOfWeek;
        private ImageView icon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            weatherDesc = itemView.findViewById(R.id.textView_listItem_weatherDesc);
            temperatureHolder = itemView.findViewById(R.id.textView_listItem_temperatureHolder);
            dayOfWeek = itemView.findViewById(R.id.textView_listItem_dayOfWeek);
            icon = itemView.findViewById(R.id.imageView_list_item_iconHolder);
        }
    }
}
