package oblig2;

import java.util.Scanner;

public class Employee extends Card implements Constants{
	private static double factor = 0.8;
	private double hourWage;
	private int seniority;
	Scanner input = new Scanner(System.in);
	Scanner scanner = new Scanner(System.in);
	
	public Employee(){		
	}
	
	public Employee(String name, int pincode){
		super(name,pincode);
		System.out.println("Please enter hourly wage: ");
		this.hourWage = input.nextDouble();
		System.out.println("Please enter service seniority[years]: ");
		this.seniority = input.nextInt();
		
	}	
	
	
	@Override
	public boolean checkPIN(int pincode) {		
		int day = dateTime.get(dateTime.DAY_OF_WEEK);
		int time = dateTime.get(dateTime.HOUR_OF_DAY);
		//System.out.println("DAY OF WEEK: " + day + "HOUR OF DAY: " + time);
		
		if (day == 1 || day == 7) // sunday or saturday
			super.accessDenided = true; // card is blocked, use pin
		else if (time <= 7 || time >= 17) //not sunday or not saturday but outside office hours    
			super.accessDenided = true; // card is blocked, use pin
		else
			super.accessDenided = false;
		
		if (pincode != this.pincode)
			return false;
		else
			return true;

	}

	@Override
	public void setGivenName() {
		String surname = this.getSurName();
		System.out.println("Please enter a given name in order to override, otherwise type the same name: ");
		String firstname = input.next();
		firstname = firstname.concat(" "); // inserting space
		super.name = firstname.concat(surname);
		
	}

	@Override
	public String getGivenName() {
		int indexSpace = name.indexOf(" ");
		return name.substring(0, indexSpace);
	}

	@Override
	public void setSurName() {
		String firstname = this.getGivenName();
		firstname = firstname.concat(" "); // inserting space
		System.out.println("Please enter a surname to override, otherwise type the same surname: ");
		String surname = input.next();
		super.name = firstname.concat(surname);
		
	}

	@Override
	public String getSurName() {
		int indexSpace = name.indexOf(" ");
		return name.substring(indexSpace+1);
	}

	@Override
	public void setFullName() {
		System.out.println("Please enter full name to override, otherwise type the same full name: ");
		super.name = scanner.nextLine();
			
	}

	@Override
	public String getFullName() {
		return name;
	}

	@Override
	public double calculateCredit() {
		return factor*hourWage;
	}

	@Override
	public double calculateBonus() {
		return factor*seniority;
	}
	

}
