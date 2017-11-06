package com.slabcode.unturno;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class SaveTurnFragment extends Fragment {

    private Button save;
    public SaveTurnFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_save_turn, container, false);
        save = v.findViewById(R.id.save_turn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Restaurant)getActivity()).showRestaurants();

            }
        });
        return v;
    }
}
