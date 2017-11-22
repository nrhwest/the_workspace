/**
 * Nate West
 * CSMC 256
 * Project 5 – Java Keyword Identifier
 * Purpose: This class models a dictionary of variable names
 * Description: This class reads a Java source code file and parses the file
 * 				leaving just it's variable names and keywords. Then it compares
 * 				the AVLTree of keywords to the tokens found from the file, creating
 * 				a dictionary of variable names.
 */

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
	
	private TreeMap<String, Integer> dictionary; // declares a new dictionary

	// constructor initializing the dictionary
	public Dictionary() {
		dictionary = new TreeMap<String, Integer>();
	}

	// reads the Java source code and compares tokens against AVLTree of keywords
	@SuppressWarnings("unchecked")
	public void readFile(Scanner fileReader, @SuppressWarnings("rawtypes") AVLTree tree) {
		String regex = "([({0-9\\s.:/',\";=<>+\\[\\]*})])+";
		while (fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			int quoteStart = line.indexOf("\"");
			while (quoteStart > -1) {	
				int quoteEnd = line.indexOf("\"", quoteStart + 1);
				String temp = line.substring(quoteEnd + 1, line.length() - 1);
				line = line.substring(0, quoteStart);
				line = line.concat(temp);
				if (line.contains("\""))
					quoteStart = line.indexOf("\"");
				else
					quoteStart = -1;
			} if (line.equals("") || line.startsWith("//") 
					|| line.startsWith("/*") || line.startsWith("/**") 
					|| line.startsWith("*") || line.startsWith("*/"))
				continue;
			else;	
			@SuppressWarnings("resource")
			Scanner lineReader = (new Scanner(line)).useDelimiter(regex);
			while (lineReader.hasNext()) {
				String nextWord = (lineReader.next());
				Integer count = dictionary.get(nextWord);
				if (tree.find(nextWord))
					continue;
				else if (count == null) 
					dictionary.put(nextWord, new Integer(1));
				else {
					count++;
					dictionary.put(nextWord, count);
				}
			}
		}
	}

	// displays identifiers and their frequencies of occurrence
	public void display() {
		Set<Map.Entry<String, Integer>> allWords = dictionary.entrySet();
		Iterator<Map.Entry<String, Integer>> keyIterator = allWords.iterator();

		while (keyIterator.hasNext()) {
			Map.Entry<String, Integer> element = keyIterator.next();
			System.out.println(element.getValue() + " - " + element.getKey());
		}
	}
}
