package com.example.tabtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tabtest.R;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private String[] weatherDescription;
    private LayoutInflater inflater;

    public GridViewAdapter(Context context, String[] numberWord) {
        this.context = context;
        this.weatherDescription = numberWord;
    }

    @Override
    public int getCount() {
        return weatherDescription.length;
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
            convertView = inflater.inflate(R.layout.row_item, null);
        }
        TextView textView = convertView.findViewById(R.id.textView_rowItem_weatherDesc);
        TextView textView1 = convertView.findViewById(R.id.textView_rowItem_airTemp);
        textView.setText(weatherDescription[position]);
        textView1.setText("-2℃");
        return convertView;
    }
}
