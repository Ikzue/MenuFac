package com.example.a3528315.menufac;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.a3528315.menufac.adapters.TableItemAdapter;
import com.example.a3528315.menufac.classes.Commande;
import com.example.a3528315.menufac.classes.DB;

/**
 * Activité Table
 * Affiche l'ensemble de la commande validée pour la table
 */
public class TableActivity extends AppCompatActivity {
    private Context c;
    private ListView listePlats;
    private FloatingActionButton actionAddBtn;
    private FloatingActionButton actionPaidBtn;
    private int table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        table = getIntent().getIntExtra("calling-activity",0);
        c = getBaseContext();

        listePlats = findViewById(R.id.ActivityTableListePlats);
        actionAddBtn = findViewById(R.id.ActivityTableActionAddBtn);
        actionPaidBtn = findViewById(R.id.ActivityTableActionPaidBtn);

        // Cliquer sur le bouton, envoie vers la création de commande (ou ajout)
        actionAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, CommandeActivity.class);
                intent.putExtra("calling-activity", table);
                startActivity(intent);
            }
        });

        // Vider la commande d'une table et retourner à l'accueil (libérer la table car les clients ont payés ou sont partis)
        actionPaidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(TableActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Confirm table clear")
                        .setMessage("Are you sure you want to clear this command?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DB.clearTable(table);
                                Intent i = new Intent(TableActivity.this, MainActivity.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                            }
                        })
                        .setNegativeButton("No", null)
                        .create()
                        .show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Commande ctable = DB.getTable(table);
        String titre = String.format("Table %s", table);

        if (ctable != null) {
            // Charger la liste des plats commandés
            TableItemAdapter adapter = new TableItemAdapter(c, ctable.getListPlats());
            listePlats.setAdapter(adapter);
        } else {
            // Si il n'y a pas de commande, aller directement en création
            actionAddBtn.performClick();
        }
        EditText editText = findViewById(R.id.ActivityTableViewName);
        editText.setText(titre);
    }
}