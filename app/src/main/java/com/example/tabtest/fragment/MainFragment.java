package com.example.tabtest.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabtest.activity.MainActivity;
import com.example.tabtest.R;
import com.example.tabtest.MyViewAdapter;


public class MainFragment extends Fragment {
    private LinearLayoutManager manager = new LinearLayoutManager(getContext());
    private RecyclerView recyclerView;
    private MyViewAdapter viewAdapter;
    private String[] daysOfWeek;
    private String[] weatherDescription;
    private final int[] weatherIcons = {
            R.drawable.ic__02_light,
            R.drawable.ic__03_snowflake,
            R.drawable.ic__04_water,
            R.drawable.ic__06_sunny,
            R.drawable.ic__06_sunny,
            R.drawable.ic__06_sunny,
            R.drawable.ic__06_sunny,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        daysOfWeek = getResources().getStringArray(R.array.days_of_the_week);
        weatherDescription = getResources().getStringArray(R.array.weather_description);
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.button_mainFragment)
                .setOnClickListener((v) -> MainActivity.viewPager.setCurrentItem(1));

        recyclerView = view.findViewById(R.id.recyclerView_mainFragment);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);



        viewAdapter = new MyViewAdapter(getContext(), daysOfWeek, weatherDescription, weatherIcons);
        recyclerView.setAdapter(viewAdapter);

        super.onViewCreated(view, savedInstanceState);
    }


}