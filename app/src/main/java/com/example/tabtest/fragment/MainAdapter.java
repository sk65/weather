package com.example.tabtest.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tabtest.R;

public class MainAdapter extends BaseAdapter {
    private Context context;
    private String[] numberWord;
    private LayoutInflater inflater;

    public MainAdapter(Context context, String[] numberWord) {
        this.context = context;
        this.numberWord = numberWord;
    }

    @Override
    public int getCount() {
        return numberWord.length;
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
        TextView textView = convertView.findViewById(R.id.textView_rowItem);
        textView.setText(numberWord[position]);
        return convertView;
    }
}
