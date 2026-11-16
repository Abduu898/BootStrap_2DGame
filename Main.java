public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);
        Player player = new Player(0, 0);
        new Game(grid, player).play();
    }
}