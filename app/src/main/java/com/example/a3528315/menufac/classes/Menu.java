package com.example.a3528315.menufac.classes;

/**
 * Created by 3528315 on 09/04/19.
 */

public class Menu extends CommandItem {
    private Plat entree;
    private Plat plat;
    private Plat dessert;
    private Plat boisson;

    Menu(String nom, float prix, Plat entree, Plat plat, Plat dessert, Plat boisson){
        super(nom,prix);
        this.entree = entree;
        this.plat = plat;
        this.dessert = dessert;
        this.boisson = boisson;
    }
}
