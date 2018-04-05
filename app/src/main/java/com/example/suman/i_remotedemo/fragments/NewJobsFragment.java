package com.example.suman.i_remotedemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suman.i_remotedemo.Adapters.JobAdapter;
import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suman on 28-03-2018.
 */

public class NewJobsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Job> jobs = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.new_jobs_fragment_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.new_job_recycler_view);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new JobAdapter(jobs);
        recyclerView.setAdapter(adapter);
        populateData();
        return rootView;
    }

    private void populateData() {
        Job job = new Job();
        job.setJobTitle("Job title 13");
        job.setJobLocation("Salt Lake");
        jobs.add(job);
        job = new Job();
        job.setJobTitle("Job title 14");
        job.setJobLocation("Baguiati");
        jobs.add(job);
    }

}
