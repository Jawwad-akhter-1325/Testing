package org.example;

public class Arena
{
    private Player playerA;
    private Player playerB;
    private String attackerName;
    private String defenderName;
    private Dice dice;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    void decideAttackerandDefenderName(boolean flag)
    {
        if(flag==true)
        {
            attackerName="Player A";
            defenderName="Player B";
        }
        else{
            attackerName="Player B";
            defenderName="Player A";
        }

    }


    public String fight()
    {
        Player attacker;
        Player defender;

        // Determine initial attacker and defender based on health
        boolean PlayerAasAttacker=true;
        if (playerA.getHealth() < playerB.getHealth())
        {
            attacker = playerA;
            defender = playerB;
            PlayerAasAttacker=true;
        }
        else
        {
            attacker = playerB;
            defender = playerA;
            PlayerAasAttacker=false;
        }




        while (attacker.isAlive() && defender.isAlive())
        {
            decideAttackerandDefenderName(PlayerAasAttacker);
            int attackRoll = dice.roll();
            int defendRoll = dice.roll();

            int attackDamage = attacker.attack(attackRoll);
            int defendStrength = defender.defend(defendRoll);
            int damageToDefender = Math.max(attackDamage - defendStrength, 0);

            defender.reduceHealth(damageToDefender);

            System.out.println(attackerName + " attacks " + defenderName);
            System.out.println("Attack roll: " + attackRoll + ", Damage: " + attackDamage);
            System.out.println(defenderName + " defends");
            System.out.println("Defend roll: " + defendRoll + ", Defense: " + defendStrength);
            System.out.println(defenderName + " health: " + defender.getHealth());

            // Swap attacker and defender
            Player temp = attacker;
            attacker = defender;
            defender = temp;
            PlayerAasAttacker=!PlayerAasAttacker;
        }


        decideAttackerandDefenderName(PlayerAasAttacker);
        if(attacker.isAlive())
        {
            return attackerName;
        }
        else{
            return defenderName;
        }
    }
}
