package com.example.a3528315.menufac.classes;

/**
 * Created by 3528315 on 09/04/19.
 */

public class Plat extends CommandItem {
    String nom;
    public Plat(String nom, float prix) {
        super(nom,prix);
        this.nom = nom;
    }
    public String toString(){
        return nom;
    }

}
