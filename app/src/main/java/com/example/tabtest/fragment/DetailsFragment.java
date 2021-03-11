package com.example.tabtest.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tabtest.R;
import com.example.tabtest.adapter.HorizontalRecyclerViewAdapter;
import com.example.tabtest.adapter.GridViewAdapter;
import com.example.tabtest.model.DayWeatherCardModel;
import com.example.tabtest.model.WeatherParamCardModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DetailsFragment extends Fragment {
    public static final String TAG = "DetailsFragmentTag";
    private HorizontalRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ObjectAnimator objectAnimator;
    private GridView gridView;
    private String[] gridViewDetailsValues;
    private String[] weatherDescription;
    private int[] weatherIcons;
    private ArrayList<DayWeatherCardModel> dayWeatherCardModels;
    private ArrayList<WeatherParamCardModel> weatherParamCardModels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        weatherDescription = getResources().getStringArray(R.array.weather_parameters);
        weatherIcons = new int[]{
                R.drawable.ic__02_light,
                R.drawable.ic__03_snowflake,
                R.drawable.ic__03_snowflake,
                R.drawable.ic__03_snowflake,
                R.drawable.ic__04_water,
                R.drawable.ic__04_water,
                R.drawable.ic__04_water,
                R.drawable.ic_sunny,
                R.drawable.ic_sunny,
                R.drawable.ic_sunny,
                R.drawable.ic_sunny,
        };
        gridViewDetailsValues = getResources().getStringArray(R.array.grid_view_details_values);
        weatherParamCardModels = new ArrayList<>(weatherDescription.length);
        dayWeatherCardModels = new ArrayList<>(weatherIcons.length);
        for (int weatherIcon : weatherIcons) {
            DayWeatherCardModel model = new DayWeatherCardModel(
                    "Сегодня",
                    "-2°",
                    "22 км/час",
                    weatherIcon,
                    R.drawable.ic_diagonal_arrow
            );
            dayWeatherCardModels.add(model);
        }
        for (int i = 0; i < weatherDescription.length; i++) {
            WeatherParamCardModel model = new WeatherParamCardModel(
                    weatherDescription[i],
                    gridViewDetailsValues[i]
            );
            weatherParamCardModels.add(model);
        }
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initGridView(view);
        initProgressBar(view);
        initRecyclerView(view);
    }

    private void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView_fragmentDetails_weather_for_day_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        adapter = new HorizontalRecyclerViewAdapter(getContext(), dayWeatherCardModels);
        recyclerView.setAdapter(adapter);
    }

    private void initGridView(View view) {
        gridView = view.findViewById(R.id.gridView_fragmentDetails);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(getContext(), weatherParamCardModels);
        gridView.setAdapter(gridViewAdapter);
    }

    private void initProgressBar(View view) {
        progressBar = view.findViewById(R.id.progressBar_fragmentDetails);
        objectAnimator = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
        objectAnimator.setDuration(7000);
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(getContext(), "OP compl", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}