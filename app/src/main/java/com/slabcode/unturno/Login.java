package com.slabcode.unturno;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private Button login;
    private Button forget;
    private Button about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login_button);
        forget = (Button) findViewById(R.id.forget_button);
        about = (Button) findViewById(R.id.about_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Restaurant.class);
                startActivity(intent);
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Forget.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, About.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void init(){
        Util.data.put("Agronomia", new Building("Agronomia","Edificio 500",4.635872, -74.087161));
        Util.data.put("Biologia", new Building("Biologia","Edificio 421",4.640441, -74.081912));
        Util.data.put("Campus",new Building("Campus","Edificio 103",4.635367,-74.083066));
        Util.data.put("Economia",new Building("Economia","Edificio 310",4.636911,-74.080739));
        Util.data.put("Hemeroteca", new Building("Hemeroteca","Edificio 571",4.636627,-74.090592));
        Util.data.put("Humanas",new Building("Humanas","Edificio 212",4.634016,-74.084722));
        Util.data.put("Matematicas", new Building("Matematicas","Edificio 404",4.637635,-74.082593));
        Util.data.put("Odontologia", new Building("Odontologia","Edificion 202",4.634578,-74.085369));
    }
}
