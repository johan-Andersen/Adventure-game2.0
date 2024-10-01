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

        while (!useraction.equalsIgnoreCase("exit")) {  // While loop makes it possible to "stay" in the game and repeatedly
            useraction = input.nextLine();
// ----------TO TAKE AN ITEM FROM A ROOM ------------------------------------------------
            if (useraction.startsWith("take ")) { // The if-statement checks whether our string user input starts with "take" and we therefore want to take an object

                String[] parts = useraction.split("take ", 2); // The program now checks if we have a second string input
                if (parts.length < 2) {   // If statement checks if the "parts" (our string input) has less than index 1 (2 spaces)
                    System.out.println("take what?");  // if it is sout is written
                } else {  // if its longer than index 0
                    String itemName = parts[1].trim();  // we set itemName to the value of "parts[1].trim()" which means our string input at index 1,
                    // aka the string after take. "trim()" makes sure that we are left with only the string at index 1 (no spaces or anything else).

                    ItemAdventure item = adventure.getPlayer().getCurrentRoom().takeItem(itemName);  // We use the method() in our Room class,
                    // which removes the string in the paremeter and returns null,
                    if (item != null) {  // Now if the itemName is in the itemsList item will get the value of null
                        System.out.println("you took " + item.getName());  //sout will be in the console
                        adventure.getPlayer().addItemToInventory(item);  //the item that has been removed from the room will now be added to the users inventory
                    } else {  // if the item is not in the room, the user will be told so
                        System.out.println("no such item in this room");
                    }
                }
//-------------------------TO LEAVE AN ITEM IN A ROOM ------------------------------------
            } else if (useraction.startsWith("leave ")) {  // To check if the user want to leave something behind, the else-if statement checks if the
                // input Starts with leave
                String[] parts = useraction.split("leave ", 2);  // The program now checks if we have a second string input
                if (parts.length < 2) {   // If statement checks if the "parts" (our string input) is less than index 1 (2 spaces)
                    System.out.println("leave what?");  // if it is sout is written
                } else { // if its longer than index 0
                    String itemName = parts[1].trim(); // we set itemName to the value of "parts[1].trim()" which means our string input at index 1,
                    // aka the string after take. "trim()" makes sure that we are left with only the string at index 1 (no spaces or anything else).
                    ItemAdventure itemToLeave = null; //we set the value of itemToLeave to null
                    for (ItemAdventure item : adventure.getPlayer().getItemListInventory()) { // We make a for loop to go through our itemListInventory
                        if (item.getName().equalsIgnoreCase(itemName)) { //if an item in our inventory matches "item", "itemToLeave" will be sat to the value of "Item" and break out of the loop
                            itemToLeave = item;
                            break;
                        }

                    }
                    if (itemToLeave != null) { // if our "itemToLeave" isnt equal to the value of null, that means our "itemName" (the userinput) could be found in our inventory
                        adventure.getPlayer().getCurrentRoom().leaveItem(itemToLeave); // And if  the item was in our inventory we will leave it behind in the current room
                        adventure.getPlayer().getItemListInventory().remove(itemToLeave); // At the same time we will remove it from our inventory.
                        System.out.println("you left " + itemName + " in " + adventure.getPlayer().getCurrentRoom().getName());
                    } else {
                        System.out.println("you dont have that item...");  // if "itemToLeave" is equal to null, there is
                        // no match in our inventory and the user will be told no such thign could be found in the inventory
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

