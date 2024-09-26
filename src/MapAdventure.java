public class MapAdventure {

    private Room currentroom;

    public Room getRoom(){
        return currentroom;
    }

    public MapAdventure(){
        this.createMap();
    }

    public void createMap(){



        Room room1 = new Room("room1","Its freezing in here right, gloomy walls, dark and wet. Be careful not to slip. There are 2 doors in the room");
        Room room2 = new Room("room2", "The room is dry as bone, drink some water perhaps. We need you soldier! btw there are 2 doors");
        Room room3 = new Room("room3", "its awfully quite in here..with 2 doors");
        Room room4 = new Room("room4", "There are 2 doors and is that children… they're white as snow..");
        Room room5 = new Room("room5", "You have entered Draculas den. Filled with riches beyond comprehension. Walls covered in gold and with paintings dating back millenniums. But there's only one one way, in and out");
        Room room6 = new Room("room6","A weaponry! Spears, swords, arrows, knives and sheelds! Everywhere. And  2 doors");
        Room room7 = new Room("room7", "There are 2 doors in the room. But Can you smell that? You've stepped into the kitchen. Fresh vegetables, meets and bread.");
        Room room8 = new Room("room8","There are 3 doors... Can you feel his presence?  ");
        Room room9 = new Room("room9", "There are 2 doors and a pile of  fallen comrades");

        room1.setSouthRoom(room4);
        room1.setEastRoom(room2);

        room2.setWestRoom(room1);
        room2.setEastRoom(room3);

        room3.setWestRoom(room2);
        room3.setSouthRoom(room6);

        room4.setNorthRoom(room1);
        room4.setSouthRoom(room7);

        room5.setSouthRoom(room8);

        room6.setSouthRoom(room9);
        room6.setNorthRoom(room3);

        room7.setNorthRoom(room4);
        room7.setEastRoom(room8);

        room8.setWestRoom(room7);
        room8.setNorthRoom(room5);
        room8.setEastRoom(room9);

        room9.setNorthRoom(room6);
        room9.setWestRoom(room8);

        currentroom = room1;




    }

}
