
public class Node {

	private String name, phone;
	private Node next;
	
	public Node(String n, String p) {
		name = n;
		phone = p;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setPhone(String p) {
		phone = p;
	}
	
	public void setNext(Node nxt) {
		next = nxt;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public Node getNext() {
		return next;
	}
	
}
