package com.example.a3528315.menufac;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Space;

import com.example.a3528315.menufac.classes.Commande;
import com.example.a3528315.menufac.classes.DB;

/**
 * Activité principale
 * Affiche la carte du restaurant, un bouton par table
 */
public class MainActivity extends AppCompatActivity {
    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB.initRestaurant();
        /* La carte du restaurant est une matrice d'entiers
        -1 : zone inaccessible
        0 : vide/couloir
        i>0 : table numéro i
         */
        Integer[][] restaurant = DB.getRestaurantMap();

        grid = findViewById(R.id.ActivityMainGrid);
        grid.setRowCount(restaurant.length);
        grid.setColumnCount(restaurant[0].length);

        for (int i = 0; i < restaurant.length; i++) {
            for (int j = 0; j < restaurant[i].length; j++) {
                View view;
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();

                if (restaurant[i][j] > 0) {
                    // Une table → bouton
                    view = new Button(this);
                    int table = restaurant[i][j];

                    ((Button) view).setText(String.format("T %s",table));
                    view.setId(table);
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, TableActivity.class );
                            intent.putExtra("calling-activity", v.getId());
                            startActivity(intent);
                        }
                    });

                    // Si la table a une commande (signaler occupée)
                    Commande ctable = DB.getTable(table);
                    if (ctable!=null)
                        ((Button) view).setTextColor(Color.RED);
                } else {
                    if (restaurant[i][j] == -1) {
                        // Espace inaccessible → noir
                        view = new View(this);
                        view.setBackgroundColor(Color.BLACK);
                    } else {
                        // Espace vide
                        view = new Space(this);
                    }
                }

                // Les éléments n'ont pas de taille fixés mais prennent toute la place accordé par GridLayout
                params.width = 0;
                params.height = 0;
                params.setGravity(Gravity.FILL);

                // Chaque élément en position i,j occupe une seule case (chaque colonne/ligne a le même poids, donc la même taille)
                params.rowSpec = GridLayout.spec(i, 1, 1);
                params.columnSpec = GridLayout.spec(j, 1, 1);

                view.setLayoutParams(params);

                grid.addView(view);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        for (View v: grid.getTouchables()) {
            if (v instanceof Button) {
                Commande ctable = DB.getTable(v.getId());
                if (ctable!=null)
                    ((Button) v).setTextColor(Color.RED);
            }
        }
    }
}
