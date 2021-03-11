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
import com.example.tabtest.model.DayWeatherCardModel;

import java.util.ArrayList;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    ArrayList<DayWeatherCardModel> cardModels;

    public HorizontalRecyclerViewAdapter(Context context, ArrayList<DayWeatherCardModel> cardModels) {
        this.context = context;
        this.cardModels = cardModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_details_fragment, parent, false);
        return new HorizontalRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageViewWeatherIcon.setImageResource(cardModels.get(position).getImageViewWeatherIcon());
        holder.imageViewWindDirection.setImageResource(cardModels.get(position).getImageViewWindDirection());
        holder.textViewCurrentTime.setText(cardModels.get(position).getTextViewCurrentTime());
        holder.textViewCurrentTimeTemperature.setText(cardModels.get(position).getTextViewCurrentTimeTemperature());
        holder.textViewCurrentWindSpeed.setText(cardModels.get(position).getTextViewCurrentWindSpeed());
    }

    @Override
    public int getItemCount() {
        return cardModels.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCurrentTime;
        private TextView textViewCurrentTimeTemperature;
        private TextView textViewCurrentWindSpeed;
        private ImageView imageViewWeatherIcon;
        private ImageView imageViewWindDirection;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCurrentTime = itemView.findViewById(R.id.textView_timeHolder);
            textViewCurrentTimeTemperature = itemView.findViewById(R.id.textView_temperatureHolder);
            textViewCurrentWindSpeed = itemView.findViewById(R.id.textView_wind_speed);
            imageViewWeatherIcon = itemView.findViewById(R.id.imageView_list_item_iconHolder);
            imageViewWindDirection = itemView.findViewById(R.id.imageView_windDirection);
        }
    }
}
