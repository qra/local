package com.example.qrazy.qrazyapplication.viewbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qrazy.qrazyapplication.AppInfo;
import com.example.qrazy.qrazyapplication.R;

import me.drakeet.multitype.ItemViewBinder;

public class OneViewBinder extends ItemViewBinder<AppInfo,OneViewBinder.ViewHolder> {
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View inflate = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull AppInfo item) {
        holder.title.setText(item.appName);
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text1);
        }
    }
}
