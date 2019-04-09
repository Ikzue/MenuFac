package com.example.a3528315.menufac.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 3528315 on 09/04/19.
 */

public class Commande {
    private int id;
    private List<Plat> listPlats;

    public Commande(int id){
        this(id, new ArrayList<Plat>());
    }

    public Commande(int id, List<Plat> p){
        this.id = id;
        this.listPlats = p;
    }

    public void addPlat(Plat p){
        listPlats.add(p);
    }

    public void addAllPlat(List<Plat> p){
        listPlats.addAll(p);
    }
}
