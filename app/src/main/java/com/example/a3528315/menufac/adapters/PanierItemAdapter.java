package com.example.a3528315.menufac.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3528315.menufac.R;
import com.example.a3528315.menufac.classes.CommandItem;
import com.example.a3528315.menufac.classes.DB;

import java.util.List;

public class PanierItemAdapter extends AbstractCommandItemAdapter {

    public PanierItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems) {
        super(context, commandItems);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull final ViewGroup parent) {
        final PanierViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.panier_plat, parent, false);
            viewHolder = new PanierViewHolder();
            viewHolder.namePlat = convertView.findViewById(R.id.itemPlat_name);

            viewHolder.minusBtn = convertView.findViewById(R.id.itemPlat_minus);
            viewHolder.minusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(parent.getContext())
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Confirm remove")
                            .setMessage("Are you sure you want to remove?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    DB.removeCommandItem(viewHolder.namePlat.getText().toString());
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("No", null)
                            .create()
                            .show();
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

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    private class PanierViewHolder {
        private TextView namePlat;
        private Button minusBtn;
    }
}
