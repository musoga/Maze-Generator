package sjsu.cs146.project3;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class LinkedListTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testAdd() {
		LinkedList list = new LinkedList();
		
		int size = 1000000;
		
		int[] numbers = new int[size];
		Random randomGenerator = new Random();
		randomGenerator.setSeed(System.currentTimeMillis());
		
		for(int index = 0;index < size;index++) {
			numbers[index] = randomGenerator.nextInt(size);
		}
		
		
		for(int index = 0;index < numbers.length;index++) {
			Node nodeToAdd = new Node();
			nodeToAdd.setPosition(numbers[index]);
			list.add(nodeToAdd);
		}
		
		
		Node current = list.head;
		int reverseIndex = size - 1;
		
		while(current != null) {
			assertEquals(numbers[reverseIndex], current.getPosition());
			
			reverseIndex--;
			current = current.next;
		}
	}

}
