package com.example.a3528315.menufac.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 3528315 on 09/04/19.
 */

public class DB {
    private static List<Plat> entrees;
    private static List<Plat> plats;
    private static List<Plat> desserts;
    private static List<Plat> boissons;
    private static List<Menu> menus;

    public static void initRestaurant() {
        entrees = new ArrayList<Plat>();
        plats = new ArrayList<Plat>();
        desserts = new ArrayList<Plat>();
        boissons = new ArrayList<Plat>();
        menus = new ArrayList<Menu>();

        Plat e1 = new Entree("Salade",5.0f);
        Plat e2 = new Entree("Soupe",7.0f);
        Plat e3 = new Entree("Fromage",4.0f);

        Plat p1 = new PlatPrincipal("Boeuf",12.0f);
        Plat p2 = new PlatPrincipal("Poulet",10.0f);
        Plat p3 = new PlatPrincipal("Poisson",11.0f);

        Plat d1 = new Dessert("Tarte",4.0f);
        Plat d2 = new Dessert("Gateau",3.0f);

        Plat b1 = new Boisson("Cola",3.0f);
        Plat b2 = new Boisson("Vin",7.0f);

        Menu m1 = new Menu("Menu Midi",16.0f,e1,p1,d1,b1);
        Menu m2 = new Menu("Menu Soir",19.0f,e2, p2, d2, b2);

        entrees.add(e1);
        entrees.add(e2);
        entrees.add(e3);

        plats.add(p1);
        plats.add(p2);
        plats.add(p3);

        desserts.add(d1);
        desserts.add(d2);

        boissons.add(b1);
        boissons.add(b2);

        menus.add(m1);
        menus.add(m2);
    }
    public List<Plat> getEntrees(){
        return entrees;
    }
    public List<Plat> getPlats(){
        return plats;
    }
    public List<Plat> getDesserts(){
        return desserts;
    }
    public List<Plat> getBoissons(){
        return boissons;
    }
    public List<Menu> getMenus(){
        return menus;
    }
}