import java.util.ArrayList;

public class PlayerAdventure {

    private Room currentRoom;
    private ArrayList<ItemAdventure> itemListInventory;

    public PlayerAdventure(Room firstRoom) {

        this.currentRoom = firstRoom;
        this.itemListInventory = new ArrayList<>();

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





