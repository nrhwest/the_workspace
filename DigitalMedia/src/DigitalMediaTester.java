
/**
 * Nathan West
 * CSMC 256
 * Project #1 - DigitalMediaTester
 * Description: This class tests the set methods of the DigitalMedia class,
 * 				validating the values that are passed to the setter methods
 * Purpose: To test DigitalMedia object getter and setter methods
 */

// import static org.junit.Assert.*;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DigitalMediaTester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		printHeading();

		/*
		 * testing creation of constructor
		 */
		DigitalMedia tester = null;
		try {
			tester = new DigitalMedia("image.jpg", 9438976);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(tester); // printing newly created object, testing
									// toString method
		System.out.println("~~~~~~~~~~~~~~~~~~~");

		/*
		 * testing setName of the tester DigitalMedia object
		 */
		try {
			tester.setName(null); // testing null
		} catch (NullPointerException e) {
			System.out.println("setName(null): " + e);
		}
		try {
			tester.setName(""); // testing empty string
		} catch (NullPointerException e) {
			System.out.println("setName(''): " + e);
		}
		try {
			tester.setName("this.shouldfail.jpg"); // testing string with two
													// dots
		} catch (IllegalArgumentException e) {
			System.out.println("setName(this.shouldfail.jpg): " + e);
		}
		try {
			tester.setName("thiswillalsofailjpg"); // testing string with no
													// dots
		} catch (IllegalArgumentException e) {
			System.out.println("setName(badfilejpg): " + e);
		}
		tester.setName("image.jpg"); // working string
		System.out.print("setName(image.jpg) – Expected: image.jpg; Actual: ");
		System.out.println(tester.getName());
		System.out.println("~~~~~~~~~~~~~~~~~~~");

		/*
		 * testing setSize of the tester DigitalMedia object
		 */
		try {
			tester.setSize(-432354); // testing negative size value
		} catch (IllegalArgumentException e) {
			System.out.println("setSize(-432354): " + e);
		}
		tester.setSize(68372); // working size value
		System.out.println("setSize(68372) - Expected: 68372  Actual; " + tester.getSize());

		
		
		/*
		 * testing setDateModified of the tester DigitalMedia object
		 */
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println("dateCreated: " + tester.getDateCreated().now()); // printed
																				// for
																				// viewing
																				// purposes

		LocalDateTime newDate = LocalDateTime.of(2016, 12, 24, 8, 35);
		try {
			tester.setDateModified(newDate); // testing newDate with old year
		} catch (NullPointerException e) {
			System.out.println("setDateModifed(newDate): " + e);
		}

		newDate = LocalDateTime.of(2018, 2, 25, 11, 12, 57); // testing newDate
																// with year
																// after
																// dateCreated
		tester.setDateModified(newDate);
		System.out.println("setDateModified(newDate): " + tester.getDateModified());
		System.out.println("~~~~~~~~~~~~~~~~~~~");

		/*
		 * testing the boolean equals method
		 */
		DigitalMedia tester2 = new DigitalMedia("image.jpg", 68372);
		DigitalMedia tester3 = new DigitalMedia("picture.jpg", 342);

		// testing for symmetry
		boolean symmetric = tester.equals(tester2) && tester2.equals(tester);
		System.out.println("Symmetric: " + symmetric);

		// testing for transitive
		boolean transitive = tester.equals(tester2) && tester2.equals(tester3) && tester.equals(tester3);
		System.out.println("Transitive: " + transitive);

		// testing for consistency
		boolean consistency = tester.equals(tester2) && tester.equals(tester2);
		System.out.println("Consistency: " + consistency);

		System.out.println("~~~~~~~~~~~~~~~~~~~");		

//		// testing an algorithm theory
//		DigitalMedia media = new DigitalMedia(null, 0);
//		Song song = new Song(null, 0, null, null);
//		Image image = new Image(null, 0, 0, 0);
//
//		System.out.println("Enter the file name: ");
//		Scanner input = new Scanner(System.in);
//		String fileName = input.nextLine();
//		File file = new File(fileName);
//		ArrayList<DigitalMedia> collection = new ArrayList<DigitalMedia>();
//		
//		Scanner fileReader = null;
//		fileReader = new Scanner(file);
//		while (fileReader.hasNextLine()) {
//			String line = fileReader.nextLine();
//			if (line.charAt(0) == 'S') {
//				String[] properties = line.split(":");
//				String[] trimmed = new String[properties.length];
//				for (int i = 0; i < properties.length; i++) {
//				    trimmed[i] = properties[i].trim();
//				}
//				song.setTitle(trimmed[1]);
//				song.setArtist(trimmed[2]);
//				song.setAlbum(trimmed[3]);
//				String number = trimmed[4];
//				number = number.replaceAll(",", "");
//				long size = Long.parseLong(number);
//				song.setSize(size);
//				collection.add(song);
//				song = new Song(null, 0, null, null);
//			}
//			if (line.charAt(0) == 'I') {
//				String[] properties = line.split(":");
//				String[] trimmed = new String[properties.length];
//				for (int i = 0; i < properties.length; i++) {
//				    trimmed[i] = properties[i].trim();
//				}
//				image.setName(trimmed[1]);
//				image.setWidth(Integer.parseInt(trimmed[2]));
//				image.setHeight(Integer.parseInt(trimmed[3]));
//				String number = trimmed[4];
//				number = number.replaceAll(",", "");
//				long size = Long.parseLong(number);
//				song.setSize(size);
//				collection.add(image);
//				image = new Image(null, 0, 0, 0);
//			}	
//		}
//		
//		// System.out.println(collection);

	}

	// print heading
	public static void printHeading() {
		System.out.println("     ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("    |       Nathan West      |");
		System.out.println("    |   @    CMSC 256    @   |");
		System.out.println("    |       Project #2       |");
		System.out.println("    | Media List Application |");
		System.out.println("     ~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
