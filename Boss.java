/**
 * A high-HP enemy that hits hard and heals itself every turn (life-steal).
 */
public class Boss extends Enemy {
    private final int damage;
    private final int lifesteal;

    public Boss() {
        super("Boss", 60);
        this.damage = 15;
        this.lifesteal = 5;
    }

    @Override
    public void attack(Player player) {
        System.out.println("  Boss strikes for " + damage
                + " damage and drains " + lifesteal + " HP!");
        player.takeDamage(damage);
        hp = Math.min(maxHp, hp + lifesteal);
    }
}