package sjsu.cs146.project3;

import java.util.Random;

public class Maze {
	Maze() {
		randomGenerator.setSeed(System.currentTimeMillis());
	}
	
	public LinkedList[] getMazeGraph() {
		return mazeGraph;
	}
	
	public void setMazeGraph(LinkedList[] newMaze) {
		mazeGraph = newMaze;
	}
	
	public void generateMaze() {
		//TODO - finish function;
		;
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
	
	private LinkedList[] mazeGraph;
	private Random randomGenerator;
}
