package oblig2;

import java.util.*;

public abstract class Card {
	protected String name;
	protected String cardnr;
	protected boolean accessDenided;
	protected int pincode;
	protected java.util.GregorianCalendar dateTime;
	
	Scanner input = new Scanner(System.in);
	
	public Card(){			
	}
	
	public Card (String name, int pincode){
		this.name=name;
		this.pincode=pincode;
		this.accessDenided = false;
		this.dateTime = new java.util.GregorianCalendar();	
		//Generates random max 4 digits card number and convert it to string
		int cardnunmber = (int)(1 + Math.random()*9999);
		this.cardnr = Integer.toString(cardnunmber);
		
	}
	
	public void setAll(){			
		System.out.println("Please eneter card holder's name: ");
		this.name = input.nextLine();
		System.out.println("Please eneter pincode(4 digits): ");
		this.pincode = input.nextInt();
		
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isBlocked(){		
		return accessDenided;
	}
	
	public String toString(){
		return "Card holder's name: " + name + " card number: " + cardnr + " PIN code: " + pincode + " Card status(is PIN required?): " + accessDenided; 
	}
	
	public abstract boolean checkPIN(int pincode);

}
