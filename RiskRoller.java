
/**
 * The main program for simulating Risk dice roll, utilizing the Risk class.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class RiskRoller
{
    public static void main(String[]args)
    {
        Scanner in = new Scanner(System.in);
        int attack = 0;
        int defense = 0;
        
        System.out.println("**********************************");
        System.out.println("* THE AUTOMATIC RISK DICE ROLLER *");
        System.out.println("**********************************");
        System.out.println();
        System.out.print("Number of attacking troops: ");
        attack = in.nextInt();
        System.out.print("Number of defending troops: ");
        defense = in.nextInt();
        System.out.println();
        
        Risk a = new Risk(attack, defense);
        a.battle();
    }
}
