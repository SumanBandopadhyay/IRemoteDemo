package com.example.suman.i_remotedemo.entity;

import java.io.Serializable;

/**
 * Created by Suman on 28-03-2018.
 */

public class Job {

    private String jobTitle;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    private String jobLocation;

}
