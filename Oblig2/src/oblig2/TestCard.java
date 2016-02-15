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
        
        System.out.println("Test of card: with pincode 1234 is" + (k1.checkPIN(1234) ?  " valid" :  " invalid" ) );
        System.out.println("Test of card: with pincode 9999 is" + (k2.checkPIN(9999) ?  " valid" :  " invalid" ) );
        System.out.println("Test of card: with pincode 6678 is" + (k3.checkPIN(6678) ?  " valid" :  " invalid" ) + "\n");
     
        for (int i=0; i<reg.size(); i++) {
            Card card = (Card)reg.get(i);  
            System.out.println(card);
        }
    }

}
