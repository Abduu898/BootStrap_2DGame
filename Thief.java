import java.util.Random;

/**
 * An enemy that steals from the player. Each turn it either drains HP
 * or weakens the player's attack power.
 */
public class Thief extends Enemy {
    private final Random rng = new Random();

    public Thief() {
        super("Thief", 15);
    }

    @Override
    public void attack(Player player) {
        if (rng.nextBoolean()) {
            int stolen = player.drainHp(5);
            System.out.println("  Thief drains " + stolen + " HP!");
        } else {
            player.weakenAttack(2);
            System.out.println("  Thief weakens your attack! (ATK now "
                    + player.getAttackPower() + ")");
        }
    }
}