package com.example.tabtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tabtest.R;
import com.example.tabtest.model.WeatherParamCardModel;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<WeatherParamCardModel> models;
    private LayoutInflater inflater;

    public GridViewAdapter(Context context, ArrayList<WeatherParamCardModel> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_view_row_item, null);
        }
        TextView textViewWeatherDescription = convertView.findViewById(R.id.textView_rowItem_weatherDesc);
        TextView textViewWeatherParam = convertView.findViewById(R.id.textView_rowItem_weatherParam);
        textViewWeatherDescription.setText(models.get(position).getWeatherDescription());
        textViewWeatherParam.setText(models.get(position).getWeatherParam());
        return convertView;
    }
}
