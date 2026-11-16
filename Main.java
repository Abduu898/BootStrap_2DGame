public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);
        Player player = new Player(0, 0);

        // Enemies
        grid.getCell(2, 1).getEnemies().add(new Goblin());
        grid.getCell(1, 2).getEnemies().add(new Thief());
        grid.getCell(4, 4).getEnemies().add(new Boss());

        // Items
        grid.getCell(0, 2).getItems().add(new Potion(30));
        grid.getCell(2, 3).getItems().add(new Sword(5));
        grid.getCell(3, 1).getItems().add(new Shield(3));

        new Game(grid, player, 3).play();
    }
}