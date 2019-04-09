package com.example.a3528315.menufac;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class CommandeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);



        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }
    public void incrementer(View sender){
        String s = (String) sender.getTag().toString();
        int id = getResources().getIdentifier(s,"id", getApplicationContext().getPackageName());
        EditText editNumero = (EditText) findViewById(id);
        int nbPlats = Integer.valueOf(editNumero.getText().toString());
        nbPlats += 1;
        editNumero.setText(String.valueOf(nbPlats));
    }
    public void decrementer(View sender){
        String s = (String) sender.getTag().toString();
        int id = getResources().getIdentifier(s,"id", getApplicationContext().getPackageName());
        EditText editNumero = (EditText) findViewById(id);
        int nbPlats = Integer.valueOf(editNumero.getText().toString());
        if(nbPlats > 0)
            nbPlats -= 1;
        editNumero.setText(String.valueOf(nbPlats));
    }
}