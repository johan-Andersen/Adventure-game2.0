public class WeaponsAdventure extends ItemAdventure {


   private double damage;
   private double ammunition;

    public WeaponsAdventure(String name, String description, double damage, double ammunition) {

        super(name, description);
        this.damage = damage;
        this.ammunition = ammunition;
    }


    public double getDamage() {
        return damage;
    }

   public double getAmmunition() {
        return ammunition;
   }

   public void useAmmunition() {
        if(ammunition > 0) {
            ammunition--;
        }
        else {
            System.out.println("");
        }
   }



}
