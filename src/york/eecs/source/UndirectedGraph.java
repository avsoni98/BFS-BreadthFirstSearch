package york.eecs.source;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class UndirectedGraph<T extends Comparable<T>> extends Graph<T> {

	private Map<T, Set<T>> graph;

	/**
	 *  This is the constructor.
	 *  Please do not change it.
	 */
	public UndirectedGraph() {
		this.graph = new HashMap<>();
	}
	
	/**
	 * @return true if graph is empty, false otherwise. 
	 */
	public boolean isEmpty() {
		// TODO: Complete this method
		// Hint: An empty graph contains zero vertices
		boolean result = true;
		if (graph.size() == 0) {
			return result;
		} 
		else {
			result = false;
		} // this line needs to be rewritten 
		return result;
	}
 
	/**
	 * @return the size (i.e. number of vertices) of this graph
	 */
	public int getSize() {
		// TODO: compute the size
		return graph.size(); // this line needs to be rewritten
	}
	
	/**
	 * Add a new vertex to the graph. A new vertex points
	 * to an empty set of adjacent vertices.
	 * 
	 * @param vertex: an object that is a new vertex in the graph
	 */
	public void addVertex(T vertex) throws VertexExistsException {
		// TODO: Complete this method  
		// Hints: If the vertex already exists, throw and exception
		//        Else, add a new pair to the graph hashmap:
		//        the vertex is the key, the value is an empty
		//        set of vertices.
		if (!graph.containsKey(vertex)) {
			graph.put(vertex, new HashSet<>());
		}

	}
	 
	public List<T> getAdjacent(T vertex) {
		return new ArrayList<>(graph.get(vertex));
	}
	
	 
	@Override
	public List<T> getVertices() {
		return graph.keySet().stream()
                .collect(Collectors.toList());
	}
 
	/**
	 * @param fromVertex one of vertices of this edge
	 * @param toVertex the other vertex of this edge
	 */
	public void addEdge(T fromVertex, T toVertex) {
        // TODO: Complete this method
        // Hint: Recall, both vertices already exist. Also,
        //       our graphs are not oriented, hence both edges
        //       need to be added.
        if(!fromVertex.equals(toVertex)) {

            if (graph.containsKey(fromVertex) && graph.containsKey(toVertex)) {

                Set<T> set1 = graph.get(fromVertex);
                set1.add(toVertex);

                Set<T> set2 = graph.get(toVertex);
                set2.add(fromVertex);
            }
        }

    }
 
	@Override
	public String toString() {
		// TODO: Override toString() method
		//ordering??
	
		List<T> list = new ArrayList<>();

		//add keys to list
		for (Entry<T, Set<T>> keyT : graph.entrySet()) { 
			
			list.add(keyT.getKey());
		}
		list.sort((T, T1) -> T.compareTo(T1)); //sort the keys

		//grab keys from list in sorted order then use that key to get the value
		//grab adjacency list for each vertex, sort, then display
		String result = "Graph:\n";
		for (int i = 0; i < graph.size(); i++) {
			
			ArrayList<T> aAdjacent = (ArrayList<T>) getAdjacent(list.get(i));
			aAdjacent.sort((s1, s2) -> s1.compareTo(s2));

			result += "Vertex: " + list.get(i) + " & Adjacent Vertices: " + aAdjacent + "\n"; 
		}
		return result;
	}
	


}
