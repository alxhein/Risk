
/**
 * The algorithm for a risk battle, simulating 3 attacker dice and 2 defender dice.
 *
 * @author Alex Hein
 * @version 4/19/18
 */
import java.util.*;
public class Risk
{
    private int attack;
    private int defense;
    private int battleCount;
    public Risk(int attack, int defense)
    {
        this.attack = attack;
        this.defense = defense;
        battleCount = 0;
    }
    
    public int getAttack()
    {
        return attack;
    }
    
    public int getDefense()
    {
        return defense;
    }
    
    public void roll()
    {
        battleCount++;
        Random r = new Random();
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> d = new ArrayList<Integer>();
        
        a.add(new Integer(r.nextInt(6)+1)); 
        if(attack>2)
        {
            a.add(new Integer(r.nextInt(6)+1)); 
            a.add(new Integer(r.nextInt(6)+1)); 
        }
        else if(attack>1)
        {
            a.add(new Integer(r.nextInt(6)+1)); 
        }
        
        d.add(new Integer(r.nextInt(6)+1));
        if(defense>1)
        {
            d.add(new Integer(r.nextInt(6)+1));
        }
        
        Collections.sort(a);
        Collections.reverse(a);
        Collections.sort(d);
        Collections.reverse(d);
        
        if(d.get(0) >= a.get(0))
        {
            attack--;
        }
        else if(d.get(0)<a.get(0))
        {
            defense--;
        }
        if(d.size()>1 && a.size()>1)
        {
            if(d.get(1) >= a.get(1))
            {
                attack--;
            }
            else if(d.get(1)<a.get(1))
            {
                defense--;
            }
        }
        
        System.out.println("BATTLE #" + battleCount);
        System.out.println("    Attack Roll: " + a);
        System.out.println("    Defense Roll: " + d);
        System.out.println("    RESULT: " + attack + ", " + defense);
    }
    
    public void rollNoPrint()
    {
        battleCount++;
        Random r = new Random();
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> d = new ArrayList<Integer>();
        
        a.add(new Integer(r.nextInt(6)+1)); 
        if(attack>2)
        {
            a.add(new Integer(r.nextInt(6)+1)); 
            a.add(new Integer(r.nextInt(6)+1)); 
        }
        else if(attack>1)
        {
            a.add(new Integer(r.nextInt(6)+1)); 
        }
        
        d.add(new Integer(r.nextInt(6)+1));
        if(defense>1)
        {
            d.add(new Integer(r.nextInt(6)+1));
        }
        
        Collections.sort(a);
        Collections.reverse(a);
        Collections.sort(d);
        Collections.reverse(d);
        
        if(d.get(0) >= a.get(0))
        {
            attack--;
        }
        else if(d.get(0)<a.get(0))
        {
            defense--;
        }
        if(d.size()>1 && a.size()>1)
        {
            if(d.get(1) >= a.get(1))
            {
                attack--;
            }
            else if(d.get(1)<a.get(1))
            {
                defense--;
            }
        }
    }
    
    public void battle()
    {
        while(attack>0 && defense>0)
        {
            roll();
        }
        if(attack==0)
        {
            System.out.println("\nDEFENDER WINS!!!");
        }
        else if(defense==0)
        {
            System.out.println("\nATTACKER WINS!!!");
        }
    }
    
    public void battleNoPrint()
    {
        while(attack>0 && defense>0)
        {
            rollNoPrint();
        }
    }
}
