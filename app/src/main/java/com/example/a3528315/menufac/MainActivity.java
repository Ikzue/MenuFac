package com.example.a3528315.menufac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a3528315.menufac.classes.DB;
import com.example.a3528315.menufac.commands.ActivityConstants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB.initRestaurant();
    }
    public void creerCommande1(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_1);
        startActivityForResult(intent,1);
    }
    public void creerCommande2(View view){
        Intent intent = new Intent(this, TableActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_2);
        startActivityForResult(intent,1);
    }
    public void creerCommande3(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_3);
        startActivityForResult(intent,1);
    }
    public void creerCommande4(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_4);
        startActivityForResult(intent,1);
    }
    public void creerCommande5(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_5);
        startActivityForResult(intent,1);
    }
    public void creerCommande6(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_6);
        startActivityForResult(intent,1);
    }
    public void creerCommande7(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_7);
        startActivityForResult(intent,1);
    }
    public void creerCommande8(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_8);
        startActivityForResult(intent,1);
    }
    public void creerCommande9(View view){
        Intent intent = new Intent(this, CommandeActivity.class );
        intent.putExtra("calling-activity", ActivityConstants.ACTIVITY_9);
        startActivityForResult(intent,1);
    }
}
