public class EnemyAdventure {

    private String name;
    private String description;
    private double health;
    private WeaponsAdventure weapon;

    public EnemyAdventure(String name, String description, double health, WeaponsAdventure weapon) {

        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public String getEnemyName(){
        return name;
    }
    public String getEnemyDescription() {
        return description;
    }
    public double getEnemyHealth() {
        return health;
    }
    public WeaponsAdventure getEnemyWeapon() {
        return weapon;
    }
    @Override
    public String toString() {
        return name + ": " + description + " / weapon: " + weapon +" / health: " + health;
    }
    public void takeDamageEnemy(WeaponsAdventure weapon) {
        health -= weapon.getDamage();
    }

}
