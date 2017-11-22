/**
 * Nathan West
 * CSMC 255 – Project 7
 * This is a Tester class meant to test the setter methods of the classes Bicycle and Customer
 */

public class Tester {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer testCustomer = new Customer();    // new Customer object
		Bicycle testBicycle = new Bicycle();       // new Bicycle object
		
		System.out.println("========== TESTS Customer CLASS ===========");
		
		// tests setFirstName of Customer //
		try {
			testCustomer.setFirstName(null); // checks for null
		} catch (NullPointerException e) {
				System.out.println("Test setFirstName(null): " + e + ": First name cannot be blank!"); }
		try {
			testCustomer.setFirstName(""); // checks for empty string
		} catch (IllegalArgumentException e) { System.out.println("Test setFirstName(''): " + e); }
		
		testCustomer.setFirstName("Nathan");
		System.out.print("Test setFirstName('Nathan') – Expected: Nathan; Actual: ");
		System.out.println(testCustomer.getFirstName());
		
		System.out.println();
		
		// tests setLastName of Customer //
		try {
			testCustomer.setLastName(null); // checks for null
		} catch (NullPointerException e) {
				System.out.println("Test setLastName(null): " + e + ": Last name cannot be blank!"); }
		try {
			testCustomer.setLastName(""); // checks for empty string
		} catch (IllegalArgumentException e) { System.out.println("Test setLastName(''): " + e); }
		
		testCustomer.setLastName("West");
		System.out.print("Test setLastName('West') – Expected: West; Actual: ");
		System.out.println(testCustomer.getLastName());
		
		System.out.println();
		
		// tests setEmailAddress of Customer //
		try {
			testCustomer.setEmailAddress(null); // checks for null
		} catch (NullPointerException e) { 
				System.out.println("Test setEmailAddress(null): " + e + ": Email address cannot be blank!"); }
		try {
			testCustomer.setEmailAddress(""); // checks for empty string
		} catch (IllegalArgumentException e) { 
			System.out.println("Test setEmailAddress(''): " + e); }
		try {
			testCustomer.setEmailAddress("westemail.com"); // checks for @ sign
		} catch (IllegalArgumentException e) {
			System.out.println("Test setEmailAddress('westemail.com'): " + e); }
		
		testCustomer.setEmailAddress("west@email.com");
		System.out.print("Test setEmailAddress('west@email.com') – Expected: west@email.com; Actual: ");
		System.out.println(testCustomer.getEmailAddress());
		
		System.out.println();

		// tests setPhoneNumber of Customer //
		try {
			testCustomer.setPhoneNumber(null); // checks for null
		} catch (NullPointerException e) {
				System.out.println("Test setPhoneNumber(null): " + e + ": Phone number cannot be blank!"); }
		try {
			testCustomer.setPhoneNumber(""); // checks for empty string
		} catch (IllegalArgumentException e) { System.out.println("Test setPhoneNumber(''): " + e); }
		
		testCustomer.setPhoneNumber("(804) 123-4567");
		System.out.print("Test setPhoneNumber('(804) 123-4567') – Expected: West; Actual: ");
		System.out.println(testCustomer.getPhoneNumber());
		
		
		System.out.println("\n========= TESTS Bicycle CLASS ==========");
		// tests setColor of Bicycle //
		try {
			testBicycle.setColor(null); // checks for null
		} catch (NullPointerException e) {
				System.out.println("Test setColor(null): " + e + ": Color cannot be blank!"); }
		try {
			testBicycle.setColor(""); // checks for empty string
		} catch (IllegalArgumentException e) { System.out.println("Test setColor(''): " + e); }
		
		testBicycle.setColor("Blue");
		System.out.print("Test setColor('Blue') – Expected: Blue; Actual: ");
		System.out.println(testBicycle.getColor());
		
		System.out.println();
		// tests setBrand of Bicycle //
		try {
			testBicycle.setBrand(null); // checks for null
		} catch (NullPointerException e) {
				System.out.println("Test setBrand(null): " + e + ": Brand cannot be blank!"); }
		try { 
			testBicycle.setBrand(""); // checks for empty string
		} catch (IllegalArgumentException e) { System.out.println("Test setBrand(''): " + e); }
		
		testBicycle.setBrand("REI");
		System.out.print("Test setBrand('REI') – Expected: REI; Actual: ");
		System.out.println(testBicycle.getBrand());
		
		System.out.println();
		// tests setNumGears of Bicycle //
		try {
			testBicycle.setNumGears(0); // checks for 0
		} catch (IllegalArgumentException e) {
				System.out.println("Test setNumGears(0): " + e); }
		try {
			testBicycle.setNumGears(-4); // checks for negative
		} catch (IllegalArgumentException e) { System.out.println("Test setNumGears(-4): " + e); }
		
		testBicycle.setNumGears(4);
		System.out.print("Test setNumGears(4) – Expected: 4; Actual: ");
		System.out.println(testBicycle.getNumGears());
		
		System.out.println();
		// tests setWeight of Bicycle //
		try {
			testBicycle.setWeight(0); // checks for 0
		} catch (IllegalArgumentException e) {
				System.out.println("Test setWeight(0): " + e); }
		try {
			testBicycle.setWeight(-10); // checks for negative
		} catch (IllegalArgumentException e) { System.out.println("Test setWeight(-10): " + e); }
		
		testBicycle.setWeight(10);
		System.out.print("Test setWeight(10) – Expected: 10; Actual: ");
		System.out.println(testBicycle.getWeight());
		
		System.out.println();
		// tests setWheelSize of Bicycle //
		try {
			testBicycle.setWheelSize(0); // checks for 0
		} catch (IllegalArgumentException e) {
				System.out.println("Test setWheelSize(0): " + e); }
		try {
			testBicycle.setWheelSize(-1); // checks for negative
		} catch (IllegalArgumentException e) { System.out.println("Test setWheelSize(-1): " + e); }
		
		testBicycle.setWheelSize(26);
		System.out.print("Test setWheelSize(26) – Expected: 26; Actual: ");
		System.out.println(testBicycle.getWheelSize());
	}
}