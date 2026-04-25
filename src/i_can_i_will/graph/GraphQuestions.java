package i_can_i_will.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphQuestions {

	 public static void main (String[] args)
	    {
	        // Input: List of edges in a digraph (as per the above diagram)
	        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
	                new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
	                new Edge(4, 5), new Edge(5, 4));
	 
	        // construct a graph from the given list of edges
	        Graph graph = new Graph(edges);
	 
	        // print adjacency list representation of the graph
	        graph.printGraph();
	     // List of graph edges as per the above diagram
	        List<Edge> dfsedges = Arrays.asList(
	                // Notice that node 0 is unconnected
	                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3),
	                new Edge(2, 6), new Edge(3, 4), new Edge(3, 5), new Edge(8, 9),
	                new Edge(8, 12), new Edge(9, 10), new Edge(9, 11)
	            );
	      
	       graph = new Graph(dfsedges);
	    // List of graph edges as per the above diagram
	       graph.printGraph();
	       System.out.println("Print dfs "+ dfsedges.size());
	       //to keep track whether vertex is discovered or not.
	       boolean [] discovered = new boolean[13];
	      
	       //perform dfs for all the un-discovred node.
	       System.out.println("print for 0");
	       GraphDFS.DFS(graph, 0, discovered);
	       System.out.println("print for 9");
	       GraphDFS.DFS(graph, 9, discovered);
	       //System.out.println("print for 1");
	     //  GraphDFS.DFS(graph, 1, discovered);
	       for(int i =0 ; i < dfsedges.size(); i++) {
	    	   if(!discovered[i]) {
	    		 //  GraphDFS.DFS(graph, i, discovered);
	    	   }
	       }
	       boolean [] discovered1 = new boolean[13];
	     //perform Iterative dfs for all the un-discovred node.
	       System.out.println("DFSIterative print for 0");
	       GraphDFS.DFSIterative(graph, 0, discovered1);
	       System.out.println("DFSIterative print for 9");
	       GraphDFS.DFSIterative(graph, 9, discovered1);
	      // System.out.println("DFSIterative print for 1");
	      // GraphDFS.DFSIterative(graph, 1, discovered1);
	       
	    // List of graph edges as per the above diagram
	        List<Edge> edges3 = Arrays.asList(
	                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5),
	                new Edge(2, 6), new Edge(5, 9), new Edge(5, 10), new Edge(4, 7),
	                new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
	                // vertex 0, 13, and 14 are single nodes
	        );
	 
	        // total number of nodes in the graph (labelled from 0 to 14)
	       int n = 15;
	 
	        // build a graph from the given edges
	         graph = new Graph(edges3,n);
	 
	        // to keep track of whether a vertex is discovered or not
	        boolean[] discovered2 = new boolean[n];
	 
	        // Perform BFS traversal from all undiscovered nodes to
	        // cover all connected components of a graph
	        System.out.println("\n GraphBFS.BFSIterative\n");
	        for (int i = 0; i < edges3.size(); i++)
	        {
	            if (discovered2[i] == false)
	            {
	                // start BFS traversal from vertex `i`
	                GraphBFS.BFSIterative(graph, i, discovered2);
	            }
	        }
	        
	        //Arrival and departure time of vertices in DFS
	        //https://www.techiedelight.com/arrival-departure-time-vertices-dfs/
	        edges = Arrays.asList(
	                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3), new Edge(2, 4),
	                new Edge(3, 1), new Edge(3, 5), new Edge(4, 5), new Edge(6, 7)
	        );
	         n = edges.size();
	        // build a graph from the given edges
	         graph = new Graph(edges);
	 
	        // array to store the arrival time of vertex
	        int[] arrival = new int[n];
	 
	        // array to store the departure time of vertex
	        int[] departure = new int[n];
	 
	        // mark all the vertices as not discovered
	         discovered = new boolean[n];
	        int time = -1;
	 
	        // Perform DFS traversal from all undiscovered nodes to
	        // cover all unconnected components of a graph
	        for (int i = 0; i < n; i++)
	        {
	            if (!discovered[i]) {
	                time = dfsArrivalDeparture(graph, i, discovered, arrival, departure, time);
	            }
	        }
	 
	        // print arrival and departure time of each vertex in DFS
	        for (int i = 0; i < n; i++)
	        {
	            System.out.println("Vertex  =" + i + " (arrival =" + arrival[i] + ", departure at=" +
	                departure[i] + ")");
	        }
	     // farthest ancestors
	        
	         edges = Arrays.asList(
	                new Edge(8, 4), new Edge(7, 8), new Edge(9, 8), new Edge(6, 5),
	                new Edge(5, 4), new Edge(6, 3), new Edge(3, 2), new Edge(3, 1), new Edge(2, 10)
	        );
	        
	        // build a graph from the given edges
	         graph = new Graph(edges);
	         discovered = new boolean[graph.adjList.size()+1];
	         discovered = new boolean[12];
	         AtomicInteger atomic  = new AtomicInteger(-1);
	         AtomicInteger max  = new AtomicInteger(0);
	         farthestAncestors(graph,3, discovered,1,max,atomic);
	         System.out.println("\n\nfarthestAncestors for 3 is "+atomic.get());
	         
	         
	    }
	 
	 public static int dfsArrivalDeparture(Graph graph , int v, 
			 boolean []discovered, int [] arrival , int []departure,int time) {
		 
		 arrival[v] = ++time;
		 discovered[v] = true;
		 for(int vertex : graph.adjList.get(v)) {
			if (!discovered[vertex]){
				time = dfsArrivalDeparture(graph,vertex,discovered, arrival,departure,time);
			 }
			
			 
		 }
		 departure[v] = ++time;
		 return time;
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
