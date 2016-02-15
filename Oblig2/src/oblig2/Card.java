package oblig2;

import java.util.*;

public abstract class Card implements Comparable<Card>, Cloneable{
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
		return "Card holder's name: " + name + " card number: " + cardnr + " PIN code: " + pincode + " Card status(is PIN required?): " + accessDenided + "\n"; 
	}
	
	
	@Override
	public int compareTo(Card card){
		int indexSpace = getName().indexOf(" ");
		String lastname = getName().substring(indexSpace+1);
		//System.out.println("last name: " + lastname);
		
		int indexSpaceCard = card.getName().indexOf(" ");
		String lastnameCard = card.getName().substring(indexSpaceCard+1);
		
	//	System.out.println("last name Card: " + lastnameCard);
	//	int result = lastname.compareTo(lastnameCard);
	
		//System.out.println("compare result = " + result);
		
		if (lastname.compareTo(lastnameCard) > 0)			
			return 1;
		else if (lastname.compareTo(lastnameCard) < 0)
			return -1;
		else{ // Last name is equal, sort on first name
			//System.out.println("equal last name");
			String firstname = getName().substring(0, indexSpace);
			String firstnameCard = card.getName().substring(0, indexSpace);
			if (firstname.compareTo(firstnameCard) > 0)
				return 1;
			else if (firstname.compareTo(firstnameCard) < 0)
				return -1;
			else				
			return 0;		
		}
	}
	
	@Override
	public Object clone(){
		try{	
			Card listClone = (Card)super.clone();						
			return listClone;
		}
		catch (CloneNotSupportedException ex){
			return null;
		}
		
	}
	
	public abstract boolean checkPIN(int pincode);

}
