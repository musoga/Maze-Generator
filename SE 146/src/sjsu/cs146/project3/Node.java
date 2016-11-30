package sjsu.cs146.project3;

public class Node {
	Node() {
		next = null;
	}
	
	public void setPosition(int newPosition) {
		position = newPosition;
	}
	
	public int getPosition() {
		return position;
	}
	
	public Node next;
	
	private int position;
}

