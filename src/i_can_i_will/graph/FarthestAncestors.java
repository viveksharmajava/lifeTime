package i_can_i_will.graph;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FarthestAncestors {

	public static void main(String[] args) {
		 List<Edge>  edges = Arrays.asList(
	                new Edge(8, 4), new Edge(7, 8), new Edge(9, 8), new Edge(6, 5),
	                new Edge(5, 4), new Edge(6, 3), new Edge(3, 2), new Edge(3, 1), new Edge(2, 10)
	        );
	        
	        // build a graph from the given edges
	        Graph graph = new Graph(edges);
	        boolean [] discovered = new boolean[12];
	        AtomicInteger atomic  = new AtomicInteger(-1);
	        AtomicInteger max  = new AtomicInteger(0);
	        farthestAncestors(graph,6, discovered,0,max,atomic);
	        System.out.println("\n\nfarthestAncestors for 6 is "+atomic.get());
	}
	 public static void farthestAncestors(Graph graph , int v , boolean discovered[] ,int count,AtomicInteger max,
			 AtomicInteger ancestor) {
	         discovered[v] = true;
	        	if(graph.adjList.get(v).size() == 0)//ancestor node which does not has parent..
	        	{
	        		if(count > max.get()) {
	        			max.set(count);
	        			ancestor.set(v);
	        		}
	        		return;
	        	}	
	        	for(int vert: graph.adjList.get(v)) {
	        		if(discovered[vert]) continue;
	        		farthestAncestors(graph, vert, discovered,count+1,max,ancestor);
	        	}
	  }
}
