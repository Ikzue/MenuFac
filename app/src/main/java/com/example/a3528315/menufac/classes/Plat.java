package com.example.a3528315.menufac.classes;

/**
 * Created by 3528315 on 09/04/19.
 */

public class Plat {
    private String nom;
    private float prix;

    Plat(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }
    public float getPrix(){
        return prix;
    }

}
