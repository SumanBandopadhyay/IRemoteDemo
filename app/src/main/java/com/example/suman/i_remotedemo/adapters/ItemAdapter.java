package com.example.suman.i_remotedemo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suman.i_remotedemo.R;
import com.example.suman.i_remotedemo.entity.Item;

import java.util.List;

/**
 * Created by Suman on 28-03-2018.
 */

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.ItemViewAdapter> {

    private List<Item> items;

    public ItemAdapter (List<Item> items) {
        this.items = items;
    }

    @Override
    public ItemViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(ItemViewAdapter holder, int position) {
        Item item = items.get(position);
        holder.txtItemName.setText(item.getItemName());
        holder.txtItemPrice.setText(item.getItemCost()+"");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewAdapter extends RecyclerView.ViewHolder {

        TextView txtItemName;
        TextView txtItemPrice;

        public ItemViewAdapter(View itemView) {
            super(itemView);
            txtItemName = (TextView) itemView.findViewById(R.id.item_name);
            txtItemPrice = (TextView) itemView.findViewById(R.id.item_price);
        }
    }

}
