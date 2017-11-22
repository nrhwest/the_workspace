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
		if (!first.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Please enter a valid first name");
		} else 
			this.first = first;
	}
	
	// returns last name
	public String getLastName() {
		return last;
	}
	
	// sets the last name of Customer
	public void setLastName(String last) {
		if (!last.matches("[a-zA-Z]+")) {
			throw new IllegalArgumentException("Please enter a valid last name");
		} else 
			this.last = last;
	}
	
	// returns the phone number of Customer
	public String getPhoneNumber() {
		return phone;
	}
	
	// sets the phone number of Customer
	public void setPhoneNumber(String phone) {
		if (phone.length() <= 0)
			throw new IllegalArgumentException("Please enter a valid phone number");
		this.phone = phone;
	}
	
	// returns the email address of Customer
	public String getEmailAddress() {
		return email;
	}
	
	// sets the email address of Customer
	public void setEmailAddress(String email) {
		if (email.contains("@")) {
			this.email = email;
		} else throw new IllegalArgumentException("Please enter a valid email address");
	}
	
	// adds the bike of the Customers
	public void addBike(Bicycle bike) {
		bikes.add(bike);
	}
	
	// converts attributes of Customer to String for output
	public String toString() {
		String output = "Customer: " + first + " " + last + "\n" 
						 + "Phone: " + phone + "\n" 
						 + "Email: " + email + "\n"
						 + first + "'s Bikes:\n"
						 + bikes.get(0);
		return output;
	}
}
