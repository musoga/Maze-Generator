package sjsu.cs146.project3;

import static org.junit.Assert.*;

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
		//TODO - finish implementing test
		vertex.head.setPosition(1);
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
