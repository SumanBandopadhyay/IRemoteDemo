package com.example.suman.i_remotedemo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Job;
import com.example.suman.i_remotedemo.fragments.InReviewJobsFragment;

import java.util.List;

/**
 * Created by Poulami on 28-03-2018.
 */

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewAdapter> {

    private List<Job> jobs;

    public JobAdapter(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public JobViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_layout, parent, false);
        return new JobViewAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(JobViewAdapter holder, int position) {
        Job job = jobs.get(position);
        holder.txtJobTitle.setText(job.getJobTitle());
        holder.txtJobLocation.setText(job.getJobLocation());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class JobViewAdapter extends RecyclerView.ViewHolder {

        TextView txtJobTitle;
        TextView txtJobLocation;

        public JobViewAdapter(View itemView) {
            super(itemView);
            txtJobTitle = (TextView) itemView.findViewById(R.id.job_title);
            txtJobLocation = (TextView) itemView.findViewById(R.id.job_location);
        }
    }
}
