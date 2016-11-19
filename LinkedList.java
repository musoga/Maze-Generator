package sjsu.cs146.project3;

public class LinkedList {
	LinkedList() {
		head = null;
	}
	
	// Adds a value into the front of the linked list
	public void add(int newValue) {
		Node next = head.next;
		
		Node newNode = new Node();
		newNode.setValue(newValue);
		
		head = newNode;
		newNode.next = next;
	}
	
	public Node head;
	
	public class Node {
		Node() {
			next = null;
		}
		
		public void setValue(int newValue) {
			value = newValue;
		}
		
		public int getValue() {
			return value;
		}
		
		public Node next;
		
		private int value;
	}
}
