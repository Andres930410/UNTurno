package com.slabcode.unturno;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class MyTurnFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyTurnAdapter myTurnAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button newTurn;
    private List<String> myTurns;


    public MyTurnFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_turns, container, false);
        setData();
        recyclerView = v.findViewById(R.id.my_turns_recycler);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        myTurnAdapter =  new MyTurnAdapter(myTurns);
        recyclerView.setAdapter(myTurnAdapter);
        newTurn = v.findViewById(R.id.new_turn);
        newTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Restaurant)getActivity()).showRestaurants();
            }
        });
        ((Restaurant)getActivity()).toolbar.setTitle("My turnos");

        return  v;
    }
    private void setData(){
        myTurns =  new ArrayList<>();
        myTurns.add("Lunes 06.11.2017/1A 11:15-11:25/Crema de pollo/Frijoles/Arroz Blanco/Sin ensalada/Jugo de lulo/Bocadillo");
        myTurns.add("Miercoles 08.11.2017/1A 12:05-12:15/Crema de pollo/Goulash/Arroz de Coco/Ensalada rusa/Jugo de mora/Natilla");
    }
}
