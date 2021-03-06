package com.example.tabtest.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tabtest.R;
import com.example.tabtest.fragment.DetailsFragment;
import com.example.tabtest.fragment.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private List<Fragment> fragments;
    private final Context mContext;

    public SectionsPagerAdapter(Context context, @NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        Fragment mainFragment = new MainFragment();
        Fragment detailsFragment = new DetailsFragment();
        fragments = new ArrayList<>(2);
        fragments.add(mainFragment);
        fragments.add(detailsFragment);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}