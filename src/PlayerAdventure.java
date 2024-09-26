public class PlayerAdventure {

    private Room currentRoom;

    public PlayerAdventure(Room firstRoom) {

        this.currentRoom = firstRoom;
    }

    public void goNorth() {

        if (currentRoom.getNorthRoom() != null) {
            currentRoom = currentRoom.getNorthRoom();
        } else {
          System.out.println("There are no doors North of here");
        }
    }

    public void goSouth() {

        if(currentRoom.getSouthRoom() != null) {
            currentRoom = currentRoom.getSouthRoom();

        } else {
            System.out.println("There are no doors South of here");
        }
    }

    public void goEast() {

        if(currentRoom.getEastRoom() != null) {
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

        }



