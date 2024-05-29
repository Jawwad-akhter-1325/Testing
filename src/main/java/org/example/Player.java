package org.example;
public class Player {
    private int health;
    private int strength;
    private int attack;

    @Override
    public String toString() {
        return "Player { " +
                "health=" + health +
                ", strength=" + strength +
                ", attack=" + attack +
                " }";
    }

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int damage)
    {

        this.health = Math.max(this.health - damage, 0);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public int attack(int diceRoll) {
        return this.attack * diceRoll;
    }

    public int defend(int diceRoll) {
        return this.strength * diceRoll;
    }
}
