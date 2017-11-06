package com.slabcode.unturno;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class RestaurtantInformationAdapter extends RecyclerView.Adapter<RestaurtantInformationAdapter.ViewHolder> {
    private List<String> days;
    private OnMenuClickListener onMenuClickListener;
    private RecyclerView.LayoutManager layoutManager;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView dayName;
        public TextView date;
        public LinearLayout linearLayout;

        public ViewHolder(View v){
            super(v);
            dayName = v.findViewById(R.id.menu_day);
            date = v.findViewById(R.id.menu_date);
            linearLayout = v.findViewById(R.id.menu_linear);
        }
    }

    public RestaurtantInformationAdapter(List<String> days, OnMenuClickListener onMenuClickListener){
        this.days = days;
        this.onMenuClickListener = onMenuClickListener;
    }

    @Override
    public RestaurtantInformationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);

        return new RestaurtantInformationAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RestaurtantInformationAdapter.ViewHolder holder, final int position) {
        holder.dayName.setText(days.get(position).split(" ")[0]);
        holder.date.setText(days.get(position).split(" ")[1]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMenuClickListener.onItemClick(days.get(position).split(" ")[0]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public interface OnMenuClickListener{
        void onItemClick(String c);

    }
}
