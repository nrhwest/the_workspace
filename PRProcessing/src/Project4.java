/**
 * Nate West 
 * CSMC 256 - Project 4 
 * Priority Request Processing 
 * Purpose: The purpose of this class is to run 
 * 			the priority request processing application
 * Description: This class reads in a file of requests, creating request 
 * 				objects from the file and pushing them onto a stack of pending requests
 * 				Clerk class to process. Once the Clerk has processed all the requests, 
 * 				the processing information is written to a new file.
 * Input: A text file with Requests
 * Output: Times requests finish processing
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Project4 {

	// private static PriorityQueue<Request> requests = new
	// PriorityQueue<Request>();

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
			fileReader = validate(fileName); // creates the fileReader from the validated file
			readFile(fileReader); // method to read the file
		} catch (FileNotFoundException e) {
			System.out.println("*** File not found");
		} catch (IllegalArgumentException e) {
			System.out.println("*** Invalid value");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("*** ArrayList is out of bounds");
		} catch (EmptyStackException e) {
			System.out.println("*** Something wrong with Stack");
		}
	}

	/*
	 * method that reads through the input file
	 * 
	 * @param Scanner
	 * @throws IllegalArgumentException
	 */
	private static void readFile(Scanner fileReader) throws IllegalArgumentException {
		ArrayList<Request> list = new ArrayList<Request>();
		Request request = null;
		Scanner lineReader = null;
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			lineReader = new Scanner(line);
			request = new Request(lineReader.nextInt(), lineReader.nextInt(), lineReader.nextInt(),
					lineReader.nextInt(), lineReader.nextLine());
			list.add(request);
		}
		
		int counter = 0;
		Clerk clerk = new Clerk();
		PriorityQueue<Request> queue = new PriorityQueue<Request>();
		Stack<Request> pendingRequests = new Stack<Request>();
		while(!isDone(queue)) {
			clerk.incrementTime();
			Request current = list.get(counter);
			if (clerk.getTime() == current.getET()) {
				counter++;
				queue.add(current);
				clerk.addRequest(current, queue);	
			} 
		}
//		while(!queue.isEmpty()) {
//			System.out.println(queue.poll());
//		}
	}
	
	// checks if the PriorityQueue of Requests is finished
	private static boolean isDone(PriorityQueue<Request> requests) {
		while (requests.isEmpty()) {
			return false;
		}
		return false;
	}
	
	// prompts user to enter a file
	private static String promptUserForFile() {
		System.out.print("Enter the file name: ");
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	// validating the file
	private static Scanner validate(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
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
		System.out.println("    |       Project #4       |");
		System.out.println("    |   Request Processing   |");
		System.out.println("     ~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
	}
}