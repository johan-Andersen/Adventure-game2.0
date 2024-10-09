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
        ItemAdventure glass = new ItemAdventure("glass", "brown-ish glass");



        room1.addItems(torch);
        room1.addItems(rock);
        room2.addItems(paper);
        room3.addItems(shoes);
        room6.addItems(glass);

//------------------ del 3 ----------------------

        FoodAdventure bread = new FoodAdventure("bread", "a hard piece of rie bread", 10);
        FoodAdventure cigarette = new FoodAdventure("cigarette", "a bag with rolling tobacco and paper", -20);
        FoodAdventure foot = new FoodAdventure("foot", "A rotten human foot, cut off by the ankle", -15);
        FoodAdventure blood = new FoodAdventure("jar of blood", "a dusty old jar, filled with blood. The top sealed with dark red wax", 30);
        FoodAdventure beef = new FoodAdventure("dried beef", "dried and salty beef. Probably made in the kitchen here somewhere", 15);
        FoodAdventure ball = new FoodAdventure("black ball", "the balls feels soft but firm, like an old piece of dough", -50);
        FoodAdventure potion = new FoodAdventure("vampire magic", "try it at your own cost", 100);
        FoodAdventure rice = new FoodAdventure("rice", "Bowl of rice", 19);



        room1.addItems(bread);
        room7.addItems(cigarette);
        room9.addItems(foot);
        room6.addItems(blood);
        room2.addItems(beef);
        room8.addItems(ball);
        room9.addItems(potion);
        room1.addItems(rice);


// ------------------------ del 4 -----------------

        MeleeWeaponsAdventure hammer = new MeleeWeaponsAdventure("hammer", "steel hammer head, splintering dark wood handle", 5, Double.POSITIVE_INFINITY);
        RangeWeaponsAdventure bow = new RangeWeaponsAdventure("bow", "beautiful old bow, made by the high elfs", 15, 5);
        MeleeWeaponsAdventure knives = new MeleeWeaponsAdventure("two hidden knives", "these knives are used by the vampires assasins", 20, Double.POSITIVE_INFINITY);
        MeleeWeaponsAdventure speer = new MeleeWeaponsAdventure("basic speer", "Some soldier probably forgot it", 10, Double.POSITIVE_INFINITY);

        room1.addItems(hammer);
        room3.addItems(bow);
        room4.addItems(knives);
        room7.addItems(speer);



// ----------------- del 5 --------------------

        MeleeWeaponsAdventure sword = new MeleeWeaponsAdventure("sword", "newly made short sword, made with dark steel", 15, Double.POSITIVE_INFINITY);
        EnemyAdventure vampire1 = new EnemyAdventure("vampire", "castle soldier", 50, sword);
        MeleeWeaponsAdventure knigts = new MeleeWeaponsAdventure("Double edged knigts sword", "A magnificent piece of craftmanship", 50, Double.POSITIVE_INFINITY);
        EnemyAdventure sneaker = new EnemyAdventure("Sneaker", "A small and fragile creature, hidding in the dark", 20, knigts);
        MeleeWeaponsAdventure knife = new MeleeWeaponsAdventure("small knife", "a childs knife", 10, Double.POSITIVE_INFINITY);
        EnemyAdventure child = new EnemyAdventure("A child.. vampire", "his shaking, right hand holding tight on to his knife", 20, knife);
        MeleeWeaponsAdventure Sword = new MeleeWeaponsAdventure("longsword", "a rather beautiful sword", 40, Double.POSITIVE_INFINITY);
        EnemyAdventure vampire = new EnemyAdventure("Vampire", "Another and another", 40, Sword);
        MeleeWeaponsAdventure claws = new MeleeWeaponsAdventure("Draculas Claws", "Dracula have immense strength and so does his claws. Dont be fooled, you should fear them more than any sword or speer", 75, Double.POSITIVE_INFINITY);
        EnemyAdventure dracular = new EnemyAdventure("Vlad Țepeș Dracula", "Standing at 2,5 meter, 148Kg, Dracular towers over anyone before him. his yet-black hair and snow white skin is covered in a red and black coat. dead eyes and the knowledge of centuries. Dont be let his calm presence take your guard down... He's a ruthless.. ", 300, claws);


        room7.addEnemy(vampire1);
        room9.addEnemy(sneaker);
        room2.addEnemy(child);
        room6.addEnemy(vampire);
        room5.addEnemy(dracular);



    }

}
