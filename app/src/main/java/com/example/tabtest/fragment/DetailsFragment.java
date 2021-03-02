package com.example.tabtest.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tabtest.R;

public class DetailsFragment extends Fragment {
    public static final String TAG = "DetailsFragmentTag";
    private ProgressBar progressBar;
    private ObjectAnimator objectAnimator;
    private GridView gridView;
    private String[] numberWord = {"One", "Two", "Three", "Four", "Five", "Six"};

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.gridView_mainDetails);
        MainAdapter mainAdapter = new MainAdapter(getContext(), numberWord);
        gridView.setAdapter(mainAdapter);
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