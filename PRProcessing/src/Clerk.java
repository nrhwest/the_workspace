/**
 * Nate West
 * CSMC 256 - Project 4
 * Priority Request Processing
 * Purpose: This class models a Clerk who handles process Requests
 * Description: This class handles all the processing and moving of
 * 				requests. If an active Request's priority is lower than
 * 				an incoming Request's, the active Request is pushed onto the
 * 				pendingRequest Stack and waits, while the incoming Request begins processing.
 * Input: A text file with Requests
 * Output: Times requests finish processing
 */

import java.util.PriorityQueue;
import java.util.Stack;

public class Clerk {

	private int time;
	private Stack<Request> pendingRequests = new Stack<Request>();

	// default constructor
	public Clerk() {
		incrementTime();
	}

	// parameterized constructor
	public Clerk(Request request) {
		Clerk clerk = new Clerk();
		clerk.processRequest(request);
	}

	// actually processes the request, using a counter to count up to it's processingTime
	public void processRequest(Request current) {
		int counter = 0;
		System.out.println(time + ": Request #" + current.getID() + " begins processing");
		while (counter != current.getPT()) {
			counter++;
		}
		System.out.println(time + ": Request #" + current.getID() + " finishes processing");
	}

	/*
	 * adds the requests to the queue, while comparing it 
	 * to the top of the stack for processing
	 */
	public void addRequest(Request current, PriorityQueue<Request> queue) {
		Clerk clerk = new Clerk();
		System.out.println(time + ": Request #" + current.getID() + " (time needed: " + current.getPT() + ")"
				+ " arrives with a priority of " + current.getPriority());
		queue.add(current);
		if (pendingRequests.empty()) {
			clerk.processRequest(current);
		} else {
			Request temp = pendingRequests.peek();
			if (temp.getPriority() < current.getPriority()) {
				clerk.processRequest(pendingRequests.pop());
				pendingRequests.push(current);
			}
		}
	}

	// gets the next requests to be processed
	public void getNextRequest(Stack<Request> pendingRequests, PriorityQueue<Request> queue) {
		Request next = queue.peek();
		Request temp = pendingRequests.peek();
		if (next.getPriority() < temp.getPriority()) {
			processRequest(queue.poll());
		} else
			processRequest(pendingRequests.pop());
	}

	// increments time when called
	public void incrementTime() {
		time++;
	}

	// returns time
	public int getTime() {
		return time;
	}

}
