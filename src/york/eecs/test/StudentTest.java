package york.eecs.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import york.eecs.source.UndirectedGraph;
import york.eecs.source.UndirectedGraphAlgorithms;
import york.eecs.source.VertexExistsException;

public class StudentTest {

	 /**
	  * TODO: Please write at least 5 test cases for testing @UndirectedGraph.
	  * TODO: Please write at least 5 test cases for testing @UndirectedGraphAlgorithms.
	  */
	//Test 1 for UndirectedGraph
	@Test 
	public void studentTest1GetAdjacent() {
		UndirectedGraph<String> ug = new UndirectedGraph<>();
		
		try {
			ug.addVertex("9m39");
			ug.addVertex("P09LK");
			ug.addVertex("1aAz?");
			ug.addVertex("blabla");
			ug.addEdge("P09LK", "1aAz?");
			ug.addEdge("9m39", "1aAz?");
			ug.addEdge("blabla", "9m39");
			ug.addEdge("blabla", "1aAz?");
		} catch (VertexExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> aAdjacent = (ArrayList<String>) ug.getAdjacent("blabla");
		aAdjacent.sort((s1, s2) -> s1.compareTo(s2));
		List<String> expectedAdjacent = new ArrayList<>();
		expectedAdjacent.add("1aAz?");
		expectedAdjacent.add("9m39");
		assertEquals(expectedAdjacent, aAdjacent);
	}
	
	//Test 2 for UndirectedGraph
	@Test
	public void studentTest2ToString() {
		UndirectedGraph<String> ug = new UndirectedGraph<>();;
		try {
			ug.addVertex("9m39");
			ug.addVertex("P09LK");
			ug.addVertex("1aAz?");
			ug.addVertex("blabla");
			ug.addEdge("P09LK", "1aAz?");
			ug.addEdge("9m39", "1aAz?");
			ug.addEdge("blabla", "9m39");
			ug.addEdge("blabla", "1aAz?");
			ug.addEdge("P09LK", "blabla");
		} catch (VertexExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String toSt = ug.toString();
		String expected = "Graph:\nVertex: 1aAz? & Adjacent Vertices: [9m39, P09LK, blabla]\nVertex: 9m39 & Adjacent Vertices: [1aAz?, blabla]\nVertex: P09LK & Adjacent Vertices: [1aAz?, blabla]\nVertex: blabla & Adjacent Vertices: [1aAz?, 9m39, P09LK]\n";
	    assertEquals(expected, toSt);
	}
	
	//Test 3 for UndirectedGraph
	@Test
	public void studentTest3ToString() {
		UndirectedGraph<Integer> ug = new UndirectedGraph<>();;
		try {
			ug.addVertex(2);
			ug.addVertex(5);
			ug.addVertex(1);
			ug.addEdge(5,2);
			ug.addEdge(1,2);
		} catch (VertexExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String toSt = ug.toString();
		String expected = "Graph:\nVertex: 1 & Adjacent Vertices: [2]\nVertex: 2 & Adjacent Vertices: [1, 5]\nVertex: 5 & Adjacent Vertices: [2]\n";
	    assertEquals(expected, toSt);
	}
	
	//Test 4 for UndirectedGraph
		@Test
		public void studentTest4GetAdjacent() {
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();;
			try {
				ug.addVertex(9);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Integer> aAdjacent = (ArrayList<Integer>) ug.getAdjacent(9);
			aAdjacent.sort((s1, s2) -> s1.compareTo(s2));
			List<Integer> expectedAdjacent = new ArrayList<>();
			assertEquals(expectedAdjacent, aAdjacent);
		}
		
		//Test 5 for UndirectedGraph
		@Test
		public void studentTest5GetAdjacent() {
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();;
			try {
				ug.addVertex(9);
				ug.addVertex(9);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Integer> expectedVertice = new ArrayList<>();
			expectedVertice.add(9);
			assertEquals(expectedVertice, ug.getVertices());
		}
	 
		//Test 6 for UndirectedGraph
		@Test
		public void studentTest6ToString() {
			UndirectedGraph<String> ug = new UndirectedGraph<>();;
			try {
				ug.addVertex("9z");
				ug.addVertex("hi");
				ug.addVertex("testing123");
				ug.addVertex("aaa");
				ug.addVertex("$$$s");
				ug.addEdge("$$$s","9z");
				ug.addEdge("hi","aaa");
				ug.addEdge("testing123","aaa");
				ug.addEdge("hi","$$$s");
				ug.addEdge("9z","aaa");
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String toSt = ug.toString();
			String expected = "Graph:\nVertex: $$$s & Adjacent Vertices: [9z, hi]\nVertex: 9z & Adjacent Vertices: [$$$s, aaa]\nVertex: aaa & Adjacent Vertices: [9z, hi, testing123]\nVertex: hi & Adjacent Vertices: [$$$s, aaa]\nVertex: testing123 & Adjacent Vertices: [aaa]\n";
		    assertEquals(expected, toSt);
		}
		
		//Test 7 for UndirectedGraph
		@Test
		public void studentTest7IsEmpty() {
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();;
			try {
				ug.addVertex(3);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Integer> expectedlist = new ArrayList<>();
			expectedlist.add(3);
			expectedlist.isEmpty();
			assertEquals(expectedlist.isEmpty(), ug.isEmpty());
		} 
		
		//Test 8 for UndirectedGraph
		@Test
		public void studentTest8GetSize() {
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();;
			try {
				ug.addVertex(3);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Integer> expectedlist = new ArrayList<>();
			expectedlist.add(3);
			assertEquals(expectedlist.size(), ug.getSize());
		} 
		
		//Test 9 for UndirectedGraph
		@Test
		public void studentTest9ToString() {
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();;
			try {
				ug.addVertex(3);
				ug.addVertex(1);
				ug.addVertex(9);
				ug.addEdge(9,3);
				ug.addEdge(9, 1);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String toSt = ug.toString();
			String expected = "Graph:\nVertex: 1 & Adjacent Vertices: [9]\nVertex: 3 & Adjacent Vertices: [9]\nVertex: 9 & Adjacent Vertices: [1, 3]\n";
		    assertEquals(expected, toSt);
		} 
		
		//Test 1 for UndirectedGraphAlgorithm
		@Test
		public void studentTestBFS1() {
			UndirectedGraphAlgorithms<String> uga = new UndirectedGraphAlgorithms<>();
			UndirectedGraph<String> ug = new UndirectedGraph<>();
			try {
				ug.addVertex("A");
				ug.addVertex("B");
				ug.addVertex("C");
				ug.addVertex("D");
				ug.addVertex("E");
				ug.addVertex("F");
				ug.addEdge("F","B");
				ug.addEdge("F","C");
				ug.addEdge("B","C");
				ug.addEdge("D","C");
				ug.addEdge("A","B");
				ug.addEdge("E","A");
				ug.addEdge("D","E");
				ug.addEdge("D","A");
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<String> result = (ArrayList<String>) uga.findBFSpath(ug, "F", "E");
			List<String> expected = new ArrayList<>();
			expected.add("F");
			expected.add("B");
			expected.add("A");
			expected.add("E");
			//Also accepted is F,C,D,E
			assertEquals(expected, result);
		}
		
		//Test 2 for UndirectedGraphAlgorithm
		@Test
		public void studentTestBFS2() {
			UndirectedGraphAlgorithms<Integer> uga = new UndirectedGraphAlgorithms<>();
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();
			try {
				ug.addVertex(1);
				ug.addVertex(2);
				ug.addVertex(3);
				ug.addVertex(4);
				ug.addVertex(5);
				ug.addEdge(1,2);
				ug.addEdge(2,5);
				ug.addEdge(1,5);
				ug.addEdge(4,1);
				ug.addEdge(4,3);
				ug.addEdge(3,2);
				ug.addEdge(5,3);
				ug.addEdge(4,5);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Integer> result = (ArrayList<Integer>) uga.findBFSpath(ug, 5, 4);
			List<Integer> expected = new ArrayList<>();
			expected.add(5);
			expected.add(4);
			assertEquals(expected, result);
		}
		
		//Test 3 for UndirectedGraphAlgorithm
		@Test
		public void studentTestBFS3() {
			UndirectedGraphAlgorithms<Integer> uga = new UndirectedGraphAlgorithms<>();
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();
			try {
				ug.addVertex(1);
				ug.addVertex(2);
				ug.addVertex(3);
				ug.addVertex(4);
				ug.addEdge(1,3);
				ug.addEdge(3,4);
				ug.addEdge(2,4);
				ug.addEdge(2,1);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Integer> result = (ArrayList<Integer>) uga.findBFSpath(ug, 1, 4);
			List<Integer> expected = new ArrayList<>();
			expected.add(1);
			expected.add(2);
			expected.add(4);
			//Also accepted is 1,2,4
			assertEquals(expected, result);
		}
		
		//Test 4 for UndirectedGraphAlgorithm
		@Test
		public void studentTestBFS4() {
			UndirectedGraphAlgorithms<Integer> uga = new UndirectedGraphAlgorithms<>();
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();
			try {
				ug.addVertex(1);
				ug.addVertex(2);
				ug.addVertex(3);
				ug.addVertex(4);
				ug.addVertex(5);
				ug.addVertex(6);
				ug.addVertex(7);
				ug.addEdge(1,2);
				ug.addEdge(2,3);
				ug.addEdge(4,3);
				ug.addEdge(2,4);
				ug.addEdge(4,5);
				ug.addEdge(7,5);
				ug.addEdge(6,5);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Integer> result = (ArrayList<Integer>) uga.findBFSpath(ug, 1, 7);
			List<Integer> expected = new ArrayList<>();
			expected.add(1);
			expected.add(2);
			expected.add(4);
			expected.add(5);
			expected.add(7);
			assertEquals(expected, result);
		}
		
		//Test 5 for UndirectedGraphAlgorithm 
		@Test
		public void studentTestBFS5() {
			UndirectedGraphAlgorithms<Integer> uga = new UndirectedGraphAlgorithms<>();
			UndirectedGraph<Integer> ug = new UndirectedGraph<>();
			try {
				ug.addVertex(1);
				ug.addVertex(2);
				ug.addVertex(3);
				ug.addVertex(4);
				ug.addVertex(5);
				ug.addEdge(1,2);
				ug.addEdge(2,3);
				ug.addEdge(5,3);
				ug.addEdge(1,5);
			} catch (VertexExistsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			List<Integer> result = (ArrayList<Integer>) uga.findBFSpath(ug, 4, 2);
			List<Integer> expected = new ArrayList<>();
			assertEquals(expected, result);
		}
		
		

}
