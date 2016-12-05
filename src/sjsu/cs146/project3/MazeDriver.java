package sjsu.cs146.project3;

public class MazeDriver {

	public static void main(String[] args) {
		int height = 8;
		int width = 8;

		
			Maze maze1 = new Maze(height, width);
			Maze maze2 = new Maze(height, width);
			
			System.out.println("Breadth First Search");
			maze1.generateMaze();
			System.out.println();
			
			maze1.printMaze();
			System.out.println();
			
			maze1.searchMazeBFS();
			maze1.printMazeDiscoveryTime();
			System.out.println();
			maze1.printMazeShortestPath();
			
			System.out.println("Deapth First Search");
			maze2.generateMaze();
			System.out.println();
			
			maze2.printMaze();
			System.out.println();
			
			maze2.searchMazeDFS();
			maze2.printMazeDiscoveryTime();
			System.out.println();
			maze2.printMazeShortestPath();

	}

}
