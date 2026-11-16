/** Permanently reduces incoming damage taken by the player. */
public class Shield extends Item {
    private final int reduction;

    public Shield(int reduction) {
        super("Shield");
        this.reduction = reduction;
    }

    @Override
    public void apply(Player player) {
        player.boostDefense(reduction);
        System.out.println("  Picked up Shield: defense +" + reduction
                + " (now " + player.getDefense() + ")");
    }
}