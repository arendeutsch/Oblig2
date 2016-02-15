package oblig2;

public class Employee extends Card{
	
	public Employee(){		
	}
	
	public Employee(String name, int pincode){
		super(name,pincode);		
	}	
	
	
	@Override
	public boolean checkPIN(int pincode) {		
		int day = dateTime.get(dateTime.DAY_OF_WEEK);
		int time = dateTime.get(dateTime.HOUR_OF_DAY);
		//System.out.println("DAY OF WEEK: " + day + "HOUR OF DAY: " + time);
		
		if (day == 1 || day == 7) // sunday or saturday
			super.accessDenided = true; // card is blocked, use pin
		else if ((day != 1 || day!=7) && (time < 7 || time > 17)) //not sunday or not saturday but outside office hours    
			super.accessDenided = true; // card is blocked, use pin
		else
			super.accessDenided = false;
		
		if (pincode != this.pincode)
			return false;
		else
			return true;

	}	

}
