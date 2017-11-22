/**
 * A simple test driver for the Bicycle and Customer classes
 * @version 1.0
 * @author Nathan West
 * 
 */
import java.util.*;
import java.io.*;

public class Project6 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	printHeading();
    	String fileName;
		if (args.length > 0) {
			fileName = args[0];
			System.out.println("File found");
		} else {
			fileName = askForFile();
		}
		try {
			Scanner fileReader = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        // create Bicycle objects and display information about them
        Bicycle myBike = new Bicycle();
        myBike.setColor("Blue");
        myBike.setBrakes(Bicycle.BrakeType.Cantilever);
        myBike.setType(Bicycle.BikeType.Cruiser);
        myBike.setBrand("Public");
        myBike.setCondition(Bicycle.Condition.Used);
        myBike.setFrame(Bicycle.FrameMaterial.Steel);
        myBike.setNumGears(3);
        myBike.setUser(Bicycle.UserType.Women);
        myBike.setWeight(20);
        myBike.setWheelSize(26);
        
        Bicycle hisBike = new Bicycle(Bicycle.BikeType.Hybrid, Bicycle.UserType.Men, 
                Bicycle.FrameMaterial.Carbon, Bicycle.BrakeType.Caliper, 
                Bicycle.Condition.Used, 29, 18, 10, "REI", "Black");
        
        System.out.println("************************************************");
        System.out.println("First Bicycle:");
        System.out.println(myBike);
        System.out.println("************************************************");
        System.out.println("Second Bicycle:");
        System.out.println(hisBike);
        System.out.println("************************************************");
        System.out.println();
        
        // create Customer objects and display information about them
        Customer don = new Customer();
        don.setFirstName("Don");
        don.setLastName("Norman");
        don.setPhoneNumber("804 123-4567");
        don.setEmailAddress("dnorman@aol.com");
        don.addBike(hisBike);
        System.out.println("************************************************");
        System.out.println(don);
        System.out.println("************************************************");
        System.out.println();
    }
    
    private static void printHeading() {
    	System.out.println("<><><><><><><><><><><>");
    	System.out.println("     Nathan West");
    	System.out.println(" CSMC 255 - Project 7");
    	System.out.println("   Bob's Bike Shop");
    	System.out.println("<><><><><><><><><><><>");
    }
    
    private static String askForFile() {
    	System.out.println("Enter the name of the file");
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