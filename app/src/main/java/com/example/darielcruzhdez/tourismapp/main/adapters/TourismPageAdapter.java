package com.example.darielcruzhdez.tourismapp.main.adapters;

import android.support.annotation.Nullable;
import android.support.v7.app.Fragment;
import android.support.v7.app.FragmentManager;
import android.support.v7.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

public TourismPageAdapter extends FragmentPagerAdapter{
    private final List<Fragments> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public TourismPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
    return mFragmentList.get(position);
    }
    public void addFragment(Fragment fragment, String title) {
    mFragmentList.add(fragment);
    mFragmentTitleList.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
    return mFragmentTitleList.get(position);
    }
    @Override
    public int getCount() {
    return mFragmentList.size();
    }

}