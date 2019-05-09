package com.example.a3528315.menufac;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Space;

import com.example.a3528315.menufac.classes.DB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB.initRestaurant();
        Integer[][] restaurant = DB.getRestaurantMap();

        GridLayout grid = findViewById(R.id.ActivityMainGrid);
        grid.setRowCount(restaurant.length);
        grid.setColumnCount(restaurant[0].length);

        for (int i = 0; i < restaurant.length; i++) {
            for (int j = 0; j < restaurant[i].length; j++) {
                View view;
                if (restaurant[i][j] > 0) {
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
                } else {
                    if (restaurant[i][j] == -1) {
                        view = new View(this);
                        view.setBackgroundColor(Color.BLACK);
                    } else {
                        view = new Space(this);
                    }
                }

                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = 0;
                params.height = 0;
                params.setGravity(Gravity.FILL);
                params.rowSpec = GridLayout.spec(i, 1, 1);
                params.columnSpec = GridLayout.spec(j, 1, 1);

                view.setLayoutParams(params);

                grid.addView(view);
            }
        }
    }
}
