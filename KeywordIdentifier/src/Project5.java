/**
 * Nate West
 * CSMC 256
 * Project 5 – Java Keyword Identifier
 * Purpose: To read two files and create a tree and dictionary
 * Description: This class controls the creation of the AVLTree and 
 * 				FrequencyCounter. The main method runs all the entire program
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Project5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printHeading();
		File file, file2 = null;
		if (args.length > 0) {
			file = new File(args[0]);
			file2 = new File(args[1]);
			System.out.println("File found!");
		} else {
			file = new File(promptUserForFile());
			file2 = new File(promptUserForFile());
		}
		Scanner fileReader = null;
		try {
			fileReader = validate(file); // creates the fileReader from the validated file
			readFiles(fileReader, file2); // method to read both files
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (NoSuchElementException e) {
			System.out.println("There's no element here!");
		} catch (Exception e) {
			System.out.println("Something missed up :-(");
		}
	}

	// reads the first file, validates the second, and passes to FrequencyCounter
	@SuppressWarnings("unchecked")
	private static void readFiles(Scanner fileReader, File file) throws IllegalArgumentException {
		System.out.println("-----------------------------");
		@SuppressWarnings("rawtypes")
		AVLTree tree = new AVLTree();
		while(fileReader.hasNextLine()) 
			tree.add(fileReader.next().trim());
		tree.printTree();
		System.out.println("-----------------------------");
		Dictionary dictionary = new Dictionary();
		try {
			fileReader = validate(file); // validates the second file
			dictionary.readFile(fileReader, tree); // passes fileReader and AVLTree to dictionary
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Printing count of the dictionary...");
		dictionary.display();
		System.out.println("-----------------------------");
		System.out.println("Processing complete!");
	}

	// prompts user to enter a file
	private static String promptUserForFile() {
		System.out.print("Enter the file name: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	// validating the file
	private static Scanner validate(File file) throws FileNotFoundException {
		while (!file.exists()) {
			file = new File(promptUserForFile());
		}
		return new Scanner(file);
	}

	// print heading
	public static void printHeading() {
		System.out.println("     ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("    |       Nate West        |");
		System.out.println("    |    $   CMSC 256   $    |");
		System.out.println("    |       Project #5       |");
		System.out.println("    |   Keyword Identifier   |");
		System.out.println("     ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
	}

}
