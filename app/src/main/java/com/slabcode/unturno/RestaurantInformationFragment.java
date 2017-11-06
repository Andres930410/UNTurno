package com.slabcode.unturno;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class RestaurantInformationFragment extends Fragment {

    private FloatingActionButton map;
    private RecyclerView recyclerView;
    private RestaurtantInformationAdapter restaurtantInformationAdapter;
    private List<String> days;
    private TextView building;
    private RecyclerView.LayoutManager layoutManager;


    public RestaurantInformationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_restaurant_information, container, false);
        final String name = getArguments().getString("value");
        map = (FloatingActionButton) v.findViewById(R.id.show_map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Restaurant)getActivity()).showMap(Util.data.get(name).getLat(),Util.data.get(name).getLng());
            }
        });
        setData();
        recyclerView = (RecyclerView) v.findViewById(R.id.menu_recycler);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        restaurtantInformationAdapter = new RestaurtantInformationAdapter(days, new RestaurtantInformationAdapter.OnMenuClickListener() {
            @Override
            public void onItemClick(String c) {
                ((Restaurant)getActivity()).showMenu(c);

            }
        });
        recyclerView.setAdapter(restaurtantInformationAdapter);
        recyclerView.setLayoutManager(layoutManager);

        building = (TextView) v.findViewById(R.id.building_name);
        ((Restaurant)getActivity()).toolbar.setTitle("Comedor " + name);
        building.setText(Util.data.get(name).getNumber());
        return v;
    }

    private void setData(){
        days = new ArrayList<>();
        days.add("Lunes 06/11/2017");
        days.add("Martes 07/11/2017");
        days.add("Miercoles 08/11/2017");
        days.add("Jueves 09/11/2017");
        days.add("Viernes 10/11/2017");
        days.add("Lunes 13/11/2017");
        days.add("Martes 14/11/2017");
        days.add("Miercoles 15/11/2017");
        days.add("Jueves 16/11/2017");
        days.add("Viernes 17/11/2017");

    }
}
