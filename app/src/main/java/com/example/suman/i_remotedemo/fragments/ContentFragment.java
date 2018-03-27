package com.example.suman.i_remotedemo.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.test.DummyData;

import java.util.ArrayList;

/**
 * Created by Suman on 20-03-2018.
 */

public class ContentFragment extends Fragment {

    public static final String CONTEXT = "context";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<DummyData> dummyDataSet = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        /*TextView contentText = (TextView) rootView.findViewById(R.id.content_txt);
        contentText.setText("This is a Fragment text..!!");*/
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.hasFixedSize();
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CustomAdapter(dummyDataSet);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
        populateData();
        return rootView;
    }

    private void populateData() {
        DummyData dummyData = new DummyData();
        dummyData.setData1("Data1");
        dummyData.setData2("Data2");
        dummyDataSet.add(dummyData);
        dummyData = new DummyData();
        dummyData.setData1("DataAgain1");
        dummyData.setData2("DataAgain2");
        dummyDataSet.add(dummyData);
        mAdapter.notifyDataSetChanged();
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        private ArrayList<DummyData> mDummyData;

        public CustomAdapter(ArrayList<DummyData> dummyDataArrayList) {
            mDummyData = dummyDataArrayList;
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {

            public TextView data1, data2;

            public CustomViewHolder(View itemView) {
                super(itemView);
                data1 = (TextView) itemView.findViewById(R.id.data1);
                data2 = (TextView) itemView.findViewById(R.id.data2);
            }
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dummy_layout, parent, false);
            return new CustomViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            DummyData dummyData = mDummyData.get(position);
            holder.data1.setText(dummyData.getData1());
            holder.data2.setText(dummyData.getData2());
        }

        @Override
        public int getItemCount() {
            return mDummyData.size();
        }
    }
}
