package com.example.a3528315.menufac.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 3528315 on 09/04/19.
 */

public class Commande {
    private static int count = 0;
    private int id;
    private List<CommandItem> listPlats;

    public Commande(){
        this(new ArrayList<CommandItem>());
    }

    public Commande(List<CommandItem> p){
        this.id = ++count;
        this.listPlats = p;
    }

    public void addPlat(CommandItem p){
        listPlats.add(p);
    }

    public void addAllPlat(List<CommandItem> p){
        listPlats.addAll(p);
    }

    public List<CommandItem> getListPlats() {
        return listPlats;
    }

    @Override
    public String toString() {
        return "Commande#"+id;
    }
}
