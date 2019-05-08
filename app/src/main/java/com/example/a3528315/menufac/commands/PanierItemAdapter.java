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

public class PanierItemAdapter extends ArrayAdapter<CommandItem> {
    private int table;

    public PanierItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems, int table) {
        super(context, 0, commandItems);
        this.table = table;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final PanierViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.panier_plat, parent, false);
            viewHolder = new PanierViewHolder();
            viewHolder.namePlat = (TextView) convertView.findViewById(R.id.itemPlat_name);

            viewHolder.minusBtn = (Button) convertView.findViewById(R.id.itemPlat_minus);
            viewHolder.minusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DB.removeCommandItem(viewHolder.namePlat.getText().toString());
                }
            });

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PanierViewHolder) convertView.getTag();
        }

        CommandItem commandItem = getItem(position);

        if(commandItem != null) {
            viewHolder.namePlat.setText(commandItem.getNom());
        }

        return convertView;
    }

    private class PanierViewHolder {
        private TextView namePlat;
        private Button minusBtn;

    }
}
