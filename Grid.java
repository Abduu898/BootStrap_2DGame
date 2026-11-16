/**
 * A fixed-size 2D grid. For now every cell is empty.
 */
public class Grid {
    private final int width;
    private final int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    /** @return true if (x, y) is inside the grid. */
    public boolean inBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    /** Prints the grid, with the player rendered as '@'. */
    public void display(Player player) {
        System.out.println();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (player.getX() == x && player.getY() == y) {
                    System.out.print("@ ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("Player at (" + player.getX() + ", " + player.getY() + ")");
    }
}