package com.example.suman.i_remotedemo.entity;

/**
 * Created by Suman on 28-03-2018.
 */

public class Job {

    private String jobTitle;
    private String jobDescription;
    private String jobCreatedOn;
    private String jobModelNumber;
    private String jobContractNumber;
    private String jobLocation;

    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobCreatedOn() {
        return jobCreatedOn;
    }
    public void setJobCreatedOn(String jobCreatedOn) {
        this.jobCreatedOn = jobCreatedOn;
    }

    public String getJobModelNumber() {
        return jobModelNumber;
    }
    public void setJobModelNumber(String jobModelNumber) {
        this.jobModelNumber = jobModelNumber;
    }

    public String getJobContractNumber() {
        return jobContractNumber;
    }
    public void setJobContractNumber(String jobContractNumber) {
        this.jobContractNumber = jobContractNumber;
    }

    public String getJobLocation() {
        return jobLocation;
    }
    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

}
