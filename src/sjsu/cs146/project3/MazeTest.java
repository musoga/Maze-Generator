package sjsu.cs146.project3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
 
public class MazeTest {

/*	@Before
	public void setUp() throws Exception {
		int height = 5;
		int width = 5;
		Maze maze = new Maze(height, width);
	}*/
	@Ignore
	@Test
	public void testSetSeed() {
		long seed = 0;
		int height = 5;
		int width = 5;
		
		Maze maze1 = new Maze(height, width);
		maze1.setSeed(seed);
		maze1.generateMaze();
		
		Maze maze2 = new Maze(height, width);
		maze2.setSeed(seed);
		maze2.generateMaze();
		
		LinkedList[] adjacencyList1 = maze1.getMazeGraph();
		LinkedList[] adjacencyList2 = maze2.getMazeGraph();
		
		for(int index = 0;index < adjacencyList1.length;index++) {
			Node current1 = adjacencyList1[index].head;
			Node current2 = adjacencyList2[index].head;
			
			while(current1 != null && current2 != null) {
				assertEquals(current1.getPosition(), current2.getPosition());
				
				current1 = current1.next;
				current2 = current2.next;
			}
		}
	}
	
	@Test
	public void testGenerateMaze() {
		int height = 5;
		int width = 5;
		
		int startPosition = 0;
		
		for(int i = 0; i < 100;i++) {
			Maze maze = new Maze(height, width);
			maze.generateMaze();	
			
			assertTrue(checkAcyclic(maze, height * width, startPosition));
		}
	}
	
	/**
	 * Wrapper function for checkAcyclicRecursive()
	 * that initializes the array of colors for the modified depth first search
	 * 
	 * @param maze
	 * @param size
	 * @param position
	 * @return
	 */
	public boolean checkAcyclic(Maze maze, int size, int position) {
		Node.Colors[] visited = new Node.Colors[size];
		
		for(int index = 0;index < visited.length;index++) {
			visited[index] = Node.Colors.WHITE;
		}
		
		return checkAcyclicRecursive(maze, position, visited);
	}
	
	
	/**
	 * Recursive function to check if maze is acyclic
	 *
	 * @param maze
	 * @param position
	 * @param visited
	 * @return if maze is acyclic, true. else false
	 */
	public boolean checkAcyclicRecursive(Maze maze, int position, Node.Colors[] visited) {
		visited[position] = Node.Colors.GREY;
		
		for(Node neighbor : maze.findNeighbors(position)) {
			if(visited[neighbor.getPosition()] == Node.Colors.WHITE) {
				checkAcyclicRecursive(maze, neighbor.getPosition(), visited);
			}
			else if(visited[neighbor.getPosition()] == Node.Colors.GREY) {
				return false;
			}
		}
		
		visited[position] = Node.Colors.BLACK;
		return true;
	}
	@Ignore
	@Test
	public void testFindNeighborsGeneration() {
		int height = 5;
		int width = 5;
		Maze maze = new Maze(height, width);
		
		int[] positionsToTest = {0,2,4,10,14,20,22,24};
		int[][] neighborsToCheck = {{1,5},
				{1,3,7},
				{3,9},
				{5,11,15},
				{9,13,19},
				{15,21},
				{17,21,23},
				{19,23}};
		
		final int TEST_CASES = 8;
		
		for(int testCase = 0;testCase < TEST_CASES;testCase++) {
			ArrayList<Node> neighbors = maze.findNeighborsGeneration(positionsToTest[testCase]);
			
			for(int index = 0;index < neighbors.size();index++) {
				assertEquals(neighborsToCheck[testCase][index], neighbors.get(index).getPosition());
			}
		}
	}
	@Ignore
	@Test
	public void testFindNeighbors() {
		int height = 5;
		int width = 5;
		Maze maze = new Maze(height, width);
		
		int[] positionsToTest = {0,2,4,10,14,20,22,24};
		int[][] neighborsToCheck = {{1,5},
				{1,3,7},
				{3,9},
				{5,11,15},
				{9,13,19},
				{15,21},
				{17,21,23},
				{19,23}};
		
		final int TEST_CASES = 8;
		
		for(int testCase = 0;testCase < TEST_CASES;testCase++) {
			ArrayList<Node> neighbors = maze.findNeighbors(positionsToTest[testCase]);
			
			for(int index = 0;index < neighbors.size();index++) {
				assertEquals(neighborsToCheck[testCase][index], neighbors.get(index).getPosition());
			}
		}
	}
	
	@Test
	public void testPrinting() {
		int height = 4;
		int width = 4;
		
		Maze maze1 = new Maze(height, width);
		maze1.generateMaze();
		maze1.printMazeGraph();
		maze1.printMaze();
	}
	@Test
	public void testSearchMazeBFS() {
		;
	}
	
	@Test
	public void testSearchMazeDFS() {
		int height = 4;
		int width = 4;
		
		for(int testCount = 0;testCount < 100;testCount++) {
			Maze maze = new Maze(height, width);
			
			maze.generateMaze();
			
			maze.searchMazeDFS();
			
			Node cell = maze.vertices[height * width - 1];
			while(cell.getParent() >= 0) {
				cell = maze.vertices[cell.getParent()];
			}
			assertEquals(cell.getPosition(), 0);
		}
	}
	
	@Test
	public void testPrintMaze() {
		;
	}

}
