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

    public Game(Grid grid, Player player) {
        this.grid = grid;
        this.player = player;
    }

    public void play() {
        System.out.println("=== GRID QUEST ===");
        System.out.println("8=up  2=down  4=left  6=right  0=quit");

        boolean running = true;
        while (running && player.getHp() > 0) {
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
        }
        sc.close();
    }

    /** Applies combat to the cell the player just entered. */
    private void resolveCell(Cell cell) {
        if (cell.hasEnemies()) {
            combat.fightAll(player, cell.getEnemies());
        }
    }
}