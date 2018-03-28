package com.example.suman.i_remotedemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suman.i_remotedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suman on 28-03-2018.
 */

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment_layout, container, false);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        setUpViewPager(viewPager);
        TabLayout tabs = (TabLayout) rootView.findViewById(R.id.home_tabs);
        tabs.setupWithViewPager(viewPager);
        return rootView;
    }

    private void setUpViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new InReviewJobsFragment(), "In Review");
        adapter.addFragment(new NewJobsFragment(), "New");
        viewPager.setAdapter(adapter);
    }

    private class FragmentAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public FragmentAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }
}
