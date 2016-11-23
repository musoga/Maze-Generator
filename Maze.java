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
		
		LinkedList currentCell = mazeGraph[0];
		
		int visitedCells = 1;
		
		while(visitedCells < totalCells) {
			ArrayList<Node> neighbors = findNeighbors(currentCell);
			//TODO - finish implementing function
		}
	}
	
	/**
   Two parameter constructor that seeds the random number generator and intializes 
   the dimensions

   @param currentCell Cell to search for neighbors
   
   @return ArrayList<Node> List of neighbors to use for maze generation

	*/
	private ArrayList<Node> findNeighbors(LinkedList currentCell) {
		ArrayList<Node> neighbors = new ArrayList<Node>();
		Node current = currentCell.head;
		
		int maxNeighbors = 4;
		
		int[] neighborPosition = { current.getPosition() - width, 
											current.getPosition() - 1, 
											current.getPosition() + 1, 
											current.getPosition() + width };
		
		for(int index = 0;index < maxNeighbors;index++) {
			Node cellToConsider = new Node();
			cellToConsider.setPosition(neighborPosition[index]);
			
			int initialValue = neighborPosition[index] < 0 
								|| neighborPosition[index] > height * width
								|| current.getPosition() % width == 0 && neighborPosition[index] - current.getPosition() == 1
								|| current.getPosition() % width + 1 == 0 && neighborPosition[index] - current.getPosition() == 1
								? -1 : 0;
			
			cellToConsider.setValue(initialValue);
			
			if(cellToConsider.getValue() == 0) {
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
