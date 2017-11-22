/**
 * Nathan West
 * CSMC 255 – Project 7
 * Bob's Bike Shop
 * Purpose – Search for a customer
 * Description ~ The purpose of the program for Bob to enter a file of customer information
 *			 where the program will read through the file, setting the information of the customer
 *			 to a customer and bicycle object. The program will then add those customer objects to a list of customer
 *			 so Bob can search for any customer.
 */

import java.io.*;
import java.util.*;

public class Project7 {

	// arrayList to hold customer objects
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printHeading();
		System.out.println();
    	String fileName;
		if (args.length > 0) {
			fileName = args[0];
			System.out.println("File found");
		} else {
			fileName = askForFile();
		}
		
		File file = new File(fileName);
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Customer customer = new Customer();
		Bicycle bike = new Bicycle();
		try { 
			System.out.print("Processing information in file...");
			// cycles through file and processes data 
			while (fileReader.hasNextLine()) { 
				String line = fileReader.nextLine(); 
				Scanner txtScan = new Scanner(line);			
				String first = "", last = "", phone = "", email = "";
				int theBikes = 0;
				
				// sets the name of the customer
				if (txtScan.findInLine("Customer: ") != null) {
					first = txtScan.next();
					last = txtScan.next(); 
			customer.setFirstName(first);
					customer.setLastName(last);
				}
				// sets the phone number of the customer
				if (txtScan.findInLine("Phone: ") != null) {
					phone = txtScan.next();
					phone = phone + " " + txtScan.next();
					customer.setPhoneNumber(phone);
				}
				// sets the email of the customer
				if (txtScan.findInLine("Email: ") != null) {
					email = txtScan.next();
					customer.setEmailAddress(email);
				}
				
				int bikeCount = 0;
				if (txtScan.findInLine("Number of Bikes: ") != null) {
					theBikes = txtScan.nextInt();
					// cycle through the number of bikes the customer owns
					while (bikeCount < theBikes) {
						line = fileReader.nextLine();
						bikeCount++;
						txtScan = new Scanner(line);
						// sets the BikeType for the bike object
						if (txtScan.findInLine("type: ") != null) {
							String type = txtScan.next();
							bike.setType(Bicycle.BikeType.valueOf(type));
						} 
						// sets the UserType for the bike object
						if (txtScan.findInLine("user: ") != null) {
							String user = txtScan.next();
							bike.setUser(Bicycle.UserType.valueOf(user));
						} 
						// sets the FrameMaterial for the bike object
						if (txtScan.findInLine("frame: ")  != null) {
							String frame = txtScan.next();
							bike.setFrame(Bicycle.FrameMaterial.valueOf(frame));
						}
						// sets the BrakeType for the bike object
						if (txtScan.findInLine("brakes: ") != null) {
							String brakes = txtScan.next();
							bike.setBrakes(Bicycle.BrakeType.valueOf(brakes));
						}
						// sets the Condition of the bike object
						if (txtScan.findInLine("condition: ") != null) {
							String condition = txtScan.next();
							bike.setCondition(Bicycle.Condition.valueOf(condition));
						} 
						// sets the wheelSize of the bike object
						if (txtScan.findInLine("wheelSize: ") != null) {
							int wheelSize = txtScan.nextInt();
							bike.setWheelSize(wheelSize);
						} 
						// sets the weight of the bike object
						if (txtScan.findInLine("weight: ") != null) {
							int weight = txtScan.nextInt();
							bike.setWeight(weight);
						} 
						// sets the number of gears for the bike object
						if (txtScan.findInLine("numGears: ") != null) {
							int numGears = txtScan.nextInt();
							bike.setNumGears(numGears);
						} 
						// sets the brand of the bike object
						if (txtScan.findInLine("brand: ") != null) {
							String brand = txtScan.next();
							bike.setBrand(brand);
						} 
						// sets the color of the bike object
						if (txtScan.findInLine("color: ") != null) {
							String color = txtScan.next();
							bike.setColor(color);
						}
						// adds the customer's bike to their collection 
						customer.addBike(bike, theBikes);
						bike = new Bicycle();
					}
					// adds the newly created customer to the customer list
					customers.add(customer);
					customer = new Customer();
				}
			}			
			fileReader.close();
			System.out.print(" Finished!\n" + "\nReady to search for customer!\n"); 
		} catch (IllegalArgumentException e) {
			 e.printStackTrace(); 
			 }
	
		// creating a search function
		Scanner input = new Scanner(System.in);
		boolean found = false;
		while (true) {
			System.out.print("Enter last name of the customer: ");
			String userInput = input.nextLine().trim();
			// exits the program
			if (userInput.equals("q")) {
				System.out.println("Application closing...\n" + "Thank you!");
				System.exit(0);
			}
			while(!userInput.equals("q")) {
				// cycle through the customers ArrayList, checking if the input matches the value of the last name
				for (Customer info : customers) {
					if (info.getLastName().equals(userInput)) {
						System.out.println(info);
						found = true;
					}
				}
				break;
			}
			// if the customer is not found, print message
			if (!found) {
				System.out.println("Customer not found!");
			}
		}
	}

	private static void printHeading() {
	    System.out.println("<><><><><><><><><><><>");
	   	System.out.println("     Nathan West");
	   	System.out.println(" CSMC 255 - Project 7");
	   	System.out.println("   Bob's Bike Shop");
	   	System.out.println("<><><><><><><><><><><>");
	}
	    
	private static String askForFile() {
	    System.out.print("Enter the name of the file: ");
	   	Scanner input = new Scanner(System.in);
	   	return input.nextLine();
	}
	    
	private static Scanner openFile(String fileName) throws IOException {
		File file = new File(fileName);
		while (!file.exists()) {
			file = new File(askForFile());
		}
		return new Scanner(file);
	}
}
