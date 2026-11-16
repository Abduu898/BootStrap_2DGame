import java.util.List;

/**
 * Resolves combat between the player and the enemies of a cell.
 */
public class CombatManager {

    /**
     * Fights all enemies in the list one after another.
     * Each round: the enemy attacks first, then the player retaliates.
     * Dead enemies are removed from the list.
     *
     * @return true if the player survived the fight
     */
    public boolean fightAll(Player player, List<Enemy> enemies) {
        while (!enemies.isEmpty() && player.getHp() > 0) {
            Enemy enemy = enemies.get(0);
            System.out.println(">> Fighting " + enemy.getName()
                    + " (" + enemy.getHp() + "/" + enemy.getMaxHp() + " HP)");

            enemy.attack(player);
            if (player.getHp() <= 0) break;

            enemy.takeDamage(player.getAttackPower());
            System.out.println("   You hit " + enemy.getName()
                    + " for " + player.getAttackPower()
                    + " (enemy HP: " + enemy.getHp() + ")");

            if (!enemy.isAlive()) {
                System.out.println("   " + enemy.getName() + " is defeated!");
                enemies.remove(enemy);
            }
        }
        return player.getHp() > 0;
    }

    /** Applies every item in the list to the player, then clears it. */
    public void lootAll(Player player, List<Item> items) {
        for (Item item : items) item.apply(player);
        items.clear();
    }
}