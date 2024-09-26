public class Room {

    private String name;
    private String surroundings;
    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom; 


    public Room(String name,String surroundings) {
        this.name = name;
        this.surroundings = surroundings;

    }

    public String getName(){
        return name;
    }
    public String getSurroundings(){
        return surroundings;
    }

    public String toString(){
        return "you're in: " + name + ". " + surroundings;

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














}
