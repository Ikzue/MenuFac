package com.example.a3528315.menufac.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 3528315 on 09/04/19.
 */

public class DB {
    private static boolean isInit = false;
    private static List<CommandItem> entrees;
    private static List<CommandItem> plats;
    private static List<CommandItem> desserts;
    private static List<CommandItem> boissons;
    private static List<CommandItem> menus;

    private static Integer[][] restaurantMap;
    private static Map<Integer, Commande> tables;

    private static List<CommandItem> tempCommand;

    public static void initRestaurant() {
        initRestaurant(false);
    }

    public static void initRestaurant(boolean force) {
        if (!isInit || force) {
            entrees = new ArrayList<CommandItem>();
            plats = new ArrayList<CommandItem>();
            desserts = new ArrayList<CommandItem>();
            boissons = new ArrayList<CommandItem>();
            menus = new ArrayList<CommandItem>();

            tables = new HashMap<Integer, Commande>();

            restaurantMap = new Integer[][]{
                    {1, 2, 3, 0, 13, -1},
                    {5, 4, 6, 0, 14, -1},
                    {7, 8, 9, 0, 15, -1},
                    {10, 11, 12, 0, 0, 0},
                    {0, 0, 0, 0, 16, 17},
                    {22, 23, 0, 0, 18, 19},
                    {24, 25, 0, 0, 20, 21},
                    {26, 27, 0, 0, 0, 0},
            };

            Plat e1 = new Entree("Salade", 5.0f);
            Plat e2 = new Entree("Soupe", 7.0f);
            Plat e3 = new Entree("Fromage", 4.0f);

            Plat p1 = new PlatPrincipal("Boeuf", 12.0f);
            Plat p2 = new PlatPrincipal("Poulet", 10.0f);
            Plat p3 = new PlatPrincipal("Poisson", 11.0f);

            Plat d1 = new Dessert("Tarte", 4.0f);
            Plat d2 = new Dessert("Gateau", 3.0f);

            Plat b1 = new Boisson("Cola", 3.0f);
            Plat b2 = new Boisson("Vin", 7.0f);

            Menu m1 = new Menu("Menu Midi", 16.0f, e1, p1, d1, b1);
            Menu m2 = new Menu("Menu Soir", 19.0f, e2, p2, d2, b2);

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

            isInit = true;
        }
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

    public static Integer[][] getRestaurantMap() {
        return restaurantMap;
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
