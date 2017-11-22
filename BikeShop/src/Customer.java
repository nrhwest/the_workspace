/**
 * Nathan West
 * CSMC 255
 * Project 6
 * Customer Class
 * 
 * This class creates a customer and allows the Customer
 * to purchase a bike of type Bicycle
 */

import java.util.ArrayList;

public class Customer {

	// declare instance variables
	private int counter = 0;
	private String first, last, phone, email;
	private ArrayList<Bicycle> bikes = new ArrayList<Bicycle>();
	
	// default Customer constructor w/ initialized ins variables
	public Customer() {
		first = "unknown";
		last = "unknown";
		phone = "unknown";
		email = "unknown";
	}
	
	// parameterized Customer constructor setting ins variables
	public Customer(String first, String last, String phone, String email, ArrayList bike) {
		setFirstName(first);
		setLastName(last);
		setPhoneNumber(phone);
		setEmailAddress(email);
		bikes = bike;
	}
	
	// returns first name
	public String getFirstName() {
		return first;
	}
	
	// sets the first name of Customer
	public void setFirstName(String first) {
		if (!first.matches("^[\\p{L} . '-]+$")) {
			throw new IllegalArgumentException("First name cannot be blank!");
		} else 
			this.first = first;
	}
	
	// returns last name
	public String getLastName() {
		return last;
	}
	
	// sets the last name of Customer
	public void setLastName(String last) {
		if (!last.matches("^[\\p{L} . '-]+$")) {
			throw new IllegalArgumentException("Last name cannot be blank!");
		} else 
			this.last = last;
	}
	
	// returns the phone number of Customer
	public String getPhoneNumber() {
		return phone;
	}
	
	// sets the phone number of Customer
	public void setPhoneNumber(String phone) {
		if (phone.matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$"))
			this.phone = phone;
		else
			throw new IllegalArgumentException();
		
	}
	
	// returns the email address of Customer
	public String getEmailAddress() {
		return email;
	}
	
	// sets the email address of Customer
	public void setEmailAddress(String email) {
		if (email.contains("@")) {
			this.email = email;
		} else throw new IllegalArgumentException("Email address cannot be blank!");
	}
	
	// adds the bike of the Customers
	public void addBike(Bicycle bike, int numOfBikes) {
//		try { 
//			if (numOfBikes > 0) {
				bikes.add(bike);
//			} else if (numOfBikes == 0){
//				System.out.println("Customer has no bikes!"); }
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("Sorry! An unknown error occurred");
//		}
	}
	
	// converts attributes of Customer to String for output
	public String toString() {
		//printBike();
		String output = "Customer: " + first + " " + last + "\n" 
						 + "Phone: " + phone + "\n" 
						 + "Email: " + email + "\n"
						 + first + "'s Bikes:\n";
						 //+ bikes.get(0) + "\n" + bikes.get(1);
		printBike();
		return output;
	}

	public void printBike() {
		for (int bike = 0; bike < bikes.size(); bike++) {
			if (bikes.size() <= 0) {
				System.out.println("Customer has no bikes!");
				break;
			}
			System.out.println(bikes.get(bike) + " " + bike);
		}
	}
}
