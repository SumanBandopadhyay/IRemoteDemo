package com.example.suman.i_remotedemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suman.i_remotedemo.adapters.JobAdapter;
import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Job;
import com.example.suman.i_remotedemo.listners.JobClickListner;
import com.example.suman.i_remotedemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suman on 28-03-2018.
 */

public class InReviewJobsFragment extends Fragment implements JobClickListner {

    private RecyclerView recyclerView;
    private JobAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Job> jobs = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.in_review_fragment_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.in_review_recycler_view);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        populateData();
        adapter = new JobAdapter(jobs);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        //populateData();
        return rootView;
    }

    private void populateData() {
        Job job = new Job();
        job.setJobTitle("Job Title 1");
        job.setJobLocation("Job Location 1");
        jobs.add(job);
        job = new Job();
        job.setJobTitle("Job Title 2");
        job.setJobLocation("Job Location 2");
        jobs.add(job);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void jobClicked(Job job) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        JobDescriptionFragment jobDescriptionFragment = new JobDescriptionFragment();
        Bundle args = new Bundle();
        //args.putSerializable(JobDescriptionFragment.JOB, job);
        //args.putInt(JobDescriptionFragment.JOB, position);
        args.putString(JobDescriptionFragment.JOB, Utils.getGsonParser().toJson(job));
        jobDescriptionFragment.setArguments(args);
        fragmentTransaction.replace(R.id.frame_layout, jobDescriptionFragment, jobDescriptionFragment.getTag());
        //fragmentTransaction.add(R.id.frame_layout, jobDescriptionFragment, jobDescriptionFragment.getTag()).addToBackStack(null).commit();
        fragmentTransaction.commit();
    }
}
