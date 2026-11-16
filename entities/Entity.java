package entities;

public abstract class Entity {
    protected String name;
    protected int hp;
    protected int maxHp;

    public Entity(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public boolean isAlive() { return hp > 0; }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }

    public void takeDamage(int dmg) {
        hp = Math.max(0, hp - dmg);
    }
}