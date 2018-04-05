package com.example.suman.i_remotedemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Job;
import com.example.suman.i_remotedemo.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobDescriptionFragment extends Fragment {


    public static final String JOB = "JOB";

    private Job job;
    //private int position;
    private TextView txtJobDescTitle;

    public JobDescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_description, null, false);
        Bundle args = getArguments();
        //job = (Job) args.getSerializable(JobDescriptionFragment.JOB);
        //position = args.getInt(JobDescriptionFragment.JOB);
        String jobString = args.getString(JobDescriptionFragment.JOB);
        job = Utils.getGsonParser().fromJson(jobString, Job.class);
        txtJobDescTitle = (TextView) view.findViewById(R.id.job_desc_title);
        txtJobDescTitle.setText("Position : " + job.getJobTitle());
        return view;
    }

}
