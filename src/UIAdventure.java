import java.util.Scanner;

public class UIAdventure {


    public void Ui() {

        Adventure adventure = new Adventure();

    System.out.println("Welcome to the adventure game. Here are the controles!:");
        System.out.println("Type 'go' followed by 'north', 'south', 'east' or 'west', followed by ENTER, to move through the map");
        System.out.println("Type 'look', followed by ENTER, to look around the room you're currently in");
        System.out.println("Type 'exit' to exit the game");
        System.out.println("\n\n\nLet the game begin!");



    Scanner input = new Scanner(System.in);
    String useraction = "";

        while(!useraction.equalsIgnoreCase("exit")) {
            useraction = input.nextLine();

            switch(useraction) {


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

                    System.out.println(adventure.getPlayer().getCurrentRoom().getName());
                    System.out.println(adventure.getPlayer().getCurrentRoom().getSurroundings());

                }
                case "help" -> {
                    System.out.println("I already told you, this is how you controle the game:");
                    System.out.println("Type 'go' followed by 'north', 'south', 'east' or 'west', followed by ENTER, to move through the map");
                    System.out.println("Type 'look', follwed by ENTER, to look around the room you're currently in");
                    System.out.println("Type 'exit' to exit the game");
                    System.out.println("\n\n\nLet the game begin!... again");

                }
                default -> {
                    System.out.println("Unknown command");
                }


            }
            System.out.println(adventure.getPlayer().getCurrentRoom().getName());
            System.out.println(adventure.getPlayer().getCurrentRoom().getSurroundings());


//            switch (useraction) {
//
//                case "go north" -> {
//                    if (currentRoom.getNorthRoom() == null) {
//                        System.out.println("There are no doors north of here!");
//
//                    } else {
//                        System.out.println("going north");
//                        currentRoom = currentRoom.getNorthRoom();
//                        System.out.println(currentRoom);
//                    }
//                }
//                case "go south" -> {
//                    if (currentRoom.getSouthRoom() == null) {
//                        System.out.println("There are no doors south of here");
//
//                    } else {
//                        System.out.println("going south");
//                        currentRoom = currentRoom.getSouthRoom();
//                        System.out.println(currentRoom);
//                    }
//
//                }
//                case "go east" -> {
//                    if (currentRoom.getEastRoom() == null) {
//                        System.out.println("there are no doors east of here");
//                    } else {
//                        System.out.println("going east");
//                        currentRoom = currentRoom.getEastRoom();
//                        System.out.println(currentRoom);
//                    }
//
//                }
//                case "go west" -> {
//                    if (currentRoom.getWestRoom() == null) {
//                        System.out.println("there are no doors west of here");
//                    } else {
//                        System.out.println("going west");
//                        currentRoom = currentRoom.getWestRoom();
//                        System.out.println(currentRoom);
//                    }
//
//
//                }
//                case "look" -> {
//                    System.out.println("looking around");
//                    System.out.println(currentRoom);
//
//                }
//                case "help" -> {
//                    System.out.println("I already told you, this is how you controle the game:");
//                    System.out.println("Type 'go' followed by 'north', 'south', 'east' or 'west', followed by ENTER, to move through the map");
//                    System.out.println("Type 'look', follwed by ENTER, to look around the room you're currently in");
//                    System.out.println("Type 'exit' to exit the game");
//                    System.out.println("\n\n\nLet the game begin!... again");
//                }
//            }


        }




    }

}
