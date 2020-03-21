package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter_EmptySlot extends ArrayAdapter<DataModel_Slots> implements View.OnClickListener{
    private ArrayList<DataModel_Slots> dataSet;
    Context mContext;

    public DataAdapter_EmptySlot(ArrayList<DataModel_Slots> data, Context context) {
        super(context, R.layout.layoutemptyslot, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private static class ViewHolder {

        TextView slotid;
        TextView slotname;
        TextView status;

    }

    private int lastPosition = -1;

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        DataModel_Slots dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        DataAdapter_EmptySlot.ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;

        if (convertView == null) {
            viewHolder = new DataAdapter_EmptySlot.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.layoutemptyslot, parent, false);

            viewHolder.slotid = (TextView) convertView.findViewById(R.id.layout_empty_slot_id);
            viewHolder.slotname = (TextView) convertView.findViewById(R.id.layout_empty_slot_title);
            viewHolder.status = (TextView) convertView.findViewById(R.id.layout_empty_slot_title);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (DataAdapter_EmptySlot.ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;
        viewHolder.slotid.setText(dataModel.getId());
        viewHolder.slotname.setText(dataModel.getSlotNo());
        viewHolder.status.setText(dataModel.getSlotNo());
        // Return the completed view to render on screen
        return convertView;
    }
}
