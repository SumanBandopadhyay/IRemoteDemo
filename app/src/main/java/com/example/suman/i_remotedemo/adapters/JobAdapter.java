package com.example.suman.i_remotedemo.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Job;
import com.example.suman.i_remotedemo.listners.JobClickListner;
import com.example.suman.i_remotedemo.test.JobsData;

import java.util.List;

/**
 * Created by Poulami on 28-03-2018.
 */

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private List<Job> jobs;
    private JobClickListner clickListner;

    private Context mCtx;

    public JobAdapter(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_layout, parent, false);
        mCtx = parent.getContext();
        return new JobViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {
        final Job job = jobs.get(position);
        holder.txtJobTitle.setText(job.getJobTitle());
        holder.txtJobCreatedOn.setText(job.getJobCreatedOn());
        holder.txtJobModelNumber.setText(job.getJobModelNumber());
        holder.txtJobLocation.setText(job.getJobLocation());
        holder.jobCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mCtx, "Clicked : " + job.getJobTitle(), Toast.LENGTH_LONG).show();
                clickListner.jobClicked(job);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class JobViewHolder extends RecyclerView.ViewHolder {

        TextView txtJobTitle;
        TextView txtJobCreatedOn;
        TextView txtJobModelNumber;
        TextView txtJobLocation;
        CardView jobCardView;

        public JobViewHolder(View itemView) {
            super(itemView);
            txtJobTitle = (TextView) itemView.findViewById(R.id.job_title);
            txtJobCreatedOn = (TextView) itemView.findViewById(R.id.job_created_on);
            txtJobModelNumber = (TextView) itemView.findViewById(R.id.job_model_number);
            txtJobLocation = (TextView) itemView.findViewById(R.id.job_location);
            jobCardView = (CardView) itemView.findViewById(R.id.job_card_view);
        }
    }

    public void setClickListener(JobClickListner clickListener){
        this.clickListner = clickListener;
    }
}
