package sjsu.cs146.project3;

public class Node {
	Node() {
		next = null;
		color = Colors.WHITE;
	}
	
	/**
	 * sets the position of the 
	 * node in the maze
	 * @param newPosition
	 */
	public void setPosition(int newPosition) {
		position = newPosition;
	}
	/**
	 * get the position of the 
	 * node in the maze
	 * @return position
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * returns the color value of the node 
	 * @return color
	 */
	public Colors getColor() {
		return color;
	}
	
	/**
	 * sets the color of the
	 * node 
	 * @param newColor
	 */
	public void setColor(Colors newColor) {
		color = newColor;
	}
	/**
	 * sets the distance of how 
	 * far the node from the source
	 * @param num
	 */
	public void setDistance(int num){
		distance = num;
	}
	/**
	 * returns the value of distance
	 * @return distance
	 */
	public int getDistance(){
		return distance;
	}
	
	public void setParent(int newParent) {
		parent = newParent;
	}
	
	public int getParent() {
		return parent;
	}
	
	public Node next;
	public enum Colors { WHITE, BLACK, GREY };
	private int distance;
	private int parent;
	private Colors color;
	private int position;
}

