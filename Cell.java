

import java.util.ArrayList;
import java.util.List;

/**
 * A single grid cell. Holds the enemies (and later, items) present there.
 */
public class Cell {
    private final List<Enemy> enemies = new ArrayList<>();

    public List<Enemy> getEnemies() { return enemies; }

    public boolean hasEnemies() { return !enemies.isEmpty(); }

    /** Glyph used when displaying the grid. */
    public char glyph() {
        return hasEnemies() ? 'E' : '.';
    }
}