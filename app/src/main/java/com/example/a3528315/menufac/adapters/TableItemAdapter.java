package com.example.a3528315.menufac.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a3528315.menufac.R;
import com.example.a3528315.menufac.classes.CommandItem;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class TableItemAdapter extends AbstractCommandItemAdapter {

    public TableItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems) {
        super(context, commandItems);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final PlatViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.table_plat, parent, false);
            viewHolder = new PlatViewHolder();
            viewHolder.namePlat = convertView.findViewById(R.id.itemPlat_name);
            viewHolder.prixPlat = convertView.findViewById(R.id.itemPlat_prix);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PlatViewHolder) convertView.getTag();
        }

        CommandItem commandItem = getItem(position);

        if(commandItem != null) {
            viewHolder.namePlat.setText(commandItem.getNom());

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            viewHolder.prixPlat.setText(currencyFormat.format(commandItem.getPrix()));
        }

        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    /**
     * Voir table_item.xml
     */
    private class PlatViewHolder {
        private TextView namePlat;
        private TextView prixPlat;
    }
}
