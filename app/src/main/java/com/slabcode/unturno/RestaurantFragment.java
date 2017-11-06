package com.slabcode.unturno;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class RestaurantFragment extends Fragment {

    private RecyclerView recyclerView;
    private RestaurantAdapater restaurantAdapater;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> restaurants;

    public RestaurantFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frgament_restaurant, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.restaurant_recycler);
        setData();
        restaurantAdapater = new RestaurantAdapater(restaurants, new RestaurantAdapater.OnRestaurantClickListener() {
            @Override
            public void onItemClick(String c) {
                ((Restaurant)getActivity()).showInformation(c);
            }
        });
        ((Restaurant)getActivity()).toolbar.setTitle(R.string.title_activity_restaurant);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(restaurantAdapater);
        return v;
    }

    public void setData(){
        restaurants = new ArrayList<>();
        restaurants.add("Agronomia");
        restaurants.add("Biologia");
        restaurants.add("Campus");
        restaurants.add("Economia");
        restaurants.add("Hemeroteca");
        restaurants.add("Humanas");
        restaurants.add("Matematicas");
        restaurants.add("Odontologia");
    }
}