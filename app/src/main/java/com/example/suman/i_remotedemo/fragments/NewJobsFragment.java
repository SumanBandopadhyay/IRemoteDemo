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

public class NewJobsFragment extends Fragment implements JobClickListner {

    private RecyclerView recyclerView;
    private JobAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Job> jobs = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateData();
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
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        //populateData();
        return rootView;
    }

    private void populateData() {
        Job job = new Job();
        job.setJobTitle("Remote Malfunction");
        job.setJobDescription("Unable to control temperature using the remote");
        job.setJobCreatedOn("02/03/2018");
        job.setJobModelNumber("68768768");
        job.setJobContractNumber("988634809");
        job.setJobLocation("Behala");
        jobs.add(job);

        job = new Job();
        job.setJobTitle("Delayed Cooling");
        job.setJobDescription("Room temperature is constant, no cooling even after hours");
        job.setJobCreatedOn("12/03/2018");
        job.setJobModelNumber("68768768");
        job.setJobContractNumber("988634809");
        job.setJobLocation("Behala");
        jobs.add(job);

        job = new Job();
        job.setJobTitle("Unable to set the swing mode");
        job.setJobDescription("Switching to the swing mode is not operational");
        job.setJobCreatedOn("22/03/2018");
        job.setJobModelNumber("68768768");
        job.setJobContractNumber("988634809");
        job.setJobLocation("Behala");
        jobs.add(job);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void jobClicked(Job job) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        JobDescriptionFragment jobDescriptionFragment = new JobDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(JobDescriptionFragment.JOB, Utils.getGsonParser().toJson(job));
        jobDescriptionFragment.setArguments(args);
        fragmentTransaction.replace(R.id.frame_layout, jobDescriptionFragment, jobDescriptionFragment.getTag())
                .addToBackStack(jobDescriptionFragment.getTag());
        fragmentTransaction.commit();
    }
}
