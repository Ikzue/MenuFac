package com.example.a3528315.menufac;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ListView;

import com.example.a3528315.menufac.classes.CommandItem;
import com.example.a3528315.menufac.classes.DB;
import com.example.a3528315.menufac.commands.ActivityConstants;
import com.example.a3528315.menufac.commands.CommandItemAdapter;
import com.example.a3528315.menufac.commands.TableItemAdapter;

import java.util.List;

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

        List<CommandItem> items = DB.getTable(table);
        String titre = String.format("Table %s", table);

        TableItemAdapter adapter = new TableItemAdapter(c, items, table);
        listePlats.setAdapter(adapter);
        EditText editText = findViewById(R.id.ActivityTableViewName);
        editText.setText(titre);

        actionAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, CommandeActivity.class);
                intent.putExtra("calling-activity", table);
                startActivity(intent);
            }
        });

        actionPaidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO empty table & return MainActivity
                System.out.println("TODO");
            }
        });
    }
}