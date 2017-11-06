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

public class TurnAdapter extends RecyclerView.Adapter<TurnAdapter.ViewHolder> {
    private List<String > turns;
    private OnTurnClickListener onTurnClickListener;

    public TurnAdapter(List<String> turns, OnTurnClickListener onTurnClickListener) {
        this.turns = turns;
        this.onTurnClickListener = onTurnClickListener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView turnNumber;
        public TextView turnTime;
        public LinearLayout linearLayout;

        public ViewHolder(View v){
            super(v);
            turnNumber = v.findViewById(R.id.turn_number);
            turnTime = v.findViewById(R.id.turn_time);
            linearLayout = v.findViewById(R.id.turn_linear);
        }
    }

    @Override
    public TurnAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.turn_item, parent, false);

        return new TurnAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TurnAdapter.ViewHolder holder, final int position) {
        holder.turnNumber.setText(turns.get(position).split(" ")[0]);
        holder.turnTime.setText(turns.get(position).split(" ")[1]);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTurnClickListener.onItemClick(turns.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return turns.size();
    }

    public interface OnTurnClickListener{
        void onItemClick(String c);
    }
}
