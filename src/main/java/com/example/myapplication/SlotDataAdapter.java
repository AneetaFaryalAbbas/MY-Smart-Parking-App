package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SlotDataAdapter extends ArrayAdapter<Slot_DataModel> implements View.OnClickListener{
    private ArrayList<Slot_DataModel> dataSet;
    Context mContext;

    public SlotDataAdapter(ArrayList<Slot_DataModel> data, Context context) {
        super(context, R.layout.layoutslots, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private static class ViewHolder {

        TextView slotid;
        TextView slotDate;
        TextView slot_arrival_time;
        TextView slot_depart_time;
        TextView slot_sts;
        TextView slot_username;
        TextView slot_vechleNo;
    }

    private int lastPosition = -1;

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        Slot_DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.layoutslots, parent, false);

            viewHolder.slotid = (TextView) convertView.findViewById(R.id.layout_slotNo);
            viewHolder.slotDate = (TextView) convertView.findViewById(R.id.layout_date);
            viewHolder.slot_arrival_time = (TextView) convertView.findViewById(R.id.layout_arrialTime);
            viewHolder.slot_depart_time = (TextView) convertView.findViewById(R.id.layout_DeptrTime);
            viewHolder.slot_username = (TextView) convertView.findViewById(R.id.layout_username);
            viewHolder.slot_vechleNo = (TextView) convertView.findViewById(R.id.layout_vechleNo);
            viewHolder.slot_sts = (TextView) convertView.findViewById(R.id.layout_status);
            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;
        viewHolder.slotid.setText(dataModel.getId());
        viewHolder.slotDate.setText(dataModel.get_Date());
        viewHolder.slot_arrival_time.setText(dataModel.getArrival_time());
        viewHolder.slot_depart_time.setText(dataModel.getDepart_time());
        viewHolder.slot_vechleNo.setText(dataModel.getUsername());
        viewHolder.slot_username.setText(dataModel.getVechle_no());
        viewHolder.slot_sts.setText(dataModel.getStatus());
        // Return the completed view to render on screen
        return convertView;
    }
}
