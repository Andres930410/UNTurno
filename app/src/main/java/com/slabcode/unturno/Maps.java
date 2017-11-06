package com.slabcode.unturno;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng unal = new LatLng(4.638310, -74.083749);
        for (Building i:Util.data.values()){
            LatLng temp = new LatLng(i.getLat(),i.getLng());
            Marker marker = mMap.addMarker(new MarkerOptions().position(temp).title(i.getName()).snippet(i.getNumber()));
            marker.setTag(i.getName());
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(unal,15));
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(Maps.this,Restaurant.class);
                intent.putExtra("RESTAURANT", marker.getTag().toString());
                startActivity(intent);
            }
        });
    }
}
