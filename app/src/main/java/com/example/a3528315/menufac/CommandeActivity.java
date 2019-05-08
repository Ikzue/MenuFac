package com.example.a3528315.menufac;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.a3528315.menufac.classes.*;
import com.example.a3528315.menufac.commands.ActivityConstants;
import com.example.a3528315.menufac.commands.CommandItemAdapter;
import com.example.a3528315.menufac.commands.PanierItemAdapter;

import java.util.List;

public class CommandeActivity extends AppCompatActivity {
    private Context c;
    private ListView listePlats;
    private FloatingActionButton actionBtn;
    private int table;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private NavigationView.OnNavigationItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);
        table =  getIntent().getIntExtra("calling-activity",0);
        c = getBaseContext();

        DB.setTempCommand(DB.getTable(table));

        System.out.println(DB.getTempCommand().toString());

        drawerLayout = findViewById(R.id.drawer_layout);
        listener = new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                // close drawer when item is tapped
                drawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                List<CommandItem> items = null;
                String titre = "";
                Drawable actionIcon = getDrawable(R.drawable.ic_round_navigate_next_24px);
                boolean isPanier=false;

                switch (menuItem.getItemId()) {
                    default:
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
                        actionIcon = getDrawable(R.drawable.ic_round_shopping_cart_24px);
                        break;
                    case R.id.drawer_panier:
                        items = DB.getTempCommand();
                        titre = "Panier table " + Integer.toString(table);
                        actionIcon = getDrawable(R.drawable.ic_round_check_24px);
                        isPanier=true;
                        break;
                }

                if (items != null) {
                    ListAdapter adapter;
                    if(isPanier) {
                        adapter = new PanierItemAdapter(c, items, table);
                    } else {
                        adapter = new CommandItemAdapter(c, items, table);
                    }
                        listePlats.setAdapter(adapter);
                        EditText editText = findViewById(R.id.ActivityCommandeViewName);
                        editText.setText(titre);
                        actionBtn.setImageDrawable(actionIcon);
                }

                // For example, swap UI fragments here

                return true;
            }
        };
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(listener);

        listePlats = findViewById(R.id.ActivityCommandeListePlats);
        actionBtn = findViewById(R.id.ActivityCommandeActionBtn);

        MenuItem defaultItem = navigationView.getMenu().getItem(0);
        listener.onNavigationItemSelected(defaultItem);
        defaultItem.setChecked(true);


        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = getCheckedItem(navigationView);
                if (id>=0) {
                    switch (navigationView.getMenu().getItem(id).getItemId()) {
                        case R.id.drawer_entree:
                        case R.id.drawer_plat:
                        case R.id.drawer_dessert:
                        case R.id.drawer_boisson:
                        case R.id.drawer_menus:
                            MenuItem mItem = navigationView.getMenu().getItem(id+1);
                            listener.onNavigationItemSelected(mItem);
                            mItem.setChecked(true);
                            break;
                        case R.id.drawer_panier:
                            //TODO Valider modif en cours & return menu
                            DB.updateTable(table, DB.getTempCommand());
                            break;
                    }
                }
            }
        });

    }

    private int getCheckedItem(NavigationView navigationView) {
        Menu menu = navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.isChecked()) {
                return i;
            }
        }

        return -1;
    }
}