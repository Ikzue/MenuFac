package com.example.a3528315.menufac.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 3528315 on 09/04/19.
 */

public class DB {
    private static List<CommandItem> entrees;
    private static List<CommandItem> plats;
    private static List<CommandItem> desserts;
    private static List<CommandItem> boissons;
    private static List<CommandItem> menus;
    public static List<CommandItem> table1;
    public static List<CommandItem> table2;
    public static List<CommandItem> table3;
    public static List<CommandItem> table4;
    public static List<CommandItem> table5;
    public static List<CommandItem> table6;
    public static List<CommandItem> table7;
    public static List<CommandItem> table8;
    public static List<CommandItem> table9;
    public static void initRestaurant() {
        entrees = new ArrayList<CommandItem>();
        plats = new ArrayList<CommandItem>();
        desserts = new ArrayList<CommandItem>();
        boissons = new ArrayList<CommandItem>();
        menus = new ArrayList<CommandItem>();
        table1 = new ArrayList<CommandItem>();
        table2 = new ArrayList<CommandItem>();
        table3 = new ArrayList<CommandItem>();
        table4 = new ArrayList<CommandItem>();
        table5 = new ArrayList<CommandItem>();
        table6 = new ArrayList<CommandItem>();
        table7 = new ArrayList<CommandItem>();
        table8 = new ArrayList<CommandItem>();
        table9 = new ArrayList<CommandItem>();

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
    public static List<CommandItem> getEntrees(){
        return entrees;
    }
    public static List<CommandItem> getPlats(){
        return plats;
    }
    public static List<CommandItem> getDesserts(){
        return desserts;
    }
    public static List<CommandItem> getBoissons(){
        return boissons;
    }
    public static List<CommandItem> getMenus(){
        return menus;
    }
}
