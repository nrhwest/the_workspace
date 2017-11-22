 /**
 * Nate West
 * CSMC 256
 * Project 5 – Java Keyword Identifier
 * Purpose: This class models a Node in a Binary Tree
 * Description: A typical TreeNode variable with and element,
 * 				left child, right child, and element.
 */

public class Node<T extends Comparable<? super T>> {

	private Node<T> left, right; // left & right child
	private T element; // element of any type
	private int height = 0; // node's height

	// default constructor 
	public Node(T element) {
		this(element, null, null);
	}
	
	// parameterized constructor
	public Node(T element, Node<T> left, Node<T> right) {
		this.element = element;
		this.left = left;
		this.right = right;
		height = 0;
	}
	
	// sets the element of the node
	public void setElement(T element) {
		this.element = element;
	}
	
	// sets the left child of the node
	public void setLeft(Node<T> left) {
		this.left = left;
	}

	// sets the right child of the node
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	// sets the height of the node
	public void setHeight(int height) {
		this.height = height;
	}

	// returns the element of the node
	public T getElement() {
		return element;
	}

	// returns the left child of the node
	public Node<T> getLeft() {
		return left;
	}

	// returns the right child of the node
	public Node<T> getRight() {
		return right;
	}
	
	// returns the height of the node
	public int getHeight() {
		return height;
	}
	
	// returns true if two nodes are equal to each other
	public boolean equals(Node<T> obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Node) {
			Node<T> alt = (Node<T>) obj;
			if (element.equals(alt.element))
				return true;
		}
		return false;
	}

	@Override
	// returns instance variables as Strings values
	public String toString() {
		return (String) element ;
	}
}
