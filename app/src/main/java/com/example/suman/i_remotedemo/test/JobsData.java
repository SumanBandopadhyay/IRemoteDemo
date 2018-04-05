package com.example.suman.i_remotedemo.test;

import com.example.suman.i_remotedemo.entity.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suman on 04-04-2018.
 */

public class JobsData {
    public static List<Job> jobs = new ArrayList<>();
    public JobsData() {
        populateData();
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

}
