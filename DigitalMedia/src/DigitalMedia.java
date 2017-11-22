/**
 * Nathan West
 * CMSC 256
 * Project 1 – DigitalMedia
 * Purpose: To create DigitalMedia objects
 * Description: This class models a file relating to digital media,
 * 				such as sound, images, text and video. The class creates an object 
 * 				from the name, size of the file and the date the file was created.
 * 				If the file were to be modified, the object will also change
 * 				it's date created to what ever the date it was modified
 */

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DigitalMedia {
	
	// instance variables for the object
	private String name = "unknown";
	private long size = 0;
	private LocalDateTime dateCreated = null, dateModified = null;
	
	// constructor that creates the DigitalMedia object
	public DigitalMedia(String n, long s) {
		name = n;
		size = s;
		dateCreated = LocalDateTime.now();
		dateModified = LocalDateTime.now();
	}
	
	// validates and sets the name of the object
	public void setName(String n) {
		if (n == null || n.length() <= 0)
			throw new NullPointerException("Filename cannot be null/blank!");
		if (!n.contains("."))
			throw new IllegalArgumentException("Invalid filename!");
		if(n.indexOf('.', n.indexOf('.') + 1) != -1)
		    throw new IllegalArgumentException("Invalid filename!")
;		else 
			name = n;
		
		LocalDateTime revised = LocalDateTime.now();
		setDateModified(revised);
	}
	
	// returns the name
	public String getName() {
		return name;
	}
	
	// sets the size of the object
	public void setSize(long s) {
		if (s >= 0) 
			size = s;
		else 
			throw new IllegalArgumentException("Size cannot be negative!");
		
		LocalDateTime revised = LocalDateTime.now();
		setDateModified(revised);
	}
	
	// returns the size
	public long getSize() {
		return size;
	}
	
	// sets the date the object was modified
	public void setDateModified(LocalDateTime dm) {
		if (dm.isAfter(dateCreated))
			dateModified = dm;
		 else 
			 throw new NullPointerException("Invalid date!");
	}
	
	// returns the date the object was modified
	public LocalDateTime getDateModified() {
		return dateModified;
	}
	
	// returns the date the object was created
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	
	// formats dateCreated
	public String dcFormatter() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("L d, u");
		String dcFormatted = dateCreated.format(format);
		if (dcFormatted.startsWith("1")) {
			dcFormatted = dcFormatted.replaceFirst("1", "January");
		} else if (dcFormatted.startsWith("2")) {
			dcFormatted = dcFormatted.replaceFirst( "2", "Feburary");
		} else if (dcFormatted.startsWith("3")) {
			dcFormatted = dcFormatted.replaceFirst("3", "March");
		} else if (dcFormatted.startsWith("4")) {
			dcFormatted = dcFormatted.replaceFirst("4", "April");
		} else if (dcFormatted.startsWith("5")) {
			dcFormatted = dcFormatted.replaceFirst("5", "May");
		} else if (dcFormatted.startsWith("6")) {
			dcFormatted = dcFormatted.replaceFirst("6", "June");
		} else if (dcFormatted.startsWith("7")) {
			dcFormatted = dcFormatted.replaceFirst("7", "July");
		} else if (dcFormatted.startsWith("8")) {
			dcFormatted = dcFormatted.replaceFirst("8", "August");
		} else if (dcFormatted.startsWith("9")) {
			dcFormatted = dcFormatted.replaceFirst("9", "September");
		} else if (dcFormatted.startsWith("10")) {
			dcFormatted = dcFormatted.replaceFirst("10", "October");
		} else if (dcFormatted.startsWith("11")) {
			dcFormatted = dcFormatted.replaceFirst("11", "November");
		} else if (dcFormatted.startsWith("12")) {
			dcFormatted = dcFormatted.replaceFirst("12", "December");
		} else {
			System.out.println("Incorrect date!");
		}
		return dcFormatted;
	}
	
	// formats dateModified
	public String dmFormatter() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("L d, u");
		String dmFormatted = dateModified.format(format);
		if (dmFormatted.startsWith("1")) {
			dmFormatted = dmFormatted.replaceFirst("1", "January");
		} else if (dmFormatted.startsWith("2")) {
			dmFormatted = dmFormatted.replaceFirst("2", "Feburary");
		} else if (dmFormatted.startsWith("3")) {
			dmFormatted = dmFormatted.replaceFirst("3", "March");
		} else if (dmFormatted.startsWith("4")) {
			dmFormatted = dmFormatted.replaceFirst("4", "April");
		} else if (dmFormatted.startsWith("5")) {
			dmFormatted = dmFormatted.replaceFirst("5", "May");
		} else if (dmFormatted.startsWith("6")) {
			dmFormatted = dmFormatted.replaceFirst("6", "June");
		} else if (dmFormatted.startsWith("7")) {
			dmFormatted = dmFormatted.replaceFirst("7", "July");
		} else if (dmFormatted.startsWith("8")) {
			dmFormatted = dmFormatted.replaceFirst("8", "August");
		} else if (dmFormatted.startsWith("9")) {
			dmFormatted = dmFormatted.replaceFirst("9", "September");
		} else if (dmFormatted.startsWith("10")) {
			dmFormatted = dmFormatted.replaceFirst("10", "October");
		} else if (dmFormatted.startsWith("11")) {
			dmFormatted = dmFormatted.replaceFirst("11", "November");
		} else if (dmFormatted.startsWith("12")) {
			dmFormatted = dmFormatted.replaceFirst("12", "December");
		} else {
			System.out.println("Incorrect date!");
		}
		return dmFormatted;
	}
		
	// compares two objects to each other, checking the attributes of the object
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null) 
	    	return false;
	    if (obj instanceof DigitalMedia) {
	    	DigitalMedia alt = (DigitalMedia) obj;
	    	if (name.equals(alt.getName())) {
	    		if (size == alt.getSize())
	    			return true;
	    	}
	    }
	    return false;
	}
	
	@Override
	// returns the properties of the object to a String for printing
	public String toString() {
		return "\nName: " + name + "\nSize: " + size + " KB " + "\nCreated: " + dcFormatter() + "\nModified: "
				+ dmFormatter();
	}
}
