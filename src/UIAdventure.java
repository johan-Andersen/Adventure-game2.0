import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIAdventure {


    public void Ui() {

        Adventure adventure = new Adventure();

        System.out.println("Welcome to the adventure game. Here are the controles!:");
        System.out.println("Type 'go' followed by 'north', 'south', 'east' or 'west', followed by ENTER, to move through the map");
        System.out.println("Type 'look', followed by ENTER, to look around the room you're currently in");
        System.out.println("Type 'exit' to exit the game");
        System.out.println("Type 'inventory', followed by ENTER to look at your inventory");
        System.out.println("Type 'take' followed by the object you want to take and ENTER, to pick something up");
        System.out.println("\n\n\nLet the game begin!");


        Scanner input = new Scanner(System.in);
        String useraction = "";

        while (!useraction.equalsIgnoreCase("exit")) {
            useraction = input.nextLine();
// ----------TO TAKE AN ITEM FROM A ROOM ----------------------------------
            if (useraction.startsWith("take ")) {

                String[] parts = useraction.split("take ", 2);
                if (parts.length < 2) {
                    System.out.println("take what?");
                } else {
                    String itemName = parts[1].trim();
                    ItemAdventure item = adventure.getPlayer().getCurrentRoom().takeItem(itemName);
                    if (item != null) {
                        System.out.println("you took " + item.getName());
                        adventure.getPlayer().addItemToInventory(item);
                    } else {
                        System.out.println("no such item in this room");
                    }
                }
//-------------------------TO LEAVE AN ITEM IN A ROOM ------------------------------------
            } else if (useraction.startsWith("leave ")) {
                String[] parts = useraction.split("leave ", 2);
                if (parts.length < 2) {
                    System.out.println("leave what?");
                } else {
                    String itemName = parts[1].trim();
                    ItemAdventure itemToDrop = null;
                    for (ItemAdventure item : adventure.getPlayer().getItemListInventory()) {
                        if (item.getName().equalsIgnoreCase(itemName)) {
                            itemToDrop = item;
                            break;
                        }

                    }
                    if (itemToDrop != null) {
                        adventure.getPlayer().getCurrentRoom().leaveItem(itemToDrop);
                        adventure.getPlayer().getItemListInventory().remove(itemToDrop);
                        System.out.println("you left " + itemName + " in " + adventure.getPlayer().getCurrentRoom().getName());
                    } else {
                        System.out.println("you dont have that item...");
                    }
                }
            } else {
                // --------------------OTHER COMMANDS ------------------------------------

                switch (useraction) {

                    case "inventory" -> {
                        System.out.println(adventure.getPlayer().getItemListInventory() + " Is in your bag");
                    }
                    case "go north" -> {
                        adventure.getPlayer().goNorth();
                        break;
                    }
                    case "go south" -> {
                        adventure.getPlayer().goSouth();
                        break;
                    }
                    case "go east" -> {
                        adventure.getPlayer().goEast();
                        break;
                    }
                    case "go west" -> {
                        adventure.getPlayer().goWest();
                        break;
                    }
                    case "look" -> {
                        List<ItemAdventure> items = adventure.getPlayer().getCurrentRoom().getItemlist();
                        if (items.isEmpty()) {
                            System.out.println("There is nothing to pick up here");
                        } else {
                            System.out.println("The following is in the room: \n");
                            for (ItemAdventure item : items) {

                                System.out.println(item);
                            }
                        }
                    }
                    case "help" -> {
                        System.out.println("I already told you, this is how you controle the game:");
                        System.out.println("Type 'go' followed by 'north', 'south', 'east' or 'west', followed by ENTER, to move through the map");
                        System.out.println("Type 'look', follwed by ENTER, to look around the room you're currently in");
                        System.out.println("Type 'exit' to exit the game");
                        System.out.println("Type 'inventory', followed by ENTER to look at your inventory");
                        System.out.println("Type 'take' followed by the object you want to take and ENTER, to pick something up");
                        System.out.println("\n\n\nLet the game begin!... again");
                    }
                    default -> {
                        System.out.println("Unknown command");
                    }
                }
                System.out.println(adventure.getPlayer().getCurrentRoom().toString());
            }
        }
    }
}

