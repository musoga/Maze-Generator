package sjsu.cs146.project3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
 

public class MazeTest {

	@Before
	public void setUp() throws Exception {
		int height = 5;
		int width = 5;
		Maze maze = new Maze(height, width);
	}
	
	@Test
	public void testSetSeed() {
		long seed = 0;
		int height = 5;
		int width = 5;
		
		Maze maze1 = new Maze(5, 5);
		maze1.setSeed(seed);
		maze1.generateMaze();
		
		Maze maze2 = new Maze(5, 5);
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
		;
	}
	
	@Test
	public void testFindNeighbors() {
		LinkedList vertex = new LinkedList();
		
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
			ArrayList<Node> neighbors = maze.findNeighbors(vertex, positionsToTest[testCase]);
			
			for(int index = 0;index < neighbors.size();index++) {
				assertEquals(neighborsToCheck[testCase][index], neighbors.get(index).getPosition());
			}
		}
	}
	
	@Test
	public void testSearchMazeBFS() {
		;
	}
	
	@Test
	public void testSearchMazeDFS() {
		;
	}
	
	@Test
	public void testPrintMaze() {
		;
	}

}
