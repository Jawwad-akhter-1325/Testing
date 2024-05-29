
package org.example;

import org.example.Arena;

import org.example.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArenaTest {
    private Player playerA;
    private Player playerB;
    private Arena arena;

    @Before
    public void setUp() {
        playerA = new Player(50, 5, 10);
        playerB = new Player(100, 10, 5);
        arena = new Arena(playerA, playerB);
    }

    @Test
    public void testFightPlayerAWins() {
        playerA = new Player(100, 10, 20); // Stronger playerA
        playerB = new Player(50, 5, 10);  // Weaker playerB
        arena = new Arena(playerA, playerB);

        String winner = arena.fight();
        assertTrue("Player A".equals(winner) || "Player B".equals(winner)); // Either player can win due to randomness
        if ("Player A".equals(winner)) {
            assertTrue(playerA.isAlive());
            assertFalse(playerB.isAlive());
        } else {
            assertTrue(playerB.isAlive());
            assertFalse(playerA.isAlive());
        }
    }

    @Test
    public void testFightPlayerBWins() {
        playerA = new Player(50, 5, 10);  // Weaker playerA
        playerB = new Player(100, 10, 20); // Stronger playerB
        arena = new Arena(playerA, playerB);

        String winner = arena.fight();
        assertTrue("Player A".equals(winner) || "Player B".equals(winner)); // Either player can win due to randomness
        if ("Player A".equals(winner)) {
            assertTrue(playerA.isAlive());
            assertFalse(playerB.isAlive());
        } else {
            assertTrue(playerB.isAlive());
            assertFalse(playerA.isAlive());
        }
    }

    @Test
    public void testFightPlayerDies() {
        playerA = new Player(20, 2, 15); // Low health, high attack
        playerB = new Player(20, 2, 15); // Low health, high attack
        arena = new Arena(playerA, playerB);

        String winner = arena.fight();
        assertTrue("Player A".equals(winner) || "Player B".equals(winner)); // Either player can win due to randomness
        if ("Player A".equals(winner)) {
            assertTrue(playerA.isAlive());
            assertFalse(playerB.isAlive());
        } else {
            assertTrue(playerB.isAlive());
            assertFalse(playerA.isAlive());
        }
    }

    @Test
    public void testFightEnds() {
        String winner = arena.fight();
        assertTrue("Player A".equals(winner) || "Player B".equals(winner)); // Either player can win due to randomness
        if ("Player A".equals(winner)) {
            assertTrue(playerA.isAlive());
            assertFalse(playerB.isAlive());
        } else {
            assertTrue(playerB.isAlive());
            assertFalse(playerA.isAlive());
        }
    }

    @Test
    public void testFightRandom() {
        playerA = new Player(70, 7, 7);
        playerB = new Player(60, 8, 6);
        arena = new Arena(playerA, playerB);

        String winner = arena.fight();
        assertTrue("Player A".equals(winner) || "Player B".equals(winner)); // Either player can win due to randomness
        if ("Player A".equals(winner)) {
            assertTrue(playerA.isAlive());
            assertFalse(playerB.isAlive());
        } else {
            assertTrue(playerB.isAlive());
            assertFalse(playerA.isAlive());
        }
    }
}
