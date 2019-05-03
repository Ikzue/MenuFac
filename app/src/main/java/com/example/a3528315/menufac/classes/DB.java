package com.example.a3528315.menufac.classes;

import com.example.a3528315.menufac.commands.ActivityConstants;

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

    private static List<CommandItem> table1;
    private static List<CommandItem> table2;
    private static List<CommandItem> table3;
    private static List<CommandItem> table4;
    private static List<CommandItem> table5;
    private static List<CommandItem> table6;
    private static List<CommandItem> table7;
    private static List<CommandItem> table8;
    private static List<CommandItem> table9;

    private static List<CommandItem> tempCommand;

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

    public static List<CommandItem> getTable(int table) {
        List<CommandItem> list = null;
        switch(table) {
            case ActivityConstants.ACTIVITY_1:
                list = DB.table1;
                break;
            case ActivityConstants.ACTIVITY_2:
                list = DB.table2;
                break;
            case ActivityConstants.ACTIVITY_3:
                list = DB.table3;
                break;
            case ActivityConstants.ACTIVITY_4:
                list = DB.table4;
                break;
            case ActivityConstants.ACTIVITY_5:
                list = DB.table5;
                break;
            case ActivityConstants.ACTIVITY_6:
                list = DB.table6;
                break;
            case ActivityConstants.ACTIVITY_7:
                list = DB.table7;
                break;
            case ActivityConstants.ACTIVITY_8:
                list = DB.table8;
                break;
            case ActivityConstants.ACTIVITY_9:
                list = DB.table9;
                break;
        }
        return new ArrayList<CommandItem>(list);
    }

    public static void updateTable(int table, List<CommandItem> commandItems) {
        List<CommandItem> command = new ArrayList<CommandItem>(commandItems);
        switch(table) {
            case ActivityConstants.ACTIVITY_1:
                table1 = command;
                break;
            case ActivityConstants.ACTIVITY_2:
                table2 = command;
                break;
            case ActivityConstants.ACTIVITY_3:
                table3 = command;
                break;
            case ActivityConstants.ACTIVITY_4:
                table4 = command;
                break;
            case ActivityConstants.ACTIVITY_5:
                table5 = command;
                break;
            case ActivityConstants.ACTIVITY_6:
                table6 = command;
                break;
            case ActivityConstants.ACTIVITY_7:
                table7 = command;
                break;
            case ActivityConstants.ACTIVITY_8:
                table8 = command;
                break;
            case ActivityConstants.ACTIVITY_9:
                table9= command;
                break;
        }
    }
}
