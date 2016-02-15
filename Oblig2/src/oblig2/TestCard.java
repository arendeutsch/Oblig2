package oblig2;

import java.util.ArrayList;

public class TestCard {
	public static void main(String[] args) {
        
        ArrayList<Card> reg = new ArrayList<Card>();
        
        Card k1 = new Employee("Ole Olsen", 1234);
        Card k2 = new Guest("Marit Olsen", 9999);
        Card k3 = new Employee("Aren Deutsch", 6678);
        reg.add(k1);
        reg.add(k2);
        reg.add(k3);       
        
        // testing interface setFullName - will override full name if true
        if ((Card)reg.get(0) instanceof Constants)
        	((Constants)(Card)reg.get(0)).setFullName();
        
        // testing interface setGivenName and setSurName - will override if true
        if ((Card)reg.get(2) instanceof Constants){
        	((Constants)(Card)reg.get(2)).setGivenName();
        	((Constants)(Card)reg.get(2)).setSurName();
        }
        
        for (int i=0; i<reg.size(); i++) {
            Card card = (Card)reg.get(i);  
            System.out.println(card);
            //Testing of interface
            if (card instanceof Constants){
            	System.out.println(((Constants) card).getGivenName());
            	System.out.println(((Constants) card).getSurName());
            	System.out.println(((Constants) card).getFullName());
            	System.out.println("Credit = " + ((Constants) card).calculateCredit());
            	System.out.println("Bonus = " + ((Constants) card).calculateBonus());
            }
        }
        
        System.out.println("\nTest of card: with pincode 1234 is" + (k1.checkPIN(1234) ?  " valid" :  " invalid" ) );
        System.out.println("Test of card: with pincode 9999 is" + (k2.checkPIN(9999) ?  " valid" :  " invalid" ) );
        System.out.println("Test of card: with pincode 6678 is" + (k3.checkPIN(6678) ?  " valid" :  " invalid" ) + "\n");
        
    }

}
