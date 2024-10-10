public class FoodAdventure extends ItemAdventure {

    private double healthPoints;

    public FoodAdventure(String name, String description, double healthPoints){
        super(name, description);
        this.healthPoints = healthPoints;
    }

    public double getHealthPoints(){
        return healthPoints;
    }
}
