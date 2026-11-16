import java.util.Scanner;

/**
 * Main game loop. Reads a direction, moves the player, resolves whatever
 * is in the destination cell, and redraws the grid.
 */
public class Game {
    private final Grid grid;
    private final Player player;
    private final CombatManager combat = new CombatManager();
    private final Scanner sc = new Scanner(System.in);
    private final int totalEnemies;
    private int enemiesDefeated = 0;

    public Game(Grid grid, Player player, int totalEnemies) {
        this.grid = grid;
        this.player = player;
        this.totalEnemies = totalEnemies;
    }

    public void play() {
        System.out.println("=== GRID QUEST ===");
        System.out.println("Defeat all " + totalEnemies + " enemies!");
        System.out.println("8=up  2=down  4=left  6=right  0=quit");

        boolean running = true;
        while (running && player.getHp() > 0 && enemiesDefeated < totalEnemies) {
            grid.display(player);
            System.out.print("> ");
            int dir = sc.nextInt();

            int dx = 0, dy = 0;
            switch (dir) {
                case 8: dy = -1; break;
                case 2: dy =  1; break;
                case 4: dx = -1; break;
                case 6: dx =  1; break;
                case 0:
                    System.out.println("Bye.");
                    running = false;
                    continue;
                default:
                    System.out.println("Invalid input.");
                    continue;
            }

            int nx = player.getX() + dx;
            int ny = player.getY() + dy;
            if (!grid.inBounds(nx, ny)) {
                System.out.println("You cannot leave the grid.");
                continue;
            }

            player.move(dx, dy);
            resolveCell(grid.getCell(nx, ny));
        }

        if (player.getHp() <= 0) {
            System.out.println("\n=== GAME OVER === You died.");
        } else if (enemiesDefeated >= totalEnemies) {
            System.out.println("\n=== VICTORY === All enemies defeated!");
        }
        sc.close();
    }

    private void resolveCell(Cell cell) {
        if (cell.hasEnemies()) {
            int before = cell.getEnemies().size();
            boolean survived = combat.fightAll(player, cell.getEnemies());
            enemiesDefeated += before - cell.getEnemies().size();
            if (!survived) return;
        }
        if (cell.hasItems()) {
            combat.lootAll(player, cell.getItems());
        }
    }
}