package com.example.suman.i_remotedemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suman.i_remotedemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobFormFragment extends Fragment {


    public JobFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job_form, container, false);
    }

}
