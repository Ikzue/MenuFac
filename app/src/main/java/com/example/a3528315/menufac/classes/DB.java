package com.example.a3528315.menufac.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 3528315 on 09/04/19.
 */

public class DB {
    private static List<CommandItem> entrees;
    private static List<CommandItem> plats;
    private static List<CommandItem> desserts;
    private static List<CommandItem> boissons;
    private static List<CommandItem> menus;

    private static Map<Integer, Commande> tables;

    private static List<CommandItem> tempCommand;

    public static void initRestaurant() {
        entrees = new ArrayList<CommandItem>();
        plats = new ArrayList<CommandItem>();
        desserts = new ArrayList<CommandItem>();
        boissons = new ArrayList<CommandItem>();
        menus = new ArrayList<CommandItem>();

        tables = new HashMap<Integer, Commande>();

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

        Menu m1 = new Menu("Menu Midi",16.0f, e1, p1, d1, b1);
        Menu m2 = new Menu("Menu Soir",19.0f, e2, p2, d2, b2);

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
    public static List<CommandItem> getTempCommand() {
        return tempCommand;
    }
    public static void setTempCommand() {
        setTempCommand(new ArrayList<CommandItem>());
    }
    public static void setTempCommand(List<CommandItem> command) {
        tempCommand = command;
    }

    public static boolean addCommandItem(String name) {
        for (CommandItem item : entrees) {
            if (item.getNom().equals(name)) {
                return tempCommand.add(item);
            }
        }
        for (CommandItem item : plats) {
            if (item.getNom().equals(name)) {
                return tempCommand.add(item);
            }
        }
        for (CommandItem item : desserts) {
            if (item.getNom().equals(name)) {
                return tempCommand.add(item);
            }
        }
        for (CommandItem item : boissons) {
            if (item.getNom().equals(name)) {
                return tempCommand.add(item);
            }
        }
        for (CommandItem item : menus) {
            if (item.getNom().equals(name)) {
                return tempCommand.add(item);
            }
        }
        return false;
    }

    public static boolean removeCommandItem(String name) {
        for(CommandItem item : tempCommand){
            if(item.getNom().equals(name)){
                return tempCommand.remove(item);
            }
        }
        return false;
    }

    public static Commande getTable(int table) {
        if(tables.containsKey(table))
            return tables.get(table);

        return null;
    }

    public static void updateTable(int table, List<CommandItem> commandItems) {
        List<CommandItem> command = new ArrayList<CommandItem>(commandItems);
        if(!tables.containsKey(table))
            tables.put(table, new Commande(commandItems));
        else
            tables.get(table).addAllPlat(command);
    }

    public static void clearTable(int table) {
        tables.remove(table);
    }
}
