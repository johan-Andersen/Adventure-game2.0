import java.util.ArrayList;

public class PlayerAdventure {

    private Room currentRoom;
    private ArrayList<ItemAdventure> itemListInventory;
    private double health;
    private ArrayList<ItemAdventure> equipped;
    private WeaponsAdventure weapon;

    public PlayerAdventure(Room firstRoom, double health) {

        this.currentRoom = firstRoom;
        this.itemListInventory = new ArrayList<>();
        this.health = health;
        this.equipped = new ArrayList<>();

    }

    public void goNorth() {

        if (currentRoom.getNorthRoom() != null) {
            currentRoom = currentRoom.getNorthRoom();
        } else {
            System.out.println("There are no doors North of here");
        }
    }

    public void goSouth() {

        if (currentRoom.getSouthRoom() != null) {
            currentRoom = currentRoom.getSouthRoom();

        } else {
            System.out.println("There are no doors South of here");
        }
    }

    public void goEast() {

        if (currentRoom.getEastRoom() != null) {
            currentRoom = currentRoom.getEastRoom();
        } else {
            System.out.println("There are no doors East of here");
        }
    }

    public void goWest() {

        if (currentRoom.getWestRoom() != null) {
            currentRoom = currentRoom.getWestRoom();
        } else {
            System.out.println("There are no doors West of here");
        }
    }

    public Room getCurrentRoom() {

        return currentRoom;

    }

    // ---------- del 2 -----------------------

    public void addItemToInventory(ItemAdventure item) {
        itemListInventory.add(item);
    }

    public ArrayList<ItemAdventure> getItemListInventory() {
        return itemListInventory;
    }

    @Override
    public String toString() {
        return "Health: " + health;
    }


    //-------------------del 3 ----------------


    public double consume(FoodAdventure food) {

        health = health + food.getHealthPoints();

        if (health > 100) {

            health = 100;
        }

        itemListInventory.remove(food);
        return health;
    }

    public double getHealth() {
        return health;
    }


    //---------------del 4 -------------------

    public void addweaponToEquipped(ItemAdventure weapon) {
        equipped.add(weapon);
    }

    public ArrayList<ItemAdventure> getEquippedWeapon() {

        return equipped;
    }

    public WeaponsAdventure getPlayerWeapon() {

        return (WeaponsAdventure) equipped.get(0);

    }

//---------------- del 5 --------------------------

    public void takeDamagePlayer(WeaponsAdventure weapon) {

        health -= weapon.getDamage();

    }
}







//public Room move(String movement){


//    if(movement.equalsIgnoreCase("go north") && placement.getNorthRoom() != null) {
//
//        placement = placement.getNorthRoom();
//
//    }
//    else if (movement.equalsIgnoreCase("go south") && placement.getSouthRoom() !=null) {
//
//
//        placement = placement.getSouthRoom();
//    }
//    else if (movement.equalsIgnoreCase("go east") && placement.getEastRoom() !=null) {
//
//        placement = placement.getEastRoom();
//
//    }
//    else if (movement.equalsIgnoreCase("go west") && placement.getWestRoom() !=null) {
//
//        placement = placement.getWestRoom();
//
//    }
//    else {
//
//        return null;
//
//    }
//
//    return placement;





