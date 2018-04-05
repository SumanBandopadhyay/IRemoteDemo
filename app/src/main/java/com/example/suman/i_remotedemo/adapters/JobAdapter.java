package com.example.suman.i_remotedemo.adapters;

import android.app.FragmentManager;
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
    public void onBindViewHolder(final JobViewHolder holder, int position) {
        final Job job = jobs.get(position);
        holder.txtJobTitle.setText(job.getJobTitle());
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
        TextView txtJobLocation;
        CardView jobCardView;

        public JobViewHolder(View itemView) {
            super(itemView);
            //itemView.setOnClickListener(this);
            txtJobTitle = (TextView) itemView.findViewById(R.id.job_title);
            txtJobLocation = (TextView) itemView.findViewById(R.id.job_location);
            jobCardView = (CardView) itemView.findViewById(R.id.job_card_view);
            //jobCardView.setOnClickListener(this);
        }


    }

    public void setClickListener(JobClickListner clickListener){
        this.clickListner = clickListener;
    }
}
