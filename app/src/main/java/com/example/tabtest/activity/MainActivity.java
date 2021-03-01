package com.example.tabtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tabtest.R;
import com.example.tabtest.SectionsPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static ViewPager viewPager;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private ActionBarDrawerToggle toggle;
    private TabLayout tabs;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // init tabs
        sectionsPagerAdapter = new SectionsPagerAdapter(this,
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager = findViewById(R.id.viewPager_mainActivity);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabLayout_mainActivity);
        tabs.setupWithViewPager(viewPager);

        // init actionBar
        setSupportActionBar(findViewById(R.id.toolbar_mainActivity));

        drawerLayout = findViewById(R.id.draverLayout_mainActivity_mainContainer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.navView_mainActivity);
        navigationView.setNavigationItemSelectedListener((item) -> {
            switch (item.getItemId()) {
                case R.id.miItem1:
                    Intent intent = new Intent(this, TestActivity.class);
                    startActivity(intent);
                    break;
                case R.id.miItem2:
                    Toast.makeText(this, "TODO-2", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.miItem3:
                    Toast.makeText(this, "TODO-3", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public SectionsPagerAdapter getSectionsPagerAdapter() {
        return sectionsPagerAdapter;
    }
}