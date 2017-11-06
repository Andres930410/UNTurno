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

public class MyTurnAdapter extends RecyclerView.Adapter<MyTurnAdapter.ViewHolder> {
    private List<String> myTurns;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView day;
        public TextView turn;
        public TextView entrada;
        public TextView principio;
        public TextView seco;
        public TextView ensalada;
        public TextView jugo;
        public TextView postre;

        public ViewHolder(View v){
            super(v);
            day = v.findViewById(R.id.information_day);
            turn = v.findViewById(R.id.information_turn);
            entrada = v.findViewById(R.id.information_entrada);
            principio = v.findViewById(R.id.information_principio);
            seco = v.findViewById(R.id.information_seco);
            ensalada = v.findViewById(R.id.information_ensalda);
            jugo = v.findViewById(R.id.information_jugo);
            postre = v.findViewById(R.id.information_postre);
        }
    }

    public MyTurnAdapter(List<String> myTurns){
        this.myTurns = myTurns;
    }

    @Override
    public MyTurnAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_turn_item, parent, false);

        return new MyTurnAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyTurnAdapter.ViewHolder holder, final int position) {
        String values[] = myTurns.get(position).split("/");
        holder.day.setText(values[0]);
        holder.turn.setText(values[1]);
        holder.entrada.setText(values[2]);
        holder.principio.setText(values[3]);
        holder.seco.setText(values[4]);
        holder.ensalada.setText(values[5]);
        holder.jugo.setText(values[6]);
        holder.postre.setText(values[7]);

    }

    @Override
    public int getItemCount() {
        return myTurns.size();
    }


}

