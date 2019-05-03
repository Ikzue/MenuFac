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
import com.example.a3528315.menufac.commands.ActivityConstants;
import com.example.a3528315.menufac.commands.CommandItemAdapter;

import java.util.List;

public class CommandeActivity extends AppCompatActivity {
    private Context c;
    private ListView listePlats;
    private int table;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        table =  getIntent().getIntExtra("calling-activity",0);
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
                        String titre = "";
                        switch (menuItem.getItemId()) {
                            case R.id.drawer_entree:
                                items = DB.getEntrees();
                                titre = "Entrees";
                                break;

                            case R.id.drawer_plat:
                                items = DB.getPlats();
                                titre = "Plats";
                                break;

                            case R.id.drawer_dessert:
                                items = DB.getDesserts();
                                titre = "Desserts";
                                break;
                            case R.id.drawer_boisson:
                                items = DB.getBoissons();
                                titre = "Boissons";
                                break;
                            case R.id.drawer_menus:
                                items = DB.getMenus();
                                titre = "Menus";
                                break;
                            case R.id.drawer_panier:
                                items = getTableActuelle();
                                titre = "Panier table "+Integer.toString(table);
                                break;



                        }

                        if (items != null) {
                            CommandItemAdapter adapter = new CommandItemAdapter(c, items,table);
                            listePlats.setAdapter(adapter);
                            EditText editText = findViewById(R.id.editText);
                            editText.setText(titre);
                        }


                        // For example, swap UI fragments here

                        return true;
                    }
                });

        listePlats = findViewById(R.id.ActivityCommandeListePlats);

        //TODO lequel est défaut ?
        CommandItemAdapter adapter = new CommandItemAdapter(c, DB.getPlats(), table);
        listePlats.setAdapter(adapter);

    }

    public List<CommandItem> getTableActuelle() {
        List<CommandItem> list = null;
        switch(table) {
            case ActivityConstants.ACTIVITY_1:
                list = DB.table1;
                break;
            case ActivityConstants.ACTIVITY_2:
                list = DB.table2;
                break;
            case ActivityConstants.ACTIVITY_3:
                list = DB.table3;
                break;
            case ActivityConstants.ACTIVITY_4:
                list = DB.table4;
                break;
            case ActivityConstants.ACTIVITY_5:
                list = DB.table5;
                break;
            case ActivityConstants.ACTIVITY_6:
                list = DB.table6;
                break;
            case ActivityConstants.ACTIVITY_7:
                list = DB.table7;
                break;
            case ActivityConstants.ACTIVITY_8:
                list = DB.table8;
                break;
            case ActivityConstants.ACTIVITY_9:
                list = DB.table9;
                break;
        }
        return list;
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