public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);
        Player player = new Player(0, 0);

        // Place one Goblin at (2, 1)
        grid.getCell(2, 1).getEnemies().add(new Goblin());

        new Game(grid, player).play();
    }
}