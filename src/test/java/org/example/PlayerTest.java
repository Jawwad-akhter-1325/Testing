package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp()
    {
        player = new Player(50, 5, 10);
    }

    @Test
    public void testAttack()
    {
        int diceRoll = 3;
        int expectedDamage = 10 * diceRoll;
        assertEquals(expectedDamage, player.attack(diceRoll));
    }

    @Test
    public void testDefend() {
        int diceRoll = 4;
        int expectedDefense = 5 * diceRoll;
        assertEquals(expectedDefense, player.defend(diceRoll));
    }

    @Test
    public void testReduceHealthPositive() {
        player.reduceHealth(20);
        assertEquals(30, player.getHealth());
    }

    @Test
    public void testReduceHealthToZero() {
        player.reduceHealth(50);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testReduceHealthNegative() {
        player.reduceHealth(60);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testIsAlivePositive() {
        assertTrue(player.isAlive());
    }
//
    @Test
    public void testIsAliveNegative() {
        player.reduceHealth(50);
        assertFalse(player.isAlive());
    }
    @Test
    public void testIsAlive() {
        Player newplayer = new Player( 50, 5, 10);
        assertTrue(newplayer.isAlive());
        newplayer.reduceHealth(50);
        assertFalse(newplayer.isAlive());
    }
}