
import java.util.*;
import java.io.*;

public class GoofyGolf1 {
	public static void printHeading() {
		System.out.println("Yonathan Mckonnen");
		System.out.println("CSMC 225");
		System.out.println("Project 5");
		System.out.println("Goofy Golf ");
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
	
	public static void main(String[] args) throws FileNotFoundException, NoSuchElementException {
		printHeading();
		String fileName;
		if (args.length > 0) {
			fileName = args[0];
		} else {
			fileName = askForFile();
		}
		
		int[][] parValuesData = new int[][] { 
				new int[] { 0, 8, 8, 9, 7, 5, 7, 8, 5, 8 }, 
				new int[] { 0, 7, 7, 8, 6, 5, 6, 7, 5, 6 }, 
				new int[] { 0, 6, 5, 6, 5, 4, 5, 5, 4, 5 },
				new int[] { 0, 5, 4, 4, 4, 3, 4, 3, 3, 4 },
				new int[] { 0, 4, 3, 3, 3, 2, 3, 2, 3, 3 } 
				};

		int[] golfHole = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()) {
			String word = in.nextLine();
			Scanner translator = new Scanner(word);
			String player = translator.next();
			int age = translator.nextInt();
			int[] outcome = new int[10];
		
			while (translator.hasNextLine()) {
				for (int i = 0; i < outcome.length; ++i) {
					outcome[i] = translator.nextInt();
					int overallScores = 0;
					int j = 1;
					while (translator.hasNextInt()) {
					if (age <= 4) { 
						System.out.println(player + ":");
						int sumRowOne = 0;
						for (int y : parValuesData[0])
							sumRowOne = sumRowOne + y;
						for (int column = 1; column < parValuesData[0].length; column++) {
							if (outcome[i] < parValuesData[0][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Under Par" );
								overallScores = overallScores + outcome[i];
							} else if (outcome[i] > parValuesData[0][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Over Par" );
								overallScores = overallScores + outcome[i];
							} else {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Par" );
								overallScores = overallScores + outcome[i];
							}
							if (translator.hasNextInt()) {
								outcome[i] = outcome[i + 1]; 
								outcome[i] = translator.nextInt();
							}
							j++;
						}	
						sumRowOne = sumRowOne - overallScores;
						System.out.println("You were " + sumRowOne + " over par");
					}
					else if (age >= 5 && age <= 7) {
						System.out.println(player + ":");
						int sumRowTwo = 0;
						for (int y : parValuesData[1])
							sumRowTwo = sumRowTwo + y;
						for (int column = 1; column < parValuesData[1].length; column++) {
							if (outcome[i] < parValuesData[1][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Under Par" );
								overallScores = overallScores + outcome[i];
							} else if (outcome[i] > parValuesData[1][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Over Par" );
								overallScores = overallScores + outcome[i];
							} else {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Par" );
								overallScores = overallScores + outcome[i];
							}
							if (translator.hasNextInt()) {
								outcome[i] = outcome[i + 1]; 
								outcome[i] = translator.nextInt();
							}
							j++;
						}
						sumRowTwo = sumRowTwo - overallScores;
						System.out.println("You were " + sumRowTwo + " over par");
					}
					else if (age >= 8 && age <= 11) {
						int sumRowThree = 0;
						for (int y : parValuesData[2])
							sumRowThree = sumRowThree + y;
						System.out.println(player + ":");
						for (int column = 1; column < parValuesData[2].length; column++) {
							if (outcome[i] < parValuesData[2][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Under Par" );
								overallScores = overallScores + outcome[i];
							} else if (outcome[i] > parValuesData[2][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Over Par" );
								overallScores = overallScores + outcome[i];
							} else {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Par" );
								overallScores = overallScores + outcome[i];
							}
							if (translator.hasNextInt()) {
								outcome[i] = outcome[i + 1]; 
								outcome[i] = translator.nextInt();
							}
							j++;
						}
						sumRowThree = sumRowThree - overallScores;
						System.out.println("You were " + sumRowThree + " over par");
					}
					else if (age >= 12 && age <= 15) {
						int sumRowFour = 0;
						for (int y : parValuesData[3])
							sumRowFour = sumRowFour + y;
						System.out.println(player + ":");
						for (int column = 1; column < parValuesData[3].length; column++) {
							if (outcome[i] < parValuesData[3][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Under Par" );
								overallScores = overallScores + outcome[i];
							} else if (outcome[i] > parValuesData[3][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Over Par" );
								overallScores = overallScores + outcome[i];
							} else {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Par" );
								overallScores = overallScores + outcome[i];
							}
							if (translator.hasNextInt()) {
								outcome[i] = outcome[i + 1]; 
								outcome[i] = translator.nextInt();
							}
							j++;
						}
						sumRowFour = sumRowFour - overallScores;
						System.out.println("You were " + sumRowFour + " over par");
					} else {
						System.out.println(player + ":");
						int sumRowFive = 0;
						for (int y : parValuesData[4])
							sumRowFive = sumRowFive + y;
						for (int column = 1; column < parValuesData[4].length; column++) {
							if (outcome[i] < parValuesData[4][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Under Par" );
								overallScores = overallScores + outcome[i];
							} else if (outcome[i] > parValuesData[4][column]) {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Over Par" );
								overallScores = overallScores + outcome[i];
							} else {
								System.out.println("Hole " + golfHole[j] + " - " + outcome[i] + " Par" );
								overallScores = overallScores + outcome[i];		
							}
							if (translator.hasNextInt()) {
								outcome[i] = outcome[i + 1]; 
								outcome[i] = translator.nextInt();
							}
							j++;
						}
						sumRowFive = sumRowFive - overallScores;
						System.out.println("You were " + sumRowFive + " over par");
					}
	
				}
					System.out.println("Total score: " + overallScores);
					System.out.println();
					word = in.nextLine();
					translator = new Scanner(word);
					player = translator.next();
					age = translator.nextInt();
				}
				translator.close();
			}
			
		}
		in.close();	
	}
	

}
