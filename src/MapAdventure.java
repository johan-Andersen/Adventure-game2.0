public class MapAdventure {

    private Room currentroom;

    public Room getRoom(){
        return currentroom;
    }

    public MapAdventure(){
        this.createMap();
    }

    public void createMap(){



        Room room1 = new Room("room1","Its freezing in here. Gloomy walls, dark and wet. Be careful not to slip. There are 2 doors in the room");
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

        // ------------------------- del 2 -------------------

        ItemAdventure torch = new ItemAdventure("torch", "an old wooding torch, with a calming warm flame");
        ItemAdventure rock = new ItemAdventure("rock", "wet and slippery");
        ItemAdventure paper = new ItemAdventure("paper", "A brown piece of paper with an unknown language written on it. Must be the ancient language of the vampires ");
        ItemAdventure shoes = new ItemAdventure("shoes", "A pair of, what seems to be a, new leather boots");



        room1.addItems(torch);
        room1.addItems(rock);
        room2.addItems(paper);
        room3.addItems(shoes);

        FoodAdventure bread = new FoodAdventure("bread", "a hard piece of rie bread", 10);
        FoodAdventure cigarette = new FoodAdventure("cigarette", "a bag with rolling tobacco and paper", -20);
        FoodAdventure foot = new FoodAdventure("foot", "A rotten human foot, cut off by the ankle", -15);
        FoodAdventure blood = new FoodAdventure("jar of blood", "a dusty old jar, filled with blood. The top sealed with dark red wax", 30);



        room1.addItems(bread);
        room7.addItems(cigarette);
        room9.addItems(foot);
        room6.addItems(blood);



    }

}
