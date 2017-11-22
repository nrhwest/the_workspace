/*
 * Nate West
 * Created Sept 2016, Modified May 2017
 * Purpose: A class to calculate my grades
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = null;
		if (args.length > 0) {
			file = new File(args[0]);
			System.out.println("File found!");
		} else {
			file = new File(promptUserForFile());
		}
		Scanner fileReader = null;
		try {
			fileReader = validate(file); // creates the fileReader from the validated file
			readFile(fileReader); // method to read the file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// reads the grades.txt file
	public static void readFile(Scanner fileReader) {
		double homework = 0, maxHomeworkPoints = 0;
		double testOne = 0, maxTestOnePoints = 0;
		double testTwo = 0, maxTestTwoPoints = 0;
		double testThree = 0, maxTestThreePoints = 0;
		double projects = 0, maxProjectsPoints = 0;
		double finalExam = 0, maxFinalExamPoints = 0;
		double finalGrade;

		// start fixing the grade here
		System.out.println();
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			if (line.startsWith("Homework:")) {
				String[] data = line.split(" ");
				homework = Double.parseDouble(data[1]);
				maxHomeworkPoints = Double.parseDouble(data[2]);
				System.out.println("Homework - " + homework + "/" + maxHomeworkPoints);
			}
			else if (line.startsWith("Test 1:")) {
				String[] data = line.split(" ");
				testOne = Double.parseDouble(data[2]);
				maxTestOnePoints = Double.parseDouble(data[3]);
				System.out.println("Test 1 - " + testOne + "/" + maxTestOnePoints);
			}
			else if (line.startsWith("Test 2:")) {
				String[] data = line.split(" ");
				testTwo = Double.parseDouble(data[2]);
				maxTestTwoPoints = Double.parseDouble(data[3]);
				System.out.println("Test 2 - " + testTwo + "/" + maxTestTwoPoints);
			}
			// else if (line.startsWith("Test 3:")) {
			// 	String[] data = line.split(" ");
			// 	testThree = Double.parseDouble(data[2]);
			// 	maxTestThreePoints = Double.parseDouble(data[3]);
			// 	System.out.println("Test 3 - " + testThree + "/" + maxTestThreePoints);
			// }
			else if (line.startsWith("Projects:")) {
				String[] data = line.split(" ");
				projects = Double.parseDouble(data[1]);
				maxProjectsPoints = Double.parseDouble(data[2]);
				System.out.println("Projects - " + projects + "/" + maxProjectsPoints);
			}
			else if (line.startsWith("Final Exam:")) {
				String[] data = line.split(" ");
				finalExam = Double.parseDouble(data[2]);
				maxFinalExamPoints = Double.parseDouble(data[3]);
				System.out.println("Final Exam - " + finalExam + "/" + maxFinalExamPoints);
			} else;
		}

		// calculates the grades on each item, then multiplies by the weight
		homework = (homework / maxHomeworkPoints) * 0.15;
		testOne = (testOne / maxTestOnePoints) * 0.15;
		testTwo = (testTwo / maxTestTwoPoints) * 0.15;
		//testThree = (testThree / maxTestThreePoints) * 0.20;
		projects = (projects / maxProjectsPoints) * 0.35;
		finalExam = (finalExam / maxFinalExamPoints) * 0.25;

		// Calculates the final grade
		finalGrade = (homework + testOne + testTwo + projects + finalExam) * 100; //
		System.out.printf("\nYour final grade is " + "%.1f%%", finalGrade);

		// conditions check if the final grade corresponds with the proper letter grade
		if (finalGrade >= 90.0 && finalGrade <= 100) {
			System.out.print(", which means your letter grade is an A\n");
		}
		else if (finalGrade >= 80.0 && finalGrade <= 89.9) {
			System.out.print(", which means your letter grade is a B\n");
		}
		else if (finalGrade >= 70.0 && finalGrade <= 79.9) {
			System.out.print(", which means your letter grade is a C\n");
		}
		else if (finalGrade >= 60.0 && finalGrade <= 69.9) {
			 System.out.print(", which means your letter grade is a D\n");
		} else {
			System.out.print(", which means your letter grade is a F\n");
		}
	}

	// asks the user for the file
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
}
