package oblig2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestCard {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        
        ArrayList<Card> reg = new ArrayList<Card>();
        
        Card k1 = new Employee("Ole Olsen", 1234);
        Card k2 = new Guest("Marit Olsen", 9999);
        Card k3 = new Employee("Aren Deutsch", 6678);
        Card k4 = new Employee("Lise Veimo", 1124);
        Card k5 = new Guest("Arnfinn Hanssen", 9999);
        Card k6 = new Guest("Bent Olsen", 9999);
        
        reg.add(k1);
        reg.add(k2);
        reg.add(k3);       
        reg.add(k4);
        reg.add(k5);
        reg.add(k6);
        
        System.out.println("Please choose test:\n");
        System.out.println("1......................CheckPIN");
        System.out.println("2......................Interface");
        System.out.println("3......................Sorting and Cloning");
        
        int test = input.nextInt();
        
        switch(test){
        case 1:
            System.out.println("\nTest of card: with pincode 1234 is" + (k1.checkPIN(1234) ?  " valid" :  " invalid" ));
            System.out.println("Test of card: with pincode 9999 is" + (k2.checkPIN(9999) ?  " valid" :  " invalid" ));
            System.out.println("Test of card: with pincode 6678 is" + (k3.checkPIN(6678) ?  " valid" :  " invalid" ));
            System.out.println("Test of card: with pincode 6678 is" + (k4.checkPIN(1124) ?  " valid" :  " invalid" ));
            System.out.println("Test of card: with pincode 6678 is" + (k5.checkPIN(9999) ?  " valid" :  " invalid" ));
            System.out.println("Test of card: with pincode 6678 is" + (k6.checkPIN(9999) ?  " valid" :  " invalid" ) + "\n");
            for (int i=0; i<reg.size(); i++) {
                Card card = (Card)reg.get(i);  
                System.out.println(card);
            }
            break;
        case 2:
            // testing interface setFullName - will override full name if true
        	// override full name of the first employee in the list
            if ((Card)reg.get(0) instanceof Constants)
            	((Constants)(Card)reg.get(0)).setFullName();
            
            // testing interface setGivenName and setSurName - will override if true
            // override given and surname of the third employee in the list
            if ((Card)reg.get(2) instanceof Constants){
            	((Constants)(Card)reg.get(2)).setGivenName();
            	((Constants)(Card)reg.get(2)).setSurName();
            }
            
            for (int i=0; i<reg.size(); i++) {
                Card card = (Card)reg.get(i);  
                System.out.println(card);
                //Testing of interface
                if (card instanceof Constants){
                	//System.out.println(((Constants) card).getGivenName());
                	//System.out.println(((Constants) card).getSurName());
                	//System.out.println(((Constants) card).getFullName());
                	System.out.println("Credit = " + ((Constants) card).calculateCredit());
                	System.out.println("Bonus = " + ((Constants) card).calculateBonus());
                }
            }
            break;
        case 3:
            //Sorting list
            Collections.sort(reg);
            System.out.println("\nSorted list [reg] by surname/givenname:");            
            System.out.println(reg);
            
            //Cloning reg list
            ArrayList<Card> reg1 = (ArrayList<Card>)reg.clone();
            //adding new guest to the cloned list
            Card k7 = new Guest("Brynjar Deutsch", 9999);
            reg1.add(k7);
            
            System.out.println("reg size = " + reg.size() + " reg1 size = " + reg1.size());
            //Sorting the cloned list
            Collections.sort(reg1);
            System.out.println("\nSorted cloned list [reg1] by surname/givenname:");            
            System.out.println(reg1);
            break;
        default:
        	System.out.println("Not a valid selection. Try again");
        	System.exit(0);       	

        }      
        input.close();
        
    }
	

}
