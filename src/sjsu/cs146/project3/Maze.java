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
		randomGenerator = new Random();
		randomGenerator.setSeed(System.currentTimeMillis());
		
		height = startHeight;
		width = startWidth;
		
		mazeGraph = new LinkedList[height * width];
		
		for(int index = 0;index < mazeGraph.length;index++) {
			mazeGraph[index] = new LinkedList();
		}
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
			ArrayList<Node> neighbors = findNeighbors(currentCell);
			
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
	Auxiliary function for the maze generation algorithm
	to find adjacent neighbors that haven't been visited

	@param position current cell to examine
   
	@return ArrayList<Node> List of neighbors to use for maze generation

	*/
	public ArrayList<Node> findNeighbors(int position) {
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
	
	public void searchMazeBFS() {
		PriorityQueue<Node> queue= new PriorityQueue<>();
		Node s= mazeGraph[0].head;
		s.setColor(Node.Colors.GREY);
		
		queue.add(s);
		while(!queue.isEmpty()){
			
		}
		
	}
	
	public void searchMazeDFS() {
		//TODO - finish function
		;
	}
	
	public void printMaze() {
		//TODO - finish function
		;
	}
	
	public void setSeed(long seed) {
		randomGenerator.setSeed(seed);
	}
	
	private LinkedList[] mazeGraph;
	private Random randomGenerator;
	private int height;
	private int width;
}
