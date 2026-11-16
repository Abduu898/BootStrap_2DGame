

import entities.Entity;

public abstract class Enemy extends Entity {
    public Enemy(String name, int hp) {
        super(name, hp);
    }

    /** Polymorphic hook: each enemy attacks in its own way. */
    public abstract void attack(Player player);
}