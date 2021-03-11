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
import com.example.tabtest.model.WeekWeatherCardModel;

import java.util.ArrayList;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.MyViewHolder> {
    private final ArrayList<WeekWeatherCardModel> model;
    private final Context context;

    public VerticalRecyclerViewAdapter(Context context, ArrayList<WeekWeatherCardModel> model) {
        this.model = model;
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
        holder.weatherDesc.setText(model.get(position).getWeatherDesc());
        holder.dayOfWeek.setText(model.get(position).getDayOfWeek());
        holder.temperatureHolder.setText(model.get(position).getTemperatureHolder());
        holder.icon.setImageResource(model.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView weatherDesc;
        private final TextView temperatureHolder;
        private final TextView dayOfWeek;
        private final ImageView icon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            weatherDesc = itemView.findViewById(R.id.textView_listItem_weatherDesc);
            temperatureHolder = itemView.findViewById(R.id.textView_listItem_temperatureHolder);
            dayOfWeek = itemView.findViewById(R.id.textView_listItem_dayOfWeek);
            icon = itemView.findViewById(R.id.imageView_list_item_iconHolder);
        }
    }
}
