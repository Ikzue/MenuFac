package com.example.a3528315.menufac.commands;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a3528315.menufac.R;
import com.example.a3528315.menufac.classes.Boisson;
import com.example.a3528315.menufac.classes.CommandItem;
import com.example.a3528315.menufac.classes.DB;
import com.example.a3528315.menufac.classes.Dessert;
import com.example.a3528315.menufac.classes.Entree;
import com.example.a3528315.menufac.classes.Menu;
import com.example.a3528315.menufac.classes.Plat;
import com.example.a3528315.menufac.classes.PlatPrincipal;

import java.util.List;

public class CommandItemAdapter  extends ArrayAdapter<CommandItem> {
    private int table;

    public CommandItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems, int table) {
        super(context, 0, commandItems);
        this.table = table;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final PlatViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_plat, parent, false);
            viewHolder = new PlatViewHolder();
            viewHolder.namePlat = (TextView) convertView.findViewById(R.id.itemPlat_name);

            viewHolder.minusBtn = (Button) convertView.findViewById(R.id.itemPlat_minus);
            viewHolder.minusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nbPlats = Integer.valueOf(viewHolder.numberPlat.getText().toString());
                    if(nbPlats > 0) {
                        //removeItem(viewHolder.namePlat.getText().toString());
                        if(DB.removeCommandItem(viewHolder.namePlat.getText().toString()))
                            nbPlats -= 1;
                    }
                    viewHolder.numberPlat.setText(String.valueOf(nbPlats));
                }
            });

            viewHolder.numberPlat = (EditText) convertView.findViewById(R.id.itemPlat_number);

            viewHolder.plusBtn = (Button) convertView.findViewById(R.id.itemPlat_plus);
            viewHolder.plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nbPlats = Integer.valueOf(viewHolder.numberPlat.getText().toString());
                    //addItem(viewHolder.namePlat.getText().toString());
                    if(DB.addCommandItem(viewHolder.namePlat.getText().toString()))
                        nbPlats += 1;
                    viewHolder.numberPlat.setText(String.valueOf(nbPlats));
                }
            });

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PlatViewHolder) convertView.getTag();
        }

        CommandItem commandItem = getItem(position);

        if(commandItem != null) {
            viewHolder.namePlat.setText(commandItem.getNom());

            //TODO init nombre plats en fonction de la commande
            viewHolder.numberPlat.setText("0");
        }

        return convertView;
    }

    private class PlatViewHolder {
        private TextView namePlat;
        private Button minusBtn;
        private EditText numberPlat;
        private Button plusBtn;
    }
}
