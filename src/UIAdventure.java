import java.io.FileOutputStream;
import java.sql.SQLOutput;
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
            String[] word = useraction.split(" ");
            String action = word[0];

            switch (action) {  //Switch takes the String "action" which has the value of word[0]. aka the first word the user types in

                case "attack" -> {
                    if (word.length < 2) {
                        if (adventure.IsEnemyListEmpty()) {
                            WeaponsAdventure weapon = adventure.getPlayerWeaponA();// if the equipped weapon array isnt empty, we'll make a variable, of type WeaponAdventure, and assigns it the value of
                            // the weapon in our equipped Arraylist (at index 0)
                            if (weapon != null && weapon.getAmmunition() > 0) { //we'll check if our weapon variable isnt null and the weapons ammunition havent run out
                                weapon.useAmmunition(); //we use our method from the weapons class to use one ammunition for each time the user attacks
                                System.out.println("congrats, you attacked the AIR with your " + weapon.getName() + "...  Ammunition left: " + weapon.getAmmunition());
                            } else {
                                System.out.println("No ammunition left for " + weapon.getName() + ". Also.. no one's here"); // if the if statement is false and there is no ammunition left, the user will be told that there is no amo left
                            }
                        }
                        if (!adventure.IsEnemyListEmpty()) {
                            WeaponsAdventure weapon = adventure.getPlayerWeaponA(); // if the equipped weapon array isnt empty, we'll make a variable, of type WeaponAdventure, and assigns it the value of
                            // the weapon in our equipped Arraylist (at index 0)
                            if (weapon != null && weapon.getAmmunition() > 0) { //we'll check if our weapon variable isnt null and the weapons ammunition havent run out
                                weapon.useAmmunition();//we use our method from the weapons class to use one ammunition for each time the user attacks
                                System.out.println("you attacked with a " + weapon.getName() + ". Ammunition left: " + weapon.getAmmunition()); // we also print out what weapon the user attacked with and the ammunition thats left

                                adventure.takeDamageEnemyA(weapon); //we take use of the method "takeDamage" from the Enemy class. The methods subtracks the enemy's health with the equipped weapon

                                if (adventure.getEnemyHealthA() < 1) {

                                    System.out.println("You killed the " + adventure.getEnemyNameA() + "! Well done!");
                                    System.out.println("The " + adventure.getEnemyNameA() + " dropped its weapon");
                                    adventure.addItemsA(adventure.getEnemyWeaponA());
                                    adventure.getEnemyListA().removeFirst();
                                } else {
                                    adventure.takeDamagePlayerA(adventure.getEnemyWeaponA()); // after the attacking the enemy, the enemy attacks back. For this we use the method "takeDamagePlayer"

                                    System.out.println("The " + adventure.getEnemyNameA() + "'s health is at: " + adventure.getEnemyHealthA());

                                    System.out.println("\nThe " + adventure.getEnemyNameA() + " attacked back!! Your health is at: " + adventure.getPlayerHealthA());

                                    if (adventure.getPlayer().getHealth() < 1) {
                                        System.out.println("YOU DIED . GAME OVER!!");
                                        System.exit(0);
                                    }

                                }
                            }
                        }
                    } else if (word[1].equalsIgnoreCase(adventure.getEnemyNameA())) {
                        if (adventure.getEquippedWeaponA().isEmpty()) {  //if the user tries to attack, without an equipped weapon, they get the following message:
                            System.out.println("you dont have a weapon equipped");
                        } else {
                            WeaponsAdventure weapon = adventure.getPlayerWeaponA(); // if the equipped weapon array isnt empty, we'll make a variable, of type WeaponAdventure, and assigns it the value of
                            // the weapon in our equipped Arraylist (at index 0)
                            if (weapon != null && weapon.getAmmunition() > 0) { //we'll check if our weapon variable isnt null and the weapons ammunition havent run out
                                weapon.useAmmunition(); //we use our method from the weapons class to use one ammunition for each time the user attacks
                                System.out.println("you attacked with a " + weapon.getName() + ". Ammunition left: " + weapon.getAmmunition()); // we also print out what weapon the user attacked with and the ammunition thats left

                                adventure.takeDamageEnemyA(weapon); //we take use of the method "takeDamage" from the Enemy class. The methods subtracks the enemy's health with the equipped weapon

                                if (adventure.getEnemyHealthA() < 1) {

                                    System.out.println("You killed the " + adventure.getEnemyNameA() + "! Well done!");
                                    System.out.println("The " + adventure.getEnemyNameA() + "dropped its weapon");
                                    adventure.addItemsA(adventure.getEnemyWeaponA());
                                    adventure.getEnemyListA().removeFirst();


                                } else {
                                    adventure.takeDamagePlayerA(adventure.getEnemyWeaponA()); // after attacking the enemy, the enemy attacks back. For this we use the method "takeDamagePlayer"

                                    System.out.println("The " + adventure.getEnemyNameA() + "'s health is at: " + adventure.getEnemyHealthA());

                                    System.out.println("\nThe " + adventure.getEnemyNameA() + " attacked back!! Your health is at: " + adventure.getPlayerHealthA());

                                    if (adventure.getPlayer().getHealth() < 1) {
                                        System.out.println("YOU DIED . GAME OVER!!");
                                        System.exit(0);
                                    }

                                }

                            } else {
                                System.out.println("No ammunition left for " + weapon.getName()); // if the if statement is false and there is no ammunition left, the user will be told that there is no amo left
                            }
                        }
                    } else {
                        System.out.println("no such thing is in here!");
                    }


                    break;
                }
                case "equip" -> {
                    if (word.length < 2) {
                        System.out.println("equip what?");
                    } else {
                        String weaponName = word[1].trim();
                        ItemAdventure weaponChosen = null; //we make a variable and sets its value as null

                        for (ItemAdventure item : adventure.getItemListInventoryA()) { //we iterate through our Item Arraylist
                            if (item.getName().equalsIgnoreCase(weaponName)) {  //we check if one of the elements in our arraylist equals with our weaponName
                                weaponChosen = item;  //if the above is the case, we set weaponChosen's value equal to item
                                break;
                            }
                        }
                        if (weaponChosen == null) {  // if no match was found above weaponChosen will stay equal to null and this if statement will "go through"
                            System.out.println("You don't have this in your inventory.");
                        } else if (!(weaponChosen instanceof WeaponsAdventure)) { //if weaponChosen isnt equal to null, but the user chose an item which wasnt an instanceof the weapon class, the user will be told so

                            System.out.println("This isn't a weapon!");
                        } else {
                            WeaponsAdventure weapon = (WeaponsAdventure) weaponChosen; //if the item the user tried to equip infact was a of the weapon class the weaponChosen til be type casted to the Weapons class
                            if (!adventure.getEquippedWeaponA().isEmpty()) { // we check if there already is a weapon equipped
                                adventure.getEquippedWeaponA().remove(0); // we remove the equipped weapon
                                adventure.addWeapontoEquippedA(weapon); // we equip the new weapon
                                System.out.println(weapon + " has been equipped");  // we let the user know
                                break;
                            } else {  //if there was no weapon already equipped we just equip the new weapon and tell the user
                                adventure.addWeapontoEquippedA(weapon);
                                System.out.println(weapon + " has been equipped");
                            }
                        }
                    }
                    break;
                }


                case "health" -> {
                    System.out.println(adventure.getPlayer().toString());
                    break;
                }
                case "eat" -> {
                    if (word.length < 2) {
                        System.out.println("eat what");
                    } else {
                        String foodName = word[1].trim();
                        FoodAdventure foodToEat = null;

                        for (ItemAdventure item : adventure.getPlayer().getCurrentRoom().getItemlist()) {
                            if (item instanceof FoodAdventure && item.getName().equalsIgnoreCase(foodName)) {
                                foodToEat = (FoodAdventure) item;
                                break;
                            }
                        }
                        for (ItemAdventure item : adventure.getPlayer().getItemListInventory())
                            if (item instanceof FoodAdventure && item.getName().equalsIgnoreCase(foodName)) {
                                foodToEat = (FoodAdventure) item;
                                break;
                            }
                        if (foodToEat != null) {
                            adventure.getItemListA().remove(foodToEat);
                            adventure.consumeA(foodToEat);
                            System.out.println("You ate the " + foodToEat);
                            System.out.println(adventure.getPlayer().toString());
                        } else if (adventure.getPlayer().getHealth() <= 0) {
                            System.out.println("YOU DIED - GAME OVER!");
                            System.exit(0);
                        } else {
                            System.out.println("You cant eat that");
                        }
                    }
                    break;
                }
                case "take" -> {
                    if (word.length < 2) {   // If statement checks if the "parts" (our string input) has less than index 1 (2 spaces)
                        System.out.println("take what?");  // if it is sout is written
                    } else {  // if its longer than index 0
                        String itemName = word[1].trim();  // we set itemName to the value of "parts[1].trim()" which means our string input at index 1,
                        // aka the string after take. "trim()" makes sure that we are left with only the string at index 1 (no spaces or anything else).

                        ItemAdventure item = adventure.takeItemA(itemName);  // We use the method() in our Room class,
                        // which removes the string in the paremeter and returns null,
                        if (item != null) {  // Now if the itemName is in the itemsList item will get the value of null
                            System.out.println("you took " + item.getName());  //sout will be in the console
                            adventure.addItemToInventoryA(item);  //the item that has been removed from the room will now be added to the users inventory
                        } else {  // if the item is not in the room, the user will be told so
                            System.out.println("no such item in this room");
                        }
                    }
                    break;

                }
                case "leave" -> {

                    if (word.length < 2) {   // If statement checks if the "parts" (our string input) is less than index 1 (2 spaces)
                        System.out.println("leave what?");  // if it is sout is written
                    } else { // if its longer than index 0
                        String itemName = word[1].trim(); // we set itemName to the value of "parts[1].trim()" which means our string input at index 1,
                        // aka the string after take. "trim()" makes sure that we are left with only the string at index 1 (no spaces or anything else).
                        ItemAdventure itemToLeave = null; //we set the value of itemToLeave to null
                        for (ItemAdventure item : adventure.getItemListInventoryA()) { // We make a for loop to go through our itemListInventory
                            if (item.getName().equalsIgnoreCase(itemName)) { //if an item in our inventory matches "item", "itemToLeave" will be sat to the value of "Item" and break out of the loop
                                itemToLeave = item;
                                break;
                            }

                        }
                        if (itemToLeave != null) { // if our "itemToLeave" isnt equal to the value of null, that means our "itemName" (the userinput) could be found in our inventory
                            adventure.leaveItemA(itemToLeave); // And if  the item was in our inventory we will leave it behind in the current room
                            adventure.getItemListInventoryA().remove(itemToLeave);// At the same time we will remove it from our inventory.
                            adventure.getEquippedWeaponA().remove(itemToLeave);
                            System.out.println("you left " + itemName + " in " + adventure.getRoomName());
                        } else {
                            System.out.println("you dont have that item...");  // if "itemToLeave" is equal to null, there is
                            // no match in our inventory and the user will be told no such thign could be found in the inventory
                        }
                    }
                    break;
                }
                case "inventory" -> {
                    if (!adventure.getItemListInventoryA().isEmpty()) {
                        System.out.println(adventure.getItemListInventoryA() + " Is in your bag");

                    } else {
                        System.out.println("your bag is empty");
                    }
                    break;
                }
                case "go" -> {
                    if (word.length < 2) {
                        System.out.println("go where?");
                    } else if (word[1].equalsIgnoreCase("north")) {
                        adventure.getPlayer().goNorth();
                        System.out.println(adventure.roomToString());
                    } else if (word[1].equalsIgnoreCase("south")) {
                        adventure.getPlayer().goSouth();
                        System.out.println(adventure.roomToString());
                    } else if (word[1].equalsIgnoreCase("east")) {
                        adventure.getPlayer().goEast();
                        System.out.println(adventure.roomToString());
                    } else if (word[1].equalsIgnoreCase("west")) {
                        adventure.getPlayer().goWest();
                        System.out.println(adventure.roomToString());
                    } else {
                        System.out.println("go where?");
                    }
                    break;
                }
                case "look" -> {
                    List<ItemAdventure> items = adventure.getItemListA();
                    if (items.isEmpty()) {
                        System.out.println("There is nothing to pick up here");
                    } else {
                        System.out.println("The following is in the room: \n");
                        for (ItemAdventure item : items) {

                            System.out.println(item);
                        }
                    }
                    break;
                }
                case "help" -> {
                    System.out.println("I already told you, this is how you controle the game:");
                    System.out.println("Type 'go' followed by 'north', 'south', 'east' or 'west', followed by ENTER, to move through the map");
                    System.out.println("Type 'look', follwed by ENTER, to look around the room you're currently in");
                    System.out.println("Type 'exit' to exit the game");
                    System.out.println("Type 'inventory', followed by ENTER to look at your inventory");
                    System.out.println("Type 'take' followed by the object you want to take and ENTER, to pick something up");
                    System.out.println("\n\n\nLet the game begin!... again");
                    break;
                }
                default -> {
                    System.out.println("Unknown command");
                    break;
                }
            }
        }
    }
}

