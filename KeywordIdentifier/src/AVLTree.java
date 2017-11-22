/**
 * Nate West
 * CSMC 256
 * Project 5 – Java Keyword Identifier
 * Purpose: This class models a self-balancing AVL tree data structure
 * Description: This class creates a AVL binary tree and balances the
 * 				tree automatically. As more nodes are added, the tree
 * 				checks the heights of the nodes, making sure each is
 * 				either -1, 0, or 1.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

    public class AVLTree<T extends Comparable<? super T>> {

    	private Node<T> root; // tree's root node

    	// tree constructor
        public AVLTree(){
            root = null;
        }

        // helper method for insert()
		public void add(T element) {
            root = add(element, root);
        }

        // inserts a node into the tree, returns the newNode
		private Node<T> add(T element, Node<T> newNode) {
            if (newNode == null)
                newNode = new Node<T>(element, null, null);
            else if (element.compareTo(newNode.getElement()) < 0) {
                newNode.setLeft(add(element, newNode.getLeft()));
                System.out.println("newNode= " + newNode + "  " + "newNode's Left= " + newNode.getLeft());
                if (height(newNode.getLeft()) - height(newNode.getRight()) == 2) {
                    if (element.compareTo(newNode.getLeft().getElement()) < 0)
                        newNode = rotateWithLeftChild(newNode);
                    else
                        newNode = doubleWithLeftChild(newNode);
                }
            }
            else if (element.compareTo(newNode.getElement()) > 0) {
                newNode.setRight(add(element, newNode.getRight()));
                System.out.println("newNode= " + newNode + "  " + "newNode's Right= " + newNode.getRight());
                if (height(newNode.getRight()) - height(newNode.getLeft()) == 2) {
                    if (element.compareTo(newNode.getRight().getElement()) > 0)
                        newNode = rotateWithRightChild(newNode);
                    else
                        newNode = doubleWithRightChild(newNode);
                }
            }
            else;
            newNode.setHeight(max(height(newNode.getLeft()),
            		height(newNode.getRight())) + 1);
            return newNode;
        }

        // [1] single rotation for node with left child, updates height, returns new root
        private Node<T> rotateWithLeftChild(Node<T> nodeToRotate) {
            Node<T> newNode = nodeToRotate.getLeft();
            nodeToRotate.setLeft(newNode.getRight());
            newNode.setRight(nodeToRotate);
            nodeToRotate.setHeight(max(height(nodeToRotate.getLeft()),
            		height(nodeToRotate.getRight()) + 1));
            newNode.setHeight(max(height(newNode.getLeft()),
            		nodeToRotate.getHeight()) + 1);
            return newNode;
        }

        // [2] double rotation for node with first lc with its rc, then another
        private Node<T> doubleWithLeftChild(Node<T> nodeToRotate) {
            nodeToRotate.setLeft(rotateWithRightChild(nodeToRotate.getLeft()));
            return rotateWithLeftChild(nodeToRotate);
        }

        //[3] double rotation for node; first node's rc with lc, then with node's new rc
        private Node<T> doubleWithRightChild(Node<T> nodeToRotate) {
            nodeToRotate.setRight(rotateWithLeftChild(nodeToRotate.getRight()));
            return rotateWithRightChild(nodeToRotate);
        }

        // [4] single rotation for node with right child, updates height, returns new root
        private Node<T> rotateWithRightChild(Node<T> nodeToRotate) {
            Node<T> newNode = nodeToRotate.getRight();
            nodeToRotate.setRight(newNode.getLeft());
            newNode.setLeft(nodeToRotate);
            nodeToRotate.setHeight(max(height(nodeToRotate.getLeft()),
            		height(nodeToRotate.getRight())) + 1);
            newNode.setHeight(max(height(newNode.getRight()),
            		nodeToRotate.getHeight()) + 1);
            return newNode;
        }

        // prints a sorted tree
        public void printTree() {
            if(isEmpty())
                System.out.println("The tree is empty!");
            else
                levelOrder(root);
        }

        // prints tree using level-order traversal
        public void levelOrder(Node<T> root) {
        	System.out.println("Printing tree using level-order... \n");
            Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
            Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
            currentLevel.add(root);
            int levelCounter = 0;

            while (!currentLevel.isEmpty()) {
                Iterator<Node<T>> iter = currentLevel.iterator();
                while (iter.hasNext()) {
                	   Node<T> currentNode = iter.next();
                    if (currentNode.getLeft() != null) {
                        nextLevel.add(currentNode.getLeft());
                    }
                    if (currentNode.getRight() != null) {
                        nextLevel.add(currentNode.getRight());
                    }
                    System.out.print(currentNode.getElement() + " ");
                }
                System.out.println();
                currentLevel = nextLevel;
                levelCounter++;
                nextLevel = new LinkedList<Node<T>>();
            }
            System.out.println("\nThe depth of the last node is " + levelCounter);
        }

        // returns the element of the given node
        private T elementAt(Node<T> node) {
            return node == null ? null : node.getElement();
        }

       // helper method for main find() method
        public boolean find(T element) {
            if (element.equals(elementAt(find(element, root))))
            	return true;
            return false;
        }

        // finds element in the tree, returns matched node containing element
        private Node<T> find(T element, Node<T> node) {
            while (node != null)
                if (element.compareTo(node.getElement()) < 0 )
                    node = node.getLeft();
                else if(element.compareTo(node.getElement()) > 0 )
                	node = node.getRight();
                else
                    return node;
            return null;   // no match
        }

        // returns true if tree is empty
        public boolean isEmpty() {
            return root == null;
        }

        // returns root of the tree
        public Node<T> getRoot() {
            return root;
        }

        // returns height of the node
        private int height(Node<T> node) {
        	return node == null ? -1 : node.getHeight();
        }

        // returns max of left and right child ****STILL HAVE QUESTIONS
        private int max(int lhs, int rhs) {
            return lhs > rhs ? lhs : rhs;
        }

}
