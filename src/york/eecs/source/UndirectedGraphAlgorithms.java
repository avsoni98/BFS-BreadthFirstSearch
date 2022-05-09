package york.eecs.source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class UndirectedGraphAlgorithms<T extends Comparable<T>> 
								implements GraphAlgorithms<T> {

	/**
	 * Please implement BFS algorithm as described on the handout
	 * @param g: a graph
	 * @param initial: the starting vertex of the path
	 * @param destination: the destination vertex of the path
	 * @return the path from initial to destination in the form of
	 *         an ArrayList of vertices, with initial as the first
	 *         element, and destination as the last element of the 
	 *         ArrayList
	 */
	public List<T> findBFSpath(Graph<T> g, T initial, T destination) {
		// TODO : implement BFS path search
		Queue<List<T>> open = new LinkedList<>();
	    List<T> path = new ArrayList<>();
	    List<T> q = new ArrayList<>();
	    List<T> current = new ArrayList<>(); //is n 

	    if (g.getVertices().contains(initial) && g.getVertices().contains(destination)) {
	     
		    current.add(initial);
			open.add(current);
			
			//while the q is NOT empty i.e. while false
			while(!open.isEmpty()) {
	
				current = open.remove();
				
					if (current.get(current.size()-1).equals(destination)) {
						path = current;
						break;
					}
					
					ArrayList<T> aAdjacent = (ArrayList<T>) g.getAdjacent(current.get(current.size()-1));
				
					for (int m = 0; m < aAdjacent.size(); m++) {
							
							if (!current.contains(aAdjacent.get(m))) {
								q = new ArrayList<>(current);
								q.add(aAdjacent.get(m));
								open.add(q);		
							}
	 
					}
	
				}
	    }
				
		return path; // this line must change 
	} 

}
