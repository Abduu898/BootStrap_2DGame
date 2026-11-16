/**
 * A fixed-size 2D grid of Cells.
 */
public class Grid {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                cells[y][x] = new Cell();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Cell getCell(int x, int y) {
        return cells[y][x];
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void display(Player player) {
        System.out.println();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (player.getX() == x && player.getY() == y) {
                    System.out.print("@ ");
                } else {
                    System.out.print(cells[y][x].glyph() + " ");
                }
            }
            System.out.println();
        }
        System.out.println("HP " + player.getHp() + "/" + player.getMaxHp()
                + " | Player at (" + player.getX() + ", " + player.getY() + ")");
    }
}