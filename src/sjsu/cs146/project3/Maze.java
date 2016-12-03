package sjsu.cs146.project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.PriorityQueue;

public class Maze {
	/**
   Two parameter constructor that seeds the random number generator and intializes 
   the dimensions

   @param startHeight height of maze
   
   @param startWidth width of maze

   @return void

	*/
	Maze(int startHeight, int startWidth) {
		lengthOfSide=(1+(startHeight*2));
		mazeString= new String[lengthOfSide*lengthOfSide];

		randomGenerator = new Random();
		randomGenerator.setSeed(System.currentTimeMillis());
		
		height = startHeight;
		width = startWidth;
		
		mazeGraph = new LinkedList[height * width];
		
		for(int index = 0;index < mazeGraph.length;index++) {
			mazeGraph[index] = new LinkedList();
		}
		
		// creates a blank maze to be changed
		for (int i = 0; i < mazeString.length; i++) {
			
			if (i % lengthOfSide == 0 && i%2==1) {
				for (int x = 1; x <= lengthOfSide; x++) {
					if (x % 2 == 1) {
						mazeString[i] = "|";
					} else {
						mazeString[i] = "  ";
					}
					i++;
				}
			} if (i % 2 == 0) {
				mazeString[i] = "+";
			} else {
				mazeString[i] = "--";
			}
		}
		mazeString[1]="  ";
		mazeString[mazeString.length-2]="  ";
		
		initializeVertices();
	}
	
	public LinkedList[] getMazeGraph() {
		return mazeGraph;
	}
	
	public void setMazeGraph(LinkedList[] newMaze) {
		mazeGraph = newMaze;
	}
	
	/**
   Generates a maze based on the size of the maze as well as the seed of 
   the random number generator

   @param none

   @return void

	*/
	public void generateMaze() {
		Stack<Integer> cellStack = new Stack<Integer>();
		int totalCells = height * width;
		
		int currentCell = 0;
		
		int visitedCells = 1;
		
		while(visitedCells < totalCells) {
			ArrayList<Node> neighbors = findNeighborsGeneration(currentCell);
			
			if(neighbors.size() > 0) {
				int randomNeighborPosition = randomGenerator.nextInt(neighbors.size());
				int newPosition = neighbors.get(randomNeighborPosition).getPosition();
				
				Node randomNeighbor = new Node();
				randomNeighbor.setPosition(newPosition);
				
				Node currentCellNode = new Node();
				currentCellNode.setPosition(currentCell);
				
				mazeGraph[currentCell].add(randomNeighbor);
				mazeGraph[randomNeighbor.getPosition()].add(currentCellNode);
				
				cellStack.push(currentCell);
				currentCell = newPosition;
				visitedCells++;
			}
			else {
				currentCell = cellStack.pop();
			}
		}
	}
	
	/**
	Auxiliary function for the search algorithms
	to find adjacent neighbors that haven't been visited

	@param position current cell to examine
   
	@return ArrayList<Node> List of neighbors to use for maze generation

	*/
	public ArrayList<Node> findNeighborsGeneration(int position) {
		ArrayList<Node> neighbors = new ArrayList<Node>();
		
		final int MAX_NEIGHBORS = 4;
		
		int[] neighborPosition = { position - width, 
											position - 1, 
											position + 1, 
											position + width };
		
		for(int index = 0;index < MAX_NEIGHBORS;index++) {
			Node cellToConsider = new Node();
			int neighborToConsider = neighborPosition[index];
			cellToConsider.setPosition(neighborToConsider);
			
								
			if(neighborToConsider >= 0
			&& neighborToConsider < height * width
			&& ((position + 1) % width != 0 || neighborToConsider - position != 1)
			&& ((position + 1) % width != 1 || position - neighborToConsider != 1)
			&& mazeGraph[neighborToConsider].length() == 0) {
				
				neighbors.add(cellToConsider);
				
			}
		}
		
		return neighbors;
	}
	/**
	Auxiliary function for the maze generation algorithm
	to find adjacent neighbors that haven't been visited

	@param position current cell to examine
   
	@return ArrayList<Node> List of neighbors to use for maze generation

	*/
	public ArrayList<Node> findNeighbors(int position) {
		Node current = mazeGraph[position].head;
		ArrayList<Node> neighbors = new ArrayList<Node>();
		
		while(current != null) {
			neighbors.add(current);
			current = current.next;
		}
		
		return neighbors;
	}
	
	/**
	 * uses breadth first search to 
	 * find the maze
	 */
	public void searchMazeBFS() {
		PriorityQueue<Node> queue= new PriorityQueue<>();
		Node s= mazeGraph[0].head;
		s.setColor(Node.Colors.GREY);
		
		queue.add(s);
		while(!queue.isEmpty()){
			Node u= queue.poll();
			ArrayList<Node> hold= this.findNeighbors(u.getPosition());

			for (Node v : hold) {
				if (v.getColor() != Node.Colors.WHITE) {
					v.setColor(Node.Colors.GREY);
					v.setDistance(u.getDistance() + 1);
					queue.add(v);
				}
			}
			u.setColor(Node.Colors.BLACK);
		}		
	}
	
	/**
	 * Searches the maze using the depth first search algorithm
	 */
	public void searchMazeDFS() {
		int[] time = new int[1];
		time[0] = 0;
		
		for(Node vertex : vertices) {
			if(vertex.getColor() == Node.Colors.WHITE) {
				dfsVisit(vertex.getPosition(), time);
			}
		}
	}
	
	/**
	 * Recursive depth first search implementation called by SearchMazeDFS
	 * @param position
	 * @param time
	 */
	public void dfsVisit(int position, int[] time) {
		time[0] += 1;
		vertices[position].setDistance(time[0]);
		vertices[position].setColor(Node.Colors.GREY);
		
		for(Node neighbor : findNeighbors(position)) {
			int neighborPosition = neighbor.getPosition();
			if(vertices[neighborPosition].getColor() == Node.Colors.WHITE) {
				vertices[neighborPosition].setParent(position);
				dfsVisit(neighborPosition, time);
			}
		}
		
		vertices[position].setColor(Node.Colors.BLACK);
		time[0] += 1;
	}

	/**
	 * prints the mazeString array
	 */
	public void printMaze() {
		int cellPosition=lengthOfSide+1;

		for (int nodeCell = 0; nodeCell < mazeGraph.length; nodeCell++) {
			ArrayList<Node> neighbors= this.findNeighbors(nodeCell);
			
			for(Node n: neighbors){
				int position=n.getPosition();
				
				if ( position- nodeCell == 1) {
					mazeString[cellPosition+ 1]=" ";
					
				} else if (position- nodeCell > 1) {
					mazeString[cellPosition+lengthOfSide]="  ";
				}
			}
			
			cellPosition+=2;
			if(mazeString[cellPosition].equals("+")){
				cellPosition+=lengthOfSide+1;
			}
		}
		
		for (int i = 0; i < mazeString.length; i++) {

			if (i % lengthOfSide == 0 && i != 0) {
				System.out.println();
				System.out.print(mazeString[i]);
			} else {
				System.out.print(mazeString[i]);
			}
		}
		System.out.println();
	}
	
	
	/**
	 * 
	 * @param seed
	 */
	public void setSeed(long seed) {
		randomGenerator.setSeed(seed);
	}
	
	/**
	 * Function to initialize array of vertices
	 * Used in the constructor
	 */
	private void initializeVertices() {
		vertices = new Node[height * width];
		for(int index = 0;index < vertices.length;index++) {
			vertices[index] = new Node();
			vertices[index].setPosition(index);
		}
	}
	
	public void printMazeGraph(){
		for (int i = 0; i < mazeGraph.length; i++) {
			System.out.print(i);
			Node head= mazeGraph[i].head;
			while(head!=null){
				System.out.print("-->"+head.getPosition());
				head=head.next;
			}
			System.out.println();
		}
			
	}
	
	private String[] mazeString;
	private int lengthOfSide;
	private LinkedList[] mazeGraph;
	public Node[] vertices;
	private Random randomGenerator;
	private int height;
	private int width;
}
