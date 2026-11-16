/**
 * The player-controlled character.
 */
public class Player {
    private int x;
    private int y;
    private int hp;
    private int maxHp;
    private final int attackPower;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.hp = 100;
        this.maxHp = 100;
        this.attackPower = 10;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttackPower() { return attackPower; }

    public void move(int dx, int dy) { x += dx; y += dy; }

    public void takeDamage(int dmg) {
        hp = Math.max(0, hp - dmg);
    }
}