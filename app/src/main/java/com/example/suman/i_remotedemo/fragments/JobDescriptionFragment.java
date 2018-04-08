package com.example.suman.i_remotedemo.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Job;
import com.example.suman.i_remotedemo.utils.Utils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobDescriptionFragment extends Fragment {


    public static final String JOB = "JOB";

    private Job job;

    private TextView txtJobDescTitle;
    private TextView txtJobDescContact;
    private TextView txtJobDescCreatedOn;
    private TextView txtJobDescModelNo;
    private TextView txtJobDescLocation;
    private TextView txtJobDescDescription;
    private MapView mapView;
    private Button btnStartJob;

    private GoogleMap googleMap;

    public JobDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        /**
         * Setting up views for the fragment
         */
        txtJobDescTitle = (TextView) view.findViewById(R.id.job_desc_title);
        txtJobDescContact = (TextView) view.findViewById(R.id.job_desc_contact_no);
        txtJobDescCreatedOn = (TextView) view.findViewById(R.id.job_desc_created_on);
        txtJobDescDescription = (TextView) view.findViewById(R.id.job_desc_description);
        txtJobDescLocation = (TextView) view.findViewById(R.id.job_desc_location);
        txtJobDescModelNo = (TextView) view.findViewById(R.id.job_desc_model_no);
        btnStartJob = (Button) view.findViewById(R.id.btn_start_job);
        mapView = (MapView) view.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        MapsInitializer.initialize(getActivity().getApplicationContext());
        /**
         * Setting up data from the job object to the views
         */
        txtJobDescTitle.setText(job.getJobTitle());
        txtJobDescModelNo.setText(job.getJobModelNumber());
        txtJobDescLocation.setText(job.getJobLocation());
        txtJobDescDescription.setText(job.getJobDescription());
        txtJobDescContact.setText(job.getJobContractNumber());
        txtJobDescCreatedOn.setText(job.getJobCreatedOn());
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                googleMap = map;

                LatLng kolkata = new LatLng(22.5726, 88.3639);
                googleMap.addMarker(new MarkerOptions().position(kolkata).title("Kolkata").snippet("Kolkata Location"));

                CameraPosition cameraPosition = new CameraPosition.Builder().target(kolkata).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
        btnStartJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                JobFormFragment jobFormFragment = new JobFormFragment();
                fragmentTransaction.replace(R.id.frame_layout, jobFormFragment, jobFormFragment.getTag())
                        .addToBackStack(jobFormFragment.getTag());
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
