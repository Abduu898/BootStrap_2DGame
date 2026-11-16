

public class Goblin extends Enemy {
    private final int damage;

    public Goblin() {
        super("Goblin", 25);
        this.damage = 8;
    }

    @Override
    public void attack(Player player) {
        System.out.println("  Goblin slashes for " + damage + " damage!");
        player.takeDamage(damage);
    }
}