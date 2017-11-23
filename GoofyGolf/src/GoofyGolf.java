/*
 * Nathan West
 * CSMC 255
 * Project 5
 * This program reads in a file containing the scores
 * from players at Rams Goofy Golf. The program sorts the age of the players 
 * then determines whether the players score for each hole is under par, over par or par.
 */
import java.util.*;
import java.io.*;

public class GoofyGolf {
	
	public static void main(String[] args) throws FileNotFoundException, NoSuchElementException {
		// TODO Auto-generated method stub
		printHeading();
		
		String fileName;
		if (args.length > 0) {
			fileName = args[0];
		} else {
			fileName = askForFile();
		}
		
		int[][] parValues = new int[][] { 
				 { 0, 8, 8, 9, 7, 5, 7, 8, 5, 8 }, 
				 { 0, 7, 7, 8, 6, 5, 6, 7, 5, 6 }, 
				 { 0, 6, 5, 6, 5, 4, 5, 5, 4, 5 },
				 { 0, 5, 4, 4, 4, 3, 4, 3, 3, 4 },
				 { 0, 4, 3, 3, 3, 2, 3, 2, 3, 3 } 
				};
		/*
		 * FILE TESTING: Pritchett-Delgado_Scores.txt
		 */
		int[] holes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		File file = new File(fileName);
		Scanner fileReader = new Scanner(file);
		
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			Scanner txtScan = new Scanner(line);
			String name = txtScan.next();
			int age = txtScan.nextInt();
			int[] scores = new int[10];
			
			while (txtScan.hasNextLine()) {
				for (int x = 0; x < scores.length; ++x) {
					if (txtScan.hasNextInt())
						scores[x] = txtScan.nextInt();
					int total = 0;
					int y = 1;
					while (txtScan.hasNextInt()) {
					if (age <= 4) { 
						System.out.println(name + ":");
						for (int col = 1; col < parValues[0].length; col++) {
							if (scores[x] < parValues[0][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Under Par" );
								total = total + scores[x];
							} else if (scores[x] > parValues[0][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Over Par" );
								total = total + scores[x];
							} else {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Par" );
								total = total + scores[x];
							}
							if (txtScan.hasNextInt()) {
								scores[x] = scores[x + 1]; 
								scores[x] = txtScan.nextInt();
							}
							y++;
						}	
					}
					else if (age >= 5 && age <= 7) {
						System.out.println(name + ":");
						for (int col = 1; col < parValues[1].length; col++) {
							if (scores[x] < parValues[1][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Under Par" );
								total = total + scores[x];
							} else if (scores[x] > parValues[1][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Over Par" );
								total = total + scores[x];
							} else {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Par" );
								total = total + scores[x];
							}
							if (txtScan.hasNextInt()) {
								scores[x] = scores[x + 1]; 
								scores[x] = txtScan.nextInt();
							}
							y++;
						}
					}
					else if (age >= 8 && age <= 11) {
						System.out.println(name + ":");
						for (int col = 1; col < parValues[2].length; col++) {
							if (scores[x] < parValues[2][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Under Par" );
								total = total + scores[x];
							} else if (scores[x] > parValues[2][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Over Par" );
								total = total + scores[x];
							} else {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Par" );
								total = total + scores[x];
							}
							if (txtScan.hasNextInt()) {
								scores[x] = scores[x + 1]; 
								scores[x] = txtScan.nextInt();
							}
							y++;
						}
					}
					else if (age >= 12 && age <= 15) {
						System.out.println(name + ":");
						for (int col = 1; col < parValues[3].length; col++) {
							if (scores[x] < parValues[3][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Under Par" );
								total = total + scores[x];
							} else if (scores[x] > parValues[3][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Over Par" );
								total = total + scores[x];
							} else {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Par" );
								total = total + scores[x];
							}
							if (txtScan.hasNextInt()) {
								scores[x] = scores[x + 1]; 
								scores[x] = txtScan.nextInt();
							}
							y++;
						}
					} else {
						System.out.println(name + ":");
						for (int col = 1; col < parValues[4].length; col++) {
							if (scores[x] < parValues[4][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Under Par" );
								total = total + scores[x];
							} else if (scores[x] > parValues[4][col]) {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Over Par" );
								total = total + scores[x];
							} else {
								System.out.println("Hole " + holes[y] + " - " + scores[x] + " Par" );
								total = total + scores[x];		
							}
							if (txtScan.hasNextInt()) {
								scores[x] = scores[x + 1]; 
								scores[x] = txtScan.nextInt();
							}
							y++;
						}
					}
	
				}
					System.out.println("Total score: " + total);
					System.out.println();
					if (txtScan.hasNextLine()) {
						line = fileReader.nextLine();
						txtScan = new Scanner(line);
						name = txtScan.next();
						age = txtScan.nextInt();
					}
				}
				//txtScan.close();
			}
			
		}
		//fileReader.close();	
	}
	
	public static void printHeading() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("Nathan West");
		System.out.println("CSMC 225");
		System.out.println("Project 5");
		System.out.println("Goofy Golf Application");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	private static String askForFile() {
		System.out.println("Enter the file name: ");
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
