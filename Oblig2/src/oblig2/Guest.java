package oblig2;

public class Guest extends Card{
	
	public Guest(){		
	}
	
	public Guest(String name, int pincode){
		super(name,pincode);			
	}
	
	
	@Override
	public boolean checkPIN(int pincode) {
		int dayCreated = super.dateTime.get(super.dateTime.DAY_OF_YEAR); 
		int dayExpired = super.dateTime.get(super.dateTime.DAY_OF_YEAR)+7; // guest card is valid only for 7 days
		java.util.GregorianCalendar calender = new java.util.GregorianCalendar(); 		
		int today = calender.get(calender.DAY_OF_YEAR);	// todays day in order to check against created day	
		int day = dateTime.get(dateTime.DAY_OF_WEEK);
		int time = dateTime.get(dateTime.HOUR_OF_DAY);

		
		if (today == dayExpired){ // card is expired after one week. pin code is invalid as well
			super.accessDenided = true;
			return false;
		}
		else
			super.accessDenided = false;
		
		if (day == 1 || day == 7) // sunday or saturday
			super.accessDenided = true; // card is blocked, use pin
		else if (time <= 7 || time >= 17) //not sunday or not saturday but outside office hours  
			super.accessDenided = true; // card is blocked, use pin
		else
			super.accessDenided = false;
		
		if (pincode != this.pincode) // check pin code. guest card pin is always 9999
			return false;
		else
			return true;
	}	

}


