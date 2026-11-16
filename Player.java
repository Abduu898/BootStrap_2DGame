import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The player-controlled character. Holds position, HP, stats, and inventory.
 */
public class Player {
    private int x;
    private int y;
    private int hp;
    private int maxHp;
    private int attackPower;
    private int defense;
    private final List<Item> inventory = new ArrayList<>();

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.hp = 100;
        this.maxHp = 100;
        this.attackPower = 10;
        this.defense = 0;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttackPower() { return attackPower; }
    public int getDefense() { return defense; }
    public List<Item> getInventory() { return inventory; }

    public void move(int dx, int dy) { x += dx; y += dy; }

    /** Heals up to maxHp. */
    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
    }

    public void boostAttack(int n) { attackPower += n; }
    public void boostDefense(int n) { defense += n; }
    public void addItem(Item item) { inventory.add(item); }

    /** Drains HP from the player (used by the Thief). */
    public int drainHp(int amount) {
        int stolen = Math.min(amount, hp);
        hp -= stolen;
        return stolen;
    }

    /** Reduces attack power, never below 0. */
    public void weakenAttack(int amount) {
        attackPower = Math.max(0, attackPower - amount);
    }

    /** Removes and returns a random item, or null if the bag is empty. */
    public Item removeRandomItem() {
        if (inventory.isEmpty()) return null;
        Random rng = new Random();
        return inventory.remove(rng.nextInt(inventory.size()));
    }

    /** Damage is reduced by defense (min 0). */
    public void takeDamage(int dmg) {
        int effective = Math.max(0, dmg - defense);
        hp = Math.max(0, hp - effective);
    }
}