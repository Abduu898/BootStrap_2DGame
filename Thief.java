/**
 * An enemy that steals a random item from the player's bag.
 * If the bag is empty, it deals a small amount of damage instead.
 */
public class Thief extends Enemy {
    private final int fallbackDamage;

    public Thief() {
        super("Thief", 15);
        this.fallbackDamage = 5;
    }

    @Override
    public void attack(Player player) {
        // For now the player has no bag — so the Thief just stabs.
        // In Step 6, when items exist, we'll wire in the steal.
        System.out.println("  Thief stabs for " + fallbackDamage + " damage!");
        player.takeDamage(fallbackDamage);
    }
}