import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Adventure {

    private MapAdventure map;
    private PlayerAdventure player;

    public Adventure() {
        map = new MapAdventure();
        player = new PlayerAdventure(map.getRoom(), 100);

    }

    public PlayerAdventure getPlayer() {
        return player;
    }

    public List<EnemyAdventure> IsEnemyListEmpty () {
        return getPlayer().getCurrentRoom().getEnemyList();
    }
    public List<EnemyAdventure> getEnemyListA(){
        return getPlayer().getCurrentRoom().getEnemyList();
    }
    public void takeDamageEnemyA(WeaponsAdventure weapon) {
        getPlayer().getCurrentRoom().getEnemy().takeDamageEnemy(weapon);
    }
    public double getEnemyHealthA() {
        return getPlayer().getCurrentRoom().getEnemy().getEnemyHealth();
    }
    public String getEnemyNameA() {
        return getPlayer().getCurrentRoom().getEnemy().getEnemyName();
    }
    public WeaponsAdventure getEnemyWeaponA(){
        return getPlayer().getCurrentRoom().getEnemy().getEnemyWeapon();
    }

    public void addItemsA(ItemAdventure item) {
        getPlayer().getCurrentRoom().addItems(item);
    }

    public void takeDamagePlayerA(WeaponsAdventure weapon) {
        getPlayer().takeDamagePlayer(weapon);
    }
    public WeaponsAdventure getPlayerWeaponA() {
        return getPlayer().getPlayerWeapon();
    }
    public double getPlayerHealthA() {
        return getPlayer().getHealth();
    }
    public ArrayList<ItemAdventure> getEquippedWeaponA() {
        return getPlayer().getEquippedWeapon();
    }
    public ArrayList<ItemAdventure> getItemListInventoryA() {
        return getPlayer().getItemListInventory();
    }
    public void addWeapontoEquippedA(ItemAdventure weapon) {
        getPlayer().addweaponToEquipped(weapon);
    }
    public List<ItemAdventure> getItemListA() {
        return getPlayer().getCurrentRoom().getItemlist();
    }
    public double consumeA(FoodAdventure food) {
        return getPlayer().consume(food);
    }
    public ItemAdventure takeItemA(String itemName) {
        return getPlayer().getCurrentRoom().takeItem(itemName);
    }
    public void addItemToInventoryA(ItemAdventure item) {
        getPlayer().addItemToInventory(item);
    }
    public void leaveItemA(ItemAdventure itemToLeave) {
        getPlayer().getCurrentRoom().leaveItem(itemToLeave);
    }
    public String getRoomName() {
        return getPlayer().getCurrentRoom().getName();
    }
    public String roomToString() {
        return getPlayer().getCurrentRoom().toString();
    }


}
