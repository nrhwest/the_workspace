
/**
 * Nathan West
 * CSMC 256
 * Project #2
 * Description: This class reads from a file, creating Song and Image 
 * 				digital media objects from data in the file. It 
 * Purpose: To 
 * @author nathanwest
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MediaList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printHeading();
		String fileName = null;
		if (args.length > 0) {
			fileName = args[0];
			System.out.println("File found!");
		} else
			fileName = promptUserForFile();
		Scanner fileReader = null;
		try {
			fileReader = validateFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// creating objects and adding it to list
		Image image = null;
		Song song = null;
		Scanner lineReader = null;
		int errors = 0;
		ArrayList<DigitalMedia> inventory = new ArrayList<DigitalMedia>();
		try {
			System.out.print("Processing file... ");
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				lineReader = new Scanner(line);
				if (line.charAt(0) == 'S' || line.charAt(0) == 's') {
					if (!line.contains(".") || line.indexOf('.', line.indexOf('.') + 1) != -1) {
						lineReader.skip(line);
						errors++;
					} else {
						String[] data = line.split(":");
						if (data[4].contains(","))
							data[4].replaceAll(",", "");
						try {
							song = new Song(data[1].trim(), Long.parseLong(data[4].trim()), 
									data[3].trim(),data[2].trim());
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						}
						inventory.add(song);
					}
				}
				if (line.charAt(0) == 'I' || line.charAt(0) == 'i') {
					if (!line.contains(".") || line.indexOf('.', line.indexOf('.') + 1) != -1) {
						lineReader.skip(line);
						errors++;
					} else {
						String[] data = line.split(":");
						if (data[4].contains(","))
							data[4].replaceAll(",", "");
						try {
							image = new Image(data[1].trim(), Long.parseLong(data[4].trim()),
									Integer.parseInt(data[3].trim()), Integer.parseInt(data[2].trim()));
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						}
						inventory.add(image);
					}
				}
			}
			lineReader.close();
			fileReader.close();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		System.out.print("Done!\n");
		System.out.println("**Found " + errors + " error(s) in the file");

		displayMenu();
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		while (!input.equals("Q")) {
			runMenu(inventory, input);
			displayMenu();
			input = scan.nextLine();
		}
		System.out.print("Program closing... ");
		System.out.println("Thank you!");
	}

	// prints out the menu
	public static void displayMenu() {
		System.out.println("------------------------------");
		System.out.println("Enter one of the four below:");
		System.out.println("S to search for songs");
		System.out.println("I to search for images");
		System.out.println("A for all unordered DigitalMedia objects");
		System.out.println("Q to exit the program");
		System.out.print("Enter here: ");
	}

	// runs the menu
	public static void runMenu(ArrayList<DigitalMedia> inventory, String input) {
		switch (input) {
		case "S":
			searchAndSortSongs(inventory);
			break;
		case "I":
			searchAndSortImages(inventory);
			break;
		case "A":
			printAll(inventory);
			break;
		default: System.out.println("Not an option, try again!");
			break;
		}
	}

	// searches and sorts a list of Song objects
	public static void searchAndSortSongs(ArrayList<DigitalMedia> inventory) {
		ArrayList<Song> songList = new ArrayList<Song>();
		for (DigitalMedia song : inventory) {
			if (song instanceof Song)
				songList.add((Song) song);
		}
		Collections.sort(songList);
		for (int x = 0; x < songList.size(); x++)
			System.out.println(songList.get(x));
	}

	// searches and sorts a list of Image objects
	public static void searchAndSortImages(ArrayList<DigitalMedia> inventory) {
		ArrayList<Image> imageList = new ArrayList<Image>();
		for (DigitalMedia image : inventory) {
			if (image instanceof Image)
				imageList.add((Image) image);
		}
		Collections.sort(imageList);
		for (int x = 0; x < imageList.size(); x++)
			System.out.println(imageList.get(x));
	}

	// prints all the DigitalMedia objects in the list
	public static void printAll(ArrayList<DigitalMedia> inventory) {
		int count = 0;
		for (int x = 0; x < inventory.size(); x++) {
			System.out.println(inventory.get(x));
			count++;
		}
		System.out.println("\nThe DigitalMedia collection holds " + count + " items.");
	}

	// prompts user to enter a file
	private static String promptUserForFile() {
		System.out.print("Enter the file name: ");
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	// validating the file
	private static Scanner validateFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		while (!file.exists()) {
			file = new File(promptUserForFile());
		}
		return new Scanner(file);
	}

	// print heading
	public static void printHeading() {
		System.out.println();
		System.out.println("     ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("    |        Nate West       |");
		System.out.println("    |   {}   CMSC 256   {}   |");
		System.out.println("    |       Project #2       |");
		System.out.println("    | Media List Application |");
		System.out.println("     ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
	}
}
