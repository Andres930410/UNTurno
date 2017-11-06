package com.slabcode.unturno;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class TurnFragment extends Fragment {
    private RecyclerView recyclerView;
    private TurnAdapter turnAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> turns;

    public TurnFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choose_turn, container, false);
        setData();
        recyclerView = v.findViewById(R.id.turn_recycler);
        turnAdapter = new TurnAdapter(turns, new TurnAdapter.OnTurnClickListener() {
            @Override
            public void onItemClick(String c) {
                ((Restaurant)getActivity()).showTurn(c);
            }
        });
        recyclerView.setAdapter(turnAdapter);
        layoutManager =  new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        ((Restaurant)getActivity()).toolbar.setTitle("Turnos disponibles");


        return v;

    }

    private void setData(){
        turns = new ArrayList<>();
        turns.add("1A 11:15-11:25");
        turns.add("2A 11:25-11:35");
        turns.add("3A 11:35-11:45");
        turns.add("4A 11:45-11:55");
        turns.add("5A 11:55-12:05");
        turns.add("6A 12:05-12:15");
        turns.add("7A 12:15-12:25");
        turns.add("8A 12:25-12:35");
        turns.add("9A 12:35-12:45");
        turns.add("10A 12:45-12:55");
        turns.add("11A 12:55-13:05");
        turns.add("12A 13:05-13:15");
        turns.add("13A 13:15-13:25");
        turns.add("14A 13:25-13:35");
        turns.add("15A 13:35-13:45");
        turns.add("16A 13:45-13:55");
        turns.add("17A 13:55-14:05");
        turns.add("18A 14:05-14:15");
        turns.add("19A 14:15-14:25");
        turns.add("20A 14:25-14:35");
        turns.add("21A 14:35-14:45");
        turns.add("22A 14:45-14:45");
    }
}
