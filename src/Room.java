import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private String surroundings;
    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;
    private List<ItemAdventure> itemlist;
    private List<EnemyAdventure> enemyList;
    private EnemyAdventure enemy;



    public Room(String name,String surroundings) {
        this.name = name;
        this.surroundings = surroundings;
        this.itemlist = new ArrayList<>(); // del 2
        this.enemyList = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public String getSurroundings(){
        return surroundings;
    }


    public void setNorthRoom(Room northRoom) {
        this.northRoom = northRoom;
    }
    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
    }
    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
    }
    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
    }

  public Room getNorthRoom(){
        return northRoom;
  }
  public Room getSouthRoom() {
      return southRoom;
  }
  public Room getEastRoom(){
        return eastRoom;
  }
  public Room getWestRoom(){
        return westRoom;
  }

    public String toString(){
        return "you're in: " + name + ": " + surroundings +
                "\nEnemies in the room: " + enemyList;

    }

  // ------------------- del 2 ------------------


    public ItemAdventure takeItem(String itemName) { //method to remove item from room

        for(ItemAdventure item : itemlist) {  // Loop through my arraylist with items

            if(item.getName().equalsIgnoreCase(itemName)) { // if the item name matches one within the list

                itemlist.remove(item); // item is removed from the list and the room
                return item;
            }
        }
        return null;  // if the item isnt found within the room null is returned
    }



    public void addItems(ItemAdventure item){
        itemlist.add(item);
        }

    public List<ItemAdventure> getItemlist(){

        return itemlist;
    }

    public void leaveItem(ItemAdventure itemToLeave) {

        itemlist.add(itemToLeave);
    }


  //------------ del 5 ----------------------


   public void addEnemy(EnemyAdventure enemy) {
        enemyList.add(enemy);
   }
   public  List<EnemyAdventure> getEnemyList() {
        return enemyList;
   }

   public EnemyAdventure getEnemy() {
        return enemyList.getFirst();
   }
















}
