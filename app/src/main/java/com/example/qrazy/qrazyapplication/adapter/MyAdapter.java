package com.example.qrazy.qrazyapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qrazy.qrazyapplication.AppInfo;
import com.example.qrazy.qrazyapplication.R;

import java.util.ArrayList;
import java.util.List;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<AppInfo> mData;
    private Context mContext;

    public List<AppInfo> getData() {
        if (mData == null) {
            return new ArrayList<>();
        }
        return mData;
    }

    public void setData(List<AppInfo> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.title.setText(mData.get(position).appName);

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1);
        }
    }
}
