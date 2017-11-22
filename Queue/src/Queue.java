
public class Queue {

private Node head;
	
	public void list(Node h) {
		head = h;
	}
	
	public void setHead (Node h) {
		head = h;
	}
	
	public Node getHead() {
		return head;
	}
	
	public void push(Node newOne) {
		if (head == null) {
			head = newOne;
		} else {
			newOne.setNext(head);
			head = newOne;
		}
	}
	
	public Node find(String name) {
		Node marker = head;
		while (marker != null) {
			if (marker.getName().equals(name)) {
				return marker;
			}
			marker = marker.getNext();
		}
		return null;
	}
	
	public void pop() {
		// The last element points to null
		// We have to make its parent point to null instead of the next Node
		/*
		 * Go through the list
		 * If the next node is going to be the last element
		 * We remove it from the Queue
		 */
		
		Node marker = head;
		while (marker != null) { // while the marker is not null – means we're not at the end of the queue, so we can keep going
			Node child = marker.getNext(); // A child Node is created, which is the marker's next Node
				// If this child is the last Node, we want to remove it, but first we need to make sure it isn't null
			if (child != null) { // Checks to see if child is not equal to Node
				if (child.getNext() == null) { // Checks to see if child's next Node is null
						// child was the last Node
					marker.setNext(null);
						// If the child's next Node is null, we must also set the parent's next Node equal to null
				}
			}
			marker = marker.getNext();
		}
	}
}
