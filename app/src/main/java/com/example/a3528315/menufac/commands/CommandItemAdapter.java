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
    public CommandItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems,int table) {
        super(context, 0, commandItems);
        this.table = table;
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
                    if(nbPlats > 0) {
                        nbPlats -= 1;
                        removeItem(viewHolder.namePlat.getText().toString());
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
                    nbPlats += 1;
                    viewHolder.numberPlat.setText(String.valueOf(nbPlats));
                    addItem(viewHolder.namePlat.getText().toString());
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
    private void addItem(String nameplat){
        //System.out.println(nameplat);
        CommandItem p = createItem(nameplat);
        addPlatTableActuelle(p);
    }
    private void removeItem(String nameplat){
        List<CommandItem> commandeActuelle = getTableActuelle();
        for(CommandItem item:commandeActuelle){
            if(nameplat.equals(item.toString())){
                commandeActuelle.remove(item);
                break;
            }
        }
    }
    public void addPlatTableActuelle(CommandItem p) {
        List<CommandItem> commandeActuelle = getTableActuelle();
        commandeActuelle.add(p);
    }
    public CommandItem createItem(String nameplat){
        CommandItem p = null;
        switch(nameplat){
            case "Salade" : p = new Plat("Salade",5.0f);break;
            case "Soupe" : p =  new Plat("Soupe",7.0f);break;
            case "Fromage" : p =  new Plat("Fromage",4.0f);break;

            case "Boeuf" : p =  new Plat("Boeuf",12.0f);break;
            case "Poulet" : p = new Plat("Poulet",10.0f);break;
            case "Poisson" : p = new Plat("Poisson",11.0f);break;

            case "Tarte" : p = new Plat("Tarte",4.0f);break;
            case "Gateau" : p = new Plat("Gateau",3.0f);break;

            case "Cola" : p = new Plat("Cola",3.0f);break;
            case "Vin" : p =  new Plat("Vin",7.0f);break;

            case "Menu Midi" :
                Plat e1 = new Entree("Salade",5.0f);
                Plat p1 = new PlatPrincipal("Boeuf",12.0f);
                Plat d1 = new Dessert("Tarte",4.0f);
                Plat b1 = new Boisson("Cola",3.0f);
                p = new Menu("Menu Midi",16.0f,e1,p1,d1,b1);
            case "Menu Soir" :
                Plat e2 = new Entree("Soupe",7.0f);
                Plat p2 = new PlatPrincipal("Poulet",10.0f);
                Plat d2 = new Dessert("Gateau",3.0f);
                Plat b2 = new Boisson("Vin",7.0f);
                p =  new Menu("Menu Soir",19.0f,e2, p2, d2, b2);
        }
        return p;
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
    private class PlatViewHolder {
        public TextView namePlat;
        public Button minusBtn;
        public EditText numberPlat;
        public Button plusBtn;
    }
}
