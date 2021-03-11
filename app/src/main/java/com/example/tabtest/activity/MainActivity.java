package com.example.tabtest.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tabtest.R;
import com.example.tabtest.adapter.SectionsPagerAdapter;
import com.example.tabtest.fragment.DetailsFragment;
import com.example.tabtest.fragment.MainFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final int LOCATION_PERMISSION_CODE = 101;
    public static ViewPager viewPager;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private ActionBarDrawerToggle toggle;
    private TabLayout tabs;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SwipeRefreshLayout refreshLayout;
    private SharedPreferences sharedPreferences;
    private final String LAST_OPEN_FRAGMENT_TAG = "lastOpenFragmentTag";
    private final String PREF_KEY = "PrefKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar_mainActivity));

        initRefreshLayout();
        initTabs();
        initNavView();

        sharedPreferences = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);
        String test = sharedPreferences.getString(LAST_OPEN_FRAGMENT_TAG, MainFragment.TAG);
        if (test.equals(MainFragment.TAG)) {
            viewPager.setCurrentItem(0);
        } else {
            viewPager.setCurrentItem(1);
        }

        Intent intent = getIntent();
        String message = intent.getStringExtra(ScreenActivity.CITY_MESSAGE);
        if (message != null) {
            getSupportActionBar().setTitle(message);
        } else {
            getSupportActionBar().setTitle(R.string.app_name);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initRefreshLayout() {
        refreshLayout = findViewById(R.id.swipeRefreshLayout_mainActivity);
        refreshLayout.setOnRefreshListener(() -> {
            if (checkLocationPermissions()) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_PERMISSION_CODE);
            }
            setCity();
            Toast.makeText(this, getString(R.string.refresh), Toast.LENGTH_SHORT).show();
        });
    }

    private void initTabs() {
        sectionsPagerAdapter = new SectionsPagerAdapter(this,
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager = findViewById(R.id.viewPager_mainActivity);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabLayout_mainActivity);
        tabs.setupWithViewPager(viewPager);
    }

    @SuppressLint("NonConstantResourceId")
    private void initNavView() {
        drawerLayout = findViewById(R.id.drawerLayout_mainActivity_mainContainer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navView_mainActivity);
        navigationView.setNavigationItemSelectedListener((item) -> {
            switch (item.getItemId()) {
                case R.id.miItem1:
                    Toast.makeText(this, R.string.todo_1, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.miItem2:
                    Toast.makeText(this, R.string.todo_2, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.miItem3:
                    Toast.makeText(this, R.string.todo_3, Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });
    }

    private void setCity() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation().addOnSuccessListener((location) -> {
            if (location != null) {
                try {
                    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                    List<Address> addresses = geocoder.
                            getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    getSupportActionBar().setTitle(addresses.get(0).getLocality());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private boolean checkLocationPermissions() {
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setCity();
            }
        }
    }

    @Override
    protected void onStop() {
        saveCurrentFragmentTag();
        super.onStop();
    }

    private void saveCurrentFragmentTag() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int currentFragmentItem = viewPager.getCurrentItem();
        if (currentFragmentItem == 0) {
            editor.putString(LAST_OPEN_FRAGMENT_TAG, MainFragment.TAG);
        } else {
            editor.putString(LAST_OPEN_FRAGMENT_TAG, DetailsFragment.TAG);
        }
        editor.apply();
    }
}