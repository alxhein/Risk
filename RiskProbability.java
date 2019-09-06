
/**
 * Write a description of class RiskProbability here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.text.*;
public class RiskProbability
{
    public static void main(String[]args)
    {
        Scanner in = new Scanner(System.in);
        NumberFormat formatter = new DecimalFormat("#0.00%");
        int attack = 0;
        int defense = 0;
        int trials = 200000;
        int attackWins = 0;
        int defenseWins = 0;
        double remainingAttack = 0;
        double aProb = 0;
        double dProb = 0;
        
        System.out.println("***********************************");
        System.out.println("* THE RISK PROBABILITY CALCULATOR *");
        System.out.println("***********************************");
        System.out.println();
        System.out.print("Number of attacking troops: ");
        attack = in.nextInt();
        System.out.print("Number of defending troops: ");
        defense = in.nextInt();
        System.out.println();
        System.out.println("Computing...");
        System.out.println();
        
        
        for(int i=0; i<trials; i++)
        {
            Risk x = new Risk(attack, defense);
            x.battleNoPrint();
            if(x.getAttack() == 0)
            {
                defenseWins++;
            }
            else if(x.getDefense() == 0)
            {
                attackWins++;
                remainingAttack+= x.getAttack();
            }
        }
        
        aProb = ((double)attackWins/(double)trials);
        dProb = ((double)defenseWins/(double)trials);
        remainingAttack = remainingAttack/trials;
        
        System.out.println("Total Trials: " + trials);
        System.out.println("Attacker Wins: " + attackWins);
        System.out.println("Defender Wins: " + defenseWins);
        System.out.println("Attacker's probability of winning: " + formatter.format(aProb));
        System.out.println("Defender's probability of winning: " + formatter.format(dProb));
        System.out.println("Remaining attackers: " + remainingAttack);
    }
}
