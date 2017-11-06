package com.slabcode.unturno;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Restaurant extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public  Toolbar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_mapa:
                    Intent intent1 = new Intent(Restaurant.this,Maps.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_about:
                    Intent intent = new Intent(Restaurant.this,About.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new RestaurantFragment(),"RESTAURANTS").commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(getIntent().getExtras() != null){
            if(getIntent().getExtras().containsKey("RESTAURANT")){
                String name = getIntent().getExtras().getString("RESTAURANT");
                showInformation(name);

            }
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void showInformation(String c){
        RestaurantInformationFragment v = new RestaurantInformationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("value",c);
        v.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,v,"INFORMATION");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showMap(Double lat, Double lng){
        Uri gmmIntentUri = Uri.parse("google.navigation:q="+lat+","+lng);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void showMenu(String c){
        MenuDayFragment v = new MenuDayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("day",c);
        v.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,v,"INFORMATION");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showTurn(String c){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,new SaveTurnFragment(),"INFORMATION");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void chooseTurn(){
        TurnFragment v = new TurnFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,v,"INFORMATION");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_log_out) {
            Intent intent = new Intent(Restaurant.this,Login.class);
            startActivity(intent);
        }else if(id == R.id.nav_comedores){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container,new RestaurantFragment(),"RESTAURANTS");
            transaction.addToBackStack(null);
            transaction.commit();
        }else if (id == R.id.nav_mapa){
            Intent intent1 = new Intent(Restaurant.this,Maps.class);
            startActivity(intent1);
        }else if (id == R.id.nav_mis_turnos){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container,new MyTurnFragment(),"MYTURNS");
            transaction.addToBackStack(null);
            transaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showRestaurants() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,new RestaurantFragment(),"RESTAURANTS");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
