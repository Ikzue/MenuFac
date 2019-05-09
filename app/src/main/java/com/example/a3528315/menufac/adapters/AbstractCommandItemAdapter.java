package com.example.a3528315.menufac.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.a3528315.menufac.classes.CommandItem;

import java.util.List;

public abstract class AbstractCommandItemAdapter extends ArrayAdapter<CommandItem> implements ListAdapter {

    AbstractCommandItemAdapter(@NonNull Context context, @NonNull List<CommandItem> commandItems) {
        super(context, 0, commandItems);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
