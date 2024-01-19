package designguru.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

	
	public static void main(String [] args) {
		// Input: List of edges in a digraph (as per the above diagram)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));
 
        // construct a graph from the given list of edges
        Graph graph = new Graph(edges);
 
        // print adjacency list representation of the graph
        printGraph(graph);
        
        
        // print bfs for a graph
        
        // List of graph edges as per the above diagram
        edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5),
                new Edge(2, 6), new Edge(5, 9), new Edge(5, 10), new Edge(4, 7),
                new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
                // vertex 0, 13, and 14 are single nodes
        );
 
        // total number of nodes in the graph (labelled from 0 to 14)
        int n = 15;
 
        // build a graph from the given edges
         graph = new Graph(edges);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
     // Perform BFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
        for (int i = 0; i < n; i++)
        {
            if (discovered[i] == false)
            {
                // start BFS traversal from vertex `i`
                bfs(graph, i, discovered);
            }
        }
        
        bfs(graph, 2, discovered);
	}
	
	// Function to print adjacency list representation of a graph
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();
 
        while (src < n)
        {
            // print current vertex and all its neighboring vertices
            for (int dest: graph.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }
    
   public static void bfs(Graph g , int v , boolean [] discovered) {
	   
	// create a queue for doing BFS
       Queue<Integer> q = new ArrayDeque<>();
       q.add(v);
	   discovered[v] = true;
	   while(!q.isEmpty()) {
		   
		   v = q.poll();
		   System.out.print(v +" ");
		   for(int u : g.adjList.get(v)) {
			   if(!discovered[u]) {
				   discovered[u] = true;
				   q.add(u);
			   }
		   }
	   }
	   
   }
}
