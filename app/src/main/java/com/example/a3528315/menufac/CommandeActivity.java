package com.example.a3528315.menufac;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import com.example.a3528315.menufac.classes.*;
import com.example.a3528315.menufac.commands.CommandItemAdapter;

import java.util.List;

public class CommandeActivity extends AppCompatActivity {
    private Context c;
    private ListView listePlats;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);

        c = getBaseContext();

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
                        List<CommandItem> items = null;
                        switch (menuItem.getItemId()) {
                            case R.id.drawer_entree:
                                items = DB.getEntrees();
                                break;

                            case R.id.drawer_plat:
                                items = DB.getPlats();
                                break;

                            case R.id.drawer_dessert:
                                items = DB.getDesserts();
                                break;

                            /*case R.id.drawer_boisson:
                                items = DB.getEntrees();
                                break;*/


                        }

                        if (items != null) {
                            CommandItemAdapter adapter = new CommandItemAdapter(c, items);
                            listePlats.setAdapter(adapter);
                        }


                        // For example, swap UI fragments here

                        return true;
                    }
                });

        listePlats = findViewById(R.id.ActivityCommandeListePlats);

        //TODO lequel est défaut ?
        CommandItemAdapter adapter = new CommandItemAdapter(c, DB.getPlats());
        listePlats.setAdapter(adapter);

    }

    /*
    public void incrementer(View v){
        String s = (String) v.getTag().toString();
        int id = getResources().getIdentifier(s,"id", getApplicationContext().getPackageName());
        EditText editNumero = (EditText) findViewById(id);
        int nbPlats = Integer.valueOf(editNumero.getText().toString());
        nbPlats += 1;
        editNumero.setText(String.valueOf(nbPlats));
    }

    public void decrementer(View v){
        String s = (String) v.getTag().toString();
        int id = getResources().getIdentifier(s,"id", getApplicationContext().getPackageName());
        EditText editNumero = (EditText) findViewById(id);
        int nbPlats = Integer.valueOf(editNumero.getText().toString());
        if(nbPlats > 0)
            nbPlats -= 1;
        editNumero.setText(String.valueOf(nbPlats));
    }
    */
}