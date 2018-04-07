package com.example.suman.i_remotedemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suman.i_remotedemo.adapters.ItemAdapter;
import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Item;
import com.example.suman.i_remotedemo.listners.ACItemClickListner;

import java.util.ArrayList;
import java.util.List;

public class OnHandItemsFragment extends Fragment implements ACItemClickListner {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Item> items = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_hand_items, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.on_hand_tems_recycler_view);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
        populateData();
        return view;
    }

    private void populateData() {
        Item item = new Item();
        item.setItemName("Item 1");
        item.setItemCost(10);
        items.add(item);
        item = new Item();
        item.setItemName("Item 2");
        item.setItemCost(20);
        items.add(item);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void itemAdded(Item item, int countChange) {
        for (Item i: items) {
            if (i.equals(item)) {
                item.setItemCost(item.getItemCost()+countChange);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
