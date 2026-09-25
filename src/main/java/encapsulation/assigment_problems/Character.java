package encapsulation.assigment_problems;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        this.health = Math.max(0, this.health - amount);
        System.out.println("c.takeDamage(" + amount + ") -> health = " + this.health + (this.health == 0 ? " (floored)" : ""));
    }

    public void heal(int amount) {
        this.health = Math.min(this.maxHealth, this.health + amount);
        System.out.println("c.heal(" + amount + ") -> health = " + this.health + (this.health == this.maxHealth ? " (capped)" : ""));
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}