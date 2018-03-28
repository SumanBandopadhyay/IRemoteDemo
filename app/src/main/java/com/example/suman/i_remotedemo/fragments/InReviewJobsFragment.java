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

import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suman on 28-03-2018.
 */

public class InReviewJobsFragment extends Fragment {

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
        View rootView = inflater.inflate(R.layout.in_review_fragment_layout, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.in_review_recycler_view);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new InReviewAdapter(jobs);
        recyclerView.setAdapter(adapter);
        populateData();
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
    }

    private class InReviewAdapter extends RecyclerView.Adapter<InReviewAdapter.InReviewViewHolder> {

        private List<Job> jobs;

        public InReviewAdapter(List<Job> jobs) {
            this.jobs = jobs;
        }

        @Override
        public InReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_layout, parent, false);
            return new InReviewViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(InReviewViewHolder holder, int position) {
            Job job = jobs.get(position);
            holder.txtJobTitle.setText(job.getJobTitle());
            holder.txtJobLocation.setText(job.getJobLocation());
        }

        @Override
        public int getItemCount() {
            return jobs.size();
        }

        public class InReviewViewHolder extends RecyclerView.ViewHolder {

            TextView txtJobTitle;
            TextView txtJobLocation;

            public InReviewViewHolder(View itemView) {
                super(itemView);
                txtJobTitle = (TextView) itemView.findViewById(R.id.job_title);
                txtJobLocation = (TextView) itemView.findViewById(R.id.job_location);
            }
        }
    }
}
