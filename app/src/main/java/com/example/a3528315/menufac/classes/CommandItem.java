package com.example.a3528315.menufac.classes;

public class CommandItem {
    private String nom;
    private float prix;


    public CommandItem(String nom, float prix) {
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
