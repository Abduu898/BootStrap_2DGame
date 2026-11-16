import java.util.ArrayList;
import java.util.List;

/**
 * A single grid cell. Holds enemies and items present there.
 */
public class Cell {
    private final List<Enemy> enemies = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();

    public List<Enemy> getEnemies() { return enemies; }
    public List<Item> getItems() { return items; }

    public boolean hasEnemies() { return !enemies.isEmpty(); }
    public boolean hasItems() { return !items.isEmpty(); }

    /** Glyph: E = enemy, I = item, . = empty. */
    public char glyph() {
        if (hasEnemies()) return 'E';
        if (hasItems()) return 'I';
        return '.';
    }
}