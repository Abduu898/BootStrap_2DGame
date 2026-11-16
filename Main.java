public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);
        Player player = new Player(0, 0);

        // One of each enemy type
        grid.getCell(2, 1).getEnemies().add(new Goblin());
        grid.getCell(1, 2).getEnemies().add(new Thief());
        grid.getCell(4, 4).getEnemies().add(new Boss());

        new Game(grid, player).play();
    }
}
