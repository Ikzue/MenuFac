package com.example.a3528315.menufac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a3528315.menufac.classes.DB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB.initRestaurant();
    }
    public void creerCommande(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        startActivityForResult(intent,1);
    }
}
