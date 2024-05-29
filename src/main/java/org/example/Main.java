package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        List<Player> players = new ArrayList<>();
        players.add(new Player( 50, 5, 10));
        players.add(new Player( 100, 10, 5));
        players.add(new Player( 70, 7, 7));
        players.add(new Player( 60, 8, 6));

        Random random = new Random();
        Arena arena ;
        while (true)
        {
            int index1 = random.nextInt(players.size());
            int index2;
            do {
                index2 = random.nextInt(players.size());
            } while (index1 == index2);

            Player player1 = players.get(index1);
            Player player2 = players.get(index2);

            System.out.println("\nMatch between ");
            System.out.println("Player A : "+player1.toString());
            System.out.println("Player B : "+player2.toString());


            arena= new Arena(player1,player2);
            String finalWinner= arena.fight();

            if (!player1.isAlive()) {
                System.out.println("Player A" + " has died.");
                players.remove(player1);
            }
            if (!player2.isAlive()) {
                System.out.println("Player B" + " has died.");
                players.remove(player2);
            }
            System.out.println("The Winner is : "+finalWinner);
            System.out.println("<--------------------------------------------------->");


            if (players.size() < 2) {
                System.out.println("Not enough players to continue.");
                break;
            }
        }
    }
}
