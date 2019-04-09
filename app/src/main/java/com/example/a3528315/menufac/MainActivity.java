package com.example.a3528315.menufac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void creerCommande(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        startActivityForResult(intent,1);
    }
}
