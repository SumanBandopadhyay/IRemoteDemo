package com.example.suman.i_remotedemo.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.suman.i_remotedemo.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobFormFragment extends Fragment implements View.OnClickListener {

    private EditText edtAttendedOn;

    private DatePickerDialog attendedOnDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    public JobFormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_form, container, false);
        edtAttendedOn = (EditText) view.findViewById(R.id.edtAttendedOn);
        edtAttendedOn.setInputType(InputType.TYPE_NULL);
        setDateTimeField();
        return view;
    }

    private void setDateTimeField() {
        edtAttendedOn.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        attendedOnDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                edtAttendedOn.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View view) {
        if(view == edtAttendedOn) {
            attendedOnDatePickerDialog.show();
        }
    }
}
