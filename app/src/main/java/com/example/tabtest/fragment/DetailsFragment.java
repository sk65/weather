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

public class DetailsFragment extends Fragment {
    public static final String TAG = "DetailsFragmentTag";
    private HorizontalRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ObjectAnimator objectAnimator;
    private GridView gridView;
    private String[] weatherDescription;
    private final int[] weatherIcons = {
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

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        weatherDescription = getResources().getStringArray(R.array.weather_parameters);
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
        adapter = new HorizontalRecyclerViewAdapter(getContext(), weatherIcons);
        recyclerView.setAdapter(adapter);
    }

    private void initGridView(View view) {
        gridView = view.findViewById(R.id.gridView_fragmentDetails);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(getContext(), weatherDescription);
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