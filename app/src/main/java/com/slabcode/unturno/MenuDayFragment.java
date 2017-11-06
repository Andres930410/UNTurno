package com.slabcode.unturno;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class MenuDayFragment extends Fragment {
    private Button chooseTurn;
    public MenuDayFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu_day, container, false);
        chooseTurn = (Button) v.findViewById(R.id.choose_turn);
        chooseTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Restaurant)getActivity()).chooseTurn();
            }
        });
        final String day = getArguments().getString("day");
        ((Restaurant)getActivity()).toolbar.setTitle("Menu " + day);
        return v;
    }
}
