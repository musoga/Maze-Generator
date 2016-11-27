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
				Node randomNeighbor = new Node();
				randomNeighbor.setPosition(randomNeighborPosition);
				
				mazeGraph[currentCell].add(randomNeighbor);
				
				cellStack.push(currentCell);
				currentCell = randomNeighborPosition;
				visitedCells++;
			}
			else {
				currentCell = cellStack.pop();
			}
		}
	}
	
	/**
   Two parameter constructor that seeds the random number generator and intializes 
   the dimensions

   @param currentCell Cell to search for neighbors
   
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
			cellToConsider.setPosition(neighborPosition[index]);
			
			int initialValue = neighborPosition[index] < 0 
								|| neighborPosition[index] >= height * width
								|| (position + 1) % width == 0 && neighborPosition[index] - position == 1
								|| (position + 1) % width == 1 && position - neighborPosition[index] == 1
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
