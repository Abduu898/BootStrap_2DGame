/**
 * Abstract item. Each subclass defines its own effect on the player.
 */
public abstract class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    /** Polymorphic hook: each item applies its own effect. */
    public abstract void apply(Player player);
}