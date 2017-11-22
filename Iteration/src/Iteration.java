/**
 * Nathan West
 * CSMC 255
 * Project #3
 * 9/29/16
 *
 * This program asks the user to search for a file.
 *
 * Prompts the user to search for a file.
 * If the searched file does not exist, it prompts the user again.
 * If the file does exist,
 * the program prints out the contents of the file.
 */

import java.io.*;
import java.util.Scanner;

public class Iteration {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the file name, (Include file type): ");

		File file = new File(input.next());
		while(!file.exists()) {
		    System.out.println("Please enter a valid file name");
		    file = new File(input.next());
		  }

		Scanner outputFile = new Scanner(file);
		int lineNumber = 1;
		while (outputFile.hasNextLine()) {
			System.out.println(lineNumber + " " + outputFile.nextLine());
			lineNumber++;
		}
		outputFile.close();
	}

}
