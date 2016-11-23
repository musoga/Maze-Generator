package sjsu.cs146.project3;

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

