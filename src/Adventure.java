import java.util.Random;
import java.util.Scanner;

public class Adventure {

    private MapAdventure map;
    private PlayerAdventure player;

public Adventure(){
    this.map = new MapAdventure();
    this.player = new PlayerAdventure(map.getRoom());

}

public PlayerAdventure getPlayer(){

    return player;
}


    //public void start(){




//        Room currentRoom = MapAdventure.createMap();
//
//        UIAdventure uiAdventure = new UIAdventure(currentRoom);
//
//        uiAdventure.Ui();
//
//        PlayerAdventure Belmont = new PlayerAdventure(currentRoom);
//
//
//    }
}
