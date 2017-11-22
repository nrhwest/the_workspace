import java.util.Scanner;

public class Controller {

	Queue customers = new Queue();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Controller c = new Controller();
		c.runMenu();
	}
	
	private String displayMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.println("Press a to add");
		System.out.println("Press r to remove");
		System.out.println("Press f to find");
		System.out.println("Press q to quit");
		System.out.print("Enter your choose here: ");
		String input = scan.nextLine();
		
		return input;
	}
	
	public void runMenu() {
		String input = displayMenu();
		
		while (!input.equals("q")) {
			if (input.equals("a")) {
				askNode();
			} else if (input.equals("r")) {
				forwardPerson();
			} else if (input.equals("f")) {
				find();
			} else {
				System.out.println("Unknown command...");
			}
	
			input = displayMenu();
		}
	}
	
	public void askNode() {
		/*
		 * 1. Ask user for customer details
		 * 2. Create a new node with them
		 * 3. Give this Node to the Queue's push(Node) method
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the customer's name: ");
		String name = scan.nextLine();
		
		System.out.print("Enter the customer's phone number: ");
		String phone = scan.nextLine();

		Node newCustomer = new Node(name, phone);
		customers.push(newCustomer);
	}
	
	public void forwardPerson() { // Removes the last person in the queue
		customers.pop();
	}
	
	public void find() {
		/*
		 * 1. Ask the user for the name of the customers
		 * 2. Call the Queues' find(string) method with this name
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the customer name you're looking for: ");
		String name = scan.nextLine();
		
		Node found = customers.find(name);
		if (found != null) {
			printDetails(found);
		} else {
			System.out.print("Node not found!");
		}
	}
	
	private void printDetails(Node n) {
		System.out.println("Name: " + n.getName());
		System.out.println("Phone Number: " + n.getPhone());
		
		if (n.getName() != null) {
			System.out.println("Next node: " + n.getNext().getName());
		}
	}
}
