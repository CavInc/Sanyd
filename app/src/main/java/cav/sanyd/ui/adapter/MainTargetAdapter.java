package cav.sanyd.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.List;

import cav.sanyd.R;
import cav.sanyd.data.models.TargetModel;

public class MainTargetAdapter extends ArrayAdapter<TargetModel> {

    private LayoutInflater mInflater;
    private int resLayout;

    public MainTargetAdapter(Context context, int resource, List<TargetModel> objects) {
        super(context, resource, objects);
        resLayout = resource;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View row = convertView;
        if (row == null) {
            row = mInflater.inflate(resLayout, parent, false);
            holder = new ViewHolder();
            holder.mTitle = (EditText) row.findViewById(R.id.item_title);
            holder.mQuantity = (EditText) row.findViewById(R.id.item_quantity);
            holder.mComment = (EditText) row.findViewById(R.id.item_comment);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }

        TargetModel record = getItem(position);
        holder.mTitle.setText(record.getTargetTitle());
        holder.mQuantity.setText(String.valueOf(record.getQuantity()));
        holder.mComment.setText(record.getComment());

        return row;
    }

    private class ViewHolder {
        public EditText mTitle;
        public EditText mQuantity;
        public EditText mComment;


    }

}