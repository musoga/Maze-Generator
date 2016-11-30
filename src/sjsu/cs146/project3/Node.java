package sjsu.cs146.project3;

public class Node {
	Node() {
		next = null;
		color = Colors.WHITE;
	}
	
	public void setPosition(int newPosition) {
		position = newPosition;
	}
	
	public int getPosition() {
		return position;
	}
	
	public Colors getColor() {
		return color;
	}
	
	public void setColor(Colors newColor) {
		color = newColor;
	}
	
	public Node next;
	
	public enum Colors { WHITE, BLACK, GREY };
	
	private Colors color;
	
	private int position;
}

