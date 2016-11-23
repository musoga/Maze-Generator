package sjsu.cs146.project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Maze {
	/**
   Two parameter constructor that seeds the random number generator and intializes 
   the dimensions

   @param startHeight height of maze
   
   @param startWidth width of maze

   @return void

	*/
	Maze(int startHeight, int startWidth) {
		randomGenerator.setSeed(System.currentTimeMillis());
		height = startHeight;
		width = startWidth;
		
		//TODO - initialize position parameter 
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
		Stack<Node> cellStack = new Stack<Node>();
		int totalCells = height * width;
		
		int position = 0;
		LinkedList currentCell = mazeGraph[position];
		
		int visitedCells = 1;
		
		while(visitedCells < totalCells) {
			ArrayList<Node> neighbors = findNeighbors(currentCell, position);
			
			int randomNeighbor = randomGenerator.nextInt(neighbors.size());
			//TODO - finish implementing function
		}
	}
	
	/**
   Two parameter constructor that seeds the random number generator and intializes 
   the dimensions

   @param currentCell Cell to search for neighbors
   
   @return ArrayList<Node> List of neighbors to use for maze generation

	*/
	private ArrayList<Node> findNeighbors(LinkedList currentCell, int position) {
		ArrayList<Node> neighbors = new ArrayList<Node>();
		
		final int MAX_NEIGHBORS = 4;
		
		int[] neighborPosition = { position - width, 
											position - 1, 
											position + 1, 
											position + width };
		
		for(int index = 0;index < MAX_NEIGHBORS;index++) {
			Node cellToConsider = new Node();
			cellToConsider.setPosition(neighborPosition[index]);
			
			int initialValue = neighborPosition[index] < 1 
								|| neighborPosition[index] > height * width
								|| position % width == 0 && neighborPosition[index] - position == 1
								|| position % width == 1 && position - neighborPosition[index] == 1
								? -1 : neighborPosition[index];
			
			cellToConsider.setPosition(initialValue);
			
			if(cellToConsider.getPosition() != -1) {
				neighbors.add(cellToConsider);
			}
		}
		
		return neighbors;
	}
	
	public void searchMazeBFS() {
		// TODO - finish function
		;
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
