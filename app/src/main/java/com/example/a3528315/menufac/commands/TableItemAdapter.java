package com.example.a3528315.menufac.commands;

import android.content.Context;
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
import com.example.a3528315.menufac.classes.DB;

import java.util.List;
import java.util.Locale;

public class TableItemAdapter extends ArrayAdapter<CommandItem> {
    private int table;

    public TableItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems, int table) {
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
            viewHolder.prixPlat = (TextView) convertView.findViewById(R.id.itemPlat_prix);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PlatViewHolder) convertView.getTag();
        }

        CommandItem commandItem = getItem(position);

        if(commandItem != null) {
            viewHolder.namePlat.setText(commandItem.getNom());
            viewHolder.prixPlat.setText(String.format(Locale.FRENCH,"%f €", commandItem.getPrix()));
        }

        return convertView;
    }

    private class PlatViewHolder {
        private TextView namePlat;
        private TextView prixPlat;
    }
}
