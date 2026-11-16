/** Heals the player by a fixed amount. */
public class Potion extends Item {
    private final int heal;

    public Potion(int heal) {
        super("Potion");
        this.heal = heal;
    }

    @Override
    public void apply(Player player) {
        player.heal(heal);
        System.out.println("  Picked up Potion: +" + heal + " HP (now "
                + player.getHp() + "/" + player.getMaxHp() + ")");
    }
}