package sjsu.cs146.project3;

public class LinkedList {
	LinkedList() {
		head = null;
		length = 0;
	}
	
	// Adds a value into the front of the linked list
	public void add(int newValue) {
		Node next = head;
		
		Node newNode = new Node();
		newNode.setValue(newValue);
		
		head = newNode;
		newNode.next = next;
		
		length++;
	}
	
	public int length() {
		return length;
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
		
		public void setPosition(int newPosition) {
			position = newPosition;
		}
		
		public int getPosition() {
			return position;
		}
		
		public Node next;
		
		private int value;
		private int position;
	}
	
	private int length;
}
