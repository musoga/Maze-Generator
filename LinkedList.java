package sjsu.cs146.project3;

public class LinkedList {
	LinkedList() {
		head = null;
		length = 0;
	}
	
	/**
   Adds a value to the beginning of the linked list

   @param nodeToAdd node that represents a vertex to be added to list

   @return void

	*/
	public void add(Node nodeToAdd) {
		Node next = head;
		
		head = nodeToAdd;
		nodeToAdd.next = next;
		
		length++;
	}
	
	/**
   Returns the length of the list

   @param none

   @return void

	*/
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
