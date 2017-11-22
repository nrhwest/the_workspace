/**
 * Nathan West
 * CSMC 255
 * Project 4 – Reaction Analysis
 *
 * This program displays a menu and
 * prompts the user to choose one of the various options.
 * Once the user chooses, the program will compare user input
 * to the movieReviews.txt file.
 */

import java.util.*;
import java.io.*;

public class ReactionAnalysis {

	// Main method that controls the program
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		printHeading();
		File movieReviews = new File("movieReviews.txt");
		Scanner fileReader = new Scanner(movieReviews);
		Scanner scan = new Scanner(System.in);
		displayMenu();
		String input = scan.nextLine();

		while (!input.equals("5")) {
			runMenu(input, scan, fileReader,movieReviews);
			fileReader = new Scanner(movieReviews);
			scan = new Scanner(System.in);
		    displayMenu();
		    input = scan.nextLine();
		}
		System.out.println("Exiting the program... Thank you!");
	}

	// Project information
	private static void printHeading() {
		System.out.println("-----------------------------");
		System.out.println("Nathan West");
		System.out.println("CSMC 255");
		System.out.println("Programming Project 4");
		System.out.println("Reaction Analysis Application");
		System.out.println("-----------------------------");
	}

	// Displays the menu for the user
	public static void displayMenu() {
		System.out.println("\nWhat would you like to do?");
		System.out.println("1: Get the score of a word");
		System.out.println("2: Get the average score of words in a file (one word per line)");
		System.out.println("3: Find the highest/lowest scoring words in a file");
		System.out.println("4: Sort words from a file into positive.txt and negative.txt");
		System.out.println("5: Exit the program");
		System.out.print("Enter a number 1-5: ");
	}

	// This method runs the menu for the program
	public static void runMenu(String in, Scanner input, Scanner fileReader, File movieReviews) throws FileNotFoundException {
		switch (in) {
			case "1": getAverageScore(input, fileReader, movieReviews);
				break;
			case "2": getAverageFileScore(input, fileReader, movieReviews);
				break;
			case "3": getMostPosNegWord(input, fileReader, movieReviews);
				break;
			case "4": sortWordsToFiles(input, fileReader, movieReviews);
				break;
			default: break;
		}
	}

	/* This method displays the average score for
	 * a searched word and the number of
	 * times the word appears throughout movieReviews.txt
	 */
	public static void getAverageScore(Scanner input, Scanner fileReader, File movieReviews) throws FileNotFoundException {
		System.out.print("Search for a word: ");
		String word = input.nextLine();

		char lineNumber;
		double count = 0, total = 0 ,average;
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			if (line.contains(word)) {
				count++;
				lineNumber = line.charAt(0);
				double number = Double.parseDouble(Character.toString(lineNumber));
				total = total + number;
			}
		}
		fileReader.close();
		average = (total / count);
		System.out.println();
		System.out.println(word + " appears " + count + " times in the file.");
		System.out.printf("The average score of reviews contain the word " + word + " is " + "%.5f", average);
		System.out.println();
		fileReader = new Scanner(movieReviews);
	}

	/*
	 * This method calculates and displays the average score for a searched file
	 */
	public static void getAverageFileScore(Scanner input, Scanner fileReader, File movieReviews) throws FileNotFoundException {
		System.out.print("Enter the name of the file with the words you want the average score for: ");
		File file = new File(input.next());
		while (!file.exists()) {
			System.out.println("Please enter a valid file:");
			file = new File(input.next());
		}
		Scanner txtScan = new Scanner(file);
		double count, average, total, number, wordCount = 0;
		double totalWordAvg = 0, fileAverage;
		char lineNumber;
		String word;
		while (txtScan.hasNextLine()) {
			word = txtScan.nextLine();
			wordCount++;
			count = 0;
			total = 0;
			number = 0;
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				if (line.contains(word)) {
					count++;
					lineNumber = line.charAt(0);
					number = Double.parseDouble(Character.toString(lineNumber));
					total = total + number;
				}
			}
			average = total / count;
			totalWordAvg = totalWordAvg + average;
			fileReader = new Scanner(movieReviews);
		}
		fileReader.close();
		txtScan.close();
		fileAverage = (totalWordAvg / wordCount);
		if (fileAverage < 1.99) {
			System.out.println();
			System.out.printf("The average score of words in " + file + " is " + "%.5f", fileAverage);
			System.out.println();
			System.out.println("The overall sentiment of " + file + " is negative");
		}
		else if (fileAverage > 2.01) {
			System.out.println();
			System.out.printf("The average score of words in " + file + " is " + "%.5f", fileAverage);
			System.out.println();
			System.out.println("The overall sentiment of " + file + " is positive");
		} else {
			System.out.printf("The average score of words in " + file + " is " + "%.5f", fileAverage);
			System.out.println();
			System.out.println("The overall sentiment of " + file + " is neutral");
		}
	}

	/*
	 * This method prompts the user for a file and
	 * calculates and displays the most
	 * positive and negative word by computing
	 * each word's (from the searched file) average
	 */
	public static void getMostPosNegWord(Scanner input, Scanner fileReader, File movieReviews) throws FileNotFoundException {
		System.out.print("Enter a name of the file with words you want to score: ");
		File file = new File(input.next());
		while (!file.exists()) {
			System.out.println("Please enter a valid file:");
			file = new File(input.next());
		}
		Scanner txtScan = new Scanner(file);
		double average, number, total = 0, count = 0;
		double lowestAvg = 1.99, highestAvg = 2.01;
		char lineNumber;
		String word, lowestWord = null, highestWord = null;
		while (txtScan.hasNextLine()) {
			word = txtScan.nextLine();
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				if (line.contains(word)) {
					count++;
					lineNumber = line.charAt(0);
					number = Double.parseDouble(Character.toString(lineNumber));
					total = total + number;
				}
			}
			average = total / count;
			if (average < lowestAvg) {
				lowestWord = word;
				lowestAvg = average;
			}
			if (average > highestAvg) {
				highestWord = word;
				highestAvg = average;
			}
			fileReader = new Scanner(movieReviews);
			count = 0;
			number = 0;
			total = 0;
		}
		txtScan.close();
		fileReader.close();
		System.out.println();
		System.out.printf("The most positive word, with a score of " + "%.5f" + " is " + highestWord, highestAvg);
		System.out.println();
		System.out.printf("The most negative word, with a score of " + "%.5f" + " is " + lowestWord, lowestAvg);
		System.out.println();
	}

	/*
	 * This method prompts the user for a file and
	 * sorts it's contents to positive and
	 * negative text files by calculating 
	 * each word's (from the searched file) average
	 */
	public static void sortWordsToFiles(Scanner input, Scanner fileReader, File movieReviews) throws FileNotFoundException {
		System.out.print("Enter the name of the file with the words you want the average score for: ");
		File file = new File(input.next());
		while (!file.exists()) {
			System.out.println("Please enter a valid file:");
			file = new File(input.next());
		}
		PrintWriter posWriter = new PrintWriter(new File("positive.txt"));
		PrintWriter negWriter = new PrintWriter(new File("negative.txt"));
		Scanner txtScan = new Scanner(file);
		double average, number, total = 0, count = 0;
		double lowestAvg = 1.9, highestAvg = 2.1;
		char lineNumber;
		String word, lowestWord = null, highestWord = null;

		while (txtScan.hasNextLine()) {
			word = txtScan.nextLine();
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				if (line.contains(word)) {
					count++;
					lineNumber = line.charAt(0);
					number = Double.parseDouble(Character.toString(lineNumber));
					total = total + number;
				}
			}
			average = total / count;
			if (average < lowestAvg) {
				lowestWord = word;
				negWriter.println(lowestWord);
			}
			if (average > highestAvg) {
				highestWord = word;
				posWriter.println(highestWord);
			}
			fileReader = new Scanner(movieReviews);
			count = 0;
			number = 0;
			total = 0;
		}
		posWriter.close();
		negWriter.close();
		txtScan.close();
		fileReader.close();
		System.out.println();
		System.out.println("Files have been created!");
	}
}
