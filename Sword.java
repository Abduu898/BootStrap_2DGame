/** Permanently increases the player's attack power. */
public class Sword extends Item {
    private final int boost;

    public Sword(int boost) {
        super("Sword");
        this.boost = boost;
    }

    @Override
    public void apply(Player player) {
        player.boostAttack(boost);
        System.out.println("  Picked up Sword: attack +" + boost
                + " (now " + player.getAttackPower() + ")");
    }
}