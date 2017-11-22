/**
 * Nate West
 * CSMC 256 - Project 3
 * Purpose: To create a linked list
 * Description: This class creates a doubly-linked list by extending
 * 				the AbstractLinkedList's standard construction of a 
 * 				singly-linked list and implements it's abstract methods
 * 				which have the ability create a doubly-linked list
 */

// extends AbstractLinkedList to implement its abstract methods
public class MyLinkedList<E> extends AbstractLinkedList<E> { 
	
	@Override
	// checks if the nodeToRemove has been removed, returns boolean 
	public boolean remove(E obj) { 
		Node<E> curr = myFront.getNext();
        while (!curr.equals(myBack)) {
            if (curr.getElement().equals(obj)) {
                curr.getPrevious().setNext(curr.getNext());
                curr.getNext().setPrevious(curr.getPrevious());
                mySize--;
                return true;
            }
            curr = curr.getNext();
        }
        return false;
	}

	@Override
	// checks if the doubly-linked list contains the object, returns boolean
	public boolean contains(E obj) {
		return lastIndexOf(obj) != -1;
	}

	@Override
	/* grabs the node's element at its position/index in the list, 
	 * grabs from getNodeAt() returns generic type(non-Javadoc)
	 * @see AbstractLinkedList#get(int)
	 */
	public E get(int index) { 
		return getNodeAt(index).getElement();	
	}

	@Override
	// return's the object's position/index in the doubly-linked list
	public int indexOf(E obj) {
		Node<E> curr = myFront.getNext();
		for (int n = 0; n < size() - 1; n++) {
			if (curr.getElement().equals(obj))
				return n;
			curr = curr.getNext();
		}
		return -1;
	}

	@Override
	// traverses the doubly-linked list backwards till loop node, returns int index
	public int lastIndexOf(E obj) {
		Node<E> curr = myBack.getPrevious();
		for (int n = size() - 1; n >= 0; n--) {
			if (curr.getElement().equals(obj))
				return n;
			curr = curr.getPrevious();
		}
		return -1;
	}

	@Override
	// traverses the DLL till loop reaches nodes index, returns generic type Node
	protected Node<E> getNodeAt(int index) throws IndexOutOfBoundsException {
		Node<E> curr = myFront.getNext();
		for (int n = 0; n < index; n++) 
			curr = curr.getNext();
		return curr;
	}

	@Override
	// creates an array from DLL making elements better to print, returns generic type array
	public E[] toArray() {
		E[] list = (E[]) new Object[size()];
		Node<E> curr = myFront.getNext();
		for (int n = 0; n <= size() - 1; n++) {
			list[n] = (E) curr.getElement();
			curr = curr.getNext();
		}
		return (E[]) list;
	}

	@Override
	// since the data types are generic, elements must be casted as Strings
	public String toString() {
		String result = "[";
        if (!isEmpty()) {
            Node<E> curr = myFront.getNext();
            while (!curr.equals(myBack)) {
                E element = curr.getElement();
                result = result + element.toString();
                if (curr.getNext() != myBack)              
                   result = result + ", ";        
                curr = curr.getNext();
            }
        }
        result = result + "]";
        return result;
	}
}
 