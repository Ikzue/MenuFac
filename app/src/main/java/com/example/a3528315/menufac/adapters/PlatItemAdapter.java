package com.example.a3528315.menufac.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a3528315.menufac.R;
import com.example.a3528315.menufac.classes.CommandItem;
import com.example.a3528315.menufac.classes.DB;

import java.util.List;
import java.util.Locale;

public class PlatItemAdapter extends AbstractCommandItemAdapter {

    public PlatItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems) {
        super(context, commandItems);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final PlatViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_plat, parent, false);
            viewHolder = new PlatViewHolder();
            viewHolder.namePlat = convertView.findViewById(R.id.itemPlat_name);

            viewHolder.minusBtn = convertView.findViewById(R.id.itemPlat_minus);
            viewHolder.minusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nbPlats = Integer.valueOf(viewHolder.numberPlat.getText().toString());
                    if(nbPlats > 0) {
                        if(DB.removeCommandItem(viewHolder.namePlat.getText().toString()))
                            nbPlats -= 1;
                    }
                    viewHolder.numberPlat.setText(String.valueOf(nbPlats));
                }
            });

            viewHolder.numberPlat = convertView.findViewById(R.id.itemPlat_number);

            viewHolder.plusBtn = convertView.findViewById(R.id.itemPlat_plus);
            viewHolder.plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nbPlats = Integer.valueOf(viewHolder.numberPlat.getText().toString());
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
            int cpt = 0, i;
            List<CommandItem> listed = DB.getTempCommand();

            for( i=0; i< listed.size();i++) {
                if (listed.get(i).getNom().equals((commandItem.getNom()))) {
                    cpt++;
                }
            }

            viewHolder.numberPlat.setText(String.format(Locale.getDefault(), "%d", cpt));
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
