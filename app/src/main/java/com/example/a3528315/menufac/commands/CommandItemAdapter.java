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
import com.example.a3528315.menufac.classes.CommandItem;

import java.util.List;

public class CommandItemAdapter  extends ArrayAdapter<CommandItem> {

    public CommandItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems) {
        super(context, 0, commandItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
                    if(nbPlats > 0)
                        nbPlats -= 1;
                    viewHolder.numberPlat.setText(String.valueOf(nbPlats));

                    //TODO modif objet commande
                }
            });

            viewHolder.numberPlat = (EditText) convertView.findViewById(R.id.itemPlat_number);

            viewHolder.plusBtn = (Button) convertView.findViewById(R.id.itemPlat_plus);
            viewHolder.plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nbPlats = Integer.valueOf(viewHolder.numberPlat.getText().toString());
                    nbPlats += 1;
                    viewHolder.numberPlat.setText(String.valueOf(nbPlats));

                    //TODO modif objet commande
                }
            });

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PlatViewHolder) convertView.getTag();
        }

        CommandItem commandItem = getItem(position);

        viewHolder.namePlat.setText(commandItem.getNom());

        //TODO init nombre plats en fonction de la commande
        viewHolder.numberPlat.setText("0");

        /*
        switch (level){
            case 0:
                viewHolder.Score.setText(String.valueOf(playerScore.getEasyScore()));
                break;
            case 1:
                viewHolder.Score.setText(String.valueOf(playerScore.getMediumScore()));
                break;
            case 2:
                viewHolder.Score.setText(String.valueOf(playerScore.getDifficultScore()));
                break;
        }
        */

        return convertView;
    }

    private class PlatViewHolder {
        public TextView namePlat;
        public Button minusBtn;
        public EditText numberPlat;
        public Button plusBtn;
    }
}
